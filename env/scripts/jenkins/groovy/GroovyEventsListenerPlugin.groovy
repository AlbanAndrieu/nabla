import groovy.json.*

import hudson.model.Job
import org.jenkinsci.plugins.workflow.job.WorkflowRun
import org.jenkinsci.plugins.workflow.flow.FlowExecution;
import org.jenkinsci.plugins.workflow.graph.FlowGraphWalker;
import org.jenkinsci.plugins.workflow.graph.FlowNode;
import org.jenkinsci.plugins.workflow.graph.StepStartNode;
import org.jenkinsci.plugins.workflow.cps.nodes.StepStartNode;
import org.jenkinsci.plugins.workflow.actions.WorkspaceAction

//import java.util.Base64 // requires java8
//auth = "Basic " + Base64.getEncoder().encodeToString("elastic:changeme".getBytes()) // if no java8, compute basicAuth externally and hardcode it here
auth = null

esUrl = 'http://bm-es:9200'
jenkinsIndex = 'jenkins-'+ new Date().format('yyyyMM')
timeout = 5 //seconds

log.info("Fired event '${event}'.")

now = System.currentTimeMillis() // ms since epoch

if (event == Event.JOB_FINALIZED) {
    if (run.getParent() instanceof hudson.maven.MavenModule) {
        return
    }
    def doc = [
        '@timestamp'        : now,
        'buildScheduleTime' : run.getTimeInMillis(),                           // ms since epoch
        'buildStartTime'    : run.getStartTimeInMillis(),                      // ms since epoch
        'buildDuration'     : run.getDuration(),                               // ms
        'buildTimeInQueue'  : run.getStartTimeInMillis()-run.getTimeInMillis(),// ms
        'jobName'           : env.JOB_NAME,
        'buildResult'       : run.getResult().toString(),
        'jenkinsMaster'     : getJenkinsMasterName(),
        'buildId'           : env.BUILD_NUMBER,                                //run.getNumber()
        'buildUrl'          : env.BUILD_URL,                                   // run.getUrl() (relative url)
        'buildNode'         : getBuildNodes(),
        'jobType'           : run.getParent().class.toString().minus(~/.*\.|class /)
    ]

    if (env.containsKey('GIT_URL')) {
        doc += [
            gitUrl: env.GIT_URL,
            gitBranch: env.GIT_BRANCH,
            gitCommit: env.GIT_COMMIT
          ]
    } else if (env.containsKey('SVN_URL')) {
        doc += [
            svnUrl: env.SVN_URL,
            svnRevision: env.SVN_REVISION
          ]
    }
  insertElasticDoc("buildResult", doc, auth)
}
else if (event == Event.PLUGIN_SCHEDULE) {
    def docs = []

    for (job in jenkins.items) {
        if (job instanceof hudson.model.Job && job.isBuilding()) {
            nbBuilds = 0
            for (build in job.getBuilds()) {
                if (build.isInProgress()) {
                    nbBuilds +=1
                }
            }
            docs.add([
                'activeBuilds' : [
                    '@timestamp'   : now,
                    'jenkinsMaster': getJenkinsMasterName(),
                    'jobName'      : job.name,
                    'activeBuilds' : nbBuilds
                ]
            ])
        }
    }

    // Not using findAll/collect, as this can fail on old Jenkins
    //
    // def docs = jenkins.items
    //    .findAll{ job -> job instanceof hudson.model.Job && job.isBuilding() }
    //    .collect {[
    //         'activeBuilds' : [
    //             '@timestamp'   : now,
    //             'jenkinsMaster': env.JENKINS_URL,
    //             'jobName'      : it.name,
    //             'activeBuilds' : it.getBuilds().findAll{it.isInProgress()}.size()
    //         ]
    //    ]}

    docs.add([
        'queueLength' : [
            '@timestamp'   : now,
            'jenkinsMaster': getJenkinsMasterName(),
            'queueLength'  : jenkins.queue.items.length
        ]
    ])

    insertElasticDocs(docs, auth)
}


def getJenkinsMasterName() {
    return jenkins.getRootUrl().minus(~/.*\/\//).minus(~/[\.:].*/) // or env.JENKINS_URL, but not declared in schedule events
}

def getBuildNodes() {
    if(run instanceof WorkflowRun) {
        nodeList = []
        exec = run.getExecution();
        if(exec != null) {
            for (FlowNode n : new FlowGraphWalker(exec)) {
                if (n instanceof StepStartNode) {
                    node = null
                    action = n.getAction(WorkspaceAction);
                    if(action) {
                        node = action.getNode().toString();
                    }
                    if (node) {
                        nodeList += node
                    }
                }
            }
        }
        return nodeList.unique()
    } else {
        // run.getExecutor().getOwner().getName() ?: run.getExecutor().getOwner().getHostName() // name or IP if no name
        return env.NODE_NAME
    }
}

def sendElasticRequest(apiCmd, text, contentType, auth=null, timeout=5) {
    def conn = new URL("${esUrl}/${jenkinsIndex}/${apiCmd}").openConnection()
    if (auth) {
        conn.setRequestProperty ("Authorization", auth)
    }
    conn.setConnectTimeout(1000*timeout)
    conn.setReadTimeout(1000*timeout)
    conn.setRequestMethod("POST")
    conn.setDoOutput(true)
    conn.setRequestProperty("Content-Type", contentType)
    conn.getOutputStream().write(text.getBytes("UTF-8"))
    def postRC = conn.getResponseCode()
    if (postRC<200 || postRC>299) {
        println "[WARN][ELASTIC] Request {$apiCmd}"
        println text.replaceAll("(?m)^", "[WARN][ELASTIC]     ").trim()
        println "[WARN][ELASTIC] returned ${postRC} : " + conn.getInputStream().getText()
    }
}

def insertElasticDoc(type, doc, auth=null, timeout=5) {
    sendElasticRequest("${type}", JsonOutput.toJson(doc), "application/json", auth, timeout)
}

// docDatas is a list of [docType: doc]
def insertElasticDocs(docDatas, auth=null, timeout=5) {
    if (docDatas) {
        def text = ""
        docDatas.each{ docData -> docData.each{ docType, doc -> text += JsonOutput.toJson(["index": ["_type": docType]])+"\n"+JsonOutput.toJson(doc)+"\n" } }
        sendElasticRequest("_bulk", text, "application/x-ndjson", auth, timeout)
    }
}

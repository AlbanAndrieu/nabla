import groovy.json.*
import hudson.model.Hudson.*
import jenkins.model.*
import java.lang.management.RuntimeMXBean
import java.lang.management.ManagementFactory
import hudson.model.*
//import jenkins.metrics.impl.TimeInQueueAction

//@Grab('org.jenkins-ci.plugins.workflow:workflow-job:2.37')
import org.jenkinsci.plugins.workflow.job.WorkflowRun
import org.jenkinsci.plugins.workflow.flow.FlowExecution;
import org.jenkinsci.plugins.workflow.graph.FlowGraphWalker;
import org.jenkinsci.plugins.workflow.graph.FlowNode;
//import org.jenkinsci.plugins.workflow.graph.StepStartNode;
import org.jenkinsci.plugins.workflow.cps.nodes.StepStartNode;
import org.jenkinsci.plugins.workflow.actions.WorkspaceAction

//import java.util.Base64 // requires java8
//auth = "Basic " + Base64.getEncoder().encodeToString("elastic:changeme".getBytes()) // if no java8, compute basicAuth externally and hardcode it here
auth = null
nexusUrl = 'http://localhost/jenkins-events-listener/regex.json'
esUrl = 'http://monitoring_elasticsearch:9200'
jenkinsIndex = 'new.jenkins-'+ new Date().format('yyyyMM')
timeout = 5 //seconds

now = System.currentTimeMillis() // ms since epoch
instance = Jenkins.instance

if (event == Event.JOB_FINALIZED) {
    if (run.getParent() instanceof hudson.maven.MavenModule) {
        return
    }
    def nodeStatistics = nodeStatistics()
    def getJVMMemoryUsage = getJVMMemoryUsage()
    def doc = [
        '@timestamp'        : now,
        'buildScheduleTime' : run.getTimeInMillis(),                           // ms since epoch
        'buildStartTime'    : run.getStartTimeInMillis(),                      // ms since epoch
        'buildDuration'     : run.getDuration(),                               // ms
        'buildTimeInQueue'  : run.getStartTimeInMillis()-run.getTimeInMillis(),// ms
        'jobName'           : env.JOB_NAME,
        'buildResult'       : run.getResult().toString(),
        'buildResultValue'  : mapResultToValue()[run.getResult().toString()],
        'jenkinsMaster'     : getJenkinsMasterName(),
        'jenkinsMasterUrl'  : jenkins.getRootUrl(),
        'buildId'           : env.BUILD_NUMBER,                                //run.getNumber()
        'buildUrl'          : env.BUILD_URL,                                   // run.getUrl() (relative url)
        'buildNode'         : getBuildNodes(),
        'jobType'           : run.getParent().class.toString().minus(~/.*\.|class /),
        'queueNumber'       : jenkins.queue.items.length,
        'nodesNumber'       : nodeStatistics['nodesNumber'],
        'numberNodesOffline': nodeStatistics['numberNodesOffline'],
        'numberNodesOnline' : nodeStatistics['numberNodesOnline'],
      	'busyExecutors'		: nodeStatistics['busyExecutors'],
      	'idleExecutors'		: nodeStatistics['idleExecutors'],
        'totalExecutors'    : nodeStatistics['totalExecutors'],
        'runnigJobNumber'   : numberOfRunnigJobs(),
      	'jvmTotalMemory'	: getJVMMemoryUsage['totalMemory'],
      	'jvmMaxMemory'		: getJVMMemoryUsage['maxMemory'],
      	'jvmFreeMemory'		: getJVMMemoryUsage['freeMemory'],
    ]
//Junit Results
   if (run.getActions(hudson.tasks.junit.TestResultAction.class)) {
        def junit = run.getAction(hudson.tasks.junit.TestResultAction.class)
        doc += junitCount(junit)
    }
    if (run.getActions(hudson.tasks.test.AggregatedTestResultPublisher.TestResultAction.class)) {
        def junit = run.getAction(hudson.tasks.test.AggregatedTestResultPublisher.TestResultAction.class)
        doc += junitCount(junit)
    }

    if (run.getActions(hudson.maven.reporters.SurefireAggregatedReport)){
        def junit = run.getAction(hudson.maven.reporters.SurefireAggregatedReport.class)
        doc += junitCount(junit)
    }

//Robot Framework Results
    if (run.getAction(hudson.plugins.robot.RobotBuildAction.class)) {
        def robotClass = run.getAction(hudson.plugins.robot.RobotBuildAction.class)
        def robotResults = robotClass.result
        doc += [
            'robotOverallTotal': robotResults.overallTotal,
            'robotOverallPassed': robotResults.overallPassed,
            'robotOverallFailed': robotResults.overallFailed,
            'robotPassPercentage': robotClass.overallPassPercentage,
            'robotCriticalTotal': robotResults.criticalTotal,
            'robotCriticalPassed': robotResults.criticalPassed,
            'robotCriticalFailed': robotResults.criticalFailed ,
            'robotCriticalPassPercentage': robotClass.criticalPassPercentage,
        ]
    }

    def getChangeSets = run.getChangeSets()

    //if (getChangeSets) {
    //    def authorEmail = []
    //    def changeSet = getChangeSets
    //    for (int i; i < changeSet.size(); i++) {
    //        def changeLogSet = changeSet[i]
    //        if (changeLogSet instanceof org.jenkinsci.plugins.multiplescms.MultiSCMChangeLogSet) {
    //            for (int x; x < changeLogSet.getItems().size(); x++){
    //                //for older version of git plugin
    //                //authorEmail.add(changeLogSet.getItems()[x].getAuthor().toString().toLowerCase() + '@finastra.com')
    //                authorEmail.add(changeLogSet.getItems()[x].getAuthorEmail().toLowerCase())
    //            }
    //        }
    //        else {
    //            for (int j; j < changeLogSet.getLogs().size(); j++) {
    //                //for older version of git plugin
    //                //authorEmail.add(changeLogSet.getLogs()[j].getAuthor().toString().toLowerCase() + '@finastra.com')
    //                authorEmail.add(changeLogSet.getLogs()[j].getAuthorEmail().toLowerCase())
    //            }
    //        }
    //    }
    //    doc += [
    //        'gitAuthorEmail': authorEmail.unique(),
    //        'gitAuthorEmailString': authorEmail.unique().join(', '),
    //    ]
    //}

    if (env.containsKey('GIT_URL')) {
        doc += [
            'gitUrl': env.GIT_URL,
            'gitBranch': env.GIT_BRANCH,
            'gitCommit': env.GIT_COMMIT,
          ]
        if(env.GIT_AUTHOR_EMAIL) {
            doc += [
                'gitAuthorEmailString': env.GIT_AUTHOR_EMAIL.toString(),
            ]
        }
    }

    if (run.getResult().toString() != 'SUCCESS') {
        def regex = ''
        try {
            regex = jsonParse(getDataFromURL(nexusUrl)).join('|')
        }
        catch (err) {
            println "[WARN][NEXUS] returned: ${err}"
            regex = ['java.nio.file.FileAlreadyExistsException:(.*)workspace',
                    'Cannot contact(.*): java.lang.InterruptedException',
                    'java.nio.file.FileSystemException:(.*)Input/output error',
                    'java.io.IOException: Failed to mkdirs:',
                    'process apparently never started in',
                    'Agent went offline',
                    'Process table full',
                    'JENKINS-(.*)if on an extremely laggy filesystem',
                    'Cannot open session, connection is not authenticated'].join('|')
        }
        def errorsFromLog = []
        def tailLog = run.getLog(1000)
        if (tailLog.size() > 0) {
            for (int x = 0; x < tailLog.size(); x++) {
                if (tailLog[x] =~ /(${regex})/) {
                    errorsFromLog.add(tailLog[x])
                }
            }
        }
        if (errorsFromLog.size() > 0) {
            doc += [
                errors: errorsFromLog.unique()
            ]
        }
    }

    else if (env.containsKey('SVN_URL')) {
        doc += [
            svnUrl: env.SVN_URL,
            svnRevision: env.SVN_REVISION
          ]
    }
  	// Number of data pushed to Elastic is to big
    if(conditionForPushing()) {
        queueStatistics()
    }
    insertElasticDoc("buildResult", doc, auth)
}
else if (event == Event.PLUGIN_SCHEDULE) {
    if(conditionForPushing()) {
        queueStatistics()
    }
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

def insertElasticDoc(type, doc, auth=nuFworll, timeout=5) {
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

def getDataFromURL(def url, def timeout=5) {
    def data = ''
    def conn = new URL(url).openConnection()
    conn.setConnectTimeout(1000*timeout)
    conn.setReadTimeout(1000*timeout)
    conn.setRequestMethod("GET")
    def connRC = conn.getResponseCode()
    if(connRC.equals(200)) {
        data = conn.getInputStream().getText()
    }
    return data
}

def jsonParse(def json) {
    return new groovy.json.JsonSlurperClassic().parseText(json)
}

def nodeStatistics() {
    final jenkins = instance
    def nodeStatistics = [:]
    int nodesNumber = 0
    int numberNodesOnline = 0
    int numberNodesOffline = 0
    for (def computer in jenkins.computers) {
        if (computer.isOffline()) {
            numberNodesOffline++
        }
        else {
            numberNodesOnline++
        }
        nodesNumber++
    }
    def getInstance = Jenkins.getInstance()
  	if (getInstance != null) {
        nodeStatistics['totalExecutors'] = getInstance.getComputer().getTotalExecutors()
        nodeStatistics['nodesNumber'] = nodesNumber
        nodeStatistics['numberNodesOffline'] = numberNodesOffline
        nodeStatistics['numberNodesOnline'] = numberNodesOnline
        nodeStatistics['busyExecutors'] = getInstance.getComputer().getBusyExecutors()
        nodeStatistics['idleExecutors'] = getInstance.getComputer().getIdleExecutors()
    }
    return nodeStatistics
}

def queueStatistics() {
  	def queue = jenkins.model.Jenkins.getInstance().getQueue().getItems()
  	def jobQueueUrl = []
  	queue.each{
      	jobQueueUrl.add(it.task.getUrl())
        def docs = [
          		'@timestamp'        : now,
                'buildResult'       : 'inQueue',
                'jenkinsMaster'     : getJenkinsMasterName(),
                'inQueue' 		    : (now - it.getInQueueSince()),
                'jobQueueUrl' 	    : it.task.getUrl(),
                'jenkinsMasterUrl'  : jenkins.getRootUrl(),
        ]
     	if (docs.size() > 0) {
  			insertElasticDoc('buildResult', docs, auth, 5)
  		}
    }
    runningJobs(jobQueueUrl)
}

def runningJobs(def jobUrl) {
  def buildingJobs = instance.getAllItems(hudson.model.Job.class).findAll { hudson.model.Job job -> job.isBuilding() }
  buildingJobs.each { hudson.model.Job job  ->
    job.builds.findAll { hudson.model.Run run ->
      if (run.isBuilding() &&  (!jobUrl.contains(run.getUrl()))) {
         def docs = [
            '@timestamp'    	: now,
            'jenkinsMaster' 	: getJenkinsMasterName(),
            'jobDuration'    	: (now - run.getStartTimeInMillis()),
            'buildStatus'		: 'IN_PROGRESS',
            'jobBuildingUrl'    : run.getUrl(),
            'jenkinsMasterUrl'  : jenkins.getRootUrl(),
            ]
        if (docs.size() > 0) {
  			insertElasticDoc('buildResult', docs, auth, 5)
  		}
      }
    }
  }
}

def getJVMMemoryUsage() {
  	def jvmMemoryUsage = [:]
	Runtime runtime = Runtime.getRuntime()
  	jvmMemoryUsage['freeMemory'] 	= runtime.freeMemory()
  	jvmMemoryUsage['totalMemory'] 	= runtime.totalMemory()
  	jvmMemoryUsage['maxMemory'] 	= runtime.maxMemory()

  return jvmMemoryUsage
}

def numberOfRunnigJobs() {
    int countOngoingBuilds = (instance.getAllItems(hudson.model.Job.class).findAll { it.isBuilding()}).size()
    if (countOngoingBuilds > 0) {
        return countOngoingBuilds
    }
    return 0
}
                            // 3 minutes
def conditionForPushing(def delay=180000) {
    context.timeStamp = context.timeStamp ?: 0
    if ((now - context.timeStamp) > delay) {
        context.timeStamp = now
        return true
    }
    return false
}

def mapResultToValue() {
    def resultToValue = [:]
    resultToValue['SUCCESS'] = 10
    resultToValue['UNSTABLE'] = 20
    resultToValue['ABORTED'] = 30
    resultToValue['NOT_BUILT'] = 40
    resultToValue['FAILURE'] = 50

    return resultToValue
}

def junitCount(def junit) {
    float junitFailCount = junit.getFailCount() ?: 0
    float junitTotalCount = junit.getTotalCount() ?: 0
    float junitSkipCount = junit.getSkipCount() ?: 0
    float junitPassCount = (junitTotalCount - junitSkipCount - junitFailCount)
    float junitFailPercent = (junitFailCount / junitTotalCount)
    float junitSkipPercent = (junitSkipCount / junitTotalCount)
    float junitPassPercent = (junitPassCount / junitTotalCount)

    def docs = [
        'junitFailCount': junitFailCount,
        'junitTotalCount': junitTotalCount,
        'junitSkipCount': junitSkipCount,
        'junitPassCount': junitPassCount,
        'junitFailPercent': junitFailPercent,
        'junitSkipPercent': junitSkipPercent,
        'junitPassPercent': junitPassPercent
    ]

    return docs
}

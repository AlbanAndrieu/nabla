import hudson.*
import jenkins.*
import jenkins.model.Jenkins

import org.jenkinsci.plugins.stashNotifier.StashNotifier

import net.sf.json.*

def credentialId = "{{ jenkins_remote_stash_name }}"
def sonarNotifierDesc = Jenkins.getInstance().getDescriptor(StashNotifier.class)
def data = [
        'stashRootUrl': "{{ jenkins_remote_stash_name }}",
        'ignoreUnverifiedSsl': true,
        'includeBuildNumberInKey': false,
        'credentialsId': credentialId,
        //'projectKey': '',
        'prependParentProjectKey': false,
        'disableInprogressNotification': false
    ]

sonarNotifierDesc.configure(null, JSONObject.fromObject(data))

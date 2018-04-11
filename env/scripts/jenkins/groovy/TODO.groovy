// More or less safe, command is fully reversible
import hudson.plugins.git.*
import jenkins.*
import jenkins.model.*

for (job in Jenkins.instance.items) {
  if (job instanceof hudson.maven.MavenModuleSet){
    def scm = job.scm
    if (scm instanceof GitSCM) {
      println(job.name)
      println("Old SCM tool: " + scm.gitTool)
      // Also can check if (scm.gitTool == null)
      if (scm.gitTool == "git-1.7.4.1") {
        scm.gitTool = "git-system"
      }
      println("New SCM tool: " + scm.gitTool)
    }
  }
}

// This is big global change on Jenkins
// Full changelog attached to confluence page (https_to_ssh_changelog.txt)
import hudson.plugins.git.*
import jenkins.*
import jenkins.model.*

def sshCredentialsId = "jenkins-ssh"
def replacement = [
  "https://scm-git-eur.misys.global.ad/scm",
  "ssh://scm-git-eur.misys.global.ad:7999"
]

for (job in Jenkins.instance.items) {
  if (job instanceof hudson.maven.MavenModuleSet) {
    println("Job name is: " + job.name)
    def scm = job.scm
    if (scm instanceof GitSCM) {
      for (remoteConfig in scm.userRemoteConfigs) {

        if (remoteConfig.url.contains(replacement[0])) {
          def replacedUrl = remoteConfig.url.replaceAll(replacement[0], replacement[1])
          println("Old SCM URL: " + remoteConfig.url)
          remoteConfig.url = replacedUrl
          println("New SCM URL: " + remoteConfig.url)
        }

        if (remoteConfig.url.contains(replacement[1])) {
          println("Old SCM credentials: " + remoteConfig.credentialsId)
          remoteConfig.credentialsId = sshCredentialsId
          println("New SCM credentials: " + remoteConfig.credentialsId)
        }
      }
    }
  }
}

// Get Jenkins job by its name (test below scripts on single Jenkins job, before running on the entire instance)

// check for object.class and object.class.getDeclaredFields()
// or consult http://javadoc.jenkins.io/ to have idea what can be done with each job / scm configuration

def jobName = "MAVEN"
def job = jenkins.model.Jenkins.instance.getItem(jobName)
scm = job.scm

for (remoteConfig in scm.userRemoteConfigs) {
  println(remoteConfig.class)

  hudson.util.DescribableList extensions = scm.extensions
  for (extension in extensions) {
    println(extension.class)
    if (extension instanceof hudson.plugins.git.extensions.impl.LocalBranch) {
      println(extension.localBranch)
      // do something on local branch
    }
    if (extension instanceof hudson.plugins.git.extensions.impl.CloneOption) {
      println(extension.depth)
      println(extension.isShallow())
      // do something on clone depth
    }
    if (extension instanceof hudson.plugins.git.extensions.impl.CleanCheckout) {
      boolean cleanCheckoutEnabled = true
      // enable / disable?
    }
  }
}

// DELETE WORKSPACE

import jenkins.model.*

import hudson.plugins.ws_cleanup.PreBuildCleanup
import hudson.plugins.ws_cleanup.Pattern
import hudson.plugins.ws_cleanup.Pattern.PatternType
import java.util.List


assert(job instanceof hudson.model.BuildableItemWithBuildWrappers)

def wrappers = job.getBuildWrappersList()

// Remove old build wrapper
for (wrapper in wrappers) {
  if (wrapper instanceof hudson.plugins.ws_cleanup.PreBuildCleanup) {
    wrappers.remove(wrapper)
  }
}

// Add new build wrapper
// To allow finer control of what files are removed from workspace
//List<Pattern> patterns = [new Pattern("", hudson.plugins.ws_cleanup.Pattern.PatternType.EXCLUDE)]
List<Pattern> patterns  = null
boolean deleteDirs 		= false
String cleanupParameter = ""
String externalDelete   = ""
def ws_cleanupWrapper = new hudson.plugins.ws_cleanup.PreBuildCleanup(
  patterns, deleteDirs, cleanupParameter, externalDelete
)
wrappers.add(ws_cleanupWrapper)

// See attached full changelog: ws_cleanup_changelog.txt

import jenkins.model.*

import hudson.plugins.ws_cleanup.PreBuildCleanup
import hudson.plugins.ws_cleanup.Pattern
import hudson.plugins.ws_cleanup.Pattern.PatternType
import java.util.List

for (job in Jenkins.instance.items) {
  if (
      job instanceof hudson.maven.MavenModuleSet
      && job instanceof hudson.model.BuildableItemWithBuildWrappers
  ) {
    def willAddWorkspaceStep = true
    def wrappers = job.getBuildWrappersList()
    for (wrapper in wrappers) {
      if (wrapper instanceof hudson.plugins.ws_cleanup.PreBuildCleanup) {
        // already configured, we assume that there are patterns set
        // which we may want to leave as they are
        willAddWorkspaceStep = false
        break
      }
    }
    if (willAddWorkspaceStep == true) {
      List<Pattern> patterns  = null
      boolean deleteDirs 		= false
      String cleanupParameter = ""
      String externalDelete   = ""
      def ws_cleanupWrapper = new hudson.plugins.ws_cleanup.PreBuildCleanup(
        patterns, deleteDirs, cleanupParameter, externalDelete
      )
      println("Job will be modified: " + job.name)
      wrappers.add(ws_cleanupWrapper)
    }
  }
}


// See attached full changelog: mask_passwd_changelog.txt
import jenkins.model.Jenkins
import com.michelin.cio.hudson.plugins.maskpasswords.MaskPasswordsBuildWrapper

for (job in Jenkins.instance.items) {
  if (job instanceof hudson.maven.MavenModuleSet) {
    def wrappers = job.getBuildWrappersList()
    for (wrapper in wrappers) {
      if (wrapper instanceof MaskPasswordsBuildWrapper) {
        println("Mask passwords will be removed from job: " + job.name)
        //wrappers.remove(wrapper)
      }
    }
  }
}

// See attached full changelog: ssh_credentials_changelog.txt
import hudson.tasks.Shell
import hudson.plugins.git.GitSCM
import com.cloudbees.jenkins.plugins.sshagent.SSHAgentBuildWrapper

def sshCredentialsId = 'jenkins-ssh'

def mavenJobs = Jenkins.instance.items.findAll{ job ->
  job instanceof hudson.maven.MavenModuleSet
}

for (job in mavenJobs) {
  def wrappers = job.getBuildWrappersList()
  def sshWrapper = wrappers.get(SSHAgentBuildWrapper)
  if (sshWrapper != null) {
    // All jobs have already proper wrapper [jenkins-ssh]
    // No other wrappers are set, so we can safely skip to next job
    continue
  }
  def shellStep = job.getPostbuilders().get(Shell)
  if (shellStep == null) {
    continue
  }
  def gitPushCommand = 'git push'
  def shellScript = shellStep.getContents()
  def sshCredentialsRequired = shellScript.contains(gitPushCommand)
  if (sshCredentialsRequired == false) {
    continue
  }
  println("SSH Agent will be added to this job: " + job.name)
  def sshCredentialWrapper = new SSHAgentBuildWrapper(sshCredentialsId)
  // To verify run:
  //sshCredentialWrapper.getCredentialHolders().each() { println(it.getId())}
  wrappers.add(sshCredentialWrapper)
}


import hudson.plugins.git.GitSCM

def mavenJobs = Jenkins.instance.items.findAll{ job ->
  (job instanceof hudson.maven.MavenModuleSet || job instanceof hudson.model.FreeStyleProject) &&
  job.scm instanceof GitSCM
}

for (job in mavenJobs) {
  for (remoteConfig in job.scm.userRemoteConfigs) {
    println("Job: " + job.name)
    println("Branches before: " + job.scm.branches)
    for (branch in job.scm.branches) {
      switch(branch.getName()) {
        case '${GIT_BRANCH_NAME}': branch.setName('refs/heads/${GIT_BRANCH_NAME}'); break
        case '*/${GIT_BRANCH_NAME}': branch.setName('refs/heads/${GIT_BRANCH_NAME}'); break
        case '$GIT_BRANCH': branch.setName('refs/heads/${GIT_BRANCH}'); break
        case '*/${GIT_BRANCH_TOBUILD}': branch.setName('refs/heads/${GIT_BRANCH_TOBUILD}'); break
      }
    }
    println("Branches after:  " + job.scm.branches)
  }
}

import hudson.model.*

DisableChildren.disable(Hudson.instance.items)

class DisableChildren {
    static disable(items) {
      for (item in items) {
        if (item.class.canonicalName == 'com.cloudbees.hudson.plugins.folder.Folder') {
            disable(item.getItems())
        // JENKINS-33821: Pipeline jobs can`t be disabled
        } else if (item.class.canonicalName != 'org.jenkinsci.plugins.workflow.job.WorkflowJob') {
          item.disabled = true
          item.save()
        }
      }
    }
}

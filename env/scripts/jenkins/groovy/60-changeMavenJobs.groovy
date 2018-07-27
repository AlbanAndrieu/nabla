/*
 Alters Maven Projects so they would always try
 to upload artifacts to 'preprod-' repository.
 */
import hudson.model.*
import hudson.maven.RedeployPublisher

class MavenJobsModifier {
    static modify(items) {
        for (item in Hudson.instance.items) {
            if (item.class.canonicalName == 'com.cloudbees.hudson.plugins.folder.Folder') {
                modify(item.getItems())
            } else {
              if (item.class.canonicalName == "hudson.maven.MavenModuleSet") {

                  item.publishers.each() {
                      if (it instanceof RedeployPublisher) {
                          item.publishersList.remove(it)
                      }
                  }

                  item.publishersList.add(new RedeployPublisher(
                          'homemade-snapshot',
                          '{{ jenkins_remote_homemade_snapshot_url }}',
                          true,
                          false,
                          'IS_M2RELEASEBUILD'))
              }
            }
        }
    }
}

MavenJobsModifier.modify(Hudson.instance.items)

import jenkins.model.*
import hudson.plugins.emailext.*
import hudson.model.*
import hudson.maven.*
import hudson.maven.reporters.*
import hudson.tasks.*


def newRecipients = "{{ jenkins_remote_email_notifications }}"

for(item in Jenkins.getInstance().items)
{
    println(item.name + ": Checking for email notifiers");

    // Find current recipients defined in project
    if(!(item instanceof ExternalJob)) {
        if(item instanceof MavenModuleSet) {
            // Search for Maven Mailer Reporter
            for(reporter in item.reporters) {
                if(reporter instanceof MavenMailer) {
                    println(item.name + " - Updating reporter: " + reporter + " changing recipients from '" + reporter.recipients + "' to '" + newRecipients + "'");
                    reporter.recipients = newRecipients;
                }
            }
        }

        for(publisher in item.publishersList) {
            // Search  for  default  Mailer  Publisher  (doesn't  exist  for  Maven  projects)
            if(publisher instanceof Mailer) {
                println(item.name + " - Updating publisher: " + publisher + " changing recipients from '" + publisher.recipients + "' to '" + newRecipients + "'");
                publisher.recipients = newRecipients;
            }

            // Or  for  Extended  Email  Publisher else
            if(publisher instanceof ExtendedEmailPublisher) {
                println(item.name + " - Updating publisher: " + publisher + " changing recipients from '" + publisher.recipientList + "' to '" + newRecipients + "'");
                publisher.recipientList = newRecipients;
            }
        }
    }
}

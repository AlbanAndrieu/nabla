//Script to batch replace recipients in all emails
//This is a modified script from http://blog.traditionalcake.org/2011/09/jenkins-script-for-mass-update-of-email.html

import hudson.plugins.emailext.*
import hudson.model.*
import hudson.maven.*
import hudson.maven.reporters.*
import hudson.tasks.*

String searchMail = "replace this";
String replaceMail = "with that";

// For each project
for(item in Hudson.instance.items) {
	println("JOB : "+item.name);
	// Find current recipients defined in project
	if(!(item instanceof ExternalJob)) {
		if(item instanceof MavenModuleSet) {
			println(">MAVEN MODULE SET");
			// Search for Maven Mailer Reporter
			println(">>Reporters");
			for(reporter in item.reporters) {
				if(reporter instanceof MavenMailer) {
                                  	if(reporter.recipients.contains(searchMail)) {
                                    		println("Match! >>> reporter : "+reporter+" : "+reporter.recipients);
                                          	reporter.recipients = reporter.recipients.replace(searchMail, replaceMail);
                                        }
				}
			}
		} else if(item instanceof FreeStyleProject) {
			println(">FREESTYLE PROJECT");
		}
		println(">>Publishers");
		for(publisher in item.publishersList) {
			// Search for default Mailer Publisher (doesn't exist for Maven projects)
			if(publisher instanceof Mailer) {
                                if(publisher.recipients.contains(searchMail)) {
                                    println("Match! >>> publisher : "+publisher+" : "+publisher.recipients);
                                    publisher.recipients = publisher.recipients.replace(searchMail, replaceMail);
                                }
                        // Or for Extended Email Publisher
			} else if(publisher instanceof ExtendedEmailPublisher) {
                                 if(publisher.recipientList.contains(searchMail)) {
                                    println("Match! >>> publisher : "+publisher+" : "+publisher.recipientList);
                                    publisher.recipientList = publisher.recipientList.replace(searchMail, replaceMail);
                                 }
			}
		}
	} else {
		println("External Jobs cannot have MailNotificationsRecipients")
	}
println("\n=======\n");
}
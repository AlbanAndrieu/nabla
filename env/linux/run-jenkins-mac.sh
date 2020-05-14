#!/bin/bash
set -xv

#MacOSX
sudo launchctl version org.jenkins-ci
sudo launchctl list org.jenkins-ci
sudo launchctl unload /Library/LaunchDaemons/org.jenkins-ci.plist

rm -f /var/log/jenkins/jenkins.log
ls /Applications/Jenkins/jenkins.war
cd /Applications/Jenkins/
wget http://mirrors.jenkins.io/war-stable/latest/jenkins.war
sudo launchctl load /Library/LaunchDaemons/org.jenkins-ci.plist
tail -f /var/log/jenkins/jenkins.log
cd /Users/Shared/Jenkins/Home
sudo su - Jenkins
mkdir init.groovy.d/

sudo launchctl start org.apache.httpd
ls -lrta /private/var/log/apache2/error_log

#/Users/devel/.ssh/org.jenkins-ci
JENKINS_HOME_^P^Z/Users/Shared/Jenkins/Home

sudo launchctl list org.jenkins-ci
#{
#	"StandardOutPath" = "/var/log/jenkins/jenkins.log";
#	"LimitLoadToSessionType" = "System";
#	"StandardErrorPath" = "/var/log/jenkins/jenkins.log";
#	"SessionCreate" = true;
#	"Label" = "org.jenkins-ci";
#	"TimeOut" = 30;
#	"OnDemand" = false;
#	"LastExitStatus" = 19968;
#	"Program" = "/bin/bash";
#	"ProgramArguments" = (
#		"/bin/bash";
#		"/Library/Application Support/Jenkins/jenkins-runner.sh";
#	);
#};

sudo su - Jenkins
#nano /Library/Application\ Support/Jenkins/jenkins-runner.sh
nohup /Library/Application\ Support/Jenkins/jenkins-runner.sh
# Add export JENKINS_HOME="/Users/Shared/Jenkins/Home"
echo "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin/java" $javaArgs -jar "$war" $args
exec "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin/java" $javaArgs -jar "$war" $args

sudo /Library/Internet\ Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin/keytool -importcert -alias dev -file UK1VSWCERT01-CA-5.crt -keystore /Library/Internet\ Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/lib/security/cacerts
/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/bin/keytool -importcert -alias dev -file UK1VSWCERT01-CA-5.crt -keystore /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/security/cacerts

ls -lrta /Users/Shared/Jenkins/
sudo chown -R jenkins:staff /Users/Shared/Jenkins/
sudo chown -R jenkins:staff /Volumes/DATA/jobs/

#See https://wiki.jenkins.io/display/JENKINS/Thanks+for+using+OSX+Installer
#sudo defaults read /Library/Preferences/org.jenkins-ci
#sudo defaults write /Library/Preferences/org.jenkins-ci heapSize 8192M
#sudo defaults write /Library/Preferences/org.jenkins-ci minHeapSize 1024M
#sudo defaults write /Library/Preferences/org.jenkins-ci minPermGen 1024M
#sudo defaults write /Library/Preferences/org.jenkins-ci permGen 2048M
#sudo defaults write /Library/Preferences/org.jenkins-ci httpPort -1
#TODO sudo defaults write /Library/Preferences/org.jenkins-ci httpsPort 443
#sudo defaults write /Library/Preferences/org.jenkins-ci httpsPort 8383
#sudo defaults write /Library/Preferences/org.jenkins-ci httpsKeyStore /etc/ssl/almonde-jenkins.misys.global.ad/almonde-jenkins.misys.global.ad.jks
#sudo defaults write /Library/Preferences/org.jenkins-ci httpsKeyStorePassword changeit
#sudo defaults write JENKINS_HOME /Users/Shared/Jenkins/

#Uninstall Jenkins
#'/Library/Application Support/Jenkins/Uninstall.command'

#See https://jenkins.io/download/lts/macos/
ssh -X aandrieu@10.41.40.126
brew install jenkins-lts
brew services start jenkins-lts

exit 0

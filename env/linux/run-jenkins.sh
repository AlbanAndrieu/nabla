#!/bin/bash
set -xv

#https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+on+Ubuntu

#Add in software source :
#http://pkg.jenkins-ci.org/debian
#Warning do not have htpp!!!!

#A simple remove of the offending 2.5 package made jenkins happy again.
#sudo apt-get remove libservlet2.5-java
#/etc/init.d/jenkins restart
#or
#sudo service tomcat6 restart
#sudo service jenkins restart

#WAR upgrade
#/usr/share/jenkins/
#/var/lib/tomcat6/webapps/jenkins/
#sudo service tomcat6 stop
#copy jenkins.war $TOMCAT_HOME/webapps
#sudo ln -s /usr/share/jenkins/jenkins.war jenkins.war
#sudo chown tomcat6:tomcat6 jenkins.war
#cd $TOMCAT_HOME/webapps
#sudo rm -Rf jenkins/
#sudo service tomcat6 start

#change JENKINS_HOME from /var/lib/jenkins/ to /jenkins/

#Massive change in config.xml
#find /jenkins/jobs -type f -name "config.xml" -exec sed -i 's/<name>nabla.jenkins<\/name>/<name>nabla jenkins<\/name>/g' {} +

#conf
#/etc/init/jenkins.conf
/etc/default/jenkins
sudo nano /etc/default/jenkins
#change port to 8380
#add
#JAVA_ARGS="-Xmx1024m -XX:MaxPermSize=512m"
#sudo gedit /var/lib/tomcat7/conf/server.xml
#see http://localhost:8380/jenkins
PREFIX=/jenkins
JENKINS_ARGS="$JENKINS_ARGS --prefix=$PREFIX"

#JENKINS USER
#tomcat6
#/usr/share/tomcat6/
#/home/kdeveloper/.jenkins

#http://en.wikipedia.org/wiki/Xvfb
#yum install Xvfb
#yum install xorg-x11-fonts*
#sudo apt-get install msttcorefonts
#rpm -ql xorg-x11-server-Xvfb-1.1.1-48.91.el5_8.2.x86_64
#yum install flash-plugin
#rpm -ql flash-plugin-11.2.202.258-release.x86_64
#sudo chown -R jenkins:jenkins /tmp/.X11-unix
#rm -Rf /tmp/.X11-unix/X0

#ll /usr/lib64/flash-plugin/
#cd /usr/bin
#sudo ln -s /home/kgr_mvn/bin/flashplayer flashplayer
#sudo ln -s /home/kgr_mvn/bin/flashplayerdebugger flashplayerdebugger
#sudo ln -s /home/kgr_mvn/bin/xvfb-run xvfb-run
#sudo -u tomcat6 flashplayer

export MAVEN_OPTS="-Xms256m -Xmx1024m -XX:PermSize=80M -XX:MaxPermSize=256M -XX:-UseGCOverheadLimit"

java -jar /usr/share/jenkins/jenkins.war --httpPort=8081 --ajp13Port=8010

#sudo /etc/init.d/jenkins start

#less /var/log/jenkins/jenkins.log

#trigger a full backup
#wget http://albandri:8280/jenkins/backup/backup
#http://home.albandrieu.com:8080/

#check memory
#http://blog.cloudbees.com/2013/09/health-check-up-for-your-jenkins.html?mkt_tok=3RkMMJWWfF9wsRonvanBZKXonjHpfsX%2F7uwqUbHr08Yy0EZ5VunJEUWy24MIRdQ%2FcOedCQkZHblFnVwASa2lV7oNr6QP
ssh -X jenkins@myserver jconsole

#monitoring
https://home.albandrieu.com/jenkins/monitoring?
https://home.albandrieu.com/jenkins/monitoring?part=graph&graph=httpSessions

#On Red hat disable jenkins start at boot time
#chkconfig jenkins off
sudo update-rc.d jenkins disable

#TODO jenkins in apache is in conflict with gearman
sudo a2dissite gearman

#restart ldap if login issue
sudo service slapd restart

#sound
cd /workspace
sudo git clone https://github.com/jenkinsci/sounds-plugin.git
cd /workspace/sounds-plugin/src/main/resources
sudo cp /workspace/sounds-plugin/src/main/resources/sound-archive.zip /jenkins
sudo chmod 777 sound-archive.zip

# war
/var/run/jenkins/war/

#Too many open files
#cat /proc/sys/fs/file-max
ulimit -n
lsof -p PID | wc -l
ls -la /proc/PID/fd | wc -l

System.setProperty("org.jenkinsci.plugins.durabletask.BourneShellScript.LAUNCH_DIAGNOSTICS", "true")
System.setProperty("org.jenkinsci.plugins.durabletask.BourneShellScript.FORCE_SHELL_WRAPPER", "true")
System.setProperty("org.jenkinsci.plugins.durabletask.BourneShellScript.FORCE_BINARY_WRAPPER", "true")
#System.setProperty("hudson.slaves.WorkspaceList", "_")
# See https://wiki.jenkins.io/display/JENKINS/Configuring+Content+Security+Policy
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
System.setProperty("permissive-script-security.enabled", "true")
System.setProperty("org.jenkinsci.plugins.gitclient.Git.timeOut", "120")
System.setProperty("hudson.plugins.git.GitSCM.verbose", "true")
System.setProperty("org.jenkinsci.plugins.docker.workflow.client.DockerClient.CLIENT_TIMEOUT", "600")

#System.setProperty("http.connect.timeout", "100")
#System.setProperty("http.connect.request.timeout", "600")
#System.setProperty("http.socket.timeout", "600")
System.setProperty("http.socket.timeout", "300")
System.getProperty("http.socket.timeout")

System.setProperty("org.jenkinsci.plugins.workflow.libs.SCMSourceRetriever.INCLUDE_SRC_TEST_IN_LIBRARIES", "true")

#Hook
$JENKINS_URL/git/notifyCommit
$JENKINS_URL/bitbucket-hook/
$JENKINS_URL/bitbucket-scmsource-hook/notify/

#On Windows
#Clear Event Log (control panel> administrator tools>event viewer)
# Application -> righ panel -> Action clear log
#Remove windows service sc.exe  delete jenkinsslave-E__Jenkins-Slave
#https://wiki.jenkins.io/display/JENKINS/Installing+Jenkins+as+a+Windows+service
#sc.exe create "<serviceKey>" start= auto binPath= "<path to jenkins-slave.exe>" DisplayName= "<service display name>"

#Add certificate in javacpl.exe

#How to install the jx binary on your machine
curl -L https://github.com/jenkins-x/jx/releases/download/v1.2.18/jx-linux-amd64.tar.gz | tar xzv
sudo mv jx /usr/local/bin

#API endpoint
#http://home.albandrieu.com:8381/job/nabla-projects-interview-visma-nightly/lastSuccessfulBuild/api/json?tree=actions[remoteUrls,lastBuildRevision[SHA1]]&pretty=true

https://github.com/jenkinsci/kubernetes-operator

helm repo add jenkins https://raw.githubusercontent.com/jenkinsci/kubernetes-operator/master/chart
helm inspect values jenkins/jenkins-operator  > jenkins-operator-values.xml
helm install jenkins-operator  jenkins/jenkins-operator -n jenkins
helm status jenkins-operator -n jenkins

NOTES:
1. Watch Jenkins instance being created:
$ kubectl --namespace jenkins get pods -w

2. Get Jenkins credentials:
$ kubectl --namespace jenkins get secret jenkins-operator-credentials-jenkins -o 'jsonpath={.data.user}' | base64 -d
$ kubectl --namespace jenkins get secret jenkins-operator-credentials-jenkins -o 'jsonpath={.data.password}' | base64 -d

3. Connect to Jenkins (actual Kubernetes cluster):
$ kubectl --namespace jenkins port-forward jenkins-jenkins 8080:8080

Now open the browser and enter http://localhost:8080


exit 0

#https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+on+Ubuntu

A simple remove of the offending 2.5 package made jenkins happy again.
sudo apt-get remove libservlet2.5-java
/etc/init.d/jenkins restart

#JENKINS_HOME
/var/lib/jenkins/

#WAR
/usr/share/jenkins/

/home/kdeveloper/.jenkins

java -jar /usr/share/jenkins/jenkins.war --httpPort=8081 --ajp13Port=8010

sudo /etc/init.d/jenkins start

less /var/log/jenkins/jenkins.log
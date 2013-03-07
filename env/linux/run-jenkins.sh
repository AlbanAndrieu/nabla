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

#JENKINS_HOME
#/etc/default/jenkins
#/var/lib/jenkins/
#/jenkins/

#WAR
#/usr/share/jenkins/

#JENKINS USER
#tomcat6
#/usr/share/tomcat6/
#/home/kdeveloper/.jenkins

#WAR
#/var/lib/tomcat6/webapps/jenkins/

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

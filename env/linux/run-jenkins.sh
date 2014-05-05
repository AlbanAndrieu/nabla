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
sudo gedit /etc/default/jenkins
#change port to 8380
#add
#JAVA_ARGS="-Xmx1024m -XX:MaxPermSize=512m"
#sudo gedit /var/lib/tomcat7/conf/server.xml
#see http://localhost:8380/jenkins

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
#http://home.nabla.mobi:8080/

#check memory 
#http://blog.cloudbees.com/2013/09/health-check-up-for-your-jenkins.html?mkt_tok=3RkMMJWWfF9wsRonvanBZKXonjHpfsX%2F7uwqUbHr08Yy0EZ5VunJEUWy24MIRdQ%2FcOedCQkZHblFnVwASa2lV7oNr6QP
ssh -X jenkins@myserver jconsole 

#conf
#/etc/init/jenkins.conf
/etc/default/jenkins

PREFIX=/jenkins
JENKINS_ARGS="$JENKINS_ARGS --prefix=$PREFIX"

#monitoring
https://home.nabla.mobi/jenkins/monitoring?
https://home.nabla.mobi/jenkins/monitoring?part=graph&graph=httpSessions

#On Red hat disable jenkins start at boot time
#chkconfig jenkins off
sudo update-rc.d jenkins disable

#TODO jenkins in apache is in conflict with gearman
sudo a2dissite gearman

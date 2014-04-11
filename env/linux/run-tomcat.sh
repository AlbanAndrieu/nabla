sudo apt-get install tomcat7 tomcat7-docs tomcat7-examples tomcat7-admin

#http://doc.ubuntu-fr.org/tomcat
#https://help.ubuntu.com/13.04/serverguide/tomcat.html
# /usr/share/tomcat7
# /etc/tomcat7/server.xml change port to 8280

export CATALINA_HOME=/usr/share/tomcat7
export CATALINA_BASE=/var/lib/tomcat7

less /etc/default/tomcat7

sudo gedit /etc/environment
#JAVA_HOME="/usr/lib/jvm/jdk1.7.0"
JAVA_HOME="/usr/lib/jvm/java-1.7.0-openjdk-i386"
JRE_HOME="/usr/lib/jvm/java-1.7.0-openjdk-i386/jre"
PATH="...(other path):$JAVA_HOME:$JRE_HOME"
PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:$JAVA_HOME:$JRE_HOME"

$CATALINA_HOME/bin/startup.sh

http://localhost:8280/
http://localhost:8280/manager/html/
http://localhost:8280/host-manager/html

#sudo gedit /etc/tomcat7/tomcat-users.xml
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<role rolename="manager"/>
<role rolename="admin-gui"/>
<role rolename="admin-script"/>
<role rolename="admin"/>

<user username="votre-login" password="votre-mot-de-passe" roles="manager-gui,admin-gui,manager,admin,manager-script,admin-script"/>


sudo chgrp -R tomcat7 /etc/tomcat7
sudo chmod -R g+w /etc/tomcat7
cd /var/lib/tomcat7
sudo chgrp -R tomcat7 ../../cache/tomcat7
sudo chgrp -R tomcat7 ../../log/tomcat7
sudo chown -h tomcat7 work
sudo chown -h tomcat7 conf
sudo chown -h tomcat7 logs
cd /usr/share/tomcat7
sudo ln -s /var/log/tomcat7 logs

#sudo /usr/share/tomcat7/bin/startup.sh
sudo gedit /etc/init.d/tomcat7
add before catalina_sh
#JAVA_HOME="/usr/lib/jvm/jdk1.7.0"
JAVA_HOME="/usr/lib/jvm/java-1.7.0-openjdk-i386"
add before # OS specific support.  
JAVA_OPTS="-Djava.awt.headless=true -Dfile.encoding=UTF-8 -server -Xms1536m -Xmx1536m -XX:NewSize=256m -XX:MaxNewSize=256m -XX:PermSize=256m -XX:MaxPermSize=256m -XX:+DisableExplicitGC -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled -Dnabla.config=/var/lib/tomcat7/webapps/nabla.properties"
#TODO : or do it in /etc/default/tomcat7

sudo /etc/init.d/tomcat7 restart
sudo service tomcat7 restart

curl -T - -u user:pass 'http://<tomcat-host>/manager/text/deploy?update=true&path=/<yourpath>' < <path_to_war_file>
curl -T - -u manager:123456 'http://localhost:8080/manager/text/deploy?update=true&path=/slim' < /target/dist/slim.war

tail -f /var/log/tomcat7
tail -f /var/lib/tomcat7/logs/
tail -f /usr/share/tomcat7/logs

#!/bin/bash
set -xv

sudo apt-get install tomcat9 tomcat9-docs tomcat9-examples tomcat9-admin

#http://doc.ubuntu-fr.org/tomcat
#https://help.ubuntu.com/13.04/serverguide/tomcat.html
# /usr/share/tomcat9
# /etc/tomcat9/server.xml change port to 8280

export CATALINA_HOME=/usr/share/tomcat9
export CATALINA_BASE=/var/lib/tomcat9

less /etc/default/tomcat9

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

#sudo gedit /etc/tomcat9/tomcat-users.xml
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<role rolename="manager"/>
<role rolename="admin-gui"/>
<role rolename="admin-script"/>
<role rolename="admin"/>

<user username="votre-login" password="votre-mot-de-passe" roles="manager-gui,admin-gui,manager,admin,manager-script,admin-script"/>


sudo chgrp -R tomcat9 /etc/tomcat9
sudo chmod -R g+w /etc/tomcat9
cd /var/lib/tomcat9
sudo chgrp -R tomcat9 ../../cache/tomcat9
sudo chgrp -R tomcat9 ../../log/tomcat9
sudo chown -h tomcat9 work
sudo chown -h tomcat9 conf
sudo chown -h tomcat9 logs
cd /usr/share/tomcat9
sudo ln -s /var/log/tomcat9 logs

#sudo /usr/share/tomcat9/bin/startup.sh
sudo gedit /etc/init.d/tomcat9
add before catalina_sh
#JAVA_HOME="/usr/lib/jvm/jdk1.7.0"
JAVA_HOME="/usr/lib/jvm/java-1.7.0-openjdk-i386"
add before # OS specific support.
JAVA_OPTS="-Djava.awt.headless=true -Dfile.encoding=UTF-8 -server -Xms1536m -Xmx1536m -XX:NewSize=256m -XX:MaxNewSize=256m -XX:PermSize=256m -XX:MaxPermSize=256m -XX:+DisableExplicitGC -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled -Dnabla.config=/var/lib/tomcat9/webapps/nabla.properties"
#TODO : or do it in /etc/default/tomcat9

sudo /etc/init.d/tomcat9 restart
sudo service tomcat9 restart

curl -T - -u user:pass 'http://<tomcat-host>/manager/text/deploy?update=true&path=/<yourpath>' < <path_to_war_file>
curl -T - -u manager:123456 'http://localhost:8080/manager/text/deploy?update=true&path=/slim' < /target/dist/slim.war

tail -f /var/log/tomcat9
tail -f /var/lib/tomcat9/logs/
tail -f /usr/share/tomcat9/logs

#In order to fix
#java.util.prefs.BackingStoreException: Couldn't get file lock
#http://stackoverflow.com/questions/23960451/java-system-preferences-under-different-users-in-linux
echo ${CATALINA_HOME}
#/usr/share/tomcat9
cd ${CATALINA_HOME}
sudo mkdir -p ${CATALINA_HOME}/.java/.systemPrefs
sudo mkdir ${CATALINA_HOME}/.java/.userPrefs
sudo chmod -R 755 ${CATALINA_HOME}/.java

#inside ${CATALINA_HOME}/bin/catalina.sh
export JAVA_OPTS="$JAVA_OPTS -Djava.util.prefs.systemRoot=${CATALINA_HOME}/.java -Djava.util.prefs.userRoot=${CATALINA_HOME}/.java/.userPrefs"

#switch from java7 to java 8
sudo nano /etc/default/tomcat9
JAVA_HOME=/usr/lib/jvm/java-8-oracle

#Add https
#https://dzone.com/articles/setting-ssl-tomcat-5-minutes
cd $JAVA_HOME/bin
keytool -genkey -alias tomcat -keyalg RSA
#changeit
#Is CN=Alban Andrieu, OU=Nabla, O=Nabla, L=Paris, ST=IleDeFrance, C=FR correct?
#keystore created in /workspace/users/albandri10/.keystore
keytool -list -keystore /workspace/users/albandri10/.keystore

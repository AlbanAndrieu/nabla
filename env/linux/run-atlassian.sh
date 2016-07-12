sudo service crowd start
http://localhost:8095/crowd/
#user : Alban Andrieu
#pass microsoft

sudo adduser crowd
sudo addgroup data
sudo adduser crowd data
#pass microsoft

#https://confluence.atlassian.com/display/CROWD/Installing+Crowd+and+CrowdID
{CROWD_INSTALL}\crowd-webapp\WEB-INF\classes\crowd-init.properties
tar xzf atlassian-crowd-2.5.2.tar.gz
gedit atlassian-crowd-2.5.2/crowd-webapp/WEB-INF/classes/crowd-init.properties
sudo mkdir -p /var/crowd-home

mysql -u root -p
microsoft
#CREATE user "crowd"@"nabla.mobi";
CREATE user "crowd";
SET password FOR "crowd" = password('microsoft');
SELECT user FROM mysql.user;
create database crowd character set utf8 collate utf8_bin;
GRANT ALL ON crowd.* TO "crowd";
create database crowdiddb character set utf8;
GRANT ALL ON crowdiddb.* TO "crowd";

cd /workspace
sudo cp ~/Downloads/mysql-connector-java-5.1.22/mysql-connector-java-5.1.22-bin.jar .
cd /workspace/atlassian-crowd-2.5.2/apache-tomcat/lib
cp /workspace/mysql-connector-java-5.1.22-bin.jar .
sudo chown crowd.data mysql-connector-java-5.1.22-bin.jar
sudo chmod 755 mysql-connector-java-5.1.22-bin.jar

gedit /workspace/atlassian-crowd-2.5.2/apache-tomcat/conf/Catalina/localhost/openidserver.xml
cd /workspace/atlassian-crowd-2.5.2
gedit build.properties
./build.sh

./start_crowd.sh 

#https://confluence.atlassian.com/display/CROWD/Setting+Crowd+to+Run+Automatically+and+Use+an+Unprivileged+System+User+on+UNIX
cd /etc/init.d
sudo ln -s /workspace/atlassian-crowd-2.5.2/crowd.init.d crowd

sudo update-rc.d crowd defaults 05 95
ls -l /etc/rc?.d/*crowd

TODO
http://www.antelink.com/blog/tutorial-secure-installation-crowd.html

sudo service crowd start
TODO https://confluence.atlassian.com/display/CROWD/Installing+Crowd+and+CrowdID

#https://confluence.atlassian.com/display/CROWD/Installing+the+Crowd+Apache+Connector+on+Ubuntu+Linux

sudo apt-get -y install autoconf libtool apache2-threaded-dev libsvn-dev libcurl4-gnutls-dev libxml2-dev apache2-mpm-worker libapache2-svn
Enter your password when prompted.
Enter the following commands:
wget https://studio.plugins.atlassian.com/svn/CWDAPACHE/tags/2.0.2/mod_authnz_crowd-2.0.2.tar.gz 
tar xzf mod_authnz_crowd-2.0.2.tar.gz 
cd mod_authnz_crowd-2.0.2
autoreconf --install 
./configure 
make 
sudo make install
Enter your password if prompted.
Everything you need should now be installed and Apache should restart. If Apache fails to start, check the /var/log/apache2/error.log file.

#cd /workspace/
#sudo chmod -R 755 atlassian-crowd-2.5.2

http://localhost:8095/crowd/
crowd user/pass alban.andrieu@nabla.mobi/microsoft

JIRA
See where JIRA will be installed and the settings that will be used.
Installation Directory: /opt/atlassian/jira 
Home Directory: /var/atlassian/application-data/jira 
HTTP Port: 8082 
RMI Port: 8006

JIRA mySQL database : user jira pass microsoft
CREATE DATABASE jira CHARACTER SET utf8 COLLATE utf8_bin;
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP,ALTER,INDEX on jira.* TO 'jira'@'localhost' IDENTIFIED BY 'microsoft';
flush privileges;

cd /workspace/users/albandri10/Downloads/mysql-connector-java-5.1.22
sudo cp mysql-connector-java-5.1.22-bin.jar /opt/atlassian/jira/lib/
#cd /opt/atlassian/jira/bin
#sudo ./start-jira.sh

jira user/pass alban.andrieu@nabla.mobi/microsoft
admin/microsoft

#start
as root 
cd /opt/atlassian/jira/
./startup.sh

CONFLUENCE
See where Confluence will be installed and the settings that will be used.
Installation Directory: /opt/atlassian/confluence 
Home Directory: /var/atlassian/application-data/confluence 
HTTP Port: 8090 
RMI Port: 8000 

CREATE DATABASE confluence;
GRANT ALL PRIVILEGES ON confluence.* TO 'confluence'@'localhost' IDENTIFIED BY 'microsoft';

confluence user/pass alban.andrieu@nabla.mobi/microsoft
admin/microsoft

#start
as root 
cd /opt/atlassian/confluence 
./startup.sh

fisheye
sudo gedit /etc/environment
FISHEYE_INST="/workspace/fisheye-2.10.2"
cd /workspace/fecru-2.10.2
as albandri
./bin/start.sh
http://localhost:8060/ 

SET GLOBAL storage_engine = 'InnoDB';
CREATE DATABASE fisheye CHARACTER SET utf8 COLLATE utf8_bin;
GRANT ALL PRIVILEGES ON fisheye.* TO 'fisheye'@'localhost' IDENTIFIED BY 'microsoft';
FLUSH PRIVILEGES;

tail -f /workspace/fisheye/var/log/fisheye.out

#grant atlassian
#!/bin/bash
CROWD_USER="crowd"
CROWD_GROUP="crowd"
#INSTALL_BASE="/opt/crowd/atlassian-crowd-2.2.2"
INSTALL_BASE="/workspace/atlassian-crowd-2.5.2"
CROWD_HOME="/var/crowd-home"
sudo chgrp ${CROWD_GROUP} ${INSTALL_BASE}/{*.sh,apache-tomcat/bin/*.sh}
sudo chmod g+x ${INSTALL_BASE}/{*.sh,apache-tomcat/bin/*.sh}
sudo chown -R ${CROWD_USER} ${CROWD_HOME} ${INSTALL_BASE}/apache-tomcat/{logs,work}
sudo touch -a ${INSTALL_BASE}/atlassian-crowd-openid-server.log
#sudo mkdir ${INSTALL_BASE}/database
sudo chown -R ${CROWD_USER} ${INSTALL_BASE}/{database,atlassian-crowd-openid-server.log}


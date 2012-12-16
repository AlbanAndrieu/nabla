sudo adduser crowd
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
sudo chown crowd.crowd mysql-connector-java-5.1.22-bin.jar
sudo chmod 755 mysql-connector-java-5.1.22-bin.jar

gedit /workspace/atlassian-crowd-2.5.2/apache-tomcat/conf/Catalina/localhost/openidserver.xml
cd /workspace/atlassian-crowd-2.5.2
gedit build.properties
./build.sh

./start_crowd.sh 

#https://confluence.atlassian.com/display/CROWD/Setting+Crowd+to+Run+Automatically+and+Use+an+Unprivileged+System+User+on+UNIX
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
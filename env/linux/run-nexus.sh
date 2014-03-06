#http://www.sonatype.org/nexus/

sudo cp nexus-2.2-01-bundle.tar.gz /workspace
cd /workspace
sudo tar xvzf nexus-2.2-01-bundle.tar.gz
sudo ln -s nexus-2.2-01 nexus

#NEXUS_HOME/conf/nexus.properties
cd /etc/init.d
sudo ln -s /workspace/nexus/bin/nexus nexus

sudo update-rc.d nexus defaults 06 94
ls -l /etc/rc?.d/*nexus

sudo adduser nexus
sudo addgroup data
sudo adduser nexus data

#cd /usr/local/nexus
cd /workspace

sudo chown -R nexus.data sonatype-work
sudo chown -R nexus.data nexus
sudo chown -R nexus.data nexus-2.3.0-04

cd /workspace/nexus
./bin/nexus console

#http://www.sonatype.com/books/nexus-book/reference/install-sect-running.html
default login/password is admin/admin123/microsoft

#https://docs.sonatype.org/display/Nexus/Nexus+Crowd+Plugin+(Community+Version)
cd /usr/local/sonatype-work/nexus/plugin-repository
#check out the latest code from https://github.com/flopma/nexus-crowd-plugin and build it by yourself.
mvn clean install
sudo cp /workspace/divers/nexus-crowd-plugin/target/nexus-crowd-plugin-2.0.6-SNAPSHOT-bundle.zip .
sudo unzip nexus-crowd-plugin-2.0.6-SNAPSHOT-bundle.zip
sudo chown -R nexus.data nexus-crowd-plugin-2.0.6-SNAPSHOT/
#https://github.com/johnou/nexus-crowd-plugin/downloads
# Plugins 2.1.2-SNAPSHOT works with previous nexus version

#sudo mv ~/Downloads/nexus-crowd-plugin-1.6.0 .
sudo mv ~/Downloads/nexus-crowd-plugin-2.1.2-SNAPSHOT .
sudo chown -R nexus.data nexus-crowd-plugin-*/

#cd /usr/local/nexus
#./bin/nexus start
#microsoft

sudo update-rc.d -f nexus remove
sudo update-rc.d nexus defaults 10 90
sudo service nexus start

java -jar /workspace/users/albandri10/Downloads/application-check-1.21.3.jar 

nano ./bin/jsw/conf/wrapper.con
#change "wrapper.startup.timeout" and "wrapper.ping.timeout to 500

#Nexus tasks
#http://blog.sonatype.com/2009/09/nexus-scheduled-tasks/#.UxYfIj-wI44
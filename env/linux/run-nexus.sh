#http://www.sonatype.org/nexus/

sudo cp nexus-2.2-01-bundle.tar.gz /usr/local/
cd /usr/local/
sudo tar xvzf nexus-2.2-01-bundle.tar.gz
sudo ln -s nexus-2.2-01 nexus

#NEXUS_HOME/conf/nexus.properties
cd /etc/init.d
sudo ln -s /usr/local/nexus/bin/nexus nexus

sudo adduser nexus
sudo addgroup data
sudo adduser nexus data

cd /usr/local/nexus

sudo chown -R nexus.data sonatype-work
sudo chown -R nexus.data nexus
sudo chown -R nexus.data nexus-2.2-01

./bin/nexus console

#http://www.sonatype.com/books/nexus-book/reference/install-sect-running.html
default login/password is admin/admin123

#https://docs.sonatype.org/display/Nexus/Nexus+Crowd+Plugin+(Community+Version)
cd /usr/local/sonatype-work/nexus/plugin-repository
#https://github.com/johnou/nexus-crowd-plugin/downloads
# Plugins 2.1.2-SNAPSHOT works

#sudo mv ~/Downloads/nexus-crowd-plugin-1.6.0 .
sudo mv ~/Downloads/nexus-crowd-plugin-2.1.2-SNAPSHOT .
sudo chown -R nexus.data nexus-crowd-plugin-*/

./bin/nexus start


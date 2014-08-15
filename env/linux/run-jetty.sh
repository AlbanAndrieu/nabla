#install jetty 6
#sudo apt-get install jetty libjetty8-extra-java libjetty8-java libjetty-extra-java libjetty-extra libjetty-java-doc jetty8 libjetty8-java-doc libjetty-java jsvc default-jre-headless apache2-utils
sudo apt-get install jetty libjetty-extra-java libjetty-extra libjetty-java-doc
Not creating home directory /usr/share/jetty.
 * Not starting jetty - edit /etc/default/jetty and change NO_START to be 0 (or comment it out)

sudo nano /etc/default/jetty
#change port to 9090

sudo service jetty status
sudo service jetty start

cd /workspace
ln -s /usr/share/jetty jetty

#for eclipse
sudo chmod -R 777 /var/log/jetty
sudo chmod -R 777 /usr/share/jetty/webapps
sudo chmod -R 777 /usr/share/jetty/contexts
#check jetty server start on port :
sudo lsof -i :8079
#change it to 8089

#downoad from
#http://eclipse.org/downloads/download.php?file=/jetty/stable-9/dist/jetty-distribution-9.1.5.v20140505.tar.gz&r=1
cd /workspace/jetty
cp ~/Downloads/jetty-distribution-9.1.5.v20140505.tar.gz  .
tar -xvf jetty-distribution-9.1.5.v20140505.tar.gz

#eclipse Jetty WTP plugins
#NOK for jetty 9 http://wiki.eclipse.org/Jetty_WTP_Plugin
#NOK for jetty 9 http://download.eclipse.org/jetty/updates/jetty-wtp
#https://code.google.com/p/run-jetty-run/
#http://run-jetty-run.googlecode.com/svn/trunk/updatesite
#See marketplace

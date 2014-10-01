#download 
#http://chrononsystems.com/products/chronon-recording-server
mv ~/Downloads/recordingserver-3.20.1.187 /workspace

cd /workspace
ln -s recordingserver-3.20.1.187 chronon

#add it to tomcat
#port:8032
 
#install eclipse plugin from market place instead of 
#http://chrononsystems.com/updatesite

cd /workspace/chronon/controllers/linux/controller/bin
geany config.properties
 
chmod 744 ./installDaemon.sh
chmod -R 744 /workspace/chronon/controllers/linux/controller/bin
sudo ./installDaemon.sh

sudo ./startDaemon.sh

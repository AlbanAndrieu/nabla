#http://visualvm.java.net/
#https://java.net/projects/visualvm/downloads/download/release138/visualvm_138.zip

#Performance monitoring
#Listing JVM Processes on the Local Machine with "jps"
jps -l -m -v
#http://docs.oracle.com/javase/7/docs/technotes/tools/share/jstatd.html
#http://stackoverflow.com/questions/9939883/can-not-start-jstatd-in-linux
rmiregistry 2020&
#Create the security policy file, tools.policy, that grants permissions to run "jstatd" and other tools in the tools.jar:
geany ~/.java.policy
grant codebase "file:${java.home}/../lib/tools.jar" {
   permission java.security.AllPermission;
};
jstatd -J-Djava.security.policy=all.policy -p 2020
#sudo apt-get install sockstat
#sockstat | grep jstat
sudo netstat -an | grep 1099
sudo netstat -an | grep 2020
sudo lsof -i :2020
sudo lsof -i -P -n | grep jstatd

jps -l -m -v rmi://localhost:2020
jps -l -m -v rmi://localhost:55841
#give 
#9015 /usr/local/eclipse/eclipse-luna
#jps -l -m -v rmi://10.25.40.139:2020
jstat -gcutil -t 9015 1s 30
#The last two parameters "1s 30" tells "jstat" to collect 30 samples with an interval of 1 second.

#ssh -L 1099:localhost:1099 albandri@albandri
#ssh -L 2020:localhost:2020 albandri@albandri
#ssh -L 9696:localhost:9696 albandri@albandri -v

#http://hackers.lookout.com/2014/06/profiling-remote-jvms/
ssh -D 9696 albandri@albandri.misys.global.ad -v
sudo lsof -i -P -n | grep ssh

jconsole -J-DsocksProxyHost=localhost -J-DsocksProxyPort=9696
#Remote process
#inside jvisualvm
sudo jvisualvm
#Tools -> Options -> network 
#Manuel proxy settings
#socket proxy -> localhost
#port -> 9696
#no proxy hosts -> clear 
#inside visualVM add jstatsd connection -> default : 1099
#service:jmx:rmi:///jndi/rmi://mgrv062.misys.global.ad:9194/jmxrmi

#Activate jmx on tomcat
#CATALINA_OPTS
-Dcom.sun.management.jmxremote
-Dcom.sun.management.jmxremote.ssl=false
-Dcom.sun.management.jmxremote.authenticate=false
-Dcom.sun.management.jmxremote.port=1099
#-Djava.rmi.server.hostname=<tomat_host>

#Activate jmx on jetty
-Dcom.sun.management.jmxremote
-Dcom.sun.management.jmxremote.ssl=false
-Dcom.sun.management.jmxremote.authenticate=false
-Dcom.sun.management.jmxremote.port=1099
-Djetty.jmxrmihost=localhost
-Djetty.jmxrmiport=1099

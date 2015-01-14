sudo service newrelic-sysmond status

#install java agent
#tomcat

sudo cp ~/newrelic-java-3.12.1.zip /usr/share/tomcat7
cd /usr/share/tomcat7
sudo chown -R tomcat7:tomcat7 newrelic-java-3.12.1.zip
sudo unzip newrelic-java-3.12.1.zip
cd newrelic
java -jar newrelic.jar install

export JAVA_OPTIONS="${JAVA_OPTIONS} -javaagent:/full/path/to/newrelic.jar"
#https://docs.newrelic.com/docs/agents/java-agent/installation/java-agent-manual-installation

#https://dripstat.com/app/index.html#/addjvm
cd /usr/share/tomcat7
sudo wget http://dripstat.com/dl/dripstat_agent-5.1.2.zip
sudo chown -R tomcat7:tomcat7 dripstat_agent-5.1.2.zip
sudo unzip dripstat_agent-5.1.2.zip
cd dripstat
sudo java -jar dripstat.jar install -n "nabla" -l b2fj9n8kTx25Ek8aG4HLRQ

#https://dripstat.com/app/index.html#/jvms

sudo service tomcat7 restart
#http://localhost:8280/

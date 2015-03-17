#http://arodrigues.developpez.com/tutoriels/java/performance/developper-plan-test-avec-jmeter/

#http://jmeter-plugins.org/wiki/WebDriverTutorial/

#Install perfMon
http://jmeter-plugins.org/wiki/PerfMonAgent/

#On the target host
/usr/local/jmeter-agent/startAgent.sh --udp-port 0 --tcp-port 3450

#Run jmeter
cd /workspace/users/albandri30/nabla-project-interview-visma/gui
/usr/local/jmeter/apache-jmeter-2.12/bin/jmeter -n -t src/test/jmeter/jmeter.jmx -l outputFile.jtl 

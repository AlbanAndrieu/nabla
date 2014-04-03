#!/bin/bash

npm install

bower install

echo ">>> Starting webdriver-manager ......."  

# start selenium
#./node_modules/protractor/bin/webdriver-manager start > /dev/null 2>&1 &
nohup webdriver-manager start &

# wait until selenium is up
while ! curl http://localhost:4444/wd/hub/status &>/dev/null; do :; done

process_id=`/bin/ps -fu $USER| grep "[w]ebdriver" | awk '{print $2}'`

if [ -n "$process_id" ]; then
	echo ">>> webdriver-manager process id: "$process_id

	echo ">>> Running protractor tests"
	#protractor protractor-jenkins-e2e.conf.js
	#protractor protractor-e2e.conf.js
	grunt protractor:e2e 
	
fi

echo ">>> Stoping webdriver-manager"
# stop selenium
curl -s -L http://localhost:4444/selenium-server/driver?cmd=shutDownSeleniumServer > /dev/null 2>&1

for pid in $process_id
do
	echo "Killing pid: "$pid
	kill $pid
done

process_id=`/bin/ps -fu $USER| grep "[w]ebdriver" | awk '{print $2}'`

if [ -n "$process_id" ]; then
	echo ">>> !!! webdriver-manager process still running!!!  - process_id: "$process_id
else
	echo ">>> webdriver-manager process stopped"
fi

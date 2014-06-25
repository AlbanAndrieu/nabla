cls

call setenv.bat 

REM use webdriver.chrome instead of webdriver.chrome.driver
REM OK call mvn clean verify -Psample -Dserver=tomcat7x -Ddatabase=derby -Dwebdriver.chrome.driver=/var/lib/chromedriver -Dwebdriver.base.url=http://home.nabla.mobi:8280 > install.log 2>&1
REM -Dwebdriver.chrome.driver="C:\chromedriver\chromedriver.exe" -Dwebdriver.firefox.bin="C:\Program Files\Mozilla Firefox\firefox.exe"
REM OK call mvn clean verify -Psample -Dserver=tomcat7x -Ddatabase=derby -Dwebdriver.base.url=http://home.nabla.mobi:8280 > install.log 2>&1
REM OK call mvn clean verify -Psample -Dserver=jetty9x -Ddatabase=derby -Dwebdriver.chrome.driver=/var/lib/chromedriver -Dwebdriver.base.url=http://localhost:9090 > install.log 2>&1
REM call mvn clean verify -Psample -Dserver=jetty9x -Ddatabase=derby -Dwebdriver.base.url=http://localhost:9090 > install.log 2>&1
REM call mvn clean verify -Psample,arq-jbossas-managed -Dserver=jboss7x -Dwebdriver.base.url=http://localhost:8180 > install.log 2>&1

REM OK call mvn -U -B clean install -Dserver=jetty9x > install.log 2>&1
REM OK call mvn -U -B clean install -Dserver=jetty9x -Dsurefire.useFile=false -Psample,coverage,integration,run-its,arq-weld-ee-embedded -Darquillian=arq-weld-ee-embedded -Darquillian.launch=arq-weld-ee-embedded > install.log 2>&1

REM TODO add property -Djacoco.outputDir=/workspace/users/albandri10/project/sample/interview/visma/gui/target -Ddatabase=derby -Dlog4j.configuration=log4j.properties -Dlog4j.debug=true 
REM DEBUG -Darquillian.debug=true
call mvn -U -B clean install -Dserver=jboss7x -Dsurefire.useFile=false -Psample,coverage,integration,run-its,arq-weld-ee-embedded -Dwebdriver.chrome.driver=/var/lib/chromedriver -Dwebdriver.base.url=http://localhost:8180 -Dlog4j.configuration=log4j.properties -Dlog4j.debug=true -Darquillian=arq-weld-ee-embedded -Darquillian.launch=arq-weld-ee-embedded -Darquillian.debug=true > install.log 2>&1
REM NOK call mvn -U -B clean install -Dserver=jboss7x -Dsurefire.useFile=false -Psample,coverage,integration,run-its,arq-jbossas-managed -Ddatabase=derby -Dwebdriver.chrome.driver=/var/lib/chromedriver -Dwebdriver.base.url=http://localhost:8180 -Darquillian=arq-jbossas-managed -Darquillian.launch=arq-jbossas-managed -Darquillian.debug=true > install.log 2>&1
REM TODO mvn -U -B clean install -Dserver=jetty9x -Dsurefire.useFile=false -Psample,coverage,integration,run-its,arq-jetty-embedded -Ddatabase=derby -Dwebdriver.chrome.driver=/var/lib/chromedriver -Dwebdriver.base.url=http://localhost:9090 -Darquillian=arq-jetty-embedded -Darquillian.launch=arq-jetty-embedded  > install.log

pause

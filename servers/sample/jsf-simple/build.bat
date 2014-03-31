cls

call setenv.bat 

REM use webdriver.chrome instead of webdriver.chrome.driver
REM OK call mvn clean verify -Psample -Dserver=tomcat7x -Ddatabase=derby -Dwebdriver.chrome.driver=/var/lib/chromedriver -Dwebdriver.base.url=http://home.nabla.mobi:8280 > install.log 2>&1
REM -Dwebdriver.chrome.driver="C:\chromedriver\chromedriver.exe" -Dwebdriver.firefox.bin="C:\Program Files\Mozilla Firefox\firefox.exe"
REM OK call mvn clean verify -Psample -Dserver=tomcat7x -Ddatabase=derby -Dwebdriver.base.url=http://home.nabla.mobi:8280 > install.log 2>&1
call mvn clean verify -Psample -Dserver=jetty9x -Ddatabase=derby -Dwebdriver.base.url=http://localhost:9090 > install.log 2>&1
REM call mvn clean verify -Psample -Dserver=jetty9x -Ddatabase=derby -Dwebdriver.base.url=http://localhost:9090 > install.log 2>&1
REM call mvn clean verify -Psample,arq-jbossas-managed -Dserver=jboss7x -Dwebdriver.base.url=http://localhost:8180 > install.log 2>&1

pause
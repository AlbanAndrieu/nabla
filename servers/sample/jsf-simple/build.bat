cls

call setenv.bat 
REM OK call mvn clean verify -Psample -Dserver=tomcat7x -Ddatabase=derby -Dwebdriver.base.url=http://localhost:8280 > install.log 2>&1
call mvn clean verify -Psample -Dserver=jetty9x -Ddatabase=derby > install.log 2>&1
REM call mvn clean verify -Psample -Dserver=jetty9x -Ddatabase=derby -Dwebdriver.base.url=http://localhost:9090 > install.log 2>&1
REM call mvn clean verify -Psample -Dserver=jboss7x > install.log 2>&1

pause
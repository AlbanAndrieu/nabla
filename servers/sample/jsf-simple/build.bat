cls

call setenv.bat 
REM call mvn clean verify -Psample -Dserver=tomcat7x -Ddatabase=derby > install.log 2>&1
call mvn clean verify -Psample -Dserver=jetty9x -Ddatabase=derby > install.log 2>&1

pause
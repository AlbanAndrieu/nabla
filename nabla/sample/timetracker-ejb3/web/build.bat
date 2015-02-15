cls

call setenv.bat 
REM call mvn clean install -Psample > install.log 2>&1
REM call mvn -U -B clean install -Psample,microcontainer-openejb > install.log 2>&1
call mvn -U -B clean install -Psample,arquillian,arq-jbossas-managed,jboss7x > install.log 2>&1

pause

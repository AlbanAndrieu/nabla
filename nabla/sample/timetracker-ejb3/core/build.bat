cls

call setenv.bat 
REM OK call mvn clean install -Psample -Dserver=jboss5x > install.log 2>&1
REM OK call mvn clean install -Pmicrocontainer-openejb -Dserver=jboss5x  > install.log 2>&1
REM NOK call mvn clean install -Pmicrocontainer-openejb -Dserver=jboss5x -Ddatabase=hsqldb > install.log 2>&1
REM NOK call mvn clean install -Pmicrocontainer-seam -Dserver=jboss5x  > install.log 2>&1
REM NOK call mvn -B clean install -Psample,arq-jbossas-managed,!microcontainer-openejb -Dserver=jboss5x > install.log 2>&1
call mvn -B clean install -Psample,arq-jbossas-managed -Dserver=jboss5x > install.log 2>&1

pause

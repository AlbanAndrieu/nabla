cls

call setenv.bat
REM OK call mvn clean install -Psample -Dserver=jboss5x > install.log 2>&1
REM OK call mvn clean install -Pmicrocontainer-openejb > install.log 2>&1
REM NOK call mvn clean install -Pmicrocontainer-openejb -Ddatabase=hsqldb > install.log 2>&1
REM NOK call mvn clean install -Pmicrocontainer-seam > install.log 2>&1
REM NOK call mvn -B clean install -Psample,arq-jbossas-managed,!microcontainer-openejb -Dserver=jboss5x > install.log 2>&1
REM OK call mvn -U -B install -Psample,microcontainer-openejb > install.log
REM OK call mvn -U -B clean install -Psample,arq-jbossas-managed > install.log 2>&1
REM OK mvn -U -B clean install -Psample,openejb,arq-jbossas-managed > install.log
REM OK call mvn -U -B clean install -Psample,microcontainer-openejb,arq-jbossas-managed > install.log 2>&1
call mvn -U -B clean install -Psample,microcontainer-openejb,arq-weld-ee-embedded > install.log 2>&1
REM ???? NOK MovieTest.java:217 FAILED call mvn -U -B clean install -Psample,openejb,arq-weld-ee-embedded > install.log 2>&1
REM OK call mvn -U -B clean install -Psample,openejb,arq-jbossas-managed > install.log 2>&1
call mvn -U -B clean install -P\!jacoco,sample,arquillian,arq-jbossas-managed,jboss7x,hibernate-4 -Darquillian=arq-jbossas-managed > install.log 2>&1

REM TO ADD in eclipse maven profile \!jacoco,sample,arquillian,arq-jbossas-managed,jboss7x -Dserver=jboss7x -Darquillian=arq-jbossas-managed

pause

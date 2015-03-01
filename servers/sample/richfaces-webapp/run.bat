cls

call setenv.bat

mvn clean install -Psample,arq-jbossas-managed,\!default -Dserver=jboss7x -Darquillian=arq-jbossas-managed > install.log
REM TODO mvn clean install -Psample,arq-weld-ee-embedded,\!default -Dserver=jboss7x -Darquillian=arq-weld-ee-embedded > install.log

REM TO ADD in eclipse maven profile \!jacoco,\!default,sample,arq-jbossas-managed,jboss7x -Dserver=jboss7x -Darquillian=arq-jbossas-managed

pause

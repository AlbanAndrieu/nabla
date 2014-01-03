cls
REM call mvn dependency:tree -Psample,arq-jbossas-managed -Dserver=jboss5x > dependency.log
call mvn help:effective-pom -Psample,arq-jbossas-managed -Dserver=jboss7x > effective.log
pause
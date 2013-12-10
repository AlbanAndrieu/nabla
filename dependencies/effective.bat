cls
REM call mvn dependency:tree -Psample,arq-jbossas-managed -Dserver=jboss5x > dependency.txt
call mvn help:effective-pom -Psample,arq-jbossas-managed -Dserver=jboss5x > effective.txt
pause
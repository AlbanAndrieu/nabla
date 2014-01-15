cls
REM call mvn dependency:tree -Psample,arq-jbossas-managed -Dserver=jboss5x > dependency.log
REM call mvn help:effective-pom -Psample,arq-jbossas-managed -Dserver=jboss7x > effective.log
REM call mvn help:effective-pom -Psample -Dserver=jetty9x > effective.log
REM call mvn help:effective-pom -Psample -Dserver=tomcat7x > effective.log
call mvn help:effective-pom -Psample -Dserver=jboss7x > effective.log
pause
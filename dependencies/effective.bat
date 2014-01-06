cls
REM call mvn dependency:tree -Dserver=jboss5x > dependency.log
call mvn help:effective-pom -Dserver=jetty9x > effective.log
pause
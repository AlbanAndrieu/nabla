cls
REM call mvn dependency:tree -Psample -Dserver=jboss5> dependency.log
call mvn help:effective-pom -Psample > effective.log
pause
cls
REM call mvn dependency:tree -Psample -Dserver=jboss5> dependency.txt
call mvn help:effective-pom -Psample -Dserver=jboss5 > effective.txt
pause
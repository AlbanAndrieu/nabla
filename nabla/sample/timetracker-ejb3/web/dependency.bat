cls
REM call mvn dependency:tree -Psample -Dserver=jboss5x -Ddatabase=h2 > dependency.log 2>&1
call mvn help:effective-pom -Psample -Dserver=jboss5x -Ddatabase=h2 > effective.log 2>&1
pause
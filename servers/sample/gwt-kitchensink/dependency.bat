cls
call mvn dependency:tree -Parq-jbossas-managed,with.test -Dserver=jboss7x -Ddatabase=derby > dependency.log  2>&1
REM call mvn help:effective-pom -Parq-jbossas-managed,with.test -Dserver=jetty9x -Ddatabase=derby > effective.log  2>&1
pause
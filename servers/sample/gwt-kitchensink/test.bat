cls
call mvn clean install -Parq-jbossas-managed -Dserver=jboss7 -Ddatabase=h2 > test.log
pause
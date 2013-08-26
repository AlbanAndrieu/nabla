cls

call setenv.bat
call mvn clean install -Pdefault,arq-jbossas-managed -Dserver=jboss7 -Ddatabase=h2 > install.log 2>&1
call mvn test -Parq-jbossas-managed,with.test -Dserver=jboss7 -Ddatabase=h2 > test.log 2>&1
pause
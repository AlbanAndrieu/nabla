cls

call setenv.bat
REM OK call mvn clean install -Pdefault,arq-jbossas-managed -Dserver=jboss7x -Ddatabase=derby > install.log 2>&1
REM OK call mvn test -Parq-jbossas-managed,with.test -Dserver=jboss7x -Ddatabase=h2 > test.log 2>&1
REM OK call mvn test -Parq-jbossas-managed,with.test -Dserver=jboss7x -Ddatabase=h2 > test.log 2>&1
REM NOK call mvn test -Parq-jbossas-managed,with.test -Dserver=jboss7x -Ddatabase=derby > test.log 2>&1
call mvn test -Parq-jbossas-managed,with.test -Dserver=jboss7x -Ddatabase=mysql > test.log 2>&1

pause
cls

call setenv.bat 

REM NOK PARSEDATETIME is not derby but H2 call mvn clean install -Psample -Dserver=jboss5x -Ddatabase=derby > install.log 2>&1
call mvn clean install -Psample,mda,arq-jbossas-managed -Dserver=jboss7x > install.log 2>&1

pause

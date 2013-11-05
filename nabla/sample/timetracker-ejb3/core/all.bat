cls

call setenv.bat
REM call mvn dependency:tree > dependency.log 2>&1
call mvn clean install -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > install.log 2>&1

pause
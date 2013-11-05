cls

call setenv.bat
call mvn dependency:tree > dependency.log
REM call mvn clean install -Psample,arq-jbossas-managed -Dserver=jboss5 > install.log

pause
cls

call setenv.bat
mvn clean install -Psample,arq-jbossas-managed,\!default -Dserver=jboss7x > install.log

pause

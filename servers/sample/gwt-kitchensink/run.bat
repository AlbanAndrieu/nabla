cls

call setenv.bat
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > deploy.log 2>&1

pause
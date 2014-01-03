cls

call setenv.bat
REM call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample,arq-jbossas-managed -Dserver=jetty9x -Ddatabase=derby > deploy.log 2>&1
REM NOK jboss and derby does not work call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample,arq-jbossas-managed -Ddatabase=derby > deploy.log 2>&1
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample,arq-jbossas-managed -Dserver=jetty7x> deploy.log 2>&1

pause
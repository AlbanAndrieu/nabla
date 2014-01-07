cls

call setenv.bat
REM OK call mvn org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=jetty9x -Ddatabase=derby > deploy.log 2>&1
REM TODO call mvn clean install org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM call mvn clean install tomcat7:run -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM OK mvn tomcat7:redeploy -Psample -Dserver=tomcat7x -Ddatabase=derby -Dtomcat.username=admin -Dtomcat.password=microsoft
REM OK mvn tomcat7:redeploy -Psample -Dserver=tomcat7x -Ddatabase=derby
#mvn org.codehaus.cargo:cargo-maven2-plugin:deployer-deploy -Psample -Dserver=tomcat7x -Ddatabase=derby
REM check result at http://192.168.0.29:8280/manager/html
REM call mvn jetty:run-war -Psample -Dserver=jetty9x -Ddatabase=derby -Djetty.port=9090 > deploy.log 2>&1

pause
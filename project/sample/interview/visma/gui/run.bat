cls

call setenv.bat
REM OK call mvn org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=jetty9x -Ddatabase=derby > deploy.log 2>&1
REM OK call mvn clean install org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=jetty9x -Ddatabase=derby > deploy.log 2>&1
REM TODO call mvn clean install org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM call mvn clean install tomcat7:run -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM OK clean mvn tomcat7:redeploy -Psample -Dserver=tomcat7x -Ddatabase=derby -Dtomcat.username=admin -Dtomcat.password=microsoft > deploy.log 2>&1
REM OK call mvn clean tomcat7:redeploy -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM call mvn clean install cargo:undeploy cargo:deploy -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM call mvn org.codehaus.cargo:cargo-maven2-plugin:deployer-deploy -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM check result at http://192.168.0.29:8280/manager/html
REM OK call clean install mvn jetty:run-war -Psample -Dserver=jetty9x -Ddatabase=derby -Djetty.port=9090 > deploy.log 2>&1
REM OK call mvn org.codehaus.cargo:cargo-maven2-plugin:run -Psample,arq-jbossas-managed -Dserver=jboss7x > deploy.log 2>&1

REM TO TEST mvn clean install org.codehaus.cargo:cargo-maven2-plugin:run -Dserver=jetty9x > deploy.log 2>&1

REM build with mvn clean install -Psample -Dserver=jetty9x
call java -jar target/dependency/jetty-runner.jar --port 9090 target/*.war

pause

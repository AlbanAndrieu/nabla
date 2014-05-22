cls

call setenv.bat
REM OK call mvn org.codehaus.cargo:cargo-maven2-plugin:run -Psample,run-its -Dserver=jetty9x -Ddatabase=derby > deploy.log 2>&1
REM OK call mvn clean install org.codehaus.cargo:cargo-maven2-plugin:run -Psample,run-its -Dserver=jetty9x -Ddatabase=derby > deploy.log 2>&1
REM TODO call mvn clean install org.codehaus.cargo:cargo-maven2-plugin:run -Psample,run-its -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM call mvn clean install tomcat7:run -Psample,run-its -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM OK clean mvn tomcat7:redeploy -Psample,run-its -Dserver=tomcat7x -Ddatabase=derby -Dtomcat.username=admin -Dtomcat.password=microsoft > deploy.log 2>&1
REM OK call mvn clean tomcat7:redeploy -Psample,run-its -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM call mvn clean install cargo:undeploy cargo:deploy -Psample,run-its -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM call mvn org.codehaus.cargo:cargo-maven2-plugin:deployer-deploy -Psample,run-its -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM check result at http://192.168.0.29:8280/manager/html
REM OK call clean install mvn jetty:run-war -Psample,run-its -Dserver=jetty9x -Ddatabase=derby -Djetty.port=9090 > deploy.log 2>&1
REM OK call mvn org.codehaus.cargo:cargo-maven2-plugin:run -Psample,run-its,arq-jbossas-managed -Dserver=jboss7x > deploy.log 2>&1

REM TO TEST mvn clean install -Dlog4j.configuration=log4j.properties -Dlog4j.debug=true -Prun-its,arq-weld-ee-embedded -Dtest=LoanServiceITest > deploy.log 2>&1
REM OK mvn -U -Dsurefire.useFile=false install -Psample,coverage,integration,run-its,arq-weld-ee-embedded -Djacoco.outputDir=~/project/sample/interview/visma/target -Ddatabase=derby -Dserver=jboss7x -Dwebdriver.chrome.driver=/var/lib/chromedriver -Dwebdriver.base.url=http://localhost:8180 -Dlog4j.configuration=log4j.properties -Dlog4j.debug=true -Darquillian=arq-weld-ee-embedded -Darquillian.launch=arq-weld-ee-embedded > deploy.log 2>&1
REM TO RUN mvn clean install org.codehaus.cargo:cargo-maven2-plugin:run -Dserver=jetty9x > deploy.log 2>&1

REM build with mvn clean install -Psample,run-its -Dserver=jetty9x
call java -jar target/dependency/jetty-runner.jar --port 9090 target/*.war

pause

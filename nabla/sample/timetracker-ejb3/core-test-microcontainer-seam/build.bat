cls

call setenv.bat 
REM call mvn clean install -Psample -Dserver=jboss5x -Ddatabase=hsqldb > install.log 2>&1
call mvn clean install -Psample -Dserver=jboss5x -Ddatabase=h2 > install.log 2>&1

REM if org.jboss.deployers.spi.DeploymentException: Error determining structure: jboss-local-jdbc.rar make sure to use maven-hotdeploy-plugin

pause
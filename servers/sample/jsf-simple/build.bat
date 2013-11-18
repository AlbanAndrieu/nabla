cls

call setenv.bat 
call mvn clean verify -Psample -Dserver=tomcat7x -Ddatabase=derby > install.log 2>&1
REM call mvn org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
call mvn jetty:run-war -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1

pause
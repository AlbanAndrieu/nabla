cls

call setenv.bat
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=jetty9x -Ddatabase=derby > deploy.log 2>&1
REM call mvn jetty:run-war -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1

pause
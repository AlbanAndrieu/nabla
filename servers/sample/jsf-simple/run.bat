cls

call setenv.bat
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=jetty9x -Ddatabase=derby > deploy.log 2>&1
REM TODO call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
REM check result at http://192.168.0.29:8280/manager/html
REM call mvn jetty:run-war -Psample -Dserver=jetty9x -Ddatabase=derby -Djetty.port=9090 > deploy.log 2>&1

pause
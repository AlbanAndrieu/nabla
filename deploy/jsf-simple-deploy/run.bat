cls

call setenv.bat
REM call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1
call mvn cargo:deploy -Dserver=tomcat7x -Ddatabase=derby > deploy.log 2>&1

pause
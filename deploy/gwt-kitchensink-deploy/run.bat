cls

call setenv.bat
REM call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run > deploy.log 2>&1
call mvn cargo:deploy -Ptomcat7x > deploy.log 2>&1

pause
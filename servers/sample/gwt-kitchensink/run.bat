cls

call setenv.bat
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run > deploy.log 2>&1

pause
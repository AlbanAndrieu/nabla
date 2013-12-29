cls

call setenv.bat
call mvn clean install site deploy site:deploy > install.log 2>&1

pause
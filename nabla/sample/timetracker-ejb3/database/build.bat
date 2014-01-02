cls

call setenv.bat 
call mvn clean install -Psample > install.log 2>&1

pause
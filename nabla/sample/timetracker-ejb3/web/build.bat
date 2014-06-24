cls

call setenv.bat 
REM call mvn clean install -Psample > install.log 2>&1
call mvn -U -B clean install -Psample,microcontainer-openejb > install.log 2>&1

pause

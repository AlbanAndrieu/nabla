cls

call setenv.bat 
call mvn clean install -Psample -Dserver=jboss5x -Ddatabase=h2 > install.log 2>&1

pause
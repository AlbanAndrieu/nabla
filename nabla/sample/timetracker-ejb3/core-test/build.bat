cls

call setenv.bat 
call mvn clean install -Psample > install.log 2>&1
REM OK call mvn clean install -Pmicrocontainer-openejb > install.log 2>&1
REM NOK call mvn clean install -Pmicrocontainer-openejb -Ddatabase=hsqldb > install.log 2>&1
REM NOK call mvn clean install -Pmicrocontainer-seam  > install.log 2>&1

pause

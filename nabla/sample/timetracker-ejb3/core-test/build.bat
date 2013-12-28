cls

call setenv.bat 
call mvn clean install -Psample -Dserver=jboss5x -Ddatabase=h2 > install.log 2>&1
REM OK call mvn clean install -Pmicrocontainer-openejb -Dserver=jboss5x -Ddatabase=h2 > install.log 2>&1
REM NOK call mvn clean install -Pmicrocontainer-openejb -Dserver=jboss5x -Ddatabase=hsqldb > install.log 2>&1
REM NOK call mvn clean install -Pmicrocontainer-seam -Dserver=jboss5x -Ddatabase=h2 > install.log 2>&1

pause
cls

call setenv.bat
call mvn clean > clean.log 2>&1
REM call mvn install > install.log 2>&1
call mvn clean clover2:setup clover2:optimize test clover2:snapshot -Psample,arq-jbossas-managed -Ddatabase=derby > install.log 2>&1

pause
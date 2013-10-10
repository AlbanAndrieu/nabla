cls

call setenv.bat
call mvn help:effective-pom -Psample,arq-jbossas-managed -Ddatabase=derby > effective.log
pause

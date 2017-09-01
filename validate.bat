cls

call setenv.bat
call mvn -Psample,arq-jbossas-managed -Dserver=jboss5 -Ddatabase=derby validate > validate.log 2>&1

pause

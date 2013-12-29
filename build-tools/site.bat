cls

call setenv.bat
rem call mvn site -Psample,integration,arq-jbossas-managed -Dserver=jboss7x -Ddatabase=h2 > site.log 2>&1
call mvn site -Psample,integration,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > site.log 2>&1
rem call mvn site:deploy -Psample

pause

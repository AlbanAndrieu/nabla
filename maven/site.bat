cls

call setenv.bat
rem call mvn site -Psample,integration,arq-jbossas-managed -Dserver=jboss7 -Ddatabase=h2 > site.log
call mvn site -Psample,integration,arq-jbossas-managed -Dserver=jboss5 -Ddatabase=derby > site.log 2>&1
rem call mvn site:deploy -Psample

pause

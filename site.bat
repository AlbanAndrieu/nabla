cls

call setenv.bat
rem call mvn site -Psample,integration,arq-jbossas-managed -Dserver=jboss7 -Ddatabase=h2 > site.log
call mvn site -Psample,integration,arq-jbossas-managed > site.log
call mvn site:deploy

pause

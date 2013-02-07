cls

call setenv.bat
REM call mvn clean jalopy:format install deploy site site:deploy -Pmaven-2-site,sample
call mvn clean install -Psample,arq-jbossas-managed -Dserver=jboss5 -Ddatabase=derby > install.log 2>&1

pause
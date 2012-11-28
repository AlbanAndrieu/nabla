cls

call setenv.bat
REM call mvn clean jalopy:format install deploy site site:deploy -Pmaven-2-site,sample
call mvn clean install -Psample,arq-jbossas-managed -Dserver=jboss7 -Ddatabase=h2 > install.log

pause
cls

call setenv.bat
REM call mvn clean jalopy:format install deploy site site:deploy -Pmaven-2-site,sample
call mvn clean verify -Psample,arq-jbossas-managed -Dserver=jetty9x -Ddatabase=derby -Derrai.devel.debugCacheDir=target/errai > install.log 2>&1

pause

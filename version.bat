cls

call setenv.bat
call mvn versions:set -DnewVersion=1.0.1-SNAPSHOT -Psample,arq-jbossas-managed -Dserver=jboss5 -Ddatabase=derby > version.log 2>&1

pause
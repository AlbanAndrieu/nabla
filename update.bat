cls

call setenv.bat
REM call mvn versions:display-dependency-updates -Psample,arq-jbossas-managed -Dserver=jboss7x -Ddatabase=derby > dependency-updates.log 2>&1
call mvn -X versions:display-plugin-updates -Psample,arq-jbossas-managed -Dserver=jboss7x -Ddatabase=derby > plugin-updates.log 2>&1
REM call mvn scm:validate -Psample,arq-jbossas-managed -Dserver=jboss7x -Ddatabase=derby > scm-validate.log 2>&1

pause

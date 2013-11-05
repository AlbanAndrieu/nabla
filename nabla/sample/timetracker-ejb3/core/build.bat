cls

call mvn clean install -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > install.log 2>&1

pause
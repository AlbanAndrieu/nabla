cls

call mvn -e andromdapp:schema -Dtasks=drop -Psample -Dserver=jboss5x -Ddatabase=h2 > schema-drop.log
call mvn -e andromdapp:schema -Dtasks=create -Psample -Dserver=jboss5x -Ddatabase=h2  > schema-create.log
call mvn -e andromdapp:schema -Dtasks=update -Psample -Dserver=jboss5x -Ddatabase=h2 > schema-update.log
call mvn -e andromdapp:schema -Dtasks=validate -Psample -Dserver=jboss5x -Ddatabase=h2 > schema-validate.log

pause
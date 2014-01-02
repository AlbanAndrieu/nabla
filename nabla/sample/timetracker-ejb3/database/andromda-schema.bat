cls

call mvn -e andromdapp:schema -Dtasks=drop -Psample > schema-drop.log
call mvn -e andromdapp:schema -Dtasks=create -Psample > schema-create.log
call mvn -e andromdapp:schema -Dtasks=update -Psample > schema-update.log
call mvn -e andromdapp:schema -Dtasks=validate -Psample > schema-validate.log

pause
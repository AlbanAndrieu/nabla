cls
call mvn -e andromdapp:schema -Dtasks=drop > schema-drop.log
call mvn -e andromdapp:schema -Dtasks=create > schema-create.log
call mvn -e andromdapp:schema -Dtasks=update > schema-update.log
rem call mvn -e andromdapp:schema -Dtasks=validate > schema-validate.log
pause
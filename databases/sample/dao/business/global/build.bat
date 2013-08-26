cls

call mvn clean
call mvn install -Pcreate_db -Ddatabase=derby > create_db.log 2>&1
call mvn install -Pdbunit_import -Ddatabase=derby > dbunit_import.log 2>&1
call mvn install -Pdbunit_export -Ddatabase=derby > dbunit_export.log 2>&1
call mvn install -Psql -Ddatabase=derby > sql.log 2>&1
call mvn install -Phibernate3 -Ddatabase=derby > hibernate3.log 2>&1
call mvn install -Ddatabase=derby > install.log 2>&1

pause
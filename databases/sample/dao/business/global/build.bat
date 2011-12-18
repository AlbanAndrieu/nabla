cls

call mvn clean
call mvn install -Phibernate3
call mvn install -Pcreate_db
call mvn install -Pdbunit_import
rem call mvn install -Psql
call mvn install
call mvn install -Pdbunit_export

pause
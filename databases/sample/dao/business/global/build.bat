cls

call mvn clean
call mvn install -Pcreate_db
call mvn install -Pdbunit_import
call mvn install -Pdbunit_export
rem call mvn install

pause
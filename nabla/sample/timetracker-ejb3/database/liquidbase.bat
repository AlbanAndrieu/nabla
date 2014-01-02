cls

call setenv.bat 
call mvn liquibase:diff -Psample > liquibase-diff.log 2>&1
call mvn liquibase:dbDoc -Psample > liquibase-dbDoc.log 2>&1
call mvn liquibase:update -Psample > liquibase-update.log 2>&1
REM see result in target\liquibase\dbDoc\index.html

pause
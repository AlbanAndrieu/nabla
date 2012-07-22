cls
call mvn dependency:tree > dependency.log
call mvn help:effective-pom > effective.log
call mvn initialize -Pshow-properties > properties.log
pause
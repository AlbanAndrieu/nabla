cls
call mvn validate
call mvn help:active-profiles > profile.log
call mvn dependency:tree > dependency.log
call mvn dependency:analyze > analyze.log
call mvn help:effective-pom > effective.log
call mvn initialize -Pshow-properties > properties.log
pause
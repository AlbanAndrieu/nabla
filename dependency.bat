cls
call mvn validate -Psample
call mvn help:active-profiles -Psample > profile.log
call mvn dependency:tree -Psample > dependency.log
call mvn dependency:analyze -Psample > analyze.log
call mvn help:effective-pom -Psample > effective.log
call mvn initialize -Pshow-properties,sample > properties.log
pause
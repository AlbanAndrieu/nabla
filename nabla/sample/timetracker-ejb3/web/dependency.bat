cls
REM call mvn validate -Psample
REM call mvn help:active-profiles -Psample > profile.log
REM call mvn -U -B dependency:tree -Psample,arq-jbossas-managed > dependency.log
call mvn -U -B dependency:tree -Psample,microcontainer-openejb > dependency.log 2>&1
REM call mvn -B dependency:tree -Psample,coverage,integration,run-its,arq-weld-ee-embedded > dependency.log
REM call mvn dependency:analyze -Psample > analyze.log
REM call mvn help:effective-pom -Psample > effective.log
REM call mvn initialize -Pshow-properties,sample > properties.log
pause

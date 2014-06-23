cls
REM call mvn validate -Psample
REM call mvn help:active-profiles -Psample > profile.log
REM call mvn -U dependency:tree -Psample,arq-jbossas-managed -Dserver=jboss5x > dependency.log
call mvn -B dependency:tree -Psample,coverage,integration,run-its,arq-weld-ee-embedded -Dserver=jboss5x > dependency.log
REM call mvn dependency:analyze -Psample > analyze.log
REM call mvn help:effective-pom -Psample > effective.log
REM call mvn initialize -Pshow-properties,sample > properties.log
pause

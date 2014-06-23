cls
call mvn validate -Psample
call mvn help:active-profiles -Psample > profile.log
call mvn dependency:tree -Psample > dependency.log
call mvn dependency:analyze -Psample > analyze.log
call mvn help:effective-pom -Psample > effective.log
call mvn initialize -Pshow-properties,sample > properties.log
REM call mvn -U dependency:tree -Dsurefire.useFile=false -Psample,coverage,integration,run-its,arq-weld-ee-embedded -Ddatabase=derby -Dserver=jetty9x -Dwebdriver.chrome.driver=/var/lib/chromedriver -Dwebdriver.base.url=http://localhost:9090 -Dlog4j.configuration=log4j.properties -Dlog4j.debug=true -Darquillian=arq-weld-ee-embedded -Darquillian.launch=arq-weld-ee-embedded > dependency.log
pause

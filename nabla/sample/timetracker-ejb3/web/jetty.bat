cls
setlocal
set MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000 %MAVEN_OPTS%
call mvn jetty:run > jetty.log 2>&1
REM call mvn jetty:start
REM call mvn jetty:stop
pause
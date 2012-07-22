cls
REM call setenv.bat
set MAVEN_OPTS=-Xmx1024m
call mvn -f mda/pom.xml andromda:start-server > server.log
REM call mvn -f mda/pom.xml andromda:stop-server
pause
cls
REM call setenv.bat
set MAVEN_OPTS=-Xmx1024m
REM call mvn -f mda/pom.xml andromda:start-server > server.log
call mvn -f mda/pom.xml andromda:start-server > server.log
REM call mvn -f mda/pom.xml andromda:start-server
REM call mvn -f mda/pom.xml andromda:stop-server
REM call ant -f ./build.xml > ant.txt
pause
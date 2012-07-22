cls
setlocal
REM add following jar in eclipse debugger C:\repo\org\andromda\metafacades\andromda-metafacades-emf-uml22\3.4\andromda-metafacades-emf-uml22-3.4-sources.jar
REM set MAVEN_OPTS="-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8797";
set MAVEN_OPTS=-classic -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8797,server=y,suspend=y %MAVEN_OPTS%
REM call mvn -o andromda:run
call mvn -o install
pause
cls
REM call setenv.bat
set MAVEN_OPTS=-Xmx1024m
REM http://www.andromda.org/docs/andromda-cartridges/andromda-ejb3-cartridge/project.html
call mvn org.andromda.maven.plugins:andromdapp-maven-plugin:generate
pause
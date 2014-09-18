cls

set TMP_VAR=%~dp0

set M2_REPO=${env.WORKSPACE}/.m2/repository
set JAVACMD=%JAVA_HOME%/bin/java
REM set PROJECT_DEV=%PROJECT_DEV%/xml
set PROJECT_DEV=${PROJECT_HOME}/${PROJECT_USER}${PROJECT_MAJOR_VERSION}
set SAXONPATH=%M2_REPO%\net\sf\saxon\saxon\8.7\saxon-8.7.jar

%JAVACMD% -cp %SAXONPATH% net.sf.saxon.Transform -w1 %PROJECT_DEV%\navigation.xml .\filesGenerator-winnt.xsl generationDirectory=%TMP_VAR% > generate.log

pause

cls

set TMP_VAR=%~dp0

REM set M2_REPO=${env.WORKSPACE}/.repository
set M2_REPO=C:\repo
set JAVACMD=%JAVA_HOME%/bin/java
REM set PROJECT_DEV=%PROJECT_DEV%/xml
set PROJECT_DEV=C:\workspace\users\albandri33\kgr\trunk\src\java\kgr-war\xml
set SAXONPATH=%M2_REPO%\net\sf\saxon\saxon\8.7\saxon-8.7.jar

%JAVACMD% -cp %SAXONPATH% net.sf.saxon.Transform -w1 %PROJECT_DEV%\navigation.xml .\filesGenerator-winnt.xsl generationDirectory=%TMP_VAR% > generate.log

pause

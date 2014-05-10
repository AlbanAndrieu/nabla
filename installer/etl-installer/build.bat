cls

call setenv.bat
REM set DEFAULT_JAVA_DEBUG_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
REM java %DEFAULT_JAVA_DEBUG_OPTS% -jar target\izpack-tomcat-1.0-SNAPSHOT-standard.jar %*
REM call mvn izpack:izpack > install.log 2>&1
call mvn clean install > install.log 2>&1

pause
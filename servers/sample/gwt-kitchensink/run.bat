cls

call setenv.bat
REM call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample,arq-jbossas-managed -Dserver=jboss7x > deploy.log 2>&1
REM NOK jboss and derby does not work call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample,arq-jbossas-managed -Dserver=jboss7x -Ddatabase=derby > deploy.log 2>&1
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=jetty7x -Derrai.devel.debugCacheDir=target/errai > deploy.log 2>&1
REM call mvn jetty:run-war -Psample -Dserver=jetty9x -Ddatabase=derby -Djetty.port=9090 > deploy.log 2>&1
REM set in JAVA_OPTS
REM -Derrai.devel.debugCacheDir=/tmp/Errai
REM -Derrai.devel.debugCacheDir=target/errai

mvn clean install -Psample,arq-jbossas-managed,with.test -Dserver=jboss7x -Derrai.devel.debugCacheDir=target/errai > install.log

pause

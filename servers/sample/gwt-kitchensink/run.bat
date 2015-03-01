cls

call setenv.bat
REM call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample,arq-jbossas-managed -Dserver=jboss7x > deploy.log 2>&1
REM NOK jboss and derby does not work call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample,arq-jbossas-managed -Dserver=jboss7x -Ddatabase=derby > deploy.log 2>&1
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Psample -Dserver=jetty7x -Derrai.devel.debugCacheDir=target/errai > deploy.log 2>&1
REM call mvn jetty:run-war -Psample -Dserver=jetty9x -Ddatabase=derby -Djetty.port=9090 > deploy.log 2>&1
REM set in JAVA_OPTS
REM -Derrai.devel.debugCacheDir=/tmp/Errai
REM -Derrai.devel.debugCacheDir=target/errai

REM OK with arq-jbossas-managed BUT NOK with arq-weld-ee-embedded
mvn clean install -Psample,arq-jbossas-managed,with.test -Dserver=jboss7x -Darquillian=arq-jbossas-managed -Derrai.devel.debugCacheDir=target/errai > install.log
REM TODO mvn clean install -Psample,arq-weld-ee-embedded,with.test -Dserver=jboss7x -Darquillian=arq-weld-ee-embedded -Derrai.devel.debugCacheDir=target/errai > install.log

REM TO ADD in eclipse maven profile \!jacoco,sample,arq-jbossas-managed,jboss7x,with.test -Dserver=jboss7x -Darquillian=arq-jbossas-managed

pause

cls

call setenv.bat
call mvn clean install > install.log 2>&1

call mvn deploy:deploy-file -DgroupId=com.sybase -DartifactId=jconn3 -Dversion=7.0.7 -Dpackaging=jar "-Dfile=target/downloads/jconn3.jar" -DrepositoryId=nexus-releases -Durl=http://home.nabla.mobi:8081/nexus/content/repositories/releases

pause

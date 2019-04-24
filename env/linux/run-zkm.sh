#!/bin/bash
set -xv

# See https://www.zelix.com/klassmaster/docs/buildToolMaven.html

export ZKM_HOME=/opt/zkm
sudo mkdir -p ${ZKM_HOME}

cd ${ZKM_HOME}
wget --no-check-certificate https://kgrdb01.misys.global.ad/download/zkm/ZKM.jar
chmod +x ${ZKM_HOME}/ZKM.jar

wget --no-check-certificate https://www.zelix.com/klassmaster/download/zkm-plugin-1.0.3.jar

mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -D"file=/opt/zkm/zkm-plugin-1.0.3.jar" -D"ZKM_HOME=${ZKM_HOME}"
mvn deploy:deploy-file -DgroupId=com.zelix.plugins -DartifactId=zkm-plugin -Dversion=1.0.3 -Dpackaging=jar "-Dfile=/opt/zkm/zkm-plugin-1.0.3.jar" -DrepositoryId=nexus-releases -Durl=http://home.nabla.mobi:8081/nexus/content/repositories/releases
mvn deploy:deploy-file -DgroupId=com.zelix.plugins -DartifactId=zkm -Dversion=12.0.0 -Dpackaging=jar "-Dfile=/opt/zkm/ZKM.jar" -DrepositoryId=nexus-releases -Durl=http://home.nabla.mobi:8081/nexus/content/repositories/releases

mvn package -D"ZKM_HOME=${ZKM_HOME}"

# See https://blog.netspi.com/java-obfuscation-tutorial-with-zelix-klassmaster/

exit 0

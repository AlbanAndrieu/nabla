#!/bin/bash
set -xv

# See https://www.zelix.com/klassmaster/docs/buildToolMaven.html

export ZKM_HOME=/opt/zkm
sudo mkdir -p ${ZKM_HOME}

cd ${ZKM_HOME}
wget --no-check-certificate https://kgrdb01.misys.global.ad/download/zkm/ZKM.jar
chmod +x ${ZKM_HOME}/ZKM.jar

wget --no-check-certificate https://www.zelix.com/klassmaster/download/zkm-plugin-1.0.3.jar

mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -D"file=zkm-plugin-1.0.3.jar" -D"ZKM_HOME=${ZKM_HOME}"

mvn package -D"ZKM_HOME=${ZKM_HOME}"

# See https://blog.netspi.com/java-obfuscation-tutorial-with-zelix-klassmaster/

exit 0

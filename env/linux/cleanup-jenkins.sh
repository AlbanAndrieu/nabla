#!/bin/bash
set -xv

echo "Start cleaning jenkins"

#setenv JENKINS_HOME "/media/jenkins"
export JENKINS_HOME="/jenkins"
export JENKINS_SLAVE_HOME="/jenkins-slave"

rm -Rf ${JENKINS_HOME}/.jenkins
rm -Rf ${JENKINS_HOME}/.sonar
rm -Rf ${JENKINS_HOME}/.caches
#rm -Rf /media/backup/jenkins/thin/*

rm -Rf ${JENKINS_HOME}/.m2/.repository
rm -Rf .npm/ .node_cache/ .node_tmp/  .tmp/ .bower/ bower_components/ node node_modules/ .sass-cache/ package-lock.json yarn.lock target/
rm -f /var/log/jenkins/jenkins.*.gz
#rm -Rf ${JENKINS_HOME}/config-history/*
#rm -Rf /var/lib/jenkins/tools/hudson.model.JDK/*
#rm -Rf /var/lib/jenkins/tools/*
#sudo find ${JENKINS_SLAVE_HOME} -type d -name 'workspace' | grep -v 'builds' | xargs sudo rm -r $1
#rm -Rf /jenkins-slave
rm -Rf ${JENKINS_SLAVE_HOME}/maven-repositories/0/
#rm -Rf ${JENKINS_HOME}/maven-repositories/0/org/owasp
rm -Rf ${JENKINS_SLAVE_HOME}/maven-repositories/0/org/owasp
rm -Rf ${JENKINS_SLAVE_HOME}/workspace
#rm -Rf ${JENKINS_HOME}/xvfb-*.fbdir/
find ${JENKINS_SLAVE_HOME}/xvfb-*.fbdir -mtime +30 -exec rm -rv {} \;
rm -f ${JENKINS_HOME}/audit.log.*
rm -f ${JENKINS_HOME}/*.out
rm -f ${JENKINS_HOME}/logs/tasks/*.log*
rm -Rf /etc/init.d/slave.jar*
#rm -Rf ${JENKINS_HOME}/workspace-tmp

#Clean X lock
rm -Rf /tmp/.X*-lock && rm -Rf /tmp/.X11-unix

find ${JENKINS_HOME}/jobs -name 'outOfOrderBuilds' -type d -exec rm -rv {} \;
find ${JENKINS_HOME}/jobs -name 'htmlreports' -type d -exec rm -rv {} \;
#todo remove ${JENKINS_HOME}/jobs/nabla-servers-bower-sample-nightly/htmlreports/GC_Report
#AND
#${JENKINS_HOME}/jobs/nabla-servers-bower-sample-nightly/htmlreports/HAR_Report
find ${JENKINS_HOME}/jobs -size +500M -mtime +180 -type f -print
#find ${JENKINS_HOME}/jobs -size +500M -mtime +180 -type f -print | xargs rm -r $1

#sudo rm -Rf /jenkins/users/*

echo "End cleaning jenkins"

exit 0

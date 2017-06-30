#!/bin/bash
set -xv

echo "Start cleaning jenkins"

\rm -Rf ~/.jenkins
\rm -Rf ~/.sonar
#\rm -Rf /backup/jenkins/thin/*

\rm -Rf /jenkins/.m2/.repository
\rm -f /var/log/jenkins/jenkins.*.gz
#\rm -Rf /jenkins/config-history/*
#\rm -Rf /var/lib/jenkins/tools/hudson.model.JDK/*
#\rm -Rf /var/lib/jenkins/tools/*
#sudo find /jenkins -type d -name 'workspace' | grep -v 'builds' | xargs sudo rm -r $1
#\rm -Rf /jenkins-slave
\rm -Rf /jenkins/maven-repositories/0/
#\rm -Rf /jenkins/maven-repositories/0/org/owasp
\rm -Rf /jenkins-slave/maven-repositories/0/org/owasp
\rm -Rf /jenkins-slave/workspace
#\rm -Rf /jenkins/xvfb-*.fbdir/
rm -f /jenkins/audit.log.*
rm -f /jenkins/ *.out
rm -f /jenkins/logs/tasks/*.log*
rm -Rf /etc/init.d/slave.jar*
#\rm -Rf /jenkins/workspace-tmp

find /jenkins/jobs -name 'outOfOrderBuilds' -type d | xargs rm -r $1
find /jenkins/jobs -name 'htmlreports' -type d | xargs rm -r $1
#todo remove /jenkins/jobs/nabla-servers-bower-sample-nightly/htmlreports/GC_Report
#AND
#/jenkins/jobs/nabla-servers-bower-sample-nightly/htmlreports/HAR_Report
find /jenkins/jobs -size +500M -mtime +180 -type f -print
#find /jenkins/jobs -size +500M -mtime +180 -type f -print | xargs rm -r $1

echo "End cleaning jenkins"

exit 0

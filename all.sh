#!/bin/bash -xv

#mvn help:effective-pom 2>&1 > effective.log
mvn clean install -Psample,arq-jbossas-managed -Dserver=jboss5 -Ddatabase=derby 2>&1 > install.log

exit 0

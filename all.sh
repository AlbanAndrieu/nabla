#!/bin/bash -xv

#mvn help:effective-pom 2>&1 > effective.log
mvn clean verify -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby 2>&1 > install.log

exit 0

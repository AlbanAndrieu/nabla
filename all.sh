#!/bin/bash -xv

#mvn help:effective-pom 2>&1 > effective.log

#aaaffdsfa
afsafsdf
mvn clean verify deploy -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby 2>&1 > install.log
afafafsafiufosfas

exit 0

#!/bin/bash

TMP_VAR=`pwd`

export M2_REPO=${env.WORKSPACE}/.repository
export JAVACMD=${JAVA_HOME}/bin/java
export PROJECT_DEV=${PROJECT_DEV}/xml
export PROJECT_DEV=/workspace/users/albandri33/kgr/trunk/src/java/kgr-war/xml
export SAXONPATH=${M2_REPO}/net/sf/saxon/saxon/8.7/saxon-8.7.jar

${JAVACMD} -cp ${SAXONPATH} net.sf.saxon.Transform -w1 ${PROJECT_DEV}/navigation.xml ./filesGenerator-unix.xsl generationDirectory="$TMP_VAR"

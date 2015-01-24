#!/bin/ksh
#
#=========================================================================
#
#	Nabla Installation Script
#	Publisher		: Nabla LTD.
#	Author			:
#	Updated By		: 
#	Last Updated		:
#	Reason			: 
#
#=========================================================================
JV_OK=1
JAVA_HOME=""
JVHOME=""
JAVA_MIN_GREP="1\.[6|7|8]\.0"
for JVHOME in $JAVA_HOME / /usr/lib/jvm/java-8-oracle /usr/lib/jvm/java-7-oracle /usr /usr/java /opt/* 
do
	[ ! -x $JVHOME/bin/java ] && continue
        $JVHOME/bin/java -version 2>&1 | grep "$JAVA_MIN_GREP" >/dev/null && JV_OK=0 &&  echo $JVHOME/bin/java is ok... && break

done
export JVHOME
$JVHOME/bin/java -jar target/FRONTERInstaller.jar $*

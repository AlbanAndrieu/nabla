#!/bin/sh -f

# User specific aliases and functions
# The following are the environment variables for Java, ANT and JBoss

# JAVA
#JDK_HOME=/usr/lib/jvm/ia32-java-6-sun-1.6.0.06/
#JDK_HOME=${DRIVE_PATH}/Sun/SDK/jdk
ln -s ${DRIVE_PATH}/Program\ Files\ \(x86\) /ProgramFilesx86
#export JAVA_HOME="${DRIVE_PATH}/Program Files (x86)/Java/jdk1.5.0_22"
##export JAVA_HOME="/ProgramFilesx86/Java/jdk1.5.0_22"
export JAVA_HOME="${DRIVE_PATH}/Sun/SDK/jdk"
export JRE_HOME=${JAVA_HOME}/jre
#export JDK_HOME JRE_HOME JAVA_HOME
#export JAVA=$JAVA_HOME/bin/java
#PATH=${JDK_HOME}/bin:${JRE_HOME}/bin:${PATH}
PATH=${JAVA_HOME}/bin:${PATH}
export PATH

export JAVA_OPTS="-Xms256m -Xmx1548m"

# MAVEN
#export M2_HOME="${DRIVE_PATH}/apache-maven-3.0.2"
export M2_HOME="${DRIVE_PATH}/apache-maven-2.2.1"
export M2=${M2_HOME}/bin
export MAVEN_OPTS="-Xms512m -Xmx1024m"
#export MAVEN_OPTS="-Xmx512M -XX:MaxPermSize=1024M"
export PATH=${M2}:$PATH
export M2_REPO=${DRIVE_PATH}/repo
echo "Maven repo are in : ${M2_REPO}"

# ANT 
export ANT_HOME="${DRIVE_PATH}/apache-ant-1.8.0"
export ANT_OPTS="-Xmx512m"
export PATH=${ANT_HOME}/bin:${ANT_HOME}/lib:$PATH

# JBOSS
export JBOSS_HOME="${DRIVE_PATH}/jboss-4.2.2.GA"
export PATH=${JBOSS_HOME}/bin:$PATH

export CATALINA_HOME=${JBOSS_HOME}/server/default
#export CATALINA_OPTS="-Dappserver.home=$CATALINA_HOME -Dappserver.base=$CATALINA_HOME"
alias jboss='${JBOSS_HOME}/bin/run.sh > ${PROJECT_DEV}/jboss.txt'

# ECLIPSE
export ECLIPSE_HOME=${DRIVE_PATH}/eclipse-3.5
export PATH=${ECLIPSE_HOME}:$PATH
alias eclipse='${ECLIPSE_HOME}/eclipse'

# LUMBERMILL
export LUMBERMILL_HOME="${DRIVE_PATH}/lumbermill-2.0-b3"
#export PATH=$PATH:${LUMBERMILL_HOME}/bin
alias lumbermill='java -jar ${LUMBERMILL_HOME}/dist/lib/lumbermill.jar'
echo "Lumbermill port is 4430"

# LUMBERMILL
export PATH=${LUMBERMILL_HOME}/bin:${PATH}

# GRAPHVIZ
export PATH=${GRAPHVIZ_HOME}/bin:${PATH}

# TIBCO
export PATH=${TIBCO_HOME}/bin:${PATH}

# WINDOWS
export PATH=$PATH:${DRIVE_PATH}/Windows/system32:${DRIVE_PATH}/Windows


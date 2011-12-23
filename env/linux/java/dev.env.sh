#!/bin/sh -f

#setenv PATH ${MAVEN_DIR}/bin:${PATH}
# User specific aliases and functions
# The following are the environment variables for Java, ANT and JBoss

# JAVA
#JDK_HOME=/usr/lib/jvm/ia32-java-6-sun-1.6.0.06/
#JDK_HOME=${DRIVE_PATH}Sun/SDK/jdk
#ln -s ${DRIVE_PATH}Program\ Files\ \(x86\) /ProgramFilesx86
#export JAVA_HOME="${DRIVE_PATH}Program Files (x86)/Java/jdk1.5.0_22"
#export JAVA_HOME="/ProgramFilesx86/Java/jdk1.5.0_22"
export JAVA_HOME=/usr/lib/jvm/java-1.6.0-openjdk
export JRE_HOME=${JAVA_HOME}/jre
PATH=${JAVA_HOME}/bin:${PATH}
export PATH

#export JAVA_OPTS="-Xms128m -Xmx128m -XX:MaxPermSize=128m"
#export JAVA_OPTS="-Xms256m -Xmx512m -XX:PermSize=1024m -XX:MaxPermSize=1024m" 
export JAVA_OPTS="-Xms256m -Xmx1548m"

# MAVEN
# config is in /etc/maven2
export M2_HOME="${DRIVE_PATH}/usr/share/maven2"
export M2=${M2_HOME}/bin
#export MAVEN_OPTS="-Xms256m -Xmx512m"
#export MAVEN_OPTS="-Xms512m -Xmx1024m"
export MAVEN_OPTS=-Xmx1548m
export PATH=${M2}:$PATH
export M2_REPO=${DRIVE_PATH}repo
echo "Maven repo are in : ${M2_REPO} and settings in /etc/maven2 to ${HOME}/.m2"

# ANT 
export ANT_OPTS="-Xmx512m"
export ANT_HOME="${DRIVE_PATH}/usr/share/ant"
export PATH=${ANT_HOME}/bin:${ANT_HOME}/lib:$PATH

# JBOSS
export JBOSS_HOME="${DRIVE_PATH}/jboss"
export PATH=${JBOSS_HOME}/bin:$PATH

export CATALINA_HOME=${JBOSS_HOME}/server/default
#export CATALINA_OPTS="-Dappserver.home=$CATALINA_HOME -Dappserver.base=$CATALINA_HOME"
alias jboss='${JBOSS_HOME}/bin/run.sh > ${KPLUSTP_DEV}/jboss.txt'

# ECLIPSE
export ECLIPSE_HOME=${DRIVE_PATH}/usr/share/eclipse
export PATH=${ECLIPSE_HOME}:$PATH
alias eclipse='${ECLIPSE_HOME}/eclipse'

# LUMBERMILL
export LUMBERMILL_HOME="${DRIVE_PATH}/lumbermill"
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
#export PATH=${DRIVE_PATH}Windows/system32:${DRIVE_PATH}Windows:$PATH

# XSLT
alias XSLT='java org.apache.xalan.xslt.Process'

# LOG4CXX COMPILE
#export CLASSPATH=${CLASSPATH}:${DRIVE_PATH}repo/ant-contrib/cpptasks/1.0b5/cpptasks-1.0b5.jar

alias jbuildEar='pushd `pwd` && cdk && cd presentation && mvn install -DwithoutPresentationCore && popd'
alias jbuildProject='pushd `pwd` && cdk && mvn install -DwithoutEAR && cdk && ( test ! -d ../mda  || ( cd ../mda && ant && cdk ) ) && jbuildEar && popd'
alias jrebuildProject='pushd `pwd` && cdk && jclean && jbuildProject && popd'

alias jbuild='mvn install -DwithoutEAR && pushd `pwd` && jbuildEar && popd'
alias jclean='mvn clean'
alias jrebuild='jclean && jbuild'
alias redeploy='pushd `pwd` && cdk && cd presentation/ear && mvn weblogic:redeploy && popd'

alias cdwebL="cd ${JBOSS_HOME}"

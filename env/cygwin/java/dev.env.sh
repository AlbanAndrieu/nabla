#!/bin/sh -f

#setenv PATH ${MAVEN_DIR}/bin:${PATH}
# User specific aliases and functions
# The following are the environment variables for Java, ANT and JBoss

# JAVA
#JDK_HOME=/usr/lib/jvm/ia32-java-6-sun-1.6.0.06/
#JDK_HOME=/cygdrive/c/Sun/SDK/jdk
ln -s /cygdrive/c/Program\ Files\ \(x86\) /ProgramFilesx86
#export JAVA_HOME="/cygdrive/c/Program Files (x86)/Java/jdk1.5.0_22"
##export JAVA_HOME="/ProgramFilesx86/Java/jdk1.5.0_22"
export JAVA_HOME="/cygdrive/c/Sun/SDK/jdk"
export JRE_HOME=${JAVA_HOME}/jre
#export JDK_HOME JRE_HOME JAVA_HOME
#export JAVA=$JAVA_HOME/bin/java
#PATH=${JDK_HOME}/bin:${JRE_HOME}/bin:${PATH}
PATH=${JAVA_HOME}/bin:${PATH}
export PATH

export JAVA_OPTS="-Xms256m -Xmx1548m"

# MAVEN
#export M2_HOME="/cygdrive/c/apache-maven-3.0.2"
export M2=${M2_HOME}/bin
export MAVEN_OPTS="-Xms512m -Xmx1024m"
#export MAVEN_OPTS="-Xmx512M -XX:MaxPermSize=1024M"
export PATH=${M2}:$PATH
export M2_REPO=/cygdrive/c/repo
echo "Maven repo are in : ${M2_REPO}"

# ANT 
export ANT_OPTS="-Xmx512m"
export ANT_HOME="/cygdrive/c/apache-ant-1.8.0"
export PATH=${ANT_HOME}/bin:${ANT_HOME}/lib:$PATH

# JBOSS
export JBOSS_HOME="/cygdrive/c/jboss-4.2.2.GA"
export PATH=${JBOSS_HOME}/bin:$PATH

export CATALINA_HOME=${JBOSS_HOME}/server/default
#export CATALINA_OPTS="-Dappserver.home=$CATALINA_HOME -Dappserver.base=$CATALINA_HOME"
alias jboss='${JBOSS_HOME}/bin/run.sh > ${KPLUSTP_DEV}/jboss.txt'

# ECLIPSE
export ECLIPSE_HOME=/cygdrive/c/eclipse-3.5
export PATH=${ECLIPSE_HOME}:$PATH
alias eclipse='${ECLIPSE_HOME}/eclipse'

# LUMBERMILL
export LUMBERMILL_HOME="/cygdrive/c/lumbermill-2.0-b3"
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
export PATH=$PATH:/cygdrive/c/Windows/system32:/cygdrive/c/Windows

# XSLT
#export XALANProcess_CLASSPATH=/cygdrive/c/repo/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar
#export XALANProcess_CLASSPATH=${XALANProcess_CLASSPATH}:/cygdrive/c/repo/xalan/xalan/2.7.1/xalan-2.7.1.jar
#export XALANProcess_CLASSPATH=${XALANProcess_CLASSPATH}:/cygdrive/c/repo/xalan/serializer/2.7.1/serializer-2.7.1.jar
#export XALANProcess_CLASSPATH=${XALANProcess_CLASSPATH}:/cygdrive/c/workspace/users/albandri30/presentation/kiwi/framework_app/libs/3rdparty/xmlapi/xml-apis-1.3.03.jar
#export XALANProcess_CLASSPATH=${XALANProcess_CLASSPATH}:/cygdrive/c/workspace/users/albandri30/presentation/kiwi/framework_app/libs/3rdparty/xmlapi/xml-resolver-1.1.jar

#alias XSLT='java -Xbootclasspath/p:$XALANProcess_CLASSPATH org.apache.xalan.xslt.Process'
#alias XSLT='java org.apache.xalan.xslt.Process'

# LOG4CXX COMPILE
export CLASSPATH=${CLASSPATH}:/cygdrive/c/repo/ant-contrib/cpptasks/1.0b5/cpptasks-1.0b5.jar

alias jbuildEar='pushd `pwd` && cdk && cd presentation && mvn install -DwithoutPresentationCore && popd'
alias jbuildProject='pushd `pwd` && cdk && mvn install -DwithoutEAR && cdk && ( test ! -d ../mda  || ( cd ../mda && ant && cdk ) ) && jbuildEar && popd'
alias jrebuildProject='pushd `pwd` && cdk && jclean && jbuildProject && popd'

alias jbuild='mvn install -DwithoutEAR && pushd `pwd` && jbuildEar && popd'
alias jclean='mvn clean'
alias jrebuild='jclean && jbuild'
alias redeploy='pushd `pwd` && cdk && cd presentation/ear && mvn weblogic:redeploy && popd'

alias cdwebL="cd ${JBOSS_HOME}"

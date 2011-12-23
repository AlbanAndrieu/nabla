#!/bin/csh -f

# JAVA
#setenv JAVA_HOME ${KPLUSTP_THIRDPARTY}/j2se/${ARCH}/jdk1.5
#setenv JAVA_HOME "C:\\Program\ Files\ \(x86\)\\Java\\jdk1.5.0_22"
ln -s /cygdrive/c/Program\ Files\ \(x86\) /ProgramFilesx86
#setenv JAVA_HOME /ProgramFilesx86/Java/jdk1.5.0_22
setenv JAVA_HOME "/cygdrive/c/Sun/SDK/jdk"

setenv JRE_HOME ${JAVA_HOME}/jre
setenv PATH ${JAVA_HOME}/bin:${PATH}

# ANT 
#setenv ANT_HOME ${ANT_HOME}
setenv ANT_OPTS "-Xmx512m"
setenv PATH ${ANT_HOME}/bin:${PATH}

# MAVEN
#setenv M2_HOME ${M2_HOME}
setenv MAVEN_DIR ${M2_HOME}
#setenv MAVEN_OPTS "-Xmx1548m"
#setenv MAVEN_OPTS "-Xmx512M -XX:MaxPermSize=1024M"
setenv MAVEN_OPTS "-Xms512m -Xmx1024m"
setenv PATH ${M2_HOME}/bin:${PATH}

# LUMBERMILL
setenv PATH ${LUMBERMILL_HOME}/bin:${PATH}

# GRAPHVIZ
setenv PATH ${GRAPHVIZ_HOME}/bin:${PATH}

# TIBCO
setenv PATH ${TIBCO_HOME}/bin:${PATH}

# XSLT
setenv XALANProcess_CLASSPATH /cygdrive/c/thirdparty/xml/xerces/java/2.9.0/xercesImpl.jar
setenv XALANProcess_CLASSPATH ${XALANProcess_CLASSPATH}:/cygdrive/c/thirdparty/Framework3.0/2.0-SNAPSHOT/kiwi/framework_app/libs/3rdparty/xmlapi/xalan-2.7.1.jar
setenv XALANProcess_CLASSPATH ${XALANProcess_CLASSPATH}:/cygdrive/c/thirdparty/Framework3.0/2.0-SNAPSHOT/kiwi/framework_app/libs/3rdparty/xmlapi/serializer-2.7.1.jar
setenv XALANProcess_CLASSPATH ${XALANProcess_CLASSPATH}:/cygdrive/c/thirdparty/Framework3.0/2.0-SNAPSHOT/kiwi/framework_app/libs/3rdparty/xmlapi/xml-apis-1.3.04.jar
setenv XALANProcess_CLASSPATH ${XALANProcess_CLASSPATH}:/cygdrive/c/thirdparty/Framework3.0/2.0-SNAPSHOT/kiwi/framework_app/libs/3rdparty/xmlapi/xml-resolver-1.1.jar

alias XSLT java -Xbootclasspath/p:$XALANProcess_CLASSPATH org.apache.xalan.xslt.Process

alias jbuildDoc '( ( pushd `pwd` && cdk && cd service/validation/api && mvn site && popd ) || echoFailed )'
alias jbuildEarProject '( ( pushd `pwd` && cdk && cd presentation && mvn install -DwithoutPresentationCore && popd ) || echoFailed )'
alias jbuildEar '( ( pushd `pwd` && cdk && cd presentation/ear && mvn clean install && popd ) || echoFailed )'
alias jbuildProject '( ( pushd `pwd` && cdk && mvn install -DwithoutEAR && cdk && ( test ! -d ../mda  || ( cd ../mda && ant && cdk ) ) && jbuildEarProject && jbuildDoc && popd ) || echoFailed )'
alias jrebuildProject '( ( pushd `pwd` && cdk && jclean && jbuildProject && popd ) || echoFailed )'

alias jbuild '( ( mvn install -DwithoutEAR && pushd `pwd` && jbuildEar && popd ) || echoFailed )'
alias jclean '( mvn clean )'
alias jrebuild '( ( jclean && jbuild && jbuildDoc ) || echoFailed )'
alias redeploy '( pushd `pwd` && cdk && cd presentation/ear && mvn weblogic:redeploy && popd )'



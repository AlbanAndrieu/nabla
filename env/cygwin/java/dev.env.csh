#!/bin/csh -f

# JAVA
#setenv JAVA_HOME ${KPLUSTP_THIRDPARTY}/j2se/${ARCH}/jdk1.5
#setenv JAVA_HOME "C:\\Program\ Files\ \(x86\)\\Java\\jdk1.5.0_22"
ln -s ${DRIVE_PATH}/Program\ Files\ \(x86\) /ProgramFilesx86
#setenv JAVA_HOME /ProgramFilesx86/Java/jdk1.5.0_22
setenv JAVA_HOME "${DRIVE_PATH}/Sun/SDK/jdk"

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



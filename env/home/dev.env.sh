#!/bin/bash

####################
### READ ARGUMENTS
####################
TOOLS_OPTION_PURIFY=""
export PERLGEN_OPTION=""
typeset PURIFY=$1
if [ "$1" != "" ]
then

  case "$1" in
    purify)
      TOOLS_OPTION_PURIFY="purify"
      export PERLGEN_OPTION="-p"
    ;;

    *)
      DATABASE_CONFIG=$1
    ;;

  esac

fi
###################

echo "ARCH : ${ARCH} must be sun4sol sun4 rs6000 hprisc solaris linux cygwin winnt"

if [ -z "$PROJECT_USER" ]
then
  echo "ERROR: Set PROJECT_USER environment variable!"
  export PROJECT_USER=albandri
fi

if [ -z "$PROJECT_VERSION" ]
then
  echo "ERROR: Set PROJECT_VERSION environment variable!"
  export PROJECT_VERSION=10
fi

if [ -z "$DRIVE_PATH" ]
then
  #echo "ERROR: Set DRIVE_PATH environment variable!"
  export DRIVE_PATH=
fi

if [ -z "$PROJECT_HOME" ]
then
  echo "ERROR: Set PROJECT_HOME environment variable!"
  export PROJECT_HOME=${DRIVE_PATH}/workspace/users
fi

if [ -z "$WORKSPACE_ENV" ]
then
  echo "ERROR: Set WORKSPACE_ENV environment variable!"
  export WORKSPACE_ENV=${PROJECT_HOME}/${PROJECT_USER}${PROJECT_VERSION}/env
fi

if [ -z "$PROJECT_EXTRACTION" ]
then
  export PROJECT_EXTRACTION=cpp
fi

if [ -z "$TERM" ]
then
  export TERM=xterm
fi

if [ -z "$EDITOR" ]
then
  export EDITOR=geany
fi
export SVN_EDITOR=${EDITOR}

export PATH=/usr/local/bin:/usr/sbin:/usr/bin:/bin
if [ -d "${HOME}/bin" ] ; then
    PATH="${HOME}/bin:$PATH"
fi
if [ -d "${WORKSPACE_ENV}/${ARCH}/bin" ] ; then
    PATH="${WORKSPACE_ENV}/${ARCH}/bin:$PATH"
fi
if [ -d "${DRIVE_PATH}/cygwin/bin" ] ; then
    PATH="${DRIVE_PATH}/cygwin/bin:$PATH"
fi

export PROJECT_MAJOR_VERSION=${PROJECT_VERSION}

export PROJECT_BUILD_TYPE=target
export CLIENT_SERVER_TYPE=jboss

export PROJECT_DEV=${PROJECT_HOME}/${PROJECT_USER}${PROJECT_MAJOR_VERSION}
echo PROJECT_USER: ${PROJECT_USER} PROJECT_DEV : ${PROJECT_DEV}
export PROJECT_SRC=${PROJECT_DEV}/${PROJECT_EXTRACTION}
export PROJECT_TARGET_PATH=${DRIVE_PATH}/${PROJECT_BUILD_TYPE}
export PROJECT_USER_PROFILE="${PROJECT_DEV}/env/config/profiles/${PROJECT_USER}${PROJECT_VERSION}.${ARCH}.properties"

export PROJECT_THIRDPARTY_PATH=${DRIVE_PATH}/thirdparty
export PROJECT_RELEASE=${PROJECT_TARGET_PATH}/release/${PROJECT_MAJOR_VERSION}
export PROJECT_PKG=${PROJECT_TARGET_PATH}/pkg/${PROJECT_MAJOR_VERSION}

if [ ! -d $PROJECT_DEV ]
then
  echo "ERROR: Directory ${PROJECT_DEV} doesn't exist!"
  exit 1
fi

##
# Cleaning LD_LIBRARY_PATH LIBPATH and CLASSPATH
##
##if [ -z "$KEEP_ENV" ]
##then
##
##  if [ -z "$CLASSPATH" ]
##  then
##fix javadoc plugins error
    echo 'Cleaning $CLASSPATH: '${CLASSPATH}
    export CLASSPATH=""
##  fi
##
##  if [ -z "$LD_LIBRARY_PATH" ]
##  then
##    echo 'Cleaning $LD_LIBRARY_PATH: '${LD_LIBRARY_PATH}
    export LD_LIBRARY_PATH=""
##  fi
##
##  if [ -z "$LIBPATH" ]
##  then
##    echo 'Cleaning $LIBPATH: '${LIBPATH}
##    export LIBPATH=""
##  fi
##fi

#Define LD_LIBRARY_PATH if does not exists
if [ -z "$LD_LIBRARY_PATH" ]
then
  export LD_LIBRARY_PATH
fi

export QTDIR=${DRIVE_PATH}/usr/lib/qt3

export HUDSON_HOME=${DRIVE_PATH}/workspace/hudson
export JENKINS_HOME=${DRIVE_PATH}/jenkins
export TOMCAT_HOME=${DRIVE_PATH}/var/lib/tomcat7
export SONAR_HOME=${DRIVE_PATH}/workspace/sonar
export SONAR_RUNNER_HOME=${DRIVE_PATH}/workspace/sonar-runner
export PATH=${SONAR_RUNNER_HOME}/bin:${PATH}
export CYGWIN_HOME=${DRIVE_PATH}/cygwin
export SVN_HOME=${CYGWIN_HOME}/bin
export CROWD_INSTALL=${DRIVE_PATH}/workspace/crowd
export CROWD_HOME=${DRIVE_PATH}/var/crowd-home
export NEXUS_HOME=${DRIVE_PATH}/workspace/nexus
export FISHEYE_HOME=${DRIVE_PATH}/workspace/fecru
export FISHEYE_INST=${DRIVE_PATH}/workspace/fisheye
export OPENGROK_TOMCAT_BASE=${DRIVE_PATH}/var/lib/tomcat7

export SYBASE_OCS=OCS-15_0
export SYBASE_VERSION=12.5
export SYBASE_HOME=${DRIVE_PATH}/Sybase/${SYBASE_OCS}/

export ORACLE_VERSION=10.2.0
export ORACLE_HOME=${DRIVE_PATH}/oraclexe/app/oracle/product/${ORACLE_VERSION}/server

###
# Alias
###
alias status="svn status -u"
alias Grep="find . -name '*.[jch]*' -exec grep -n \!* {} + -o -name '.svn' -prune -type f"
alias hGrep="find . -name '*.h' -exec grep -n \!* {} + -o -name '.svn' -prune -type f"
alias myGrep="find . -name '*.*' -exec grep -n \!* {} + -o -name '.svn' -prune -type f"
echo "find . -type d -name ".svn"  -print | xargs rm -Rf"
echo "find . -name 'pom.xml' | xargs grep SNAPSHOT"

###
# THIRDPARTIES
###

export ORB_VERSION=1_3
export ORB=tao

if [ "${ARCH}" = winnt -o "${ARCH}" = cygwin ]
then
  export CORBA_ROOT=${PROJECT_THIRDPARTY_PATH}/tao
  export ACE_ROOT=${CORBA_ROOT}/ACE_wrappers

  echo ${ACE_ROOT}

  TAO_ROOT=${ACE_ROOT}/tao
  export TAO_ROOT

  echo ${TAO_ROOT}

  MPC_ROOT=${ACE_ROOT}/MPC
  export MPC_ROOT

  echo ${MPC_ROOT}

  CIAO_ROOT=${TAO_ROOT}/CIAO
  export CIAO_ROOT
  
  echo ${CIAO_ROOT}
  
  DANCE_ROOT=${CIAO_ROOT}/DANCE
  export DANCE_ROOT
  
  echo ${DANCE_ROOT}

  DDS_ROOT=${CIO_ROOT}/connectors/dds4ccm
  export DDS_ROOT
  
  echo ${DDS_ROOT}
fi

export BOOST_VERSION=1.41.0
export GETTEXT_VERSION=0.17
export XERCES_VERSION=2.8.0
export XML2_VERSION=2.7.2
export TIBRV_VERSION=7.2.x

if [ "${ARCH}" = winnt -o "${ARCH}" = cygwin ]
then
  export MINGW_ROOT=${DRIVE_PATH}/MinGW

  export BOOST_ROOT=${PROJECT_THIRDPARTY_PATH}/boost/${BOOST_VERSION}
else
  export BOOST_ROOT=/usr/include
fi 
export BOOST=$BOOST_ROOT

# CMAKE 2.6.4
export CMAKE_HOME=/usr/share/cmake-2.6.4
export CMAKE_ROOT=${CMAKE_HOME}

# PYTHON 27
export PYTHON_DIR=/usr/lib/python

# ALIAS to python
alias python='/usr/bin/python'
  
# SCONS 2.2.0
#export SCONS_DIR=${PYTHON_DIR}/Lib/site-packages/scons-2.2.0
export SCONS_DIR=/usr/lib/scons/SCons
  
# ALIAS to scons-local
alias scons='/usr/bin/scons'
  
export SCONS_PATH=/usr/lib/scons/SCons/Script
if [ "$SCONS_PATH" = "" ]
then
  echo "WARNING: Set SCONS_PATH environment variable not defined!"
else    
  export PATH=${SCONS_PATH}:${PATH}
fi

#CORBA TAO
export PATH=${PATH}:${ACE_ROOT}/tao:${ACE_ROOT}/bin:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs
if [ -d "${MPC_ROOT}" ] ; then
    PATH="${MPC_ROOT}:$PATH"
fi
if [ -d "${CIAO_ROOT}" ] ; then
    PATH="${CIAO_ROOT}:$PATH"
fi
if [ -d "${DANCE_ROOT}" ] ; then
    PATH="${DANCE_ROOT}:$PATH"
fi
if [ -d "${DDS_ROOT}" ] ; then
    PATH="${DDS_ROOT}:$PATH"
fi
export LD_LIBRARY_PATH=/usr/local/lib:${LD_LIBRARY_PATH}:${ACE_ROOT}/tao:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}

# JAVA
#JDK_HOME=/usr/lib/jvm/ia32-java-6-sun-1.6.0.06/
#JDK_HOME=${DRIVE_PATH}/Sun/SDK/jdk
if [ "${ARCH}" = winnt -o "${ARCH}" = cygwin ]
then
  ln -s ${DRIVE_PATH}/Program\ Files\ \(x86\) /ProgramFilesx86
  #export JAVA_HOME="/ProgramFilesx86/Java/jdk1.5.0_22"
fi
export JAVA_HOME=${DRIVE_PATH}/jenkins/tools/JDK/JDK_7u7
  
export JRE_HOME=${JAVA_HOME}/jre
#export JDK_HOME JRE_HOME JAVA_HOME
#export JAVA=$JAVA_HOME/bin/java
#PATH=${JDK_HOME}/bin:${JRE_HOME}/bin:${PATH}
PATH=${JAVA_HOME}/bin:${PATH}
export PATH

export JAVA_OPTS="-Xms256m -Xmx1548m"

# MAVEN
export M2_HOME=/usr/share/maven
export M2=${M2_HOME}/bin
export PATH=${M2}:$PATH
#export MAVEN_OPTS="-Xms512m -Xmx1024m"
#export MAVEN_OPTS="-Xmx512M -XX:MaxPermSize=1024M" 
#export MAVEN_OPTS="-Xms256m -Xmx512m -XX:PermSize=64M -XX:MaxPermSize=160M"
#Jenkins We have 48GB RAM and 44 GB swap and its 24 core server. 
#-Xms24g -Xmx24g -Xmn6g -XX:MaxPermSize=512M -XX:+UseParallelOldGC -XX:ParallelGCThreads=16
#Add MaxPermSize for andromda
MAVEN_OPTS="-Xms256m -Xmx512m -XX:PermSize=80M -XX:MaxPermSize=256M"
# -Djava.awt.headless=true
if [ 1 -eq 1 ] ; then
  #with gc info dump in file gc.log -XX:+PrintGCDetails -Xloggc:gc.log
  MAVEN_OPTS="${MAVEN_OPTS} -XX:+PrintGCDetails -Xloggc:gc.log"
fi
export MAVEN_OPTS  
export M2_REPO=${DRIVE_PATH}/repo
echo "Maven repo are in : ${M2_REPO}"

# ANT
export ANT_HOME=/usr/share/ant
export PATH=${ANT_HOME}/bin:${ANT_HOME}/lib:$PATH
export ANT_OPTS="-Xmx512m"

# JBOSS
export JBOSS_HOME=${DRIVE_PATH}/workspace/jboss-as-7.1.1.Final
export PATH=${JBOSS_HOME}/bin:$PATH

# JBOSS
export BEES_HOME="${DRIVE_PATH}/cloudbees-sdk-1.1"
export PATH=${BEES_HOME}:$PATH
alias jboss='${JBOSS_HOME}/bin/run.sh > ${PROJECT_DEV}/jboss.txt'

# TOMCAT
export CATALINA_HOME=${DRIVE_PATH}/usr/share/tomcat7
# Customize tomcat in CATALINA_BASE
export CATALINA_BASE=${DRIVE_PATH}/var/lib/tomcat7
CATALINA_OPTS=""
#CATALINA_OPTS="-Dappserver.home=$CATALINA_HOME -Dappserver.base=$CATALINA_HOME -Dapplication.property.dir=${CATALINA_HOME}/project"
if [ 1 -eq 1 ] ; then
  export CATALINA_OPTS="-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=2924,server=y,suspend=n -Djava.compiler=NONE $CATALINA_OPTS"
fi

# ECLIPSE 3.7
export ECLIPSE_HOME=/workspace/eclipse-j2ee
if [ "${ARCH}" = winnt -o "${ARCH}" = cygwin ]
then
  export PATH=${ECLIPSE_HOME}:$PATH
  alias eclipse='${ECLIPSE_HOME}/eclipse'
else
  export ECLIPSE_HOME=${DRIVE_PATH}/eclipse
fi

if [ "${ARCH}" = winnt -o "${ARCH}" = cygwin ]
then
  #ln -s ${DRIVE_PATH}/MagicDraw\ UML\ 16.5 /MagicDrawUML16.5
  #export MD_HOME="/MagicDrawUML16.5"
  export MD_HOME=${DRIVE_PATH}/MagicDraw-UML-16.5
fi
export ANDROMDA_HOME=${DRIVE_PATH}/repo/org/andromda

# CHROME
export CHROME_BIN=${DRIVE_PATH}/usr/bin/google-chrome

# LUMBERMILL
export LUMBERMILL_HOME="${DRIVE_PATH}/lumbermill-2.0-b3"
export PATH=${LUMBERMILL_HOME}/bin:${PATH}
alias lumbermill='java -jar ${LUMBERMILL_HOME}/dist/lib/lumbermill.jar'
echo "Lumbermill port is 4445"

# GRAPHVIZ
if [ "${ARCH}" = winnt -o "${ARCH}" = cygwin ]
then
  export GRAPHVIZ_HOME=${DRIVE_PATH}/Graphviz2.26.3
  export PATH=${GRAPHVIZ_HOME}/bin:${PATH}
else
  export GRAPHVIZ_HOME=/usr/share/graphviz/
fi

# TIBCO
if [ "${ARCH}" = winnt -o "${ARCH}" = cygwin ]
then
  export TIBCO_HOME=${DRIVE_PATH}/Tibco/Tibrv
  export PATH=${TIBCO_HOME}/bin:${PATH}
fi

# WINDOWS
if [ "${ARCH}" = winnt -o "${ARCH}" = cygwin ]
then
  export PATH=$PATH:${DRIVE_PATH}/Windows/system32:${DRIVE_PATH}/Windows
fi

#AWS EC2
#export EC2_KEYPAIR=<your keypair name> # name only, not the file name
#export EC2_URL=https://ec2.<your ec2 region>.amazonaws.com
#export EC2_PRIVATE_KEY=$HOME/<where your private key is>/pk-XXXXXXXXXXXXXXXXXXXXXXXXXXXX.pem
#export EC2_CERT=$HOME/<where your certificate is>/cert-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.pem
export EC2_KEYPAIR=albandri # name only, not the file name
export EC2_URL=https://ec2.us-west-2.amazonaws.com
export EC2_PRIVATE_KEY=$HOME/.ec2/pk-FMQ27HNLF2PVMPVL7MPWHEY5GWDKDOT2.pem
export EC2_CERT=$HOME/.ec2/cert-FMQ27HNLF2PVMPVL7MPWHEY5GWDKDOT2.pem
###
# INCLUDE LANGUAGE SPECIFIC
###

# Make a directory with link to several libraries for LIBPATH length restriction
#################################################################################
LIB_LINK_DIR="${PROJECT_TARGET_PATH}/lib/${ARCH}"
echo $LIB_LINK_DIR
test ! -d ${LIB_LINK_DIR} && mkdir -p ${LIB_LINK_DIR}
#\rm -f ${LIB_LINK_DIR}/* |& cat >/dev/null
#rm -f ${LIB_LINK_DIR}/*

#ln -s ${PROJECT_THIRDPARTY_PATH}/boost/${BOOST_VERSION}/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/boost
#ln -s ${PROJECT_THIRDPARTY_PATH}/cppunit/${CPPUNIT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/cppunit
#ln -s ${PROJECT_THIRDPARTY_PATH}/gnu/gettext/${GETTEXT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/gettext
#ln -s ${PROJECT_THIRDPARTY_PATH}/xml/xerces/c++/${XERCES_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/xerces
#ln -s ${PROJECT_THIRDPARTY_PATH}/libxml2/${XML2_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/xml2
#ln -s ${PROJECT_THIRDPARTY_PATH}/tibco/tibrv/${TIBRV_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/tibrv

#ln -s ${PROJECT_THIRDPARTY_PATH}/database/sybase/openclient/12.51/ESD_17/${ARCH}/lib ${LIB_LINK_DIR}/sybase

#################################################################################

#case ${ARCH} in
#    sun4sol)
#      export LD_LIBRARY_PATH=/usr/lib/lwp
#    ;;
#    rs6000)
#      export LD_LIBRARY_PATH=${PROJECT_TARGET_PATH}/lib/${ARCH}/opt/shared:${PROJECT_TARGET_PATH}/lib/${ARCH}/opt
#    ;;
#    *)
#      export LD_LIBRARY_PATH=""
#    ;;
#esac
#export LD_LIBRARY_PATH=${PROJECT_TARGET_PATH}/lib/${ARCH}/opt/shared:${PROJECT_TARGET_PATH}/lib/${ARCH}/opt

#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/tibrv
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/sybase
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/oracle
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/boost
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/cppunit
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/gettext
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/xerces

#CORBA TAO
#if [ "$ORB" = "tao" ]
#  export MPC_ROOT=${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/MPC
#  export CIAO_ROOT=${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/TAO/CIAO
#  export DANCE_ROOT=${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/TAO/CIAO/DANCE
#  export DDS_ROOT=${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/TAO/CIAO/connectors/dds4ccm
#  export PATH=${PATH}:${ACE_ROOT}/tao:${ACE_ROOT}/bin:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}
#  export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}::${ACE_ROOT}/tao:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}
#fi

export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:/lib:/usr/lib

# Development library path, opt first, then debug
export LD_LIBRARY_PATH=${PROJECT_TARGET_PATH}/lib/${ARCH}/debug:${PROJECT_TARGET_PATH}/lib/${ARCH}/debug/shared:${LD_LIBRARY_PATH}
export LD_LIBRARY_PATH=${PROJECT_TARGET_PATH}/lib/${ARCH}/opt:${PROJECT_TARGET_PATH}/lib/${ARCH}/opt/shared:${LD_LIBRARY_PATH}

##
# Alias
##
git config --global alias.co checkout
git config --global alias.br branch
git config --global alias.ci commit
git config --global alias.st status
git config --global alias.unstage 'reset HEAD --'
git config --global alias.last 'log -1 HEAD'

alias cde="cd ${PROJECT_DEV}/${PROJECT_EXTRACTION}"
alias cdr="cd ${PROJECT_DEV}"
alias cdc="cd ${PROJECT_DEV}/env/config"
alias cdinc="cd ${PROJECT_TARGET_PATH}/include/${ARCH}"
alias cdobj="cd ${PROJECT_TARGET_PATH}"
alias cdbin="cd ${PROJECT_TARGET_PATH}/bin"

alias cdrl="cd ${PROJECT_RELEASE}/latest"
alias cdri="cd ${PROJECT_RELEASE}/installed"
alias cdcu="cd ${PROJECT_RELEASE}/current"

alias cdcore="cd ${PROJECT_TARGET_PATH}/corefiles"
alias ..="cd .."
alias cls="clear"

alias ls='/bin/ls -F'

if [ "${ARCH}" = sun4sol -o "${ARCH}" = solaris ]
then
  alias l='/bin/ls -Fl'
  alias pp='/usr/ucb/ps -auxwww'
  alias m='/usr/ucb/more'
else
  if [ "${ARCH}" = sun4 ]
  then
    alias l='/bin/ls -Flg'
    alias pp='/usr/bin/ps -auxwww'
  else
    if [ "${ARCH}" = rs6000 ]
    then
      alias l='/bin/ls -Fl'
      alias pp='/usr/bin/ps auxwww'
      alias m='/usr/bin/more'
    else
      if [ "${ARCH}" = hprisc ]
      then
        alias l='/bin/ls -Fl'
        alias pp='/bin/ps -edf'
      else
        if [ "${ARCH}" = linux -o "${ARCH}" = cygwin ]
        then
          alias l='/bin/ls -Fl --color'
          alias pp='/bin/ps -auxwww'
        fi
      fi
    fi
  fi
fi

alias lt='l -t'
alias lrt='l -rt'
alias l~='l ~'
alias ll='l -a'
alias la='l -al'
alias llt='ll -t'
alias llrt='ll -rt'
alias ll~='ll ~'

alias psg="pp | egrep -i \!* |& grep -v 'egrep -i \!*'"
alias psuser="pp | cut -d' ' -f1 | sort | grep -v USER | uniq -c | sort -r"

alias setEnvFiles="${WORKSPACE_ENV}/config/setEnvFiles.sh ${PROJECT_USER_PROFILE} \!* --userdev"
alias setEnvFilesAll="${WORKSPACE_ENV}/config/setEnvFiles.allUserDev.sh ${PROJECT_USER_PROFILE}"

alias setWorkspace="source ${WORKSPACE_ENV}/scripts/setWorkspace.sh"

#export M2_SETTINGS=${PROJECT_DEV}/.m2/settings.xml
#alias mvn="mvn -s ${M2_SETTINGS}"
#echo "Maven settings are in : ${M2_SETTINGS}"

# PATH Setting
#source ${WORKSPACE_ENV}/java/dev.env.sh
#source ${WORKSPACE_ENV}/cpp/dev.env.sh
#GIT
source ${WORKSPACE_ENV}/home/.git-completion.bash
#see source ~/.git-prompt.sh in .bashrc
source ${WORKSPACE_ENV}/home/.novarc

alias replace="${WORKSPACE_ENV}/scripts/replace.pl"
alias svndi="svn di --diff-cmd=svndiff"
#TODO same as svn st-q
alias svnst="svn st | grep -v ^?"

####### TRY TO CHANGE PATH TO BE IN THE CURRENT ENVIRONMENT DEVELOPMENT PATH

OLD_PATH=`pwd`
NEW_PATH=`echo ${OLD_PATH} | sed -e "s/\/${PROJECT_USER}[^\/]*/\/${PROJECT_USER}${PROJECT_VERSION}/"`
        
if [ "${OLD_PATH}" != "${NEW_PATH}" ]
then
  if [ -d "${NEW_PATH}" ]
  then
        cd ${NEW_PATH}
        echo Current path UPDATED : cd `pwd`
  else
        echo "Current path : `pwd`"
  fi
fi

case ${ARCH} in
    rs6000)
      export LIBPATH=${LD_LIBRARY_PATH}
      unset LD_LIBRARY_PATH
    ;;
esac

export DISPLAY=:0.0
export LC_CTYPE=en_US.UTF-8

/usr/games/cowsay -f `ls /usr/share/cowsay/cows/ | rl | tail -n 1 | cut -d'.' -f1` "`/usr/games/fortune -s`"

echo "PATH is ${PATH}"

#exit 0

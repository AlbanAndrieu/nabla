# ~/.bashrc: executed by bash(1) for non-login shells.
# see /usr/share/doc/bash/examples/startup-files (in the package bash-doc)
# for examples

####################
### READ ARGUMENTS
####################
TOOLS_OPTION_PURIFY=""
DATABASE_CONFIG=fa_ktp30
#export PERLGEN_OPTION ""
typeset PURIFY=$1
#echo $PURIFY
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

if [ -z "$PROJECT_USER" ]
then
  echo "ERROR: Set PROJECT_USER environment variable!"
  exit 1
fi

#If you want to use new GCC by default, make sure that your PATH contains /usr/local/bin before /bin and /usr/bin.
#:/sbin:/usr/local/sbin
export PATH=/usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/games:${DRIVE_PATH}/cygwin/bin
#export LD_LIBRARY_PATH=/usr/local/lib
#cd /usr/bin
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 gcc.exe -> /etc/alternatives/gcc
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 g++.exe -> /etc/alternatives/g++
#ln -s /etc/alternatives/gcc gcc-SAV.exe
#ln -s /etc/alternatives/g++ g++-SAV.exe
#ln -s /usr/bin/gcc-3.exe gcc.exe
#ln -s /usr/bin/g++-3.exe g++.exe

export PROJECT_MAJOR_VERSION=${PROJECT_VERSION}

export PROJECT_BUILD_TYPE=target
#export CLIENT_SERVER_TYPE=weblogic
export CLIENT_SERVER_TYPE=jboss

export PROJECT_USER_PROFILE="${PROJECT_DEV}/config/profiles/${UNIX_USERNAME}.dev.properties"

export PROJECT_DEV=${DEV_HOME}/${PROJECT_USER}${PROJECT_MAJOR_VERSION}
export PROJECT_SRC=${PROJECT_DEV}/${PROJECT_EXTRACTION}
export PROJECT_OBJ=${DRIVE_PATH}/${PROJECT_BUILD_TYPE}
export PROJECT_THIRDPARTY_PATH=${DRIVE_PATH}/thirdparty
export PROJECT_RELEASE=${PROJECT_DEV}/${PROJECT_EXTRACTION}/release/${PROJECT_MAJOR_VERSION}
export PROJECT_PKG=${PROJECT_DEV}/${PROJECT_EXTRACTION}/pkg/${PROJECT_MAJOR_VERSION}
export TMPLDIR=${PROJECT_DEV}/config/tmpl

export TIBCO_HOME=${DRIVE_PATH}/Tibco/Tibrv
export GRAPHVIZ_HOME=${DRIVE_PATH}/Graphviz2.26.3
export QTDIR=/lib/qt3

export HUDSON_HOME=${DRIVE_PATH}/hudson
export SVN_HOME=${DRIVE_PATH}/cygwin/bin
export ORACLE_HOME=${DRIVE_PATH}/oraclexe/app/oracle/product/10.2.0/server
export SYBASE_HOME=${DRIVE_PATH}/Sybase/OCS-15_0/
export CYGWIN_HOME=${DRIVE_PATH}/cygwin

export LUMBERMILL_HOME="${DRIVE_PATH}/lumbermill-2.0-b3"
echo "Lumbermill port is 4430"

export EDITOR=nedit
export SVN_EDITOR=${EDITOR}

if [ ! -d $PROJECT_DEV ]
then
  echo "ERROR: Directory ${PROJECT_DEV} doesn't exist!"
  #exit 1
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
##    export LD_LIBRARY_PATH=""
##  fi
##
##  if [ -z "$LIBPATH" ]
##  then
##    echo 'Cleaning $LIBPATH: '${LIBPATH}
##    export LIBPATH=""
##  fi
##fi

if [ -z "$LD_LIBRARY_PATH" ]
then
  export LD_LIBRARY_PATH
fi

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
export BOOST_VERSION=1.41.0
export GETTEXT_VERSION=0.14.5
export XERCES_VERSION=2_5_0

case ${MACHINE} in
    sun4sol)
      export ORB_VERSION=1_3
      export ORB=tao
    ;;
    x86Linux)
      export ORB_VERSION=1_3
      export ORB=tao
    ;;
    rs6000)
      export ORB_VERSION=4.0.7
      export ORB=omniOrb
    ;;
    *)
      echo "Unknown machine: ${MACHINE}"
      exit 1
    ;;
esac

#export MINGW_ROOT=${DRIVE_PATH}/MinGW

export CORBA_ROOT=${PROJECT_THIRDPARTY_PATH}/tao
export ACE_ROOT=${CORBA_ROOT}/ACE_wrappers

echo ${ACE_ROOT}

TAO_ROOT=${ACE_ROOT}/TAO
export TAO_ROOT

echo ${TAO_ROOT}

MPC_ROOT=${ACE_ROOT}/MPC
export MPC_ROOT

echo ${MPC_ROOT}

CIAO_ROOT=${TAO_ROOT}/CIAO
export CIAO_ROOT
DANCE_ROOT=${CIAO_ROOT}/DANCE
export DANCE_ROOT

DDS_ROOT=${CIO_ROOT}/connectors/dds4ccm
export DDS_ROOT

export BOOST_ROOT=${PROJECT_THIRDPARTY_PATH}/boost/${BOOST_VERSION}
export BOOST=$BOOST_ROOT

#CORBA TAO
#export PATH=${ACE_ROOT}/ace:${ACE_ROOT}/bin:${ACE_ROOT}/lib:${TAO_ROOT}/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:$PATH
export PATH=${PATH}:${ACE_ROOT}/tao:${ACE_ROOT}/bin:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}
export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}::${ACE_ROOT}/tao:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}

###
# INCLUDE LANGUAGE SPECIFIC
###

# Make a directory with link to several libraries for LIBPATH length restriction
#################################################################################
LIB_LINK_DIR="${PROJECT_OBJ}/lib/${ARCH}"
echo $LIB_LINK_DIR
test ! -d ${LIB_LINK_DIR} && mkdir -p ${LIB_LINK_DIR}
#\rm -f ${LIB_LINK_DIR}/* |& cat >/dev/null
#rm -f ${LIB_LINK_DIR}/*

#ln -s ${PROJECT_THIRDPARTY_PATH}/boost/${BOOST_VERSION}/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/boost
#ln -s ${PROJECT_THIRDPARTY_PATH}/cppunit/${CPPUNIT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/cppunit
#ln -s ${PROJECT_THIRDPARTY_PATH}/gnu/gettext/${GETTEXT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/gettext
#ln -s ${PROJECT_THIRDPARTY_PATH}/xml/xerces/c++/${XERCES_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/xerces

#ln -s ${PROJECT_THIRDPARTY_PATH}/tibco/tibrv/7.2.x/${ARCH}/lib ${LIB_LINK_DIR}/tibrv

#ln -s ${PROJECT_THIRDPARTY_PATH}/database/products/kondor/3.0/UPGRADE_55/src/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/kondordb
#ln -s ${PROJECT_THIRDPARTY_PATH}/database/products/backend/${PROJECT_MAJOR_VERSION_WD}/V20/package/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/nabladb
#ln -s ${PROJECT_THIRDPARTY_PATH}/database/ida/package/V4/v4r29b/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/ida

#ln -s /srv/dist/kplus/30/30.3.03050/common/machine/${ARCH} ${LIB_LINK_DIR}/kplus

#ln -s /database/sybase/openclient/12.51/ESD_17/${ARCH}/lib ${LIB_LINK_DIR}/sybase
#ln -s /database/oracle/openclient/12.51/ESD_17/${ARCH}/lib ${LIB_LINK_DIR}/oracle

#ln -s ${PROJECT_THIRDPARTY_PATH}/infra/common/P104L1_p3/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infra
#ln -s ${PROJECT_THIRDPARTY_PATH}/infrafa/infra11/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa
#ln -s ${PROJECT_THIRDPARTY_PATH}/infrafa/faketat/12002/P104/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa_ketat
#ln -s ${PROJECT_THIRDPARTY_PATH}/infrafa/fareport/30001/P104/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa_report

#################################################################################

case ${MACHINE} in
    sun4sol)
      export LD_LIBRARY_PATH=/usr/lib/lwp
    ;;
    rs6000)
      export LD_LIBRARY_PATH=${PROJECT_OBJ}/lib/${ARCH}/opt/shared:${PROJECT_OBJ}/lib/${ARCH}/opt
    ;;
    *)
      export LD_LIBRARY_PATH=""
    ;;
esac

export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/tibrv
export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/ida
export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/nabladb
export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kondordb
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/sybase
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/oracle
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kplus

#if [ "$ORB" = "tao" ]
#then
#  export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${PROJECT_THIRDPARTY_PATH}/corba/${ORB}/${ORB_VERSION}/lib/${ARCH}.mt/opt/shared
#else
#  export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${PROJECT_THIRDPARTY_PATH}/corba/${ORB}/${ORB_VERSION}/${ARCH}/lib
#fi

#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/boost
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/cppunit
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/gettext
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/xerces

export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/infra
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/infrafa
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/infrafa_ketat

export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:/lib:/usr/lib

# Set in launch.sh report / openreport
#export LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/infrafa_report

#Keep it after source .cshrc.tools
#export TMPLDIR ${PROJECT_DEV}/config/tmpl

# settings  for interactive shells
# environment variable used have to be defined before
#set    prompt="%{\033]0;%n@%M:${DSQUERY} %C2\007%}%B%n@%M:${DSQUERY} %C2 [%?]%#%b "

##
# Alias
##
alias cde="cd ${PROJECT_DEV}/${PROJECT_EXTRACTION}"
alias cdr="cd ${PROJECT_DEV}"
alias cdc="cd ${PROJECT_DEV}/config"
alias cdsh="cd ${PROJECT_DEV}/${PROJECT_EXTRACTION}/setup"
alias cdweb="cd ${PROJECT_DEV}/${PROJECT_EXTRACTION}/setup/web/${CLIENT_SERVER_TYPE}/bin"

#alias cdrl="cd /${PROJECT_RELEASE}/latest"
#alias cdri="cd /${PROJECT_RELEASE}/installed"
#alias cdcu="cd /${PROJECT_RELEASE}/current"

if [ "${ARCH}" = sun4sol ]
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
        if [ "${ARCH}" = x86Linux ]
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
alias tibrvlisten='tibrvlisten -service 7924 -daemon "tcp:7924" -network ";230.232.51.124;"'

alias setEnvFiles="${PROJECT_DEV}/config/setEnvFiles.sh ${PROJECT_DEV}/config/profiles/${PROJECT_USER}.dev.properties \!* --userdev"
alias setEnvFilesAll="${PROJECT_DEV}/config/setEnvFiles.allUserDev.sh ${PROJECT_DEV}/config/profiles/${PROJECT_USER}.dev.properties"

alias chgWorkspace='export USER \!* && export PROJECT_USER \!* && eval ${PROJECT_MAJOR_VERSION}'

export M2_SETTINGS=${WORKSPACE_ENV}/home/.m2/settings.xml
#alias mvn="mvn -s ${M2_SETTINGS}"
#echo "Maven settings are in : ${M2_SETTINGS}"

# PATH Setting
source ${WORKSPACE_ENV}/java/dev.env.sh
source ${WORKSPACE_ENV}/cpp/dev.env.sh

case ${MACHINE} in
  sun4sol)
    test -f /usr/xpg4/bin/grep && alias grep /usr/xpg4/bin/grep
    export PATH=${PATH}:/usr/X/bin
  ;;

  x86Linux)
    #export PATH=${PATH}:/usr/X11R6/bin
    test "$TERM" = "xterm" && export TERM=xterm-color
  ;;

  rs6000)
    export PATH=${PATH}:/usr/X11R6/bin
    export LIBPATH=${LD_LIBRARY_PATH}
    #unexport LD_LIBRARY_PATH
  ;;

  *)
  ;;

esac

####### TRY TO CHANGE PATH TO BE IN THE CURRENT ENVIRONMENT DEVELOPMENT PATH

OLD_PATH=`pwd`
#set NEW_PATH=`echo ${OLD_PATH} | sed -e "s/alban\/[^\/]*\//alban\/${PROJECT_USER}\/30\//"`
NEW_PATH=`echo ${OLD_PATH} | sed -e "s/alban/alban\/${PROJECT_USER}\/30\//"`

if [ "${OLD_PATH}" != "${NEW_PATH}" ]
then
  if [ -d "${NEW_PATH}" ]
  then
        cd ${NEW_PATH}
        echo "Current path UPDATED : cd `pwd`"
  else
        echo "Current path : `pwd`"
  fi
fi

export DISPLAY=localhost:0.0

echo "PATH is ${PATH}"

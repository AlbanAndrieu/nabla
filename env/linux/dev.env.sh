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

if [ -z "$DEV_USER" ]
then
  echo "ERROR: Set DEV_USER environment variable!"
  exit 1
fi

#If you want to use new GCC by default, make sure that your PATH contains /usr/local/bin before /bin and /usr/bin.
#:/sbin:/usr/local/sbin
export PATH=/usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/games
#export LD_LIBRARY_PATH=/usr/local/lib
#cd /usr/bin
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 gcc.exe -> /etc/alternatives/gcc
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 g++.exe -> /etc/alternatives/g++
#ln -s /etc/alternatives/gcc gcc-SAV.exe
#ln -s /etc/alternatives/g++ g++-SAV.exe
#ln -s /usr/bin/gcc-3.exe gcc.exe
#ln -s /usr/bin/g++-3.exe g++.exe

export DEV_MAJOR_VERSION=${DEV_VERSION}

export DEV_BUILD_TYPE=target
#export CLIENT_SERVER_TYPE=weblogic
export CLIENT_SERVER_TYPE=jboss

export DEV_USER_PROFILE="${DEV_ROOT}/integration/config/profiles/${UNIX_USERNAME}.dev.properties"
export DEV_EXTRACTION=ktpplus

export DEV_ROOT=${DEV_HOME}/${DEV_USER}${DEV_MAJOR_VERSION}
export DEV_SRC=${DEV_ROOT}/${DEV_EXTRACTION}
export DEV_OBJ=${DRIVE_PATH}/${DEV_BUILD_TYPE}
export DEV_THIRDPARTY_PATH=${THIRDPARTY_ROOT}
export DEV_RELEASE=${DEV_ROOT}/${DEV_EXTRACTION}/release/${DEV_MAJOR_VERSION}
export DEV_PKG=${DEV_ROOT}/${DEV_EXTRACTION}/pkg/${DEV_MAJOR_VERSION}
export TMPLDIR=${DEV_ROOT}/integration/tmpl

export KPLUS_ROOT=${DEV_THIRDPARTY_PATH}/kondor
export KPLUSTP_SRC=${DEV_SRC}
export KPLUSTP_OBJ=${DEV_OBJ}

#export TIBCO_HOME=${DRIVE_PATH}/Tibco/Tibrv
#export GRAPHVIZ_HOME=${DRIVE_PATH}/Graphviz2.26.3
export QTDIR=/lib/qt3

export HUDSON_HOME=${DRIVE_PATH}/hudson
#export SVN_HOME=/usr/bin/svn
export ORACLE_HOME=${DRIVE_PATH}/oraclexe/app/oracle/product/10.2.0/server
export SYBASE_HOME=${DRIVE_PATH}/Sybase/OCS-15_0/
#export CYGWIN_HOME=${DRIVE_PATH}/cygwin

#export JAVA_HOME="${DRIVE_PATH}/Program\ Files\ \(x86\)/Java/jdk1.5.0_22"
#export ANT_HOME="${DRIVE_PATH}/apache-ant-1.8.0"
#export M2_HOME="${DRIVE_PATH}/apache-maven-2.2.1"
#export LUMBERMILL_HOME="${DRIVE_PATH}/lumbermill-2.0-b3"
echo "Lumbermill port is 4430"

export EDITOR=nedit

#export SVN_EDITOR=${DEV_ROOT}/integration/svneditor_wrapper.sh
export SVN_EDITOR=${EDITOR}

if [ ! -d $DEV_ROOT ]
then
  echo "ERROR: Directory ${DEV_ROOT} doesn't exist!"
  #exit 1
fi


##
# Cleaning LD_LIBRARY_PATH LIBPATH and CLASSPATH
##
if [ -z "$KEEP_ENV" ]
then

  if [ -z "$CLASSPATH" ]
  then
#    echo 'Cleaning $CLASSPATH: '${CLASSPATH}
    export CLASSPATH=""
  fi

  if [ -z "$LD_LIBRARY_PATH" ]
  then
#    echo 'Cleaning $LD_LIBRARY_PATH: '${LD_LIBRARY_PATH}
    export LD_LIBRARY_PATH=""
  fi

  if [ -z "$LIBPATH" ]
  then
#    echo 'Cleaning $LIBPATH: '${LIBPATH}
    export LIBPATH=""
  fi
fi

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
#alias com=/kplustp/dev/home/integration/com.sh
alias myGrep="find . -name '*.*' -exec grep -n \!* {} + -o -name '.svn' -prune -type f"
echo "find . -type d -name ".svn"  -print | xargs rm -Rf"
#find . -name 'pom.xml' | xargs grep appfuse

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

if [ "${ARCH}" = cygwin ]
then
  export CORBA_ROOT=${DEV_THIRDPARTY_PATH}/tao
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
  
  #CORBA TAO
  export PATH=${PATH}:${ACE_ROOT}/tao:${ACE_ROOT}/bin:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}
  export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}::${ACE_ROOT}/tao:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}
  
fi

export BOOST_ROOT=${DEV_THIRDPARTY_PATH}/boost/${BOOST_VERSION}
export BOOST=$BOOST_ROOT

###
# INCLUDE LANGUAGE SPECIFIC
###

# Make a directory with link to several libraries for LIBPATH length restriction
#################################################################################
LIB_LINK_DIR="${DEV_OBJ}/lib/${ARCH}"
echo $LIB_LINK_DIR
test ! -d ${LIB_LINK_DIR} && mkdir -p ${LIB_LINK_DIR}
#\rm -f ${LIB_LINK_DIR}/* |& cat >/dev/null
#rm -f ${LIB_LINK_DIR}/*

#ln -s ${DEV_THIRDPARTY_PATH}/boost/${BOOST_VERSION}/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/boost
#ln -s ${DEV_THIRDPARTY_PATH}/cppunit/${CPPUNIT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/cppunit
#ln -s ${DEV_THIRDPARTY_PATH}/gnu/gettext/${GETTEXT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/gettext
#ln -s ${DEV_THIRDPARTY_PATH}/xml/xerces/c++/${XERCES_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/xerces

#ln -s ${DEV_THIRDPARTY_PATH}/tibco/tibrv/7.2.x/${ARCH}/lib ${LIB_LINK_DIR}/tibrv

#ln -s ${DEV_THIRDPARTY_PATH}/database/products/kondor/3.0/UPGRADE_55/src/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/kondordb
#ln -s ${DEV_THIRDPARTY_PATH}/database/ida/package/V4/v4r29b/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/ida

#ln -s /srv/dist/kplus/30/30.3.03050/common/machine/${ARCH} ${LIB_LINK_DIR}/kplus

#ln -s /database/sybase/openclient/12.51/ESD_17/${ARCH}/lib ${LIB_LINK_DIR}/sybase
#ln -s /database/oracle/openclient/12.51/ESD_17/${ARCH}/lib ${LIB_LINK_DIR}/oracle

#ln -s ${DEV_THIRDPARTY_PATH}/infra/common/P104L1_p3/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infra
#ln -s ${DEV_THIRDPARTY_PATH}/infrafa/infra11/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa
#ln -s ${DEV_THIRDPARTY_PATH}/infrafa/faketat/12002/P104/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa_ketat
#ln -s ${DEV_THIRDPARTY_PATH}/infrafa/fareport/30001/P104/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa_report

#################################################################################

case ${MACHINE} in
    sun4sol)
      export LD_LIBRARY_PATH=/usr/lib/lwp
    ;;
    rs6000)
      export LD_LIBRARY_PATH=${DEV_OBJ}/lib/${ARCH}/opt/shared:${DEV_OBJ}/lib/${ARCH}/opt
    ;;
    *)
      export LD_LIBRARY_PATH=""
    ;;
esac

export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/tibrv
export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/ida
export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kplustpdb
export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kondordb
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/sybase
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/oracle
#export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kplus

#if [ "$ORB" = "tao" ]
#then
#  export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${DEV_THIRDPARTY_PATH}/corba/${ORB}/${ORB_VERSION}/lib/${ARCH}.mt/opt/shared
#else
#  export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:${DEV_THIRDPARTY_PATH}/corba/${ORB}/${ORB_VERSION}/${ARCH}/lib
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
#export TMPLDIR ${DEV_ROOT}/integration/tmpl

# settings  for interactive shells
# environment variable used have to be defined before
#set	prompt="%{\033]0;%n@%M:${DSQUERY} %C2\007%}%B%n@%M:${DSQUERY} %C2 [%?]%#%b "

##
# Alias
##
alias cdk="cd ${DEV_ROOT}/${DEV_EXTRACTION}"
alias cdm="cd ${DEV_ROOT}/mda"
alias cdfe="cd ${DEV_ROOT}/fe"
alias cdkj="cd ${DEV_ROOT}/${DEV_EXTRACTION}/presentation/business/src/main/java/com/reuters/kplustp"
alias cdi="cd ${DEV_ROOT}/integration"
alias cdsh="cd ${DEV_ROOT}/${DEV_EXTRACTION}/setup"
alias cddev="cd ${DEV_ROOT}/${DEV_EXTRACTION}/src"
alias cdinc="cd ${DEV_OBJ}/include/${ARCH}/debug"
alias cdobj="cd ${DEV_OBJ}"
alias cdweb="cd ${DEV_ROOT}/${DEV_EXTRACTION}/setup/web/${CLIENT_SERVER_TYPE}/bin"

#alias cdrl="cd /${DEV_RELEASE}/latest"
#alias cdri="cd /${DEV_RELEASE}/installed"
#alias cdcu="cd /${DEV_RELEASE}/current"

#alias phone="grep -h -i \!* ~/.phone /home/rms/share/adresse.doc"
#alias ant="/kplustp/thirdparty/ant/latest/bin/ant"

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

alias setEnvFiles="${DEV_ROOT}/integration/config/setEnvFiles.sh ${DEV_ROOT}/integration/config/profiles/${DEV_USER}.dev.properties \!* --userdev"
alias setEnvFilesAll="${DEV_ROOT}/integration/config/setEnvFiles.allUserDev.sh ${DEV_ROOT}/integration/config/profiles/${DEV_USER}.dev.properties"

alias chgWorkspace='export USER \!* && export DEV_USER \!* && eval ${DEV_MAJOR_VERSION}'

export M2_SETTINGS=${WORKSPACE_ENV}/home/.m2/settings.xml
#alias mvn="mvn -s ${M2_SETTINGS}"
#echo "Maven settings are in : ${M2_SETTINGS}"

# PATH Setting
source ${WORKSPACE_ENV}/java/dev.env.sh
source ${WORKSPACE_ENV}/cpp/dev.env.sh
#source ${WORKSPACE_ENV}/cpp/runtime.env.sh

alias cleandProject='\rm -rf /kplustp/dev_obj/users/${DEV_USER}${DEV_VERSION}'
#alias builddProject='cdk && buildd && cd presentation/business && ant ejb-jar && cdk && jbuildProject'
alias builddProject='cdk && buildd && jbuildProject'
alias rebuilddProject='cdk && cleandProject && cdk && perlgen && gmdm && builddProject'

alias cleanProject='\rm -rf /kplustp/dev_obj/users/${DEV_USER}${DEV_VERSION}'
alias buildProject='cdk && build && jbuildProject'
alias rebuildProject='cdk && cleanProject && cdk && perlgen -O && gmm && buildProject'

alias updateKplustp="${WORKSPACE_ENV}/scripts/updateKplustp.sh"
alias cppDepend="${WORKSPACE_ENV}/scripts/cppDepend.sh"

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

#alias 28='source ${DEV_HOME}/${DEV_USER}28/${DEV_EXTRACTION}/env/dev.env.csh \!*; test ! -f ~/.cshrc.local || source ~/.cshrc.local \!*'
#alias 30='source ${DEV_HOME}/${DEV_USER}30/${DEV_EXTRACTION}/env/dev.env.sh \!*; test ! -f ~/.bashrc || source ~/.bashrc \!*'
alias 30='. ${WORKSPACE_ENV}/dev.env.sh'

# Continuous integration process aliases
#alias i27 ${HOME}/cruisecontrol27/integration.sh
#alias i28 ${HOME}/cruisecontrol28/integration.sh
#alias i30 ${HOME}/cruisecontrol30/integration.sh

####### TRY TO CHANGE PATH TO BE IN THE CURRENT ENVIRONMENT DEVELOPMENT PATH

OLD_PATH=`pwd`
#set NEW_PATH=`echo ${OLD_PATH} | sed -e "s/alban\/[^\/]*\//alban\/${DEV_USER}\/${DEV_VERSION}\//"`
NEW_PATH=`echo ${OLD_PATH} | sed -e "s/alban/alban\/${DEV_USER}\/${DEV_VERSION}\//"`

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

#export DISPLAY=localhost:0.0
export DISPLAY=:0.0
# test with command xclock

echo "PATH is ${PATH}"

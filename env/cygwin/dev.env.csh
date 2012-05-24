#!/bin/csh -f


####################
### READ ARGUMENTS
####################
set TOOLS_OPTION_PURIFY = ""
set DATABASE_CONFIG = fa_32
setenv PERLGEN_OPTION ""
while ( "$1" != "" )

  switch( "$1" )
    case purify:
      set TOOLS_OPTION_PURIFY = "purify"
      setenv PERLGEN_OPTION "-p"
    breaksw

    default:
      set DATABASE_CONFIG = "$1"
    breaksw

  endsw

  shift
end
###################


if (! $?PROJECT_USER) then
  echo "ERROR: Set PROJECT_USER environment variable!"
  exit 1
endif

#If you want to use new GCC by default, make sure that your PATH contains /usr/local/bin before /bin and /usr/bin.
#:/sbin:/usr/local/sbin
setenv PATH /usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/games:${DRIVE_PATH}/cygwin/bin
#setenv LD_LIBRARY_PATH /usr/local/lib
#cd /usr/bin
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 gcc.exe -> /etc/alternatives/gcc
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 g++.exe -> /etc/alternatives/g++
#ln -s /etc/alternatives/gcc gcc-SAV.exe
#ln -s /etc/alternatives/g++ g++-SAV.exe
#ln -s /usr/bin/gcc-3.exe gcc.exe
#ln -s /usr/bin/g++-3.exe g++.exe

if (! $?PROJECT_EXTRACTION) then
  setenv PROJECT_EXTRACTION backend
endif

if (! $?TERM ) then
  setenv TERM xterm
endif

if (! $?EDITOR) then
  setenv EDITOR ${DRIVE_PATH}/workspace/home/local/${ARCH}/bin/vim
endif

setenv PROJECT_MAJOR_VERSION 30
setenv PROJECT_MAJOR_VERSION_WD 3.0

setenv PROJECT_DEV ${DRIVE_PATH}/workspace/users/albandri10
setenv PROJECT_SRC ${DRIVE_PATH}/workspace/users/albandri10/backend
setenv PROJECT_OBJ ${DRIVE_PATH}/target
setenv PROJECT_USER_PROFILE ${DRIVE_PATH}/workspace/users/albandri10/config/profiles/albandri.dev.properties

setenv PROJECT_THIRDPARTY_PATH ${DRIVE_PATH}/thirdparty
setenv PROJECT_THIRDPARTY_PATH ${DRIVE_PATH}/thirdparty
setenv PROJECT_RELEASE ${DRIVE_PATH}/nabla/deploy/${PROJECT_MAJOR_VERSION}
setenv PROJECT_PKG ${DRIVE_PATH}/nabla/pkg/${PROJECT_MAJOR_VERSION}

setenv TIBCO_HOME ${DRIVE_PATH}/Tibco/Tibrv
setenv GRAPHVIZ_HOME ${DRIVE_PATH}/Graphviz2.26.3
setenv QTDIR /lib/qt3

setenv HUDSON_HOME ${DRIVE_PATH}/hudson
setenv SVN_HOME ${DRIVE_PATH}/cygwin/bin
setenv ORACLE_HOME ${DRIVE_PATH}/oraclexe/app/oracle/product/10.2.0/server
setenv SYBASE_HOME ${DRIVE_PATH}/Sybase/OCS-15_0/
setenv CYGWIN_HOME ${DRIVE_PATH}/cygwin

setenv JAVA_HOME ${DRIVE_PATH}/Program\ Files\ \(x86\)/Java/jdk1.5.0_22
setenv JAVA_HOME ${DRIVE_PATH}/Sun/SDK/jdk
setenv ANT_HOME ${DRIVE_PATH}/apache-ant-1.7.1
setenv M2_HOME ${DRIVE_PATH}/apache-maven-3.0.2
setenv LUMBERMILL_HOME ${DRIVE_PATH}/lumbermill-2.0-b3
echo "Lumbermill port is 4430"

setenv ANT_OPTS "-Xmx512m"

#setenv SVN_EDITOR ${DRIVE_PATH}/workspace/home/svneditor_wrapper.sh


if (! -d $PROJECT_DEV) then
  echo "ERROR: Directory ${PROJECT_DEV} doesn't exist!"
  exit 1
endif


##
# Cleaning LD_LIBRARY_PATH LIBPATH and CLASSPATH
##
if (! $?KEEP_ENV) then
  
  if ($?CLASSPATH) then
#    echo 'Cleaning $CLASSPATH: '${CLASSPATH}
    setenv CLASSPATH ""
  endif  
  
  if ($?LD_LIBRARY_PATH) then
#    echo 'Cleaning $LD_LIBRARY_PATH: '${LD_LIBRARY_PATH}
    setenv LD_LIBRARY_PATH ""
  endif
  
  if ($?LIBPATH) then
#    echo 'Cleaning $LIBPATH: '${LIBPATH}
    setenv LIBPATH ""
  endif
endif

if (! $?LD_LIBRARY_PATH) then
  setenv LD_LIBRARY_PATH
endif

###
# Alias
###
alias status "svn status -u"
alias aGrep "find . -type d -name '.svn' -prune -o -type f -exec grep -n \!* {} /dev/null \;"
alias Grep "find . -type d -name '.svn' -prune -o -type f -name '*.[jch]*' -exec grep -n \!* {} /dev/null \;"
alias hGrep "find . -type d -name '.svn' -prune -o -type f -name '*.h' -exec grep -n \!* {} /dev/null \;"

###
# THIRDPARTIES 
###
setenv XML2_VERSION 2.7.4
setenv BOOST_VERSION 1.41.0
setenv GETTEXT_VERSION 0.17
setenv XERCES_VERSION 2.8.0

setenv ORB_VERSION 1_5a
setenv ORB tao
setenv SYBASE ${DRIVE_PATH}/thirdparty/database/sybase/15.0.2/${MACHINE}
setenv SYBASE_OCS OCS-15_0
      
setenv CPPUNIT_VERSION 1.12.0

setenv CORBA_ROOT ${PROJECT_THIRDPARTY_PATH}/tao
setenv ACE_ROOT ${CORBA_ROOT}/ACE_wrappers
setenv TAO_ROOT ${ACE_ROOT}/TAO

setenv ACE_ROOT ${CORBA_ROOT}/ACE_wrappers

setenv TAO_ROOT ${ACE_ROOT}/TAO
setenv CIAO_ROOT ${TAO_ROOT}/CIAO
setenv DANCE_ROOT ${CIAO_ROOT}/DANCE
setenv DDS_ROOT ${CIAO_ROOT}/connectors/dds4ccm
setenv MPC_ROOT ${ACE_ROOT}/MPC

setenv BOOST_ROOT ${PROJECT_THIRDPARTY_PATH}/boost/${BOOST_VERSION}
setenv BOOST $BOOST_ROOT

# Make a directory with link to several libraries for LIBPATH length restriction
#################################################################################
set LIB_LINK_DIR="${PROJECT_DEV}/lib/${ARCH}"
#if ( ! -d "${LIB_LINK_DIR}" ) then
#   mkdir -p "${LIB_LINK_DIR}"
#else
#   \rm -f "${LIB_LINK_DIR}"/* |& cat >/dev/null
#endif

#ln -s ${PROJECT_THIRDPARTY_PATH}/boost/${BOOST_VERSION}/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/boost
#ln -s ${PROJECT_THIRDPARTY_PATH}/cppunit/${CPPUNIT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/cppunit
#ln -s ${PROJECT_THIRDPARTY_PATH}/gnu/gettext/${GETTEXT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/gettext
#ln -s ${PROJECT_THIRDPARTY_PATH}/xml/xerces/c++/${XERCES_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/xerces

#ln -s ${PROJECT_THIRDPARTY_PATH}/tibco/tibrv/8.1.2/${ARCH}/lib ${LIB_LINK_DIR}/tibrv

#ln -s ${PROJECT_THIRDPARTY_PATH}/database/products/kondor/5.0/UPGRADE_98/src/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/kondordb
#ln -s ${PROJECT_THIRDPARTY_PATH}/database/products/backend/${PROJECT_MAJOR_VERSION_WD}/V98/package/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/nabladb
#ln -s ${PROJECT_THIRDPARTY_PATH}/database/ida/package/V4/v4r33/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/ida

# Replaced link because official K+ release does not exist yet 
#ln -s /srv/dist/kplus/30/30.3.05000/common/machine/${ARCH} ${LIB_LINK_DIR}/kplus

#ln -s /kplus/tools/adfin/6.0.0.0711/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/adfin

#ln -s /database/sybase/openclient/12.51/ESD_17/${ARCH}/lib ${LIB_LINK_DIR}/sybase

#ln -s ${PROJECT_THIRDPARTY_PATH}/infra/common/P104L1_p5/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infra
#ln -s ${PROJECT_THIRDPARTY_PATH}/infrafa/infra14/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa
#ln -s ${PROJECT_THIRDPARTY_PATH}/infrafa/faketat/30-12014/P104/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa_ketat
#ln -s ${PROJECT_THIRDPARTY_PATH}/infrafa/fareport/380005/P104/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa_report

#ln -s ${PROJECT_THIRDPARTY_PATH}/KML/V1/v1r05/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/kml
#ln -s ${PROJECT_THIRDPARTY_PATH}/libxml2/2.7.4/${ARCH}/lib ${LIB_LINK_DIR}/xml2

#################################################################################

switch( ${MACHINE} )
    case x86sol:
    case sun4sol:
      setenv LD_LIBRARY_PATH /usr/lib/lwp
    breaksw
    case rs6000:
      setenv LD_LIBRARY_PATH ${PROJECT_OBJ}/lib/${ARCH}/opt/shared:${PROJECT_OBJ}/lib/${ARCH}/opt
    breaksw
    default:
      setenv LD_LIBRARY_PATH ""
    breaksw
 endsw 

setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/tibrv
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/sybase
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/ida
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/nabladb
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kondordb
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kplus
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/adfin

#CORBA TAO
if ( "$ORB" == "tao" ) then
  setenv MPC_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/MPC
  setenv CIAO_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/TAO/CIAO
  setenv DANCE_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/TAO/CIAO/DANCE
  setenv DDS_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/TAO/CIAO/connectors/dds4ccm
  setenv PATH ${PATH}:${ACE_ROOT}/tao:${ACE_ROOT}/bin:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}
  setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}::${ACE_ROOT}/tao:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}
#else
#  setenv PATH ${PATH}:${CORBA_ROOT}/lib/${ARCH}.mt/opt/shared
#  setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${CORBA_ROOT}/lib
endif

setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/boost
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/cppunit
#setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/gettext
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/xerces

setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/xml2

setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:/lib:/usr/lib

# Development library path, opt first, then debug
setenv LD_LIBRARY_PATH ${PROJECT_OBJ}/lib/${ARCH}/debug:${PROJECT_OBJ}/lib/${ARCH}/debug/shared:${LD_LIBRARY_PATH}
setenv LD_LIBRARY_PATH ${PROJECT_OBJ}/lib/${ARCH}/opt:${PROJECT_OBJ}/lib/${ARCH}/opt/shared:${LD_LIBRARY_PATH}

# settings  for interactive shells
# environment variable used have to be defined before
#set PROMPT="'$P$G'"

##
# Alias
##

alias cdk 'cd ${PROJECT_DEV}/backend'
alias cdi 'cd ${PROJECT_DEV}/config'
alias cdsh 'cd ${PROJECT_DEV}/backend/setup'
alias cdinc 'cd ${PROJECT_OBJ}/include/${ARCH}'
alias cdobj 'cd ${PROJECT_OBJ}/'

alias cdweb 'cd ${PROJECT_DEV}/backend/setup/web/jboss /bin'

alias cdcore 'cd ${PROJECT_OBJ}/corefiles'
alias .. "cd .."
alias cls "clear"

alias cdrl "cd ${DRIVE_PATH}/nabla/deploy/${PROJECT_MAJOR_VERSION}/latest"
alias cdri "cd ${DRIVE_PATH}/nabla/deploy/${PROJECT_MAJOR_VERSION}/x86_installed"
alias cdrt "cd ${DRIVE_PATH}/nabla/deploy/${PROJECT_MAJOR_VERSION}/test"
alias cdcu "cd ${DRIVE_PATH}/workspace/users/current${PROJECT_MAJOR_VERSION}"

alias ls                /bin/ls -F

if (${ARCH} == sun4sol || ${ARCH} == x86sol) then
  alias l               /bin/ls -Fl
  alias pp              /usr/ucb/ps -auxwww
  if ( `uname -s` == "SunOS" && `uname -r` != "5.8" ) then
      # Workaround to display the whole line with ps command
      alias pp            sudo /usr/ucb/ps -auxwww
  endif
  alias m               /usr/ucb/more
else if (${ARCH} == sun4) then
  alias l               /bin/ls -Flg
  alias pp              /usr/bin/ps -auxwww
else if (${ARCH} == rs6000) then
  alias l               /bin/ls -Fl
  alias pp              /usr/bin/ps auxwww
  alias m               /usr/bin/more
else if (${ARCH} == hprisc) then
  alias l               /bin/ls -Fl
  alias pp              /bin/ps -edf
else if (${ARCH} == x86Linux) then
  alias l               /bin/ls -Fl --color
  alias pp              /bin/ps -auxwww
endif

alias lt                l -t
alias lrt               l -rt
alias l~                l ~
alias ll                l -a
alias la                l -al
alias llt               ll -t
alias llrt              ll -rt
alias ll~               ll ~

alias psg               "pp | egrep -i \!* |& grep -v 'egrep -i \!*'"
alias psuser            "pp | cut -d' ' -f1 | sort | grep -v USER | uniq -c | sort -r"

alias tibrvlisten       'tibrvlisten -service 7924 -daemon "tcp:7924" -network ";230.232.51.124;"' 

alias setEnvFiles       '${PROJECT_DEV}/config/setEnvFiles.sh ${PROJECT_USER_PROFILE} \!* --userdev'
alias setEnvFilesAll    '${PROJECT_DEV}/config/setEnvFiles.allUserDev.sh ${PROJECT_USER_PROFILE}'

alias setWorkspace      "source ${WORKSPACE_ENV}/scripts/setWorkspace.csh"

alias svnCommit         "${WORKSPACE_ENV}/scripts/svnCommit.sh"

alias setVersionFiles   '${PROJECT_DEV}/config/buildfactory/src/main/script/setVersions.sh ${PROJECT_DEV}/backend/'

#alias mvn               'mvn -s ${WORKSPACE_ENV}/home/.m2/settings.xml'

alias echoFailed 'test $status != 123 && ( echo && echo ================== && echo BUILD FAILED && echo ================== && echo && exit 123 )'

source ${WORKSPACE_ENV}/java/dev.env.csh
source ${WORKSPACE_ENV}/cpp/dev.env.csh

alias cleandProject '( ( removeDevObj && forceBuildIdl ) || echoFailed )'
alias builddProject '( ( setVersionFiles && cdk && buildd && jbuildProject ) || echoFailed )'
alias rebuilddProject '( ( cdk && cleandProject && cdk && gmdm && builddProject ) || echoFailed )'

alias cleanProject '( ( removeDevObj && forceBuildIdl ) || echoFailed )'
alias buildProject '( ( setVersionFiles && cdk && build && jbuildProject ) || echoFailed )'
alias rebuildProject '( ( cdk && cleanProject && cdk && gmm && buildProject ) || echoFailed )'

alias replace "${WORKSPACE_ENV}/scripts/replace.pl"
alias svndi "svn di --diff-cmd=svndiff"

####### TRY TO CHANGE PATH TO BE IN THE CURRENT ENVIRONMENT DEVELOPMENT PATH

set OLD_PATH=`pwd`
set USER_PATH=`echo ${PROJECT_DEV} | sed -e 's:/*$::' | sed -e 's:^.*/::'`
set NEW_PATH=`echo ${OLD_PATH} | sed -e "s/users\/[^\/]*\//users\/${USER_PATH}\//"`

if ( "${OLD_PATH}" != "${NEW_PATH}" && -d "${NEW_PATH}" ) then
        cd ${NEW_PATH}
#        echo "Current path UPDATED : `pwd`"
else
#        echo "Current path : `pwd`"
endif

#### Core path definition
if ( "${ARCH}" == "rms" ) then
  # Create corefiles directory if not exist
  if (! -d ${PROJECT_OBJ}/corefiles) then
    mkdir -p ${PROJECT_OBJ}/corefiles
  endif

  # Set core to be generated in corefiles directory
  coreadm -p ${PROJECT_OBJ}/corefiles/core.%f.$PROJECT_MAJOR_VERSION.%n.%p $$

  # remove existing core files
  find ${PROJECT_OBJ}/corefiles/ -type f -name "core*" -atime +4 -exec rm {} \;
endif

echo "PATH is ${PATH}"

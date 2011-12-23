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


if (! $?KPLUSTP_USER) then
  echo "ERROR: Set KPLUSTP_USER environment variable!"
  exit 1
endif

#If you want to use new GCC by default, make sure that your PATH contains /usr/local/bin before /bin and /usr/bin.
#:/sbin:/usr/local/sbin
setenv PATH /usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/games:/cygdrive/c/cygwin/bin
#setenv LD_LIBRARY_PATH /usr/local/lib
#cd /usr/bin
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 gcc.exe -> /etc/alternatives/gcc
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 g++.exe -> /etc/alternatives/g++
#ln -s /etc/alternatives/gcc gcc-SAV.exe
#ln -s /etc/alternatives/g++ g++-SAV.exe
#ln -s /usr/bin/gcc-3.exe gcc.exe
#ln -s /usr/bin/g++-3.exe g++.exe

if (! $?KPLUSTP_EXTRACTION) then
  setenv KPLUSTP_EXTRACTION ktpplus
endif

if (! $?TERM ) then
  setenv TERM xterm
endif

if (! $?EDITOR) then
  setenv EDITOR /cygdrive/c/workspace/home/local/${ARCH}/bin/vim
endif

setenv KPLUSTP_MAJOR_VERSION 30
setenv KPLUSTP_MAJOR_VERSION_WD 3.0

setenv KPLUSTP_DEV /cygdrive/c/workspace/users/albandri30
setenv KPLUSTP_SRC /cygdrive/c/workspace/users/albandri30/ktpplus
setenv KPLUSTP_OBJ /cygdrive/c/target
setenv TMPLDIR /cygdrive/c/workspace/users/albandri30/integration/tmpl
setenv KPLUSTP_USER_PROFILE /cygdrive/c/workspace/users/albandri30/integration/config/profiles/albandri.dev.properties

setenv THIRDPARTY_ROOT /cygdrive/c/thirdparty
setenv KPLUSTP_THIRDPARTY_PATH /cygdrive/c/thirdparty
setenv KPLUSTP_RELEASE /cygdrive/c/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}
setenv KPLUSTP_PKG /cygdrive/c/kplustp/pkg/${KPLUSTP_MAJOR_VERSION}

setenv KPLUS_ROOT ${KPLUSTP_THIRDPARTY_PATH}/kondor

setenv TIBCO_HOME /cygdrive/c/Tibco/Tibrv
setenv GRAPHVIZ_HOME /cygdrive/c/Graphviz2.26.3
setenv QTDIR /lib/qt3

setenv HUDSON_HOME /cygdrive/c/hudson
setenv SVN_HOME /cygdrive/c/cygwin/bin
setenv ORACLE_HOME /cygdrive/c/oraclexe/app/oracle/product/10.2.0/server
setenv SYBASE_HOME /cygdrive/c/Sybase/OCS-15_0/
setenv CYGWIN_HOME /cygdrive/c/cygwin

setenv JAVA_HOME /cygdrive/c/Program\ Files\ \(x86\)/Java/jdk1.5.0_22
setenv JAVA_HOME /cygdrive/c/Sun/SDK/jdk
setenv ANT_HOME /cygdrive/c/apache-ant-1.7.1
setenv M2_HOME /cygdrive/c/apache-maven-2.2.1
setenv LUMBERMILL_HOME /cygdrive/c/lumbermill-2.0-b3
echo "Lumbermill port is 4430"

setenv ANT_OPTS "-Xmx512m"

#setenv SVN_EDITOR /cygdrive/c/workspace/home/svneditor_wrapper.sh


if (! -d $KPLUSTP_DEV) then
  echo "ERROR: Directory ${KPLUSTP_DEV} doesn't exist!"
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
alias com /cygdrive/c/workspace/users/albandri30/integration/tools/com/com.sh
alias launcher 'source ${WORKSPACE_ENV}/scripts/launcher/launcher.csh'

###
# THIRDPARTIES 
###
setenv XML2_VERSION 2.7.4
setenv BOOST_VERSION 1.41.0
setenv GETTEXT_VERSION 0.17
setenv XERCES_VERSION 2.8.0

setenv ORB_VERSION 1_5a
setenv ORB tao
setenv SYBASE /cygdrive/c/thirdparty/database/sybase/15.0.2/${MACHINE}
setenv SYBASE_OCS OCS-15_0
      
setenv CPPUNIT_VERSION 1.12.0

setenv CORBA_ROOT ${KPLUSTP_THIRDPARTY_PATH}/tao
setenv ACE_ROOT ${CORBA_ROOT}/ACE_wrappers
setenv TAO_ROOT ${ACE_ROOT}/TAO

setenv ACE_ROOT ${CORBA_ROOT}/ACE_wrappers

setenv TAO_ROOT ${ACE_ROOT}/TAO
setenv CIAO_ROOT ${TAO_ROOT}/CIAO
setenv DANCE_ROOT ${CIAO_ROOT}/DANCE
setenv DDS_ROOT ${CIAO_ROOT}/connectors/dds4ccm
setenv MPC_ROOT ${ACE_ROOT}/MPC

setenv BOOST_ROOT ${KPLUSTP_THIRDPARTY_PATH}/boost/${BOOST_VERSION}
setenv BOOST $BOOST_ROOT

###
# INCLUDE LANGUAGE SPECIFIC
###

switch( ${ARCH} )
    case rms:
      set tools="unix x11 rms sunpro_local aide gnu ${DATABASE_CONFIG} ${TOOLS_OPTION_PURIFY}"
      source /home/rms/.cshrc.tools
      unset tools
    breaksw
    case winnt:
      setenv DSQUERY FA_32
    breaksw
    default:
    breaksw
endsw

# Make a directory with link to several libraries for LIBPATH length restriction
#################################################################################
set LIB_LINK_DIR="${KPLUSTP_DEV}/lib/${ARCH}"
#if ( ! -d "${LIB_LINK_DIR}" ) then
#   mkdir -p "${LIB_LINK_DIR}"
#else
#   \rm -f "${LIB_LINK_DIR}"/* |& cat >/dev/null
#endif

#ln -s ${KPLUSTP_THIRDPARTY_PATH}/boost/${BOOST_VERSION}/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/boost
#ln -s ${KPLUSTP_THIRDPARTY_PATH}/cppunit/${CPPUNIT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/cppunit
#ln -s ${KPLUSTP_THIRDPARTY_PATH}/gnu/gettext/${GETTEXT_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/gettext
#ln -s ${KPLUSTP_THIRDPARTY_PATH}/xml/xerces/c++/${XERCES_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/xerces

#ln -s ${KPLUSTP_THIRDPARTY_PATH}/tibco/tibrv/8.1.2/${ARCH}/lib ${LIB_LINK_DIR}/tibrv

#ln -s ${KPLUSTP_THIRDPARTY_PATH}/database/products/kondor/5.0/UPGRADE_98/src/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/kondordb
#ln -s ${KPLUSTP_THIRDPARTY_PATH}/database/products/ktpplus/${KPLUSTP_MAJOR_VERSION_WD}/V98/package/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/kplustpdb
#ln -s ${KPLUSTP_THIRDPARTY_PATH}/database/ida/package/V4/v4r33/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/ida

# Replaced link because official K+ release does not exist yet 
#ln -s /srv/dist/kplus/30/30.3.05000/common/machine/${ARCH} ${LIB_LINK_DIR}/kplus

#ln -s /kplus/tools/adfin/6.0.0.0711/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/adfin

#ln -s /database/sybase/openclient/12.51/ESD_17/${ARCH}/lib ${LIB_LINK_DIR}/sybase

#ln -s ${KPLUSTP_THIRDPARTY_PATH}/infra/common/P104L1_p5/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infra
#ln -s ${KPLUSTP_THIRDPARTY_PATH}/infrafa/infra14/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa
#ln -s ${KPLUSTP_THIRDPARTY_PATH}/infrafa/faketat/30-12014/P104/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa_ketat
#ln -s ${KPLUSTP_THIRDPARTY_PATH}/infrafa/fareport/380005/P104/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/infrafa_report

#ln -s ${KPLUSTP_THIRDPARTY_PATH}/KML/V1/v1r05/lib/${ARCH}/opt/shared ${LIB_LINK_DIR}/kml
#ln -s ${KPLUSTP_THIRDPARTY_PATH}/libxml2/2.7.4/${ARCH}/lib ${LIB_LINK_DIR}/xml2

#################################################################################

switch( ${MACHINE} )
    case x86sol:
    case sun4sol:
      setenv LD_LIBRARY_PATH /usr/lib/lwp
    breaksw
    case rs6000:
      setenv LD_LIBRARY_PATH ${KPLUSTP_OBJ}/lib/${ARCH}/opt/shared:${KPLUSTP_OBJ}/lib/${ARCH}/opt
    breaksw
    default:
      setenv LD_LIBRARY_PATH ""
    breaksw
 endsw 

setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/tibrv
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/sybase
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/ida
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kplustpdb
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kondordb
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kplus
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/adfin

#CORBA TAO
if ( "$ORB" == "tao" ) then
  setenv MPC_ROOT /cygdrive/c/thirdparty/tao/ACE_wrappers/MPC
  setenv CIAO_ROOT /cygdrive/c/thirdparty/tao/ACE_wrappers/TAO/CIAO
  setenv DANCE_ROOT /cygdrive/c/thirdparty/tao/ACE_wrappers/TAO/CIAO/DANCE
  setenv DDS_ROOT /cygdrive/c/thirdparty/tao/ACE_wrappers/TAO/CIAO/connectors/dds4ccm
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

setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/infra
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/infrafa
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/infrafa_ketat

setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/xml2
setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/kml

setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:/lib:/usr/lib

# Set in launch.sh report / openreport
#setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/infrafa_report

#KSP Integration : Needed to launch K+ batch on External Deals
#setenv LD_LIBRARY_PATH  ${LD_LIBRARY_PATH}:${KSP_HOME_DIR}/lib/${ARCH}

# Development library path, opt first, then debug
setenv LD_LIBRARY_PATH ${KPLUSTP_OBJ}/lib/${ARCH}/debug:${KPLUSTP_OBJ}/lib/${ARCH}/debug/shared:${LD_LIBRARY_PATH}
setenv LD_LIBRARY_PATH ${KPLUSTP_OBJ}/lib/${ARCH}/opt:${KPLUSTP_OBJ}/lib/${ARCH}/opt/shared:${LD_LIBRARY_PATH}

#Keep it after source .cshrc.tools
setenv TMPLDIR ${KPLUSTP_DEV}/integration/tmpl

# settings  for interactive shells
# environment variable used have to be defined before
#set PROMPT="'$P$G'"

##
# Alias
##

alias cdk 'cd ${KPLUSTP_DEV}/ktpplus'
alias cdm 'cd ${KPLUSTP_DEV}/mda'
alias cdfe 'cd ${KPLUSTP_DEV}/fe'
alias cdkj 'cd ${KPLUSTP_DEV}/ktpplus/presentation/business/src/main/java/com/reuters/kplustp'
alias cdi 'cd ${KPLUSTP_DEV}/integration'
alias cdsh 'cd ${KPLUSTP_DEV}/ktpplus/setup'
alias cddev 'cd ${KPLUSTP_DEV}/ktpplus/src'
alias cdinc 'cd ${KPLUSTP_OBJ}/include/${ARCH}'
alias cdobj 'cd ${KPLUSTP_OBJ}/'

alias cdweb 'cd ${KPLUSTP_DEV}/ktpplus/setup/web/jboss /bin'

alias cdcore 'cd ${KPLUSTP_OBJ}/corefiles'
alias .. "cd .."
alias cls "clear"

alias cdrl "cd /cygdrive/c/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/latest"
alias cdri "cd /cygdrive/c/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/x86_installed"
alias cdrt "cd /cygdrive/c/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/test"
alias cdcu "cd /cygdrive/c/workspace/users/current${KPLUSTP_MAJOR_VERSION}"

alias phone "grep -h -i \!* ~/.phone /home/rms/share/adresse.doc"
#alias ant "/cygdrive/c/thirdparty/ant/latest/bin/ant"

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

alias setEnvFiles       '${KPLUSTP_DEV}/integration/config/setEnvFiles.sh ${KPLUSTP_USER_PROFILE} \!* --userdev'
alias setEnvFilesAll    '${KPLUSTP_DEV}/integration/config/setEnvFiles.allUserDev.sh ${KPLUSTP_USER_PROFILE}'

alias setWorkspace      "source ${WORKSPACE_ENV}/scripts/setWorkspace.csh"

alias svnCommit         "${WORKSPACE_ENV}/scripts/svnCommit.sh"

alias setVersionFiles   '${KPLUSTP_DEV}/integration/buildfactory/src/main/script/setVersions.sh ${KPLUSTP_DEV}/ktpplus/'

#alias mvn               'mvn -s ${WORKSPACE_ENV}/home/.m2/settings.xml'

alias echoFailed 'test $status != 123 && ( echo && echo ================== && echo BUILD FAILED && echo ================== && echo && exit 123 )'

switch( ${ARCH} )
    case winnt:
      source ${WORKSPACE_ENV}/java/dev.env.csh
      source ${WORKSPACE_ENV}/cpp/dev.env.csh    
    breaksw
    default:
      source ${WORKSPACE_ENV}/java/dev.env.csh
      source ${WORKSPACE_ENV}/cpp/dev.env.csh
      source ${WORKSPACE_ENV}/cpp/runtime.env.csh
    breaksw
endsw

alias removeDevObj '( echo "Cleaning Project..." && ( \rm -rf ${KPLUSTP_OBJ} || test `find ${KPLUSTP_OBJ} -type f ! -name ".nfs*" | wc -l` = 0 ) )'
alias forceBuildIdl '( echo "IDL build workaround..." && find ${KPLUSTP_DEV}/ktpplus -type d -name "\.svn" -prune -o -type f -name "*\.idl" -exec touch {} \; && ( find ${KPLUSTP_DEV}/ktpplus -type d -name "\.svn" -prune -o -type d -name "corba" -print | grep generated | xargs -i rm -rf {} ) )'


alias cleandProject '( ( removeDevObj && forceBuildIdl ) || echoFailed )'
alias builddProject '( ( setVersionFiles && cdk && buildd && jbuildProject ) || echoFailed )'
alias rebuilddProject '( ( cdk && cleandProject && cdk && gmdm && builddProject ) || echoFailed )'

alias cleanProject '( ( removeDevObj && forceBuildIdl ) || echoFailed )'
alias buildProject '( ( setVersionFiles && cdk && build && jbuildProject ) || echoFailed )'
alias rebuildProject '( ( cdk && cleanProject && cdk && gmm && buildProject ) || echoFailed )'

alias updateKplustp "( ${WORKSPACE_ENV}/scripts/updateKplustp.sh \!* || echoFailed )"
alias cppDepend "${WORKSPACE_ENV}/scripts/cppDepend.sh"
alias qaStatus "${WORKSPACE_ENV}/scripts/qaStatus.sh"
alias replace "${WORKSPACE_ENV}/scripts/replace.pl"
alias svndi "svn di --diff-cmd=svndiff"

alias zt ${KPLUSTP_OBJ}/repos/EasyZText/launchEZT.sh

alias updateFromNightly "( ${WORKSPACE_ENV}/scripts/updateFromNightly.sh || echoFailed )"
    
#setenv PATH /cygdrive/c/workspace/home/local/${ARCH}/bin:${PATH}

####### TRY TO CHANGE PATH TO BE IN THE CURRENT ENVIRONMENT DEVELOPMENT PATH

set OLD_PATH=`pwd`
set USER_PATH=`echo ${KPLUSTP_DEV} | sed -e 's:/*$::' | sed -e 's:^.*/::'`
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
  if (! -d ${KPLUSTP_OBJ}/corefiles) then
    mkdir -p ${KPLUSTP_OBJ}/corefiles
  endif

  # Set core to be generated in corefiles directory
  coreadm -p ${KPLUSTP_OBJ}/corefiles/core.%f.$KPLUSTP_MAJOR_VERSION.%n.%p $$

  # remove existing core files
  find ${KPLUSTP_OBJ}/corefiles/ -type f -name "core*" -atime +4 -exec rm {} \;
endif

echo "PATH is ${PATH}"

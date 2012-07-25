#!/bin/csh -f

####################
### READ ARGUMENTS
####################
set TOOLS_OPTION_PURIFY = ""
setenv PERLGEN_OPTION ""
while ( "$1" != "" )

  switch( "$1" )
    case purify:
      set TOOLS_OPTION_PURIFY = "purify"
      setenv PERLGEN_OPTION "-p"
    breaksw

    default:
    breaksw

  endsw

  shift
end
###################

if (! $?PROJECT_USER) then
  echo "ERROR: Set PROJECT_USER environment variable!"
  exit 1
endif

if (! $?PROJECT_VERSION) then
  echo "ERROR: Set PROJECT_VERSION environment variable!"
  exit 1
endif

if (! $?DEV_HOME) then
  echo "ERROR: Set DEV_HOME environment variable!"
  exit 1
endif

if (! $?WORKSPACE_ENV) then
  echo "ERROR: Set WORKSPACE_ENV environment variable!"
  exit 1
endif

if (! $?PROJECT_EXTRACTION) then
  setenv PROJECT_EXTRACTION cpp
endif

if (! $?TERM ) then
  setenv TERM xterm
endif

if (! $?EDITOR) then
  setenv EDITOR nedit
endif
setenv SVN_EDITOR ${EDITOR}

#If you want to use new GCC by default, make sure that your PATH contains /usr/local/bin before /bin and /usr/bin.
#:/sbin:/usr/local/sbin
setenv PATH /usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/games:${DRIVE_PATH}/cygwin/bin
#cd /usr/bin
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 gcc.exe -> /etc/alternatives/gcc
#lrwxrwxrwx 1 Alban None      21 2010-03-02 00:50 g++.exe -> /etc/alternatives/g++
#ln -s /etc/alternatives/gcc gcc-SAV.exe
#ln -s /etc/alternatives/g++ g++-SAV.exe
#ln -s /usr/bin/gcc-3.exe gcc.exe
#ln -s /usr/bin/g++-3.exe g++.exe

# construct path
setenv PATH ""
#setenv PATH "~/bin"
foreach i (\
    /usr/local/bin      \
    /usr/bin            \
    /bin                \
    /usr/sbin           \
    /sbin               \
    /usr/X11R6/bin      \
)
    if ( -d "$i" ) then
        if ( -z "$path" ) then
            setenv PATH $i
        else
            setenv PATH ${PATH}:$i
        endif
    else
        echo "-- Warning: can't append $i to PATH because it doesn't exist."
    endif
end

setenv PROJECT_VERSION 10
setenv PROJECT_MAJOR_VERSION ${PROJECT_VERSION}

setenv PROJECT_BUILD_TYPE target
setenv CLIENT_SERVER_TYPE jboss

setenv PROJECT_DEV ${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}
setenv PROJECT_SRC ${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}/cpp
setenv PROJECT_TARGET_PATH ${DRIVE_PATH}/${PROJECT_BUILD_TYPE}
setenv PROJECT_USER_PROFILE ${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}/env/config/profiles/albandri.dev.properties

setenv PROJECT_THIRDPARTY_PATH ${DRIVE_PATH}/thirdparty
setenv PROJECT_RELEASE ${PROJECT_TARGET_PATH}/deploy/${PROJECT_MAJOR_VERSION}
setenv PROJECT_PKG ${PROJECT_TARGET_PATH}/pkg/${PROJECT_MAJOR_VERSION}

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

setenv ORB_VERSION 1_5a
setenv ORB tao

setenv SYBASE_VERSION 12.5
setenv SYBASE_HOME ${DRIVE_PATH}/Sybase/${SYBASE_OCS}/
#setenv SYBASE_HOME ${PROJECT_THIRDPARTY_PATH}/database/sybase
setenv SYBASE ${SYBASE_HOME}/${SYBASE_VERSION}/${MACHINE}
setenv SYBASE_OCS OCS-15_0

setenv ORACLE_VERSION 10.2.0
#setenv ORACLE_HOME ${DRIVE_PATH}/oraclexe
setenv ORACLE_HOME ${DRIVE_PATH}/oraclexe/app/oracle/product/${ORACLE_VERSION}/server
      
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

setenv BOOST_VERSION 1.41.0
setenv GETTEXT_VERSION 0.17
setenv XERCES_VERSION 2.8.0
setenv XML2_VERSION 2.7.2
setenv TIBRV_VERSION 7.2.x

setenv BOOST_ROOT ${PROJECT_THIRDPARTY_PATH}/boost/${BOOST_VERSION}
setenv BOOST $BOOST_ROOT

setenv QTDIR /lib/qt3

# TIBCO
setenv TIBCO_HOME ${DRIVE_PATH}/Tibco/Tibrv
setenv PATH ${PATH}:${TIBCO_HOME}/bin

# GRAPHVIZ
setenv GRAPHVIZ_HOME ${DRIVE_PATH}/Graphviz2.26.3
setenv PATH ${PATH}:${GRAPHVIZ_HOME}/bin

setenv HUDSON_HOME ${DRIVE_PATH}/hudson
setenv CYGWIN_HOME ${DRIVE_PATH}/cygwin
setenv SVN_HOME ${CYGWIN_HOME}/bin

#setenv CMAKE_HOME ${DRIVE_PATH}/CMake-2.6.4
setenv CMAKE_HOME ${CYGWIN_HOME}/usr/share/cmake-2.6.4
setenv CMAKE_ROOT ${CMAKE_HOME}

# JAVA
#setenv JAVA_HOME ${KPLUSTP_THIRDPARTY}/j2se/${ARCH}/jdk1.5
#setenv JAVA_HOME "C:\\Program\ Files\ \(x86\)\\Java\\jdk1.5.0_22"
ln -s ${DRIVE_PATH}/Program\ Files\ \(x86\) /ProgramFilesx86
#setenv JAVA_HOME /ProgramFilesx86/Java/jdk1.5.0_22
setenv JAVA_HOME "${DRIVE_PATH}/Sun/SDK/jdk"

setenv JRE_HOME ${JAVA_HOME}/jre
setenv PATH ${PATH}:${JAVA_HOME}/bin

# MAVEN
setenv M2_HOME ${DRIVE_PATH}/apache-maven-3.0.4
setenv M2 ${M2_HOME}/bin
setenv MAVEN_DIR ${M2_HOME}
#setenv MAVEN_OPTS "-Xmx1548m"
#setenv MAVEN_OPTS "-Xmx512M -XX:MaxPermSize=1024M"
setenv MAVEN_OPTS "-Xms512m -Xmx1024m"
setenv PATH ${PATH}:${M2}

# ANT 
setenv ANT_HOME ${DRIVE_PATH}/apache-ant-1.8.0
setenv ANT_OPTS "-Xmx512m"
setenv PATH ${PATH}:${ANT_HOME}/bin

# JBOSS
setenv JBOSS_HOME "${DRIVE_PATH}/jboss-4.2.2.GA"
setenv PATH ${JBOSS_HOME}/bin:$PATH

setenv CATALINA_HOME ${JBOSS_HOME}/server/default
#setenv CATALINA_OPTS "-Dappserver.home=$CATALINA_HOME -Dappserver.base=$CATALINA_HOME"
alias jboss '${JBOSS_HOME}/bin/run.sh > ${PROJECT_DEV}/jboss.txt'

# ECLIPSE
setenv ECLIPSE_HOME ${DRIVE_PATH}/eclipse-3.7
setenv PATH ${ECLIPSE_HOME}:$PATH
alias eclipse '${ECLIPSE_HOME}/eclipse'

# LUMBERMILL
setenv LUMBERMILL_HOME ${DRIVE_PATH}/lumbermill-2.0-b3
setenv PATH ${PATH}:${LUMBERMILL_HOME}/bin
alias lumbermill 'java -jar ${LUMBERMILL_HOME}/dist/lib/lumbermill.jar'
echo "Lumbermill port is 4430"

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
#ln -s ${PROJECT_THIRDPARTY_PATH}/libxml2/${XML2_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/xml2
#ln -s ${PROJECT_THIRDPARTY_PATH}/tibco/tibrv/${TIBRV_VERSION}/${ARCH}/lib ${LIB_LINK_DIR}/tibrv

#ln -s ${SYBASE_HOME}/openclient/12.51/ESD_17/${ARCH}/lib ${LIB_LINK_DIR}/sybase

#################################################################################

switch( ${MACHINE} )
    case x86sol:
    case sun4sol:
      setenv LD_LIBRARY_PATH /usr/lib/lwp
    breaksw
    case rs6000:
      setenv LD_LIBRARY_PATH ${PROJECT_TARGET_PATH}/lib/${ARCH}/opt/shared:${PROJECT_TARGET_PATH}/lib/${ARCH}/opt
    breaksw
    default:
      setenv LD_LIBRARY_PATH ""
    breaksw
 endsw 

#setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/tibrv
#setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/sybase

#CORBA TAO
if ( "$ORB" == "tao" ) then
  setenv MPC_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/MPC
  setenv CIAO_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/TAO/CIAO
  setenv DANCE_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/TAO/CIAO/DANCE
  setenv DDS_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers/TAO/CIAO/connectors/dds4ccm
  setenv PATH ${PATH}:${ACE_ROOT}/tao:${ACE_ROOT}/bin:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}
  setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}::${ACE_ROOT}/tao:${ACE_ROOT}/lib:${ACE_ROOT}/TAO/orbsvcs:${MPC_ROOT}:${CIAO_ROOT}:${DANCE_ROOT}:${DDS_ROOT}
endif

#setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/boost
#setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/cppunit
#setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/gettext
#setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/xerces
#setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:${LIB_LINK_DIR}/xml2

setenv LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:/lib:/usr/lib

# Development library path, opt first, then debug
setenv LD_LIBRARY_PATH ${PROJECT_TARGET_PATH}/lib/${ARCH}/debug:${PROJECT_TARGET_PATH}/lib/${ARCH}/debug/shared:${LD_LIBRARY_PATH}
setenv LD_LIBRARY_PATH ${PROJECT_TARGET_PATH}/lib/${ARCH}/opt:${PROJECT_TARGET_PATH}/lib/${ARCH}/opt/shared:${LD_LIBRARY_PATH}

# settings  for interactive shells
# environment variable used have to be defined before
#set PROMPT="'$P$G'"

##
# Alias
##
alias cde 'cd ${PROJECT_DEV}/${PROJECT_EXTRACTION}'
alias cdr 'cd ${PROJECT_DEV}'
alias cdc 'cd ${PROJECT_DEV}/env/config'
alias cdinc 'cd ${PROJECT_TARGET_PATH}/include/${ARCH}'
alias cdobj 'cd ${PROJECT_TARGET_PATH}'
alias cdbin 'cd ${PROJECT_TARGET_PATH}/bin'

alias cdrl 'cd ${PROJECT_RELEASE}/latest'
alias cdri 'cd ${PROJECT_RELEASE}/installed'
alias cdcu 'cd ${PROJECT_RELEASE}/current'

alias cdcore 'cd ${PROJECT_TARGET_PATH}/corefiles'
alias .. 'cd ..'
alias cls 'clear'

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
else if (${ARCH} == x86Linux || ${ARCH} == cygwin) then
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

alias setEnvFiles       '${WORKSPACE_ENV}/config/setEnvFiles.sh ${PROJECT_USER_PROFILE} \!* --userdev'
alias setEnvFilesAll    '${WORKSPACE_ENV}/config/setEnvFiles.allUserDev.sh ${PROJECT_USER_PROFILE}'

alias setWorkspace      "source ${WORKSPACE_ENV}/scripts/setWorkspace.csh"

setenv M2_SETTINGS ${WORKSPACE_ENV}/home/.m2/settings.xml
#alias mvn               'mvn -s ${M2_SETTINGS}'

# PATH Setting
#source ${WORKSPACE_ENV}/java/dev.env.csh
#source ${WORKSPACE_ENV}/cpp/dev.env.csh

alias replace "${WORKSPACE_ENV}/scripts/replace.pl"
alias svndi "svn di --diff-cmd=svndiff"

####### TRY TO CHANGE PATH TO BE IN THE CURRENT ENVIRONMENT DEVELOPMENT PATH

set OLD_PATH=`pwd`
set CURRENT_USER=`echo ${PROJECT_DEV} | sed -e 's:/*$::' | sed -e 's:^.*/::'`
set NEW_PATH=`echo ${OLD_PATH} | sed -e "s/\/${CURRENT_USER}/\/${PROJECT_USER}${PROJECT_VERSION}/"`

if ( "${OLD_PATH}" != "${NEW_PATH}" && -d "${NEW_PATH}" ) then
        echo cd ${NEW_PATH}
#        echo "Current path UPDATED : `pwd`"
else
#        echo "Current path : `pwd`"
endif

#### Core path definition
if ( "${ARCH}" == "sun4sol" ) then
  # Create corefiles directory if not exist
  if (! -d ${PROJECT_TARGET_PATH}/corefiles) then
    mkdir -p ${PROJECT_TARGET_PATH}/corefiles
  endif

  # Set core to be generated in corefiles directory
  coreadm -p ${PROJECT_TARGET_PATH}/corefiles/core.%f.$PROJECT_MAJOR_VERSION.%n.%p $$

  # remove existing core files
  find ${PROJECT_TARGET_PATH}/corefiles/ -type f -name "core*" -atime +4 -exec rm {} \;
endif

setenv DISPLAY Alban-PC:0.0
    
echo "PATH is ${PATH}"
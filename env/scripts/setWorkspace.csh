#!/bin/csh -f

####################
### READ ARGUMENTS
####################
set QUIET_MODE = "No"
set DIR = ""
while ( "$1" != "" )

  switch( "$1" )
    case --quiet:
    case -q:
      set QUIET_MODE = "Yes"
    breaksw

    default:
      set DIR = "$1"
    breaksw
  endsw

  shift
end
###################

switch( ${ARCH} )
    case cygwin:
      set DRIVE_PATH=/cygdrive/c
    breaksw
    default:
      set DRIVE_PATH=
    breaksw
endsw

if ( "${DIR}" == "" ) then
  echo "usage `basename $0` [-quiet] <workspace_directory>"
  exit 1
endif

if ( -d "/${DIR}" ) then
  set DIR="/${DIR}"
else if ( -d "${DRIVE_PATH}/workspace/users/${DIR}" ) then
  set DIR="${DRIVE_PATH}/workspace/users/${DIR}"
else
  test ${QUIET_MODE} != "Yes" && echo "Directory '${DIR}' not found"
  exit 1
endif

set DEV_USER=`echo ${DIR} | sed -e 's:/*$::' | sed -e 's:^.*/::'`

set PROJECT_DIR="${DIR}/cpp/sample"
set PROJECT_TARGET_DIR="${DRIVE_PATH}/target"
set ENV_DIR="${DIR}/env"
set CONFIG_DIR="${ENV_DIR}/config"

foreach i ( ${DIR} ${PROJECT_DIR} ${PROJECT_TARGET_DIR} ${ENV_DIR} ${CONFIG_DIR} )

  if ( ! -d "${i}" ) then
    test ${QUIET_MODE} != "Yes" && echo "Directory '${i}' not found"
    exit 1
  endif

end

if (! $?ARCH) then
  set ARCH=dev
endif


set USER_PROFILE=${CONFIG_DIR}/profiles/${DEV_USER}.${ARCH}.properties
set GENERATION_MODE=patch

if (! $?PROJECT_VERSION) then
  set PROJECT_VERSION=10
endif

if (! $?PROJECT_USER) then
  #set PROJECT_USER=${USER}${PROJECT_VERSION}
  set PROJECT_USER=${USER}
endif

if ( ${?PROJECT_VERSION} ) then
  if ( "${DEV_USER}" == "${PROJECT_USER}${PROJECT_VERSION}" ) then
    set USER_PROFILE=${CONFIG_DIR}/profiles/${DEV_USER}.${ARCH}.properties
    set GENERATION_MODE=user
  endif
endif

###################################################################
#
# If some environement files don't exists, regenerate environment
#
###################################################################

if ( ! -f ${USER_PROFILE} || ! -f ${ENV_DIR}/dev.env.csh || ! -f "${ENV_DIR}/home/.m2/settings.xml" ) then

  test ${QUIET_MODE} != "Yes" && echo "Regenerate environment..."

  if ( ${GENERATION_MODE} == "user" ) then
    if ( ! -f ${USER_PROFILE} ) then
      test ${QUIET_MODE} != "Yes" && echo "User profile doesn't exists : '${USER_PROFILE}' not found"
      exit 1
    endif
  else
    if ( ! -f ${USER_PROFILE} ) then
      # Make it manually
      echo "Generate default environment file : ${USER_PROFILE}"
      cat > ${USER_PROFILE} << EOF
[[USER_INDEX_ID]]=99
[[UNIX_USERNAME]]=${USER}
[[DRIVE_PATH]]=${DRIVE_PATH}
[[RUNNING_SERVICES_SERVER]]=localhost
EOF
    endif
  endif

  echo "Regenerate all environment files"
  ${CONFIG_DIR}/setEnvFiles.sh ${USER_PROFILE} ${ENV_DIR} --userdev > /dev/null
endif

if ( ${GENERATION_MODE} != "user" ) then

  ##############################################
  #
  # Get all environment variables
  #
  ##############################################

  set UNSET_FILE="${ENV_DIR}/${DEV_USER}.unsetenv.$HOST.$$.tmp"
  set SET_FILE="${ENV_DIR}/${DEV_USER}.setenv.$HOST.$$.tmp"

  # Workaround to clean previous variable setting
  #
  #setenv | grep -v ! | grep -v \( | perl -e'while(<STDIN>){ (/[^=]*=.*/) || next; print $_; }'
  setenv | grep -v ! | grep -v \( | perl -e'while(<STDIN>){ (/[^=]*=.*/) || next;  if ( (/^(USER=|HOME=|ARCH=|MACHINE=|PROJECT_USER=|HOST=|DISPLAY=|PATH=|TERM=|HOME=)/) ) { s/([^=]*)=(.*)/unset $1/ } else { s/([^=]*)=(.*)/unset $1\nunsetenv $1/ } print $_; }'> ${UNSET_FILE}

  echo "unset environment variable"
  test ! -x ${UNSET_FILE} && chmod a+x ${UNSET_FILE}
  source ${UNSET_FILE}
  echo "unset environment variable done"

  # Test if a local .cshrc exists
  #
  set LOCAL_CSHRC="test 1"
  if ( -f ~/.cshrc.local ) then
    set LOCAL_CSHRC="source ~/.cshrc.local"
  endif
  
  # Set workspace environement variables
  echo "get environment variables from ${ENV_DIR}/home/dev.env.csh"
  ( source ${ENV_DIR}/home/dev.env.csh \
 && ${LOCAL_CSHRC} \
 && setenv ) | grep -v ! | grep -v \( | perl -e'while(<STDIN>){ s/([^=]*)=(.*)/setenv $1 \"$2\"/ || next; print $_; }' > ${SET_FILE}

  setenv | grep M2_HOME

  echo "set environment variable"
  test ! -x ${SET_FILE} && chmod a+x ${SET_FILE}
  source ${SET_FILE}
  echo "set environment variable done"

  #echo "--- ${SET_FILE}--"
  \rm -f ${UNSET_FILE}
  \rm -f ${SET_FILE}

endif

#################################
#
# Retrieve MAVEN path
#
#################################
if ( ! ${?MAVEN_DIR} ) then

  if ( ${?M2_HOME} ) then 
    set MAVEN_DIR=$M2_HOME
  else
    exit 1
  endif

endif

#################################
#
# Retrieve CPP path in PATH
#
#################################
switch( ${MACHINE} )
    case rs6000:
      set CPP_PATH=`perl -e '@dir=split(/:+/, $ENV{"PATH"}); for $i(0..$#dir) { if ( $dir[$i] =~ /xlccpp/ ) { print $dir[$i],"\n"; last; } }'`
    breaksw
    case sun4sol:
      set CPP_PATH=`perl -e '@dir=split(/:+/, $ENV{"PATH"}); for $i(0..$#dir) { if ( $dir[$i] =~ /studio/ ) { print $dir[$i],"\n"; last; } }'`
    breaksw
    default:
      set CPP_PATH=`perl -e '@dir=split(/:+/, $ENV{"PATH"}); for $i(0..$#dir) { print $dir[$i],"\n";}'`
    breaksw
endsw

#####################################################

setenv PROJECT_DEV ${DIR}
setenv PROJECT_SRC ${PROJECT_DIR}
setenv PROJECT_TARGET ${PROJECT_TARGET_DIR}
setenv PROJECT_USER_PROFILE ${USER_PROFILE}

if ( "${QUIET_MODE}" != "Yes" ) then
  echo "DEV extraction: 	${PROJECT_DEV}"
  echo "SOURCE extraction: 	${PROJECT_SRC}"
  echo "OBJECT directory: 	${PROJECT_TARGET}"
  echo "Profile:                ${PROJECT_USER_PROFILE}"
  echo "MAVEN settings file: 	${ENV_DIR}/home/.m2/settings.xml"
  echo "MAVEN path:             ${MAVEN_DIR}"
  #echo "C++ compilator path: 	${CPP_PATH}"
  echo
endif

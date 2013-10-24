#!/bin/bash

####################
### READ ARGUMENTS
####################

#echo "Total number of arg passed: $#"
#echo "arg values are: $@"
#echo "-----------------------------------------"

USAGE="Usage: $0 --quiet -q"

if [ "$#" == "0" ];
then
	echo "$USAGE"
	exit 1
fi

export DIR=""
export QUIET_MODE="No"

while [ "$1" ] ; do

  #echo "\$1 = $1"


  case "$1" in
    --quiet | -q)
      export QUIET_MODE="Yes"
    ;;
    *)
      export DIR="$1"

      break
    ;;
  esac

  shift
done

#echo "DIR : -$DIR-"
#echo "QUIET_MODE : -$QUIET_MODE-"

###################

case ${ARCH} in
    cygwin)
      export DRIVE_PATH=/cygdrive/c
    ;;
    *)
      export DRIVE_PATH=
    ;;
esac

if [ "${DIR}" == "" ];
then
  echo "usage `basename $0` [-quiet] <workspace_directory>"
  exit 1
fi

if [ -d "/${DIR}"  ];
then
  DIR="/${DIR}"
elif [ -d "${DRIVE_PATH}/workspace/users/${DIR}" ];
then
  DIR="${DRIVE_PATH}/workspace/users/${DIR}"
else
  test ${QUIET_MODE} != "Yes" && echo "Directory '${DIR}' not found"
  exit 1
fi

export DEV_USER=`echo ${DIR} | sed -e 's:/*$::' | sed -e 's:^.*/::'`

export PROJECT_DIR="${DIR}/cpp/sample"
export PROJECT_TARGET_DIR="${DRIVE_PATH}/target"
export ENV_DIR="${DIR}/env"
export CONFIG_DIR="${ENV_DIR}/config"

for i in ${DIR} ${PROJECT_DIR} ${PROJECT_TARGET_DIR} ${ENV_DIR} ${CONFIG_DIR} ; do

  if [ ! -d "${i}" ];
  then
    test ${QUIET_MODE} != "Yes" && echo "Directory '${i}' not found"
    exit 1
  fi

done

if [ -z "$ARCH" ];
then
  export ARCH=dev
fi

export USER_PROFILE=${CONFIG_DIR}/profiles/${DEV_USER}.${ARCH}.properties
export GENERATION_MODE=patch

if [ -z "$PROJECT_VERSION" ];
then
  export PROJECT_VERSION=10
fi

if [ -z "$PROJECT_USER" ];
then
  #export PROJECT_USER=${USER}${PROJECT_VERSION}
  export PROJECT_USER=${USER}
fi

#echo PROJECT_USER : $PROJECT_USER

if [ -z "$PROJECT_VERSION" ];
then
  if [ "${DEV_USER}" == "${PROJECT_USER}${PROJECT_VERSION}" ];
  then
    export USER_PROFILE=${CONFIG_DIR}/profiles/${DEV_USER}.${ARCH}.properties
    export GENERATION_MODE=user
  fi
fi

#echo USER_PROFILE : $USER_PROFILE -- ${PROJECT_USER} + ${PROJECT_VERSION} -- - $DEV_USER

###################################################################
#
# If some environement files don't exists, regenerate environment
#
###################################################################

if [ ! -f ${USER_PROFILE} -o ! -f ${ENV_DIR}/dev.env.sh -o ! -f "${ENV_DIR}/home/.m2/settings.xml" ];
then

  test ${QUIET_MODE} != "Yes" && echo "Regenerate environment..."

  if [ ${GENERATION_MODE} == "user" ];
  then
    #echo USER_PROFILE : ${USER_PROFILE}
    if [ ! -f ${USER_PROFILE} ];
    then
      test ${QUIET_MODE} != "Yes" && echo "User profile doesn't exists : '${USER_PROFILE}' not found"
      exit 1
    fi
  else
    if [ ! -f ${USER_PROFILE} ];
    then
      # Make it manually
      echo "Generate default environment file : ${USER_PROFILE}"
      cat > ${USER_PROFILE} << EOF
[[USER_INDEX_ID]]=99
[[UNIX_USERNAME]]=${USER}
[[DRIVE_PATH]]=${DRIVE_PATH}
[[RUNNING_SERVICES_SERVER]]=localhost
EOF
    fi
  fi

  echo "Regenerate all environment files : "
  ${CONFIG_DIR}/setEnvFiles.sh ${USER_PROFILE} ${ENV_DIR} --userdev > /dev/null
fi

if [ ${GENERATION_MODE} != "user" ];
then

  ##############################################
  #
  # Get all environment variables
  #
  ##############################################

  export UNSET_FILE="${ENV_DIR}/${DEV_USER}.unsetenv.$HOST.$$.tmp"
  #export SET_FILE="${ENV_DIR}/${DEV_USER}.setenv.$HOST.$$.tmp"

  # Workaround to clean previous variable setting
  #
  #env | grep -v ! | grep -v \( | perl -e'while(<STDIN>){ (/[^=]*=.*/) || next; print $_; }'
  env | grep -v 'asl\.log=' | grep -v 'DIR=' | grep -v 'PROJECT_DIR=' | grep -v 'PROJECT_TARGET_DIR=' | grep -v 'USER_PROFILE=' | grep -v 'ENV_DIR=' | grep -v 'UNSET_FILE=' | grep -v 'SET_FILE=' | grep -v 'SET_FILE=' | grep -v 'USER=' | grep -v 'SET_FILE=' | grep -v 'HOME=' | grep -v 'ARCH=' | grep -v 'MACHINE=' | grep -v 'PROJECT_USER=' | grep -v 'HOST=' | grep -v 'DISPLAY=' | grep -v 'PATH=' | grep -v 'TERM=' | grep -v 'HOME=' | grep -v ! | grep -v \( | perl -e'while(<STDIN>){ (/[^=]*=.*/) || next;  if ( (/^(USER=|HOME=|ARCH=|MACHINE=|PROJECT_USER=|HOST=|DISPLAY=|PATH=|TERM=|HOME=)/) ) { s/([^=]*)=(.*)/unset $1/ } else { s/([^=]*)=(.*)/unset $1/ } print $_; }'> ${UNSET_FILE}

' | grep -v 'DIR=' | grep -v 'PROJECT_DIR=' | grep -v 'PROJECT_TARGET_DIR=' | grep -v 'USER_PROFILE=

  echo "unset environment variable"
  test ! -x ${UNSET_FILE} && chmod a+x ${UNSET_FILE}
  source ${UNSET_FILE}
  echo "unset environment variable done"

  echo ENV_DIR : ${ENV_DIR}

  # Test if a local .bashrc exists
  #
  export LOCAL_BASHRC="test 1"
  if [ -f ~/.bashrc_profile ];
  then
    export LOCAL_BASHRC="source ~/.bashrc_profile"
  fi

  #echo SET_FILE ${SET_FILE} - UNSET_FILE ${UNSET_FILE}

  # Set workspace environement variables
  echo "get environment variables from ${ENV_DIR}/home/dev.env.sh"
  source ${ENV_DIR}/home/dev.env.sh
  ${LOCAL_BASHRC}
  #&& env ) | grep -v ! | grep -v \( | perl -e'while(<STDIN>){ s/([^=]*)=(.*)/export $1 \"$2\"/ || next; print $_; }' > ${SET_FILE}

  #env | grep M2_HOME

  #echo "set environment variable"
  #test ! -x ${SET_FILE} && chmod a+x ${SET_FILE}
  #source ${SET_FILE}
  echo "set environment variable done"

  #echo "--- ${SET_FILE}--"
  \rm -f ${UNSET_FILE}
  #\rm -f ${SET_FILE}

fi

#################################
#
# Retrieve MAVEN path
#
#################################
if [ -z "$MAVEN_DIR" ];
then

  if [ "$M2_HOME" != "" ];
  then
    export MAVEN_DIR=${M2_HOME}
    echo MAVEN_DIR : $MAVEN_DIR
  else
    exit 1
  fi

fi

#################################
#
# Retrieve CPP path in PATH
#
#################################
case ${MACHINE} in
    rs6000)
      export CPP_PATH=`perl -e '@dir=split(/:+/, $ENV{"PATH"}); for $i(0..$#dir) { if ( $dir[$i] =~ /xlccpp/ ) { print $dir[$i],"\n"; last; } }'`
    ;;
    sun4sol)
      export CPP_PATH=`perl -e '@dir=split(/:+/, $ENV{"PATH"}); for $i(0..$#dir) { if ( $dir[$i] =~ /studio/ ) { print $dir[$i],"\n"; last; } }'`
    ;;
    *)
      export CPP_PATH=`perl -e '@dir=split(/:+/, $ENV{"PATH"}); for $i(0..$#dir) { print $dir[$i],"\n";}'`
    ;;
esac

#####################################################

export PROJECT_DEV=${DIR}
export PROJECT_SRC=${PROJECT_DIR}
export PROJECT_TARGET=${PROJECT_TARGET_DIR}
export PROJECT_USER_PROFILE=${USER_PROFILE}

if [ "${QUIET_MODE}" != "Yes" ];
then
  echo "DEV extraction: 	${PROJECT_DEV}"
  echo "SOURCE extraction: 	${PROJECT_SRC}"
  echo "OBJECT directory: 	${PROJECT_TARGET}"
  echo "Profile:                ${PROJECT_USER_PROFILE}"
  echo "MAVEN settings file: 	${ENV_DIR}/home/.m2/settings.xml"
  echo "MAVEN path:             ${MAVEN_DIR}"
  #echo "C++ compilator path: 	${CPP_PATH}"
  echo
fi

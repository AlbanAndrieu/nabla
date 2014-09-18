#!/bin/sh

if [ $# -lt 2 ]
then 
  echo "usage: $0 <user_properties_file> <path_to_set> [--keepsuffix] [--userdev] [--targetfile <file>]"
  exit 1
fi

if [ ! -r $1 ]
then
  echo "$1 doesn't exist or isn't readeable"
  exit
fi

CURRENT_PWD=`pwd`

cd `dirname $1`
U_PATH=`pwd`
U_FILE=`basename $1`
USER_PROP_FILE=${U_PATH}/${U_FILE}

cd $CURRENT_PWD

if [ ! -r $2 ]
then
  echo "$2 is not accessible"
  exit 1
fi

ONE_FILE=""
if [ -f $2 ]
then
  # Only one file
  cd `dirname $2`
  ONE_FILE=`basename $2`
else
  # Directory
  cd $2
fi
PATH_P=`pwd`

REPLACE_REMOVE_OPT="-r .j2"
USER_COMMON_PROPERTIES=""
TARGET_FILE=""

while [ "$3" != "" ]; do

    case "$3" in
            
        "--keepsuffix") REPLACE_REMOVE_OPT=""; ;;
        "--userdev") USER_COMMON_PROPERTIES="./profiles/commonUser.dev.properties"; ;;
        "--targetfile")
          shift
          TARGET_FILE=$3
          ;;

    esac
    
    shift
done


cd $CURRENT_PWD
cd `dirname $0`

REPLACE_EXE=./replace_token.pl
THIRDPARTY_PROPERTIES=./profiles/thirdparty.properties

if [ ! -x ${REPLACE_EXE} ]; then
    echo "File ${REPLACE_EXE} not found or not executable"
    exit 1
fi

[ -n "${THIRDPARTY_PROPERTIES}" ] || echo "Warning: properties file name for THIRDPARTY (${THIRDPARTY_PROPERTIES}) not defined"
[ -r ${THIRDPARTY_PROPERTIES} ] || echo "Warning: properties file THIRDPARTY (${THIRDPARTY_PROPERTIES}) not found"
#echo "THIRDPARTY_PROPERTIES : ${THIRDPARTY_PROPERTIES}"
[ -n "${USER_COMMON_PROPERTIES}" ] || echo "Warning: properties file name for USER_COMMON (${USER_COMMON_PROPERTIES}) not defined"
#echo "USER_COMMON_PROPERTIES : ${USER_COMMON_PROPERTIES}"

if [ "${TARGET_FILE}" != "" ]; then

    perl ${REPLACE_EXE} -d -f ${TARGET_FILE} -o ${REPLACE_REMOVE_OPT} -p ${THIRDPARTY_PROPERTIES},${USER_COMMON_PROPERTIES},${USER_PROP_FILE},${USER_PROP_FILE_WIN}

else
  if [ "${ONE_FILE}" != "" ]; then
    perl ${REPLACE_EXE} -d -o ${REPLACE_REMOVE_OPT} -p ${THIRDPARTY_PROPERTIES},${USER_COMMON_PROPERTIES},${USER_PROP_FILE},${USER_PROP_FILE_WIN} ${PATH_P}/${ONE_FILE}
  else
    DEFAULT_LIST_TMP="setEnvFiles.list.`hostname`.$$.tmp"
    find $PATH_P -type f -name "*.j2" -o -name ".*.j2" > ${DEFAULT_LIST_TMP}
    perl ${REPLACE_EXE} -v -f ${DEFAULT_LIST_TMP} -o ${REPLACE_REMOVE_OPT} -p ${THIRDPARTY_PROPERTIES},${USER_COMMON_PROPERTIES},${USER_PROP_FILE},${USER_PROP_FILE_WIN}
    \rm -f ${DEFAULT_LIST_TMP}
  fi
fi

#! /bin/sh


if [ "$1" = "" -o "$1" = "-h" ]; then
  echo "Usage : $0 <Property_file>"
  exit 1
fi

PROPERTYFILE=$1

if [ ! -f "${PROPERTYFILE}" ]; then
  echo "Unable to open file ${PROPERTYFILE}"
  exit 1
fi

OLD_PATH=`pwd`

####### Retrieve absolute path of the property file

cd `dirname ${PROPERTYFILE}`
PROPERTYFILE=`pwd`/`basename ${PROPERTYFILE}`

cd ${OLD_PATH}

####### Set working directory

cd `dirname $0`

if [ ! -x ./setEnvFiles.sh ]; then
  echo "`pwd`/setEnvFiles.sh missing"
  exit 1
fi

####### Create files from .default files and property file

TARGET_LIST="\
../home/ \
../cygwin/ \
../linux/ \
../winnt/ \
"

if [ ! -r setEnvFiles.list.txt ]; then

  # Create list
  #############

  echo "Generate .default list in `pwd`/setEnvFiles.list.txt..."
  touch setEnvFiles.list.txt

  for target in $TARGET_LIST; do
    echo $target
    if [ -d $target ]; then
      find $target -type f -name "*.default" -o -name ".*.default" >> setEnvFiles.list.txt
    else
      if [ -r $target ]; then
        echo $target >> setEnvFiles.list.txt
      else
        echo ERROR on target: $target
        RES=1
      fi
    fi
  done

  cat setEnvFiles.list.txt

else
  
  echo "Use .default list in `pwd`/setEnvFiles.list.txt"

fi

./setEnvFiles.sh ${PROPERTYFILE} . --targetfile setEnvFiles.list.txt --userdev || RES=1

####### Restaure path

cd ${OLD_PATH}

exit ${RES}

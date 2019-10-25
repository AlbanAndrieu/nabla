#!/bin/bash
#set -xv

WORKING_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}"  )" && pwd  )"

# shellcheck source=./step-0-color.sh
source "${WORKING_DIR}/step-0-color.sh"

"${WORKING_DIR}/step-0-1-run-processes-cleaning.sh"

if [ -n "${TARGET_WORKSPACE}" ]; then
  # shellcheck disable=SC2154
  echo -e "${green} TARGET_WORKSPACE is defined ${happy_smiley} ${NC}"
else
  # shellcheck disable=SC2154
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TARGET_WORKSPACE, use the default one ${NC}"
  if [ "$(uname -s)" == "Darwin" ]; then
    export TARGET_WORKSPACE="/Volumes/DATA/Jenkins-slave" # master OSX jenkins
  else
    export TARGET_WORKSPACE="/workspace/slave"
  fi
fi

echo -e "${green} xvfb temp files to clean ${NC}"
find /workspace/slave/xvfb-*.fbdir  -mtime +1 -exec rm -rf {} \;
find ${TARGET_WORKSPACE}/xvfb-*.fbdir  -mtime +1 -exec rm -rf {} \;

echo -e "${green} molecule temp files to clean ${NC}"
find /tmp/molecule/*  -mtime +1 -exec rm -rf {} \;
find /tmp/ara/*  -mtime +1 -exec rm -rf {} \;

echo -e "${green} ansible temp files to clean ${NC}"
find ~/.ansible  -mtime +1 -exec rm -rf {} \;

#git-lfs install || true

# We keep only 1 days of workspace (mtime +1)

if [ "$(uname -s)" != "Darwin" ]; then


  echo -e "${green} workspace to clean ${NC}"
  if [[ -d /workspace/slave/workspace/ ]]
  then
    echo -e "${green} find /workspace/slave/workspace/ -maxdepth 2 -not \( -path '*/.git' -o -path '*/docker-cleaning*' -o -path './repository' -o -path '*/ADMIN_CLEAN_LINUX*' \) -mtime +1 -type d -print ${NC}"
    find /workspace/slave/workspace/ -maxdepth 2 -not \( -path '*/.git' -o -path '*/docker-cleaning*' -o -path './repository' -o -path '*/ADMIN_CLEAN_LINUX*' \) -mtime +1 -type d -exec rm -rf {} \;
  fi
  if [[ -d "${TARGET_WORKSPACE}/workspace/" ]]
  then
    echo -e "${green} find ${TARGET_WORKSPACE}/workspace/ -maxdepth 2 -not \( -path '*/.git' -o -path '*/docker-cleaning*' -o -path './repository' -o -path '*/ADMIN_CLEAN_LINUX*' \) -mtime +1 -type d -print ${NC}"
    find ${TARGET_WORKSPACE}/workspace/ -maxdepth 2 -not \( -path '*/.git' -o -path '*/docker-cleaning*' -o -path './repository' -o -path '*/ADMIN_CLEAN_LINUX*' \) -mtime +1 -type d -exec rm -rf {} \;
  fi
  if [[ -d /data/jenkins/workspace/ ]]
  then
      echo -e "${green} find /data/jenkins/workspace/ -maxdepth 2 -not \( -path '*/.git' -o -path '*/docker-cleaning*' -o -path './repository' -o -path '*/ADMIN_CLEAN_LINUX*' \) -mtime +1 -type d -print ${NC}"
      find /data/jenkins/workspace/ -maxdepth 2 -not \( -path '*/.git' -o -path '*/docker-cleaning*' -o -path './repository' -o -path '*/ADMIN_CLEAN_LINUX*' \) -mtime +1 -type d | xargs -I{} bash -c " echo removing dir {}; rm -rf {}"
  fi

  if [ "$(uname -s)" == "SunOS" ]; then
      # TODO Solaris x86
      if [[ -d /export/home/jenkins ]]
      then
          echo -e "${green} find find /export/home/jenkins/ \( ! -name workspace -o -type f \) -prune -type d -mtime +1 ${NC}"
          find /export/home/jenkins// \( ! -name workspace -o -type f \) -prune -type d -mtime +1 | xargs -I{} bash -c " echo removing dir {}; rm -rf {}"
      fi
      # TODO Solaris sparc
      if [[ -d /kgr-mvn/Jenkins-slave/workspace/ ]]
      then
          echo -e "${green} find find /kgr-mvn/Jenkins-slave/workspace/ \( ! -name workspace -o -type f \) -prune -type d -mtime +1 ${NC}"
          find /kgr-mvn/Jenkins-slave/workspace/ \( ! -name workspace -o -type f \) -prune -type d -mtime +1 | xargs -I{} bash -c " echo removing dir {}; rm -rf {}"
      fi
  else
      echo -e "${red} Find NABLATest in workspace to clean ${NC}"

      echo -e "${green} find ${TARGET_WORKSPACE}/workspace/ -maxdepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+'  -mtime +1 -type d -print ${NC}"
      find ${TARGET_WORKSPACE}/workspace/ -maxdepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+'  -mtime +1 -type d -exec rm -rf {} \;

      #echo -e "${green} Fix wrong credentials setted by jenkins when installing for the first time"
      #chown -R jenkins:docker ${TARGET_WORKSPACE}/remoting* ${TARGET_WORKSPACE}/tools/
      #chown -R jenkins:docker /home/jenkins/

      # Docker images
      if command -v docker 2>/dev/null
      then
          {
              docker kill "$(docker ps | grep -E 'Up [0-9]{2,3} hours' | awk '{print $1}')"
          } || echo "No docker images are running"
          {
              # remove all fusion-risk docker images, except for compilation images
              img_to_rm=$(docker image ls | grep -i fusion-risk | grep -E "weeks|months ago" | grep -E -v "/jenkins-slave" | awk '{print $3}')
              docker rmi --force $img_to_rm
          } || echo "No docker images to remove found"
          docker container prune -f --filter until=12h
          docker image prune -f --filter until=12h
          docker network prune -f --filter until=12h
      fi
  fi

else

  echo -e "${green} workspace to clean ${NC}"
  find /Users/jenkins/slave/workspace/ -maxdepth 2 -not \( -path '*/.git' -o -path '*/docker-cleaning*' -o -path './repository' -o -path '*/ADMIN_CLEAN_LINUX*' \) -mtime +1 -type d -exec rm -rf {} \;
  find ${TARGET_WORKSPACE}/workspace/ -maxdepth 2 -not \( -path '*/.git' -o -path '*/docker-cleaning*' -o -path './repository' -o -path '*/ADMIN_CLEAN_LINUX*' \) -mtime +1 -type d -exec rm -rf {} \;

  echo -e "${red} Find NABLATest in workspace to clean ${NC}"

  echo -e "${green} find /Users/jenkins/slave/workspace/ -maxdepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+'  -mtime +1 -type d -exec rm -rf {} \; ${NC}"
  find /Users/jenkins/slave/workspace/ -maxdepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+'  -mtime +1 -type d -exec rm -rf {} \;
  echo -e "${green} find ${TARGET_WORKSPACE}/workspace/ -maxdepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+'  -mtime +1 -type d -exec rm -rf {} \; ${NC}"
  find ${TARGET_WORKSPACE}/workspace/ -maxdepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+'  -mtime +1 -type d -exec rm -rf {} \;

fi

if [ "$(uname -s)" == "Darwin" ]; then
  mdutil -E /Volumes/Macintosh\ HD || true
  #Below is only for master-slave
  mdutil -E /Volumes/DATA || true
fi

echo -e "${green} Clean tmp ${NC}"
find /tmp -mtime +2 -prune | xargs -I{} bash -c " echo removing dir {}; rm -rf {}"

exit 0

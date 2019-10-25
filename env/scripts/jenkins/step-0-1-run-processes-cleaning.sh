#!/bin/bash
#set -xv

WORKING_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}"  )" && pwd  )"

# shellcheck source=./step-2-0-0-build-env.sh
source "${WORKING_DIR}/step-2-0-0-build-env.sh"

if [ -n "${TARGET_USER}" ]; then
  # shellcheck disable=SC2154
  echo -e "${green} TARGET_USER is defined ${happy_smiley} ${NC}"
else
  # shellcheck disable=SC2154
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TARGET_USER, use the default one ${NC}"
  export TARGET_USER="jenkins"
fi

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} Find stale processes${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

function kill_matching_processes
{
  local process_name_matcher="$1"
  echo -e "${magenta} find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ${XARGS_OPTIONS} ps | grep -v grep | grep -w ${process_name_matcher} | awk '{ print $1 }' ${NC}"
  # shellcheck disable=SC2038
  find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ${XARGS_OPTIONS} ps | grep -v grep | grep -w ${process_name_matcher} | awk '{ print $1 }'
  # shellcheck disable=SC2038
  find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ${XARGS_OPTIONS} ps | grep -v grep | grep -w ${process_name_matcher} | awk '{ print $1 }' | xargs ${XARGS_OPTIONS} kill -9 || true
}

if [ "$(uname -s)" != "Darwin" ]; then

  echo -e "${magenta} find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ${XARGS_OPTIONS} ps | grep -v grep ${NC}"
  find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ${XARGS_OPTIONS} ps | grep -v grep

  echo -e "${red} Killing stale grunt processes ${head_skull} ${NC}"
  kill_matching_processes grunt
  echo -e "${red} Killing stale google/chrome processes ${head_skull} ${NC}"
  kill_matching_processes google/chrome
  echo -e "${red} Killing stale chromedriver processes ${head_skull} ${NC}"
  kill_matching_processes chromedriver
  echo -e "${red} Killing stale selenium processes ${head_skull} ${NC}"
  kill_matching_processes selenium
  echo -e "${red} Killing stale zaproxy processes ${head_skull} ${NC}"
  kill_matching_processes ZAPROXY
  echo -e "${red} Killing stale integration test processes ${head_skull} ${NC}"
  kill_matching_processes integration-test
  echo -e "${red} Killing stale jboss processes ${head_skull} ${NC}"
  kill_matching_processes jboss-modules
  echo -e "${red} Killing stale sqlservr processes ${head_skull} ${NC}"
  kill_matching_processes sqlservr
  echo -e "${red} Killing stale container-structure-test processes ${head_skull} ${NC}"
  kill_matching_processes container-structure-test
  echo -e "${NC}"

fi


echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} Selenium${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

export DISPLAY=localhost:99.0

SELENIUM_SERVER_STANDALONE_VERSION="3.13"

cd /workspace/

sudo wget -nc https://selenium-release.storage.googleapis.com/${SELENIUM_SERVER_STANDALONE_VERSION}/selenium-server-standalone-${SELENIUM_SERVER_STANDALONE_VERSION}.0.jar
sudo wget -nc https://selenium-release.storage.googleapis.com/${SELENIUM_SERVER_STANDALONE_VERSION}/selenium-html-runner-${SELENIUM_SERVER_STANDALONE_VERSION}.0.jar

sudo chmod 777 /workspace/selenium-*.jar

SELENIUM_SERVER_STANDALONE="/workspace/selenium-server-standalone-${SELENIUM_SERVER_STANDALONE_VERSION}.0.jar"
#SELENIUM_HUB="http://127.0.0.1:4444"
SELENIUM_HUB="http://home.nabla.mobi:4444"

cd ~

echo -e "${green} Start hub ${NC}"

#-Dwebdriver.chrome.driver=/usr/lib/chromium-browser/chromedriver
echo -e "${green} nohup java -jar ${SELENIUM_SERVER_STANDALONE} -role hub -port 4444 -host 192.168.0.29 -debug ${NC}"
nohup java -jar ${SELENIUM_SERVER_STANDALONE} -role hub -port 4444 -host 192.168.0.29 -debug &
#nohup java -jar /workspace/selenium-server-standalone-3.13.0.jar -role hub -port 4444 -host 192.168.0.29 -debug

echo -e "${green} Start node ${NC}"

echo -e "${green} nohup java -jar ${SELENIUM_SERVER_STANDALONE} -role node -hub ${SELENIUM_HUB}/grid/register -browser browserName=firefox,version=58.0.2,firefox_binary=/usr/bin/firefox,maxInstances=1,platform=LINUX -browser browserName=chrome,version=48.0.2564.116,chrome_binary=/usr/bin/google-chrome,maxInstances=1,platform=LINUX -debug > selenum-hub.out ${NC}"
nohup java -jar ${SELENIUM_SERVER_STANDALONE} -role node -hub ${SELENIUM_HUB}/grid/register -browser browserName=firefox,version=58.0.2,firefox_binary=/usr/bin/firefox,maxInstances=1,platform=LINUX -browser browserName=chrome,version=48.0.2564.116,chrome_binary=/usr/bin/google-chrome,maxInstances=1,platform=LINUX -debug > selenum-hub.out 2>&1 &

exit 0

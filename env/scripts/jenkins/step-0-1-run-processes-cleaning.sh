#!/bin/bash
#set -xve

script_dir="$( cd "$(dirname "$0")" ; pwd -P )"

#tput colors && source "$script_dir/step-0-color.sh"
source "$script_dir/step-0-color.sh"

if [ -n "${TARGET_USER}" ]; then
  echo -e "${green} TARGET_USER is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : TARGET_USER, use the default one ${NC}"
  export TARGET_USER="jenkins"
fi

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} Find stale processes${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps
echo -e "${red} Killing stale grunt processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep grunt | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep grunt | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale google/chrome processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep google/chrome | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep google/chrome | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale chromedriver processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep chromedriver | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep chromedriver | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale selenium processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep selenium | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep selenium | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale zaproxy processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep ZAPROXY | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep ZAPROXY | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale auditreporting-itest processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +60 -exec basename {} \; | xargs ps | grep auditreporting-itest | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +60 -exec basename {} \; | xargs ps | grep auditreporting-itest | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale cargo-itest processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +60 -exec basename {} \; | xargs ps | grep cargo-itest | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +60 -exec basename {} \; | xargs ps | grep cargo-itest | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale integration test processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +60 -exec basename {} \; | xargs ps | grep integration-test | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +60 -exec basename {} \; | xargs ps | grep integration-test | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale cargo-base processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +60 -exec basename {} \; | xargs ps | grep cargo-base | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +60 -exec basename {} \; | xargs ps | grep cargo-base | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale almonde processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep almonde | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep almonde | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale jboss processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep jboss-modules | awk '{ print $1 }'
find /proc -maxdepth 1 -user "${TARGET_USER}" -type d -mmin +200 -exec basename {} \; | xargs ps | grep jboss-modules | awk '{ print $1 }' | sudo xargs kill -9 || true


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

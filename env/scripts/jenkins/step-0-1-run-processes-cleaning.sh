#!/bin/bash
#set -xv

red='\033[31m'
green="\033[32m"
bold="\033[01m"
NC="\033[0m"

double_arrow='\xC2\xBB'
head_skull='\xE2\x98\xA0'
happy_smiley='\xE2\x98\xBA'

if [ -n "${TARGET_USER}" ]; then
  echo -e "${green} TARGET_USER is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : TARGET_USER, use the default one ${NC}"
  export TARGET_USER="jenkins"
fi

echo -e "${red} Find stale processes ${NC}"

find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps
echo -e "${red} Killing stale grunt processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep grunt | awk '{ print $1 }'
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep grunt | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale google/chrome processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep google/chrome | awk '{ print $1 }'
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep google/chrome | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale chromedriver processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep chromedriver | awk '{ print $1 }'
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep chromedriver | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale selenium processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep selenium | awk '{ print $1 }'
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep selenium | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale zaproxy processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep ZAPROXY | awk '{ print $1 }'
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep ZAPROXY | awk '{ print $1 }' | sudo xargs kill -9 || true
echo -e "${red} Killing stale cargo-itest processes ${head_skull} ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep jboss | awk '{ print $1 }'
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep jboss | awk '{ print $1 }' | sudo xargs kill -9 || true

exit 0

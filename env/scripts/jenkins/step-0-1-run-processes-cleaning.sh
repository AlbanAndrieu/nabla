#!/bin/bash
#set -xve

source ./step-0-color.sh

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
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep jboss-modules | awk '{ print $1 }'
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep jboss-modules | awk '{ print $1 }' | sudo xargs kill -9 || true

exit 0

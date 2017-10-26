#!/bin/bash
#set -xve

source ./step-2-0-0-build-env.sh

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} RKHUNTER${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

sudo rkhunter --update
sudo rkhunter --version

sudo rkhunter --checkall --report-warnings-only

exit 0

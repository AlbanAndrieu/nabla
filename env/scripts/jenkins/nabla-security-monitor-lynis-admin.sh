#!/bin/bash
#set -xve

./step-2-0-0-build-env.sh

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} LYNIS${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#TODO use /usr/local/lynis/2.2.0/lynis
sudo lynis --check-update
sudo lynis --version

sudo lynis --check-all -Q

exit 0

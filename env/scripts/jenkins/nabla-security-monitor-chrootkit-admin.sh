#!/bin/bash
#set -xve

./step-2-0-0-build-env.sh

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHROOTKIT${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

sudo chkrootkit -V

sudo chkrootkit -q

#sudo tiger --version

#sudo tiger

exit 0

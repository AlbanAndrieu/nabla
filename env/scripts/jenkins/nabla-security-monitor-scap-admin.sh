#!/bin/bash
#set -xve

./step-2-0-0-build-env.sh

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} SCAP${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#See https://github.com/GovReady/ubuntu-scap
#sudo apt-get install libopenscap8
#cd /workspace/users/albandri30/
#git clone https://github.com/GovReady/ubuntu-scap.git || true
#cd ubuntu-scap || true
#rm -f ubuntu-xccdf.xml || true
#wget http://home.nabla.mobi:7072/download/scap/ubuntu-xccdf.xml || true
./run_tests.sh || true

exit 0

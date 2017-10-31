#!/bin/bash
#set -xve

source ./step-2-0-0-build-env.sh

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} SCAP${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#See https://wiki.opnfv.org/display/security/OpenSCAP+on+Ubuntu+16.04

#See https://github.com/GovReady/ubuntu-scap
#sudo apt-get install openssh-server
#sudo apt-get install libopenscap8
#sudo apt-get install python-openscapr
#cd /workspace/users/albandri30/
#git clone https://github.com/GovReady/ubuntu-scap.git || true
#cd ubuntu-scap || true
#rm -f ubuntu-xccdf.xml || true
#wget http://home.nabla.mobi:7072/download/scap/ubuntu-xccdf.xml || true
${WORKSPACE}/run_tests.sh || true

exit 0

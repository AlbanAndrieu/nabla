#!/bin/bash
set -xv

#See file:///thirdparty/ACE/ACE_wrappers/ACE-INSTALL.html

cd $ACE_ROOT

make

#As root for make install
#export ACE_ROOT=/thirdparty/ACE/ACE_wrappers
#cd $ACE_ROOT
#make install

ls -lrta /usr/local/share/ace

cd $TAO_ROOT

make

exit 0

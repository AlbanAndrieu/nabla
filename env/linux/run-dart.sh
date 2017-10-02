#!/bin/bash
#set -xv

#https://github.com/dartsim/dart/wiki/DART-5.0-Installation-for-Ubuntu
sudo apt-add-repository ppa:dartsim
sudo apt-get update

sudo apt-get install build-essential cmake pkg-config git
sudo apt-get install libeigen3-dev libassimp-dev libccd-dev libfcl-dev
sudo apt-get install libxi-dev libxmu-dev freeglut3-dev

sudo apt-get install libflann-dev libboost-all-dev
sudo apt-get install libtinyxml-dev libtinyxml2-dev
sudo apt-get install liburdfdom-dev liburdfdom-headers-dev

sudo apt-get install libbullet-dev
sudo apt-get install libnlopt-dev
sudo apt-get install coinor-libipopt-dev

#sudo apt-get install libdart-core5-dev
#sudo apt-get install libdart5-dev
sudo apt-get install libdart6-dev
sudo apt-get install libdart6-gui-dev

#https://www.dartlang.org/guides/testing
#sudo apt-get update
#sudo apt-get install apt-transport-https
## Get the Google Linux package signing key.
#sudo sh -c 'curl https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -'
## Set up the location of the stable repository.
#sudo sh -c 'curl https://storage.googleapis.com/download.dartlang.org/linux/debian/dart_stable.list > /etc/apt/sources.list.d/dart_stable.list'
#sudo apt-get update
#
#sudo apt-get install dart

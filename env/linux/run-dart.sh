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

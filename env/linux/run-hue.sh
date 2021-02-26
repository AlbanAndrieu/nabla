#!/bin/bash
#set -xv

# philips hue gub
# GW-E8E8B7B9C443
# 192.168.1.79
# See http://192.168.1.79/description.xml

# See https://www.philips-hue.com/fr-fr/entertainment/hue-sync

pip install phue

# On chrome extension -> ChromeHue for Philips Hue

# https://github.com/craigcabrey/luminance
# NOK -> https://github.com/Fuchs/hoppla-sa
# sudo apt-get install libkf5plasma-dev
# cmake .. -DCMAKE_INSTALL_PREFIX=/usr
#
# ls -lrta /usr/share/plasma/

# See https://invent.kde.org/frameworks/extra-cmake-modules
sudo apt-get install extra-cmake-modules

# http://huestacean.com/

# See https://github.com/BradyBrenot/huestacean
sudo apt-get install qt5-default

sudo apt-get install qtbase5-dev              ## provides Core, Sql and Widgets
sudo apt-get install qtdeclarative5-dev       ## provides Quick and Qml
sudo apt-get install qtmultimedia5-dev        ## provides Multimedia
sudo apt-get install qt-quickcontrols2-5-dev  ## provides QuickControls2
sudo apt-get install libqt5remoteobjects5-dev libqt5remoteobjects5-bin

ls -lrta /usr/lib/x86_64-linux-gnu/cmake/Qt5RemoteObjects/

qtchooser -print-env
qmake -v

git clone --recursive git://github.com/BradyBrenot/huestacean.git
cd huestacean
git checkout tags/v2.6 -b test-v2.6
git submodule sync

mkdir build
cd build

cmake ..
make
make huestacean

#See https://medium.com/flexmr-dev-blog/an-exercise-in-code-diy-philips-hue-sync-app-for-linux-cfa5a644039e

exit 0

#!/bin/bash
set -xv

#See https://developer.samsung.com/smarttv/develop/getting-started/setting-up-sdk/installing-tv-sdk.html

https://launchpad.net/ubuntu/+source/webkitgtk

#NOK sudo apt-get install webkit2gtk-driver

#wget https://launchpad.net/ubuntu/+archive/primary/+files/libwebkitgtk-1.0-0_2.4.11-3ubuntu3_amd64.deb
#sudo dpkg -i ${HOME}/Downloads/libwebkitgtk-1.0-0_2.4.11-3ubuntu3_amd64.deb
#sudo apt-get remove libwebkitgtk-1.0-0

echo -e "# For Tizen studio\ndeb http://cz.archive.ubuntu.com/ubuntu bionic main universe" | sudo tee /etc/apt/sources.list.d/tizen-bionic-libwebkitgtk.list
sudo apt-get install libwebkitgtk-1.0-0

sudo add-apt-repository ppa:linuxuprising/libpng12
sudo apt-get update
sudo apt-get install libpng12-0
sudo apt-get install expect

ls -lrta /home/albandrieu/tizen-studio
ls -lrta /home/albandrieu/tizen-studio-data

exit 0

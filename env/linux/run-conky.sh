#!/bin/bash
set -xv

#http://doc.ubuntu-fr.org/conky

sudo add-apt-repository ppa:norsetto/ppa

sudo apt-get install conky-all
sudo apt-get install unace unrar zip unzip p7zip-full p7zip-rar sharutils rar uudeview mpack lha arj cabextract file-roller

#http://www.webupd8.org/2014/06/conky-manager-gets-revamped-ui-new.html
#conky manager
sudo apt-add-repository ppa:teejee2008/ppa
sudo apt-get update
sudo apt-get install conky-manager
#sudo apt-get remove conky-manager

# Install latest
# Try https://github.com/brndnmtthws/conky/issues/471
# https://github.com/brndnmtthws/conky/releases/tag/v1.11.5

sudo mv /usr/bin/conky /usr/bin/conky-SAV
cd ~/Downloads
#wget https://github.com/brndnmtthws/conky/releases/download/v1.11.5/conky-x86_64.AppImage
wget https://github.com/brndnmtthws/conky/releases/download/v1.11.4/conky-x86_64.AppImage
sudo cp ./conky-x86_64.AppImage /usr/bin/conky

#See https://linuxconfig.org/system-monitoring-on-ubuntu-18-04-linux-with-conky
chmod +x $HOME/.conky/conky-startup.sh

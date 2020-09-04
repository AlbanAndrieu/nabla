#!/bin/bash
set -xv

./run-database.sh

sudo snap install code --classic

#wget -qO - https://gitlab.com/paulcarroty/vscodium-deb-rpm-repo/raw/master/pub.gpg | sudo apt-key add -
#echo 'deb https://paulcarroty.gitlab.io/vscodium-deb-rpm-repo/debs/ vscodium main' | sudo tee --append /etc/apt/sources.list.d/vscodium.list
#sudo apt update && sudo apt install vscodium

sudo nano /etc/sysctl.conf
fs.inotify.max_user_watches=524288

exit 0

#!/bin/bash
#set -xv

# See https://arstechnica.com/gadgets/2020/03/ubuntu-20-04s-zsys-adds-zfs-snapshots-to-package-management/

sudo apt-get install python2-minimal
sudo apt-get install python-apt

# See https://linuxconfig.org/ubuntu-20-04-wallpaper-slideshow

#sudo apt remove gnome-shell-extension-ubuntu-dock
sudo apt-get install gnome-shell-extension-multi-monitors
sudo apt-get install gnome-shell-extension-weather
sudo apt-get install gnome-shell-extension-autohidetopbar gnome-shell-extension-dash-to-panel gnome-shell-extension-hard-disk-led chrome-gnome-shell

sudo ufw disable
sudo swapoff -a

sudo add-apt-repository -y ppa:teejee2008/ppa
sudo apt update
sudo apt install timeshift

# See https://stackoverflow.com/questions/67298443/when-gcc-11-will-appear-in-ubuntu-repositories

exit 0

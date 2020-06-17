#!/bin/bash
#set -xv

#password issue
#polkit-gnome-authentication-agent
synaptic-pkexec

# unity have been replaced by gdm
sudo dpkg-reconfigure gdm3
sudo systemctl status gdm

# Remove language related ign from apt-get update:
sudo gedit /etc/apt/apt.conf.d/00aptitude
#Add 
#Acquire::Languages "none";

exit 0

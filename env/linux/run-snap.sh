#!/bin/bash
#set -xv

#See https://doc.ubuntu-fr.org/snap

sudo snap install snap-store
sudo apt install gnome-software-plugin-flatpak
sudo apt-get update
sudo flatpak remote-add --if-not-exists flathub https://flathub.org/repo/flathub.flatpakrepo

sudo flatpak list
sudo flatpak update

snap list
snap find libre

# Run
snap-store

#See account https://snapcraft.io/snap-store

exit 0

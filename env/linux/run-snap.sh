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

snap refresh --time
sudo snap set system refresh.timer=sat,10:00~12:00


#NetworkManager
nmcli d
nmcli c show docker0 | grep "IP"
nmcli c show "Wired connection 1" | grep "IP"

sudo systemctl restart snapd.service
journalctl -u snapd.service
#Lookup api.snapcraft.io: no such host

exit 0

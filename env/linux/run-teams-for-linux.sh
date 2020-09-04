#!/bin/bash
set -xv

sudo apt update
sudo apt install snapd
sudo snap install teams-for-linux --beta

#See https://forum.snapcraft.io/t/how-can-i-use-snap-when-i-dont-use-home-user/3352
teams-for-linux

sudo dpkg-reconfigure apparmor

sudo nano /etc/apparmor.d/tunables/home.d/my-home
#@{HOMEDIRS}+=/albandrieu /albandri /jenkins
sudo nano /var/lib/snapd/apparmor/snap-confine/my-homes

exit 0

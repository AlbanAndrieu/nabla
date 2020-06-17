#!/bin/bash
set -xv

sudo apt-get install libmtp-common mtp-tools libmtp-dev libmtp-runtime libmtp9
#sudo apt-get dist-upgrade

lsusb

sudo nano /etc/fuse.conf
# uncomment
#user_allow_other

sudo nano /lib/udev/rules.d/69-mtp.rules

# Device
#ATTR{idVendor}=="XXXX", ATTR{idProduct}=="YYYY", SYMLINK+="libmtp-%k", ENV{ID_MTP_DEVICE}="1", ENV{ID_MEDIA_PLAYER}="1"

sudo nano /etc/udev/rules.d/51-android.rules

#ATTR{idVendor}=="XXXX", ATTR{idProduct}=="YYYY", MODE="0666"

sudo service udev restart

#sudo reboot

exit 0

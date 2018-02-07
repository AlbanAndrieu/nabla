#!/bin/bash
set -xv

#sudo apt-get install linux-firmware

#TODO disable wifi
dmesg | grep iwl
rfkill list all
modinfo iwlwifi
grep [[:alnum:]] /sys/module/iwlwifi/parameters/*; lshw -c net
#firmware-iwlwifi
sudo rfkill block wifi
sudo rfkill block bluetooth

sudo systemctl is-enabled bluetooth
sudo systemctl disable bluetooth

sudo nano /etc/default/tlp
#DEVICES_TO_DISABLE_ON_STARTUP="bluetooth wifi wwan"

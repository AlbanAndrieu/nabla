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

./run-sep.sh
./run-clamav.sh

#https://shop.hak5.org/pages/videos
#https://hunter.io/
#youtube.com defcon vishing demo
#kali linux 2020
#netsparker
#acunetix
#hashcat

# See https://www.scamdoc.com/fr/
# See https://lookup.icann.org/lookup
# See https://www.afnic.fr/fr/produits-et-services/services/whois/

exit 0

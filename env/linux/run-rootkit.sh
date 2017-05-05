#!/bin/bash
set -xv

#http://doc.ubuntu-fr.org/rootkit

sudo apt-get install rkhunter
sudo rkhunter --update
sudo rkhunter --version

sudo rkhunter --checkall --report-warnings-only

sudo apt-get install chkrootkit
sudo chkrootkit --version

sudo chkrootkit -q

#Warning: Hidden directory found
#http://askubuntu.com/questions/1537/rkhunter-warning-about-etc-java-etc-udev-etc-initramfs
#Add Uncomment
#ALLOWHIDDENDIR="/etc/.java"
#ALLOWHIDDENDIR="/dev/.udev"
#ALLOWHIDDENDIR="/dev/.initramfs"

sudo apt-get install tiger
sudo tiger --version

sudo tiger

#check for bad block
sudo apt-get install e2fsprogs
sudo badblocks -v /dev/sda > bad-blocks
#sudo fsck -t ext3 -l bad-blocks /dev/sda

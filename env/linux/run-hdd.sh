#!/bin/bash
#set -xv

red='\e[0;31m'
green='\e[0;32m'
NC='\e[0m' # No Color

#See https://doc.ubuntu-fr.org/lvm

sudo lvscan

sudo apt-get install system-config-lvm

man -k ^pv

lvm vgscan
lvm lvs

#https://supportex.net/blog/2010/11/determine-raid-controller-type-model/
sudo apt-get install mdadm dmraid
sudo dmraid -r

#Check harware raid
# lspci -nn
lspci -vv | grep -i raids

#list full hardware
#lshw

#http://www.thegeekstuff.com/2014/07/hpacucli-examples
#hpacucli ctrl all show config

#ls -lah /dev/cciss/

#https://help.ubuntu.com/lts/serverguide/iscsi-initiator.html
sudo apt-get install open-iscsi
sudo nano /etc/iscsi/iscsid.conf
#uncomment
node.startup = automatic

sudo iscsiadm -m discovery -t st -p 192.168.0.46
sudo iscsiadm -m node --login


#See encrypted diks
#https://community.linuxmint.com/tutorial/view/2191#appc
modprobe dm-crypt
sudo update-grub
#Windows using BitLocker/TPM and Linux using dm-crypt with LUKS Enxtension
exit 0

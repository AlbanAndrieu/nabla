#!/bin/bash
#set -xv

#See https://doc.ubuntu-fr.org/lvm

sudo lvscan

sudo apt-get install system-config-lvm

man -k ^pv

lvm vgscan
lvm lvs

type lsblk > /dev/null 2>&1 || { echo >&2 "lsblk isn't installed. Abort!"; exit 1; }

partprobe /dev/sdb

#Add more disk space to VM
#Frist add another HDD in cloud, it will be visible in VM as sdb
#init disk for use by LVM
pvcreate /dev/sdb

#display atributes of disk
pvdisplay
vgdisplay
lvdisplay

# Extends volume group. Please confirm group name.
#add disk to volume group
vgextend rhel_fr1cslvcacrhel71 /dev/sdb

# Extends physical volume.
#extend size of logical volume
lvextend -l +100%FREE /dev/mapper/rhel_fr1cslvcacrhel71-root

# extend size of mapped logical volume (only for xfs file system since RHEL7)
#xfs_growfs -d /dev/mapper/rhel_fr1cslvcacrhel71-root
xfs_growfs -d /dev/rhel_fr1cslvcacrhel71/root

#extend size of filesystem
#resize2fs /dev/rhel_fr1cslvcacrhel71/root

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

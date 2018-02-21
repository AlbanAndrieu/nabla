#!/bin/bash
#set -xv

sudo apt-get install xfsprogs
#sudo yum install xfsprogs

#Show disk

fdisk -l

#fdisk /dev/sda
#p

#/dev/sda1 is a non-LVM partition (Type: 0x83)
#/dev/sda2 is an LVM partition (Type: 0x8e)

#fdisk /dev/sdb

dmsetup status
dmsetup ls
dmsetup remove_all

#See https://doc.ubuntu-fr.org/lvm

#See https://www.gadgetdaily.xyz/cactus-for-mac-review-powerful-and-clean-web-development-tools/

sudo lvscan

sudo apt-get install system-config-lvm system-storage-manager kvpm
#system-config-lvm is no longer available in Centos 7 and has been replaced with system storage manager in Centos 7
#yum install system-storage-manager
#yum install gnome-disk-utility
#yum install baobab
sudo ssm list

#Lunch the gui
sudo system-config-lvm
sudo kvpm

#gnome-disk-util
#Redhat GUI launch
#gnome-disks

#TODO see palimpsest

sudo vgchange -ay

man -k ^pv

lvm vgscan
lvm lvs

type lsblk > /dev/null 2>&1 || { echo >&2 "lsblk isn't installed. Abort"; exit 1; }

#See free space
parted /dev/sda print free
df -Th /root

#sudo partprobe /dev/sdb
partprobe -s
#partx -v -a /dev/sda

#Add more disk space to VM
#First add another HDD in cloud, it will be visible in VM as sdb
#init disk for use by LVM
pvcreate /dev/sdb

ls -1d /sys/class/scsi_device/*/device/block/*
#bash -c 'echo "1" > /sys/class/scsi_disk/2\:0\:2\:0/device/rescan'
echo 1>/sys/class/block/sdb/device/rescan
#OR
#echo 1>/sys/class/scsi_device/0\:0\:0\:0/device/block/sda/device/rescan

pvresize /dev/sdb

#display atributes of disk
pvdisplay
vgdisplay
lvdisplay

# Extends volume group. Please confirm group name.
#add disk to volume group
vgextend rhel_fr1cslvcacrhel71 /dev/sdb
#vgextend rhel_fr1cslvcacrhel71 /dev/sdc

# Free disk space should be now visible in VG. Actual number of available physical extents (PE) will be smaller,
# than expected with disk size, some of the space will be taken by metadata
vgdisplay
vgdisplay -v rhel_fr1cslvcacrhel71

lvcreate -l 12805 -n workspace rhel_fr1cslvcacrhel71
lvcreate -l 12805 -n docker rhel_fr1cslvcacrhel71

lvdisplay

sudo mkfs -t ext4 /dev/rhel_fr1cslvcacrhel71/workspace
sudo mkfs -t ext4 /dev/rhel_fr1cslvcacrhel71/docker

sudo mkdir /workspace
sudo mount /workspace

sudo mkdir /docker
sudo mount /docker

# Extends physical volume.
#extend size of logical volume
lvextend --resizefs -L +6G /dev/rhel_fr1cslvcacrhel71/swap
lvextend --resizefs -l +12805 /dev/rhel_fr1cslvcacrhel71/root
lvextend -l +100%FREE /dev/rhel_fr1cslvcacrhel71/root
#lvextend -L +1G /dev/rhel_fr1cslvcacrhel71/docker
lvextend --resizefs -l +12805 /dev/mapper/rhel_fr1cslvcacrhel71-docker
#lvextend --resizefs -l +12805 /dev/rhel_fr1cslvcacrhel71/docker
lvextend --resizefs -l +12805 /dev/rhel_fr1cslvcacrhel71/workspace

xfs_info /dev/mapper/rhel_fr1cslvcacrhel71-root
# extend size of mapped logical volume (only for xfs file system since RHEL7)
#xfs_growfs -d /dev/mapper/rhel_fr1cslvcacrhel71-root
xfs_growfs -d /dev/rhel_fr1cslvcacrhel71/root

#extend size of filesystem
#resize2fs /dev/rhel_fr1cslvcacrhel71/root

#nano /etc/fstab
/dev/rhel_fr1cslvcacrhel71/workspace       /workspace   ext4    defaults        0       2
/dev/rhel_fr1cslvcacrhel71/docker       /docker   ext4    defaults        0       2

df -h
lsblk -o NAME,SIZE,GROUP,TYPE,FSTYPE,MOUNTPOINT

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

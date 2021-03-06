#!/bin/bash
set -xv

#http://www.h-online.com/open/news/item/ZFS-on-Linux-is-ready-for-wide-scale-deployment-1832848.html
#https://github.com/zfsonlinux/pkg-zfs/wiki/HOWTO-install-Ubuntu-to-a-Native-ZFS-Root-Filesystem

#sudo apt-add-repository --yes ppa:zfs-native/stable
#sudo apt-add-repository --yes ppa:zfs-native/grub
#sudo apt-get update
#sudo apt-get install ubuntu-zfs
#sudo apt-get install zfs-fuse
#
#sudo zpool upgrade -v
#
#sudo apt-get install debootstrap ubuntu-zfs
#sudo apt-get install --no-install-recommends linux-image-generic linux-headers-generic
#sudo apt-get install ubuntu-zfs
#sudo apt-get install grub2-common grub-pc
#sudo apt-get install zfs-initramfs
#sudo apt-get dist-upgrade

# Ubuntu 20
# See https://arstechnica.com/gadgets/2020/03/ubuntu-20-04s-zsys-adds-zfs-snapshots-to-package-management/
sudo apt-get install zfsutils-linux zsys
zsysctl

dmesg | grep ZFS

ls -l /dev/disk/by-id/
#zpool create -f datastore raidz /dev/vdb /dev/vdc /dev/vdd
sudo zpool create -o ashift=9 dpool /dev/disk/by-id/ata-WDC_WD10EALX-759BA1_WD-WCATR7624246 -f
sudo zpool create -o ashift=9 apool /dev/disk/by-id/ata-WDC_WD10EALX-759BA1_WD-WCATR7615786 -f
sudo zfs create apool/ROOT
sudo zfs create apool/ROOT/ubuntu-albandri
sudo zpool status dpool
sudo zdb

sudo zfs create -o mountpoint=/mnt/backup dpool/backup
sudo zfs create -o mountpoint=/mnt/jenkins dpool/jenkins

sudo zfs snapshot dpool/jenkins@empty
sudo zfs snapshot dpool/backup@empty

sudo zfs list

#chek mount
sudo zfs get all dpool/jenkins
#sudo zfs set mountpoint=/mnt/jenkins dpool/jenkins
sudo zfs get mountpoint dpool/jenkins
sudo zfs get mounted dpool/jenkins
sudo zfs mount -a

cd /
sudo ln -s /mnt/jenkins jenkins
sudo chown -h jenkins:jenkins /jenkins
sudo chown jenkins:jenkins /mnt/jenkins

export JENKINS_HOME=/jenkins
sudo apt-get install jenkins

#swap
swap -d /dev/zvol/dsk/rpool/swap
zfs destroy rpool/swap
zfs create -V300G -b4k rpool/swap
swap -a /dev/zvol/dsk/rpool/swap

zfs list

#issue Load the module manually by running 'insmod <location>/zfs.ko' as root
sudo apt-get install --reinstall zfs-dkms

#cleaning
#sudo apt remove zfs.doc

sudo dkms status

#Cheat sheet
#http://thegeekdiary.com/solaris-zfs-command-line-reference-cheat-sheet/
#http://www.unixarena.com/2012/07/zfs-quick-command-reference-with.html

#https://askubuntu.com/questions/404172/zpools-dont-automatically-mount-after-boot

exit 0

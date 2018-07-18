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
#https://www.tecmint.com/extend-and-reduce-lvms-in-linux/

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
sudo parted /dev/sda print free
df -Th /root

#Change quota on xfs for oracle database

#1) The linux host machine *must* have a lvm partition of type xfs with d_type activated. This is done by formatting with: mkfs.xfs -n ftype=1 /dev/path_to_device,
#2) pquota *must* also be set on the xfs device. Read https://help.directadmin.com/item.php?id=557 for details,
#4) The container *must* be run with the options: --storage-opt size=35G --shm-size="8g" -p 1521:1521 -p 5500:5500 -p 5501:5501.

#nano /etc/default/grub
#GRUB_CMDLINE_LINUX="rd.lvm.lv=rhel_fr1cslvcacrhel71/swap rd.lvm.lv=rhel_fr1cslvcacrhel71/root rhgb quiet rootflags=uquota,pquota"

#cp /boot/grub2/grub.cfg /boot/grub2/grub.cfg.orig
#grub2-mkconfig -o /boot/grub2/grub.cfg

#sudo partprobe /dev/sdb
partprobe -s
#partx -v -a /dev/sda

#Add more disk space to VM
#First add another HDD in cloud, it will be visible in VM as sdb
#init disk for use by LVM
pvcreate /dev/sdb

sudo apt-get install scsitools
sudo rescan-scsi-bus
ls -1d /sys/class/scsi_device/*/device/block/*
#bash -c 'echo "1" > /sys/class/scsi_disk/2\:0\:2\:0/device/rescan'
echo 1>/sys/class/block/sdb/device/rescan
echo 1>/sys/class/block/sda/device/rescan
#OR
#echo 1>/sys/class/scsi_device/0\:0\:0\:0/device/block/sda/device/rescan
#echo 1>/sys/class/scsi_device/2\:0\:0\:0/device/block/sda/device/rescan
#sh -c 'echo "1" > /sys/class/scsi_disk/2\:0\:0\:0/device/rescan'

#On RedHat
pvresize /dev/sdb

#On Ubuntu
#sudo apt-get install parted
#umount /dev/sda
#resize2fs /dev/sda1
#resize2fs /dev/sda1
#mount -a
pvresize /dev/sda5

#display atributes of disk
pvdisplay
vgdisplay
lvdisplay

# Extends volume group. Please confirm group name.
#add disk to volume group
vgextend rhel_fr1cslvcacrhel71 /dev/sdb
vgextend VolGroup00 /dev/sdb
vgextend fr1vslub1604-vg /dev/sdb
#vgextend rhel_fr1cslvcacrhel71 /dev/sdc

# Free disk space should be now visible in VG. Actual number of available physical extents (PE) will be smaller,
# than expected with disk size, some of the space will be taken by metadata
vgdisplay
vgdisplay -v rhel_fr1cslvcacrhel71
vgdisplay -v VolGroup00

lvcreate -l 12805 -n workspace rhel_fr1cslvcacrhel71
lvcreate -l 12805 -n docker rhel_fr1cslvcacrhel71
lvcreate -l 12805 -n workspace fr1vslub1604-vg
lvcreate -l 12794 -n docker fr1vslub1604-vg

lvdisplay

#sudo mkfs -t ext4 /dev/rhel_fr1cslvcacrhel71/workspace
sudo mkfs -t xfs /dev/rhel_fr1cslvcacrhel71/workspace
sudo mkfs -t ext4 /dev/fr1vslub1604-vg/workspace
#sudo mkfs -t ext4 /dev/rhel_fr1cslvcacrhel71/docker
mkfs.xfs -n ftype=1 /dev/rhel_fr1cslvcacrhel71/docker
sudo mkfs -t ext4 /dev/fr1vslub1604-vg/docker

#nano /etc/fstab
#/dev/rhel_fr1cslvcacrhel71/workspace /workspace ext4 auto 0 2
#/dev/rhel_fr1cslvcacrhel71/docker /docker ext4 auto 0 2
/dev/rhel_fr1cslvcacrhel71/workspace /workspace xfs auto 0 2
/dev/rhel_fr1cslvcacrhel71/docker /docker xfs defaults,usrquota,prjquota  0   0
q

sudo mkdir /workspace
sudo mount /workspace

sudo mkdir /docker
sudo mount /docker

# Extends physical volume.
#extend size of logical volume
lvextend --resizefs -L +6G /dev/rhel_fr1cslvcacrhel71/swap
lvextend --resizefs -L +17G /dev/rhel_fr1cslvcacrhel71/root
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
sudo apt-get install open-iscsi open-iscsi-utils
sudo nano /etc/iscsi/iscsid.conf
#uncomment
node.startup = automatic

sudo iscsiadm -m discovery -t st -p 192.168.0.46
sudo iscsiadm -m node --login
#sudo iscsiadm --mode node --targetname iqn.2011-03.org.example.istgt:nabla --portal 192.168.0.46 --login
dmesg | grep sd
sudo fdisk -l
lsblk

fdisk /dev/sdc

#Command (m for help): <-- m
#Command action
#   a   toggle a bootable flag
#   b   edit bsd disklabel
#   c   toggle the dos compatibility flag
#   d   delete a partition
#   l   list known partition types
#   m   print this menu
#   n   add a new partition
#   o   create a new empty DOS partition table
#   p   print the partition table
#   q   quit without saving changes
#   s   create a new empty Sun disklabel
#   t   change a partition's system id
#   u   change display/entry units
#   v   verify the partition table
#   w   write table to disk and exit
#   x   extra functionality (experts only)
#
#Command (m for help): <-- n
#Command action
#   e   extended
#   p   primary partition (1-4)
#<-- p
#Partition number (1-4): <-- 1
#First cylinder (1-20480, default 1): <-- ENTER
#Using default value 1
#Last cylinder or +size or +sizeM or +sizeK (1-20480, default 20480): <-- ENTER
#Using default value 20480
#
#Command (m for help): <-- t
#Selected partition 1
#Hex code (type L to list codes): <-- L
#
# 0  Empty           1e  Hidden W95 FAT1 80  Old Minix       be  Solaris boot
# 1  FAT12           24  NEC DOS         81  Minix / old Lin bf  Solaris
# 2  XENIX root      39  Plan 9          82  Linux swap / So c1  DRDOS/sec (FAT-
# 3  XENIX usr       3c  PartitionMagic  83  Linux           c4  DRDOS/sec (FAT-
# 4  FAT16 <32M      40  Venix 80286     84  OS/2 hidden C:  c6  DRDOS/sec (FAT-
# 5  Extended        41  PPC PReP Boot   85  Linux extended  c7  Syrinx
# 6  FAT16           42  SFS             86  NTFS volume set da  Non-FS data
# 7  HPFS/NTFS       4d  QNX4.x          87  NTFS volume set db  CP/M / CTOS / .
# 8  AIX             4e  QNX4.x 2nd part 88  Linux plaintext de  Dell Utility
# 9  AIX bootable    4f  QNX4.x 3rd part 8e  Linux LVM       df  BootIt
# a  OS/2 Boot Manag 50  OnTrack DM      93  Amoeba          e1  DOS access
# b  W95 FAT32       51  OnTrack DM6 Aux 94  Amoeba BBT      e3  DOS R/O
# c  W95 FAT32 (LBA) 52  CP/M            9f  BSD/OS          e4  SpeedStor
# e  W95 FAT16 (LBA) 53  OnTrack DM6 Aux a0  IBM Thinkpad hi eb  BeOS fs
# f  W95 Ext'd (LBA) 54  OnTrackDM6      a5  FreeBSD         ee  EFI GPT
#10  OPUS            55  EZ-Drive        a6  OpenBSD         ef  EFI (FAT-12/16/
#11  Hidden FAT12    56  Golden Bow      a7  NeXTSTEP        f0  Linux/PA-RISC b
#12  Compaq diagnost 5c  Priam Edisk     a8  Darwin UFS      f1  SpeedStor
#14  Hidden FAT16 <3 61  SpeedStor       a9  NetBSD          f4  SpeedStor
#16  Hidden FAT16    63  GNU HURD or Sys ab  Darwin boot     f2  DOS secondary
#17  Hidden HPFS/NTF 64  Novell Netware  b7  BSDI fs         fd  Linux raid auto
#18  AST SmartSleep  65  Novell Netware  b8  BSDI swap       fe  LANstep
#1b  Hidden W95 FAT3 70  DiskSecure Mult bb  Boot Wizard hid ff  BBT
#1c  Hidden W95 FAT3 75  PC/IX
#Hex code (type L to list codes): <-- 83
#
#Command (m for help): <-- w
#The partition table has been altered!
#
#Calling ioctl() to re-read partition table.
#Syncing disks.

fdisk -l

mkfs.ext4 /dev/sdc1

#sudo mkdir -p /media/iscsi/zvol-openstack
sudo mkdir -p /media/iscsi/extent1
#sudo mkdir -p /media/iscsi/zvol-owncloud

mount /dev/sdc1 /media/iscsi/extent1

sudo nano /etc/fstab
#/dev/sdb       /media/iscsi/zvol-openstack        zfs    defaults,auto,_netdev 0 0
/dev/sdc       /media/iscsi/extent1        ext4    defaults,auto,_netdev 0 0
#/dev/sdd       /media/iscsi/zvol-owncloud        zfs    defaults,auto,_netdev 0 0

sudo mount -a

#See encrypted diks
#https://community.linuxmint.com/tutorial/view/2191#appc
modprobe dm-crypt
sudo update-grub
#Windows using BitLocker/TPM and Linux using dm-crypt with LUKS Enxtension

#Ubuntu 17 add swap
#http://linuxbsdos.com/2017/05/26/replace-the-swap-partition-with-a-swap-file-after-upgrading-to-ubuntu-17-04/

swapon --show
free -h

#https://askubuntu.com/questions/934391/how-to-resize-ubuntu-17-04-zesty-swap-file-size

swapoff /swapfile

#dd if=/dev/zero of=/swapfile bs=1024 count=65536
fallocate -l 4G /swapfile

#Change the persmissions of the newly created file:

chmod 0600 /swapfile

#Setup the swap file with the command:

mkswap /swapfile

#To enable the swap file immediately but not automatically at boot time:

swapon /swapfile

sudo nano /etc/sysctl.conf
sudo sysctl -p

exit 0

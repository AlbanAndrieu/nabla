#!/bin/bash
set -xv

sudo fdisk -l

#/dev/sdg

#mkfs.ntfs -n CLE_NTFS /dev/sdg
mkfs.vfat -n CLE_VFAT /dev/sdg

sudo umount /dev/sdg
sudo mount /dev/sdg
#sudo eject /dev/sdb

sudo /media/windows
sudo mount -t ntfs -o nls=utf8,umask=0222 /dev/sdg /media/windows
sudo mount /media/windows
#sudo mount -t vfat /dev/sdb1 /media/external -o uid=1000,gid=1000,utf8,dmask=027,fmask=137

exit 0

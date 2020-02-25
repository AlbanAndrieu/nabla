#!/bin/bash
#set -xv

#iscsi
#See run-hdd.sh

#TODO
#https://github.com/zfsonlinux/pkg-zfs/wiki/Ubuntu-ZFS-mountall-FAQ-and-troubleshooting
#connect to freenas
zfs get mountpoint /mnt/dpool/media/ftp
#zfs set mountpoint=/export/media/ftp /mnt/dpool/media/ftp
zfs set mountpoint=/dpool/media/ftp dpool/media/ftp
zfs get mountpoint dpool/media/ftp
zfs set mountpoint=legacy dpool/media/ftp

#mount main disk from ubuntu usb
#http://www.linuxquestions.org/questions/linux-general-1/cannot-edit-fstab-in-recovery-mode-filesystem-is-read-only-540195/
umount /mnt/sdd1
mount -o rw /dev/sdd1 /mnt/sdd1

./mountall.sh

#workaround
#http://askubuntu.com/questions/76901/nfs-mount-fails-on-startup
cd /etc/init.d/
sudo gedit /etc/init.d/mountall.sh
sudo chmod +x mountall.sh
sudo update-rc.d mountall.sh defaults
less /var/log/syslog | grep -i nfs

exit 0

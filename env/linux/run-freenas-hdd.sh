#!/bin/bash
#set -xv

#mount by hand
sudo apt-get install nfs-common
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media /media -o user=albandri
sudo umount /media/ftp
sudo umount /media/photo
sudo umount /media/music
sudo umount /media/video
sudo umount /image
sudo umount /archive
sudo umount /jenkins-tmp
sudo umount /workspace-tmp
sudo umount /workspace/users/albandri10

#sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/ftp /media/ftp -o user=albandri
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/download /media/download
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/ftp /media/ftp
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/movie /media/movie
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/music /media/music
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/photo /media/photo
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/serie /media/serie
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/torrentfile /media/torrentfile
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/video /media/video
sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/webdav /media/webdav
sudo mount -t zfs 192.168.1.24:/mnt/dpool/image /image
sudo mount -t nfs 192.168.1.24:/mnt/dpool/archive /archive
sudo mount -t nfs 192.168.1.24:/mnt/dpool/backup /backup
sudo mount -t nfs 192.168.1.24:/mnt/dpool/jenkins /media/jenkins
rsync -anv /jenkins/ /media/jenkins
sudo mount -t nfs 192.168.1.24:/mnt/dpool/jenkins-slave /jenkins-slave
sudo mount -t nfs 192.168.1.24:/mnt/dpool/workspace /workspace-tmp
#sudo mount -t nfs 192.168.1.24:/mnt/dpool/workspace/users/albandri10 /workspace/users/albandri10

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

sudo gedit /etc/fstab
#<server>:</remote/export></local/directory><nfs-type><options> 0 0
freenas:/mnt/dpool/media/ftp /media/ftp nfs rw 0 0
freenas:/mnt/dpool/media/photo /media/photo nfs rw 0 0
freenas:/mnt/dpool/media/music /media/music nfs rw 0 0
freenas:/mnt/dpool/media/video /media/video nfs rw 0 0
192.168.1.1:/mnt/dpool/image /image nfs defaults 0 0
freenas:/mnt/dpool/archive /archive nfs rw 0 0
freenas:/mnt/dpool/backup /backup nfs rw 0 0
freenas:/mnt/dpool/jenkins /jenkins nfs rw 0 0
freenas:/mnt/dpool/workspace /workspace-tmp nfs rw 0 0
#freenas:/mnt/dpool/media/ftp  /media/ftp  zfs  defaults  0  0

#mount main disk from ubuntu usb
#http://www.linuxquestions.org/questions/linux-general-1/cannot-edit-fstab-in-recovery-mode-filesystem-is-read-only-540195/
umount /mnt/sda1
mount -o rw /dev/sda1 /mnt/sda1

#workaround
#http://askubuntu.com/questions/76901/nfs-mount-fails-on-startup
cd /etc/init.d/
sudo gedit /etc/init.d/mountall.sh
sudo chmod +x mountall.sh
sudo update-rc.d mountall.sh defaults
less /var/log/syslog | grep -i nfs

exit 0

#!/bin/bash

#TODO see ansible script NOW
sudo umount -f /owncloud

sudo mkdir /media/ftp
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/ftp /media/ftp
sudo mkdir /media/photo
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/photo /media/photo
sudo mkdir /media/music
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/music /media/music
sudo mkdir /media/video
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/video /media/video
sudo mkdir /media/movie
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/movie /media/movie
sudo mkdir /media/download
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/download /media/download
sudo mkdir /image
sudo mount -t nfs 192.168.0.46:/mnt/dpool/image /image
sudo mkdir /archive
sudo mount -t nfs 192.168.0.46:/mnt/dpool/archive /archive
sudo mkdir /backup
sudo mount -t nfs 192.168.0.46:/mnt/dpool/backup /backup
sudo mkdir /owncloud
sudo mount -t nfs 192.168.0.46:/mnt/dpool/owncloud /owncloud
sudo mkdir /jenkins-tmp
#sudo mount -t nfs 192.168.0.46:/mnt/dpool/jenkins /jenkins-tmp
sudo mkdir /workspace-tmp
#sudo mount -t nfs 192.168.0.46:/mnt/dpool/workspace /workspace-tmp

echo "Mount freenas NABLA directories"
#less /var/log/syslog | grep -i nfs

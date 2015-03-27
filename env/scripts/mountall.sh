#!/bin/bash

#TODO see ansible script NOW
umount -f /owncloud

mount -t nfs 192.168.0.46:/mnt/dpool/media/ftp /media/ftp
mount -t nfs 192.168.0.46:/mnt/dpool/media/photo /media/photo
mount -t nfs 192.168.0.46:/mnt/dpool/media/music /media/music
mount -t nfs 192.168.0.46:/mnt/dpool/media/video /media/video
mount -t nfs 192.168.0.46:/mnt/dpool/media/movie /media/movie
mount -t nfs 192.168.0.46:/mnt/dpool/media/download /media/download
mount -t nfs 192.168.0.46:/mnt/dpool/image /image
mount -t nfs 192.168.0.46:/mnt/dpool/archive /archive
mount -t nfs 192.168.0.46:/mnt/dpool/backup /backup
mount -t nfs 192.168.0.46:/mnt/dpool/owncloud /owncloud
#mount -t nfs 192.168.0.46:/mnt/dpool/jenkins /jenkins-tmp
#mount -t nfs 192.168.0.46:/mnt/dpool/workspace /workspace-tmp

echo "Mount freenas NABLA directories"
#less /var/log/syslog | grep -i nfs


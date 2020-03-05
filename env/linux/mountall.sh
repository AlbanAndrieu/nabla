#!/bin/bash
#set -xv

#See ansible script NOW

#mount by hand
sudo apt-get install nfs-common
#sudo umount /media/ftp
#sudo umount /media/download
#sudo umount /media/movie
#sudo umount /media/music
#sudo umount /media/photo
#sudo umount /media/video
#sudo umount /media/image
#sudo umount /media/archive
#sudo umount /media/jenkins
#sudo umount /media/jenkins-slave
#sudo umount /workspace-tmp

showmount -e nabla

#sudo mount -t nfs 192.168.1.24:/mnt/dpool/media /media -o user=albandri
#sudo mount -t nfs 192.168.1.24:/mnt/dpool/media/ftp /media/ftp -o user=albandri
sudo mkdir /media/ftp
sudo mount -t nfs nabla:/mnt/dpool/media/ftp /media/ftp
sudo mkdir /media/download
sudo mount -t nfs nabla:/mnt/dpool/media/download /media/download
sudo mkdir /media/movie
sudo mount -t nfs nabla:/mnt/dpool/media/movie /media/movie
sudo mkdir /media/music
sudo mount -t nfs nabla:/mnt/dpool/media/music /media/music
sudo mkdir /media/photo
sudo mount -t nfs nabla:/mnt/dpool/media/photo /media/photo
sudo mkdir /media/serie
sudo mount -t nfs nabla:/mnt/dpool/media/serie /media/serie
sudo mkdir /media/torrentfile
sudo mount -t nfs nabla:/mnt/dpool/media/torrentfile /media/torrentfile
sudo mkdir /media/video
sudo mount -t nfs nabla:/mnt/dpool/media/video /media/video
sudo mkdir /media/webdav
sudo mount -t nfs nabla:/mnt/dpool/media/webdav /media/webdav
sudo mkdir /media/image
sudo mount -t zfs nabla:/mnt/dpool/image /media/image
sudo mkdir /media/archive
sudo mount -t nfs nabla:/mnt/dpool/archive /media/archive
sudo mkdir /media/backup
sudo mount -t nfs nabla:/mnt/dpool/backup /media/backup
sudo mkdir /media/jenkins
sudo mount -t nfs nabla:/mnt/dpool/jenkins /media/jenkins
#rsync -anv /jenkins/ /media/jenkins
sudo mkdir /media/jenkins-slave
sudo mount -t nfs nabla:/mnt/dpool/jenkins-slave /media/jenkins-slave
sudo mkdir /workspace-tmp
sudo mount -t nfs nabla:/mnt/dpool/workspace /workspace-tmp
#sudo mount -t nfs nabla:/mnt/dpool/workspace/users/albandri10 /workspace/users/albandri10
#sudo mkdir /media/owncloud
#sudo mount -t nfs nabla:/mnt/dpool/owncloud /media/owncloud

#sudo nano /etc/fstab
##<server>:</remote/export></local/directory><nfs-type><options> 0 0
#nabla:/mnt/dpool/media/ftp /media/ftp nfs rw 0 0
<<<<<<< HEAD
nabla:/mnt/dpool/media/download /media/download nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/media/music /media/music nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/media/photo /media/photo nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/media/serie /media/serie nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/media/torrentfile /media/torrentfile nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/media/video /media/video nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/media/webdav /media/webdav nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/image /media/image nfs defaults 0 0
nabla:/mnt/dpool/archive /media/archive nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/backup /media/backup nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/jenkins /media/jenkins nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/jenkins-slave /media/jenkins-slave nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
nabla:/mnt/dpool/workspace /workspace-tmp nfs4 defaults,user,auto,noatime,bg,rsize=16384,wsize=16384 0 0
#nabla:/mnt/dpool/media/ftp  /media/ftp  zfs  defaults  0  0
=======
#nabla:/mnt/dpool/media/photo /media/photo nfs rw 0 0
#nabla:/mnt/dpool/media/music /media/music nfs rw 0 0
#nabla:/mnt/dpool/media/video /media/video nfs rw 0 0
#nabla:/mnt/dpool/image /image nfs defaults 0 0
#nabla:/mnt/dpool/archive /archive nfs rw 0 0
#nabla:/mnt/dpool/backup /backup nfs rw 0 0
#nabla:/mnt/dpool/jenkins /jenkins nfs rw 0 0
#nabla:/mnt/dpool/workspace /workspace-tmp nfs rw 0 0
##nabla:/mnt/dpool/media/ftp  /media/ftp  zfs  defaults  0  0
>>>>>>> 9053cf3bd92d78dfb9f33cf5b39354fcbe34c705

echo "Mount freenas NABLA NFS directories"
#less /var/log/syslog | grep -i nfs

exit 0

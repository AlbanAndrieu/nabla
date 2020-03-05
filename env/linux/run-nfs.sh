#!/bin/bash
#set -xv

<<<<<<< HEAD
# See https://doc.ubuntu-fr.org/nfs
# See https://help.ubuntu.com/community/NFSv4Howto

sudo apt-get install nfs-common
sudo apt-get install portmap rpcbind

./run-freenas-hdd.sh

#resolvectl status
showmount -e nabla

#cp /workspace/users/albandrieu30/ansible-nabla/playbooks/templates/idmapd.conf.j2 /etc/idmapd.conf
#cp /workspace/users/albandrieu30/ansible-nabla/playbooks/templates/nfs-common.j2 /etc/default/nfs-common

service portmap restart
service rpcbind restart

fuser -m /media/jenkins-slave
umount /media/jenkins-slave
mount /media/jenkins-slave
ls -lrta /media/jenkins-slave
=======
sudo apt-get install nfs-common

./run-freenas-hdd.sh

resolvectl status
>>>>>>> 9053cf3bd92d78dfb9f33cf5b39354fcbe34c705

exit 0

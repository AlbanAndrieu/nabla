#!/bin/bash
#set -xv

id jenkins
#uid=818(jenkins) gid=818(jenkins) groups=818(jenkins)

#in jail
edit /etc/group

pkg install bash
#Delete user with wrong id

pw groupadd -n docker -g 2000
# usermod -u 117 jenkins
#pw userdel jenkins
pw groupadd -n jenkins -g 131
#pw useradd -n jenkins -u 117 -d /nonexistent -s /usr/sbin/nologin
ln -s /media/jenkins-slave /usr/local/jenkins
pw useradd -n jenkins -u 117 -d /usr/local/jenkins -s /usr/local/bin/bash
#pw groupmod -g 131 jenkins
pw groupmod jenkins -m jenkins
pw groupmod docker -m jenkins
pw usermod jenkins -G wheel

chown jenkins:jenkins /usr/local/jenkins
chown -R jenkins:jenkins /var/run/jenkins

#jenkins jail
ssh -v jenkins@192.168.1.61
ssh -X jenkins@192.168.1.61
#albandri
ssh -v jenkins@192.168.0.29

#jenkins user add rsa key in freenas
[jenkins@freenas ~/.ssh]$ ssh-keygen -t rsa
The key fingerprint is:
SHA256:l7g/OFaD0EKFNmHhTvmEVlsF+oQA3fI6YPtuTvIoWNQ jenkins@apache

less ~/.ssh/id_rsa.pub
ssh-rsa KEY jenkins@freenas.local
ssh-rsa KEY jenkins@albandri

#freenas
ssh -X jenkins@192.168.1.62
ssh-keyscan -t rsa 192.168.1.61 >> /mnt/dpool/jenkins/.ssh/known_hosts
#in the jail
ssh-keyscan -t rsa 192.168.1.61 >> ~/.ssh/known_hosts

#from jenkins master as jenkins user (su - jenkins)
cat .ssh/id_rsa.pub | ssh jenkins@192.168.1.61 'cat >> .ssh/authorized_keys'

#pw groupadd -n www -g 80 #already exist
pw useradd -n albandri -u 1000 -d /usr/local/albandri -s /usr/local/bin/bash

#user www-data 33 33 TO DELETE
#use instead www 80

#freenas
ssh jenkins@192.168.1.62
ssh-keyscan -t rsa 192.168.0.29 >> /mnt/dpool/jenkins/.ssh/known_hosts

pw groupadd -n bower -g 34
pw useradd -n bower -u 34 -d /nonexistent -s /usr/sbin/nologin

# In jail
#passwd jenkins
#su jenkins

exit 0

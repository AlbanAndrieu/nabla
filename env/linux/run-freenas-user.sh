#!/bin/bash
#set -xv

id jenkins
#uid=818(jenkins) gid=818(jenkins) groups=818(jenkins)

#in jail
edit /etc/group

pkg install bash
#Delete user with wrong id

# usermod -u 117 jenkins
#pw userdel jenkins
pw groupadd -n jenkins -g 131
#pw useradd -n jenkins -u 117 -d /nonexistent -s /usr/sbin/nologin
pw useradd -n jenkins -u 117 -d /usr/local/jenkins -s /usr/local/bin/bash
#pw groupmod -g 131 jenkins
pw groupmod jenkins -m jenkins
pw usermod jenkins -G wheel

chown jenkins:jenkins /usr/local/jenkins
chown -R jenkins:jenkins /var/run/jenkins

#jenkins_2 jail
ssh -v jenkins@192.168.0.26
#albandri
ssh -v jenkins@192.168.0.29

#jenkins_1 jail
ssh -v jenkins@192.168.0.14
#albandri
ssh -v jenkins@192.168.0.29

#jenkins user add rsa key in freenas
[jenkins@freenas ~/.ssh]$ ssh-keygen -t rsa
Generating public/private rsa key pair.
Enter file in which to save the key (/mnt/dpool/jenkins/.ssh/id_rsa):
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /mnt/dpool/jenkins/.ssh/id_rsa.
Your public key has been saved in /mnt/dpool/jenkins/.ssh/id_rsa.pub.
The key fingerprint is:
37:41:20:f6:8e:c8:aa:23:b7:45:82:7e:df:46:b2:7a jenkins@freenas.local

less ~/.ssh/id_rsa.pub
ssh-rsa KEY jenkins@freenas.local
ssh-rsa KEY jenkins@albandri

#freenas
ssh -X jenkins@192.168.1.24
ssh-keyscan -t rsa 192.168.0.29 >> /mnt/dpool/jenkins/.ssh/known_hosts
#in the jail
ssh-keyscan -t rsa 192.168.0.29 >> ~/.ssh/known_hosts

#from jenkins master as jenkins user (su - jenkins)
cat .ssh/id_rsa.pub | ssh jenkins@192.168.0.26 'cat >> .ssh/authorized_keys'


#pw groupadd -n www -g 80 #already exist
pw useradd -n albandri -u 1000 -d /usr/local/albandri -s /usr/local/bin/bash

#user www-data 33 33 TO DELETE
#use instead www 80

#freenas
ssh jenkins@192.168.1.24
ssh-keyscan -t rsa 192.168.0.29 >> /mnt/dpool/jenkins/.ssh/known_hosts

pw groupadd -n bower -g 34
pw useradd -n bower -u 34 -d /nonexistent -s /usr/sbin/nologin



exit 0

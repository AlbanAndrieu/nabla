#!/bin/bash
set -xv

sudo apt-get purge openssh-server openssh-client
sudo apt-get install openssh-server openssh-client

#First, check that your SSH daemon is running:
ps -A | grep sshd

sudo ss -lnp | grep sshd

sudo lsof -i | grep ssh
netstat -l --numeric-ports | grep 22

ssh localhost

#ssh tunelling example
ssh -D 9696 albandri@albandri.misys.global.ad

As jenkins@192.168.0.29

ssh-keygen
#ssh-keygen -f ~/test-key-rsa -t rsa -b 4096

#https://serverfault.com/questions/132970/can-i-automatically-add-a-new-host-to-known-hosts
#Add wifi
ssh-keyscan 192.168.0.19 >> ~/.ssh/known_hosts
#Add ethernet
ssh-keyscan 192.168.0.18 >> ~/.ssh/known_hosts

As jenkins@albandri-laptop-work aka 192.168.0.19 (wifi) or 192.168.0.18 (ehternet)
ssh-keyscan 192.168.0.29 >> ~/.ssh/known_hosts
cat .ssh/id_rsa.pub | ssh jenkins@192.168.0.29 'cat >> .ssh/authorized_keys'

#Permissions for '.ssh/id_rsa' are too open
chmod 400 ~/.ssh/id_rsa*

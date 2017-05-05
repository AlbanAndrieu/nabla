#!/bin/bash
set -xv

#Connect to windows share
#smb://ptxw011116/share/

sudo apt-get install -y samba samba-common python-glade2 system-config-samba
#https://help.ubuntu.com/lts/serverguide/samba-fileserver.html
sudo mkdir -p /srv/samba/share
sudo chown nobody:nogroup /srv/samba/share/

sudo nano /etc/samba/smb.conf

[global]
	workgroup = WORKGROUP
	server string = Samba Server %v
	netbios name = ubuntu
	security = user
	map to guest = bad user
	dns proxy = no

#============================ Share Definitions ==============================

[share]
    comment = Ubuntu File Server Share
    path = /srv/samba/share
    browsable = yes
    guest ok = yes
    read only = no
    create mask = 0755

#[Anonymous]
#path = /srv/samba/share
#browsable =yes
#writable = yes
#guest ok = yes
#read only = no
#force user = nobody


sudo service smbd restart
sudo service firewall stop

smb://10.25.40.104/share/
smb://10.25.40.139/share/

#!/bin/bash
set -xv

#Connect to windows share
#smb://ptxw011116/share/

sudo apt-get install -y samba samba-common python-glade2 system-config-samba

#check mountable filesystem
lsof | grep '/srv'
#umount auto_srv
less /etc/mtab

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
#    path = /srv/samba/share
    path = /workspace/samba/share
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

# See https://www.cyberciti.biz/faq/how-to-configure-samba-to-use-smbv2-and-disable-smbv1-on-linux-or-unix/
# Append 
min protocol = SMB2
client min protocol = SMB2
#client max protocol = SMB3
   
#sudo service smbd restart
sudo systemctl restart smbd.service
sudo service firewall stop

smb://10.25.40.104/share/
smb://10.25.40.139/share/

exit 0

#!/bin/bash
set -xv

sudo systemctl disable apport-autoreport.service
sudo -i geany /etc/default/apport
# put enabled=0
sudo apt purge apport

systemctl list-unit-files

ls -lrta /etc/systemd/system/

#nano /lib/systemd/system/iscsid.service
nano /lib/systemd/system/docker.service
#ADD iscsid.service
#BindsTo=containerd.service iscsid.service
#After=network-online.target iscsid.service firewalld.service containerd.service
#Wants=network-online.target iscsid.service
systemctl cat docker.service

systemctl list-units --type service

systemctl list-units --failed
#systemctl disable autoprotect.service
#systemctl disable vboxweb.service
sudo systemctl status snap.bluez.bluez.service

systemctl --no-pager status

# Issue https://unix.stackexchange.com/questions/533933/systemd-cant-unmask-root-mount-mount
#systemctl unmask  -- -.mount
# close gparted
#sudo rm /run/systemd/system/-.mount
sudo systemctl daemon-reload

systemd-analyze plot > /home/albandrieu/Downloads/file.svg


exit 0

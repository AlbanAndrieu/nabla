#!/bin/bash
set -xv

systemctl list-unit-files

#nano /lib/systemd/system/iscsid.service
nano /lib/systemd/system/docker.service
#ADD iscsid.service
#BindsTo=containerd.service iscsid.service
#After=network-online.target iscsid.service firewalld.service containerd.service
#Wants=network-online.target iscsid.service
systemctl cat docker.service

exit 0

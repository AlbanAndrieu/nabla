#!/bin/bash
set -xv

#release
sudo dhclient -v -r wlan1
#renew
sudo dhclient -v -r wlan1
#Changed below!!!
sudo nano /etc/resolv.conf

#if you have issue with you dns configuration not updated automatically by DHCP

#http://askubuntu.com/questions/54888/resolvconf-u-gives-the-error-resolvconf-error-etc-resolv-conf-must-be-a-sym
dpkg-reconfigure resolvconf
sudo resolvconf -u

sudo nano /etc/resolvconf/resolv.conf.d/head
#Add
nameserver 8.8.4.4

sudo service network-manager restart
less /etc/resolv.conf

#Since upgrade from ubuntu 14.04
#http://askubuntu.com/questions/462560/ubuntu-14-04-wont-shutdown-or-reboot
#network-manager Could not acquire the org.freedesktop.ModemManager1 service name
sudo apt-get purge modemmanager
sudo apt-get install modemmanager

dpkg-reconfigure nis
#change

#check
domainname
less /etc/defaultdomain

#https://help.ubuntu.com/community/SettingUpNISHowTo
#https://docs.oracle.com/cd/E19455-01/806-1387/6jam692fn/index.html
status rpcbind
#start rpcbind
#/etc/init.d/nis restart
#sudo service rpcbind start
status ypbind
start ypbind
ypwhich
yptest

dmesg
service nis stop
ipconfig /flushdns

#systemctl disable bind9
#sudo update-rc.d bind9 disable

#!/bin/bash
set -xv

#http://doc.ubuntu-fr.org/nis
#sudo apt-get install portmap
sudo apt-get install nis

#put nis server to /etc/hosts
#See https://alexandrelebris.wordpress.com/2017/12/15/installation-et-configuration-dun-serveur-nis/

#nis domain albandrieu.com
sudo service ypserv start
sudo service nis start
dpkg-reconfigure nis

#To get access to /home/jenkins
systemctl stop autofs

ypwhich
ypdomainname
sudo /usr/lib/yp/ypinit -m
#Now you can run ypinit -s albandrieu on all slave server

exit 0

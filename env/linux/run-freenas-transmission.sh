#!/bin/bash
set -xv

#transmission
http://192.168.0.01:9091/
http://albandrieu.com:9091/transmission/web/
#in the jail
cd /usr/pbi/transmission-amd64/etc/transmission/home/
edit /usr/pbi/transmission-amd64/etc/transmission/home/settings.json

#install transmission remote gui
#https://code.google.com/p/transmisson-remote-gui/downloads/list

#https://blog.tetsumaki.net/articles/2017/04/bloquer-hadopi-et-tmg-sous-rtorrent-et-transmission.html

cd /usr/local/etc/transmission/home/
#Add to rpc-whitelist
#127.0.0.1.192.168.1.24,172.16.0.18

cd /mnt/dpool/www/apache24/data/nabla-site-apache/scripts
./run-wicked.sh

cp /mnt/dpool/www/apache24/data/nabla-site-apache/scripts/out-transmission-wickedlist.txt /mnt/dpool/iocage/jails/transmission/root/usr/local/etc/transmission/home/blocklists/
cd /usr/local/etc/transmission/home/blocklists

#Or use https://www.iblocklist.com/list?list=fr
#http://list.iblocklist.com/?list=fr&fileformat=p2p&archiveformat=gz

service transmission restart

exit 0

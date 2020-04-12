#!/bin/bash
#set -xv

# See https://kinsta.com/fr/base-de-connaissances/vider-cache-dns/
# https://www.maketecheasier.com/flush-dns-cache-linux/

#Windows
ipconfig /flushdns
#Macosx
dscacheutil -flushcache
#linux
sudo systemd-resolve --flush-caches
sudo systemd-resolve --statistics

sudo systemctl restart systemd-resolved.service
sudo systemctl restart dnsmasq
sudo systemctl restart named
sudo systemctl restart nscd

exit 0

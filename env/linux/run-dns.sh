#!/bin/bash
#set -xv

# See https://kinsta.com/fr/base-de-connaissances/vider-cache-dns/
# https://www.maketecheasier.com/flush-dns-cache-linux/

sudo nano /etc/resolvconf/resolv.conf.d/head
#Adresse IP du DNSv4 secondaire
nameserver 80.10.246.136
nameserver 10.21.200.3
nameserver 10.25.200.3
search home misys.global.ad finastra.global

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

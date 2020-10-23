#!/bin/bash
set -xv

sudo nano /etc/resolvconf/resolv.conf.d/head

nameserver 8.8.8.8
nameserver 8.8.4.4
nameserver 10.21.200.3
nameserver 10.25.200.3

sudo nano /etc/resolv.conf

nameserver 8.8.8.8
nameserver 8.8.4.4
nameserver 10.21.200.3
nameserver 10.25.200.3
nameserver 127.0.0.53

systemd-resolve --status

exit 0

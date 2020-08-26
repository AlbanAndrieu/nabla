#!/bin/bash
set -xv

sudo netplan apply
#sudo /etc/init.d/network-manager restart

exit 0

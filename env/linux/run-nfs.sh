#!/bin/bash
#set -xv

sudo apt-get install nfs-common

./run-freenas-hdd.sh

resolvectl status

exit 0

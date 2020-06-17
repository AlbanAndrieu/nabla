#!/bin/bash
set -xv

# See https://github.com/freenas/iocage-ports1

# See https://gist.github.com/mow4cash/e2fd4991bd2b787ca407a355d134b0ff

ssh -X root@nabla

iocage list

#Freenas plugins unable to open database file
#Maybe https://community.home-assistant.io/t/my-outdated-quick-start-for-home-assistant-core-on-freenas-11-2/71882/66
iocage destroy homeassistant

iocage df
iocage fetch
iocage restart jenkins

/sbin/umount -f /mnt/dpool/iocage/jails/jenkins/root/media/jenkins

df -h | grep -v RELEASE | grep -v devfs | grep -v fdescfs  | grep -v system

# Update plugins
iocage update clamav

./run-freenas-sonarr.sh

./run-freenas-radarr.sh

./run-freenas-jackett.sh

exit 0

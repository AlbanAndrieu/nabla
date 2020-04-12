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
#iocage exec jenkins /sbin/umount -t nullfs /mnt/dpool/iocage/jails/jenkins/root/media/jenkins
#iocage fstab -a plexmediaserver /mnt/dpool/media /mnt/dpool/iocage/jails/plexmediaserver/root/media nullfs rw 0 0

df -h | grep -v RELEASE | grep -v devfs | grep -v fdescfs  | grep -v system

# Update plugins
iocage update clamav

# Media Permissions
iocage exec transmission "pw user add media -c media -u 8675309 -d /nonexistent -s /usr/bin/nologin"
#iocage exec transmission "pw groupadd -n media -g 8675309"
iocage exec transmission "pw groupmod media -m transmission"
#iocage exec transmission  chown -R media:media /config/transmission-home
iocage exec transmission  chown -R media:media /media
iocage exec transmission  sysrc 'transmission_user=media'

./run-freenas-sonarr.sh

./run-freenas-radarr.sh

./run-freenas-jackett.sh

exit 0

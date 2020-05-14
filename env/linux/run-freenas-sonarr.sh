#!/bin/bash
#set -xv

iocage exec sonarr "pw user add media -c media -u 8675309 -d /nonexistent -s /usr/bin/nologin"
#iocage exec sonarr "pw groupadd -n media -g 8675309"
iocage exec sonarr "pw groupmod media -m sonarr"
##iocage exec sonarr chown -R media:media /usr/local/share/Sonarr /config
iocage exec sonarr  sysrc 'sonarr_user=media'

iocage exec sonarr "pw user add transmission -c media -u 921 -d /nonexistent -s /usr/bin/nologin"

# mount
#/mnt/dpool/media/download/serie /mnt/dpool/iocage/jails/sonarr/root/media/serie

mkdir -p /usr/local/etc/transmission/home/Downloads/
cd /usr/local/etc/transmission/home/Downloads/
ln -s /media/music music

# In settings
# /usr/local/etc/transmission/home/Downloads/serie/ /media/serie/
# /usr/local/sabnzbd/Downloads/complete/serie/ /media/serie

exit 

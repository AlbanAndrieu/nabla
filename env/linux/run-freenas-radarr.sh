#!/bin/bash
#set -xv

iocage exec radarr "pw user add media -c media -u 8675309 -d /nonexistent -s /usr/bin/nologin"
#iocage exec radarr "pw groupadd -n media -g 8675309"
#iocage exec radarr "pw groupmod media -m radarr"
#iocage exec radarr chown -R media:media /usr/local/share/Radarr /config
iocage exec radarr sysrc 'radarr_user=media'

# mount
#/mnt/dpool/media/download/movie /mnt/dpool/iocage/jails/radarr/root/media/movie

# In settings
# /usr/local/etc/transmission/home/Downloads/serie/ /media/serie/

exit 

#!/bin/bash
#set -xv

#iocage exec jenkins /sbin/umount -t nullfs /mnt/dpool/iocage/jails/jenkins/root/media/jenkins
#iocage fstab -a plexmediaserver /mnt/dpool/media /mnt/dpool/iocage/jails/plexmediaserver/root/media nullfs rw 0 0

iocage exec sonarr "pw user add transmission -c media -u 921 -d /nonexistent -s /usr/bin/nologin"
iocage exec radarr "pw user add media -c media -u 8675309 -d /nonexistent -s /usr/bin/nologin"
iocage exec sonarr "pw groupmod media -m plex"

exit 0

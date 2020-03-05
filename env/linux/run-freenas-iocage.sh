#!/bin/bash
set -xv

# See https://github.com/freenas/iocage-ports1

# See https://gist.github.com/mow4cash/e2fd4991bd2b787ca407a355d134b0ff

ssh -X root@nabla

<<<<<<< HEAD
iocage list

#Freenas plugins unable to open database file
#Maybe https://community.home-assistant.io/t/my-outdated-quick-start-for-home-assistant-core-on-freenas-11-2/71882/66
iocage destroy homeassistant

iocage df
iocage fetch
=======
iocage df
>>>>>>> 9053cf3bd92d78dfb9f33cf5b39354fcbe34c705
iocage restart jenkins

/sbin/umount -f /mnt/dpool/iocage/jails/jenkins/root/media/jenkins
#iocage exec jenkins /sbin/umount -t nullfs /mnt/dpool/iocage/jails/jenkins/root/media/jenkins
#iocage fstab -a plexmediaserver /mnt/dpool/media /mnt/dpool/iocage/jails/plexmediaserver/root/media nullfs rw 0 0

df -h | grep -v RELEASE | grep -v devfs | grep -v fdescfs  | grep -v system

<<<<<<< HEAD
# Update plugins
iocage update clamav

=======
>>>>>>> 9053cf3bd92d78dfb9f33cf5b39354fcbe34c705
# Media Permissions
iocage exec transmission "pw user add media -c media -u 8675309 -d /nonexistent -s /usr/bin/nologin"
#iocage exec transmission "pw groupadd -n media -g 8675309"
iocage exec transmission "pw groupmod media -m transmission"
#iocage exec transmission  chown -R media:media /config/transmission-home
iocage exec transmission  chown -R media:media /media
iocage exec transmission  sysrc 'transmission_user=media'

iocage exec sonarr "pw user add media -c media -u 8675309 -d /nonexistent -s /usr/bin/nologin"
#iocage exec sonarr "pw groupadd -n media -g 8675309"
iocage exec sonarr "pw groupmod media -m sonarr"
##iocage exec sonarr chown -R media:media /usr/local/share/Sonarr /config
iocage exec sonarr  sysrc 'sonarr_user=media'

iocage exec radarr "pw user add media -c media -u 8675309 -d /nonexistent -s /usr/bin/nologin"
#iocage exec radarr "pw groupadd -n media -g 8675309"
#iocage exec radarr "pw groupmod media -m radarr"
#iocage exec radarr chown -R media:media /usr/local/share/Radarr /config
iocage exec radarr sysrc 'radarr_user=media'

exit 0

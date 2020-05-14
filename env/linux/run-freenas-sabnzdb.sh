#!/bin/bash
#set -xv

echo '{"pkgs":["sabnzbdplus","ca_root_nss"]}' > /tmp/pkg.json
iocage create -n "sabnzbd" -p /tmp/pkg.json -r 11.3-RELEASE ip4_addr="vnet0|172.16.0.27/30" defaultrouter="172.16.0.1" vnet="on" \
nat_forwards='tcp(8080)' \
nat="on" allow_raw_sockets="1" boot="on" --basejail

rm /tmp/pkg.json
iocage fstab -a sabnzbd /mnt/dpool/apps/sabnzbd /config nullfs rw 0 0
iocage fstab -a sabnzbd /mnt/dpool/media/torrentfile /mnt/torrentfile nullfs rw 0 0
iocage exec sabnzbd mkdir -p /mnt/torrentfile/sabnzbd/incomplete
iocage exec sabnzbd mkdir -p /mnt/torrentfile/sabnzbd/complete
iocage exec sabnzbd ln -s /usr/local/bin/python2.7 /usr/bin/python
iocage exec sabnzbd ln -s /usr/local/bin/python2.7 /usr/bin/python2
iocage exec sabnzbd chown -R _sabnzbd:_sabnzbd /mnt/torrentfile/sabnzbd /config
iocage exec sabnzbd sysrc sabnzbd_enable=YES
iocage exec sabnzbd sysrc sabnzbd_conf_dir="/config"
iocage exec sabnzbd service sabnzbd start
iocage exec sabnzbd service sabnzbd stop
iocage exec sabnzbd sed -i '' -e 's?host = 127.0.0.1?host = 0.0.0.0?g' /config/sabnzbd.ini
iocage exec sabnzbd sed -i '' -e 's?download_dir = Downloads/incomplete?download_dir = /mnt/torrentfile/sabnzbd/incomplete?g' /config/sabnzbd.ini
iocage exec sabnzbd sed -i '' -e 's?complete_dir = Downloads/complete?complete_dir = /mnt/torrentfile/sabnzbd/complete?g' /config/sabnzbd.ini
iocage exec sabnzbd service sabnzbd start

exit 0

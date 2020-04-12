#!/bin/bash
#set -xv

iocage list -b
#See https://www.freebsd.org/cgi/man.cgi?query=iocage&sektion=8

echo '{"pkgs":["mono","mediainfo","sqlite3","ca_root_nss","curl","chromaprint"]}' > /tmp/pkg.json
iocage create -n "lidarr" -p /tmp/pkg.json -r 11.3-RELEASE ip4_addr="vnet0|172.16.0.27/30" defaultrouter="172.16.0.1" vnet="on" \
nat_forwards='tcp(8686)' \
nat="on" allow_raw_sockets="1" boot="on" --basejail

#ADD natforward 8683

rm /tmp/pkg.json
iocage exec lidarr mkdir -p /config
iocage exec lidarr mkdir -p /mnt/music
iocage exec lidarr mkdir -p /mnt/torrentfile
iocage fstab -a lidarr /mnt/dpool/apps/lidarr /config nullfs rw 0 0
iocage fstab -a lidarr /mnt/dpool/media/torrentfile /mnt/torrentfile nullfs rw 0 0
iocage fstab -a lidarr /mnt/dpool/media/music /mnt/music nullfs rw 0 0
#iocage exec lidarr ln -s /usr/local/bin/mono /usr/bin/mono
#iocage exec lidarr rm /usr/local/share/lidarr
iocage exec lidarr "fetch https://github.com/lidarr/Lidarr/releases/download/v0.7.1.1381/Lidarr.master.0.7.1.1381.linux.tar.gz -o /usr/local/share"
iocage exec lidarr "tar -xzvf /usr/local/share/Lidarr.master.0.7.1.1381.linux.tar.gz -C /usr/local/share"
iocage exec lidarr rm /usr/local/share/Lidarr.master.0.7.1.1381.linux.tar.gz
iocage exec lidarr "pw user add lidarr -c lidarr -u 353 -d /nonexistent -s /usr/bin/nologin"
iocage exec lidarr chown -R lidarr:lidarr /usr/local/share/Lidarr /config
#iocage exec lidarr mkdir /usr/local/etc/rc.d
#Create an rc file for lidarr using your favorite editor at 
nano /mnt/dpool/iocage/jails/lidarr/root/usr/local/etc/rc.d/lidarr

iocage exec lidarr chmod u+x /usr/local/etc/rc.d/lidarr
iocage exec lidarr sysrc "lidarr_enable=YES"
iocage exec lidarr service lidarr restart

lidarr should be available at http://192.168.1.24:8683
#iocage start lidarr

# In settings
#/usr/local/etc/transmission/home/Downloads/music/ /mnt/music/

iocage df

exit 

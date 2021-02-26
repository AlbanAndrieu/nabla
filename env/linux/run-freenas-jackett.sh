#!/bin/bash
#set -xv

iocage list -b
#See https://www.freebsd.org/cgi/man.cgi?query=iocage&sektion=8

echo '{"pkgs":["mono","curl","ca_root_nss"]}' > /tmp/pkg.json
iocage create -n "jackett" -p /tmp/pkg.json -r 11.3-RELEASE ip4_addr="vnet0|172.16.0.27/30" defaultrouter="172.16.0.1" vnet="on" \
nat_forwards='tcp(9117)' \
nat="on" allow_raw_sockets="1" boot="on" --basejail

rm /tmp/pkg.json
iocage exec jackett mkdir -p /config
iocage fstab -a jackett /mnt/dpool/apps/jackett /config nullfs rw 0 0
#iocage exec jackett ln -s /usr/local/bin/mono /usr/bin/mono
#iocage exec jackett rm /usr/local/share/Jackett
iocage exec jackett "fetch https://github.com/Jackett/Jackett/releases/download/v0.14.99/Jackett.Binaries.Mono.tar.gz -o /usr/local/share"
iocage exec jackett "tar -xzvf /usr/local/share/Jackett.Binaries.Mono.tar.gz -C /usr/local/share"
iocage exec jackett rm /usr/local/share/Jackett.Binaries.Mono.tar.gz
iocage exec jackett "pw user add jackett -c jackett -u 818 -d /nonexistent -s /usr/bin/nologin"
iocage exec jackett chown -R jackett:jackett /usr/local/share/Jackett /config
iocage exec jackett mkdir /usr/local/etc/rc.d
#Create an rc file for jackett using your favorite editor at
nano /mnt/dpool/iocage/jails/jackett/root/usr/local/etc/rc.d/jackett

iocage exec jackett chmod u+x /usr/local/etc/rc.d/jackett
iocage exec jackett sysrc "jackett_enable=YES"
iocage exec jackett service jackett restart

Jackett should be available at http://192.168.1.24:9117
#iocage start jackett

# http://www.omdbapi.com/?i=tt3896198&apikey=f3b80c44

# Test
# From outside http://192.168.1.24:9117/api/v2.0/indexers/gktorrent/results/torznab/api?t=caps&apikey=sprfux7y52dbksyktc56ksjq4iebaj9r
# From inside http://172.16.0.22:9117/api/v2.0/indexers/gktorrent/results/torznab/

# http://172.16.0.22:9117/api/v2.0/indexers/all/results/torznab

# https://www.oxtorrent.com/ is working well

iocage df

exit

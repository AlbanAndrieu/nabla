#!/bin/bash
set -xv

# https://www.ixsystems.com/community/resources/how-to-install-clamav-on-freenas-v11.66/

iocage create -n "clamav" -p /tmp/pkg.json -r 11.3-RELEASE ip4_addr="vnet0|172.16.0.27/30" defaultrouter="172.16.0.1" vnet="on" \
nat_forwards='tcp(9117)' \
nat="on" allow_raw_sockets="1" boot="on" --basejail
#defaultrouter="192.168.1.1”

#add /mnt/dpool --> /mnt/dpool as ready only

iocage start clamav
iocage set boot=on clamav

# Update virus defination
freshclam
touch /var/log/clamav/freshclam.log
chmod 600 /var/log/clamav/freshclam.log
chown clamav /var/log/clamav/freshclam.log

edit /usr/local/etc/freshclam.conf

sysrc clamav_freshclam_enable="YES"
freshclam -d

sysrc clamav_clamd_enable="YES"
clamd -d

iocage start clamav

ps -aux | grep clam

# See https://github.com/jaburt/FreeNAS-Server-ClamAV-Scan/blob/master/run_clamav_scan.sh
# Add cron
#/root/run-clamav-scan.sh "/mnt/dpool/www"
# iocage exec clamav clamscan -i -r -z -a -l  /var/log/clamav/jab_clamscan000.log /mnt/dpool/iocage/jails/clamav/root/mnt/dpool/www/

exit 0

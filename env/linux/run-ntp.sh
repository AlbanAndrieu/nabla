#!/bin/bash
set -xv

#this will sync localtime with ntp
#there are two dashes before systohc

/etc/init.d/ntpd stop
ntpdate timehost
hwclock --systohc
hwclock --show
/etc/init.d/ntpd start

#On RHEL7 issue conficts between chronyd and ntpd
#systemctl list-unit-files | grep ntpd
systemclt status ntpd.service
systemctl status chronyd
systemctl stop chronyd
systemctl disable chronyd
#systemctl enable dhcpd.service
#systemctl enable named.service
systemctl enable ntpd.service
#systemctl enable httpd.service
systemctl start ntpd.service

journalctl -b | grep ntpd
systemctl status ntpd
cat /var/log/messages | grep ntpd
netstat -tulpn | grep 123
systemctl status chronyd

#See https://www.certdepot.net/rhel7-set-ntp-service/
timedatectl
timedatectl list-timezones

exit 0

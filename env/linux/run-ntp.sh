#!/bin/bash
set -xv

#this will sync localtime with ntp
#there are two dashes before systohc

/etc/init.d/ntpd stop
ntpdate timehost
hwclock --systohc
hwclock --show
/etc/init.d/ntpd start

#On RHEL7
#systemctl list-unit-files | grep ntpd
systemclt status ntpd.service
systemctl stop chronyd
#systemctl enable dhcpd.service
#systemctl enable named.service
systemctl enable ntpd.service
#systemctl enable httpd.service
systemctl start ntpd.service

exit 0

#!/bin/bash
#set -xv

tmpreaper --test 2d /tmp
#nano /etc/cron.daily/tmpreaper
#nano /etc/tmpreaper.conf

nano /etc/rsyslog.d/50-default.conf
#Uncomment
#cron.*     /var/log/cron.log
service rsyslog restart

#crontab -e

exit 0

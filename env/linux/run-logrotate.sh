#!/bin/bash
set -xv

systemctl status logrotate.service
cat /etc/logrotate.conf

sudo rm -f /etc/logrotate.d/falcon-sensor
systemctl start logrotate.service

exit 0

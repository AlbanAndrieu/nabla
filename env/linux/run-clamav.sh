#!/bin/bash
set -xv

# https://wiki.jenkins-ci.org/display/JENKINS/ClamAV+Plugin
sudo apt-get install clamav-base clamav-daemon clamav-docs clamav
#sudo apt-get install clamtk-nautilus
sudo apt-get install clamtk-gnome

# See https://doc.ubuntu-fr.org/clamav

# Update clamav virus definition
freshclam

# Balayer les fichiers du dossier personnel
clamscan
clamscan -r /home/albandrieu
clamscan -r /

# check is it running
netstat -tlpn | grep clam

tail -f /var/log/clamav/freshclam.log

sudo apt-get install inotify-tools
./run-clamav-tr.sh

sudo clamscan --max-filesize=3999M --max-scansize=3999M --exclude-dir=/kgr/* --exclude-dir=/home/* --exclude-dir=/sys/* --exclude-dir=/proc/* -i -r /

#sudo freshclam
#clamscan -r --bell -i /
#Schedule a scan tommorrow
#at 3:30 tomorrow
#clamscan -i / | mail alban.andrieu@free.fr
#<CTRL-D>

clamscan --infected

#sudo apt-get install libmilter1.0.1 libmilter-dev
less /etc/clamav/freshclam.conf

netstat -anp | grep -E "(Active|State|clam|3310)"

sudo nano /etc/clamav/clamd.conf
# Add
#TCPSocket 3310
#TCPAddr 192.168.1.25

#systemctl disable clamav-daemon.service
systemctl restart clamav-daemon.service

sudo clamd ping

clamdtop

sudo nano /etc/cron.daily/daily_scan
#-i – display information only about infected files
#-r – scan all subdirectories recursively
clamscan --max-filesize=3999M --max-scansize=3999M --exclude-dir=/media/* --exclude-dir=/home/test/* --exclude-dir=/sys/* --exclude-dir=/proc/* -i -r / >> /var/log/clamav/clamav-cron-albandrieu.log

telnet 192.168.1.25 3310

# For Windows, see http://fr.clamwin.com/

exit

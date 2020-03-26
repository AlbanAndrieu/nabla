#!/bin/bash
set -xv

#http://doc.ubuntu-fr.org/heartbeat
#sudo apt-get install heartbeat
#sudo /etc/init.d/heartbeat start
systemctl disable heartbeat.service

curl -L -O https://artifacts.elastic.co/downloads/beats/heartbeat/heartbeat-7.6.1-amd64.deb
sudo dpkg -i heartbeat-7.6.1-amd64.deb

sudo nano /etc/heartbeat/heartbeat.yml

sudo heartbeat setup
sudo service heartbeat-elastic start

ll /usr/share/heartbeat

less /var/log/heartbeat/heartbeat

exit 0

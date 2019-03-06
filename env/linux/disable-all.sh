#!/bin/bash
set -xv

systemctl stop webmin
systemctl stop usermin
systemctl stop jetty
systemctl stop jenkins
systemctl stop selenium_hub
systemctl stop sonar
systemctl stop rabbitmq-server
systemctl stop jboss
systemctl stop zabbix-agent
systemctl stop supervisor
systemctl stop mon
systemctl stop tomcat7
systemctl stop elasticsearch
systemctl stop logstash
systemctl stop logstash-web
systemctl stop collectd
systemctl stop mailman.service
systemctl stop bumblebeed
systemctl stop apparmor
systemctl stop docker
systemctl stop docker.io
systemctl stop apache2
systemctl stop ChrononController
systemctl stop postgresql
systemctl stop mysql
systemctl stop nginx
systemctl stop varnish
systemctl stop gearman-job-server
systemctl stop ansible-tower
systemctl stop redis-server
systemctl stop private-bower
systemctl stop mongod
systemctl stop nis
systemctl stop teamviewerd

systemctl stop slapd
systemctl stop snmpd
systemctl stop sendmail
systemctl stop iscsitarget
systemctl stop nmbd
systemctl stop smbd
systemctl stop samba
systemctl stop lightdm
systemctl stop avahi-daemon
sh -c "echo manual > /etc/init/avahi-daemon.override"
systemctl stop memcached
systemctl stop clamav-freshclam
systemctl stop clamav-daemon
systemctl stop osspd
systemctl stop cups
systemctl stop cups-browsed
systemctl stop ypbind
systemctl stop apt-cacher-ng

#update-rc.d -f todo remove

systemctl disable webmin remove
systemctl disable usermin remove
systemctl disable jetty remove
systemctl disable jenkins remove
systemctl disable selenium_hub remove
systemctl disable selenium-standalone remove
systemctl disable sonar remove
systemctl disable rabbitmq-server remove
systemctl disable jboss remove
systemctl disable zabbix-agent remove
systemctl disable supervisor remove
#systemctl disable supervisord remove
systemctl disable mon remove
systemctl disable sendmail remove
systemctl disable tomcat7 remove
systemctl disable elasticsearch remove
systemctl disable logstash remove
systemctl disable logstash-web remove
#sudo rm /etc/init.d/logstash-web
systemctl disable collectd remove
systemctl disable mailman.service remove
systemctl disable bumblebeed remove
systemctl disable apparmor remove
systemctl disable docker remove
systemctl disable apache2 remove
systemctl disable ChrononController remove
systemctl disable postgresql remove
systemctl disable mysql remove
systemctl disable nginx remove
systemctl disable varnish remove
systemctl disable gearman-job-server remove
#sudo apt-get remove gearman gearman-job-server
systemctl disable ansible-tower remove
systemctl disable redis-server remove
systemctl disable private-bower remove
systemctl disable mongod remove
systemctl disable teamviewerd remove
systemctl disable nis remove
systemctl disable cfengine2 remove
systemctl disable cfengine3 remove
systemctl disable memcached remove
systemctl disable clamav-freshclam remove
systemctl disable clamav-daemon remove
systemctl disable osspd remove
systemctl disable cups remove
systemctl disable cups-browsed remove
systemctl disable ypbind remove

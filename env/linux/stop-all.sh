#!/bin/bash
set -xv

systemctl stop jenkins
systemctl stop selenium_hub
systemctl stop apache2
systemctl stop tomcat6
systemctl stop tomcat7
systemctl stop jboss

systemctl stop sonar
systemctl stop nexus
systemctl stop crowd
systemctl stop mysql
#mountall
systemctl stop icinga
#systemctl stop ssh

systemctl stop rabbitmq-server
systemctl stop zabbix-agent
systemctl stop supervisord
systemctl stop mon
systemctl stop mongod
systemctl stop nginx

#systemctl stop lightdm
#if mouse get stuck
#http://superuser.com/questions/72112/mouse-clicks-suddenly-stopped-working-in-ubuntu
#apt-get remove flashplugin-nonfree flashplugin-installer
#metacity --replace

systemctl stop webmin
systemctl stop usermin
systemctl stop jetty
#systemctl stop jenkins
#systemctl stop sonar
systemctl stop rabbitmq-server
#systemctl stop jboss
systemctl stop supervisord
systemctl stop mon
#systemctl stop tomcat7
systemctl stop elasticsearch
systemctl stop logstash
systemctl stop logstash-web
systemctl stop collectd
systemctl stop mailman.service
systemctl stop docker
systemctl stop docker.io
#sudo apt-get -y remove docker*
#systemctl stop apache2
systemctl stop ChrononController
systemctl stop postgresql
#systemctl stop mysql
systemctl stop nginx
systemctl stop varnish
systemctl stop gearman-job-server
systemctl stop redis-server
#systemctl stop private-bower
systemctl stop nis
systemctl stop teamviewerd
#systemctl stop conky

systemctl stop slapd
#sudo apt-get -y remove slapd
systemctl stop snmpd
#systemctl stop iscsitarget
systemctl stop nmbd
systemctl stop smbd
#systemctl stop lightdm
#http://www.ihackforfun.eu/index.php?title=improve-security-by-removing-services&more=1&c=1&tb=1&pb=1
systemctl stop avahi-daemon
#sh -c "echo manual > /etc/init/avahi-daemon.override"
systemctl stop memcached
systemctl stop cups
systemctl stop cups-browsed
#sudo apt-get -y remove cups
systemctl stop ypbind
systemctl stop apt-cacher-ng
#ps -edf | grep smmsp
systemctl stop sendmail

systemctl stop ansible-tower

systemctl stop clamav-daemon
systemctl stop clamav-freshclam
#https://linuxacademy.com/blog/linux/disabling-unused-daemons-to-speed-up-your-boot-sequence/
systemctl stop bluetooth
systemctl stop fancontrol
systemctl stop autofs

#tiger clamav are consuming too many resources
#ps -edf | grep tiger
#apt-get remove tiger
#apt-get remove clamav

#systemctl stop --status-all

#ps -edf | grep chrome
#ps -edf | grep firefox
#ps -edf | grep npm
#ps -edf | grep selenium
#ps -edf | grep slave

#security cleaning
#sudo apt-get remove ftp telnet xinetd finger sysstat rusersd rwho rwhod
#sudo apt-get remove net-tools

systemctl stop gitlab-runsvdir

exit 0

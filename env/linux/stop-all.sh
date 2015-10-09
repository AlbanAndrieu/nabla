#!/bin/sh

sudo service --status-all

sudo service jenkins stop
sudo service apache2 stop
sudo service tomcat6 stop
sudo service tomcat7 stop
sudo service varnish stop

sudo service sonar stop
sudo service nexus stop
sudo service crowd stop
sudo service mysql stop
#mountall
sudo service icinga stop
sudo service webmin stop
sudo service ssh stop

sudo service jetty stop
sudo service rabbitmq-server stop
sudo service jboss stop
sudo service zabbix-agent stop
sudo service supervisor stop
sudo service mon stop
sudo service mongod stop

#sudo service lightdm stop
#if mouse get stuck
#http://superuser.com/questions/72112/mouse-clicks-suddenly-stopped-working-in-ubuntu
#sudo apt-get remove flashplugin-nonfree flashplugin-installer
#metacity --replace

sudo service slapd stop
sudo service memcached stop
#http://www.ihackforfun.eu/index.php?title=improve-security-by-removing-services&more=1&c=1&tb=1&pb=1
sudo service avahi-daemon stop
sudo service iscsitarget stop
sudo service cups stop
sudo service clamav-daemon stop
sudo service clamav-freshclam stop
sudo service conky stop
#https://linuxacademy.com/blog/linux/disabling-unused-daemons-to-speed-up-your-boot-sequence/
sudo service bluetooth stop
sudo service fancontrol stop
sudo service lm-sensors stop
sudo service cups stop
sudo service cups-browsed stop
sudo service zabbix-agent stop
sudo service webmin stop
sudo service smb stop
sudo service postgresql stop
sudo service autofs stop

#tiger clamav are consuming too many resources
#ps -edf | grep tiger
#sudo apt-get remove tiger
#sudo apt-get remove clamav

sudo service --status-all

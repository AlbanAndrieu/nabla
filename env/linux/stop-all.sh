#!/bin/bash
set -xv

service jenkins stop
service selenium_hub stop
service apache2 stop
service tomcat6 stop
service tomcat7 stop
service jboss stop

service sonar stop
service nexus stop
service crowd stop
service mysql stop
#mountall
service icinga stop
#service ssh stop

service rabbitmq-server stop
service zabbix-agent stop
service supervisord stop
service mon stop
service mongod stop
service nginx stop

#service lightdm stop
#if mouse get stuck
#http://superuser.com/questions/72112/mouse-clicks-suddenly-stopped-working-in-ubuntu
#apt-get remove flashplugin-nonfree flashplugin-installer
#metacity --replace

service webmin stop
service usermin stop
service jetty stop
#service jenkins stop
#service sonar stop
service rabbitmq-server stop
#service jboss stop
service supervisord stop
service mon stop
#service tomcat7 stop
service elasticsearch stop
service logstash stop
service logstash-web stop
service collectd stop
service docker stop
service docker.io stop
#service apache2 stop
service ChrononController stop
service postgresql stop
#service mysql stop
service nginx stop
service varnish stop
service gearman-job-server stop
service redis-server stop
#service private-bower stop
service nis stop
service teamviewerd stop
#service conky stop

service slapd stop
service snmpd stop
#service iscsitarget stop
service nmbd stop
service smbd stop
#service lightdm stop
#http://www.ihackforfun.eu/index.php?title=improve-security-by-removing-services&more=1&c=1&tb=1&pb=1
service avahi-daemon stop
#sh -c "echo manual > /etc/init/avahi-daemon.override"
service memcached stop
service cups stop
service cups-browsed stop
service ypbind stop
service apt-cacher-ng stop

service ansible-tower stop

service clamav-daemon stop
service clamav-freshclam stop
#https://linuxacademy.com/blog/linux/disabling-unused-daemons-to-speed-up-your-boot-sequence/
service bluetooth stop
service fancontrol stop
service autofs stop

#tiger clamav are consuming too many resources
#ps -edf | grep tiger
#apt-get remove tiger
#apt-get remove clamav

#service --status-all

#ps -edf | grep chrome
#ps -edf | grep firefox
#ps -edf | grep npm
#ps -edf | grep selenium
#ps -edf | grep slave

#security cleaning
#sudo apt-get remove ftp telnet xinetd finger sysstat rusersd rwho rwhod
#sudo apt-get remove net-tools 

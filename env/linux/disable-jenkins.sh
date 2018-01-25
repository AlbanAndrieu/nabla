#!/bin/bash
set -xv

sudo service --status-all

#sudo apt-get install rcconf
sudo rcconf

#slow boot
#sudo systemd-analyze

sudo service webmin stop
sudo service usermin stop
sudo service jetty stop
#sudo service jenkins stop
#sudo service selenium_hub stop
#sudo service sonar stop
sudo service rabbitmq-server stop
#sudo apt-get remove rabbitmq-server
#sudo service jboss stop
sudo service zabbix-agent stop
sudo service supervisor stop
sudo service mon stop
#sudo service tomcat7 stop
sudo service elasticsearch stop
sudo service logstash stop
sudo service logstash-web stop
sudo service collectd stop
sudo service docker stop
sudo service docker.io stop
#sudo service apache2 stop
sudo service ChrononController stop
sudo service postgresql stop
#sudo apt-get remove postgresql
sudo service mysql stop
#sudo apt-get remove mysql-server mysql-client
sudo service nginx stop
sudo service varnish stop
sudo service gearman-job-server stop
sudo service redis-server stop
#sudo service private-bower stop
sudo service mongod stop
sudo service nis stop
sudo service teamviewerd stop
sudo service conky stop

sudo service slapd stop
sudo service snmpd stop
#sudo service iscsitarget stop
sudo service nmbd stop
sudo service smbd stop
sudo service lightdm stop
sudo service avahi-daemon stop
#sudo sh -c "echo manual > /etc/init/avahi-daemon.override"
#sudo apt-get remove avahi-daemon
#Bug avahi-daemon (3907): VmData 8982528 exceed data ulimit 4194304. Update limits or use boot option ignore_rlimit_data
#See https://patchwork.kernel.org/patch/8096761/
sudo service memcached stop
sudo service cups stop
#sudo apt-get remove cups
sudo service cups-browsed stop
sudo service ypbind stop
sudo service clamav-daemon stop
sudo service clamav-freshclam stop
sudo service crowd stop
sudo service xrdp stop
sudo service webmin stop
#udiskd ok
sudo service libvirt-bin stop
#sudo apt-get remove qemu-kvm libvirt-bin
sudo service rwhod stop
#sudo apt-get remove rwhod
#sudo apt-get remove pm2
#sudo npm remove pm2 -g
#ll /etc/.pm2
#rtkit ok
sudo service samba stop
sudo service postfix stop
#sudo auditctl -a exit,always -F path=/etc/passwd -F perm=wa
#sudo auditctl -l
sudo service auditd stop
sudo killall colord
#ansible-tower removed when postgresql removed
#sudo service ansible-tower stop
sudo service vnstat stop
#sudo apt-get remove vnstat
sudo service sysstat stop
#sudo apt-get remove sysstat
sudo service statsd stop
#sudo apt-get remove statsd
sudo service ntp stop
sudo service kerneloops-daemon stop
#sudo apt-get remove kerneloops-daemon
#https://doc.ubuntu-fr.org/bluetooth#desactiver_le_bluetooth_au_demarrage_d_ubuntu
sudo service bluetooth stop
sudo service saned stop
#sudo apt-get remove sane
sudo service snmpd stop
#sudo apt-get remove snmp
sudo service speech-dispatcher stop
#sudo apt-get remove speech-dispatcher
sudo service virtualbox stop
#sudo apt-get virtualbox
sudo service zfs-mount stop
sudo service zfs-share stop
#SCSI target
#tgtd ok
#acpid ok
sudo service pulseaudio stop
sudo killall pulseaudio
sudo service console-kit-deamon stop
#sudo apt-get remove consolekit
##sudo apt-get remove dbus-x11 consolekit
#sudo apt-get remove cfengine-community
#sudo apt-get remove heartbeat
#sudo apt-get remove kgrb5
sudo service nexus stop
sudo service sonar stop

#sudo update-rc.d -f webmin remove
sudo update-rc.d -f usermin remove
#sudo update-rc.d -f jetty remove
#sudo update-rc.d -f jenkins remove
#sudo update-rc.d -f selenium_hub remove
#sudo update-rc.d -f sonar remove
#sudo update-rc.d -f rabbitmq-server remove
#sudo update-rc.d -f jboss remove
sudo update-rc.d -f zabbix-agent remove
sudo update-rc.d -f supervisord remove
sudo update-rc.d -f mon remove
#sudo update-rc.d -f tomcat7 remove
sudo update-rc.d -f elasticsearch remove
sudo update-rc.d -f logstash remove
sudo update-rc.d -f logstash-web remove
#sudo apt-get remove logstash*
sudo update-rc.d -f collectd remove
sudo update-rc.d -f docker remove
#sudo update-rc.d -f apache2 remove
sudo update-rc.d -f ChrononController remove
sudo update-rc.d -f postgresql remove
#sudo update-rc.d -f mysql remove
sudo update-rc.d -f nginx remove
sudo update-rc.d -f varnish remove
sudo update-rc.d -f gearman-job-server remove
#sudo apt-get remove gearman gearman-job-server gearman-tools
sudo update-rc.d -f ansible-tower remove
sudo update-rc.d -f redis-server remove
#sudo update-rc.d -f private-bower remove
sudo update-rc.d -f mongod remove
sudo update-rc.d -f nis remove
sudo update-rc.d -f teamviewerd remove
sudo update-rc.d -f conky remove
sudo update-rc.d -f cups remove
sudo update-rc.d -f cups-browsed remove
sudo update-rc.d -f pm2-init.sh remove
sudo update-rc.d -f bluetooth remove
sudo update-rc.d -f cfengine3 remove
#sudo update-rc.d -f clamav-freshclam remove
#sudo update-rc.d -f clamav-daemon remove
sudo update-rc.d -f crowd remove
sudo update-rc.d -f xrdp remove
sudo update-rc.d -f webmin remove

#sudo apt-get purge nginx postgresql clonezilla varnish phpmyadmin postgresql elasticsearch cups bluetooth

exit 0

#!/bin/sh

sudo service webmin stop
sudo service usermin stop
sudo service jetty stop
sudo service jenkins stop
sudo service sonar stop
sudo service rabbitmq-server stop
sudo service jboss stop
sudo service zabbix-agent stop
sudo service supervisor stop
sudo service mon stop
sudo service tomcat7 stop
sudo service elasticsearch stop
sudo service logstash stop
sudo service logstash-web stop
sudo service docker stop
sudo service apache2 stop
sudo service ChrononController stop
sudo service postgresql stop
sudo service mysql stop
sudo service nginx stop
sudo service varnish stop
sudo service gearman-job-server stop
sudo service ansible-tower stop

sudo update-rc.d -f webmin remove
sudo update-rc.d -f usermin remove
sudo update-rc.d -f jetty remove
sudo update-rc.d -f jenkins remove
sudo update-rc.d -f sonar remove
sudo update-rc.d -f rabbitmq-server remove
sudo update-rc.d -f jboss remove
sudo update-rc.d -f zabbix-agent remove
sudo update-rc.d -f supervisor remove
#sudo update-rc.d -f supervisord remove
sudo update-rc.d -f mon remove
sudo update-rc.d -f tomcat7 remove
sudo update-rc.d -f elasticsearch remove
sudo update-rc.d -f logstash remove
sudo update-rc.d -f logstash-web remove
sudo update-rc.d -f docker remove
sudo update-rc.d -f apache2 remove
sudo update-rc.d -f ChrononController remove
sudo update-rc.d -f postgresql remove
sudo update-rc.d -f mysql remove
sudo update-rc.d -f nginx remove
sudo update-rc.d -f varnish remove
sudo update-rc.d -f gearman-job-server remove
sudo update-rc.d -f ansible-tower remove


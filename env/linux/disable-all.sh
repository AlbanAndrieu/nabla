#!/bin/sh

sudo update-rc.d -f webmin remove
sudo update-rc.d -f jetty remove
sudo update-rc.d -f jenkins remove
sudo update-rc.d -f sonar remove
sudo update-rc.d -f rabbitmq-server remove
sudo update-rc.d -f jboss remove
sudo update-rc.d -f zabbix-agent remove
sudo update-rc.d -f supervisor remove
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
sudo update-rc.d -f supervisord remove
sudo update-rc.d -f nginx remove

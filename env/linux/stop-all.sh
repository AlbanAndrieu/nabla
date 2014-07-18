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

sudo service --status-all


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

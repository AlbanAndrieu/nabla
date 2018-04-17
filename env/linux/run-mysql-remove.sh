#!/bin/bash
set -xv

sudo service mysql stop  #or mysqld
sudo killall -9 mysql
sudo killall -9 mysqld
sudo apt-get remove --purge mysql-server mysql-client mysql-common
#sudo apt-get remove --purge mysql\*
sudo apt-get autoremove
sudo apt-get autoclean
sudo deluser mysql
sudo rm -rf /var/lib/mysql/*
sudo apt-get purge mysql-server-core-5.5
sudo apt-get purge mysql-client-core-5.5
sudo apt-get purge mysql-server-core-5.7
sudo apt-get purge mysql-client-5.7
sudo rm -rf /var/log/mysql/*
sudo rm -rf /etc/mysql/*

#sudo mkdir /etc/mysql/conf.d/

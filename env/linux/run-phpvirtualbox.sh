#!/bin/bash
set -xv

#https://www.liberiangeek.net/2014/09/install-virtualbox-headless-ubuntu-14-04-server-manage-phpvirtualbox/

sudo apt-get install apache2 php5 php5-common php-soap php5-gd

cd /tmp/ &&  wget http://sourceforge.net/projects/phpvirtualbox/files/phpvirtualbox-4.3-1.zip

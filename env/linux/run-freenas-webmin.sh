#!/bin/bash
#set -xv

#install webmin
#See https://doxfer.webmin.com/Webmin/Installation

pkg update
cd /usr/ports && make search name=webmin

#pkg install webmin
cd /usr/ports/sysutils/webmin && make install clean

#-----------------
#[jenkins] Installing webmin-1.941...
#After installing Webmin for the first time you should perform the following
#steps as root:
#
#* Configure Webmin by running 
/usr/local/lib/webmin/setup.sh

#* Add webmin_enable="YES" to your /etc/rc.conf
echo "webmin_enable="YES"" >> /etc/rc.conf

#* Start Webmin for the first time by running 
service webmin start
#/usr/local/etc/rc.d/webmin start

#The parameters requested by setup.sh may then be changed from within Webmin
#itself.
#-----------------

tail -f /var/log/webmin/miniserv.error
 
echo "https://192.168.1.24:10000"

exit 0

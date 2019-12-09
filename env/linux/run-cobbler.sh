#!/bin/bash
set -xv

# See http://cobbler.github.io/quickstart/

apt-get install make
apt-get install git
apt-get install python-yaml
apt-get install python-cheetah
apt-get install python-netaddr
apt-get install python-simplejson
apt-get install libapache2-mod-wsgi
apt-get install python-django
apt-get install atftpd

#a2enmod proxy
#a2enmod proxy_http
#a2enmod rewrite

ln -s /srv/tftp /var/lib/tftpboot

chown www-data /var/lib/cobbler/webui_sessions

apt-get install cobbler cobbler-web

# See https://cobbler.readthedocs.io/en/release28/web-interface.html

#htdigest /etc/cobbler/users.digest "Cobbler" cobbler

systemctl start cobblerd.service

a2dismod python

cp /etc/cobbler/cobbler.conf /etc/apache2/conf.d/cobbler.conf

service apache2 restart

# See http://150.151.160.25/cobbler/
# http://150.151.160.25/cobbler_webui_content/

exit 0

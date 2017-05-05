#!/bin/bash
set -xv

#deactivate pagespeed

sudo nano /etc/apache2/mods-available/pagespeed.conf
#ModPagespeed on
ModPagespeed unplugged

sudo service apache2 restart

#http://localhost:7070/wordpress/?ModPagespeed=off

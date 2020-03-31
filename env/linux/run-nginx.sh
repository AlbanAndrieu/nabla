#!/bin/bash
set -xv

cd /etc/nginx/sites-enabled

sudo nano /etc/nginx/sites-enabled/default
#8480

# freenas
# workaround to install groovy-events-listener-plugin by hand
nano /usr/local/etc/nginx/nginx.conf
#client_max_body_size 10M;

exit 0

#!/bin/bash
set -xv


# freenas
# workaround to install groovy-events-listener-plugin by hand
nano /usr/local/etc/nginx/nginx.conf
#client_max_body_size 10M;
#client_body_buffer_size    128k;

cd /etc/nginx/sites-enabled
sudo nano /etc/nginx/sites-enabled/default
#8480

#nano /etc/nginx/nginx.conf
proxy_connect_timeout  600;
proxy_send_timeout    600;
proxy_read_timeout    600;
send_timeout      600;

fastcgi_read_timeout 300;

service nginx reload

exit 0

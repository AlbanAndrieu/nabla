#!/bin/bash
#set -xv

# See https://www.jenkins.io/doc/book/system-administration/reverse-proxy-configuration-nginx/
cd /usr/local/etc/nginx
edit nginx.conf

#upstream jenkins {
#  keepalive 32; # keepalive connections
#  server 127.0.0.1:8180; # jenkins ip and port
#}

# Required for Jenkins websocket agents
map $http_upgrade $connection_upgrade {
        default upgrade;
        '' close;
}

location ~ "^/static/[0-9a-fA-F]{8}\/(.*)$" {
   #rewrite all static files into requests to the root
   #E.g /static/12345678/css/something.css will become /css/something.css
   rewrite "^/static/[0-9a-fA-F]{8}\/(.*)" /$1 last;
}

service nginx restart
tail -f /var/log/nginx/error.log

exit 0

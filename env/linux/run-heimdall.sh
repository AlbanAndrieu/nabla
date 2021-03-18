#!/bin/bash
set -xv

mkdir /data/heimdall

#sudo docker run --name=heimdall -d -v /data/heimdall:/config -e PGID=2000 -e PUID=1000 -p 8080:80 -p 8443:443 linuxserver/heimdall

# Using freenas
# https://github.com/jsegaert/iocage-plugin-heimdall
# See http://192.168.1.21

exit 0

#!/bin/bash
set -xv

curl -L -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-7.3.0-amd64.deb
sudo dpkg -i filebeat-7.3.0-amd64.deb

exit 0

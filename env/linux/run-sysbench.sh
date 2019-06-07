#!/bin/bash
set -xv

# See https://github.com/akopytov/sysbench

curl -s https://packagecloud.io/install/repositories/akopytov/sysbench/script.deb.sh | sudo bash
sudo apt -y install sysbench

exit 0

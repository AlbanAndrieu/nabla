#!/bin/bash
#set -xv

# See https://github.com/deislabs/oras

curl -LO https://github.com/deislabs/oras/releases/download/v0.8.1/oras_0.8.1_linux_amd64.tar.gz
mkdir -p oras-install/
tar -zxf oras_0.8.1_*.tar.gz -C oras-install/
sudo mv oras-install/oras /usr/local/bin/
rm -rf oras_0.8.1_*.tar.gz oras-install/

exit 0

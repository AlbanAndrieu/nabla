#!/bin/bash
set -xv

sudo snap install go --classic

go version

# See https://github.com/golang/dep#installation
sudo apt-get install go-dep

exit 0

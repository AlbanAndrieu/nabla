#!/bin/bash
set -xv

sudo apt-get remve stacer
sudo apt install gdebi-core
wget -O ~/stacer.deb https://github.com/oguzhaninan/Stacer/releases/download/v1.1.0/stacer_1.1.0_amd64.deb
sudo gdebi ~/stacer.deb

exit 0

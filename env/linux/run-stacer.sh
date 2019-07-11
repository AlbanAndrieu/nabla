#!/bin/bash
set -xv

# Below NOK on Ubuntu 18.04
#sudo apt-get remve stacer
#sudo apt install gdebi-core
#wget -O ~/stacer.deb https://github.com/oguzhaninan/Stacer/releases/download/v1.1.0/stacer_1.1.0_amd64.deb
#sudo gdebi ~/stacer.deb

sudo add-apt-repository ppa:oguzhaninan/stacer -y
sudo apt-get update
sudo apt-get install stacer -y

exit 0

#!/bin/bash
set -xv

#http://maxolasersquad.blogspot.no/2013/10/install-keepasshttp-on-ubuntu.html

sudo apt-add-repository ppa:jtaylor/keepass
sudo apt-get update
sudo apt-get install keepass2

cd /usr/lib/keepass2/
sudo mkdir plugins
cd plugins

sudo apt-get install git-core

sudo git clone -n https://github.com/pfn/keepasshttp.git --depth 1
cd keepasshttp
sudo git checkout HEAD KeePassHttp.plgx

#!/bin/bash
set -xv

# See https://ubuntu.com/appliance/adguard/vm

sudo snap install multipass
multipass launch appliance:adguard-home --name adguard-home
multipass list

#See http://10.136.74.226:3000/

multipass shell adguard-home

#sudo snap install adguard-home

exit 0

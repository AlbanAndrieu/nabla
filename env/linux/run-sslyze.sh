#!/bin/bash
set -xv

#https://github.com/iSECPartners/sslyze
sudo su - root
pip install nassl
sudo pip install certifi
sudo pip install pyopenssl ndg-httpsclient pyasn1
git clone https://github.com/iSECPartners/sslyze.git

./sslyze.py --regular example.com:443
#DOES NOT WORK

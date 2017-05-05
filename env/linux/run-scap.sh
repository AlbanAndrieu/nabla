#!/bin/bash
set -xv

#Check jenkins job docker-scap-admin
#git clone https://github.com/GovReady/ubuntu-scap.git || true
#cd ubuntu-scap || true
#rm -f ubuntu-xccdf.xml || true
#wget http://kgrweb/download/ubuntu-xccdf.xml || true
#./run_tests.sh || true

#Ensure /tmp Located On Separate Partition
#CCE-26435-8
#https://www.maketecheasier.com/move-home-folder-ubuntu/
#https://help.ubuntu.com/community/Partitioning/Home/Moving

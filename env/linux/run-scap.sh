#!/bin/bash
set -xv

sudo apt-get install libopenscap8

#Check jenkins job docker-scap-admin
git clone https://github.com/GovReady/ubuntu-scap.git || true
cd ubuntu-scap || true
#cp ubuntu-* /media/ftp/download/scap/
#rm -f ubuntu-xccdf.xml || true
#wget http://albandrieu.com/download/ubuntu-xccdf.xml || true
./run_tests.sh || true

#Ensure /tmp Located On Separate Partition
#CCE-26435-8
#https://www.maketecheasier.com/move-home-folder-ubuntu/
#https://help.ubuntu.com/community/Partitioning/Home/Moving

# See http://www.open-scap.org/tools/scap-workbench/

# NOK sudo apt-get install scap-workbench

git clone --recurse-submodules https://github.com/OpenSCAP/openscap.git
cd openscap

sudo apt-get install cmake libdbus-1-dev libdbus-glib-1-dev libcurl4-openssl-dev \
libgcrypt20-dev libselinux1-dev libxslt1-dev libgconf2-dev libacl1-dev libblkid-dev \
libcap-dev libxml2-dev libldap2-dev libpcre3-dev swig libxml-parser-perl \
libxml-xpath-perl libperl-dev libbz2-dev librpm-dev g++ libapt-pkg-dev libyaml-dev
#python-dev

cd build/
cmake ../
make

sudo make install

which oscap
#bash ./run utils/oscap xccdf eval /workspace/users/albandrieu30/ubuntu-scap/ubuntu-xccdf.xml

cd /workspace/users/albandrieu30/ubuntu-scap/

oscap xccdf eval \
	--profile xccdf_ubuntu_profile_default \
	--cpe ubuntu-cpe.xml \
	--check-engine-results --oval-results --results results.xml \
	--report results.html \
	ubuntu-xccdf.xml

exit 0

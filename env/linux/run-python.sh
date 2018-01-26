#!/bin/bash
set -xv

#disable rhnplugin
# grep enable /etc/yum/pluginconf.d/rhnplugin.conf
#enabled = 0
##enabled = 1

#or disable by hand
yum search python26 --disableplugin=rhnplugin
#yum search python27 --disableplugin=rhnplugin
#Not available on RH 5
wget https://www.python.org/ftp/python/2.7.3/Python-2.7.3.tgz --no-check-certificate # Download
tar xvfz Python-2.7.3.tgz # unzip
cd Python-2.7.3 # go into directory
./configure
make # build
#su # or 'sudo su' if there is no root user
make altinstall
#make install #do not do it

ln -s /usr/local/bin/python2.7 /usr/bin/python2.7

ls -lrta /usr/local/bin/python2.7

rm /root/Python-2.7.3

#might need todo yum remove mercurial

#TODO RedHat https://www.tecmint.com/install-python-in-linux/ install python 3.6 for ansible
#yum -y groupinstall development
#yum -y install zlib-devel

# wget https://www.python.org/ftp/python/3.6.3/Python-3.6.3.tar.xz
# tar xJf Python-3.6.3.tar.xz
# cd Python-3.6.3
# ./configure
# make
# make install

# which python3
# python3 -V

#virtualenv py3-ansible -p /usr/local/bin/python3.6

#alternatives --list | grep -i python

#alternatives --install /usr/bin/python python /usr/local/bin/python3.6 2
#alternatives --install /usr/bin/python python /usr/bin/python2.7 1

#pip3 install docker-py
#pip3 install -U docker-compose
#pip3 install ansible

#python3 /usr/bin/ansible localhost -m ping

#update-alternatives --config python

#Show outdated pip package
pip list --outdated --format=freeze
#Upgrade all
pip freeze --local | grep -v '^\-e' | cut -d = -f 1  | xargs -n1 sudo pip install -U

#Issue pycurl: libcurl link-time ssl backend (nss) is different from compile-time ssl backend (none/other)
pip install --no-cache-dir --compile --ignore-installed --install-option="--with-nss" pycurl

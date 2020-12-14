#!/bin/bash
set -xv

#RedHat
#alternatives --install /usr/bin/python python /usr/local/bin/python3.6 2
#alternatives --install /usr/bin/python python /usr/bin/python2.7 1
#alternatives --list | grep -i python

#Ubuntu
#ls -la /etc/alternatives/python*

update-alternatives --list python
sudo update-alternatives --remove-all python
sudo update-alternatives --install /usr/bin/python python /usr/bin/python2.7 1
sudo update-alternatives --install /usr/bin/python python /usr/bin/python3.6 6
sudo update-alternatives --install /usr/bin/python python /usr/bin/python3.7 7
sudo update-alternatives --install /usr/bin/python python /usr/bin/python3.8 8
update-alternatives --config python

update-alternatives --list gcc
sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-8 80 --slave /usr/bin/g++ g++ /usr/bin/g++-8 --slave /usr/bin/gcov gcov /usr/bin/gcov-8
sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-9 90 --slave /usr/bin/g++ g++ /usr/bin/g++-9 --slave /usr/bin/gcov gcov /usr/bin/gcov-8

exit 0

#!/bin/bash
#set -xv

pkg install sudo wget

#pkg install ansible
pkg install py37-ansible-2.8.7
ls -lrta /usr/local/share/examples/py37-ansible/ansible.cfg

pkg install python
pkg install py27-pip
pip install pygal

pkg install py37-ansible-2.8.7

# See https://www.freshports.org/devel/maven-wrapper/
#pkg_add -v -r maven3
#cd /usr/ports/devel/maven3/ && make install clean
#pkg install maven3
#cd /usr/ports/devel/maven33/ && make install clean
#pkg install maven33
pkg install maven-3.6.3 maven-wrapper-1_2 maven33-3.3.9_1

mvn --version

cd /var/lib/
ln -s /usr/local/jenkins jenkins
ls -lrta /var/lib/jenkins/.m2/repository

cd /usr/ports/security/openssh-askpass/ && make install clean
#pkg install OpenSSH-askpass
ls /usr/local/bin/ssh-askpass

#for Xvfb
pkg install xorg-vfbserver
#/usr/local/bin/Xvfb

#See https://www.freebsd.org/doc/handbook/desktop-browsers.html
pkg install firefox
#pkg install firefox-esr
pkg install chromium

npm install -g bower
npm install -g nsp
#npm install -g phantomjs-prebuilt
#npm i phantom@4.0.5 -g
npm search phantomjs

#pkg install phantomjs
#cd /usr/ports/lang/phantomjs/ && make install clean

pkg info phantomjs
ls -lrta /usr/local/bin/phantomjs
#ls -lrta /usr/local/lib/node_modules/

#pkg install libass
#pkg install ffmpeg

#export JAVA_HOME=/usr/local/openjdk8/

./run-freenas-package.sh

exit 0

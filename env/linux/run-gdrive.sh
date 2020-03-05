#!/bin/bash
set -xv

#For connecting google to ldap see run-ldap
#http://support.google.com/a/bin/answer.py?hl=fr&answer=106368

#TODO add password syncronisation in Google Apps Directory Sync

#Install Google Drive
#http://tilap.net/google-drive-sur-ubuntu-facilement/

cd /workspace
sudo apt-get install fuse
sudo apt-get -f install
sudo wget https://launchpad.net/~invernizzi/+archive/google-docs-fs/+files/google-docs-fs_1.0~gdrive_all.deb
sudo dpkg -i google-docs-fs_1.0~gdrive_all.deb
sudo apt-get install -f
sudo mkdir drive
gmount drive alban.andrieu@nabla.mobi

#in order to change mounting point
# delete mounting
gumount MON_REPERTOIRE_INITIAL
# delete directory
rm -Rf MON_REPERTOIRE_INITIAL
# mount again
gmount REPERTOIRE_CIBLE user@gmail.com

#Insync not OK
#http://www.howopensource.com/2012/11/install-insync-google-drive-client-in-ubuntu-12-10-12-04-ppa/
#wget -O - https://d2t3ff60b2tol4.cloudfront.net/services@insynchq.com.gpg.key | sudo apt-key add -
#sudo sh -c 'echo "deb http://apt.insynchq.com/ubuntu $(lsb_release -sc) non-free" >> /etc/apt/sources.list.d/insync.list'

#https://www.thefanclub.co.za/overgrive

exit 0

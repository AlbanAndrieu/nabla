#!/bin/bash
set -xv

echo "Install bleachbit"
sudo apt-get install bleachbit

echo "Start cleaning"
#http://doc.ubuntu-fr.org/nettoyer_ubuntu
\rm -Rf /usr/local/sonar/.local
\rm -Rf /usr/local/sonar/Downloads/*
\rm -Rf /usr/share/tomcat6/.m2/repository/
\rm -Rf ~/.m2/repository/
\rm -Rf ~/.repository
#\rm -Rf ~/.cache/upstart
\rm -Rf ~/.cache/*
#\rm -Rf ~/.aspera
#\rm -Rf ~/.eclipse/*
\rm -Rf ~/.cpan/*
\rm -Rf ~/.svn/*
\rm -Rf ~/.thunderbird/*
#\rm -Rf ~/.mozilla/*
\rm -Rf ~/.fonts
\rm -Rf ~/.gem
\rm -Rf ~/.node_cache
\rm -Rf ~/.node_tmp
\rm -Rf ~/.node-gyp
\rm -Rf ~/.npm
\rm -Rf ~/.ievms
\rm -Rf ~/tmp
\rm -f ~/*.db
#\rm -Rf  ~/.vagrant.d/boxes
#empty trash
\rm -rf ~/.local/share/Trash/*
\rm -rf ~/.local/share/wineprefixes/*
\rm -rf ~/.local/share/gvfs-metadata/*
#\rm -Rf ~/.config/*
#google chrome
#\rm -rf ~/.config/google-chrome/Default/Web\ Data
\rm -Rf ~/.config/google-chrome/History*
\rm -Rf ~/.config/variety/Downloaded/*/
#nabla
\rm -Rf ~/env/config/setEnvFiles.list.txt
#https://askubuntu.com/questions/177312/filesystem-filling-up-due-to-large-uvcydnctrl-udev-log-file
sudo \rm -Rf /var/log/uvcdynctrl-udev.log
sudo \rm -Rf /var/log/elasticsearch/elasticsearch.log*
\rm -Rf /var/lib/mongodb/journal/*
\rm -Rf /var/lib/mongodb/local.*
\rm -Rf /var/lib/mongodb/nabla-*
\rm -Rf /var/lib/redis/*.rdb
\rm -Rf /var/lib/collectd/rrd/*
\rm -Rf /workspace/jboss-as-7.1.1.Final/standalone/data/content*

./cleanup-jenkins.sh

find ~/.thumbnails -type f -atime +7 -exec rm {} \;

#find /var/log -type f -name '*.log' -exec chmod 664 {} \;

#\rm -Rf workspace-cpp
#\rm -Rf workspace-j2ee

#find . -type f -name '*~' | xargs rm -r $1
find . -type f -name '*\.log' | xargs rm -r $1
find . -type d -name '.svn' | xargs rm -r $1

#\rm -Rf /var/lib/elasticsearch/elasticsearch/nodes/
#https://community.spiceworks.com/topic/783490-webm-files-in-virtualbox-are-they-safe-to-delete
\rm -Rf ~/VirtualBox VMs/**/*.webm

echo "End cleaning"

#https://doc.ubuntu-fr.org/ecryptfs
#cd ~/Private
#ecryptfs-umount-private
#chmod 700 ~/Private
#NEVER rm -rf ~/Private ~/.Private ~/.ecryptfs
#NEVER rm -rf /home/.ecryptfs
#sudo apt-get remove ecryptfs-utils libecryptfs0

#find ~/ -name '*~' -print0
find ~/ -name '*~' -type f
find ~/ -name '*~' -type f -print0 | xargs -0 rm

#http://www.insanitybit.com/2012/07/17/removing-zeitgeist-sped-up-unity-2/
sudo apt-get purge zeitgeist zeitgeist-datahub rhythmbox-plugin-zeitgeist

sudo apt-get autoclean
sudo apt-get autoremove
#sudo dpkg -P `dpkg -l | grep "^rc" | tr -s ' ' | cut -d ' ' -f 2`
sudo apt-get --purge remove tex.\*-doc$

#Removed useless local file
#sudo apt-get install localepurge
#sudo localepurge
#in case of problem
#sudo apt-get install --reinstall locales

#current kernel
uname -r
#remove old kernel
dpkg -l | awk '{print $2}' | grep -E "linux-(image|headers)-$(uname -r | cut -d- -f1).*" | grep -v $(uname -r | sed -r -e 's:-[a-z]+.*::')
#sudo apt-get purge $(dpkg -l | awk '{print $2}' | grep -E "linux-(image|headers)-$(uname -r | cut -d- -f1).*" | grep -v $(uname -r | sed -r -e 's:-[a-z]+.*::'))

#delete mail
#http://apple.stackexchange.com/questions/28745/how-do-i-delete-all-terminal-mail
#: > /var/mail/$USER
#Fix issue sendmail-largeboxes
#http://unix.stackexchange.com/questions/134136/how-to-access-and-manage-a-large-mailbox-11-gb
#sudo rm /var/spool/mail/BOGUS.jenkins.N4Af
#sudo rm /var/spool/mail/BOGUS.www-data.GOLf
#sudo rm /var/spool/mail/mon
#sudo rm /var/spool/mail/www-data
#sudo rm /var/spool/mail/nobody
#sudo rm /var/spool/mail/nagios
#sudo rm /var/spool/mail/mail
#ll /var/spool/mail/

#RedHat
#yum clean all || true
#rm -rf /var/cache/yum

#List pgk used by services
find /etc/init /etc/init.d /etc/systemd /lib/systemd /etc/cron.* -type f -exec dpkg-query -S {} \; | sed 's/:.*$//' | sort -u

#Bluetooth remove
#apt-get remove blueman bluez-alsa bluez-cups

#Wifii remove
#apt-get remove bluez-cups

#Modem remove
#apt-get remove modem-manager

#ppp remove
#apt-get remove ppp pptp-linux network-manager-pptp network-manager-pptp-gnome

#scanner remove
#apt-get remove sane-utils

#printer remove
#apt-get remove cups cups-bsd cups-filters cups-ppdc

#braille remove
#apt-get remove brltty brltty-x11

#vocale remove
#apt-get remove speech-dispatcher

exit 0

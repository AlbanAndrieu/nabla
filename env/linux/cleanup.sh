#!/bin/bash
set -xv

echo "Install bleachbit"
sudo apt-get install bleachbit
#See https://www.bleachbit.org/download/file/t?file=bleachbit_3.0_all_ubuntu1904.deb

echo "Start cleaning"

# As jenkins user

#Inside your home directory
du -sh .[!.]* *

#http://doc.ubuntu-fr.org/nettoyer_ubuntu
\rm -Rf /usr/local/sonar/.local
\rm -Rf /usr/local/sonar/Downloads/*
\rm -Rf /usr/share/tomcat6/.m2/repository/
\rm -Rf ~/.m2/repository/
\rm -Rf ~/.repository
#\rm -Rf ~/.cache/upstart
#\rm -Rf ~/.cache/pip
#\rm -Rf ~/.cache/thumbnails/*
\rm -Rf ~/.cache/*
#\rm -Rf ~/.linuxbrew/*
\rm -Rf ~/.jenkins/cache/*
#\rm -Rf ~/.conan/*
#\rm -Rf ~/.codemix/*
#\rm -Rf ~/.cpan/*
#\rm -Rf ~/.cppan/*
#\rm -Rf ~/.aspera
#\rm -Rf ~/.eclipse/*
#\rm -Rf ~/.ansible
#\rm -Rf ~/ansible
\rm -Rf ~/.ansible/roles/
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
\rm -f *:compile #maven crap
#\rm -Rf  ~/.vagrant.d/boxes
#empty trash
\rm -Rf ~/.local/share/Trash/*
\rm -Rf ~/.local/share/wineprefixes/*
\rm -Rf ~/.local/share/gvfs-metadata/*
#\rm -Rf ~/.config/*
#google chrome
#\rm -Rf ~/.config/google-chrome/Default/Web\ Data
\rm -Rf ~/.config/google-chrome/History*
\rm -Rf ~/.config/variety/Downloaded/*/
#nabla
\rm -Rf ~/env/config/setEnvFiles.list.txt
#https://askubuntu.com/questions/177312/filesystem-filling-up-due-to-large-uvcydnctrl-udev-log-file
\rm -Rf /var/log/uvcdynctrl-udev.log
\rm -Rf /var/log/elasticsearch/elasticsearch.log*
#\rm -Rf /var/log/bandwidth
#\rm -Rf /var/log/*.1
#\rm -Rf /var/log/*.1.gz
#\rm -Rf /var/log/*.2.gz
#\rm -Rf /var/log/*.3.gz
#\rm -Rf /var/log/*.4.gz
#\rm -Rf /var/log/*.5.gz
#\rm -Rf /var/log/*.6.gz
#\rm -Rf /var/log/*.7.gz
\rm -Rf /var/lib/mongodb/journal/*
\rm -Rf /var/lib/mongodb/local.*boot
\rm -Rf /var/lib/mongodb/nabla-*
\rm -Rf /var/lib/redis/*.rdb
\rm -Rf /var/lib/collectd/rrd/*
#\rm -Rf /var/lib/docker/overlay2/*
\rm -Rf /workspace/jboss-as-7.1.1.Final/standalone/data/content*
\rm -Rf /usr/share/doc/
\rm -Rf /var/cache/apt/archives/

#systemctl stop mysql
#ls /var/log/mysql/mysql.err
##mv /var/log/mysql/mysql.err /backup/mysql/log/mysql-TODELETE.err
#systemctl start mysql
#systemctl stop proftpd
#rm /var/log/proftpd/tls.log
lsof +D /var/spool/mqueue-client/ || true
#systemctl stop sendmail
#rm -Rf /var/spool/mqueue-client/
#systemctl start sendmail

#rm -f /var/log/bandwidth
#rm -f /var/log/kern.log
#rm -f /var/log/syslog*

# Display log before deleting
lastlog
#RUN rm -f /var/lib/dpkg/available-old /var/lib/dpkg/status-old /var/cache/debconf/config.dat-old /var/cache/debconf/config.dat /var/cache/debconf/templates.dat-old /var/cache/debconf/templates.dat /var/log/lastlog /var/log/faillog

brew cleanup || true

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
#NEVER rm -Rf ~/Private ~/.Private ~/.ecryptfs
#NEVER rm -Rf /home/.ecryptfs
#sudo apt-get remove ecryptfs-utils libecryptfs0

#find ~/ -name '*~' -print0
find ~/ -name '*~' -type f
find ~/ -name '*~' -type f -print0  -exec rm -rv {} \;

#http://www.insanitybit.com/2012/07/17/removing-zeitgeist-sped-up-unity-2/
sudo apt-get purge zeitgeist zeitgeist-datahub rhythmbox-plugin-zeitgeist

#sudo apt-get autoclean
sudo apt-get clean
sudo apt-get autoremove --purge
#sudo dpkg -P `dpkg -l | grep "^rc" | tr -s ' ' | cut -d ' ' -f 2`
sudo apt-get --purge remove tex.\*-doc$

#ls -lrta /etc/yum.repos.d/*
#yum clean all && yum clean metadata && yum clean dbcache && yum makecache && yum update
#rm -rf /var/cache/yum

#Removed useless local file
#sudo apt-get install localepurge
#sudo localepurge
#in case of problem
#sudo apt-get install --reinstall locales

#remove
#sudo rm /etc/apt/sources.list.d/get_docker_io_ubuntu.list
sudo rm -f /etc/apt/sources.list.d/pdffs-precise-virt-trusty.list
sudo rm -f /etc/apt/sources.list.d/ntop.list
sudo rm -f /etc/apt/sources.list.d/dl_google_com_linux_chrome_deb.list*
sudo rm -f /etc/apt/sources.list.d/google-chrome.list
sudo rm -f /etc/apt/sources.list.d/repo_zabbix_com_zabbix_2_2_ubuntu.list
sudo rm -f /etc/apt/sources.list.d/nvidia-docker.list*
sudo rm -f /etc/apt/sources.list.d/google-talkplugin.list*
sudo rm -f /etc/apt/sources.list.d/yarn.list
sudo rm -f /etc/apt/sources.list.d/github_git-lfs.list
sudo rm -f /etc/apt/sources.list.d/download_webmin_com_download_repository.list
sudo rm -f /etc/apt/sources.list.d/nodesource.list
sudo rm -f /etc/apt/sources.list.d/ppa_webupd8team_nemo_bionic.list
sudo rm -f /etc/apt/sources.list.d/ppa_awstools_dev_awstools_bionic.list
sudo rm -f /etc/apt/sources.list.d/artful.list*
sudo rm -f /etc/apt/sources.list.d/ppa_webupd8team_java_bionic.list*
sudo rm -f /etc/apt/sources.list.d/download_docker_com_linux_ubuntu.list*
sudo rm -f /etc/apt/sources.list.d/ppa_webupd8team_atom_disco.list*
sudo rm -f /etc/apt/sources.list.d/ppa_linuxuprising_shutter.list*
sudo rm -f /etc/apt/sources.list.d/ppa_brightbox_ruby_ng_disco.list*
sudo rm -f /etc/apt/sources.list.d/ppa_deadsnakes_ppa_disco.list*
sudo rm -f /etc/apt/sources.list.d/oguzhaninan-ubuntu-stacer-eoan.list*
sudo rm -f /etc/apt/sources.list.d/owasp-wte.list*
sudo rm -f /etc/apt/sources.list.d/zfs-native-ubuntu-stable-focal.list*
sudo rm -f /etc/apt/sources.list.d/skype-stable.list*
sudo rm -f /etc/apt/sources.list.d/bellsoft.list
sudo rm -f /etc/apt/sources.list.d/fkrull-ubuntu-deadsnakes-bionic.list

sudo add-apt-repository \
"deb [arch=amd64] https://download.docker.com/linux/ubuntu \
$(lsb_release -cs) \
stable"
sudo rm -rf /var/lib/apt/lists/*
#/var/lib/apt/lists/software.virtualmin.com_vm_6_gpl_apt_dists_virtualmin-*
sudo apt-get update

#current kernel
uname -r
dpkg -l *linux-image* | grep ii
#remove old kernel
dpkg -l | awk '{print $2}' | grep -E "linux-(image|headers)-$(uname -r | cut -d- -f1).*" | grep -v $(uname -r | sed -r -e 's:-[a-z]+.*::')
#sudo apt-get purge $(dpkg -l | awk '{print $2}' | grep -E "linux-(image|headers)-$(uname -r | cut -d- -f1).*" | grep -v $(uname -r | sed -r -e 's:-[a-z]+.*::'))
sudo apt search linux-image

# remove old kernel when boot is full
# https://gist.github.com/ipbastola/2760cfc28be62a5ee10036851c654600
ls -lrta /boot
#rm -rf /boot/*-4.4.0-{59,81,93,104,108,109,112,130,131,133,134,137,138,139}-*
#rm -rf /boot/*-4.4.0-{148,150,151}-*
#rm -rf /boot/*-4.15.0-51-*
# See https://www.tecmint.com/upgrade-kernel-in-ubuntu/
sudo apt-get -f install
sudo apt-get autoremove
sudo update-grub

#delete mail
#http://apple.stackexchange.com/questions/28745/how-do-i-delete-all-terminal-mail
: > /var/mail/$USER
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
#rm -Rf /var/cache/yum

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

docker system df

docker stop $(docker ps -a -q) # stop all docker containers
docker rm -f $(docker ps -a -q) # remove all docker containers
docker images -q | xargs docker rmi -f # remove all docker images

#See https://itsfoss.com/free-up-space-ubuntu-linux/

sudo apt-get install gtkorphan
#sudo gtkorphan

sudo apt install fdupes
#fdupes -d ~/

#CentOS
#yum clean all
#rm -rf /var/cache/yum

exit 0

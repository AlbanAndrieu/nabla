#!/bin/bash
#set -xv

#webmin

sudo mkdir -p /workspace/users/albandri30
sudo mkdir -p /workspace/users/albandri10
sudo chown albandri:albandri -R /workspace

sudo apt-get autoremove
sudo apt-get install nis ntp autofs

#other package
sudo apt-get install perl libnet-ssleay-perl openssl libauthen-pam-perl libpam-runtime libio-pty-perl apt-show-versions python
sudo apt-get -f install

wget http://prdownloads.sourceforge.net/webadmin/webmin_1.630_all.deb
sudo dpkg --install webmin_1.630_all.deb

sudo apt-get install subversion cvs git maven
sudo apt-get install tomcat7 apache2
sudo apt-get install vim dos2unix xxdiff
sudo apt-get install wget curl nmap ssh
sudo apt-get install smartmontools mon
sudo apt-get install cmake scons
sudo apt-get install doxygen graphviz

sudo apt-get install maven
#sudo dpkg -i --force-all /var/cache/apt/archives/libwagon2-java_2.2-3+nmu1_all.deb
#sudo apt-get -f install
#cd /usr/share
#sudo ln -s maven maven3

#sudo apt-cache search 5
#sudo apt-get install libdb5.1-dev

sudo apt-get install ssmtp mailutils
sudo apt-get install geany gedit

#for jenkins
#sudo apt-get install daemon

#cpan
sudo cpan install CPAN
#Install following perl package
sudo cpan install BDB
sudo cpan install XML::DOM
sudo cpan install XML::Handler::YAWriter
sudo cpan install XML::Simple
sudo cpan install Test::Harness
sudo cpan install Test::Pod::Coverage
sudo cpan install Test::Pod
sudo cpan install JSON
sudo cpan install IO::Prompt
sudo cpan install Text::SimpleTable
sudo cpan install HTTP::Date
sudo cpan install Date::Calc
sudo cpan install Date::Format
sudo cpan install Date::Manip
sudo cpan install LWP::Protocol::https
sudo cpan install Crypt::SSLeay
sudo cpan install File::Copy::Recursive
sudo cpan install File::Find::Rule
sudo cpan install Tree::Simple
sudo cpan install Tree::Simple::View::ASCII

#http://askubuntu.com/questions/205342/how-do-i-downgrade-to-subversion-1-6
#sudo apt-get remove libsvn1 subversion
#sudo apt-get remove subversion

sudo geany /etc/apt/sources.list
ls /etc/apt/sources.list.d/
#Append the following line
#NOK deb http://us.archive.ubuntu.com/ubuntu precise main
deb http://extras.ubuntu.com/ubuntu precise main
#deb http://us.archive.ubuntu.com/ubuntu/ precise main universe
deb http://us.archive.ubuntu.com/ubuntu/ precise main universe restricted multiverse

sudo apt-get autoclean
sudo apt-get update
sudo apt-get install subversion

sudo chmod +x ~/.subversion/svn-merge-meld.py

#check out
cd /workspace/users/albandri10
svn co https://alban.googlecode.com/svn/trunk/env env

sudo add-apt-repository ppa:rquillo/ansible
sudo apt-get install ansible

#install python
sudo apt-get install python-pip python-dev build-essential
sudo pip install --upgrade pip

sudo nano /etc/ssh/sshd_config
#Append
ForwardX11Trusted yes

less /var/log/boot.log

more /etc/rc.local

ls /etc/rc?.d

rc0.d contains the services which runs in runlevel 0
rc1.d contains the services which runs in runlevel 1
rc2.d contains the services which runs in runlevel 2
rc3.d contains the services which runs in runlevel 3
rc4.d contains the services which runs in runlevel 4
rc5.d contains the services which runs in runlevel 5
rc6.d contains the services which runs in runlevel 6

#First one is S script (S30killprocs)---> start
#Second one is k script (K15pulseaudio)---> kill

#sudo update-rc.d varnish start XX 2 3 4 5 . stop XX 0 1 6 .
#sudo update-rc.d varnish start 30 5 . stop 30 0 1 6 .
#Dans ce cas l�, monscript sera uniquement lanc� dans le runlevel 5 et avec une priorit� de 30. Il sera stopp� dans les runlevels 0,1,6 avec une priorit� de 30 �galement.
#Les runlevels 2,3,4,5 pour le lancer et 0,1,6 pour le stopper. La priorit� par d�faut est de 20.
#Si vous n�tes pas bien certain de ce que vous fa�tes, vous pouvez toujours lancer une simulation afin d��viter la bourde� Pour cela, il est possible d�utiliser l�argument -n � votre commande qui affichera ce qu�aurait fait update-rc.d

#test
sudo update-rc.d -n varnish start 85 2 3 4 5 . stop 20 0 1 6 .
sudo update-rc.d -n private-bower start 85 2 3 4 5 . stop 20 0 1 6 .
sudo update-rc.d -n apache2 start 80 2 3 4 5 . stop 25 0 1 6 .

sudo update-rc.d -f varnish remove
sudo update-rc.d varnish start 85 2 3 4 5 . stop 20 0 1 6 .
sudo update-rc.d -f varnishlog remove
sudo update-rc.d -n varnishlog start 85 2 3 4 5 . stop 20 0 1 6 .
sudo update-rc.d -f varnishncsa remove
sudo update-rc.d -n varnishncsa start 85 2 3 4 5 . stop 20 0 1 6 .
sudo update-rc.d -f apache2 remove
sudo update-rc.d apache2 start 80 2 3 4 5 . stop 25 0 1 6 .

#sudo update-rc.d -f jenkins remove
#sudo update-rc.d jenkins start 90 2 3 4 5 . stop 15 0 1 6 .

#add albandri as sudoers
albandri ALL=(ALL) ALL
%rms    ALL = NOPASSWD: /usr/local/bin/kzone-connector

#add ability to display with sudo
xhost +

#sudo mount /dev/sda1 /media/albandri

ifconfig eth0

#uid of current user
id -u

sudo apt-get install zabbix-agent
#for cacti
sudo apt-get install snmp snmpd

export LC_CTYPE=en_US.UTF-8
#sudo locale-gen en_US.UTF-8
sudo nano /etc/default/locale

LC_NUMERIC=en_US.UTF-8
LC_TIME=en_US.UTF-8
LC_MONETARY=en_US.UTF-8
LC_PAPER=en_US.UTF-8
LC_NAME=en_US.UTF-8
LC_ADDRESS=en_US.UTF-8
LC_TELEPHONE=en_US.UTF-8
LC_MEASUREMENT=en_US.UTF-8
LC_IDENTIFICATION=en_US.UTF-8

#dhcp
sudo nano /etc/dhcp/dhclient.conf
#add
append domain-name " nabla.mobi";
#restart dhcp
sudo dhclient

#http://www.isalo.org/wiki.debian-fr/Cowsay_et_fortunes
sudo apt-get install aptitude
sudo aptitude install cowsay fortunes fortunes-fr
sudo apt-get install randomize-lines
#add in .bashrc
#/usr/games/cowsay -f `ls /usr/share/cowsay/cows/ | rl | tail -n 1 | cut -d'.' -f1` "`fortune -s`"

#http://blog.retep.org/2012/07/05/whoopsie-how-to-disable-it-on-ubuntu-12-04-or-mint-13/
sudo apt-get remove whoopsie

#SVN
#sudo apt-get install python-nautilus python-configobj python-gtk2 python-glade2 python-svn python-dbus python-dulwich subversion meld
#sudo add-apt-repository ppa:rabbitvcs/ppa
#deb http://ppa.launchpad.net/rabbitvcs/ppa/ubuntu precise main
sudo apt-get update
sudo apt-get install rabbitvcs-nautilus
sudo apt-get install rabbitvcs-gedit
sudo apt-get install rabbitvcs-cli

#putty
sudo chown -R albandri:albandri ~/.putty

#javascript coverage
sudo apt-get install lcov
#diff tool
sudo apt-get install meld

#wallpaper
#http://peterlevi.com/variety/
sudo add-apt-repository ppa:peterlevi/ppa
sudo apt-get update
sudo apt-get install variety

#supervisor
#http://supervisord.org/configuration.html
sudo easy_install supervisor
sudo apt-cache show supervisor
sudo apt-get install supervisor

#startup application display all prg
sudo sed -i "s/NoDisplay=true/NoDisplay=false/g" /etc/xdg/autostart/*.desktop

#start prog to run app faster
#WARNING it must be tested
#sudo apt-get install preload

#Decrease swappiness value
cat /proc/sys/vm/swappiness
gksu gedit /etc/sysctl.conf
#add the following 2 lines at the end
#Decrease swappiness value
vm.swappiness=10
cat /proc/sys/vm/swappiness
#for more info about swap please see
#https://help.ubuntu.com/community/SwapFaq

# extra package to add
sudo apt-get install ubuntu-restricted-extras

#remove incinga
sudo apt-get remove --auto-remove icinga
sudo apt-get remove icinga-web

#remove doc in order to spare disk space
sudo apt-get --purge remove tex.\*-doc$
sudo rm -Rf /usr/share/doc/texlive-doc/
sudo rm -Rf /var/lib/jenkins/tmp
sudo find /var/log -name '*.gz' | xargs sudo rm -r $1
sudo apt-get clean

# What package is the netstat executable in?
sudo apt-file search /usr/bin/netstat
# Now download the source of that package
sudo apt-get source net-tools

#boot repair
#http://doc.ubuntu-fr.org/boot-repair
#http://doc.ubuntu-fr.org/unetbootin
sudo apt-get install unetbootin

#ugrade
aptitude safe-upgrade
aptitude forbid-version my_packet=X.Y
#aptitude full-upgrade

#install notification
sudo apt-get apticron

#identify process using file
#fuser -v /dev/sdb
fuser -v /bin/bash

#system info
#lsb_release -cs
#xenial
sudo apt-get  install lsb-core
lsb_release -a
lsmod
sudo modinfo btrfs

#backup / save
#http://www.hascode.com/snippets
dpkg --get-selections > installed-packages
#dpkg --set-selections < installed-packages
#dselect

#perf monitoring
sudo apt-get install iperf

#https://askubuntu.com/questions/31618/how-can-i-find-my-hardware-details
#list hardware
#Video
sudo lspci -nnk | grep VGA -A1
#Ausio
sudo lspci -v | grep -A7 -i "audio"
#Network
sudo lspci -nnk | grep net -A2
sudo lshw -short
sudo lshw -html > lshw.html
#sudo apt-get install hardinfo

#usb issue
#http://ubuntuforums.org/archive/index.php/t-1448092.html
sudo apt-get remove usbmount

#https://www.reddit.com/r/Ubuntu/comments/3rwhye/why_is_avahidaemon_still_included_in_default/
#sudo apt-get remove avahi-daemon

#Configuration file /lib/systemd/system/tomcat7.service is marked executable
sudo chmod 644 /lib/systemd/system/tomcat7.service

#Ubuntu 14 things todo
#http://itsfoss.com/things-to-do-after-installing-ubuntu-14-04/
#http://www.webupd8.org/2014/04/10-things-to-do-after-installing-ubuntu.html
sudo apt-get install software-center*

#disable hud service
sudo chmod -x /usr/lib/x86_64-linux-gnu/hud/hud-service

#enable automatic security upgrade
sudo apt-get install unattended-upgrades
sudo dpkg-reconfigure unattended-upgrades

#systemd
sudo update-rc.d -f nexus remove
sudo systemctl enable nexus.service

#Speed up https://itsfoss.com/speed-up-ubuntu-1310/
sudo nano /etc/default/grub
#And change GRUB_TIMEOUT=10 to GRUB_TIMEOUT=2
sudo update-grub

# Are we booting with systemd
ps -p 1 -o comm=

#https://www.thegeekdiary.com/centos-rhel-7-systemd-analyze-command-to-find-booting-time-delays/
systemd-analyze time
systemd-analyze blame
systemd-analyze critical-chain
systemd-analyze plot > plot.svg
eog plot.svg

#Ubuntu 16.04 upgrade
#See https://bugs.launchpad.net/ubuntu/+source/ubuntu-release-upgrader/+bug/1613970
#sudo rm /var/lib/dpkg/info/util-linux.postinst
#install-docs --install-changed
#
#dpkg --configure initscripts
#dpkg -l initscripts insse
#apt-cache policy initscripts insserv
#
#sudo apt-get dist-upgrade -f
#
#dpkg --purge task-file-server nfs-kernel-server rpcbind nfs-common
#
#The program 'showmount' is currently not installed. You can install it by typing:
#apt install nfs-common
#
#/etc/ssh/ssh_config
#Host allmypersobox*
#    StrictHostKeyChecking no
#    UserKnownHostsFile /dev/null
#    IdentityFile ~/.ssh/kenvng.rsa

#Ubuntu 18.04 upgrade
#sudo dpkg-reconfigure dash
sudo service apparmor stop
sudo update-rc.d -f apparmor remove
sudo apt-get remove apparmor apparmor-utils

#Ubuntu 19.04 upgrade
#A start job is running for Hold until boot finishes up
#See http://rffuste.com/solution-a-start-job-is-running-for-hold-until-boot-finishes-up-ubuntu/
#mount  -o remount, rw /
#apt-get install lightdm
##dpkg-reconfigure lightdm

#Ubuntu 19.10 upgrade
#sudo aptitude remove libgtk3-nocsd0 gtk3-nocsd

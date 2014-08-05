
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

sudo apt-get install openjdk-6-jdk openjdk-7-jdk

sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java7-installer
sudo apt-get install oracle-java8-installer
#sudo ln -s java-7-oracle jdk1.7.0
#Switching between Oracle Java 8 and Java 7
sudo update-java-alternatives -s java-7-oracle
sudo update-java-alternatives -s java-8-oracle

#Setting Java environment variables
sudo apt-get install oracle-java8-set-default

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

sudo gedit /etc/apt/sources.list
ls /etc/apt/sources.list.d/
#Append the following line
#NOK deb http://us.archive.ubuntu.com/ubuntu precise main
deb http://extras.ubuntu.com/ubuntu precise main
#deb http://us.archive.ubuntu.com/ubuntu/ precise main universe
deb http://us.archive.ubuntu.com/ubuntu/ precise main universe restricted multiverse

sudo apt-get update
sudo apt-get install subversion

sudo chmod +x ~/.subversion/svn-merge-meld.py

sudo gedit /etc/apt/sources.list
#comment the following line
deb http://extras.ubuntu.com/ubuntu precise main
#deb http://us.archive.ubuntu.com/ubuntu/ precise main universe
deb http://us.archive.ubuntu.com/ubuntu/ precise main universe restricted multiverse

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

#ubuntu login loop issue
http://askubuntu.com/questions/314362/ubuntu-13-04-login-loop
rm ~/.Xauthority
rm ~/.profile
sudo apt-get install --reinstall xorg
sudo reboot

more /etc/rc.local

ls /etc/rc?.d

rc0.d contains the services which runs in runlevel 0
rc1.d contains the services which runs in runlevel 1
rc2.d contains the services which runs in runlevel 2
rc3.d contains the services which runs in runlevel 3
rc4.d contains the services which runs in runlevel 4
rc5.d contains the services which runs in runlevel 5
rc6.d contains the services which runs in runlevel 6

First one is S script (S30killprocs)---> start
Second one is k script (K15pulseaudio)---> kill

/etc/rc0.d:
K05heartbeat@            K20clamav-freshclam@  K20speech-dispatcher@  K32logd@      S20sendsigs@
K08tomcat6@              K20exim4@             K20stunnel4@           K65sonar@     S30urandom@
K08tomcat7@              K20hddtemp@           K20varnish@            K79quotarpc@  S31umountnfs.sh@
K09apache2@              K20kerneloops@        K20varnishlog@         K80slapd@     S34aoetools@
K10unattended-upgrades@  K20libnss-ldap@       K20varnishncsa@        K85bind9@     S40umountfs@
K10webmin@               K20mon@               K20vnstat@             K85dnsmasq@   S48cryptdisks@
K18icinga@               K20mountall.sh@       K20xrdp@               K85quota@     S59cryptdisks-early@
K18krb5-admin-server@    K20openhpid@          K20zfs-mount@          K90nexus@     S60umountroot@
K18krb5-kdc@             K20postfix@           K20zfs-share@          K99fail2ban@  S90halt@
K19sendmail@             K20saslauthd@         K21vblade@             README

/etc/rc1.d:
K05heartbeat@          K20acpi-support@      K20postfix@            K20vnstat@     K85bind9@
K08tomcat6@            K20clamav-freshclam@  K20saned@              K20xrdp@       K85dnsmasq@
K08tomcat7@            K20exim4@             K20saslauthd@          K20zfs-mount@  K90nexus@
K09apache2@            K20hddtemp@           K20smartmontools@      K20zfs-share@  K99fail2ban@
K10webmin@             K20kerneloops@        K20speech-dispatcher@  K21vblade@     README
K18icinga@             K20libnss-ldap@       K20stunnel4@           K32logd@       S30killprocs@
K18krb5-admin-server@  K20mon@               K20varnish@            K65sonar@      S70dns-clean@
K18krb5-kdc@           K20mountall.sh@       K20varnishlog@         K79quotarpc@   S70pppd-dns@
K19sendmail@           K20openhpid@          K20varnishncsa@        K80slapd@      S90single@

/etc/rc2.d:
README                 S20kerneloops@         S20stunnel4@     S21sendmail@   S92tomcat6@
S10nexus@              S20libnss-ldap@        S20varnish@      S30icinga@     S92tomcat7@
S15bind9@              S20logd@               S20varnishlog@   S35sonar@      S99acpi-support@
S15dnsmasq@            S20mon@                S20varnishncsa@  S50rsync@      S99fail2ban@
S18krb5-admin-server@  S20mountall.sh@        S20vblade@       S50saned@      S99grub-common@
S18krb5-kdc@           S20openhpid@           S20vnstat@       S70dns-clean@  S99ondemand@
S19slapd@              S20postfix@            S20xrdp@         S70pppd-dns@   S99rc.local@
S20clamav-freshclam@   S20saslauthd@          S20zfs-mount@    S75heartbeat@  S99webmin@
S20exim4@              S20smartmontools@      S20zfs-share@    S75sudo@
S20hddtemp@            S20speech-dispatcher@  S21quotarpc@     S91apache2@

/etc/rc3.d:
README                 S20kerneloops@         S20stunnel4@     S21sendmail@   S92tomcat6@
S10nexus@              S20libnss-ldap@        S20varnish@      S30icinga@     S92tomcat7@
S15bind9@              S20logd@               S20varnishlog@   S35sonar@      S99acpi-support@
S15dnsmasq@            S20mon@                S20varnishncsa@  S50rsync@      S99fail2ban@
S18krb5-admin-server@  S20mountall.sh@        S20vblade@       S50saned@      S99grub-common@
S18krb5-kdc@           S20openhpid@           S20vnstat@       S70dns-clean@  S99ondemand@
S19slapd@              S20postfix@            S20xrdp@         S70pppd-dns@   S99rc.local@
S20clamav-freshclam@   S20saslauthd@          S20zfs-mount@    S75heartbeat@  S99webmin@
S20exim4@              S20smartmontools@      S20zfs-share@    S75sudo@
S20hddtemp@            S20speech-dispatcher@  S21quotarpc@     S91apache2@

/etc/rc4.d:
K10webmin@             S20hddtemp@        S20speech-dispatcher@  S21quotarpc@   S91apache2@
README                 S20kerneloops@     S20stunnel4@           S21sendmail@   S92tomcat6@
S10nexus@              S20libnss-ldap@    S20varnish@            S30icinga@     S92tomcat7@
S15bind9@              S20logd@           S20varnishlog@         S35sonar@      S99acpi-support@
S15dnsmasq@            S20mon@            S20varnishncsa@        S50rsync@      S99fail2ban@
S18krb5-admin-server@  S20mountall.sh@    S20vblade@             S50saned@      S99grub-common@
S18krb5-kdc@           S20openhpid@       S20vnstat@             S70dns-clean@  S99ondemand@
S19slapd@              S20postfix@        S20xrdp@               S70pppd-dns@   S99rc.local@
S20clamav-freshclam@   S20saslauthd@      S20zfs-mount@          S75heartbeat@
S20exim4@              S20smartmontools@  S20zfs-share@          S75sudo@

/etc/rc5.d:
README                 S20kerneloops@         S20stunnel4@     S21sendmail@   S92tomcat6@
S10nexus@              S20libnss-ldap@        S20varnish@      S30icinga@     S92tomcat7@
S15bind9@              S20logd@               S20varnishlog@   S35sonar@      S99acpi-support@
S15dnsmasq@            S20mon@                S20varnishncsa@  S50rsync@      S99fail2ban@
S18krb5-admin-server@  S20mountall.sh@        S20vblade@       S50saned@      S99grub-common@
S18krb5-kdc@           S20openhpid@           S20vnstat@       S70dns-clean@  S99ondemand@
S19slapd@              S20postfix@            S20xrdp@         S70pppd-dns@   S99rc.local@
S20clamav-freshclam@   S20saslauthd@          S20zfs-mount@    S75heartbeat@  S99webmin@
S20exim4@              S20smartmontools@      S20zfs-share@    S75sudo@
S20hddtemp@            S20speech-dispatcher@  S21quotarpc@     S91apache2@

/etc/rc6.d:
K05heartbeat@            K20clamav-freshclam@  K20speech-dispatcher@  K32logd@      S20sendsigs@
K08tomcat6@              K20exim4@             K20stunnel4@           K65sonar@     S30urandom@
K08tomcat7@              K20hddtemp@           K20varnish@            K79quotarpc@  S31umountnfs.sh@
K09apache2@              K20kerneloops@        K20varnishlog@         K80slapd@     S34aoetools@
K10unattended-upgrades@  K20libnss-ldap@       K20varnishncsa@        K85bind9@     S40umountfs@
K10webmin@               K20mon@               K20vnstat@             K85dnsmasq@   S48cryptdisks@
K18icinga@               K20mountall.sh@       K20xrdp@               K85quota@     S59cryptdisks-early@
K18krb5-admin-server@    K20openhpid@          K20zfs-mount@          K90nexus@     S60umountroot@
K18krb5-kdc@             K20postfix@           K20zfs-share@          K99fail2ban@  S90reboot@
K19sendmail@             K20saslauthd@         K21vblade@             README

/etc/rcS.d:
README  S25brltty@  S35quota@  S37apparmor@  S41aoetools@  S47lm-sensors@  S55urandom@  S70x11-common@

#sudo update-rc.d varnish start XX 2 3 4 5 . stop XX 0 1 6 .
#sudo update-rc.d varnish start 30 5 . stop 30 0 1 6 .
#Dans ce cas là, monscript sera uniquement lancé dans le runlevel 5 et avec une priorité de 30. Il sera stoppé dans les runlevels 0,1,6 avec une priorité de 30 également.
#Les runlevels 2,3,4,5 pour le lancer et 0,1,6 pour le stopper. La priorité par défaut est de 20.
#Si vous n’êtes pas bien certain de ce que vous faîtes, vous pouvez toujours lancer une simulation afin d’éviter la bourde… Pour cela, il est possible d’utiliser l’argument -n à votre commande qui affichera ce qu’aurait fait update-rc.d

#test
sudo update-rc.d -n varnish start 85 2 3 4 5 . stop 20 0 1 6 .
sudo update-rc.d -n varnish start 85 2 3 4 5 . stop 20 0 1 6 .
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

# ubuntu error messages check
dmesg
grep EDAC /var/log/messages*
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

#messaging
#http://mylinuxbook.com/how-to-get-pidgin-working-with-gtalk/
sudo apt-get install pidgin pidgin-sipe pidgin-skype
#add my google account
#Username alban.andrieu
#Domain nabla.mobi
#Resource home
#In advanced tab
#Connection security Use old-style SSL
#Connect port 5223
#Connect server  talk.google.com
#add my misys account 
#Protocol Office Communicator
#Username alban.andrieu@misys.com
#Login alban.andrieu@misys.com
#add my Skype account
#Username alban.andrieu
#Local Alias Alban Andrieu

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

#synergy
wget http://synergy-project.org/files/packages/synergy-1.4.17-r2055-Linux-x86_64.deb

#opencl
#http://develnoter.blogspot.co.uk/2012/05/installing-opencl-in-ubuntu-1204.html
cd /workspace
wget http://registrationcenter.intel.com/irc_nas/4181/intel_sdk_for_ocl_applications_2014_ubuntu_4.4.0.117_x64.tgz
tar zxvf intel_sdk_for_ocl_applications_2014_ubuntu_4.4.0.117_x64.tgz
./install-cpu.sh
ll /usr/lib/x86_64-linux-gnu/libOpenCL.so

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
sudo apt-get remove icinga-web

#remove doc in order to spare disk space
sudo apt-get --purge remove tex.\*-doc$
sudo rm -Rf /usr/share/doc/texlive-doc/
sudo rm -Rf /var/lib/jenkins/tmp
sudo find /var/log -name '*.gz' | xargs sudo rm -r $1
sudo apt-get clean

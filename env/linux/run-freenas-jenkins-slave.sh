
pkg update && pkg upgrade
portsnap fetch update
#You must run 'portsnap extract' before running 'portsnap update'.

#Install Jenkins
#https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+inside+a+FreeNAS+jail

pkg_add -r jenkins
http://192.168.0.23:8380/
http://home.nabla.mobi:8381/
/usr/local/etc/rc.d/jenkins onestart
edit /usr/local/etc/rc.d/jenkins
/usr/local/etc/rc.d/jenkins stop
#--ajp13ListenAddress=192.168.0.14 --ajp13Port=8009
#REMOVE --prefix=/jenkins for jenkins apps on android
: ${jenkins_args="--webroot=${jenkins_home}/war --httpListenAddress=0.0.0.0 --httpPort=8380 --prefix=/"}
echo 'jenkins_enable="YES"' >> /etc/rc.conf

tail -f /var/log/jenkins.log
tail -f /mnt/dpool/jail/software/var/log/httpd-access.log

cd /usr/local/etc/rc.d/
edit jenkins
service jenkins restart
http://home.nabla.mobi:8380/
192.168.0.23
tail -f /var/log/jenkins.log

user : admin
pass :

id jenkins

#in jail
edit /etc/group

#sudo usermod -u 117 jenkins
#pw useradd -n jenkins -u 117 -d /nonexistent -s /usr/sbin/nologin
#pw userdel jenkins
pw groupadd -n jenkins -g 131
pw useradd -n jenkins -u 117 -d /usr/local/jenkins -s /usr/local/bin/bash
#pw groupmod -g 131 jenkins
pw groupmod jenkins -m jenkins

pw usermod jenkins -G wheel

chown -R jenkins:jenkins /var/run/jenkins

#add ssh to jail
#http://doc.freenas.org/index.php/Adding_Jails
#edit /etc/rc.conf
echo 'sshd_enable="YES"' >> /etc/rc.conf
service sshd start

#jenkins user add rsa key in freenas
[jenkins@freenas ~/.ssh]$ ssh-keygen -t rsa
Generating public/private rsa key pair.
Enter file in which to save the key (/mnt/dpool/jenkins/.ssh/id_rsa):
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /mnt/dpool/jenkins/.ssh/id_rsa.
Your public key has been saved in /mnt/dpool/jenkins/.ssh/id_rsa.pub.
The key fingerprint is:
37:41:20:f6:8e:c8:aa:23:b7:45:82:7e:df:46:b2:7a jenkins@freenas.local

less ~/.ssh/id_rsa.pub
ssh-rsa KEY jenkins@freenas.local
ssh-rsa KEY jenkins@albandri

#freenas
ssh -X jenkins@192.168.0.46
ssh-keyscan -t rsa 192.168.0.29 >> /mnt/dpool/jenkins/.ssh/known_hosts
#in the jail
ssh-keyscan -t rsa 192.168.0.29 >> ~/.ssh/known_hosts

#from jenkins master as jenkins user (su - jenkins)
cat .ssh/id_rsa.pub | ssh jenkins@192.168.0.26 'cat >> .ssh/authorized_keys'

#jenkins_2 jail
ssh -v jenkins@192.168.0.26
#albandri
ssh -v jenkins@192.168.0.29

#
/usr/sbin/freebsd-update && freebsd-update install

#install package
#See https://www.freebsd.org/doc/handbook/ports-using.html
#jexec 1 /bin/tcsh
export PATH=/sbin:/bin:/usr/sbin:/usr/bin:/usr/games:/usr/local/sbin:/usr/local/bin:/mnt/dpool/bin:/mnt/dpool/jail/software/usr/local/bin
#/usr/local/etc/pkg/repos/FreeBSD.conf
pkg update -f
/usr/sbin/portsnap fetch
/usr/sbin/portsnap extract
/usr/sbin/portsnap update

To update ports it's enough just to run
# portsnap fetch extract
for the first time (yes, it downloads and extracts ~60MB for the first time) and
# portsnap fetch update
thereafter (it downloads only deltas and it's really fast).
If you used csup before (or installed ports from DVD) it's better to delete all /usr/ports directory first and then run portsnap fetch extract.
That's was step #1. Next if you run
# pkg_version -vL=
it shows all your outdated packages (installed ports).
Then read /usr/ports/UPDATING and update your installed ports starting from the most important such as gettext, perl, python and similar. I don't use -a option whatsoever: it's troublesome (with exception of pkg_delete -a :))
When you have all the installed ports up-to-date the troubles are unlikely.
The last step is installation itself. It could be done by
# cd /usr/ports/<pkg_group>/<package> && make install clean
but it also could be done by
# pkg_add -r <package> if you accept default configs and the up-to-date packages were created already and could be found in a repository corresponding your distribution:
ftp://ftp.freebsd.org/pub/FreeBSD/ports/<ARCH>/packages-N-distro/Latest/
I use both methods depending on current situation.

tail -f  /var/log/messages

#freenas
ssh jenkins@192.168.0.46
ssh-keyscan -t rsa 192.168.0.29 >> /mnt/dpool/jenkins/.ssh/known_hosts

#jenkins_1 jail
ssh -v jenkins@192.168.0.14
#albandri
ssh -v jenkins@192.168.0.29

#in the jail
#install port
portsnap fetch && portsnap extract

-----------------------------------------------------
#shorty error
http://www.macintom.com/wp/2012/06/13/owncloud-bug-lors-de-lactivation-dune-application-owncloud-ne-fonctionne-plus/
UPDATE  `oc_appconfig` SET  `configvalue` =  "no" WHERE  `appid` =  "shorty" AND  `configkey` =  "enabled"
UPDATE  `oc_appconfig` SET  `configvalue` =  "no" WHERE  `appid` =  "music" AND  `configkey` =  "enabled"
UPDATE  `oc_appconfig` SET  `configvalue` =  "no" WHERE  `appid` =  "internal_bookmarks" AND  `configkey` =  "enabled"
UPDATE  `oc_appconfig` SET  `configvalue` =  "no" WHERE  `appid` =  "mozilla_sync" AND  `configkey` =  "enabled"

ll /usr/local/share/jenkins/jenkins.war
pkg_add -v -r fontconfig
pkg_add -v -r libXfont
pkg_add -v -r libfontenc
pkg_add -v -r ttmkfdir
pkg_add -v -r dejavu
pkg_add -v -r freetype
pkg_add -v -r freetype-tools

/usr/local/jenkins

pkg_info | grep jenkins
#pkg_delete jenkins-1.454
cd /usr/ports/devel/jenkins/ && make install clean
ll /usr/ports/distfiles/jenkins/1.525/jenkins.war
cd /usr/local/share/jenkins/

pkg install selenium
/usr/local/www/selenium

#To automate browsers you need one or more of these ports:
#pkg install www/firefox
#pkg install www/chromium
#
#With one or more of these complementary ports:
#pkg install www/geckodriver
#pkg install x11-servers/xorg-vfbserver
#pkg install x11-fonts/xorg-fonts
#pkg install x11-fonts/webfonts
#pkg install x11/xauth
#pkg install x11/xkeyboard-config
#pkg install x11/xkbcomp
#
#Clients can also be found:
#pkg install www/rubygem-selenium-webdriver
#pkg install www/py-selenium
#pkg install devel/p5-Test-WWW-Selenium

ssh-keygen
cat ~/.ssh/id_rsa.pub | ssh 192.168.0.23 "cat >> .ssh/authorized_keys"

#cd /usr/ports/graphics/graphviz/ && make install clean
pkg install graphviz

pkg install node
pkg install npm
pkg install firefox
pkg install chromium
pkg install hs-ShellCheck
pkg install lsof
pkg install htop

pkg install perl5
pkg install p5-Locale-libintl
pkg install p5-Locale-gettext

portsnap fetch update

pkg upgrade ruby23
pkg install ruby23

#pkg install ruby23
cd /usr/ports/lang/phantomjs/
#make install clean
#make ALLOW_UNSUPPORTED_SYSTEM=true DISABLE_VULNERABILITIES=yes install clean > test.log
make ALLOW_UNSUPPORTED_SYSTEM=true clean install > test.log
make reinstall

#https://wiki.freebsd.org/Docker
#pkg install docker
pkg install docker-freebsd ca_root_nss

ls -lrta /dev/zvol/dpool/
#zfs create -o mountpoint=/usr/docker dpool/docker

pw groupadd -n docker -g 1002
pw usermod <you> -G operator

# sysrc -f /etc/rc.conf docker_enable="YES"
# service docker start

docker -d
#/sbin/zfs zfs get -rHp -t filesystem all dpool/jails/jenkinsslave_1
less /var/log/docker.log
#/usr/local/bin/docker -d -D -g "/var/lib/docker" -H unix:// -H tcp://0.0.0.0:2376 -s zfs >> "/var/lib/docker/docker.log"

#See issue https://forums.freenas.org/index.php?threads/need-some-clarity-on-docker-setup.54323/

#TODO
#https://forums.freenas.org/index.php?threads/how-to-oracle-database-container.53973/

#pkg_add -v -r maven3
#cd /usr/ports/devel/maven3/ && make install clean
pkg install maven3
#cd /usr/ports/devel/maven33/ && make install clean
pkg install maven33

mvn --version

pkg install nano bash
#bash_completion
ln -s /usr/local/bin/bash /bin/bash

pkg install sudo

pkg install ruby
pkg install devel/ruby-gems
#pkg_add -v -r gtksourceview

#SSH
ssh -i OpenSSH_RSA_4096 albandri@freenas

#http://doc.freenas.org/index.php/Plugins

#firefox fix
dbus-uuidgen > /var/lib/dbus/machine-id
#TODO pkg install libcanberra libcanberra-gtk3

#!/bin/bash
set -xv

#Fix wrong version of Feenas in jail
sudo freebsd-version
jls
sudo jexec 10 freebsd-version
pkg version -v

#See https://www.reddit.com/r/freenas/comments/7s1cgb/pkg_repository_freebsd_contains_packages_for/
#I solved it by editing /usr/local/etc/pkg/repos/FreeBSD.conf Setting the url: to "pkg+https://pkg.freebsd.org/freebsd:11:x86:64/release_1" solved the problem.

pkg update && pkg upgrade
pkg update -f

#Install Jenkins
#https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+inside+a+FreeNAS+jail

pkg_add -r jenkins
http://192.168.0.23:8380/
http://albandrieu.com:8381/
/usr/local/etc/rc.d/jenkins onestart
edit /usr/local/etc/rc.d/jenkins
/usr/local/etc/rc.d/jenkins stop
#--ajp13ListenAddress=192.168.0.14 --ajp13Port=8009
#REMOVE --prefix=/jenkins for jenkins apps on android
: ${jenkins_java_opts="-Xmx2048m -XX:MaxPermSize=512m -Djava.awt.headless=true"}
: ${jenkins_args="--webroot=${jenkins_home}/war --httpListenAddress=0.0.0.0 --httpPort=8380 --prefix=/"}
echo 'jenkins_enable="YES"' >> /etc/rc.conf

tail -f /var/log/jenkins.log
tail -f /mnt/dpool/jail/software/var/log/httpd-access.log

cd /usr/local/etc/rc.d/
edit jenkins
service jenkins restart
http://albandrieu.com:8380/
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

#pw groupadd -n www -g 80 #already exist
pw useradd -n albandri -u 1000 -d /usr/local/albandri -s /usr/local/bin/bash

#user www-data 33 33 TO DELETE
#use instead www 80

#add ssh to jail
#http://doc.freenas.org/index.php/Adding_Jails
#edit /etc/rc.conf
echo 'sshd_enable="YES"' >> /etc/rc.conf
service sshd start

/usr/sbin/freebsd-update && freebsd-update install

#install package
#See https://www.freebsd.org/doc/handbook/ports-using.html
#jexec 1 /bin/tcsh
export PATH=/sbin:/bin:/usr/sbin:/usr/bin:/usr/games:/usr/local/sbin:/usr/local/bin:/mnt/dpool/bin:/mnt/dpool/jail/software/usr/local/bin
#/usr/local/etc/pkg/repos/FreeBSD.conf

tail -f  /var/log/messages

-----------------------

pkg_add -v -r fontconfig
pkg_add -v -r libXfont
pkg_add -v -r libfontenc
pkg_add -v -r ttmkfdir
pkg_add -v -r dejavu
pkg_add -v -r freetype
pkg_add -v -r freetype-tools

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

#SSH
ssh -i OpenSSH_RSA_4096 albandri@freenas

#http://doc.freenas.org/index.php/Plugins

#firefox fix
dbus-uuidgen > /var/lib/dbus/machine-id
#TODO pkg install libcanberra libcanberra-gtk3

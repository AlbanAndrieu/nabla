#!/bin/bash
set -xv

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

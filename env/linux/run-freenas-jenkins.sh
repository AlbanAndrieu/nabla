#!/bin/bash
#set -xv

#Fix wrong version of Feenas in jail
freebsd-version
jls
sudo jexec 10 freebsd-version

#See https://www.reddit.com/r/freenas/comments/7s1cgb/pkg_repository_freebsd_contains_packages_for/
#I solved it by editing /usr/local/etc/pkg/repos/FreeBSD.conf Setting the url: to "pkg+https://pkg.freebsd.org/freebsd:11:x86:64/release_1" solved the problem.

pkg update && pkg upgrade
pkg update -f
portsnap fetch extract update
#You must run 'portsnap extract' before running 'portsnap update'.

#Install Jenkins
#https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+inside+a+FreeNAS+jail
#https://wiki.jenkins.io/display/JENKINS/Installing+Jenkins+inside+a+FreeNAS+jail

#http://www.slideshare.net/iXsystems/jenkins-bhyve
pkg install devel/jenkins-lts
#pkg install /devel/jenkins
======================================================================

This OpenJDK implementation requires fdescfs(5) mounted on /dev/fd and
procfs(5) mounted on /proc.

If you have not done it yet, please do the following:

        mount -t fdescfs fdesc /dev/fd
        mount -t procfs proc /proc

To make it permanent, you need the following lines in /etc/fstab:

        fdesc   /dev/fd         fdescfs         rw      0       0
        proc    /proc           procfs          rw      0       0

======================================================================

#pkg_add -r jenkins
http://192.168.1.62/jenkins
http://albandrieu.com:8686/jenkins

edit /usr/local/etc/rc.d/jenkins
#--ajp13ListenAddress=192.168.0.14 --ajp13Port=8009
#REMOVE --prefix=/jenkins for jenkins apps on android
: ${jenkins_java_opts="-Xmx2048m -XX:MaxPermSize=512m -Djava.awt.headless=true"}
: ${jenkins_args="--webroot=${jenkins_home}/war --httpListenAddress=0.0.0.0 --httpPort=8380 --prefix=/"}
echo 'jenkins_enable="YES"' >> /etc/rc.conf

cd /usr/local/etc/rc.d/
edit jenkins

cd /usr/local/share/jenkins/
ls -lrta jenkins.war
mv jenkins.war jenkins.war-2.176.4
/usr/local/bin/wget http://mirrors.jenkins.io/war-stable/latest/jenkins.war

# install by hand
#pkg_info | grep jenkins
##pkg_delete jenkins-1.454
#cd /usr/ports/devel/jenkins/ && make install clean
#ll /usr/ports/distfiles/jenkins/1.525/jenkins.war
#cd /usr/local/share/jenkins/

cd /usr/local/jenkins
mv jenkins jenkins-BACK-SAV
ln -s /media/jenkins jenkins

cd /usr/local/jenkins
nano config,xml
#<!--<useSecurity>true</useSecurity>-->

#/usr/local/etc/rc.d/jenkins onestart
#/usr/local/etc/rc.d/jenkins stop
service jenkins restart

tail -f /var/log/jenkins.log
tail -f /mnt/dpool/jail/software/var/log/httpd-access.log

cd /media/jenkins/scm-sync-configuration/checkoutConfiguration
git config --global user.email "alban.andrieu@free.fr"
git config --global user.name "AlbanAndrieu"

exit 0

#!/bin/bash
set -xv

#TODO See https://github.com/freenas/docker-images

#wake on LAN
#https://dipisoft.com/pages/wakeonwan.php?lng=fr&tconfig=0
#7C:05:07:0E:D9:88

#from Shell
/etc/netcli

echo "https://192.168.0.46:7000/"
echo "https://home.nabla.mobi:7000/"
echo "https://freenas.freeboxos.fr:7000/"

#GUI
user : root

#Upgrade FreeNAS
#http://doc.freenas.org/index.php/Upgrading_FreeNAS%C2%AE

#http://download.freenas.org/9.2.1.5/RELEASE/x64/

#to see
#http://www.durindel.fr/utilisation-avancee-de-freenas
#http://www.durindel.fr/informatique/tutoriel-configuration-de-freenas
#TODO
#http://www.geekzone.fr/ipb/topic/49641-les-newsgroups-pour-les-nuls-sabnzbd-sickbeard-couchpotato/

#remove old plugins by hand
#https://bugs.freenas.org/issues/4264#note-4
sqlite3 /data/freenas-v1.db

delete from plugins_plugins;
delete from services_rcptoken;
delete from plugins_nullmountpoint;

.quit

#do some cleanup on old dataset
cd /mnt/dpool/plugins
minidlna-1.0.24_1-amd64
transmission-2.77-amd64
firefly-1696_7-amd64

#freenas IP is 192.168.0.46

#IPv4 Default Gateway
#NOK 192.168.1.1
#192.168.0.254 (freebox)
#Nameserver 1
#8.8.8.8
#Nameserver 2
#8.8.4.4

#Install PBI Plugins : http://pisethtips.blogspot.fr/2013/01/using-freenas-to-build-diy-home-server.html
#jail IP is 192.168.0.47

http://sourceforge.net/projects/freenas/files/FreeNAS-8.3.1/RELEASE-p2/x64/

#minidlna
#TODO fix issue http://forums.freenas.org/index.php?threads/minidlna-automatic-scan-fix.9312/
#http://www.durindel.fr/utilisation-avancee-de-freenas#etape3
echo 'minidlna_enable="YES"' >> /etc/rc.conf
#https://sites.google.com/site/mesnasmesdonneesetmoi/synology-dsm-3-1-sur-un-ds411j/freebox-player

#install minidlna by hand
#http://www.durindel.fr/informatique/tuto-freenas-9-3-installer-des-plugins-plex-et-minidlna
http://192.168.0.47:8200
http://192.168.0.2:8200/
service minidlna onestart

tail -f var/log/minidlna.log
tail -f /mnt/dpool/jail/software/var/log/minidlna.log
#rm -Rf /mnt/dpool/jail/software/var/db/minidlna/files.db
#check issue http://forums.freenas.org/threads/mount-point-connects-to-empty-folders-cannot-get-minidlna-to-scan-media.11196/

#configure plugins
#http://forums.freenas.org/index.php?threads/seting-up-freenas-9-2-0-with-transmission-and-couchpotato-as-a-dlna-server.17165/

#Firefly
#do redirect to jail
http://192.168.0.46:3689/
http://home.nabla.mobi:3689/index.html

#transmission
http://192.168.0.01:9091/
http://home.nabla.mobi:9091/transmission/web/
#in the jail
cd /usr/pbi/transmission-amd64/etc/transmission/home/
edit /usr/pbi/transmission-amd64/etc/transmission/home/settings.json

#install transmission rempte gui
#https://code.google.com/p/transmisson-remote-gui/downloads/list

#couchpotato
http://home.nabla.mobi:5050/
http://192.168.0.4:5050/
#username : AlbanAndrieu
#alban.andrieu@free.fr
API KEY : 2eec6cdb46a542fab4ae650d770a89b4

#sickbeard
http://192.168.0.6:8081/
API KEY : f98167fbbea5df9cb52e1a5eb642cca1

#sonarr
http://home.nabla.mobi:8989/
http://192.168.0.5:8989/
API KEY : 04617d4e3dd945cd83d79555064f71d0

#mylar
http://192.168.0.21:8090/
API KEY : 750d7c4d76786e8851c65795e2ec59de

#sabnzbd_1
https://home.nabla.mobi:9090/sabnzbd/
https://sabnzbd_1:9090/sabnzbd/
http://192.168.0.3:8080/sabnzbd/wizard/
#user admin
API KEY : eb516be6908cd047b0d48c96f2bf59ba
NZB Key : beac1fd2af932dffdf1bb931f6c345e9
#Change the "Completed Download Folder" folder setting in SAB's folder settings to remove slash.

#madsonic
http://192.168.0.22:4040/

#subsonic
#install subsonic 4.9 (5.2 is not working)
#get pbi 4.9 at http://www.freenas.org/downloads/plugins/9/x64/
http://192.168.0.11:4040
#customplugin_1
pkg_add -v -r xtrans
pkg_add -v -r xproto
pkg_add -v -r xextproto
pkg_add -v -r javavmwrapper
# NOK pkg_add -v -r lame
#instead
pkg_add -r -v http://ftp.urc.ac.ru/pub/OS/FreeBSD/packages-7/Latest/lame.tbz
pkg_add -v -r flac
pkg_add -v -r ffmpeg

./usr/local/share/subsonic
./usr/local/etc/subsonic
./usr/local/etc/rc.d/subsonic
/usr/pbi/subsonic-amd64/etc/subsonic
#user admin

#Subsonic music stream license
edit /etc/hosts
#add 127.0.0.1 subsonic.org
echo -n alban.andrieu@free.fr | md5sum

#headphone
http://192.168.0.8:8181/home
#user admin
API KEY : 4e2577bedc17a65e4fa0bea9405c9b41
Songkick API KEY : nd1We7dFW2RqxPw8

#Nzbhydra
http://192.168.0.9:5075/
API KEY : ab00y7qye6u84lx4eqhwd0yh1wp423

#owncloud
http://home.nabla.mobi:83/
http://192.168.0.10
user : admin

#LazyLibrarian
#http://192.168.0.7:5299/home

#plexmedia
#In the gui check disableRemoteSecurity
#or
#/usr/pbi/plexmediaserver-amd64/plexdata/Plex Media Server/Preferences.xml
#and add the attribute
#disableRemoteSecurity="1"
#http://192.168.0.15:32400/web/index.html

#mount by hand
sudo apt-get install nfs-common
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media /media -o user=albandri
sudo umount /media/ftp
sudo umount /media/photo
sudo umount /media/music
sudo umount /media/video
sudo umount /image
sudo umount /archive
sudo umount /jenkins-tmp
sudo umount /workspace-tmp
sudo umount /workspace/users/albandri10

#sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/ftp /media/ftp -o user=albandri
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/download /media/download
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/ftp /media/ftp
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/movie /media/movie
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/music /media/music
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/photo /media/photo
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/serie /media/serie
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/torrentfile /media/torrentfile
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/video /media/video
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/webdav /media/webdav
sudo mount -t zfs 192.168.0.46:/mnt/dpool/image /image
sudo mount -t nfs 192.168.0.46:/mnt/dpool/archive /archive
sudo mount -t nfs 192.168.0.46:/mnt/dpool/backup /backup
sudo mount -t nfs 192.168.0.46:/mnt/dpool/jenkins /media/jenkins
rsync -anv /jenkins/ /media/jenkins
sudo mount -t nfs 192.168.0.46:/mnt/dpool/jenkins-slave /jenkins-slave
sudo mount -t nfs 192.168.0.46:/mnt/dpool/workspace /workspace-tmp
#sudo mount -t nfs 192.168.0.46:/mnt/dpool/workspace/users/albandri10 /workspace/users/albandri10

#TODO
#https://github.com/zfsonlinux/pkg-zfs/wiki/Ubuntu-ZFS-mountall-FAQ-and-troubleshooting
#connect to freenas
zfs get mountpoint /mnt/dpool/media/ftp
#zfs set mountpoint=/export/media/ftp /mnt/dpool/media/ftp
zfs set mountpoint=/dpool/media/ftp dpool/media/ftp
zfs get mountpoint dpool/media/ftp
zfs set mountpoint=legacy dpool/media/ftp

sudo gedit /etc/fstab
#<server>:</remote/export></local/directory><nfs-type><options> 0 0
freenas:/mnt/dpool/media/ftp /media/ftp nfs rw 0 0
freenas:/mnt/dpool/media/photo /media/photo nfs rw 0 0
freenas:/mnt/dpool/media/music /media/music nfs rw 0 0
freenas:/mnt/dpool/media/video /media/video nfs rw 0 0
192.168.1.1:/mnt/dpool/image /image nfs defaults 0 0
freenas:/mnt/dpool/archive /archive nfs rw 0 0
freenas:/mnt/dpool/backup /backup nfs rw 0 0
freenas:/mnt/dpool/jenkins /jenkins nfs rw 0 0
freenas:/mnt/dpool/workspace /workspace-tmp nfs rw 0 0
#freenas:/mnt/dpool/media/ftp  /media/ftp  zfs  defaults  0  0

#mount main disk from ubuntu usb
#http://www.linuxquestions.org/questions/linux-general-1/cannot-edit-fstab-in-recovery-mode-filesystem-is-read-only-540195/
umount /mnt/sda1
mount -o rw /dev/sda1 /mnt/sda1

#workaround
http://askubuntu.com/questions/76901/nfs-mount-fails-on-startup
cd /etc/init.d/
sudo gedit /etc/init.d/mountall.sh
sudo chmod +x mountall.sh
sudo update-rc.d mountall.sh defaults
less /var/log/syslog | grep -i nfs

#install java
ssh root@192.168.0.46

#http://doc.freenas.org/index.php/Plugins#Accessing_the_Plugins_Jail
jls
#jexec 1 /bin/tcsh
jexec 9

#http://orw.se/blog/index.php/install-java-on-freenas-7-3/
setenv PACKAGESITE ftp://ftp.freebsd.org/pub/FreeBSD/ports/i386/packages-8.3-release/Latest/

pkg_add -v -r compat6x-i386
pkg_add -v -r libXaw
pkg_add -v -r libdnet
pkg_add -v -r libevent
pkg_add -v -r libgcrypt
pkg_add -v -r libidn
pkg_add -v -r libnet11
pkg_add -v -r libpcap
pkg_add -v -r libtasn1

pkg_add -v -r subversion
pkg_add -v -r wget

pkg_add -v -r openjdk7

pkg install ansible
#for Xvfb
pkg install xorg-vfbserver
#/usr/local/bin/Xvfb

pkg install firefox

npm install -g bower
npm install -g nsp
#npm install -g phantomjs-prebuilt

pkg install phantomjs

pkg install wildfly10
Extracting wildfly10-10.1.0: 100%
Message from wildfly10-10.1.0:
To make WildFly bind to all interfaces add this to rc.conf:

wildfly10_args="-Djboss.bind.address=0.0.0.0"
echo '-Djboss.bind.address=0.0.0.0' >> /etc/rc.conf

See

        https://community.jboss.org/wiki/JBossProperties

for additional startup properties.

To change JVM args, edit appropriate standalone.conf.

To add the initial admin user:

/usr/local/wildfly10/bin/add-user.sh

http://doc.freenas.org/index.php/Plugins#Accessing_the_Plugins_Jail

ls -l /dev/da1*
mkdir /mnt/usb1
mount -t ntfs /dev/da1s1 /mnt/usb1/
mount_msdosfs /dev/da1s1 /mnt/usb1/
umount /mnt/usb1/

#change default shell to bash
chsh -s /usr/local/bin/bash root
echo $SHELL

#SSH private key
#http://www.learnfreenas.com/blog/2009/07/22/how-to-connect-to-your-freenas-server-via-ssh-without-a-password-password-free-logins-via-public-key-authentication/
#chmod -R 755 /mnt/dpool/albandri/.ssh
#chown -R albandri:albandri /mnt/dpool/albandri/.ssh
#chmod 600 /mnt/dpool/albandri/.ssh/authorized_keys
scp ~/.ssh/id_rsa.pub albandri@192.168.0.46:
cat ~/id_rsa.pub >> ~/.ssh/authorized_keys
chmod 600 ~/.ssh/authorized_keys

#for root
jexec 1 /bin/tcsh
mkdir ~/.ssh

#http://how-to.linuxcareer.com/how-to-automatically-chroot-jail-selected-ssh-user-logins
mkdir /var/chroot
ldd /bin/bash
cd /var/chroot/
mkdir bin/ lib64/ lib/
cp /lib/libncurses.so.8 lib/
cp /lib/libc.so.7 lib/
cp /bin/bash bin/
cp /bin/csh bin/

ldd /usr/bin/ssh

/usr/local/bin/java
/mnt/dpool/jail/software/usr/local
export PATH=/sbin:/bin:/usr/sbin:/usr/bin:/usr/games:/usr/local/sbin:/usr/local/bin:/mnt/dpool/bin:/mnt/dpool/jail/software/usr/local/bin

less  /usr/local/etc/sudoers
#albandri  ALL= NOPASSWD: /usr/sbin/jexec

jexec 1 /bin/tcsh /mnt/dpool/jail/software/usr/local/bin/java --version

#install apache
http://forums.freenas.org/threads/howto-install-apache-under-jail-with-freenas-8-3.10594/
pkg install apache24
pkg install apachetop
cd /usr/ports/www/apache24
cat /usr/local/etc/apache24/httpd.conf | grep Listen
echo 'apache24_enable="YES"' >> /etc/rc.conf

#as non jail
#start apache
/usr/local/etc/rc.d/apache24 start

less /var/log/httpd-error.log
see http://192.168.0.47/

#http://forums.freenas.org/threads/php-applications-nginx-php-fpm-mysql-jail-install-and-setup.10802/
pkg_info | grep owncloud
pkg_delete owncloud
pkg_add -r owncloud-2
Please note that everything has been installed in /usr/local/www/owncloud.
service nginx start && service php-fpm start && service mysql-server start

ln -s /mnt/dpool/mysql /var/db/mysql

#http://maison-et-domotique.com/books/tutorial-installer-mysql-php-et-phpmyamin-sur-freenas/
pkg_add -r mysql50-server
mysql_upgrade (with the optional --datadir=<dbdir> flag
mysql_upgrade --datadir=/var/db/mysql

You can start the MySQL daemon with:
cd /usr/local ; /usr/local/bin/mysqld_safe &
ln -s /var/db/mysql/mysql /usr/local/libexec/

/usr/local/bin/mysqltest

mysql -u root -p
#change root pass
#mysqladmin -u root -p'.microsoft.' password microsoft
echo 'mysql_enable="YES"' >> /etc/rc.conf

/usr/local/bin/mysqladmin -u root password microsoft
/usr/local/bin/mysqladmin -u root -h freenas.local password microsoft

telnet localhost 3306

#http://www.iceflatline.com/2011/11/how-to-install-apache-mysql-php-and-phpmyadmin-on-freebsd/
fetch http://sourceforge.net/projects/phpmyadmin/files/phpMyAdmin/4.0.5/phpMyAdmin-4.0.5-english.tar.gz
tar -zxvf phpMyAdmin-4.0.5-english.tar.gz

ln -s /app/phpMyAdmin /usr/local/www/phpMyAdmin
http://192.168.0.47/phpMyAdmin/

cd /usr/ports/databases/phpmyadmin/
make config
make install clean

#install php5
http://forums.freenas.org/threads/installing-apache-2-2-mysql-5-5-php-5-4-11-into-plugin-jail.11519/
/usr/local/etc/rc.d/apache22 stop
/usr/local/etc/rc.d/apache22 restart
php -v

cd /usr/ports/lang/php5 && make config
make install clean

#--enable-zip for owncloud
cd /usr/ports/lang/php5-extensions && make config
make install clean

cd /usr/local/www/apache22/data
ln -s ../../owncloud owncloud
ln -s ../../phpMyAdmin phpMyAdmin

vi /usr/local/etc/apache22/httpd.conf

AddType application/x-httpd-php .php
AddType application/x-httpd-php-source .phps

Alias /phpmyadmin "/usr/local/www/phpMyAdmin"

<Directory "/usr/local/www/phpMyAdmin">
Options None
AllowOverride None
Require all granted
</Directory>

Alias /owncloud "/usr/local/www/owncloud"

<Directory "/usr/local/www/owncloud">
Options None
AllowOverride None
Require all granted
</Directory>

#owncloud
http://forums.freenas.org/threads/owncloud-setup.9177/
#cd /usr/ports/www/owncloud/ && make install clean

<?php
$CONFIG = array(
"datadirectory" => '/usr/local/www/owncloud/data',
"dbtype" => 'mysql',
"version" => '2.0.0',
"dbname" => 'owncloud',
"dbhost" => 'localhost',
"dbtableprefix" => 'oc_',
"dbuser" => 'oc_mysql_albandr',
"dbpassword" => 'aee6d111dcf016529d8c23b83161c6cf',
"installed" => true,
  "apps_paths" => array (
      0 => array (
              "path"     => OC::$SERVERROOT."/apps",
              "url"      => "/apps",
              "writable" => false,
      ),
      1 => array (
              "path"     => OC::$SERVERROOT."/apps2",
              "url"      => "/apps2",
              "writable" => true,
      ),
),
"log_type" => "owncloud",
"logfile" => "owncloud.log",
"loglevel" => "3",
"logdateformat" => "F d, Y H:i:s",
"mail_smtphost"     => "smtp.gmail.com:465",
"mail_smtpsecure"   => 'ssl',
);
?>


/mnt/dpool/jail/software/usr/local/www/owncloud/data

#hors jail
chown -R www:www /mnt/dpool/owncloud/apps2

#copy app
mv /mnt/dpool/workspace/os/freenas/ /mnt/dpool/owncloud/apps2

#hors jail
chown -R www:www /mnt/dpool/owncloud/apps2

mv /mnt/dpool/workspace/os/freenas/ /mnt/dpool/owncloud/apps2

dans le jail
chown -R www:www /usr/local/www/owncloud/apps2

#NOK mkdir /usr/pbi/minidlna-amd64/media
/usr/local/www/owncloud

#dans le jail
chown -R www:www /usr/local/www/owncloud/apps2

#mount point app
/mnt/dpool/owncloud/apps2
/usr/local/www/owncloud/apps2

#mount point media
/mnt/dpool/media
/usr/local/www/owncloud/data


mkdir /usr/pbi/minidlna-amd64/media
/usr/local/www/owncloud

#tomcat
pkg install tomcat7

#jenkins
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
ssh jenkins@192.168.0.46
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

#install port
portsnap fetch && portsnap extract
cd /usr/ports/java/openjdk7
make clean install

pkg install openjdk


#jdk8
cd /usr/ports/java/openjdk8
make clean install

pkg install openjdk8

ls -lrta /usr/local/openjdk8

java -version

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

cd /usr/ports/graphics/graphviz/ && make install clean
pkg install graphviz
pkg install gcc

#-Wl,-rpath=/usr/local/lib/gcc5

pkg install scons
pkg install cmake
pkg install doxygen
pkg install clang38
pkg install node
pkg install npm
pkg install firefox
pkg install chromium
pkg install hs-ShellCheck

#pkg_add -v -r maven3
#cd /usr/ports/devel/maven3/ && make install clean
pkg install maven3
#cd /usr/ports/devel/maven33/ && make install clean
pkg install maven33

mvn --version

pkg install bash
ln -s /usr/local/bin/bash /bin/bash

pkg install ruby
pkg install devel/ruby-gems
#pkg_add -v -r gtksourceview

#SSH
ssh -i OpenSSH_RSA_4096 albandri@freenas

#http://doc.freenas.org/index.php/Plugins

#nexus
http://home.nabla.mobi:8085/nexus/
http://192.168.0.24:8081/nexus

pkg install nexus2-oss
======================================================================
Message from nexus2-oss-2.14.0:
========================================================================
Nexus Repository Manager OSS 2.14.0 has been successfully installed!

To enable Nexus, add the following line to /etc/rc.conf[.local]:

  nexus2_enable="YES"

IMPORTANT: Nexus runs by default as user nexus!

Configuration
=============
* Start Nexus 'service nexus2 start'
* Open the following URL in your browser: http://localhost:8081/nexus
* Log in with the admin account 'admin/admin123', configure Nexus and
  change this password immediately!

Common Locations
================
The configuration files can be found at:
  /usr/local/etc/nexus2

The work, log, and run directories are located at:
* /var/nexus2
* /var/log/nexus2
* /var/run/nexus2

Documentation
=============
Further documentation can be found in the official Nexus Book at:
  http://books.sonatype.com/nexus-book/2.14/reference/index.html

echo 'nexus2_enable="YES"' >> /etc/rc.conf
service nexus2 start
http://192.168.0.24:8081/nexus
http://home.nabla.mobi:8085/nexus/
OLD NEXUS is http://home.nabla.mobi:8084/nexus

#zoneminder
pkg install zoneminder
The schroedinger port currently does not have a maintainer. As a result, it is
more likely to have unresolved issues, not be up-to-date, or even be removed in
the future. To volunteer to maintain this port, please create an issue at:

https://bugs.freebsd.org/bugzilla

More information about port maintainership is available at:

https://www.freebsd.org/doc/en/articles/contributing/ports-contributing.html#maintain-port
Message from opencv-core-2.4.13.1_1:
===>   NOTICE:

The opencv-core port currently does not have a maintainer. As a result, it is
more likely to have unresolved issues, not be up-to-date, or even be removed in
the future. To volunteer to maintain this port, please create an issue at:

https://bugs.freebsd.org/bugzilla

More information about port maintainership is available at:

https://www.freebsd.org/doc/en/articles/contributing/ports-contributing.html#maintain-port
Message from php56-pdo-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-pdo.ini
configuration file to automatically load the installed extension:

extension=pdo.so

****************************************************************************
Message from php56-mysql-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-mysql.ini
configuration file to automatically load the installed extension:

extension=mysql.so

****************************************************************************
Message from mysql56-client-5.6.36:
* * * * * * * * * * * * * * * * * * * * * * * *

Please be aware the database client is vulnerable
to CVE-2015-3152 - SSL Downgrade aka "BACKRONYM".
You may find more information at the following URL:

http://www.vuxml.org/freebsd/36bd352d-299b-11e5-86ff-14dae9d210b8.html

Although this database client is not listed as
"affected", it is vulnerable and will not be
receiving a patch. Please take note of this when
deploying this software.

* * * * * * * * * * * * * * * * * * * * * * * *
Message from php56-session-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-18-session.ini
configuration file to automatically load the installed extension:

extension=session.so

****************************************************************************
Message from php56-opcache-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-10-opcache.ini
configuration file to automatically load the installed extension:

zend_extension=opcache.so

****************************************************************************
Message from php56-ctype-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-ctype.ini
configuration file to automatically load the installed extension:

extension=ctype.so

****************************************************************************
Message from php56-sockets-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-sockets.ini
configuration file to automatically load the installed extension:

extension=sockets.so

****************************************************************************
Message from php56-gd-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-gd.ini
configuration file to automatically load the installed extension:

extension=gd.so

****************************************************************************
Message from php56-json-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-json.ini
configuration file to automatically load the installed extension:

extension=json.so

****************************************************************************
Message from pecl-APCu4-4.0.11:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-apcu.ini
configuration file to automatically load the installed extension:

extension=apcu.so

****************************************************************************
Message from php56-pdo_mysql-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-30-pdo_mysql.ini
configuration file to automatically load the installed extension:

extension=pdo_mysql.so

****************************************************************************
Message from zoneminder-1.30.4:
ZoneMinder is a free, open source Closed-circuit television software
application developed for Unix-like operating systems which supports
IP, USB and Analog cameras.

New installs
============

ZoneMinder requires a MySQL (or MySQL forks) database backend and
a http server, capable to execute PHP and CGI scripts.

To simplify things, we assume, that you use MySQL and NGINX on
the same server.

1. Preliminary steps

1.1 Install databases/mysql56-server or newer
    pkg install databases/mysql56-server

    -----------------------------

Message from mysql56-server-5.6.36:
*****************************************************************************

Remember to run mysql_upgrade the first time you start the MySQL server
after an upgrade from an earlier version.

Initial password for first time use of MySQL is saved in $HOME/.mysql_secret
ie. when you want to use "mysql -u root -p" first you should see password
in /root/.mysql_secret

*****************************************************************************

*****************************************************************************

Please keep in mind that the default location for my.cnf will be changed
from "/var/db/mysql/my.cnf" to "/usr/local/etc/mysql/my.cnf" in the near
future.  If you do not want to move your my.cnf to the new location then
you must set "mysql_optfile" in /etc/rc.conf to "/var/db/mysql/my.cnf".


---------------------------------

	You may choose your favourite method - ports or packages here.
	FreeBSD default setting use STRICT_TRANS_TABLES sql_mode. It's mandatory to disable it. Edit your my.cnf accordingly

	The following SQL mode should be compatible with ZM:
		sql_mode= NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION

	ZoneMinder use very simple queries, however it tends to write to
	the database quite a lot depending on your capture mode and number
	of cameras. So tweak your MySQL instance accordantly

	Now, enable and start MySQL
		sysrc mysql_server_enable="YES"
		echo 'mysql_enable="YES"' >> /etc/rc.conf
		service mysql-server onestart

1.2 Install www/nginx
	We provide an example for an HTTP install, however, you should use
	HTTPS if you plan to expose your installation to the public. There
	are plenty guides how to do it and security/letsencrypt.sh is a
	good way to get a valid SSL certificate.

	Your server block should include the following:

		server {
				root /usr/local/www/zoneminder;
				try_files $uri $uri/ /index.php$is_args$args;
				index index.php;

				location = /cgi-bin/nph-zms {
						include fastcgi_params;
						fastcgi_param   SCRIPT_FILENAME $document_root$fastcgi_script_name;
						fastcgi_pass    unix:/var/run/fcgiwrap/fcgiwrap.sock;
				}

				location ~ \.php$ {
						include fastcgi_params;
						fastcgi_param   SCRIPT_FILENAME  $document_root$fastcgi_script_name;
						fastcgi_pass    unix:/var/run/php-fpm.sock;
				}

				location /api {
						rewrite ^/api/(.+)$ /api/index.php?p=$1 last;
				}
		}

1.2.1 ZoneMinder has it's own authentication system, however it's recommend to use NGINX basic
	auth over HTTPS if you don't need fine grain control to ZoneMinder components.

1.2.2 If you choose ZoneMinder authentication, it's recommended to prohibit access to
	image and events folder as it's possible to guess file names inside it.

        location ~ ^/(?:images|events)/ {
                deny all;
        }

	Enable and start NGINX
		sysrc nginx_enable="YES"
		service nginx start

1.3 Install www/fcgiwrap
	As NGINX lacks it's own CGI wrapper, we need external one. Please
	note that ZoneMinder's montage page use simultaneous access to all
	cameras, so you need to use at least as many fcgiwrap workers as
	your number of cameras. The following example assumes you have 4.

	Enable and start FcgiWrap
		sysrc fcgiwrap_enable="YES"
		sysrc fcgiwrap_user="www"
		sysrc fcgiwrap_flags="-c 4"

1.4 PHP is installed as a dependency to ZoneMinder. However, you should
	tweak some of it's settings.
	Edit /usr/local/etc/php-fpm.conf and set

		listen = /var/run/php-fpm.sock
		listen.owner = www
		listen.group = www
		env[PATH] = /usr/local/bin:/usr/bin:/bin

	If you want to set another path for the socket file, make sure you
	change it in your NGINX config well. The env[PATH] needs to be set
	to locate the zip utility as ZoneMinder's export functions rely on
	exec(). Sorry, chroot folks.

	PHP throws warning if date.timezone option is not set. The best place
	to do it is to create new ini file in /usr/local/etc/php with overrides

		date.timezone = "UTC"

	Enable and start php-fpm
		sysrc php_fpm_enable="YES"
		service php-fpm start

1.5 ZoneMinder constantly keeps the last N frames from its cameras to
	preserve them when alarm occurs. This can be a performance hog if
	placed on spindle drive. The best practice is put it on tmpfs.
	See https://www.freebsd.org/cgi/man.cgi?query=tmpfs for more
	information.

	ZoneMinder will use /tmp for default. If you plan to change it, see
	ZM_PATH_MAP setting.

	Mapping /tmp to tmpfs is actually a recommended step under FreeBSD.
	Edit /etc/fstab and add the following:

		tmpfs			/tmp		tmpfs	rw,nosuid,mode=01777	0	0

	The size of temporary files depends on your number of cameras
	number and frames you plan to keep. My 12 3Mbit cameras with 25
	last frames consumes 6 GB.

2. ZoneMinder installation

	Connect to MySQL under root and create zm user and populate database.

	mysql -u root -p

		CREATE DATABASE zm;
		GRANT ALL PRIVILEGES ON zm.* TO 'zmuser'@'localhost' IDENTIFIED BY 'zmpass';
		FLUSH PRIVILEGES;
		quit;

	mysql -u root -p zm < /usr/local/share/zoneminder/db/zm_create.sql

2.1 If you have chosen to change the ZoneMinder MySQL credentials to something
	other than zmuser/zmpass then you must now edit /usr/local/etc/zm.conf. Change
	ZM_DB_USER and ZM_DB_PASS to the values you created in the previous step.

	Enable and start ZoneMinder
		sysrc zoneminder_enable="YES"
		service zoneminder start

Upgrades
========

1. Stop ZoneMinder
	service zoneminder stop

2. Upgrade database
	sudo -u www zmupdate.pl

3. Start ZoneMinder
	service zoneminder start

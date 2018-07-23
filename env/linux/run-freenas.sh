#!/bin/bash
set -xv

#https://www.tecmint.com/things-to-do-after-installing-freebsd/
#https://www.freshports.org/x11-servers/xorg-vfbserver/

#See http://themadindian.wolfdendesign.com/?cat=5

#TODO See https://github.com/freenas/docker-images

#wake on LAN
#https://dipisoft.com/pages/wakeonwan.php?lng=fr&tconfig=0
#7C:05:07:0E:D9:88
wakeonlan 7C:05:07:0E:D9:88

#from Shell
/etc/netcli

#WebUI
#Set nginx_enable to YES: sysrc nginx_enable=YES
#modify nginx.conf: nano /usr/local/etc/nginx/nginx.conf
#listen                  192.168.0.46:7000 default_server ssl http2;
#listen                  [::]:7000 default_server ssl http2;
#
#ssl_certificate         "/etc/certificates/freenas-pre-certui.crt";
#ssl_certificate_key     "/etc/certificates/freenas-pre-certui.key";
#listen       192.168.0.46:80;
#listen       [::]:80;
#Remove the IPv6 listen line
#Start Nginx Service: service nginx start
service nginx restart
service django restart

sqlite3 /data/freenas-v1.db "update system_settings set stg_guiprotocol = 'http';"

echo "https://192.168.0.46:7000/"
echo "https://home.nabla.mobi:7000/"
echo "https://freenas.freeboxos.fr:7000/"
#https://[fe80::160c:76ff:fe64:65dd]:7000/
https://[fe80::7e05:7ff:fe0e:d988]:7000/

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

#iscsi
#See run-hdd.sh

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

pkg upgrade

pkg install sudo

pkg install wget

pkg install ansible

pkg install python
pkg install py27-pip
pip install pygal

cd /usr/ports/security/openssh-askpass/ && make install clean
#pkg install OpenSSH-askpass
ls /usr/local/bin/ssh-askpass

#for Xvfb
pkg install xorg-vfbserver
#/usr/local/bin/Xvfb

#See https://www.freebsd.org/doc/handbook/desktop-browsers.html
pkg install firefox
#pkg install firefox-esr
pkg install chromium

npm install -g bower
npm install -g nsp
#npm install -g phantomjs-prebuilt
#npm i phantom@4.0.5 -g
npm search phantomjs

pkg install phantomjs
cd /usr/ports/lang/phantomjs/ && make install clean

pkg info phantomjs
ls -lrta /usr/local/bin/phantomjs
#ls -lrta /usr/local/lib/node_modules/

#pkg install libass
#pkg install ffmpeg

#pkg install ar-ae_fonts_mono ar-ae_fonts1_ttf croscorefonts
pkg install xterm rxvt-unicode

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

#install webmin
#See https://doxfer.webmin.com/Webmin/Installation

pkg update
pkg install webmin
/usr/local/lib/webmin/setup.sh
echo "webmin_enable="YES"" >> /etc/rc.conf
/usr/local/etc/rc.d/webmin start

admin

echo "https://192.168.0.26:10000"
echo "https://192.168.0.28:10000"
echo "https://192.168.0.23:10000"
echo "https://192.168.0.25:10000/"

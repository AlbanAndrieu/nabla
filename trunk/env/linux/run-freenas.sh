#http://www.durindel.fr/informatique/tutoriel-configuration-de-freenas

#freenas IP is 192.168.0.46

#IPv4 Default Gateway
#192.168.1.1
#Nameserver 1
#8.8.8.8
#Nameserver 2
#8.8.4.4

portsnap fetch
portsnap extract
portsnap update

tail -f  /var/log/messages

#Install PBI Plugins : http://pisethtips.blogspot.fr/2013/01/using-freenas-to-build-diy-home-server.html
#jail IP is 192.168.0.47

http://sourceforge.net/projects/freenas/files/FreeNAS-8.3.1/RELEASE-p2/x64/

#minidlna
http://192.168.0.47:8200

tail -f /mnt/dpool/jail/software/var/log/minidlna.log
#rm -Rf /mnt/dpool/jail/software/var/db/minidlna/files.db
#check issue http://forums.freenas.org/threads/mount-point-connects-to-empty-folders-cannot-get-minidlna-to-scan-media.11196/

#Firefly
http://192.168.0.47:3689/
admin 

http://192.168.0.47:9091/

#mount by hand
sudo apt-get install nfs-common
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media /media -o user=albandri
sudo umount /media/ftp
sudo umount /media/photo
sudo umount /media/music
sudo umount /media/photo
sudo umount /image
sudo umount /archive
sudo umount /jenkins-tmp
sudo umount /workspace-tmp
sudo umount /workspace/users/albandri10

#sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/ftp /media/ftp -o user=albandri
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/ftp /media/ftp 
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/photo /media/photo 
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/music /media/music
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/video /media/video
sudo mount -t zfs 192.168.0.46:/mnt/dpool/image /image 
sudo mount -t nfs 192.168.0.46:/mnt/dpool/archive /archive
sudo mount -t nfs 192.168.0.46:/mnt/dpool/backup /backup
sudo mount -t nfs 192.168.0.46:/mnt/dpool/jenkins /jenkins
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
jexec 1 /bin/tcsh
jls
pkg_add -r ftp://ftp.freebsd.org/pub/FreeBSD/ports/i386/packages-8.3-release/java/openjdk-7.2.13.tbz

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

http://doc.freenas.org/index.php/Plugins#Accessing_the_Plugins_Jail

ls -l /dev/da1*
mkdir /mnt/usb1
mount -t ntfs /dev/da1s1 /mnt/usb1/
mount_msdosfs /dev/da1s1 /mnt/usb1/
umount /mnt/usb1/

#change default shell to bash
chsh -s /usr/local/bin/bash root

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
cd /usr/ports/www/apache22
cat /usr/local/etc/apache22/httpd.conf | grep Listen
echo 'apache22_enable="YES"' >> /etc/rc.conf

#as non jail
#start apache 
/usr/local/etc/rc.d/apache22 start

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

pkg_add -v -r maven3
pkg_add -v -r apache-ant
pkg_add -v -r geany -f

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

#jenkins
pkg_add -r jenkins
http://192.168.0.47:8081
/usr/local/etc/rc.d/jenkins onestart
vi /usr/local/etc/rc.d/jenkins
/usr/local/etc/rc.d/jenkins stop
: ${jenkins_args="--webroot=${jenkins_home}/war --httpListenAddress=192.168.0.47 --httpPort=8280 --ajp13ListenAddress=192.168.0.47 --ajp13Port=8009 --prefix=/jenkins"}
echo 'jenkins_enable="YES"' >> /etc/rc.conf

tail -f /var/log/jenkins.log
tail -f /mnt/dpool/jail/software/var/log/httpd-access.log
http://192.168.0.47:8280/jenkins/

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

/usr/local/jenkins`

pkg_info | grep jenkins
#pkg_delete jenkins-1.454
cd /usr/ports/devel/jenkins/ && make install clean
ll /usr/ports/distfiles/jenkins/1.525/jenkins.war
cd /usr/local/share/jenkins/

pkg_add -v -r selenium
/usr/local/www/selenium

pkg_add -v -r ruby
pkg_add -v -r gtksourceview
/var/db/pkg/gtksourceview-1.8.5_7

pkg_delete openjdk-7.2.13
pkg_delete openjdk6-b24_4
openjdk6-b24_4

#SSH
ssh -i OpenSSH_RSA_4096 albandri@freenas

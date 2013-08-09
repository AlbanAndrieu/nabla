#http://www.durindel.fr/informatique/tutoriel-configuration-de-freenas

#freenas IP is 192.168.0.46

#IPv4 Default Gateway
#192.168.1.1
#Nameserver 1
#8.8.8.8
#Nameserver 2
#8.8.4.4

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

#sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/ftp /media/ftp -o user=albandri
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/ftp /media/ftp 
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/photo /media/photo 
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/music /media/music
sudo mount -t nfs 192.168.0.46:/mnt/dpool/media/video /media/video
sudo mount -t zfs 192.168.0.46:/mnt/dpool/image /image 
sudo mount -t nfs 192.168.0.46:/mnt/dpool/archive /archive
sudo mount -t nfs 192.168.0.46:/mnt/dpool/backup /backup
sudo mount -t nfs 192.168.0.46:/mnt/dpool/jenkins /jenkins-tmp
sudo mount -t nfs 192.168.0.46:/mnt/dpool/workspace /workspace-tmp

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
freenas:/mnt/dpool/image /image nfs rw 0 0
freenas:/mnt/dpool/archive /archive nfs rw 0 0
freenas:/mnt/dpool/backup /backup nfs rw 0 0
freenas:/mnt/dpool/jenkins /jenkins nfs rw 0 0
freenas:/mnt/dpool/workspace /workspace-tmp nfs rw 0 0
#freenas:/mnt/dpool/media/ftp  /media/ftp  zfs  defaults  0  0

#install java
ssh root@192.168.0.46

#http://doc.freenas.org/index.php/Plugins#Accessing_the_Plugins_Jail
jexec 1 /bin/tcsh
pkg_add -r ftp://ftp.freebsd.org/pub/FreeBSD/ports/i386/packages-8.3-release/java/openjdk-7.2.13.tbz

#http://orw.se/blog/index.php/install-java-on-freenas-7-3/
setenv PACKAGESITE ftp://ftp.freebsd.org/pub/FreeBSD/ports/i386/packages-8.3-release/Latest/

pkg_add -r compat6x-i386
pkg_add -r libXaw
pkg_add -r libdnet
pkg_add -r libevent
pkg_add -r libgcrypt
pkg_add -r libidn
pkg_add -r libnet11
pkg_add -r libpcap
pkg_add -r libtasn1

pkg_add -r subversion
pkg_add -r wget

pkg_add -v -r openjdk7

http://doc.freenas.org/index.php/Plugins#Accessing_the_Plugins_Jail

ls -l /dev/da1*
mkdir /mnt/usb1
mount -t ntfs /dev/da1s1 /mnt/usb1/
mount_msdosfs /dev/da1s1 /mnt/usb1/
umount /mnt/usb1/

#change default shell to bash
chsh -s /usr/local/bin/bash root

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
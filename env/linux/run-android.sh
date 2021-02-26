#!/bin/bash
set -xv

sudo apt-get install libmtp-common mtp-tools libmtp-dev libmtp-runtime libmtp9
#sudo apt-get dist-upgrade

lsusb
lsusb|grep -i samsung

sudo nano /etc/fuse.conf
# uncomment
#user_allow_other

sudo nano /lib/udev/rules.d/69-mtp.rules

# Device
#ATTR{idVendor}=="XXXX", ATTR{idProduct}=="YYYY", SYMLINK+="libmtp-%k", ENV{ID_MTP_DEVICE}="1", ENV{ID_MEDIA_PLAYER}="1"

sudo nano /etc/udev/rules.d/51-android.rules

#ATTR{idVendor}=="XXXX", ATTR{idProduct}=="YYYY", MODE="0666"

sudo service udev restart

#sudo reboot

#NOK sudo add-apt-repository ppa:samoilov-lex/aftl-stable
sudo apt-get install go-mtpfs
sudo apt-get install mtpfs mtp-tools

mtp-detect
mtp-connect
mtp-folders

jmtpfs
error returned by libusb_claim_interface() = -6LIBMTP PANIC: Unable to initialize devic
#sudo add-apt-repository ppa:atareao/atareao
#sudo apt-get install nemo-pushbullet && killall nemo

sudo apt-get install -s gphoto2 gphotofs

#dd if=/dev/sdXX of=/home/rootfs.img
gvfs-copy "mtp://[usb:004,007]/store_00010001/contacts.vcf" /home/aandrieu/Desktop/

gio copy -p "mtp://SAMSUNG_SAMSUNG_Android_3200f8e44b5ea523/Phone/DCIM/Camera/20191102_140457.jpg" /home/albandrieu/Documents/galaxy-folder

# See https://ubuntuplace.info/questions/455312/how-to-mount-usb-device-using-jmtpfs-on-linux-debian-9

#mkdir ~/Android
#go-mtpfs ~/Android
#fusermount -u ~/Android

#https://www.techrepublic.com/article/how-to-set-the-default-usb-behavior-in-android-10/
# Enable developper mode
# Enable USB Debugging
# Enable OEM Unlock

sudo apt-get install android-sdk

sudo apt-add-repository ppa:maarten-fonville/android-studio
sudo apt-get update
sudo apt-get install android-studio

sudo nano /etc/udev/rules.d/51-android.rules
SUBSYSTEM=="usb", ATTR{idVendor}=="0bb4", MODE="0666", GROUP="plugdev"
sudo chmod a+r /etc/udev/rules.d/51-android.rules

/opt/android-studio/bin/studio.sh

./run-kvm.sh

# BUG samsung android the name was not provided by any .service files
# See https://stackoverflow.com/questions/61348912/unhandled-error-message-while-accessing-android-phone-ubuntu-19-10
sudo killall nautilus

 jmtpfs --listDevices

mkdir /media/mtp
chmod a+rwx /media/mtp/
sudo umount /media/mtp
sudo jmtpfs -o allow_other /media/mtp
fusermount -u /media/mtp
mount | grep jmtpfs
jmtpfs on  /media/mtp
 type  fuse.jmtpfs      (rw,nosuid,nodev,relatime,user_id=0,group_id=0)
#SAMSUNG_SAMSUNG_Android_3200f8e44b5ea523
#sudo go-mtpfs /media/mtp/
echo "jmtpfs       /media/mtp       fuse       noauto,nodev,allow_others,rw,user,noatime       0       0" >> /etc/fstab

#/run/user/1000/gvfs/mtp:host=SAMSUNG_SAMSUNG_Android_3200f8e44b5ea523]

sudo lsblk -o name,fstype,label,size,mountpoint

#sudo dd if=/media/mtp/Phone/DCIM/Camera of=/home/albandrieu/Documents/galaxy/Phone-DCIM.bin
#error reading '/media/mtp/Phone/DCIM/Camera': Is a directory
#sudo dd if=/dev/fuse of=/home/albandrieu/Documents/galaxy/galaxy.bin

ls -lrta /dev/fuse

cd /media/mtp/Phone/DCIM/Camera

adb kill-server
# as root
adb reboot recovery
adb shell
'tar -cz /sdcard | uuencode sdcard.tar.gz' >sdcard.tar.gz.uu uudecode sdcard.tar.gz.uu

adb pull /dev/block/mmcblk0 mmcblk0.img

#Decide what partition to copy, the /dev/block/mmcblk0 partition is usually the one containing the data you typically would want.
su dd if=/dev/block/stl6 of=/sdcard/factoryfs.rfs
su
dd if=/dev/block/mmcblk0/ of=/sdcard/galaxy.bin

sdcard/DCIM/Camera/

#How to Boot into Custom Recovery (TWRP)
#adb reboot bootloader
#fastboot oem unlock

#See https://www.nextpit.fr/installer-drivers-android-adb-fastboot-windows#linux
adb backup -f FullBackup.ab -apk -all

exit 0

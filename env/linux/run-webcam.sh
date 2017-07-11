#!/bin/bash
set -xv

VBoxManage list webcams

#Prevent gvfs from starting
apt-get install gconf2
gconftool-2 --type Boolean --set /apps/nautilus/preferences/media_automount  false

#Disable webcam
#https://askubuntu.com/questions/528422/enabling-disabling-camera-from-terminal
sudo modprobe -r uvcvideo
#sudo modprobe -r videodev
#Enable webcam
sudo modprobe uvcvideo

lsof | grep video0

#http://ubuntuforums.org/showthread.php?t=1340168
#sudo aptitude remove gvfs -P
#it will diable too much things
#1)      brasero
#2)      gnome-applets
#3)      gnome-session-flashback
#4)      gvfs-backends
#5)      gvfs-fuse
#6)      nautilus
#7)      nautilus-sendto
#8)      owasp-wte-fuzzdb
#9)      software-center

#https://github.com/markvdb/diybookscanner/wiki/Software-triggering-on-Debian-GNU-Linux#avoiding-competition-for-our-cameras
#sudo apt-get remove --purge gvfs-backends
#dpkg -s gvfs-backends|grep Status
#it will disable too much things

#dynamicly enable and disable gphoto gvfs
gsettings set org.gnome.desktop.media-handling automount "false"
gsettings set org.gnome.desktop.media-handling automount-open "false"
#Obviously, to reverse:
#gsettings set org.gnome.desktop.media-handling automount "true"
#gsettings set org.gnome.desktop.media-handling automount-open "true"

gphoto2 --auto-detect

#identify webcam
lsusb -v

#install webcam security tool
sudo apt-get install motion
cd ~
mkdir .motion
sudo cp /etc/motion/motion.conf ~/.motion/motion.conf
cd ~/Dropbox
ln -s /var/lib/motion motion

sudo motion

#echo "http://localhost:8081 http://localhost:8080"
#todo 8081 TO 8082 AND 8080 TO 8083
echo "http://localhost:8082 http://localhost:8083"


sudo apt-get install wput
#on_picture_save wput ftp://user@password@server %f

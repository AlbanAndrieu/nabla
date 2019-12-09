#!/bin/bash
set -xv

#Fix broken package
#remove xorg
sudo apt-get remove xserver-xorg-video-all
sudo apt-add-repository ppa:xorg-edgers
sudo apt-get install ppa-purge
sudo ppa-purge xorg-edgers
#install xorg
sudo apt-get install compizconfig-settings-manager
#export DISPLAY=:0
#ccsm
sudo apt-get install lightdm
sudo dpkg-reconfigure lightdm
sudo apt-get install ubuntu-desktop

#Fix black screen
#http://askubuntu.com/questions/41681/blank-screen-after-installing-nvidia-restricted-driver

#Remove everything to do with the Nvidia proprietary drivers.
sudo nvidia-settings --uninstall
sudo apt-get remove --purge nvidia*
#Start from scratch.
sudo apt-get remove --purge xserver-xorg-video-nouveau xserver-xorg-video-nv xserver-xorg-video-all
Reinstall all the things!
sudo apt-get install nvidia-common
sudo apt-get install xserver-xorg-video-nouveau
sudo apt-get install --reinstall libgl1-mesa-glx libgl1-mesa-dri xserver-xorg-core
#Reconfigure the X server.
sudo dpkg-reconfigure xserver-xorg

#http://news.softpedia.com/news/How-to-Install-The-Latest-Nvidia-Driver-on-Ubuntu-12-04-295542.shtml

#reset compix and unity
gconftool-2 --recursive-unset /apps/compiz-1
#deprecated unity --reset
sudo apt-get install dconf-editor dconf-tools
wget https://launchpad.net/~amith/+archive/ubuntutools/+build/3910667/+files/unity-reset_0.1-8_all.deb
sudo dpkg --install unity-reset_0.1-8_all.deb

unity-reset
#Optionally you can reset launcher icons by executing unity --reset-icons

sudo apt-get install unity-2d
sudo apt-get install ubuntu-desktop
sudo apt-get install compizconfig-settings-manager
sudo apt-get install compiz-plugins-extra

sudo apt-get install mesa-util
glxinfo | grep OpenGL
#check you video hardware
sudo lshw -c video


sudo hwinfo --framebuffer
sudo hwinfo --monitor
lspci -vnn | grep -i VGA

Xorg -version
sudo Xorg -configure
ls /etc/X11/xorg.conf

#DO NOT INSTALL
sudo add-apt-repository ppa:ubuntu-x-swat/x-updates
sudo apt-get update
sudo apt-get dist-upgrade
sudo apt-get install nvidia-current

#STEPS TO FIX IT

#stop screen display
sudo service lightdm stop

sudo apt-get purge nvidia-current
sudo apt-get purge nvidia*
sudo apt-get install --reinstall xserver-xorg-video-intel  libgl1-mesa-glx libgl1-mesa-dri xserver-xorg-core
sudo dpkg-reconfigure xserver-xorg
sudo update-alternatives --remove gl_conf /usr/lib/nvidia-current/ld.so.conf

#login whith your user

#ubuntu login loop issue
#http://askubuntu.com/questions/314362/ubuntu-13-04-login-loop
ls -d .X*
rm ~/.Xauthority
rm ~/.profile
rm .config/monitors.xml
rm /etc/X11/xorg.conf
sudo apt-get install --reinstall xorg
sudo reboot

sudo service lightdm start

ps -ef | grep '[b]in/X'
ps -ef | grep nolisten

#X does not display
xhost + #temporary fix
/usr/bin/xhost +albandri

#https://unix.stackexchange.com/questions/110558/su-with-error-x11-connection-rejected-because-of-wrong-authentication
xauth info
xauth list
standarduser@localhost:~$ xauth list | grep unix`echo $DISPLAY | cut -c10-12` > /tmp/xauth
standarduser@localhost:~$ sudo su
root@localhost:~$ xauth add `cat /tmp/xauth`

#enter
#check graphic
nautilus
#unity

#login failed due to ATI driver issue
#check you video hardware
sudo lshw -c video

#product: Juniper XT [FirePro V5800]

#download http://support.amd.com/en-us/download/workstation?os=Linux+x86_64#catalyst-pro
#wget http://www2.ati.com/drivers/firepro/15.201.2401-linux-retail_end_user.zip
scp 15.201.2401-linux-retail_end_user.zip kdeveloper@10.25.40.85:~

#as root
unzip 15.201.2401-linux-retail_end_user.zip
cd fglrx-15.201.2401
./check.sh
./amd-driver-installer-15.201.2401-x86.x86_64.run

reboot
apt-get -f install#download http://support.amd.com/en-us/download/workstation?os=Linux+x86_64#catalyst-pro
#wget http://www2.ati.com/drivers/firepro/15.201.2401-linux-retail_end_user.zip
scp 15.201.2401-linux-retail_end_user.zip kdeveloper@10.25.40.85:~

#as root
unzip 15.201.2401-linux-retail_end_user.zip
cd fglrx-15.201.2401
./check.sh
./amd-driver-installer-15.201.2401-x86.x86_64.run

reboot
apt-get -f install

#Maximum number of clients reached
lsof -U +c 15 | cut -f1 -d' ' | sort | uniq -c | sort -rn | head -3

#sudo aptitude install tcpd
#Do not set DISPLAY in

# See https://doc.ubuntu-fr.org/xrandr

xdpyinfo | grep -e dimensions -e resolution

# Resolution
xrandr -q
#xrandr --output VGA1 --mode 800x600
#xrandr --output HDMI1 --mode 1920x1024
#xrandr --output HDMI1 --mode 2560x1440
xrandr --size 1920x1024
xrandr --size 3840x2160
xrandr --size 32:9

# check grqphic cqrt hold mode
gtf 3840 2160 144

#xrandr --newmode $(3840 2160 144 | sed -ne 's/"//g;s/ Modeline //p')
xrandr --newmode "3840x2160_144.00"  1833.14  3840 4200 4632 5424  2160 2161 2164 2347  -HSync +Vsync

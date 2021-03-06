#!/bin/bash
set -xv

#See https://doc.ubuntu-fr.org/nvidia
#https://linuxconfig.org/how-to-install-the-nvidia-drivers-on-ubuntu-19-04-disco-dingo-linux
#https://linuxconfig.org/how-to-install-the-nvidia-drivers-on-ubuntu-19-10-eoan-ermine-linux

sudo apt remove --purge nvidia-driver-435 nvidia-driver-440

ubuntu-drivers devices
#== /sys/devices/pci0000:00/0000:00:01.0/0000:01:00.0 ==
#modalias : pci:v000010DEd00001F08sv00001043sd0000868Ebc03sc00i00
#vendor   : NVIDIA Corporation
#model    : TU106 [GeForce RTX 2060 Rev. A]
#driver   : nvidia-driver-435 - distro non-free recommended
#driver   : nvidia-driver-430 - distro non-free
#driver   : xserver-xorg-video-nouveau - distro free builtin

#Check for the Available Nvidia Drivers
apt search nvidia-driver*
#nvidia-driver-435/eoan,now 435.21-0ubuntu2 amd64 [installed]

sudo apt-get install nvidia-driver-460 nvidia-settings

sudo nvidia-settings

#Add Antialiasingand Anisotropie

#Save settings to /workspace/users/albandrieu30/ansible-nabla/playbooks/templates/.nvidia-settings-rc.j2
sudo chown albandrieu:albandrieu /workspace/users/albandrieu30/ansible-nabla/playbooks/templates/.nvidia-settings-rc.j2
cp /home/albandrieu/.config/monitors.xml /workspace/users/albandrieu30/ansible-nabla/playbooks/templates/monitors.xml.j2

sudo lshw -c video

#Connaître la version des pilotes
glxinfo | grep OpenGL

#https://doc.ubuntu-fr.org/problemes_nvidia
apt-get install compizconfig-settings-manager

less Xorg.0.log
#[  1292.663] (--) NVIDIA(GPU-0): Samsung C49HG9x (DFP-1): 2660.0 MHz maximum pixel clock
#[  1292.663] (--) NVIDIA(GPU-0):
#[  1292.665] (--) NVIDIA(GPU-0): DFP-2: disconnected
#[  1292.665] (--) NVIDIA(GPU-0): DFP-2: Internal TMDS
#[  1292.665] (--) NVIDIA(GPU-0): DFP-2: 165.0 MHz maximum pixel clock
#
#1891.859] (WW) modeset(G0): Output DP-1-1: Strange aspect ratio (1196/336), consider adding a quirk
#[  1891.859] (WW) modeset(G0): Output DP-1-1: Strange aspect ratio (1196/336), consider adding a quirk
#[  1891.859] (WW) modeset(G0): Output DP-1-1: Strange aspect ratio (1196/336), consider adding a quirk
#[  1891.859] (WW) modeset(G0): Output DP-1-1: Strange aspect ratio (1196/336), consider adding a quirk

#profile added in /home/albandrieu/.nv/nvidia-application-profiles-rc

# See https://doc.ubuntu-fr.org/multi-ecran
find /sys/devices/ -iname edid
xrandr

nvidia-xconfig
ls -lrta /etc/X11/xorg.conf

# See issue
#ucsi_ccg 0-0008: failed to reset PPM!
# https://askubuntu.com/questions/1155263/new-install-desktop-ubuntu-19-04-shows-error-message-ucsi-ccg-0-0008-failed-to
# https://bugs.launchpad.net/ubuntu/+source/linux/+bug/1850238
sudo nano /etc/modprobe.d/blacklist-nvidia-usb.conf
#blacklist ucsi_ccg

./run-grub.sh

#Add unity
#sudo apt-get install lightdm

sudo apt install linux-headers-$(uname -r)

exit 0

#!/bin/bash
set -xv

#See https://doc.ubuntu-fr.org/nvidia
#https://linuxconfig.org/how-to-install-the-nvidia-drivers-on-ubuntu-19-04-disco-dingo-linux

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

sudo apt install nvidia-driver-435 nvidia-settings

sudo nvidia-settings

#Add Antialiasingand Anisotropie

#Save settings to /workspace/users/albandrieu30/ansible-jenkins-slave-docker/playbooks/templates/nvidia-albandrieu.j2
sudo chown albandrieu:albandrieu /workspace/users/albandrieu30/ansible-jenkins-slave-docker/playbooks/templates/nvidia-albandrieu.j2

sudo lshw -c video

#Connaître la version des pilotes
glxinfo | grep OpenGL

exit 0

#!/bin/bash
set -xv

sudo add-apt-repository ppa:graphics-drivers/ppa

sudo apt-get install phoronix-test-suite
phoronix-test-suite default-benchmark openarena xonotic tesseract gputest unigine-valley

sudo apt install build-essential libglvnd-dev pkg-config

sudo bash -c "echo blacklist nouveau > /etc/modprobe.d/blacklist-nvidia-nouveau.conf"
sudo bash -c "echo options nouveau modeset=0 >> /etc/modprobe.d/blacklist-nvidia-nouveau.conf"

cat /etc/modprobe.d/blacklist-nvidia-nouveau.conf

sudo update-initramfs -u

#sudo telinit 3
 
#wget https://www.nvidia.com/content/DriverDownload-March2009/confirmation.php?url=/XFree86/Linux-x86_64/435.21/NVIDIA-Linux-x86_64-435.21.run&lang=us&type=TITAN
wget https://www.nvidia.com/content/DriverDownload-March2009/confirmation.php?url=/XFree86/Linux-x86_64/440.64/NVIDIA-Linux-x86_64-440.64.run&lang=us&type=TITAN
cd ~/Downloads
#sudo bash NVIDIA-Linux-x86_64-435.21.run
sudo bash NVIDIA-Linux-x86_64-440.64.run
 
less /var/log/nvidia-installer.log

sudo reboot

exit 0

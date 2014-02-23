
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
Start from scratch.
sudo apt-get remove --purge xserver-xorg-video-nouveau xserver-xorg-video-nv xserver-xorg-video-all
Reinstall all the things!
sudo apt-get install nvidia-common
sudo apt-get install xserver-xorg-video-nouveau
sudo apt-get install --reinstall libgl1-mesa-glx libgl1-mesa-dri xserver-xorg-core
Reconfigure the X server.
sudo dpkg-reconfigure xserver-xorg
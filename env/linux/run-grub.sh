#!/bin/bash
set -xv

# See
# https://askubuntu.com/questions/1184060/ubuntu-19-10-login-loop-after-installing-proprietary-nvidia-drivers
#sudo nano /etc/default/grub
#GRUB_TIMEOUT=10
# Désactiver les fonctionnalités de la carte graphique Intel en définissant l’option « nomodeset » avant le démarrage.
#GRUB_CMDLINE_LINUX_DEFAULT="nomodset"
#GRUB_CMDLINE_LINUX_DEFAULT="quiet splash nomodset nvidia-drm.modeset=1 cgroup_enable=memory swapaccount=1"
#sudo update-grub

exit 0

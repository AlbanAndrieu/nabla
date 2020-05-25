#!/bin/bash
set -xv

#See https://remmina.org/how-to-install-remmina/

sudo apt-add-repository ppa:remmina-ppa-team/remmina-next
sudo apt update
sudo apt install remmina remmina-plugin-rdp remmina-plugin-secret

sudo killall remmina

# List available plugins
sudo apt-cache search remmina-plugin

sudo apt install remmina-plugin-rdp remmina-plugin-vnc remmina-plugin-www

#See https://www.howtogeek.com/429190/how-to-set-up-remote-desktop-on-ubuntu/

gsettings set org.gnome.Vino require-encryption false

la -lrta ~/.config/remmina/

#Backup with:
cd ~
tar -czf remmina_backup.tgz .local/share/remmina/ .config/remmina/ .local/share/keyrings .ssh/

#Restore with:
#cd ~
#tar -xf remmina_backup.tgz

#Snap users Backup with:
#cd ~
#tar -czf remmina_backup.tgz snap/remmina/<version>/.local/share/remmina/ snap/remmina/<version>/.config/remmina/ .local/share/keyrings .ssh/

# Download VNC on windows
#See https://www.realvnc.com/en/connect/download/viewer/windows

exit 0

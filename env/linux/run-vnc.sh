#!/bin/bash
set -xv

#http://doc.ubuntu-fr.org/vnc

#sudo apt-get install ubuntu-desktop tightvncserver xfce4 xfce4-goodies

#see run-ufw.sh to set up firewall

sudo apt-get install vino
cd /home/albandri/.vnc
#./startScript.sh
DISPLAY=:0 /usr/lib/vino/vino-server

sudo apt install xtightvncviewer
xtightvncviewer -viewonly -quality 5 -compresslevel 9 11.22.33.44:0
#Choose Desktop Sharing and (un)check "Allow other users to view your desktop"
#If you would like to check previous connection to your workstation
grep -i got .xsession-errors

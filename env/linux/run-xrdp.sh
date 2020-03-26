#!/bin/bash
set -xv

# See http://c-nergy.be/blog/?p=13667
./run-xrdp-install.sh -s yes

ls -lrta ~/.xsession*

# See https://medium.com/@vivekteega/how-to-setup-an-xrdp-server-on-ubuntu-18-04-89f7e205bd4e
#sudo apt-get purge xrdp

sudo ufw allow 3389/tcp

rm -f ~/.xsession*

#sudo apt-get install xfce4
#Optional stuff
#sudo apt-get install xfce4-terminal
#sudo apt-get install gnome-icon-theme-full tango-icon-theme
#echo xfce4-session > ~/.xsession
#sudo sed -i.bak '/fi/a #xrdp multiple users configuration \n xfce-session \n' /etc/xrdp/startwm.sh

#sudo apt-get install mate-core mate-desktop-environment mate-notification-daemon
#echo mate-session> ~/.xsession
#sudo sed -i.bak '/fi/a #xrdp multiple users configuration \n mate-session \n' /etc/xrdp/startwm.sh

#echo lightdm-session> ~/.xsession

#http://doc.ubuntu-fr.org/xrdp
sudo apt-get install xrdp
sudo apt-get install gnome-session-flashback
#echo "gnome-session --session=gnome-fallback" > ~/.xsession
#echo "gnome-session --session=gnome-flashback-metacity --disable-acceleration-check & gnome-panel" >~/.xsession

#echo unity > ~/.xsession
cat <<EOF > ~/.xsessionrc
export GNOME_SHELL_SESSION_MODE=ubuntu
export XDG_CURRENT_DESKTOP=ubuntu:GNOME
export XDG_CONFIG_DIRS=/etc/xdg/xdg-ubuntu:/etc/xdg
EOF

#See https://c-nergy.be/blog/?p=12469
sudo apt-get install xrdp-pulseaudio-installer
xrdp-build-pulse-modules

#See https://guacamole.apache.org/doc/0.9.0/gug/installing-guacamole.html

#sudo /etc/init.d/xrdp stop
#sudo /etc/init.d/xrdp restart
sudo systemctl restart xrdp.service
sudo systemctl status xrdp.service
sudo journalctl -xe

#configure the  VM inside VirtualBox
#https://www.youtube.com/watch?v=mFk0Stw3EZQ

#https://www.virtualbox.org/manual/ch07.html
VBoxManage modifyvm "Windows7Misys" --vrde on
VBoxManage modifyvm "Windows7Misys" --vrdeport 5000,5010-5012
VBoxManage showvminfo  "Windows7Misys"
vboxmanage modifyvm "Windows7Misys" --vrdeproperty "Security/Method=negotiate"

Display -> Remote Display
Server port : 5000
Authentification method : Guest

NAT
Port forwrding rule
RDP TCP 10 .25 .40 .139 5000 10 .0  .2  .15  3389

#In your RDP client (remmina), you must enter:
#dedicated_host_name_or_IP:RDP_port_number_of the_VM
#for instance:
localhost:5001 # if I connect a VM running on my Virtual Box server.
10.25.40.139:5000 # IP adress of my dedicated server not of the VM.

With RDP
Username : aandrieu
Domain : NABLA

Advanced -> Security : RDP
Advanced -> Disable clipboard sync

#remmina is a client to connect with RDP or VNC
rm -Rf ~/.freerdp

#http://askubuntu.com/questions/157723/cannot-rdp-to-windows-7-with-remmina-on-12-04
#When I edited the connection properties, I looked on the "advanced" tab and changed the security from "negotiate" to "TLS", and voila, everything works.
#Strangely, "negotiate" still works on the laptop, but at least I'm back in business with my bigger monitor

#Save configuration
#~/.remmina

#vino
pkill vino
export DISPLAY=:0.0
/usr/lib/vino/vino-server &
3389

#sudo apt install freerdp-x11
#xfreerdp --sec rdp -d NABLA -u aandrieu WINDOWSBOX

# Kill other session
who -u
# DO NOT MOUNT on /home user for XRDP to WORK

exit 0

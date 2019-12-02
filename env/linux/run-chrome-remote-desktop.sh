#!/bin/bash
set -xv

#See https://medium.com/@vsimon/how-to-install-chrome-remote-desktop-on-ubuntu-18-04-52d99980d83e
wget https://dl.google.com/linux/direct/chrome-remote-desktop_current_amd64.deb
apt install ./chrome-remote-desktop_current_amd64.deb

sudo usermod -a -G chrome-remote-desktop $USER
/opt/google/chrome-remote-desktop/chrome-remote-desktop --stop
/opt/google/chrome-remote-desktop/chrome-remote-desktop --start

# See https://cloud.google.com/solutions/chrome-desktop-remote-on-compute-engine?hl=fr

less  ~/.chrome-remote-desktop-session
less /opt/google/chrome-remote-desktop/chrome-remote-desktop

#echo "exec /usr/bin/lxsession -s Lubuntu -e LXDE" > ~/.chrome-remote-desktop-session

# for xfce4 
#sudo apt install --assume-yes xscreensaver
#sudo bash -c 'echo "exec /etc/X11/Xsession /usr/bin/xfce4-session" > /etc/chrome-remote-desktop-session'
#echo "exec /usr/bin/xfce4-session" > ~/.chrome-remote-desktop-session
# for cinnamon 
echo "exec /usr/bin/cinnamon-session-cinnamon2d" > ~/.chrome-remote-desktop-session

#sudo systemctl disable lightdm.service
sudo systemctl restart chrome-remote-desktop

exit 0

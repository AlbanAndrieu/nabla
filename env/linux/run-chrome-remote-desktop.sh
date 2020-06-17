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

#Choose Ubuntu (Not Unity or MATE)

# for lxde
#echo "exec /usr/bin/lxsession -s Lubuntu -e LXDE" > ~/.chrome-remote-desktop-session
# for xfce4
#sudo apt install --assume-yes xscreensaver
#sudo bash -c 'echo "exec /etc/X11/Xsession /usr/bin/xfce4-session" > /etc/chrome-remote-desktop-session'
#echo "exec /usr/bin/xfce4-session" > ~/.chrome-remote-desktop-session
# for cinnamon
#echo "exec /usr/bin/cinnamon-session-cinnamon2d" > ~/.chrome-remote-desktop-session

#sudo systemctl disable lightdm.service
sudo systemctl restart chrome-remote-desktop

gsettings get org.gnome.desktop.lockdown disable-lock-screen
gsettings set org.gnome.desktop.lockdown disable-lock-screen 'true'

#ls -lrta /usr/share/polkit-1/actions/org.freedesktop.color.policy

# See https://c-nergy.be/blog/?p=14051
# See https://askubuntu.com/questions/1193810/authentication-required-to-refresh-system-repositories-in-ubuntu-19-10
cd /etc/polkit-1/localauthority/50-local.d
nano 45-allow-colord.pkla

[Allow Colord all Users]
Identity=unix-user:*
Action=org.freedesktop.color-manager.create-device;org.freedesktop.color-manager.create-profile;org.freedesktop.color-manager.delete-device;org.freedesktop.color-manager.delete-profile;org.freedesktop.color-manager.modify-device;org.freedesktop.color-manager.modify-profile
ResultAny=no
ResultInactive=no
ResultActive=yes

nano 46-allow-update-repo.pkla

[Allow Package Management all Users]
Identity=unix-user:*
Action=org.freedesktop.packagekit.system-sources-refresh
ResultAny=yes
ResultInactive=yes
ResultActive=yes

exit 0

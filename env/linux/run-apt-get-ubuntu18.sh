#!/bin/bash
#set -xv

TRYING to upgrade my workstation

With error

Your python3 install is corrupted. Please fix the '/usr/bin/python3' symlink

TRIED:

sudo update-alternatives --remove-all python
sudo ln -sf /usr/bin/python2.7 /usr/bin/python

sudo apt-get install --reinstall python
sudo apt-get install --reinstall python3

Disable python from

.bashrc
/workspace/users/albandri30/nabla/env/home/dev.env.sh

virtualenv
#PATH="${HOME}/.linuxbrew/bin"

------------------------

/usr/bin/python3 -V
Python 3.5.2

sudo ln -sf /usr/bin/python3.5 /usr/bin/python3

ls -lrta /usr/bin/python3

update-manager -c

sudo do-release-upgrade

----------------

See https://sobrelinux.info/questions/13527/the-package-system-is-broken-after-upgraded-to-ubuntu-17-04

sudo apt autoclean
sudo -H pip uninstall click libunity-scopes1.0

cd /var/lib/dpkg/info/

sudo rm -r python3-apparmor-click.*
sudo rm -r click-apparmor.*
sudo rm -r click.*
sudo rm -r ubuntu-app-launch.*
sudo rm -r url-dispatcher-tools.*
sudo rm -r url-dispatcher:amd64.*
sudo rm -r libunity-scopes1.0:amd64

sudo apt purge python3-apparmor-click
sudo apt purge click-apparmor
sudo apt purge click
sudo apt purge ubuntu-app-launch
sudo apt purge url-dispatcher-tools
sudo apt purge url-dispatcher:amd64
sudo apt purge libunity-scopes1.0

sudo apt purge lxd

sudo apt --fix-broken install

sudo apt update

sudo apt dist-upgrade
sudo apt autoremove

-----

#Fix docker login
apt remove golang-docker-credential-helpers

sudo apt install --reinstall command-not-found

sudo ln -sf /usr/bin/python3.6 /usr/bin/python3

apt-get install --reinstall  python3-apt
apt-get install python-netaddr

python3 -m pip install --upgrade pip==9.0.3

sudo rm -rf /usr/lib/python3/dist-packages/PyYAML-*

exit 0

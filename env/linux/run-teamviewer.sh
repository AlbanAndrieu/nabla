#!/bin/bash
#set -xv

sudo apt install gdebi-core wget

wget -O ~/teamviewer.deb "https://download.teamviewer.com/download/linux/teamviewer_amd64.deb"

sudo gdebi ~/teamviewer.deb

exit 0

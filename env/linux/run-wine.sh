#!/bin/bash
set -xv

#reinstall wine
sudo add-apt-repository ppa:ubuntu-wine/ppa
sudo apt-get update
sudo apt-get upgrade # got me wine 1.3.32, but not working
rm -rf ~/.wine # wipe out entire wine directory before downgrading
sudo apt-get install wine1.2 # done :)
sudo apt-get build-dep wine

#install Bridgit client
wine BridgitLoader.exe

#Then access inside
wine /workspace/users/albandri10/.wine/drive_c/users/albandri/Application\ Data/SMART\ Technologies/Bridgit/4.6.206.0/Bridgit.exe
wineconsole /workspace/users/albandri10/.wine/drive_c/users/albandri/Application\ Data/SMART\ Technologies/Bridgit/4.6.206.0/Bridgit.exe

wine /home/albandri/.wine/drive_c/Program\ Files\ \(x86\)/Mozilla\ Firefox/firefox.exe

# See wine database
# See https://appdb.winehq.org/

# See https://itsfoss.com/use-windows-applications-linux/

# WinePrefix
# Windows applications need a C: drive. Wine uses a virtual C: drive for this purpose. The directory of this virtual C: drive is called wineprefix. First of all, we need to create a wineprefix. For doing that, fire up a terminal and enter this command:
winecfg

ls -lrta $HOME/.wine/drive_c/

sudo apt install playonlinux

wineconsole ./target/bin/x86Linux/run_app.exe

exit 0

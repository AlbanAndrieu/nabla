#!/bin/sh

#http://doc.ubuntu-fr.org/nettoyer_ubuntu
\rm -Rf /usr/share/tomcat6/.m2/repository/
\rm -Rf ~/.m2/repository/
\rm -Rf ~/.cache/*
#\rm -Rf .eclipse/*
\rm -Rf .cpan/*
\rm -Rf .svn/*
\rm -Rf .thunderbird/*
\rm -Rf .mozilla/*
\rm -Rf .config/*
\rm -f *.db
#empty trash
\rm -rf ~/.local/share/Trash/*
#google chrome
#\rm -rf ~/.config/google-chrome/Default/Web\ Data
\rm -Rf ~/.config/google-chrome/History*
#nabla
\rm -Rf ~/env/config/setEnvFiles.list.txt
find ~/.thumbnails -type f -atime +7 -exec rm {} \;

#find /var/log -type f -name '*.log' -exec chmod 664 {} \; 
 
#\rm -Rf workspace-cpp
#\rm -Rf workspace-j2ee
#\rm -Rf hudson

#find . -type f -name '*~' | xargs rm -r $1
find . -type f -name '*\.log' | xargs rm -r $1
find . -type d -name '.svn' | xargs rm -r $1
find /jenkins -type d -name 'workspace' | grep -v 'builds' | xargs rm -r $1

#find ~/ -name '*~' -print0 
find ~/ -name '*~' -type f
find ~/ -name '*~' -type f -print0 | xargs -0 rm

sudo apt-get autoclean
sudo apt-get autoremove
sudo dpkg -P `dpkg -l | grep "^rc" | tr -s ' ' | cut -d ' ' -f 2`

#Removed useless local file
#sudo apt-get install localepurge
#sudo localepurge
#in case of problem
#sudo apt-get install --reinstall locales

#current kernel
uname -r
#remove old kernel
dpkg -l | awk '{print $2}' | grep -E "linux-(image|headers)-$(uname -r | cut -d- -f1).*" | grep -v $(uname -r | sed -r -e 's:-[a-z]+.*::')
#sudo apt-get purge $(dpkg -l | awk '{print $2}' | grep -E "linux-(image|headers)-$(uname -r | cut -d- -f1).*" | grep -v $(uname -r | sed -r -e 's:-[a-z]+.*::'))

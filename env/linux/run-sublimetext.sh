#!/bin/bash
set -xv

#check scripts/svn-merge-meld.sh or scripts/svn-merge-meld.py
#check .subversion/config

#http://askubuntu.com/questions/205342/how-do-i-downgrade-to-subversion-1-6
#sudo apt-get remove libsvn1 subversion
#sudo apt-get remove subversion

#Configure javascript validation
#http://www.gavinorland.com/tutorials/installing-jshint-for-sublime-text-2/
#https://packagecontrol.io/
#http://jshint.com/install/

#Install
#JSHint Gutter
#JSONLint
#Trailing Spaces
#{
#	"trim_trailing_white_space_on_save": true,
#	"ensure_newline_at_eof_on_save": true
#}
#Emmet
#SublimeLinter
#AllAutocomplete
#Maven
#Grunt
#EditorConfig
#SublimeLinter-jscs
#less

#https://gist.github.com/thbkrkr/3194275

#See http://tipsonubuntu.com/2015/03/27/install-sublime-text-2-3-ubuntu-15-04/
#sudo add-apt-repository -y ppa:webupd8team/sublime-text-2
#sudo add-apt-repository -y ppa:webupd8team/sublime-text-3
#sudo apt-get install sublime-text-installer

#http://www.sublimetext.com/docs/3/linux_repositories.html#apt

wget -qO - https://download.sublimetext.com/sublimehq-pub.gpg | sudo apt-key add -
sudo apt-get install apt-transport-https
echo "deb https://download.sublimetext.com/ apt/stable/" | sudo tee /etc/apt/sources.list.d/sublime-text.list
sudo apt-get update
sudo apt-get install sublime-text

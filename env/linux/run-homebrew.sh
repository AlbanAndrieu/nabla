#!/bin/bash
set -xv

#See http://linuxbrew.sh/

sudo apt-get install build-essential curl file git python-setuptools ruby
#sudo yum install curl file git irb python-setuptools ruby

ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Linuxbrew/install/master/install)"

PATH="$HOME/.linuxbrew/bin:$PATH"
echo 'export PATH="$HOME/.linuxbrew/bin:$PATH"' >>~/.bash_profile

brew --version
brew doctor

exit 0

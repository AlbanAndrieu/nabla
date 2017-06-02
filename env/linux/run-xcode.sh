#!/bin/bash
set -xv

#Objective C tools

#xctool (HomeBrew installed and brew install xctool). If you are using Xcode 6, make sure to update xctool (brew upgrade xctool) to a version > 0.2.2.
#CLint installed. Version 0.8.1 recommended (HomeBrew installed and brew install https://gist.githubusercontent.com/TonyAnhTran/e1522b93853c5a456b74/raw/157549c7a77261e906fb88bc5606afd8bd727a73/oclint.rb).
#gcovr installed

sudo apt-get install gcovr
sudo apt-get install subversion git cmake lcov libssl-dev


#See brew info
#https://www.digitalocean.com/community/tutorials/how-to-install-and-use-linuxbrew-on-a-linux-vps
#brew uninstall --force oclint

brew update
#brew tap oclint/formulae
brew install FORMULA
brew install file-formula

brew install https://github.com/oclint/oclint/releases/download/v0.12/oclint-0.12-x86_64-linux-4.4.0-66-generic.tar.gz
#brew install oclint
brew upgrade oclint

brew install xctool
 
brew untap michaeldfallen/formula
 
exit 0

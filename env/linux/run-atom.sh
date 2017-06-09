#!/bin/bash
#set -xv

sudo add-apt-repository ppa:webupd8team/atom
sudo apt-get update
sudo apt-get install atom

#https://atom.io/packages/linter-shellcheck
#sudo apt install apmd xapm
apm install linter
apm install linter-shellcheck

exit 0

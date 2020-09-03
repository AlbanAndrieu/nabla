#!/bin/bash
#set -xv

sudo add-apt-repository ppa:webupd8team/atom
sudo apt-get update
sudo apt-get install atom

#https://atom.io/packages/linter-shellcheck
#sudo apt install apmd xapm
apm install linter
apm install linter-shellcheck
apm install language-jenkinsfile
apm install linter-jenkins

#https://atom.io/packages/python-debugger
apm install python-debugger language-python

apm install atom-beautify

apm install build
apm install build-scons

#pip install virtualenvwrapper

exit 0

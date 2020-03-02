#!/bin/bash
set -xv

/usr/local/bin/molecule --version

#https://github.com/ansible-community/molecule/issues/2173
#sudo yum -y remove ansible
#pip3 install ansible --user
#pip3 install "molecule[lint]" --user
#pip3 install "molecule[docker]" --user

#sudo rm -Rf /usr/local/bin/molecule
molecule check

exit 0

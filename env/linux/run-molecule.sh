#!/bin/bash
set -xv

/usr/local/bin/molecule --version

#https://github.com/ansible-community/molecule/issues/2173
#sudo yum -y remove ansible
#pip3 install ansible --user
#pip3 install "molecule[lint]" --user
#pip3 install "molecule[docker]" --user

python3 -m pip install --user ansible "ara[server]"
export ANSIBLE_CALLBACK_PLUGINS="$(python3 -m ara.setup.callback_plugins)"

python3 -m ara.setup.path
python3 -m ara.setup.action_plugins
python3 -m ara.setup.callback_plugins
python3 -m ara.setup.ansible | tee ansible.cfg
  
#sudo rm -Rf /usr/local/bin/molecule
molecule check

exit 0

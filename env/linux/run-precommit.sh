#!/bin/bash
set -xv

#See http://pre-commit.com/#advanced

# Uninstall local pre-commit, instead install it on virtualenv
sudo pip uninstall pre-commit
sudo pip3.8 uninstall pre-commit
#sudo pip install pre-commit
#sudo pip install pre-commit-hooks
sudo /opt/ansible/env38/bin/pip3.8 install pre-commit==2.7.1

/opt/ansible/env38/bin/pre-commit --version

#pre-commit install
pre-commit autoupdate

/opt/ansible/env38/bin/pre-commit run --all-files
#pre-commit run

exit 0

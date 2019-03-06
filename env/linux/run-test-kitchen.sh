#!/bin/bash
set -xv

# See https://kitchen.ci/

sudo apt-get install ruby gem -y

sudo gem install test-kitchen kitchen-vagrant kitchen-ansible kitchen-docker

#kitchen init --driver=vagrant --provisioner=ansible
kitchen init --driver=docker --provisioner=ansible

exit 0

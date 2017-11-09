#!/bin/bash
set -xv

#See https://blog.codeship.com/docker-trusted-registry/

wget -qO- 'https://pgp.mit.edu/pks/lookup?op=get&search=0xee6d536cf7dc86e2d7d56f59a178ac6c6238f52e' | sudo apt-key add --import
sudo apt-get update && sudo apt-get install apt-transport-https
sudo apt-get install -y linux-image-extra-virtual
echo "deb https://packages.docker.com/1.10/apt/repo ubuntu-trusty main" | sudo tee /etc/apt/sources.list.d/docker.list
sudo apt-get update && sudo apt-get install docker-engine

sudo bash -c "$(sudo docker run docker/trusted-registry install)"

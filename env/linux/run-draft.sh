#!/bin/bash
set -xv

brew install azure/draft/draft
#Then
wget https://azuredraft.blob.core.windows.net/draft/draft-v0.16.0-linux-amd64.tar.gz
tar- xvf draft-v0.16.0-linux-amd64.tar.gz
sudo cp linux-amd64/draft /data1/home/albandri/.linuxbrew/Cellar/draft/0.16.0/bin/

#Clean draft
#draft home
#rm -rf $(draft home)

draft version

draft init
draft create
draft config set registry docker.io/nabla
draft config list
draft up

exit 0

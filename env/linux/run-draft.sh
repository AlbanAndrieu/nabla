#!/bin/bash
set -xv

# See https://github.com/Azure/draft/tree/master/docs

brew uninstall draft helm
#brew install azure/draft/draft

#Then
wget https://azuredraft.blob.core.windows.net/draft/draft-v0.16.0-linux-amd64.tar.gz
tar -xvf draft-v0.16.0-linux-amd64.tar.gz
#sudo cp linux-amd64/draft /data1/home/albandri/.linuxbrew/Cellar/draft/0.16.0/bin/
sudo mv linux-amd64/draft /usr/local/bin/draft

#Clean draft
#draft home
#rm -rf $(draft home)

draft version

draft init
#draft init --config config-file.toml
draft pack-repo remove github.com/Azure/draft
#draft create
#draft config set registry docker.io/nabla
draft config list
draft up

#REPOS="ssh://git@10.21.200.140:7999/solint/technology.git ssh://git@10.21.200.140:7999/solint/kondor-front-packs.git ssh://git@10.21.200.140:7999/to/treasury-charts.git"
#for repo in $REPOS
#do
#    draft pack-repo add ${repo}
#done

draft pack-repo update

draft pack list

exit 0

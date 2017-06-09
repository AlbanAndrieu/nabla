#!/bin/bash
#set -xv

sudo apt install golang-go
go version

sudo mkdir -p $GOPATH/src/github.com/mitchellh && cd $!
git clone https://github.com/mitchellh/packer.git
cd packer
make bootstrap
make dev
packer -v

exit 0

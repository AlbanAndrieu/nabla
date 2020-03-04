#!/bin/bash
set -xv

#See https://github.com/boltgolt/howdy

#Issue https://github.com/boltgolt/howdy/issues/265

sudo add-apt-repository ppa:boltgolt/howdy
sudo apt update
sudo apt install howdy

sudo howdy add
#sudo howdy config
sudo -i

exit 0

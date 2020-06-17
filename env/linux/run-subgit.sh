#!/bin/bash
#set -xv

wget https://subgit.com/files/subgit_3.3.9_all.deb
sudo dpkg -i subgit_3.3.9_all.deb
sudo apt-get install -f
#
# make sure you're acting on behalf of the same user you use
# to serve Subversion repository
#
#subgit-3.3.9/bin/subgit configure --layout auto SVN_URL REPOS.GIT
#subgit-3.3.9/bin/subgit install REPOS.GIT
#git clone REPOS.GIT working-tree

exit 0

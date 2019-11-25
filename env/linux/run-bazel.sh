#!/bin/bash
#set -xv

#https://docs.bazel.build/versions/master/install-ubuntu.html

sudo apt-get install pkg-config zip g++ zlib1g-dev unzip python

echo "deb [arch=amd64] http://storage.googleapis.com/bazel-apt stable jdk1.8" | sudo tee /etc/apt/sources.list.d/bazel.list
curl https://bazel.build/bazel-release.pub.gpg | sudo apt-key add -

sudo apt-get update && sudo apt-get install bazel
sudo apt-get upgrade bazel
#sudo apt-get install --only-upgrade bazel

exit 0

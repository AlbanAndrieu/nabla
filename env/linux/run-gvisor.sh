#!/bin/bash
#set -xv

#https://github.com/google/gvisor

bazel build runsc
sudo cp ./bazel-bin/runsc/linux_amd64_pure_stripped/runsc /usr/local/bin

exit 0

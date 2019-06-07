#!/bin/bash
set -xv

sudo update-alternatives --config java
sudo update-alternatives --config javac
#sudo update-java-alternatives -s java-1.8.0-openjdk-amd64

exit 0

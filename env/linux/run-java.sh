#!/bin/bash
set -xv

sudo update-alternatives --config java
sudo update-alternatives --config javac
#sudo update-java-alternatives -s java-1.8.0-openjdk-amd64

# Donwngrade javafx to 8
sudo apt install openjfx=8u161-b12-1ubuntu2 libopenjfx-java=8u161-b12-1ubuntu2 libopenjfx-jni=8u161-b12-1ubuntu2

exit 0

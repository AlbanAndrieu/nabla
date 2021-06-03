#!/bin/bash
set -xv

sudo update-alternatives --config java
sudo update-alternatives --config javac
#sudo update-java-alternatives -s java-1.8.0-openjdk-amd64

# Donwngrade javafx to 8
#sudo apt install openjfx=8u161-b12-1ubuntu2 libopenjfx-java=8u161-b12-1ubuntu2 libopenjfx-jni=8u161-b12-1ubuntu2

sudo apt-get install openjdk-6-jdk openjdk-7-jdk

#sudo add-apt-repository ppa:webupd8team/java
sudo add-apt-repository ppa:linuxuprising/java
sudo apt-get update
#sudo apt-get install oracle-java7-installer
#sudo apt-get install oracle-java8-installer
#sudo apt-get install oracle-java11-set-default-local oracle-java11-installer-local
#sudo apt-get install oracle-java11-installer-local
#sudo apt-get install oracle-java14-installer visualvm
#sudo ln -s java-7-oracle jdk1.7.0

#Setting Java environment variables
#sudo apt-get install oracle-java8-set-default
#sudo apt-get install oracle-java14-set-default

#Switching between Oracle Java 8 and Java 7
#sudo update-java-alternatives -s java-7-oracle
#sudo update-java-alternatives -s java-8-oracle
sudo update-java-alternatives --list
sudo update-java-alternatives -s java-14-oracle
sudo update-java-alternatives -s java-1.11.0-openjdk-amd64
sudo update-java-alternatives -s java-1.8.0-openjdk-amd64

#sudo apt remove oracle-java14-set-default

exit 0

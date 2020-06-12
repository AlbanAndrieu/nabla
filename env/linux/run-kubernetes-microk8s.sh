#!/bin/bash
set -xv

#First install docker
#./run-docker.sh

#See https://wiki.debian.org/AppArmor/HowToUse
cat /sys/module/apparmor/parameters/enabled
sudo aa-status
ps auxZ | grep -v '^unconfined'

#as root
sudo snap install microk8s --classic
snap info microk8s

microk8s.status
#microk8s.kubectl
sudo snap alias microk8s.kubectl kubectl
sudo usermod -a -G microk8s albandrieu
microk8s.kubectl config view --raw > $HOME/.kube/config
#cp /root/.kube/config /home/albandrieu/.kube/

exit 0

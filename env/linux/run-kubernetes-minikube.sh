#!/bin/bash
set -xv

#Install minikube
#See https://kubernetes.io/fr/docs/setup/learning-environment/minikube/

#See https://github.com/kubernetes/minikube/releases
curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 \
  && chmod +x minikube

sudo mkdir -p /usr/local/bin/
sudo install minikube /usr/local/bin/

#minikube start --driver=<driver_name>

./run-kvm.sh

#minikube start --driver kvm2 --kvm-gpu --kvm-gpu
minikube addons enable nvidia-gpu-device-plugin
minikube addons enable nvidia-driver-installer
#minikube config set driver kvm2

egrep -q 'vmx|svm' /proc/cpuinfo && echo yes || echo no

./run-nvidia-docker.sh

#minikube start --driver=docker
#minikube config set driver docker

sudo apt-get install conntrack

minikube delete
#sudo systemctl disable kubelet.service
sudo systemctl enable kubelet.service
sudo microk8s stop
sudo lsof -i :10250
rm -Rf /tmp/juju-mk*
sudo minikube start --driver=none --apiserver-ips 127.0.0.1 --apiserver-name localhost
sudo snap unalias kubectl
kubectl create -f https://raw.githubusercontent.com/NVIDIA/k8s-device-plugin/master/nvidia-device-plugin.yml

minikube addons enable ingress
minikube ip

#TODO minikube dashboard

exit 0

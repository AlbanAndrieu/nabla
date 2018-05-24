#!/bin/bash
set -xv

#See https://kubernetes.io/docs/tasks/tools/install-kubectl/

sudo su - root
apt-get update && apt-get install -y apt-transport-https
curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | apt-key add -
cat <<EOF >/etc/apt/sources.list.d/kubernetes.list
deb http://apt.kubernetes.io/ kubernetes-xenial main
EOF
apt-get update
apt-get install -y kubectl

#sudo snap install kubectl --classic

kubectl cluster-info

#Add bash completion
#source <(kubectl completion bash)
echo "source <(kubectl completion bash)" >> ~/.bashrc

#Install minikube
#See https://github.com/kubernetes/minikube/releases
curl -Lo minikube https://storage.googleapis.com/minikube/releases/v0.26.1/minikube-linux-amd64 && chmod +x minikube && sudo mv minikube /usr/local/bin/

minikube start

#See https://kubernetes.io/docs/getting-started-guides/ubuntu/local/
sudo snap install conjure-up --classic
sudo usermod -a -G lxd $(whoami)

sudo apt install conjure-up

conjure-up kubernetes

exit 0

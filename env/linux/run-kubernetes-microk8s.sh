#!/bin/bash
set -xv

#First install docker
#./run-docker.sh

#See https://wiki.debian.org/AppArmor/HowToUse
cat /sys/module/apparmor/parameters/enabled
sudo aa-status
ps auxZ | grep -v '^unconfined'

#as root
#sudo snap remove microk8s
sudo snap install microk8s --classic
snap info microk8s

sudo ufw allow in on cni0 && sudo ufw allow out on cni0
sudo ufw default allow routed

sudo microk8s.status --wait-ready
#microk8s.kubectl
sudo snap alias microk8s.kubectl kubectl
sudo usermod -a -G microk8s albandrieu
microk8s.kubectl config view --raw > $HOME/.kube/config
#cp /root/.kube/config /home/albandrieu/.kube/

./run-kubernetes-dashboard.sh

#microk8s.enable gpu
#microk8s.enable prometheus
#user/pass: admin/admin
#microk8s.enable registry

microk8s.kubectl cluster-info
microk8s.kubectl get all

#See https://github.com/kubernetes/dashboard#getting-started
#kubectl create serviceaccount jenkins
#kubectl get serviceaccounts jenkins -o yaml
#kubectl get secret jenkins-token-hgmzw -o yaml

kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')

microk8s.kubectl get service --all-namespaces

sudo microk8s.stop


exit 0

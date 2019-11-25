#!/bin/bash
set -xv

#First install docker
#./run-docker.sh

#See https://kubernetes.io/docs/tasks/tools/install-kubectl/

#sudo su - root
sudo apt-get update && apt-get install -y apt-transport-https curl
#curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl
#chmod +x ./kubectl
#sudo mv ./kubectl /usr/local/bin/kubectl
curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | apt-key add -
cat <<EOF >/etc/apt/sources.list.d/kubernetes.list
deb http://apt.kubernetes.io/ kubernetes-xenial main
EOF
sudo apt-get update
sudo apt-get install -y kubelet kubeadm kubectl
sudo apt-mark hold kubelet kubeadm kubectl
#sudo apt-mark unhold kubelet kubeadm kubectl
#sudo snap install kubectl --classic

kubectl version
#kubectl cluster-info

#Add bash completion
#source <(kubectl completion bash)
echo "source <(kubectl completion bash)" >> ~/.bashrc

#Install minikube
#See https://github.com/kubernetes/minikube/releases
#curl -Lo minikube https://storage.googleapis.com/minikube/releases/v0.26.1/minikube-linux-amd64 && chmod +x minikube && sudo mv minikube /usr/local/bin/

#minikube start

#See https://kubernetes.io/docs/getting-started-guides/ubuntu/local/
sudo snap install conjure-up --classic
sudo usermod -a -G lxd $(whoami)

sudo apt install conjure-up

conjure-up kubernetes

#https://github.com/GoogleContainerTools/skaffold
curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-linux-amd64 && chmod +x skaffold && sudo mv skaffold /usr/local/bin

skaffold version

#https://github.com/jenkins-x/jx

curl -L https://github.com/jenkins-x/jx/releases/download/v1.2.88/jx-linux-amd64.tar.gz | tar xzv
sudo mv jx /usr/local/bin

jx version

jx completion bash > ~/.jx/bash
source ~/.jx/bash

#https://docs.helm.sh/using_helm/#installing-helm

#brew update
#brew install kubernetes-helm

sudo swapoff -a
kubeadm version
#v1.16.3
#As root
kubectl get nodes
#kubeadm reset
kubectl -n kube-system get cm kubeadm-config -oyaml
#sudo kubeadm init --pod-network-cidr=10.41.40.0/24
kubeadm init --ignore-preflight-errors=SystemVerification,IsDockerSystemdCheck,Swap

#As albandri
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config

kubectl get cs

#Run "kubectl apply -f [podnetwork].yaml" with one of the options listed at:
#  https://kubernetes.io/docs/concepts/cluster-administration/addons/

#https://www.weave.works/blog/weave-net-kubernetes-integration/

sudo kubectl apply -f "https://cloud.weave.works/k8s/net?k8s-version=$(kubectl version | base64 | tr -d '\n')"
#sudo kubectl apply -f https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml
kubectl get nodes

#NAME                       STATUS   ROLES    AGE   VERSION
#albandri.misys.global.ad   Ready    master   23h   v1.16.3

kubectl get pods --all-namespaces

sudo nano /etc/systemd/system/kubelet.service.d/10-kubeadm.conf
#NOK --cgroup-driver=system
#Add --cgroup-driver=cgroupfs
#Environment="KUBELET_EXTRA_ARGS=--fail-swap-on=false --cgroup-driver=cgroupfs"

sudo systemctl daemon-reload
sudo systemctl restart kubelet
sudo systemctl status kubelet
journalctl -xeu kubelet

#kubectl taint nodes --all node-role.kubernetes.io/master-node/vm1

#You can now join any number of machines by running the following on each node
#as root:
#albandri
kubeadm join 10.41.40.139:6443 --token wq7kbn.l21cmw4d2ko4tc9v \
    --discovery-token-ca-cert-hash sha256:2bb9aaf3624f93803dfc32106db90cdf6ea5128daab92670ba31b639cf0679f7 --ignore-preflight-errors=SystemVerification,IsDockerSystemdCheck,Swap
#albandrieu
kubeadm join 10.41.40.40:6443 --token em40d6.ork5gj1u2ngn7vmf \
    --discovery-token-ca-cert-hash sha256:dea402bcb29d4cd5e41edc7837ce9518f32272e2ad932565013213b8aacfdcc3 --ignore-preflight-errors=SystemVerification,IsDockerSystemdCheck,Swap

#See https://10.41.40.40:6443/

#See https://github.com/kubernetes/dashboard#kubernetes-dashboard
sudo kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v1.10.1/src/deploy/recommended/kubernetes-dashboard.yaml
sudo kubectl proxy
#See http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/

sudo kubectl get nodes

exit 0

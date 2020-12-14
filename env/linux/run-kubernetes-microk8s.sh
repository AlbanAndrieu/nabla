#!/bin/bash
set -xv

#First install docker
#./run-docker.sh

# See https://ubuntu.com/blog/deploying-kubernetes-locally-microk8s

#See https://wiki.debian.org/AppArmor/HowToUse
cat /sys/module/apparmor/parameters/enabled
sudo aa-status
ps auxZ | grep -v '^unconfined'

#as root
kubeadm reset
sudo apt-get purge kubeadm kubectl kubelet kubernetes-cni kube*
sudo apt-get autoremove
sudo rm -rf ~/.kube
#sudo snap remove microk8s
#sudo snap install microk8s --classic
#sudo snap install microk8s --classic --channel=1.18/stable
sudo snap refresh microk8s --classic --channel=1.19/stable
snap info microk8s

sudo ufw allow in on cni0 && sudo ufw allow out on cni0
sudo ufw default allow routed

#as root
microk8s status --wait-ready
#microk8s.kubectl
sudo snap alias microk8s.kubectl kubectl
#alias kubectl='microk8s kubectl'
alias mkctl="microk8s kubectl"
sudo usermod -a -G microk8s albandrieu
microk8s.kubectl config view --raw > $HOME/.kube/config
#cp /root/.kube/config /home/albandrieu/.kube/

#microk8s.enable gpu
#microk8s.enable prometheus
#user/pass: admin/admin
#microk8s.enable registry

microk8s.kubectl cluster-info
microk8s.kubectl get all

#Turn on the services you want
microk8s enable dashboard dns registry storage
microk8s enable gpu
#istio

microk8s kubectl port-forward -n kube-system service/kubernetes-dashboard 10443:443

./run-kubernetes-dashboard.sh

#Access the Kubernetes dashboard
#microk8s dashboard-proxy
#sudo microk8s.kubectl proxy --accept-hosts=.* --address=0.0.0.0 &

#See https://github.com/kubernetes/dashboard#getting-started
#kubectl create serviceaccount jenkins
#kubectl get serviceaccounts jenkins -o yaml
#kubectl get secret jenkins-token-hgmzw -o yaml

kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')

microk8s.kubectl get service --all-namespaces

#sudo microk8s.stop

microk8s.kubectl get nodes -o wide
microk8s add-node
# trottt
microk8s join 10.41.40.23:25000/TODO
microk8s remove-node albandrieu.com
#On albandrieu.com
microk8s leave

microk8s enable ha-cluster

# See https://github.com/ubuntu/microk8s/issues/259

kubectl config view --kubeconfig ${HOME}/.kube/config

# Creating a wrapper shell script (kubectlx) that runs kubectl with the kubeconfig option
echo -e '#!/bin/bash \nkubectl --kubeconfig=$HOME/.kube/config $@' > /snap/bin/kubectlx
# Making the wrapper shell script executable
chmod +x /snap/bin/kubectlx
# Setting a shell alias for kubectlx
echo "alias kubectl=kubectlx" >> ~/.bash_profile
#alias k='kubectlx'
echo "alias k=kubectlx" >> ~/.bash_profile
source ~/.bash_profile

kubectl config view

exit 0

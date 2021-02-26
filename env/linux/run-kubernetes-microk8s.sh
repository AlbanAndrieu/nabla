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
sudo rm -r /var/snap/microk8s
sudo snap remove eks
sudo snap remove microk8s
#sudo snap install microk8s --classic
#sudo snap install microk8s --classic --channel=1.18/stable
#sudo snap refresh microk8s --classic --channel=1.19/stable
sudo snap install microk8s --classic --channel=1.20/stable
snap info microk8s

systemctl status snap.microk8s.daemon-kubelet
sudo journalctl -u snap.microk8s.daemon-kubelet
#https://127.0.0.1:16443/apis/coordination.k8s.io/v1/namespaces/kube-node-lease/leases/albandrieu?timeout=10s
# See https://github.com/ubuntu/microk8s/issues/423
sudo systemctl restart snap.microk8s.daemon-kubelet

# See https://github.com/ubuntu/microk8s/issues/508
microk8s.stop
mv /var/snap/microk8s/common/var/lib/containerd /var/snap/microk8s/common/var/lib/_containerd
microk8s.start

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

#microk8s.enable prometheus
#user/pass: admin/admin

#sudo microk8s.enable registry:size=30Gi
#See 10.0.0.1:32000

microk8s.kubectl cluster-info
microk8s.kubectl get all

#Turn on the services you want
microk8s enable dns registry storage
#microk8s enable dashboard
microk8s enable gpu
#sudo geany /var/snap/microk8s/current/args/kubelet
--container-runtime=runtime
#--container-runtime=docker
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
echo -e '#!/bin/bash \nkubectl --kubeconfig=$HOME/.kube/config $@' > /snap/bin/kubectlxx
# Making the wrapper shell script executable
chmod +x /snap/bin/kubectlxx
# Setting a shell alias for kubectlx
echo "alias kubectl=kubectlxx" >> ~/.bash_profile
#alias k='kubectlx'
echo "alias k=kubectlxx" >> ~/.bash_profile
source ~/.bash_profile

kubectl config view

microk8s inspect
sudo lsof -i :1338
sudo lsof -i :10252

# TODO https://dev.to/musabhusaini/remote-development-with-multi-node-microk8s-cluster-and-scaffold-4o1d

#By default, the storage addon persists all volumes in
ls -lrta /var/snap/microk8s/common/default-storage

exit 0

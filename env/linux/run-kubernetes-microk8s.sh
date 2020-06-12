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

microk8s.enable dns dashboard ingress
microk8s.kubectl get all --all-namespaces
service/kubernetes-dashboard            ClusterIP      10.152.183.244
#See https://10.152.183.244/
token=$(microk8s.kubectl -n kube-system get secret | grep default-token | cut -d " " -f1)
microk8s.kubectl -n kube-system describe secret $token

#kubectl proxy
sudo microk8s.kubectl proxy --accept-hosts=.* --address=0.0.0.0 &

#See http://192.168.1.57:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/#/login
#See http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/overview?namespace=default
#See http://192.168.1.57:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/

# See https://github.com/kubernetes/dashboard/blob/master/docs/user/accessing-dashboard/1.7.x-and-above.md
# See https://logz.io/blog/getting-started-with-kubernetes-using-microk8s/
sudo microk8s.kubectl -n kube-system edit deploy kubernetes-dashboard -o yaml
# Add - --enable-skip-login

#kubectl -n kubernetes-dashboard get secret
#kubectl -n kubernetes-dashboard edit service kubernetes-dashboard

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

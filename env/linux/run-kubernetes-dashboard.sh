#!/bin/bash
set -xv

#See https://github.com/kubernetes/dashboard#kubernetes-dashboard
#kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v1.10.1/src/deploy/recommended/kubernetes-dashboard.yaml
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta6/aio/deploy/recommended.yaml
kubectl config view
#kubectl proxy
kubectl proxy --address 0.0.0.0 --port=8582 --accept-hosts '.*'
curl http://localhost:8582/api/
token=$(microk8s.kubectl -n kube-system get secret | grep default-token | cut -d " " -f1)
microk8s.kubectl -n kube-system describe secret $token
#See http://localhost:8582/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/

microk8s.enable dns dashboard ingress
microk8s.kubectl get all --all-namespaces
service/kubernetes-dashboard            ClusterIP      10.152.183.244
#See https://10.152.183.244/
token=$(microk8s.kubectl -n kube-system get secret | grep default-token | cut -d " " -f1)
microk8s.kubectl -n kube-system describe secret $token

# START dashboard
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

exit 0

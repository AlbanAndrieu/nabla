#!/bin/bash
set -xv

# See https://computingforgeeks.com/how-to-install-and-use-rancher-2-to-manage-containers-on-ubuntu-18-04-lts/

#sudo docker run -d --restart=unless-stopped -p 80:80 -p 443:443 rancher/rancher
sudo docker run -d --restart=unless-stopped -p 8580:80 -p 8581:443 rancher/rancher

#See http://150.151.160.25:8581/ https://150.151.160.25:8443/
# https://10.41.40.40:8581/

docker ps | grep apiserver
sudo docker run -d --privileged --restart=unless-stopped --net=host -v /etc/kubernetes:/etc/kubernetes -v /var/run:/var/run rancher/rancher-agent:master --server https://10.41.40.40:8581 --token fsw4vp2sdd527nrl4m7dkdkp6vr92bbdhtfkjrqvbl7gtgs459t8gc --ca-checksum 1f7895d1e84a05bb0bf85c9f633f35ac0d0ef563216ea4107f8bb16d947717be --node-name my-worker-node --address 150.151.160.25 --internal-address 150.151.160.25 --etcd --controlplane --worker --insecure-skip-tls-verify
# On 150.151.160.25
sudo docker run -d --privileged --restart=unless-stopped --net=host -v /etc/kubernetes:/etc/kubernetes -v /var/run:/var/run rancher/rancher-agent:v2.3.3 --server https://150.151.160.25:8581 --token sjwh9jqqg4l2q9qtqvlrwv82trw5hd4rhsn2cfhvrfmfwz4ft9ldw2 --ca-checksum 247f30f7d0ea1bf1d34bb064cbe66a897ed5d32fc6e8542d5c2e901365e02e92 --etcd --controlplane --worker

exit 0

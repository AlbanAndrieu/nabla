#!/bin/bash
set -xv

# See https://computingforgeeks.com/how-to-install-and-use-rancher-2-to-manage-containers-on-ubuntu-18-04-lts/

#sudo docker run -d --restart=unless-stopped -p 80:80 -p 443:443 rancher/rancher
sudo docker run -d --restart=unless-stopped -p 8580:80 -p 8581:443 rancher/rancher

#See http://150.151.160.25:8580/ https://150.151.160.25:8443/

sudo docker run -d --privileged --restart=unless-stopped --net=host -v /etc/kubernetes:/etc/kubernetes -v /var/run:/var/run rancher/rancher-agent:v2.3.3 --server https://ptxs12361:8581 --token rpllpmvg9scc2zj5vngq6h6jqs7rm4l47vtv5kw7xhc8ns8vt7phg8 --ca-checksum 7e71bcdcf656ee0fbad9efc3673f0f289ed433acee637c0d99beee8affca8120 --etcd --controlplane --worker

exit 0

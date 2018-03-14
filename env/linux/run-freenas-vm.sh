#!/bin/bash
set -xv

#See https://forums.freenas.org/index.php?threads/howto-freenas-11-1-rancheros-docker-rancherui-plex.59963/
#See http://doc.freenas.org/11/vms.html#rancher-vm-requirements

ssh -X root@192.168.0.46

cu -l /dev/nmdm4B
rancher
microsoft

sudo docker run -d --restart=unless-stopped -p 8080:8080 rancher/server

ifconfig eth0 | grep 'inet addr'

192.168.0.57:8080

sudo ros config set rancher.network.interfaces.eth0.address 10.1.2.252/24
sudo ros config set rancher.network.interfaces.eth0.gateway 10.1.2.1
sudo ros config set rancher.network.interfaces.eth0.mtu 1500
sudo ros config set rancher.network.interfaces.eth0.dhcp false

sudo service docker stop
sudo rm -Rf /var/lib/docker/
sudo curl https://releases.rancher.com/install-docker/17.12.sh | sh
sudo usermod -aG docker albandri
sudo docker run -e CATTLE_AGENT_IP="192.168.0.62"  --rm --privileged -v /var/run/docker.sock:/var/run/docker.sock -v /var/lib/rancher:/var/lib/rancher rancher/agent:v1.2.9 http://192.168.0.57:8080/v1/scripts/8884FBF882BDA048C2BB:1514678400000:wsX7Fp9jHLSJkigd4PueDYXqzA

#See template https://github.com/freenas/vm-templates
/mnt/dpool/vm-storage/nabla-ubuntu.img

cu -l /dev/nmdm3B

docker pull nabla/ansible-jenkins-slave-docker

exit 0

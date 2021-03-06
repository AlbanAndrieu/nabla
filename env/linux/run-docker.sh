#!/bin/bash
set -xv

#See https://docs.docker.com/engine/installation/linux/docker-ce/ubuntu/#set-up-the-repository

#---------------

#uninstall docker
sudo apt-get -y remove lxc-docker docker docker-engine

#---------------

#install docker
sudo apt-get -y install apt-transport-https ca-certificates curl software-properties-common python-software-properties
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu xenial stable"
sudo apt-get update
sudo apt-get -y install aufs-tools
sudo apt-get install -o Dpkg::Options::='--force-confold' --force-yes -y docker-ce

##Add CentOS repo
#sudo yum install -y yum-utils
#sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
#Install Docker
#
##If needed check key - Docker CE     060A 61C5 1B55 8A7F 742B 77AA C52F EB6B 621E 9F35
#sudo yum makecache fast
## downgrade because of dependency issue
#sudo yum downgrade policycoreutils-2.5-8.el7.x86_64
#sudo yum install docker-ce
##if it fails due to Error: Requires: container-selinux >= 2.9 install older version of docker:
#yum install -y --setopt=obsoletes=0 docker-ce-17.03.1.ce-1.el7.centos docker-ce-selinux-17.03.1.ce-1.el7.centos

#-------------

#Start docker by hand
echo manual | sudo tee /etc/init/docker.override

#-------------

#Upgrade kernel
sudo apt-get install --install-recommends linux-generic-hwe-16.04 xserver-xorg-hwe-16.04

#------------------

#See https://docs.docker.com/engine/installation/linux/linux-postinstall/#specify-dns-servers-for-docker

#check to see if you use dnsmasq
ps aux |grep dnsmasq
gksudo geany /etc/NetworkManager/NetworkManager.conf

#nano /etc/docker/daemon.json
#   {
#  "userns-remap": "jenkins",
#  "dns": ["172.17.0.1"],
#  "exec-opts": ["native.cgroupdriver=systemd"],
#  "log-driver": ["json-file"],
#  "log-opts": {
#      "max-size": "100m"
#   },
#   "debug": true
#   }
# kubernetes
sudo sh -x 'cat > /etc/docker/daemon.json <<EOF
{
  "exec-opts": ["native.cgroupdriver=cgroupfs"],
  "insecure-registries":["hostname.com"],
  "storage-driver": "overlay2",
  "debug": true,
  "insecure-registries" : ["localhost:32000"]
}
EOF'
# as root
cat > /etc/docker/daemon.json <<EOF
{
  "log-driver": "json-file",
  "exec-opts": ["native.cgroupdriver=systemd"],
  "log-opts": {
    "max-size": "100m"
  },
  "storage-driver": "overlay2",
  "icc": false,
  "userland-proxy": false,
  "no-new-privileges": true,
  "debug": true
}
EOF

# NOK "userns-remap": "default",
#  "disable-legacy-registry": true,


#nano /etc/NetworkManager/dnsmasq.d/docker-bridge.conf
#   listen-address=172.17.0.1

swapoff -a
strace -eopenat kubectl version

#Comment out the dns=dnsmasq
sudo service network-manager restart
sudo systemctl daemon-reload
sudo systemctl restart docker

#------------------

#See https://development.robinwinslow.uk/2016/06/23/fix-docker-networking-dns/
# DNS Issue check
docker run busybox nslookup google.com

#------------------

#Check firewall
sudo ufw status

#See http://philpep.org/blog/integration-continue-avec-jenkins-et-docker
sudo docker info
sudo docker version

#less /var/log/upstart/docker.log
#cat /etc/default/docker

#Add plugins
#See https://github.com/docker/docker-ce/blob/master/components/cli/docs/extend/plugins_graphdriver.md
#docker plugin install cpuguy83/docker-overlay2-graphdriver-plugin

#gksudo geany /etc/init/docker.conf /etc/systemd/system/docker.service.d/env.conf
sudo geany /lib/systemd/system/docker.service
systemctl cat docker.service

[Unit]
Description=Docker Application Container Engine
Documentation=https://docs.docker.com
BindsTo=containerd.service
After=network-online.target firewalld.service containerd.service autofs.service iscsid.service openvpn.service
Wants=network-online.target autofs.service iscsid.service openvpn.service
Requires=docker.socket

DOCKER_OPTS="-H tcp://192.168.0.29:4243 -H unix:///var/run/docker.sock"
#DOCKER_OPTS="-H tcp://192.168.0.29:4243 -H unix:///var/run/docker.sock --dns 10.21.200.3 --dns 10.25.200.3"
DOCKER_OPTS="-H tcp://192.168.0.29:4243 -H unix:///var/run/docker.sock --dns 8.8.8.8 --dns 8.8.8.4"

#For Ubuntu 16.04
ExecStart=/usr/bin/dockerd -H fd:// -H tcp://0.0.0.0:2376 -H unix:///var/run/docker.sock --dns 10.21.200.3 --dns 10.41.200.3 --data-root /docker --label provider=albandri --experimental
#ExecStart=/usr/bin/dockerd -H fd:// -H tcp://0.0.0.0:2376 -H unix:///var/run/docker.sock --dns 10.21.200.3 --dns 10.41.200.3 --data-root /docker --storage-driver overlay2 --disable-legacy-registry --tlsverify --tlscacert /root/pki/ca.pem --tlscert /etc/ssl/albandri.misys.global.ad/albandri.misys.global.ad.pem --tlskey /etc/ssl/albandri.misys.global.ad/albandri.misys.global.ad.key --label provider=albandri
#For Ubuntu 19.10 and 20
#ExecStart=/usr/bin/dockerd -H fd:// --dns 10.21.200.3 --dns 10.41.200.3 --containerd=/run/containerd/containerd.sock --data-root /docker --label provider=albandri --insecure-registry=registry.misys.global.ad --insecure-registry=albandrieu --userns-remap jenkins
Environment="HTTP_PROXY=http://192.168.1.57:3128"
Environment="HTTPS_PROXY=http://192.168.1.57:3128"
Environment="NO_PROXY=localhost,127.0.0.1,.nabla.mobi,.albandrieu.com,.azure.io"
ExecStart=/usr/bin/dockerd -H fd:// -H tcp://0.0.0.0:2376 --dns 10.21.200.3 --dns 10.41.200.3 --dns 192.168.1.1 --containerd=/run/containerd/containerd.sock --data-root /docker --label provider=albandri --insecure-registry=registry.misys.global.ad --insecure-registry=albandrieu
# -s cpuguy83/docker-overlay2-graphdriver-plugin
#For RedHat 7.4
ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:2376 -H unix:///var/run/docker.sock --data-root /docker
#For RedHat 7.7
ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock -H tcp://0.0.0.0:2376 --data-root /docker --label provider=albandri --userns-remap jenkins
# --disable-legacy-registry

#For RedHat CentOS
#See https://www.ostechnix.com/install-dnf-centos-7/

#See http://192.168.1.57:2376/version

#sudo yum install epel-release
#sudo yum install dnf

#wget http://springdale.math.ias.edu/data/puias/unsupported/7/x86_64//dnf-0.6.4-2.sdl7.noarch.rpm
#wget http://springdale.math.ias.edu/data/puias/unsupported/7/x86_64/dnf-conf-0.6.4-2.sdl7.noarch.rpm
#wget http://springdale.math.ias.edu/data/puias/unsupported/7/x86_64/python-dnf-0.6.4-2.sdl7.noarch.rpm
#yum install dnf-0.6.4-2.sdl7.noarch.rpm dnf-conf-0.6.4-2.sdl7.noarch.rpm python-dnf-0.6.4-2.sdl7.noarch.rpm

#See http://www.projectatomic.io/blog/2015/06/notes-on-fedora-centos-and-docker-storage-drivers/

#dnf install -y docker-storage-setup.noarch

#See https://docs.docker.com/storage/storagedriver/device-mapper-driver/#configure-direct-lvm-mode-for-production
sudo systemctl stop docker

yum install device-mapper-persistent-data lvm2
sudo apt-get install thin-provisioning-tools lvm2

nano /etc/docker/daemon.json

#Docker daemon log : See https://stackoverflow.com/questions/30969435/where-is-the-docker-daemon-log
sudo journalctl -fu docker.service

sudo systemctl show --property=Environment docker
sudo systemctl daemon-reload
#sudo service docker restart
sudo systemctl stop kubelet
sudo systemctl restart docker.service
sudo systemctl status docker
sudo systemctl status docker.service -l
journalctl -xe

sudo docker --tlsverify ps

ls -lrta ~/.docker/config.json
less ~/.docker/config.json
#{
#        "auths": {
#                "https://index.docker.io/v1/": {},
#                "acr.azurecr.io": {},
#                "registry-tmp.albandrieu.com": {},
#                "registry.albandrieu.com": {}
#        },
#        "HttpHeaders": {
#                "User-Agent": "Docker-Client/19.03.8 (linux)"
#        },
#        "experimental": "enabled",
#        "credsStore": "pass"
#}

#docker login 10.21.70.133
docker login registry.albandrieu.com --username=nabla

if curl http://localhost:8380/jenkins 2>/dev/null | grep -iq jenkins; then echo "FAIL"; else echo "OK"; fi

curl -o mkimage-debootstrap.sh https://raw.githubusercontent.com/dotcloud/docker/master/contrib/mkimage-debootstrap.sh
chmod +x mkimage-debootstrap.sh

./mkimage-debootstrap.sh -s wheezy64 wheezy http://ftp.fr.debian.org/debian/

#TODO
#see mkimage.sh and mkimage/debootstrap
#sudo apt-get install u-boot-tools

sudo docker images
#REPOSITORY          TAG                 IMAGE ID            CREATED              VIRTUAL SIZE
#wheezy64            wheezy              36f694c03b31        About a minute ago   116.8 MB

cat << EOF > Dockerfile
#FROM wheezy64:wheezy
FROM dockerfile/ansible

RUN apt-get install -y openssh-server openjdk-7-jre-headless
RUN groupadd jenkins
RUN useradd -m -g jenkins -s /bin/bash jenkins
RUN echo jenkins:jenkins | chpasswd
# Create the ssh host keys needed for sshd
RUN ssh-keygen -A
RUN mkdir -p /var/run/sshd
# Fix sshd's configuration for use within the container. See VW-10576 for details.
RUN sed -i -e 's/^UsePAM .*/UsePAM no/' /etc/ssh/sshd_config
RUN sed -i -e 's/^PasswordAuthentication .*/PasswordAuthentication yes/' /etc/ssh/sshd_config
# Expose the standard SSH port
EXPOSE 22
# Start the ssh daemon
CMD ["/usr/sbin/sshd -D"]
EOF

sudo docker build -t wheezy64:jenkins .

sudo docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             VIRTUAL SIZE
wheezy64            jenkins             d0efc2e8d159        13 minutes ago      333.4 MB
wheezy64            wheezy              36f694c03b31        19 minutes ago      116.8 MB

jenkins=$(sudo docker run -d -p 0.0.0.0:2223:22 -t -i wheezy64:jenkins)
ssh jenkins@localhost -p 2223
#pass is jenkins

docker kill $jenkins && docker rm $jenkins

----------------------------------

sudo docker ps -a

#since vagrant
vagrant up
vagrant ssh

#jenkins=$(sudo docker run -d -p 0.0.0.0:2223:22 -t -i dockerfile/ansible)
#sudo docker run -d -p 0.0.0.0:2222:22 -t -i dockerfile/ansible

----------------------------------
#create your own image
#sudo docker pull ubuntu
#sudo docker pull dockerfile/ansible
sudo docker pull nabla/ansible-jenkins-slave-docker

docker run --rm nabla/ansible-jenkins-slave-docker curl http://home.albandrieu.com/html/download/README.html

docker run -it nabla/ansible-jenkins-slave-docker /bin/bash
#Sample using container to buid my local workspace
docker run -t -d -w /sandbox/project-to-build -v /workspace/users/albandri30/:/sandbox/project-to-build:rw --name sandbox nabla/ansible-jenkins-slave:latest cat
#More advance sample using jenkins user on my workstation in order to get bash completion, git-radar and most of the dev tools I need
docker run -it -u 1004:999 --rm --net=host --pid=host --dns-search=albandrieu.com --init -w /sandbox/project-to-build -v /workspace/users/albandri30/:/sandbox/project-to-build:rw -v /workspace:/workspace -v /jenkins:/home/jenkins -v /etc/passwd:/etc/passwd:ro -v /etc/group:/etc/group:ro -v /etc/bash_completion.d:/etc/bash_completion.d:ro -v/data1/home/albandri/.git-radar/:/home/jenkins/.git-radar/ --name sandbox nabla/ansible-jenkins-slave:latest /bin/bash
#do you stuff
docker commit 44f8471b6047 jenkins-1
sudo docker run --rm -i -t fec8ae404140 /usr/sbin/sshd -D
sudo docker kill stupefied_albattani

#http://repo.jenkins-ci.org/releases/com/nirima/docker-plugin/0.6.1/

#docker registry http://150.151.160.25:5000
docker login 150.151.160.25:5000
docker push 150.151.160.25:5000/jenkins-2

docker ps -a | grep 'weeks ago' | awk '{print $1}' | xargs --no-run-if-empty docker rm

#bug fix for swap
#http://docs.docker.com/installation/ubuntulinux/#adjust-memory-and-swap-accounting

#Fix warning https://unix.stackexchange.com/questions/342735/docker-warning-no-swap-limit-support/408955
nano /etc/default/grub
GRUB_CMDLINE_LINUX="cgroup_enable=memory swapaccount=1"
sudo update-grub

#check disk space
gksudo baobab

#check docker space
docker system df
#docker system prune -f --volumes
docker system prune -f
docker system prune -a --volumes

#cleaning
docker stop $(docker ps -a -q) # stop all docker containers
docker rm -f $(docker ps -a -q) # remove all docker containers
docker images -q | xargs docker rmi -f # remove all docker images
#docker volume ls -f dangling=true

docker stats $(docker ps --format '{{.Names}}')

ll /var/lib/docker/tmp/docker-build*/Downloads

#https://github.com/docker/compose
sudo pip install docker-compose
docker-compose --version

docker-compose --verbose -f docker-compose-logstash.yml -p TEST up -d
docker-compose -f docker-compose-logstash.yml -p TEST ps

alias dps='docker ps --format "table {{.Names}}\t{{.Status}}"'

----------

https://github.com/kwk/docker-registry-frontend

sudo docker pull konradkleine/docker-registry-frontend

#Removing need of sudo
sudo groupadd docker
sudo gpasswd -a ${USER} docker
sudo service docker restart      # Ubuntu >= 14.04
# sudo service docker.io restart # Ubuntu < 14.04

#Accessing the in house repo
wget http://server/download/docker/ca.crt
sudo cp ca.crt /usr/local/share/ca-certificates
sudo update-ca-certificates
sudo service docker restart
sudo docker run server:5000/hello-world

#Redhat DTR
#docker pull registry.access.redhat.com/rhel7/rhel
docker pull server:5000/nabla/jdk8
docker pull server:5000/nabla/oracle
docker pull server:5000/nabla/sybase
docker pull server:5000/nabla/nabla
docker exec containername –ti /bin/bash

#http://developerblog.redhat.com/2014/09/30/overview-storage-scalability-docker/

#https://docs.docker.com/engine/userguide/storagedriver/overlayfs-driver/
#--storage-driver=overlay

docker build . -t docker/nabla/visma:latest

#Install docker-machine
#https://www.digitalocean.com/community/tutorials/how-to-provision-and-manage-remote-docker-hosts-with-docker-machine-on-ubuntu-16-04
#as root
curl -L https://github.com/docker/machine/releases/download/v0.8.2/docker-machine-`uname -s`-`uname -m` >/usr/local/bin/docker-machine && \
  chmod +x /usr/local/bin/docker-machine

#Docker completion
sudo wget https://raw.githubusercontent.com/docker/machine/master/contrib/completion/bash/docker-machine-prompt.bash -O /etc/bash_completion.d/docker-machine-prompt.bash

#Doc See https://github.com/wsargent/docker-cheat-sheet
#OR http://msoliman.me/2017/04/20/most-common-docker-commands/
#Checking container logs
docker logs sandbox
#Copying log files to the local file system
docker cp sandbox:/home/jenkins/.m2/settings.xml .
#Copying files to the container while it is running
docker cp input.csv sandbox:/tmp/
#Executing a command on a running container
docker exec -it sandbox /bin/bash
#docker exec -u 0 -it sandbox env TERM=xterm-256color bash -l
docker run -i -t --entrypoint /bin/bash sandbox
docker run -d sandbox sleep infinity

#https://blog.docker.com/2013/07/docker-desktop-your-desktop-over-ssh-running-inside-of-a-docker-container/

#network
#See https://examples.javacodegeeks.com/devops/docker/configuring-dns-docker/
docker network ls
ip address show label docker0
docker network inspect albandri30_default
docker network inspect centos_default

#Fix audit AVC apparmor="DENIED" operation="open" profile="/usr/sbin/cupsd"
#https://askubuntu.com/questions/645636/apparmor-with-cupsd-denied-in-logs

#See https://doc.ubuntu-fr.org/apparmor
sudo apt-get install apparmor-utils
#sudo aa-complain cupsd
#sudo aa-enforce cupsd

#See https://goldmann.pl/blog/2014/09/11/resource-management-in-docker/#_example_managing_the_memory_shares_of_a_container
systemd-cgls
systemd-cgtop

docker ps
docker exec -it c9076828eca8 ip addr
docker exec -it pedantic_colden sh

ssh -X jenkins@172.17.0.4 -o StrictHostKeyChecking=no
xeyes ## run an X11 demo app in the client

#Enable debug mode
#https://success.docker.com/article/how-do-i-enable-debug-logging-of-the-docker-daemon

#https://docs.docker.com/config/daemon/#read-the-logs
journalctl -u docker.service

#https://registry.albandrieu.com/docs/api
#https://registry.albandrieu.com/api/v0/repositories
#https://registry.albandrieu.com/api/v0/imagescan/status

#See https://github.com/GoogleContainerTools/container-structure-test
curl -LO https://storage.googleapis.com/container-structure-test/latest/container-structure-test-linux-amd64 && chmod +x container-structure-test-linux-amd64 && sudo mv container-structure-test-linux-amd64 /usr/local/bin/container-structure-test

#For non sudo user such as clair : docker-compose exec clairctl clairctl report -l infoslack/dvwa
#sudo chmod 666 /var/run/docker.sock
sudo setfacl -m user:jenkins:rw /var/run/docker.sock
sudo setfacl -m user:albandri:rw /var/run/docker.sock
ls -lrta /var/run/docker.sock
docker version

#Ubuntu 19.04

sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 7EA0A9C3F273FCD8
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable edge test"
sudo apt-cache policy docker-ce
sudo apt-get install -y docker-ce
sudo systemctl status docker

sudo usermod -aG docker ${USER}

sudo apt-get install -y docker-registry cadvisor
#See http://localhost:4194/containers/
nano /lib/systemd/system/cadvisor.service

docker run -it -u 1004:999 -v /etc/passwd:/etc/passwd:ro -v /etc/group:/etc/group:ro -v /var/run/docker.sock:/var/run/docker.sock --entrypoint /bin/bash fusion-risk/ansible-jenkins-slave:latest

#docker linter
# See https://github.com/hadolint/hadolint
brew install hadolint
#ls -lrta .hadolint.yaml
hadolint Dockerfile

#See https://github.com/wagoodman/dive
#wget https://github.com/wagoodman/dive/releases/download/v0.9.1/dive_0.9.1_linux_amd64.deb
#sudo apt install ./dive_0.9.1_linux_amd64.deb
brew install dive

#could not find an available, non-overlapping IPv4 address pool among the defaults to assign to the network
docker network ls
#system prune -a --volumes
docker network prune

sudo apt-get install lxc

containerd --version
#containerd containerd.io 1.2.13 7ad184331fa3e55e52b890ea95e65ba581ae3429

# Show kernel only
sudo journalctl -k

export DOCKER_CLI_EXPERIMENTAL=enabled
#Add "experimental": "enabled" to ~/.docker/config.json

docker buildx ls

# Bug : Cannot remove file: “Structure needs cleaning”
systemctl reset-failed docker.service
umount /dev/mapper/vg--sata-docker
e2fsck /dev/mapper/vg--sata-docker -y
# if not working rename folder and delete it

cd /docker/image
mv overlay2 overlay2-TODELETE
sudo service docker restart

# See https://www.digitalocean.com/community/tutorials/how-to-audit-docker-host-security-with-docker-bench-for-security-on-ubuntu-16-04
sudo systemctl restart auditd

# See https://github.com/justone/dockviz
docker pull nate/dockviz

# if docker client using local unix socket
alias dockviz="docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz"
dockviz images -t

exit 0

#!/bin/bash
set -xv

# On the host

nano /etc/environment
http_proxy="http://192.168.1.57:3128/"
https_proxy="http://192.168.1.57:3128/"
ftp_proxy="http://192.168.1.57:3128/"
no_proxy="10.1.0.0/16,10.21.191.93/24,150.151.160.25,localhost,127.0.0.1,.albandrieu.com,.nabla.mobi,.azurecr.io,.blob.core.windows.net,verdaccio"
HTTP_PROXY="http://192.168.1.57:3128/"
HTTPS_PROXY="http://192.168.1.57:3128/"
FTP_PROXY="http://192.168.1.57:3128/"
NO_PROXY="10.1.0.0/16,10.21.191.93/24,150.151.160.25,localhost,127.0.0.1,.albandrieu.com,.nabla.mobi,.azurecr.io,.blob.core.windows.net,verdaccio"

#See http://www.squid-cache.org/
export HTTP_PROXY=192.168.1.57:3128
export HTTPS_PROXY=192.168.1.57:3128
export NO_PROXY=.nabla.global.ad,.nabla.com,.nabla.global

#maven .settings.xml

<proxies>
  <proxy>
    <id>id</id>
    <active>true</active>
    <protocol>http</protocol>
    <host>192.168.1.57</host>
    <port>3128</port>
    <nonProxyHosts>artifacts.albandrieu.com|artifacts.nabla.mobi|artifacts</nonProxyHosts>
  </proxy>
</proxies>

#.npmrc

proxy=http://192.168.1.57:3128
https-proxy=http://192.168.1.57:3128
noproxy[]=nabla-npmjs
noproxy[]=nabla-npmjs.albandrieu.com
noproxy[]=nabla-npmjs.nabla.mobi

#.bowerrc

  "proxy": "http://192.168.1.57:3128",
  "https-proxy": "http://192.168.1.57:3128",
  "no-proxy": "nabla-artifacts.albandrieu.com",

#docker

nano /lib/systemd/system/docker.service

#sudo mkdir -p /etc/systemd/system/docker.service.d
#nano /etc/systemd/system/docker.service.d/http-proxy.conf
Environment="HTTP_PROXY=http://192.168.1.57:3128"
Environment="HTTPS_PROXY=http://192.168.1.57:3128"
Environment="NO_PROXY=localhost,127.0.0.1,.albandrieu.com,.nabla.mobi,.azurecr.io,.blob.core.windows.net,verdaccio"

sudo systemctl daemon-reload
sudo systemctl restart docker
sudo systemctl show --property=Environment docker

#bash

export http_proxy=http://192.168.1.57:3128
export https_proxy=http://192.168.1.57:3128
export no_proxy=localhost,127.0.0.1,.albandrieu.com,.nabla.mobi,.azure.io

#apt

sudo nano /etc/apt/apt.conf.d/proxy.conf
Acquire::http::Proxy "http://192.168.1.57:3128/";

#snap

sudo snap set system proxy.http="http://192.168.1.57:3128"
sudo snap set system proxy.https="http://192.168.1.57:3128"

#k8s

nano /var/snap/microk8s/current/args/containerd-env
HTTP_PROXY=http://192.168.1.57:3128
NO_PROXY=10.1.0.0/16,10.21.191.93/24,localhost,127.0.0.1,.albandrieu.com,.nabla.mobi,.azurecr.io,.blob.core.windows.net,verdaccio
sudo systemctl restart snap.microk8s.daemon-containerd.service

exit 0

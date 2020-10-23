#!/bin/bash
set -xv

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
    <nonProxyHosts>artifacts.nabla.global.ad|artifacts.nabla.global|artifacts</nonProxyHosts>
  </proxy>
</proxies>

#.npmrc

proxy=http://192.168.1.57:3128
https-proxy=http://192.168.1.57:3128
noproxy[]=alm-npmjs
noproxy[]=alm-npmjs.nabla.global.ad
noproxy[]=alm-npmjs.nabla.global

#.bowerrc

  "proxy": "http://192.168.1.57:3128",
  "https-proxy": "http://192.168.1.57:3128",
  "no-proxy": "alm-artifacts.nabla.global.ad",

#docker

nano /lib/systemd/system/docker.service

#sudo mkdir -p /etc/systemd/system/docker.service.d
#nano /etc/systemd/system/docker.service.d/http-proxy.conf
Environment="HTTP_PROXY=http://192.168.1.57:3128"
Environment="HTTPS_PROXY=http://192.168.1.57:3128"
Environment="NO_PROXY=localhost,127.0.0.1,.nabla.com,.nabla.global.ad,.nabla.global,.azure.io"

sudo systemctl daemon-reload
sudo systemctl restart docker
sudo systemctl show --property=Environment docker

#bash

export http_proxy=http://192.168.1.57:3128
export https_proxy=http://192.168.1.57:3128
export no_proxy=localhost,127.0.0.1,.nabla.com,.nabla.global.ad,.nabla.global,.azure.io

#apt

sudo nano /etc/apt/apt.conf.d/proxy.conf
Acquire::http::Proxy "http://192.168.1.57:3128/";

exit 0

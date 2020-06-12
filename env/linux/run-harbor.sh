#!/bin/bash
set -xv

#See https://github.com/goharbor/harbor

# https://github.com/bitnami/bitnami-docker-harbor-portal#how-to-use-this-image
curl -LO https://raw.githubusercontent.com/bitnami/bitnami-docker-harbor-portal/master/docker-compose.yml > docker-compose.harbor.yml
#docker-compose -f ./docker-compose.harbor.yml down -v
docker-compose -f ./docker-compose.harbor.yml up

curl -sSL https://raw.githubusercontent.com/bitnami/bitnami-docker-nginx/master/docker-compose.yml > docker-compose.nginx.yml

# See https://goharbor.io/docs/1.10/install-config/download-installer/

#Get https://github.com/goharbor/harbor/releases/tag/v2.0.0-rc1

gpg --keyserver hkps://keyserver.ubuntu.com --receive-keys 644FF454C0B4115C
gpg -v --keyserver hkps://keyserver.ubuntu.com --verify harbor-offline-installer-v2.0.0-rc1.tgz.asc

tar xvf harbor-offline-installer-v2.0.0-rc1.tgz

# port 6532

sudo mv harbor /opt/

#As root
pip3 install docker-compose

cd /opt/harbor
#./install.sh --with-notary --with-clair --with-chartmuseum
./install.sh  --with-clair --with-chartmuseum
#admin and Harbor12345

# See https://dev.to/mustafaops/how-to-deploy-your-own-container-regitory-4jbl

docker-compose down -v
# See doc https://goharbor.io/docs/1.10/install-config/configure-yml-file/
nano harbor.yml
./prepare --with-clair --with-chartmuseum

#sudo echo "{"insecure-registries":["albandrieu"]}" > /etc/docker/daemon.json
sudo geany /lib/systemd/system/docker.service
# Add --insecure-registry=albandrieu

sudo systemctl daemon-reload

docker-compose up -d

# See http://192.168.1.57:6532/

tail -f /var/log/harbor/registry.log

# See http://albandrieu:6532/v2/

#docker login 192.168.1.57
docker login http://albandrieu:6532
#admin
#microsoft

exit 0

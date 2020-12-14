#!/bin/bash
set -xv

#See https://github.com/quay/clair

#mkdir $PWD/clair_config
#curl -L https://raw.githubusercontent.com/coreos/clair/master/config.yaml.sample -o $PWD/clair_config/config.yaml
#docker run -d -e POSTGRES_PASSWORD="" -p 5432:5432 postgres:9.6
#docker run --net=host -d -p 6060-6061:6060-6061 -v $PWD/clair_config:/config quay.io/coreos/clair:latest -config=/config/config.yaml
mkdir -p clair/docker-compose-data/clair-config
wget https://raw.githubusercontent.com/jgsqware/clairctl/master/docker-compose.yml --directory-prefix=clair/docker-compose-data/
wget https://raw.github.com/jgsqware/clairctl/master/docker-compose-data/clair-config/config.yml --directory-prefix=clair/clair-config/
cd clair/docker-compose-data
docker-compose up

curl http://192.168.1.57:6060

docker pull infoslack/dvwa
#sudo chmod 666 /var/run/docker.sock
docker-compose exec clairctl clairctl analyze -l infoslack/dvwa
docker-compose exec clairctl clairctl report -l infoslack/dvwa

# Will target http://localhost:6060/
#sudo chown -R albandrieu:docker .

# See https://quay.github.io/clair/howto/testing.html
make local-dev-up-with-quay

docker-compose up -d quay
#postgresql:5432
# Quai is http://192.168.1.57:8080/

#make local-dev-down

wget https://github.com/arminc/clair-scanner/releases/download/v12/clair-scanner_linux_amd64
mv clair-scanner_linux_amd64 clair-scanner
chmod +x clair-scanner
docker pull debian:9.5
docker tag debian:9.5 localhost:8080/nabla/test:latest
docker login https://localhost:8080 -u ${CLAIR_USER} -p ${CLAIR_PASSWORD}
docker push localhost:8080/nabla/test:latest

docker tag registry.hub.docker.com/nabla/ansible-jenkins-slave-docker:latest localhost:8080/nabla/ansible-jenkins-slave-docker:latest
docker push localhost:8080/nabla/ansible-jenkins-slave-docker:latest

curl -u ${CLAIR_USER}:${CLAIR_PASSWORD} http://localhost:8080/v2/nabla/ansible-jenkins-slave-docker/manifests/latest

# swagger http://0.0.0.0:8082/

#./clair-scanner --ip 192.168.1.57 -c "http://192.168.1.57:32159" localhost:8080/nabla/ansible-jenkins-slave-docker:latest

#See pgadmin postgre admin http://192.168.1.57:8084/login?next=%2F

exit 0

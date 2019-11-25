#!/bin/bash
set -xv

#https://microscanner.aquasec.com/signup

#https://my.aquasec.com

#https://www.aquasec.com/wiki

docker login registry.aquasec.com -u <AQUA_USERNAME> -p <AQUA_PASSWORD>
docker pull registry.aquasec.com/scanner:4.2

#https://hub.docker.com/u/aquasec/
#https://jenkins.io/doc/pipeline/steps/aqua-security-scanner/

docker pull registry.misys.global.ad/global-bakery/aquasec-scanner-cli:latest
docker run --rm --volume ${pwd()}:/mnt --volume /var/run/docker.sock:/var/run/docker.sock registry.misys.global.ad/global-bakery/aquasec-scanner-cli:latest scan --user scanner --password password --host http://fr1cslbmts0304:8080 --local --direct-cc --jsonfile /mnt/test.AquaSec --htmlfile /mnt/test registry.misys.global.ad/fusion-risk/ansible-jenkins-slave-test:latest

exit 0

#!/bin/bash
#set -xv

#See https://conan.io/

pip install conan

git clone https://github.com/sonatype-nexus-community/nexus-repository-conan.git
cd nexus-repository-conan
mvn clean package -PbuildKar
sudo cp target/nexus-repository-conan-0.0.6.jar /usr/local/nexus/nexus/deploy/
sudo chown nexus:nexus /usr/local/nexus/nexus/deploy/nexus-repository-conan-0.0.6.jar

# See https://docs.conan.io/en/latest/systems_cross_building/cross_building.html
#git clone https://github.com/memsharded/conan-hello.git
#cd conan-hello && conan create . conan/testing --profile ../linux_to_win64

exit 0

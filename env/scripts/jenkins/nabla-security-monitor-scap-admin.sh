#!/bin/bash

echo ########### Check Docker disk space usage #######

sudo docker ps -a -s

echo ########### Check Docker images tree #######

#See https://github.com/justone/dockviz
alias dockviz="sudo docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz"
dockviz images -t

dockviz containers -d | dot -Tpng -o containers.png
dockviz images --dot --only-labelled | dot -Tpng -o images.png

echo ########### Check Docker security #######

sudo docker run -it --net host --pid host --cap-add audit_control \
    -v /var/lib:/var/lib \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v /usr/lib/systemd:/usr/lib/systemd \
    -v /etc:/etc --label docker_bench_security \
    docker/docker-bench-security

echo ########### Check ubuntu security #######

#See https://github.com/GovReady/ubuntu-scap
#sudo apt-get install libopenscap8
#cd /workspace/users/albandri30/
git clone https://github.com/GovReady/ubuntu-scap.git
cd ubuntu-scap
./run_tests.sh

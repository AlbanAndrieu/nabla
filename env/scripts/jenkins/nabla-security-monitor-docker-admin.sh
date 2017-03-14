#!/bin/bash
set -xv

echo ########### Check Docker disk space usage #######

#Thre reference
sudo -t docker history hello-world:latest

sudo -t docker ps -a -s

echo ########### Check Docker images tree #######

#See https://github.com/justone/dockviz
alias dockviz="sudo docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz"
sudo -t docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz images -t
sudo -t docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz containers -d | dot -Tpng -o containers.png
sudo -t docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz images --dot --only-labelled | dot -Tpng -o images.png

echo ########### Check Docker security #######

sudo -t docker run -it --net host --pid host --cap-add audit_control \
    -v /var/lib:/var/lib \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v /usr/lib/systemd:/usr/lib/systemd \
    -v /etc:/etc --label docker_bench_security \
    docker/docker-bench-security

echo ########### Check ubuntu security #######

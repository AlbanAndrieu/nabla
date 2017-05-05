#!/bin/bash
#set -xv

red='\e[0;31m'
green='\e[0;32m'
NC='\e[0m' # No Color

echo ########### Check Docker disk space usage #######

#The reference
#docker history hello-world:latest

docker run docker/whalesay cowsay boo

docker ps -a -s

echo ########### Check Docker images tree #######

#See https://github.com/justone/dockviz
alias dockviz="sudo docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz"
docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz images -t
docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz containers -d | dot -Tpng -o containers.png
docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz images --dot --only-labelled | dot -Tpng -o images.png

echo ########### Check Docker security #######

docker run -it --net host --pid host --cap-add audit_control \
    -v /var/lib:/var/lib \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v /usr/lib/systemd:/usr/lib/systemd \
    -v /etc:/etc --label docker_bench_security \
    docker/docker-bench-security

echo ########### Check ubuntu security #######

exit 0

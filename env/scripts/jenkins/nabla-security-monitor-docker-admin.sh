#!/bin/bash
#set -xve

./step-2-0-0-build-env.sh

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} Check Docker disk space usage${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#The reference
#docker history hello-world:latest

docker run docker/whalesay cowsay boo

docker ps -a -s

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} Check Docker images tree${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

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

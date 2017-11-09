#!/bin/bash
#set -xve

source ./step-2-0-0-build-env.sh

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

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} Check Docker security${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

docker run -it --net host --pid host --cap-add audit_control \
    -v /var/lib:/var/lib \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v /usr/lib/systemd:/usr/lib/systemd \
    -v /etc:/etc --label docker_bench_security \
    docker/docker-bench-security

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} Check more Docker disk space usage${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

docker history docker/whalesay
#docker diff todo

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} Check Docke Engine${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

if [ -f check-config.sh ]; then
  echo -e "Poodle file found"
else
  curl https://raw.githubusercontent.com/docker/docker/master/contrib/check-config.sh > check-config.sh
fi
bash check-config.sh

exit 0

#!/bin/bash
set -xv

echo ########### Check Docker disk space usage #######

#The reference
#docker history hello-world:latest

docker run docker/whalesay cowsay boo

docker ps -a -s
#docker stats --all

echo ########### Check Docker images tree #######

#See https://github.com/justone/dockviz
#alias dockviz="sudo docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock nate/dockviz"
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

echo ########### Check more Docker disk space usage #######

docker history nabla/ansible-jenkins-slave-docker:latest
#docker diff sandbox

echo ########### Check more Docker Engine #######

# See https://blog.hypriot.com/post/verify-kernel-container-compatibility/

if [ -f check-config.sh ]; then
  echo -e "check-config.sh"
else
  curl https://raw.githubusercontent.com/docker/docker/master/contrib/check-config.sh > check-config.sh
fi
bash check-config.sh || true

# extract the .config from a running kernel
#zcat /proc/config.gz > kernel.config

exit 0

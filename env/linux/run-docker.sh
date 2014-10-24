
---------------

#See http://philpep.org/blog/integration-continue-avec-jenkins-et-docker
sudo docker info

less /var/log/upstart/docker.log
cat /etc/default/docker
#NOK DOCKER_OPTS="-H 127.0.0.1:4243 -H unix:///var/run/docker.sock"
#NOK DOCKER_OPTS="-H albandri.misys.global.ad:4243 -H unix:///var/run/docker.sock"
DOCKER_OPTS="-H tcp://10.25.40.139:4243 -H unix:///var/run/docker.sock"
DOCKER_OPTS="-H tcp://10.25.40.139:4243 -H unix:///var/run/docker.sock --dns 10.21.200.3 --dns 10.25.200.3"

if curl http://localhost:8380/jenkins 2>/dev/null | grep -iq jenkins; then echo "FAIL"; else echo "OK"; fi

curl -o mkimage-debootstrap.sh https://raw.githubusercontent.com/dotcloud/docker/master/contrib/mkimage-debootstrap.sh
chmod +x mkimage-debootstrap.sh

./mkimage-debootstrap.sh -s wheezy64 wheezy http://ftp.fr.debian.org/debian/

#TODO
#see mkimage.sh and mkimage/debootstrap
#sudo apt-get install u-boot-tools

sudo docker images
#REPOSITORY          TAG                 IMAGE ID            CREATED              VIRTUAL SIZE
#wheezy64            wheezy              36f694c03b31        About a minute ago   116.8 MB

cat << EOF > Dockerfile
#FROM wheezy64:wheezy
FROM dockerfile/ansible

RUN apt-get install -y openssh-server openjdk-7-jre-headless
RUN groupadd jenkins
RUN useradd -m -g jenkins -s /bin/bash jenkins
RUN echo jenkins:jenkins | chpasswd
# Create the ssh host keys needed for sshd
RUN ssh-keygen -A
RUN mkdir -p /var/run/sshd
# Fix sshd's configuration for use within the container. See VW-10576 for details.
RUN sed -i -e 's/^UsePAM .*/UsePAM no/' /etc/ssh/sshd_config
RUN sed -i -e 's/^PasswordAuthentication .*/PasswordAuthentication yes/' /etc/ssh/sshd_config
# Expose the standard SSH port
EXPOSE 22
# Start the ssh daemon
CMD ["/usr/sbin/sshd -D"]
EOF

sudo docker build -t wheezy64:jenkins .

sudo docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             VIRTUAL SIZE
wheezy64            jenkins             d0efc2e8d159        13 minutes ago      333.4 MB
wheezy64            wheezy              36f694c03b31        19 minutes ago      116.8 MB

jenkins=$(sudo docker run -d -p 0.0.0.0:2223:22 -t -i wheezy64:jenkins)
ssh jenkins@localhost -p 2223
#pass is jenkins

docker kill $jenkins && docker rm $jenkins

----------------------------------

sudo docker ps -a

#since vagrant
vagrant up
vagrant ssh

#jenkins=$(sudo docker run -d -p 0.0.0.0:2223:22 -t -i dockerfile/ansible)
#sudo docker run -d -p 0.0.0.0:2222:22 -t -i dockerfile/ansible

----------------------------------
#create your own image
#sudo docker pull ubuntu
sudo docker pull dockerfile/ansible

sudo docker run -i -t 9e67d9bdac37 /bin/bash
#do you stuff
docker commit 44f8471b6047 jenkins-1
sudo docker run -i -t fec8ae404140 /usr/sbin/sshd -D
sudo docker kill stupefied_albattani

#http://repo.jenkins-ci.org/releases/com/nirima/docker-plugin/0.6.1/

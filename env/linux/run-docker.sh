
---------------

#See http://philpep.org/blog/integration-continue-avec-jenkins-et-docker
sudo docker info

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
FROM wheezy64:wheezy

RUN apt-get install -y openssh-server openjdk-7-jre-headless
RUN useradd -m -s /bin/bash jenkins
RUN echo jenkins:jenkins | chpasswd
RUN mkdir -p /var/run/sshd
EXPOSE 22
CMD /usr/sbin/sshd -D
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

sudo docker ps

#since vagrant
vagrant up
vagrant ssh

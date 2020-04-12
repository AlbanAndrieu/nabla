#!/bin/bash
#set -x

#https://serverfault.com/questions/680804/how-do-i-find-out-if-a-uid-exists

CURRENT_UID=$(id -u):$(id -g)
echo "CURRENT_UID: ${CURRENT_UID}"

JENKINS_USER_HOME=${JENKINS_USER_HOME:-/home/jenkins}
DOCKER_USER=${DOCKER_USER:-jenkins}
DOCKER_GROUP=${DOCKER_GROUP:-docker}
DOCKER_UID=${DOCKER_UID:-2000}
DOCKER_GID=${DOCKER_GID:-2000}
printf "\033[1;32mFROM UID:GID: ${DOCKER_UID}:${DOCKER_GID}- JENKINS_USER_HOME: ${JENKINS_USER_HOME} \033[0m\n" && \
printf "\033[1;32mWITH user: $DOCKER_USER\ngroup: $DOCKER_GROUP \033[0m\n"

# Add user jenkins to the image
printf "\033[1;32msudo groupadd -g ${DOCKER_GID} ${DOCKER_GROUP} \033[0m\n"

#echo groupmod -g ${GID} docker
#RUN cat /etc/group | grep docker || true
#RUN id docker
getent passwd 2000 || true

printf "\033[1;32msudo adduser --uid ${DOCKER_UID} --gid ${DOCKER_GID} --home ${JENKINS_USER_HOME} --shell /bin/bash ${DOCKER_USER} -c \"${DOCKER_USER} nabla\" --disabled-login \033[0m\n" #--quiet --disabled-password --encrypt-home
#echo sudo useradd -m -g jenkins --shell /bin/bash jenkins -u 2000 -g 2000 -G jenkins,docker
echo "Set password for the jenkins user (you may want to alter this)"
#echo "jenkins:jenkins1234" | chpasswd
printf "\033[1;32msudo usermod -a -G ${DOCKER_GROUP} ${DOCKER_USER} \033[0m\n"

id ${DOCKER_USER}

echo "Add current user to docker group"
printf "\033[1;32msudo usermod -a -G ${DOCKER_GROUP} ${USER} \033[0m\n"

id ${USER}
#uid=1000(albandrieu) gid=1000(albandrieu) groups=1000(albandrieu),4(adm),24(cdrom),27(sudo),30(dip),46(plugdev),119(lpadmin),130(lxd),131(sambashare)
echo "Add nexus user"
printf "\033[1;32msudo useradd --no-create-home --system -s /sbin/nologin nexus -c \"Nexus nabla\" -u 1001 -G root,docker \033[0m\n"

echo "Add media group"
sudo groupadd -g 8675309 media
"sudo usermod -a -G media ${USER}"
sudo groupadd -g 80 www
# sudo groupadd -g 34 bower # used by backup
#sudo groupadd -g 125 mysql # used by _rpc
#mysql user 116
#sudo groupadd -g 131 jenkins # used by nm-openconnect
sudo groupadd -g 1001 tomcat7
sudo groupadd -g 666 webdav
sudo groupadd -g 1002 docker
sudo usermod -a -G docker albandri
sudo usermod -a -G docker albandrieu
sudo usermod -a -G www-data albandrieu
sudo usermod -a -G docker nexus3

#To assign a new UID to user called foo, enter:
#sudo usermod -u 117 jenkins

#To assign a new GID to group called docker, enter:
#sudo groupmod -g 2000 docker

# TODO do not mount albandri AND albandrieu to /home, xrdp will not work

#Disable kerberos
pam-auth-update

# User jenkins specific for docker run
#sudo chmod -R 777 /home/jenkins/.config/configstore/
sudo chmod -R 777 /jenkins/.config/
sudo chmod 777 /jenkins/.cache/

sudo mkdir -p /jenkins/.local/share/bower/
#sudo chmod 777 /home/jenkins/.local/share/bower/
sudo chmod 777 /jenkins/.local/
sudo chmod 777 /jenkins/.local/share/
sudo chmod 777 /jenkins/.local/share/bower/

sudo ln -s /docker /var/lib/docker
sudo ln -s /jenkins /var/lib/jenkins

exit 0

# Ansible managed: /workspace/users/albandri10/env/ansible/roles/zap/templates/Dockerfile.j2 modified on 2014-09-30 23:50:06 by albandri on albandri-laptop-misys
#FROM        debian:jessie
#FROM        stackbrew/ubuntu:14.04
FROM        jasongiedymin/ansible-base-ubuntu

# Volume can be accessed outside of container
VOLUME      [/usr/local/zap]

MAINTAINER  Alban Andrieu "https://github.com/AlbanAndrieu"

ENV			DEBIAN_FRONTEND noninteractive
ENV         JENKINS_HOME /usr/local/zap/zap-2.3.1

# Working dir
WORKDIR /home/vagrant

# COPY
#COPY

# ADD
ADD defaults $WORKDIR/defaults
ADD meta $WORKDIR/meta
#ADD files $WORKDIR/files
ADD handlers $WORKDIR/handlers
ADD tasks $WORKDIR/tasks
ADD templates $WORKDIR/templates
#ADD vars $WORKDIR/vars

# Here we continue to use add because
# there are a limited number of RUNs
# allowed.
ADD hosts /etc/ansible/hosts
ADD playbook.yml $WORKDIR/playbook.yml -vvvv

# Execute
RUN         ansible-playbook $WORKDIR/playbook.yml -i $WORKDIR/hosts -c local

#RUN         apt-get update && \
#            apt-get install -y openssh-server openjdk-7-jre-headless
#RUN         useradd -m -s /bin/bash jenkins
#RUN         echo jenkins:jenkins | chpasswd
#RUN         mkdir -p /var/run/sshd
            
EXPOSE      22
ENTRYPOINT  ["/usr/local/zap/zap2/zap.sh"]
CMD /usr/sbin/sshd -D
#CMD ["-g", "deamon off;"]

# Ansible managed: /workspace/users/albandri10/env/ansible/roles/zap/templates/Dockerfile.j2 modified on 2014-10-10 17:47:33 by albandri on albandri-laptop-misys
#FROM        debian:jessie
#FROM        stackbrew/ubuntu:14.04
FROM        jasongiedymin/ansible-base-ubuntu

# Volume can be accessed outside of container
VOLUME      [/usr/local/zap]

MAINTAINER  Alban Andrieu "https://github.com/AlbanAndrieu"

ENV			DEBIAN_FRONTEND noninteractive
ENV         ZAP_HOME /usr/local/zap/zap-2.3.1
ENV         WORKDIR /home/vagrant

# Working dir
WORKDIR /home/vagrant

# COPY
#COPY

RUN         pwd
RUN         ls -lrta

# ADD
ADD defaults $WORKDIR/ansible-zap/defaults
ADD meta $WORKDIR/ansible-zap/meta
#ADD files $WORKDIR/ansible-zap/files
ADD handlers $WORKDIR/ansible-zap/handlers
ADD tasks $WORKDIR/ansible-zap/tasks
ADD templates $WORKDIR/ansible-zap/templates
#ADD vars $WORKDIR/ansible-zap/vars

# Here we continue to use add because
# there are a limited number of RUNs
# allowed.
ADD hosts /etc/ansible/hosts
ADD zap.yml $WORKDIR/ansible-zap/zap.yml

# Execute
RUN         pwd
RUN         ls -lrta
RUN         ansible-playbook $WORKDIR/ansible-zap/zap.yml -c local -vvvv

#RUN         apt-get update && \
#            apt-get install -y openssh-server openjdk-7-jre-headless
#RUN         useradd -m -s /bin/bash jenkins
#RUN         echo jenkins:jenkins | chpasswd
#RUN         mkdir -p /var/run/sshd
            
EXPOSE      22
ENTRYPOINT  ["/usr/local/zap/zap2/zap.sh"]
CMD /usr/sbin/sshd -D
#CMD ["-g", "deamon off;"]

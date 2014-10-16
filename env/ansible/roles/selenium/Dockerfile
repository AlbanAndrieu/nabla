# Ansible managed: /workspace/users/albandri10/env/ansible/roles/selenium/templates/Dockerfile.j2 modified on 2014-10-16 01:27:32 by albandri on albandri-laptop-misys
#FROM        debian:jessie
#FROM        stackbrew/ubuntu:14.04
FROM        jasongiedymin/ansible-base-ubuntu

# Volume can be accessed outside of container
VOLUME      [/usr/local/lib]

MAINTAINER  Alban Andrieu "https://github.com/AlbanAndrieu"

ENV			DEBIAN_FRONTEND noninteractive
ENV         SELENIUM_HOME /usr/local/lib
ENV         WORKDIR /home/vagrant

# Working dir
WORKDIR /home/vagrant

# COPY
#COPY

RUN         pwd
RUN         ls -lrta

# ADD
ADD defaults $WORKDIR/ansible-selenium/defaults
ADD meta $WORKDIR/ansible-selenium/meta
ADD files $WORKDIR/ansible-selenium/files
ADD handlers $WORKDIR/ansible-selenium/handlers
ADD tasks $WORKDIR/ansible-selenium/tasks
ADD templates $WORKDIR/ansible-selenium/templates
ADD vars $WORKDIR/ansible-selenium/vars

# Here we continue to use add because
# there are a limited number of RUNs
# allowed.
ADD hosts /etc/ansible/hosts
ADD selenium.yml $WORKDIR/ansible-selenium/selenium.yml

# Execute
RUN         pwd
RUN         ls -lrta
RUN         ansible-playbook $WORKDIR/ansible-selenium/selenium.yml -c local -vvvv

EXPOSE 21:9999
ENTRYPOINT  ["/etc/init.d/jboss", "start"]
CMD ["-g", "deamon off;"]

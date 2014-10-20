# Ansible managed: /workspace/users/albandri10/env/ansible/roles/web/templates/Dockerfile.j2 modified on 2014-09-16 00:56:12 by albandri on albandri-laptop-misys
#Docker image with java7 (oracle) based on debian:jessie
FROM        wouterd/java7

VOLUME      ["/var/log/tomcat6"]

MAINTAINER  Alban Andrieu "https://github.com/AlbanAndrieu/nabla"

ENV         CATALINA_BASE /var/lib/tomcat6
ENV         CATALINA_HOME /usr/share/tomcat6

RUN         apt-get update && \
            apt-get install -y tomcat6

EXPOSE      8080
ENTRYPOINT  ["/usr/share/tomcat6/bin/catalina.sh", "run"]

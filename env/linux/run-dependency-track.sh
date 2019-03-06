#!/bin/bash
set -xv

# See https://wiki.jenkins.io/display/JENKINS/OWASP+Dependency-Track+Plugin

docker pull owasp/dependency-track
docker volume create --name dependency-track
docker run -d -p 8087:8080 --name dependency-track -v dependency-track:/data owasp/dependency-track

# http://10.41.40.91:8087/
#admin/admin

exit 0

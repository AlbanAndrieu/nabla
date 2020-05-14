#!/bin/bash
set -xv

# See https://wiki.jenkins.io/display/JENKINS/OWASP+Dependency-Track+Plugin
# https://docs.dependencytrack.org/getting-started/initial-startup/

# Pull the image from the Docker Hub OWASP repo
docker pull owasp/dependency-track
# Creates a dedicated volume where data can be stored outside the container
docker volume create --name dependency-track
# Run the container with 8GB RAM on port 8087
docker run -d -m 8192m -p 8087:8080 --name dependency-track -v dependency-track:/data owasp/dependency-track

# http://10.41.40.91:8087/
#admin/admin

#Go in the Configuration -> Teams --> Automation
#Get the API Keys
#Then add Permissions
#BOM_UPLOAD
#PROJECT_CREATION_UPLOAD
#VIEW_PORTFOLIO
#VULNERABILITY_ANALYSIS

exit 0

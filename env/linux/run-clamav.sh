#!/bin/bash
set -xv

#https://wiki.jenkins-ci.org/display/JENKINS/ClamAV+Plugin
apt-get install clamav-base clamav-daemon clamav-docs clamav
#Update clamav virus definition
freshclam
#check is it running
netstat -tlpn | grep clam

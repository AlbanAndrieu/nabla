#!/bin/bash
set -xv

#[SAN]\nsubjectAltName=DNS:${SSL_KEY_NAME},DNS:albandrieu.com,DNS:home.albandrieu.com,DNS:freenas.albandrieu.com,DNS:jenkins.albandrieu.com,DNS:sample.albandrieu.com,DNS:apache.home,DNS:apache.albandrieu.com,DNS:albandrieu.home,DNS:albandrieu.albandrieu.com,IP:86.242.254.92,IP:192.168.1.57,IP:192.168.1.61,IP:192.168.1.24,IP:127.0.0.1"

# For letsencrypt
export CERT_HOST_NAME=albandrieu.com home.albandrieu.com
#apache.albandrieu.com nabla.albandrieu.com
#albandrieu.albandrieu.com jenkins.albandrieu.com sample.albandrieu.com bababou.albandrieu.com
# 82.124.241.189 192.168.1.57 192.168.1.61 192.168.1.24 127.0.0.1

exit 0

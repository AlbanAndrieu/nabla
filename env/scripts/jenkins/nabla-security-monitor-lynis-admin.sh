#!/bin/bash
set -xv

echo ""
echo "################### LYNIS ###################"
echo ""

#TODO use /usr/local/lynis/2.2.0/lynis
sudo -t lynis --check-update
sudo -t lynis --version

sudo -t lynis --check-all -Q

#!/bin/bash

echo ""
echo "################### LYNIS ###################"
echo ""

#TODO use /usr/local/lynis/2.2.0/lynis
sudo lynis --check-update
sudo lynis --version

sudo lynis --check-all -Q

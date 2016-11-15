#!/bin/bash


echo ""
echo "################### RKHUNTER ###################"
echo ""

sudo rkhunter --update
sudo rkhunter --version

sudo rkhunter --checkall --report-warnings-only

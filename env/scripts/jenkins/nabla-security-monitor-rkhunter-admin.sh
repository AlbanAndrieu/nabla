#!/bin/bash
set -xv

echo ""
echo "################### RKHUNTER ###################"
echo ""

sudo -t rkhunter --update
sudo -t rkhunter --version

sudo -t rkhunter --checkall --report-warnings-only

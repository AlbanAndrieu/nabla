#!/bin/bash
set -xv

echo ""
echo "################### CHROOTKIT ###################"
echo ""

sudo -t chkrootkit -V

sudo -t chkrootkit -q

#sudo tiger --version

#sudo tiger

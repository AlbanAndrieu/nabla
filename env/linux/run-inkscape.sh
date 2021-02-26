#!/bin/bash
set -xv

# See https://doc.ubuntu-fr.org/inkscape

sudo apt-add-repository --yes ppa:inkscape.dev/stable
sudo apt-get update
sudo apt-get install inkscape
sudo apt-get install aspell-fr aspell-no

exit 0

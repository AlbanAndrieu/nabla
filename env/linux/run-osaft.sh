#!/bin/bash
set -xv

#https://github.com/OWASP/O-Saft

sudo apt-get install libssl-dev
sudo apt-get install libnet-ssleay-perl
sudo apt-get install libcrypt-ssleay-perl
sudo apt-get install libio-socket-ssl-perl

sudo apt-cache search perl | grep SSL

sudo perl -MCPAN -e 'install Devel::Trace'

git clone https://github.com/OWASP/O-Saft.git
git tag -l
git checkout tags/15.12.15
cd O-Saft
export PATH=./:$PATH
perl -d:trace o-saft.pl --help
o-saft.pl +check your.tld
o-saft.tcl

#DOES NOT WORK


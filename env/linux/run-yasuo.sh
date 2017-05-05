#!/bin/bash
set -xv

#See https://github.com/0xsauby/yasuo
sudo gem install ruby-nmap net-http-persistent mechanize text-table
cd ${WORSPACE}
git clone https://github.com/0xsauby/yasuo.git
cd yasuo
sudo ./yasuo.rb -r 127.0.0.1 -p 80,8080,443,8443,8380 -b form

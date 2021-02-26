#!/bin/bash
set -xv

#sudo apt-get install task-print-server
sudo apt-get install cups
sudo apt-get install cups-bsd # cmd tools
sudo apt-get install cups-filters # printer without pilote

# Check the pinter driver exists
sudo /usr/sbin/lpinfo --make-and-model "SX105" -m
#gutenprint.5.3://escp2-sx105/expert Epson Stylus SX105 - CUPS+Gutenprint v5.3.3
#everywhere IPP Everywhere

# See https://openprinting.org/printers

./run-printer-epson.sh

system-config-printer

sudo nano /etc/cups/cupsd.conf
sudo systemctl restart cups.service

# See http://localhost:631/

#See http://localhost:631/admin
# albandrieu

lpq

#lprm 12321

# remove tasks
lprm -a

# All availanle printer
lpstat -s

exit 0

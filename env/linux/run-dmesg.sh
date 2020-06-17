#!/bin/bash
#set -xv

# ubuntu error messages check
dmesg -wHT

#grep EDAC /var/log/messages*
# memory issues
#egrep 'Out|Killed' /var/log/messages*

multitail /var/log/kern.log /var/log/dmesg /var/log/syslog

exit 0

#!/bin/bash
#set -xv

# See https://github.com/Tripwire/tripwire-open-source

#dpkg-reconfigure tripwire

twadmin -m G -S /etc/tripwire/site.key
twadmin --create-cfgfile -S  /etc/tripwire/site.key /etc/tripwire/twcfg.txt

tripwire --init

exit 0

#!/bin/bash
#set -xv

#http://doc.freenas.org/index.php/Plugins#Accessing_the_Plugins_Jail
jls

jexec 48 /bin/tcsh

./run-freenas-port.sh

#OLD jail are in
ls /mnt/dpool/jails/
#NEW are
ls /mnt/dpool/iocage/jails

exit 0

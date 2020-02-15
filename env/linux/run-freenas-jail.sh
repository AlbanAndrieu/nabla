#!/bin/bash
#set -xv

#http://doc.freenas.org/index.php/Plugins#Accessing_the_Plugins_Jail
jls

jexec 1 /bin/tcsh
jexec 9

./run-freenas-port.sh

exit 0

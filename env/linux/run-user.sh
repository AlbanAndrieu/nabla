#!/bin/bash
set -xv

#https://serverfault.com/questions/680804/how-do-i-find-out-if-a-uid-exists
getent passwd 2000

CURRENT_UID=$(id -u):$(id -g)

exit 0

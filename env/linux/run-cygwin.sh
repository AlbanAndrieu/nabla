#!/bin/bash
set -xv

# Create service using cygwin

cygrunsrv.exe -I remoteos -p /cygdrive/c//workspace/users/albandri30/nabla/myservice -a "-p 4004" --type auto
starting/stopping service

# starting service
cygrunsrv -S myservice

# stopping service
cygrunsrv -E myservice

exit 0

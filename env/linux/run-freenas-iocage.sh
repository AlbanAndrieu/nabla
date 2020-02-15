#!/bin/bash
set -xv

# See https://github.com/freenas/iocage-ports1

# See https://gist.github.com/mow4cash/e2fd4991bd2b787ca407a355d134b0ff

ssh -X root@nabla

iocage df
iocage restart jenkins

exit 0

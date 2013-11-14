#!/bin/bash -xv

# Generating zones/zfs informations
#report have been replaced by putting showtree as an output inside jenkins
# zones description output for jenkins
./zfstree.pl || exit 1

exit 0
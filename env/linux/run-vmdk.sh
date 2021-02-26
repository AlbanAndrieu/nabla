#!/bin/bash
set -xv

sudo apt-get install qemu-utils -y
# Check module installed
modinfo nbd
# Load module
sudo modprobe nbd max-part=4
# mount image
qemu-nbd -r -c /dev/nbd0 Windows\ Server\ 2016-0000.2.vmdk

exit 0

#!/bin/bash
#set -xv

# See https://gehrcke.de/2019/10/freenas-insufficient-space-to-install-update-how-to-replace-the-usb-boot-device-with-a-larger-one/

Attach da1

/dev/da0p2/dev/da0p2

zpool status freenas-boot
1.56 G 2.12G

Boot Pool Condition: ONLINE
Size: 3.81 GiB
Used: 1.56 GiB

zpool set autoexpand=on freenas-boot
#zpool online -e freenas-boot da0p2
#Detach da0p2
zpool online -e freenas-boot da1p2

5.76 G

exit 0

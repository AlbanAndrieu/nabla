#!/bin/bash
set -xv

# See https://www.nielsvandermolen.com/bluetooth-headphones-ubuntu/

dmesg | grep -i bluetooth # Shows all Bluetooth driver info
dmesg | grep -i bluetooth | grep -i firmware # Shows Bluetooth firmware issues
lsusb # Displays hardware connected to the USB ports

pulseaudio --k

exit 0

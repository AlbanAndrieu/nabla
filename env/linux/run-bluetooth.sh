#!/bin/bash
set -xv

# See https://www.nielsvandermolen.com/bluetooth-headphones-ubuntu/

dmesg | grep -i bluetooth # Shows all Bluetooth driver info
dmesg | grep -i bluetooth | grep -i firmware # Shows Bluetooth firmware issues
lsusb # Displays hardware connected to the USB ports

# See https://www.freedesktop.org/wiki/Software/PulseAudio/Documentation/User/Bluetooth/
pulseaudio --k

# See https://bugs.freedesktop.org/show_bug.cgi?id=93898
nano ~/.config/pulse/client.conf
#Create '~/.config/pulse/client.conf' with the following line:
#autospawn = no

#sudo apt install ofono

# Config bluethooth aukey
pavucontrol

exit 0

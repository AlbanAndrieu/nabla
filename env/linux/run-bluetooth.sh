#!/bin/bash
set -xv

# USB receiver TP-LINK UB4000 is working with Ubuntu 20

# See https://www.nielsvandermolen.com/bluetooth-headphones-ubuntu/

dmesg | grep -i bluetooth # Shows all Bluetooth driver info
dmesg | grep -i bluetooth | grep -i firmware # Shows Bluetooth firmware issues
lsusb # Displays hardware connected to the USB ports

#0a12:0001 Cambridge Silicon Radio, Ltd Bluetooth Dongle (HCI mode)
#https://linux-hardware.org/index.php?id=usb:0a12-0001
hcidump

sudo snap install bluez
# Then aukey br-c1 is detected
# Connected to phono on yamaha

# See https://www.freedesktop.org/wiki/Software/PulseAudio/Documentation/User/Bluetooth/
pulseaudio --k

# See https://bugs.freedesktop.org/show_bug.cgi?id=93898
nano ~/.config/pulse/client.conf
#Create '~/.config/pulse/client.conf' with the following line:
#autospawn = no

#sudo apt-get install git linux-headers-generic build-essential dkms
#lsmod | grep bluetooth
bluetoothctl

# See https://doc.ubuntu-fr.org/bluetooth
hcitool scan

# Config bluethooth aukey
pacmd list-modules
#module-device-restore
#module-card-restore

pavucontrol

# Settinges saved into
~/.config/pulse

sudo apt install pavumeter paprefs

exit 0

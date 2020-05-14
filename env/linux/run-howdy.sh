#!/bin/bash
set -xv

#See https://github.com/boltgolt/howdy

#Issue https://github.com/boltgolt/howdy/issues/265

sudo add-apt-repository ppa:boltgolt/howdy
sudo apt update
sudo apt install howdy

sudo howdy add
#sudo howdy config
#identify webcam
lsusb -v
#us 001 Device 011: ID 046d:081b Logitech, Inc. Webcam C310
#device_path = /dev/v4l/by-path/pci-0000:00:14.0-usb-0:3.3:1.0-video-index0
#device_path = /dev/v4l/by-path/pci-0000:00:14.0-usb-0:2.3:1.0-video-index0
sudo -i

less /var/log/auth.log

exit 0

#!/bin/bash

#See https://itsfoss.com/play-dvd-ubuntu-1310/

dmesg | grep -A8 CD-ROM

sudo apt-get install libdvdcss2 libdvdread4 libdvdnav4  ubuntu-restricted-extras gstreamer1.0-plugins-bad gstreamer1.0-plugins-ugly libdvd-pkg

#libdvdcss2: to recognize DVD
#libdvdread4: to read DVD
#libdvdnav4: to navigate DVD

sudo apt-get install udftools

#sudo dpkg-reconfigure libdvd-pkg

lshw | less
sudo mount -o ro,unhide,uid=1000 /dev/sr0 /mnt/cdrom

cdrecord -checkdrive

vlc -vvv /dev/sr0

sudo mount -a

sudo eject /dev/sr0

exit 0

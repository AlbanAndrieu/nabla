#!/bin/bash
set -xv

# See https://doc.ubuntu-fr.org/tutoriel/installer_imprimante_epson#installation_a_partir_des_pilotes_du_site_epson

#sudo add-apt-repository -y "deb http://download.ebz.epson.net/dsc/op/stable/debian/ lsb3.2 main"
#sudo apt-get update -q

# See http://download.ebz.epson.net/dsc/search/01/search/nextPage
# http://download.ebz.epson.net/dsc/du/02/DriverDownloadInfo.do?LG2=FR&CN2=&DSCMI=16142&DSCCHK=0086d304be51c379a257721a72f73b7dc5765576

sudo apt-get remove pips-snx100:i386
ls -l /var/lib/dpkg/info | grep  pips-snx100
sudo mv /var/lib/dpkg/info/pips-snx100.* /tmp/
#sudo dpkg --remove --force-remove-reinstreq  pips-snx100
sudo apt --fix-broken install

sudo /usr/local/EPAva/printer/snx100/uninstall-snx100.sh

#sudo ./pips-snx100-ubuntu8.04-3.5.0-CG.install
sudo ./pips-snx100-ubuntu8.04-3.3.0-CG.install

ls -lrta /usr/local/EPAva/printer/snx100/

# See localhost:631
lpstat -p -d

#sudo apt install libcanberra-gtk-module
/etc/init.d/cups restart

lsusb | grep -i epson
#Bus 001 Device 011: ID 04b8:0841 Seiko Epson Corp. PX-401A [ME 300/Stylus NX100]

sudo apt-get install escputil mtink

ls /dev/usb/lp2
sudo escputil -i -r /dev/usb/lp2

#sudo mtink

sudo apt-get install libcups2-dev
sudo apt-get install lsb-base printer-driver-escpr

#NOK Epson Stylus SX 200
#NOK Epson Stylus SX 100
#Idle - File "/usr/lib/cups/filter/pips-wrapper" not available: No such file or directory
#sudo apt-get install pips-snx100:i386

sudo gtklp

sudo usermod -a -G lpadmin albandrieu
#sudo lpadmin -p sx100 -E -v ekplp:/var/ekpd/ekplp0 -m /usr/local/EPAva/printer/snx100/ekssx100.ppd
sudo lpadmin -p sx100 -E -v usb://EPSON/Stylus%20SX100?serial=KQHZ592124&interface=1 -m /usr/local/EPAva/printer/snx100/ekssx100.ppd
geany /usr/share/doc/pips-core-3.5.0/UsersManual.en.txt
#geany /usr/share/doc/pips-snx100-3.5.0/Stylus_NX100_Manual.txt

#Once register you will have
ll /etc/cups/ppd/Stylus-SX100.ppd

printer-driver-hpijs printer-driver-gutenprint

exit 0

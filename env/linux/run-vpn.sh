#!/bin/bash
set -xv

sudo apt-get install network-manager-openconnect network-manager-openconnect-gnome
#http://www.humans-enabled.com/2011/06/how-to-connect-ubuntu-linux-to-cisco.html
#gateway is https://ukrassl.misys.com/misysvpn
#then in network manager click add
#Then Cisco AnyConnect Compatible VPN openconnect

#reinstall
#sudo apt-get install --reinstall network-manager-iodine network-manager-openconnect network-manager-openvpn network-manager-pptp network-manager-strongswan network-manager-vpnc

sudo apt-get install vpnc network-manager-vpnc

sudo service networking restart
#A rebbot is required
#sudo reboot

exit 0

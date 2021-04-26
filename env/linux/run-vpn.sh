#!/bin/bash
set -xv

sudo apt-get install network-manager-openconnect network-manager-openconnect-gnome
#reinstall
#sudo apt-get install --reinstall network-manager-iodine network-manager-openconnect network-manager-openvpn network-manager-pptp network-manager-strongswan network-manager-vpnc

#http://www.humans-enabled.com/2011/06/how-to-connect-ubuntu-linux-to-cisco.html
#gateway is https://ukrassl.misys.com/misysvpn
#then in network manager click add
#Then Cisco AnyConnect Compatible VPN openconnect

sudo apt-get install vpnc network-manager-vpnc

sudo service networking restart
sudo service network-manager restart
#A reboot is required
#sudo reboot

#---------------------------------

# See https://github.com/systemd/systemd/issues/6076

sudo nano /etc/default/openvpn

OPTARGS="
    --script-security 2
    --up /etc/openvpn/up.sh
    --down /etc/openvpn/down.sh
"

#---------------

sudo nano /etc/openvpn/up.sh

#!/bin/sh

sudo systemd-resolve -i eno1 --set-dns=8.8.8.8 --set-domain="~."
#127.0.0.53
sudo systemd-resolve -i eno1 --set-domain="~bnt."
sudo systemctl restart systemd-resolved

#---------------

sudo nano /etc/openvpn/down.sh

#!/bin/sh

sudo systemd-resolve -i eno1 --set-domain="~."

#---------------------------------

sudo systemd-resolve --status

Link 70 (vpn0)
      Current Scopes: DNS
DefaultRoute setting: yes
       LLMNR setting: yes
MulticastDNS setting: no
  DNSOverTLS setting: no
      DNSSEC setting: no
    DNSSEC supported: no

# See https://unix.stackexchange.com/questions/316156/network-manager-not-taking-dns-search-into-account-for-vpn-gnome-ubuntu-16-04-1
ll /etc/NetworkManager/system-connections
dns-search=misys.global.ad;finastra.global;.provides.io;

systemctl restart NetworkManager.service

systemd-resolve --status

sudo nano /etc/default/openvpn

# See https://gist.github.com/plembo/26027128bc7cbdbb0b967a2fb275da50

# Add search to VPN
nm-connection-editor

sudo nmcli con show

nmcli con | grep -i vpn
nmcli con show --active

sudo service openvpn status

# Check IP https://www.hostip.fr/

exit 0

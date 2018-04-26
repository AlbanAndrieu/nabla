
#https://jochen.kirstaetter.name/configure-ipv6-on-ubuntu/

#https://jochen.kirstaetter.name/dhcpv6-ipv6-in-your-local-network/
sudo apt-get install isc-dhcp-server
sudo nano /etc/dhcp/dhcpd6.conf

authoritative;
default-lease-time 14400;
max-lease-time 86400;
log-facility local7;
subnet6 2a01:e35:2fdf:4a20::/64 {
    option dhcp6.name-servers 2a01:4860:4860::8888, 2a01:4860:4860::8844;
    option dhcp6.domain-search "nabla.mobi";
    range6 2a01:e35:2fdf:4a20::100 2a01:e35:2fdf:4a20::199;
    range6 2a01:e35:2fdf:4a20::/64 temporary;
}

sudo service isc-dhcp-server6 restart
sudo /usr/sbin/dhcpd -6 -d -cf /etc/dhcp/dhcpd6.conf eth0
sudo touch /var/lib/dhcp/dhcpd6.leases
sudo chown dhcpd:dhcpd /var/lib/dhcp/dhcpd6.leases

#sudo apt-get remove network-manager

sudo nano /etc/network/interfaces
# interfaces(5) file used by ifup(8) and ifdown(8)
auto lo
iface lo inet loopback

iface eth0 inet6 dhcp

sudo service networking restart

less /etc/resolv.conf
systemd-resolve --status

#Ping roouter
ping6 2a01:e35:2fdf:4a20::1

ip -6 neigh show

#freenas
ping6 -I em0 fe80::7e05:7ff:fe0e:d988
ping6 fe80::7e05:7ff:fe0e:d988%em0
ping6 fe80::7e05:7ff:fe0e:d988%eno1

fe80::98aa:9cff:fe4a:3be3

#laptop
ping6 -I eno1 fe80::e5be:531d:776a:7647

ping6 -c4 -I eno1 fe80::1

host -t AAAA http://home.nabla.mobi:84/

ping6 -c 4 fe80::7e05:7ff:fe0e:d988

#!/bin/bash
set -xv

telnet 192.168.1.64 24800
nc -vz 192.168.1.64 24800

netstat -anp | grep -E "(Active|State|barrier|24800)"

#iptables -A INPUT -p tcp -i $interface --dport 24800 -j ACCEPT

#https://github.com/debauchee/barrier/issues/190#issuecomment-445582840

# Disable SSL in the congig and use VPN IP 10.119.217.12

exit 0

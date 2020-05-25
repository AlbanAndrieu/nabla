#!/bin/bash
set -xv

telnet 192.168.1.64 24800
nc -vz 192.168.1.64 24800

netstat -anp | grep -E "(Active|State|barrier|24800)"

#iptables -A INPUT -p tcp -i $interface --dport 24800 -j ACCEPT

https://github.com/debauchee/barrier/wiki/Adding-Barrier-to-the-Windows-Firewall

exit 0

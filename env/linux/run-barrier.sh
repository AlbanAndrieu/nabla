#!/bin/bash
set -xv

telnet 192.168.1.64 24800

netstat -anp | grep -E "(Active|State|barrier|24800)"
 
exit 0 

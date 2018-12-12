#!/bin/bash
set -xv

# Clear memory
/sbin/sysctl vm.drop_caches=3

exit 0

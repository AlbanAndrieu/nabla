#!/bin/bash
set -xv

cd /var/db/collectd/rrd/

# See https://collectd.org/wiki/index.php/Plugin:Write_Prometheus
nano /conf/base/etc/local/collectd.conf 

exit 0

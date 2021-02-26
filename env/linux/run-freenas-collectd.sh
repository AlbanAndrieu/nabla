#!/bin/bash
set -xv

#cd /usr/ports/net-mgmt/collectd5/

cd /var/db/collectd/rrd/

# See https://collectd.org/wiki/index.php/Plugin:Write_Prometheus
#nano /conf/base/etc/local/collectd.conf
nano /etc/local/collectd.conf

LoadPlugin write_prometheus
<Plugin "write_prometheus">
  Port "9103"
</Plugin>

ls -lrta /usr/local/lib/collectd

service collectd onerestart

exit 0

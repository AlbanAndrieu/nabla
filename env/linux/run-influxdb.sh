#!/bin/bash
set -xv

#See https://rudimartinsen.com/2018/04/12/monitoring-freenas-with-influxdb-and-grafana/

docker run --rm influxdb:1.8.0 influxd config > influxdb.conf

exit 0

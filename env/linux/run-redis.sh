#!/bin/bash
set -xv

#empty redis database
redis-cli
#With redis-cli:

FLUSHDB       - Removes data from your connections CURRENT database.
FLUSHALL      - Removes data from ALL databases.

#log
tail -f /var/log/redis/redis-server.log

docker pull redislabs/redisinsight:latest

exit 0

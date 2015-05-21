#empty redis database
redis-cli
#With redis-cli:

FLUSHDB       - Removes data from your connection's CURRENT database.
FLUSHALL      - Removes data from ALL databases.

#log
tail -f /var/log/redis/redis-server.log

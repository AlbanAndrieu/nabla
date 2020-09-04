#!/bin/sh

# Download lists, unpack and filter, write to gzipped file
curl -s https://www.iblocklist.com/lists.php \
| sed -n "s/.*value='\(http:.*\)'.*/\1/p" \
| sed "s/\&amp;/\&/g" \
| sed "s/http/\"http/g" \
| sed "s/gz/gz\"/g" \
| xargs curl -s -L \
| gunzip \
| egrep -v '^#' \
| gzip - > ./bt_blocklist.gz

#cp ./bt_blocklist.gz /usr/local/etc/transmission/home/blocklists/bt_blocklist.gz

exit 0

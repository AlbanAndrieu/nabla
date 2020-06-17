#!/bin/bash
#set -xv

deluge --version

service deluged stop
service deluge_web stop
 
cd ./usr/local/etc/deluge/
sed -i.bak "/pwd_sha1/d" web.conf

#find / -name "*.egg"
#/usr/local/lib/python2.7/site-packages/deluge/plugins/Blocklist-1.3-py2.7.egg
#Blocklist-1.3-py2.7.egg

cp /usr/local/lib/python2.7/site-packages/deluge/plugins/Blocklist-1.3-py2.7.egg /usr/local/etc/deluge/plugins

#http://list.iblocklist.com/?list=fr&fileformat=p2p&archiveformat=gz
##http://list.iblocklist.com/?list=ydxerpxkpcfqjaybcssw&fileformat=p2p&archiveformat=gz).

#curl -sI http://john.bitsurge.net/public/biglist.p2p.gz | grep Last-Modified

exit 0

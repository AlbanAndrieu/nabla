#!/bin/bash

/usr/share/awstats/tools/update.sh

cd /var/lib/awstats
rm *
cd /var/log/apache*
for i in `ls -tr *access.log.*.gz` 
do
 echo "Fichier traité: $i"
 zcat $i | /usr/lib/cgi-bin/awstats.pl -config=home.nabla.mobi -update -LogFile=-
done

echo "AWStats done"

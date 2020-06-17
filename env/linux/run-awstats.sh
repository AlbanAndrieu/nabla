#!/bin/bash
set -xv

#http://doc.ubuntu-fr.org/awstats
#http://blog.nicolargo.com/2010/09/analyser-les-logs-de-votre-serveur-web-avec-awstats.html

http://www.home.nabla.mobi/cgi-bin/awstats.pl

cd /etc/awstats
sudo cp awstats.conf awstats.home.nabla.mobi.conf

sudo /usr/lib/cgi-bin/awstats.pl -config=home.albandrieu.com update
sudo chown -R www-data:www-data /var/lib/awstats/

cd /var/lib/awstats
rm *
cd /var/log/apache*
for i in `ls -tr access.log.*.gz`
do
 echo "File processed: $i"
 zcat $i | /usr/lib/cgi-bin/awstats.pl -config=home.albandrieu.com -update -LogFile=-
done

chmod 755 /var/log/apache2/

chgrp -R www-data /var/log/apache2/

#cpan -i Geo::IP

http://www.home.albandrieu.com/cgi-bin/awstats.pl?config=home.albandrieu.com

cd /usr/share/awstats/

#webalizer
#On ubuntu /var/www/webalizer

#Freenas

pkg install awstats

#Use webmin
#Write report to /usr/local/www/apache24/data/nabla/webalizer/

# You will see the generator in 
ls -lrta /usr/local/etc/webmin/webalizer/

#See http://www.quesaco.org/Installer-et-configurer-awstats

#less /usr/local/share/doc/awstats/httpd_conf
#change: /usr/local/awstats/wwwroot/cgi-bin/awstats.pl
#by
#/usr/local/www/awstats/cgi-bin/awstats.pl
#mkdir /usr/local/etc/awstats/
#cp /usr/local/www/awstats/cgi-bin/awstats.model.conf /usr/local/etc/awstats/configs/awstats.albandrieu.com.conf
#ln -s /usr/local/etc/awstats /etc/awstats

#Test it
#sudo -u www /usr/local/www/awstats/tools/awstats_updateall.pl -configdir=/usr/local/etc/awstats/configs/ now

#mkdir /usr/local/www/apache24/data/nabla/webalizer
See http://albandrieu.com/nabla/webalizer/

exit 0

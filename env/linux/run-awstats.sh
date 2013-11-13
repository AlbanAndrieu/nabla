#http://doc.ubuntu-fr.org/awstats
#http://blog.nicolargo.com/2010/09/analyser-les-logs-de-votre-serveur-web-avec-awstats.html

http://www.home.nabla.mobi/cgi-bin/awstats.pl

cd /etc/awstats
sudo cp awstats.conf awstats.home.nabla.mobi.conf

sudo /usr/lib/cgi-bin/awstats.pl -config=home.nabla.mobi –update
sudo chown -R www-data:www-data /var/lib/awstats/

cd /var/lib/awstats
rm *
cd /var/log/apache*
for i in `ls -tr access.log.*.gz` 
do
 echo "File processed: $i"
 zcat $i | /usr/lib/cgi-bin/awstats.pl -config=ma_machine_mon_domaine.com -update -LogFile=-
done

chmod 2755 /var/log/apache2/

chgrp -R www-data /var/log/apache2/

http://www.home.nabla.mobi/cgi-bin/awstats.pl?config=home.nabla.mobi
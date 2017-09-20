#!/bin/bash
set -xv

sudo apt-get remove --purge phpmyadmin phpldapadmin

sudo apt install libapache2-mod-php5 php5-common
sudo apt install php-mbstring php5.0-mbstring
sudo apt-get install phpmyadmin

sudo htpasswd /etc/phpmyadmin/htpasswd.setup admin

sudo ln -s /etc/phpmyadmin/apache.conf  /etc/apache2/sites-available/phpmyadmin.conf & a2ensite phpmyadmin

phpenmod mbstring
php5enmod mbstring

#issue
#http://stackoverflow.com/questions/12760394/1146-table-phpmyadmin-pma-recent-doesnt-exist

#I encountered the same problem but none of your answers solved it. But I found this link. I had to edit /etc/phpmyadmin/config.inc.php
sudo nano /etc/phpmyadmin/config.inc.php
#$cfg['Servers'][$i]['table_uiprefs'] = 'pma_table_uiprefs';
#into
#$cfg['Servers'][$i]['pma__table_uiprefs'] = ‘pma__table_uiprefs’;

#MYSQL reconfigure sudo dpkg-reconfigure phpmyadmin
#zcat /usr/share/doc/phpmyadmin/examples/create_tables.sql.gz | mysql -uroot -p

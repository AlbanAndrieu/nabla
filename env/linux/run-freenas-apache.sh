#!/bin/bash
set -xv

pkg install nano bash
#bash_completion
ln -s /usr/local/bin/bash /bin/bash
pkg install sudo

###################################

#install lamp
#https://www.digitalocean.com/community/tutorials/how-to-install-an-apache-mysql-and-php-famp-stack-on-freebsd-10-1

#install apache

#https://forums.freenas.org/index.php?threads/howto-install-apache-under-jail-with-freenas-8-3.10594/
pkg install apache24
pkg install apachetop
#cd /usr/ports/www/apache24
cat /usr/local/etc/apache24/httpd.conf | grep Listen
echo 'apache24_enable="YES"' >> /etc/rc.conf

#check mod ssl
#/usr/ports/www/apache24]#  make showconfig | grep ssl
#     SSL=on: SSL/TLS support (mod_ssl)

#as non jail
#start apache
/usr/local/etc/rc.d/apache24 start
service apache24 restart

#See http://192.168.1.61/

#####################

#NOK pkg install databases/mysql80-server

#Installed packages to be REMOVED:
#	cdash: 2.2.3_2
#	mysql57-client: 5.7.33

#pkg install devel/cdash
#Moved:	devel/llvm90
cd /usr/ports/devel/cdash && make install clean

pkg install mysql57-server

sudo sysrc mysql_enable=yes
service mysql-server start
mysql_secure_installation

#https://www.ostechnix.com/install-phpmyadmin-apache-nginx-freebsd-10-2/
pkg install phpMyAdmin5-php74-5.1.0
pkg install mod_php74
pkg install php74-mysqli php74-json php74-mbstring php74-session php74-iconv

#pkg search php74
sudo nano /usr/local/www/apache24/data/info.php
<?php phpinfo(); ?>
http://192.168.1.61/info.php

---------------
edit /usr/local/etc/php.ini
extension=mysqli.so
extension=mbstring.so

extension=session.so
extension=json.so
extension=iconv.so

# Check
php -m

To make phpMyAdmin available through your web site, I suggest
that you add something like the following to httpd.conf:

Alias /phpmyadmin/ "/usr/local/www/phpMyAdmin/"

<Directory "/usr/local/www/phpMyAdmin/">
    Options None
    AllowOverride Limit

    Require local
    Require host .albandrieu.com
</Directory>

http://192.168.1.61/phpMyAdmin/

#################

# In webmin
#from "/var/db/mysql/my.cnf" to "/usr/local/etc/mysql/my.cnf"

#Access denied for user ''@'localhost' to database 'cdash'

mysql -u root -p
<HERE YOU TYPE YOUR MYSQL ROOT PASSWORD>

create database cdash;
create user 'cdash'@'localhost' identified by 'microsoft';
grant all privileges on cdash.* to 'cdash'@'localhost' with grant option;
FLUSH PRIVILEGES;
quit;

cd /usr/local/www/CDash

less /var/log/httpd-albandrieu.com-error.log
[Thu May 13 02:36:31.531739 2021] [php7:error] [pid 41234] [client 192.168.1.57:60700] script '/usr/local/www/CDash/version.php' not found or unable to stat
[Thu May 13 02:36:33.910827 2021] [php7:error] [pid 41234] [client 192.168.1.57:60700] PHP Fatal error:  Uncaught Error: Call to undefined function mysql_connect()
in /usr/local/www/CDash/cdash/pdocore.php:48\nStack trace:\n
#0 /usr/local/www/CDash/cdash/pdocore.php(441): pdo_connect('localhost', 'root', 'microsoft')\n
#1 /usr/local/www/CDash/cdash/log.php(19): require_once('/usr/local/www/...')\n
#2 /usr/local/www/CDash/cdash/pdo.php(18): require_once('/usr/local/www/...')\n
#3/usr/local/www/CDash/index.php(19): require_once('/usr/local/www/...')\n
#4 {main}\n  thrown in /usr/local/www/CDash/cdash/pdocore.php on line 48
/var/log/httpd-albandrieu.com-error.log (END)
$CDASH_FORWARDING_IP='192.%'; // should be an SQL format

nano /usr/local/etc/apache24/httpd.conf

<IfModule dir_module>
DirectoryIndex index.php index.html
</IfModule>

#At the end
<FilesMatch "\.php$">
    SetHandler application/x-httpd-php
</FilesMatch>
<FilesMatch "\.phps$">
    SetHandler application/x-httpd-php-source
</FilesMatch>

#DocumentRoot "/usr/local/www/apache24/data"
cd /usr/local/www/apache24/data

#https://mujahidjaleel.blogspot.fr/2016/10/how-to-install-apache-v24-webserver-in.html

# See https://certbot.eff.org/lets-encrypt/freebsd-apache

#pkg remove -y py27-certbot
cd /usr/ports/security/py-certbot && make install clean

#The certbot plugins to support apache and nginx certificate installation
#will be made available in the following ports:
#
# * Apache plugin: security/py-certbot-apache
# * Nginx plugin: security/py-certbot-nginx
#
#In order to automatically renew the certificates, add this line to
#/etc/periodic.conf:
#
#    weekly_certbot_enable="YES"

certbot certonly
certbot renew
# AND restart apache

#INPUT
#2
#albandrieu.com,nabla.albandrieu.com,home.albandrieu.com,cv.albandrieu.com,sample.albandrieu.com
#1
#/usr/local/www/apache24/data

#NOK /usr/local/www/apache24/data/sample
#NOK /usr/local/www/apache24/data/alban
#NOK /usr/local/www/apache24/data/bababou

#TODO freenas.nabla.mobi,jenkins.nabla.mobi

less /usr/local/etc/letsencrypt/renewal/albandrieu.com.conf

cert = /usr/local/etc/letsencrypt/live/albandrieu.com-0001/cert.pem
privkey = /usr/local/etc/letsencrypt/live/albandrieu.com-0001/privkey.pem
chain = /usr/local/etc/letsencrypt/live/albandrieu.com-0001/chain.pem
fullchain = /usr/local/etc/letsencrypt/live/albandrieu.com-0001/fullchain.pem

nano /usr/local/etc/apache24/httpd.conf

#certbot certonly --standalone -d albandrieu.com

ServerAlias www.albandrieu.com

nano /usr/local/etc/apache24/extra/httpd-vhosts.conf
nano /usr/local/etc/apache24/extra/httpd-ssl.conf

SSLEngine On
SSLCertificateFile "/usr/local/etc/letsencrypt/live/albandrieu.com-0001/cert.pem"
SSLCertificateKeyFile "/usr/local/etc/letsencrypt/live/albandrieu.com-0001/privkey.pem"

openssl s_client -connect localhost:443

service apache24 restart

tail -f /var/log/httpd-error.log

http://192.168.0.28/index.pl
http://192.168.0.28/index.cgi

cd /usr/local/www/apache24/data/.well-known/acme-challenge
watch -n 0.1 ls -lRa

pkg install py37-fail2ban
pkg install webalizer
pkg install awstats

# https://192.168.1.61:10000/webalizer/view_log.cgi/%252Fvar%252Flog%252Fhttpd%252Dalbandrieu%252Ecom%252Daccess%252Elog/index.html?xnavigation=1

#See run-awstats.sh

grep deflate /usr/local/etc/apache24/httpd.conf
#LoadModule deflate_module libexec/apache24/mod_deflate.so
nano /usr/local/etc/apache24/Includes/mod_deflate.conf

---------------------------

<IfModule mod_deflate.c>
        <IfModule mod_filter.c>
            # these are known to be safe with MSIE 6
            AddOutputFilterByType DEFLATE text/html text/plain text/xml

            # everything else may cause problems with MSIE 6
            AddOutputFilterByType DEFLATE text/css
            AddOutputFilterByType DEFLATE application/x-javascript application/javascript application/ecmascript
            AddOutputFilterByType DEFLATE application/rss+xml
            AddOutputFilterByType DEFLATE application/xml
            AddOutputFilterByType DEFLATE image/svg+xml

            #Highest 9 - Lowest 1
            DeflateCompressionLevel 9

            #Optional
            #Skip browsers with known problems
            BrowserMatch ^Mozilla/4 gzip-only-text/html
            BrowserMatch ^Mozilla/4\.0[678] no-gzip
            BrowserMatch \bMSIE !no-gzip !gzip-only-text/html

            #Optional
            #Logging
            DeflateFilterNote ratio
            LogFormat '"%r" %b (%{ratio}n) "%{User-agent}i"' deflate
            CustomLog /var/log/deflate_log deflate
        </IfModule>
</IfModule>

-----------------------------

run-freenas-jenkins.sh

-----------------------------

apachectl graceful

./run-freenas-jenkins-package.sh

exit 0

#!/bin/bash
#set -xv

###################################

#install lamp
#https://www.digitalocean.com/community/tutorials/how-to-install-an-apache-mysql-and-php-famp-stack-on-freebsd-10-1

#install apache

#https://forums.freenas.org/index.php?threads/howto-install-apache-under-jail-with-freenas-8-3.10594/
pkg install apache24
pkg install apachetop
cd /usr/ports/www/apache24
cat /usr/local/etc/apache24/httpd.conf | grep Listen
echo 'apache24_enable="YES"' >> /etc/rc.conf

#check mod ssl
#/usr/ports/www/apache24]#  make showconfig | grep ssl
#     SSL=on: SSL/TLS support (mod_ssl)

#as non jail
#start apache
/usr/local/etc/rc.d/apache24 start

#See http://192.168.1.62/

#####################

pkg install databases/mysql56-server
service mysql-server start
mysql_secure_installation

#https://www.ostechnix.com/install-phpmyadmin-apache-nginx-freebsd-10-2/
pkg install phpMyAdmin
#pkg install mod_php56 php56-mysql php56-mysqli
#pkg install php56-mysqli php56-json php56-mbstring php56-session

#pkg search php56
#pkg install php56-bcmath php56-curl php56-gd php56-mbstring php56-pdo_mysql php56-xsl

    Alias /phpmyadmin/ "/usr/local/www/phpMyAdmin/"

    <Directory "/usr/local/www/phpMyAdmin/">
        Options None
        AllowOverride Limit

        Require local
        Require host .example.com
    </Directory>

http://192.168.1.62/phpMyAdmin/

pkg install cdash

Message from php56-dom-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-dom.ini
configuration file to automatically load the installed extension:

extension=dom.so

****************************************************************************
Message from php56-pdo-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-pdo.ini
configuration file to automatically load the installed extension:

extension=pdo.so

****************************************************************************
Message from php56-mysql-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-mysql.ini
configuration file to automatically load the installed extension:

extension=mysql.so

****************************************************************************
Message from php56-xsl-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-30-xsl.ini
configuration file to automatically load the installed extension:

extension=xsl.so

****************************************************************************
Message from php56-curl-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-curl.ini
configuration file to automatically load the installed extension:

extension=curl.so

****************************************************************************
Message from php56-pdo_mysql-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-30-pdo_mysql.ini
configuration file to automatically load the installed extension:

extension=pdo_mysql.so

****************************************************************************
Message from cdash-2.2.3_1:
Your CDash configuration file is located at
/usr/local/www/CDash/cdash/config.local.php.

Please create the mysql username 'cdash' and
grant him privileges over a database named 'cdash'.

A sample CDash project is available for download at
http://www.cdash.org/download/CDashTest.zip.

===>   NOTICE:

The cdash port currently does not have a maintainer. As a result, it is
more likely to have unresolved issues, not be up-to-date, or even be removed in
the future. To volunteer to maintain this port, please create an issue at:

https://bugs.freebsd.org/bugzilla

More information about port maintainership is available at:

https://www.freebsd.org/doc/en/articles/contributing/ports-contributing.html#maintain-port

#################

#Access denied for user ''@'localhost' to database 'cdash'

mysql -u root -p
<HERE YOU TYPE YOUR MYSQL ROOT PASSWORD>

create database cdash;
create user 'cdash'@'localhost' identified by 'microsoft';
grant all privileges on cdash.* to 'cdash'@'localhost' with grant option;
FLUSH PRIVILEGES;
quit;

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

#https://www.debarbora.com/lets-encrypt-ssl-certificate-with-freebsd-apache/
pkg install -y py27-certbot
certbot certonly

#INPUT
#2
#nabla.mobi,albandrieu.com,sample.nabla.mobi,alban-andrieu.fr,alban-andrieu.com,alban-andrieu.eu,bababou.fr,bababou.eu
#1
#/usr/local/www/apache24/data
#/usr/local/www/apache24/data/sample
#/usr/local/www/apache24/data/alban
#/usr/local/www/apache24/data/bababou

#TODO freenas.nabla.mobi,jenkins.nabla.mobi

less /usr/local/etc/letsencrypt/renewal/albandrieu.com.conf

cert = /usr/local/etc/letsencrypt/live/albandrieu.com/cert.pem
privkey = /usr/local/etc/letsencrypt/live/albandrieu.com/privkey.pem
chain = /usr/local/etc/letsencrypt/live/albandrieu.com/chain.pem
fullchain = /usr/local/etc/letsencrypt/live/albandrieu.com/fullchain.pem

/usr/local/etc/letsencrypt/live/albandrieu.com/fullchain.pem

nano /usr/local/etc/apache24/httpd.conf

SSLEngine On
SSLCertificateFile "/usr/local/etc/letsencrypt/live/albandrieu.com/cert.pem"
SSLCertificateKeyFile "/usr/local/etc/letsencrypt/live/albandrieu.com/privkey.pem"

#certbot certonly --standalone -d albandrieu.com

ServerAlias www.albandrieu.com

nano /usr/local/etc/apache24/extra/httpd-vhosts.conf
nano /usr/local/etc/apache24/extra/httpd-ssl.conf

openssl s_client -connect localhost:443

service apache24 restart

tail -f /var/log/httpd-error.log

http://192.168.1.62/index.pl
http://192.168.1.62/index.cgi

cd /usr/local/www/apache24/data/.well-known/acme-challenge
watch -n 0.1 ls -lRa

pkg install py27-fail2ban
pkg install webalizer
pkg install awstats

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

apachectl graceful

exit 0

pkg install nano bash 
#bash_completion
ln -s /usr/local/bin/bash /bin/bash
pkg install sudo

###################################

#install lamp
#https://www.digitalocean.com/community/tutorials/how-to-install-an-apache-mysql-and-php-famp-stack-on-freebsd-10-1

#install apache

#http://forums.freenas.org/threads/howto-install-apache-under-jail-with-freenas-8-3.10594/
pkg install apache24
pkg install apachetop
cd /usr/ports/www/apache24
cat /usr/local/etc/apache24/httpd.conf | grep Listen
echo 'apache24_enable="YES"' >> /etc/rc.conf

#as non jail
#start apache
/usr/local/etc/rc.d/apache24 start

less /var/log/httpd-error.log
see http://192.168.0.47/

#####################

pkg install databases/mysql56-server
service mysql-server start
mysql_secure_installation

#https://www.ostechnix.com/install-phpmyadmin-apache-nginx-freebsd-10-2/
pkg install phpMyAdmin
pkg install mod_php56 php56-mysql php56-mysqli
pkg install php56-mysqli php56-json php56-mbstring php56-session

pkg search php56 
pkg install php56-bcmath php56-curl php56-gd php56-mbstring php56-pdo_mysql php56-xsl
 
    Alias /phpmyadmin/ "/usr/local/www/phpMyAdmin/"

    <Directory "/usr/local/www/phpMyAdmin/">
        Options None
        AllowOverride Limit

        Require local
        Require host .example.com
    </Directory>

http://192.168.0.28/phpMyAdmin/

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

service apache24 restart


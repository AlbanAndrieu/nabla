
#zoneminder
pkg install zoneminder
The schroedinger port currently does not have a maintainer. As a result, it is
more likely to have unresolved issues, not be up-to-date, or even be removed in
the future. To volunteer to maintain this port, please create an issue at:

https://bugs.freebsd.org/bugzilla

More information about port maintainership is available at:

https://www.freebsd.org/doc/en/articles/contributing/ports-contributing.html#maintain-port
Message from opencv-core-2.4.13.1_1:
===>   NOTICE:

The opencv-core port currently does not have a maintainer. As a result, it is
more likely to have unresolved issues, not be up-to-date, or even be removed in
the future. To volunteer to maintain this port, please create an issue at:

https://bugs.freebsd.org/bugzilla

More information about port maintainership is available at:

https://www.freebsd.org/doc/en/articles/contributing/ports-contributing.html#maintain-port
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
Message from mysql56-client-5.6.36:
* * * * * * * * * * * * * * * * * * * * * * * *

Please be aware the database client is vulnerable
to CVE-2015-3152 - SSL Downgrade aka "BACKRONYM".
You may find more information at the following URL:

http://www.vuxml.org/freebsd/36bd352d-299b-11e5-86ff-14dae9d210b8.html

Although this database client is not listed as
"affected", it is vulnerable and will not be
receiving a patch. Please take note of this when
deploying this software.

* * * * * * * * * * * * * * * * * * * * * * * *
Message from php56-session-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-18-session.ini
configuration file to automatically load the installed extension:

extension=session.so

****************************************************************************
Message from php56-opcache-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-10-opcache.ini
configuration file to automatically load the installed extension:

zend_extension=opcache.so

****************************************************************************
Message from php56-ctype-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-ctype.ini
configuration file to automatically load the installed extension:

extension=ctype.so

****************************************************************************
Message from php56-sockets-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-sockets.ini
configuration file to automatically load the installed extension:

extension=sockets.so

****************************************************************************
Message from php56-gd-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-gd.ini
configuration file to automatically load the installed extension:

extension=gd.so

****************************************************************************
Message from php56-json-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-json.ini
configuration file to automatically load the installed extension:

extension=json.so

****************************************************************************
Message from pecl-APCu4-4.0.11:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-20-apcu.ini
configuration file to automatically load the installed extension:

extension=apcu.so

****************************************************************************
Message from php56-pdo_mysql-5.6.31:
****************************************************************************

The following line has been added to your /usr/local/etc/php/ext-30-pdo_mysql.ini
configuration file to automatically load the installed extension:

extension=pdo_mysql.so

****************************************************************************
Message from zoneminder-1.30.4:
ZoneMinder is a free, open source Closed-circuit television software
application developed for Unix-like operating systems which supports
IP, USB and Analog cameras.

New installs
============

ZoneMinder requires a MySQL (or MySQL forks) database backend and
a http server, capable to execute PHP and CGI scripts.

To simplify things, we assume, that you use MySQL and NGINX on
the same server.

1. Preliminary steps

1.1 Install databases/mysql56-server or newer
    pkg install databases/mysql56-server

    -----------------------------

Message from mysql56-server-5.6.36:
*****************************************************************************

Remember to run mysql_upgrade the first time you start the MySQL server
after an upgrade from an earlier version.

Initial password for first time use of MySQL is saved in $HOME/.mysql_secret
ie. when you want to use "mysql -u root -p" first you should see password
in /root/.mysql_secret

*****************************************************************************

*****************************************************************************

Please keep in mind that the default location for my.cnf will be changed
from "/var/db/mysql/my.cnf" to "/usr/local/etc/mysql/my.cnf" in the near
future.  If you do not want to move your my.cnf to the new location then
you must set "mysql_optfile" in /etc/rc.conf to "/var/db/mysql/my.cnf".


---------------------------------

	You may choose your favourite method - ports or packages here.
	FreeBSD default setting use STRICT_TRANS_TABLES sql_mode. It's mandatory to disable it. Edit your my.cnf accordingly

	The following SQL mode should be compatible with ZM:
		sql_mode= NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION

	ZoneMinder use very simple queries, however it tends to write to
	the database quite a lot depending on your capture mode and number
	of cameras. So tweak your MySQL instance accordantly

	Now, enable and start MySQL
		sysrc mysql_server_enable="YES"
		echo 'mysql_enable="YES"' >> /etc/rc.conf
		service mysql-server onestart

1.2 Install www/nginx
	We provide an example for an HTTP install, however, you should use
	HTTPS if you plan to expose your installation to the public. There
	are plenty guides how to do it and security/letsencrypt.sh is a
	good way to get a valid SSL certificate.

	Your server block should include the following:

		server {
				root /usr/local/www/zoneminder;
				try_files $uri $uri/ /index.php$is_args$args;
				index index.php;

				location = /cgi-bin/nph-zms {
						include fastcgi_params;
						fastcgi_param   SCRIPT_FILENAME $document_root$fastcgi_script_name;
						fastcgi_pass    unix:/var/run/fcgiwrap/fcgiwrap.sock;
				}

				location ~ \.php$ {
						include fastcgi_params;
						fastcgi_param   SCRIPT_FILENAME  $document_root$fastcgi_script_name;
						fastcgi_pass    unix:/var/run/php-fpm.sock;
				}

				location /api {
						rewrite ^/api/(.+)$ /api/index.php?p=$1 last;
				}
		}

1.2.1 ZoneMinder has it's own authentication system, however it's recommend to use NGINX basic
	auth over HTTPS if you don't need fine grain control to ZoneMinder components.

1.2.2 If you choose ZoneMinder authentication, it's recommended to prohibit access to
	image and events folder as it's possible to guess file names inside it.

        location ~ ^/(?:images|events)/ {
                deny all;
        }

	Enable and start NGINX
		sysrc nginx_enable="YES"
		service nginx start

1.3 Install www/fcgiwrap
	As NGINX lacks it's own CGI wrapper, we need external one. Please
	note that ZoneMinder's montage page use simultaneous access to all
	cameras, so you need to use at least as many fcgiwrap workers as
	your number of cameras. The following example assumes you have 4.

	Enable and start FcgiWrap
		sysrc fcgiwrap_enable="YES"
		sysrc fcgiwrap_user="www"
		sysrc fcgiwrap_flags="-c 4"

1.4 PHP is installed as a dependency to ZoneMinder. However, you should
	tweak some of it's settings.
	Edit /usr/local/etc/php-fpm.conf and set

		listen = /var/run/php-fpm.sock
		listen.owner = www
		listen.group = www
		env[PATH] = /usr/local/bin:/usr/bin:/bin

	If you want to set another path for the socket file, make sure you
	change it in your NGINX config well. The env[PATH] needs to be set
	to locate the zip utility as ZoneMinder's export functions rely on
	exec(). Sorry, chroot folks.

	PHP throws warning if date.timezone option is not set. The best place
	to do it is to create new ini file in /usr/local/etc/php with overrides

		date.timezone = "UTC"

	Enable and start php-fpm
		sysrc php_fpm_enable="YES"
		service php-fpm start

1.5 ZoneMinder constantly keeps the last N frames from its cameras to
	preserve them when alarm occurs. This can be a performance hog if
	placed on spindle drive. The best practice is put it on tmpfs.
	See https://www.freebsd.org/cgi/man.cgi?query=tmpfs for more
	information.

	ZoneMinder will use /tmp for default. If you plan to change it, see
	ZM_PATH_MAP setting.

	Mapping /tmp to tmpfs is actually a recommended step under FreeBSD.
	Edit /etc/fstab and add the following:

		tmpfs			/tmp		tmpfs	rw,nosuid,mode=01777	0	0

	The size of temporary files depends on your number of cameras
	number and frames you plan to keep. My 12 3Mbit cameras with 25
	last frames consumes 6 GB.

2. ZoneMinder installation

	Connect to MySQL under root and create zm user and populate database.

	mysql -u root -p

		CREATE DATABASE zm;
		GRANT ALL PRIVILEGES ON zm.* TO 'zmuser'@'localhost' IDENTIFIED BY 'microsoft';
		FLUSH PRIVILEGES;
		quit;

	mysql -u root -p zm < /usr/local/share/zoneminder/db/zm_create.sql

2.1 If you have chosen to change the ZoneMinder MySQL credentials to something
	other than zmuser/zmpass then you must now edit /usr/local/etc/zm.conf. Change
	ZM_DB_USER and ZM_DB_PASS to the values you created in the previous step.

	Enable and start ZoneMinder
		sysrc zoneminder_enable="YES"
		service zoneminder start

Upgrades
========

1. Stop ZoneMinder
	service zoneminder stop

2. Upgrade database
	sudo -u www zmupdate.pl

3. Start ZoneMinder
	service zoneminder start

echo "http://192.168.0.25/zoneminder/"


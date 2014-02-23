#http://www.slideshare.net/taehuncho/gearman-1
#gearman.org/getting-started/
#NOT up to date sudo apt-get install gearman-job-server

#check ubuntu version
lsb_release -a
sudo apt-get update

#install gearman
sudo apt-get install gearman-job-server gearman-tools
#for older ubuntu version 
#https://github.com/tripsta/gearman-php-prototype/blob/master/README.md
#follow process
#curl -L https://launchpad.net/gearmand/1.0/1.0.6/+download/gearmand-1.0.6.tar.gz > gearmand-1.0.6.tar.gz
#tar xzf gearmand-1.0.6.tar.gz &&
#cd gearmand-1.0.6 &&
#./configure &&
#make &&
#sudo make install &&
#cd ../ &&
#rm -rf gearmand-1.0.6 &&
#rm gearmand-1.0.6.tar.gz
#You might need to change prefix=/usr by prefix=/usr/local in /etc/init.d/gearman-job-server

#check version is 1.0.6
/usr/sbin/gearmand -V
/usr/local/sbin/gearmand -V

# start gearman
gearmand -d &

# check gearmand running 
ps auxw | grep [g]earmand

# check germand listening for jobs on tcp port 4730
sudo lsof -i tcp:4730

#sudo nmap -p 4730 192.168.0.0-255

#sudo apt-get -f install libboost-all-dev
sudo apt-get install libboost-dev
#sudo apt-get install bjam

sudo apt-get install gperf
sudo apt-get install libevent-dev
sudo apt-get install memcached
sudo apt-get install libmemcached-dev
sudo apt-get install sqlite3
sudo apt-get install mysql-server mysql-client
sudo apt-get install cloog-ppl
sudo apt-get install mpi-default-bin mpi-default-dev 
sudo apt-get install povray
sudo apt-cache search libuuid
#sudo apt-get install libuuid1
sudo apt-get install uuid-dev

cd /workspace
sudo wget https://launchpad.net/gearmand/1.2/1.1.11/+download/gearmand-1.1.11.tar.gz
sudo tar xzf gearmand-1.1.11.tar.gz
sudo ln -s gearmand-1.1.11 gearmand
cd gearmand-1.1.11
sudo ./configure
sudo make
sudo make install

#https://wiki.jenkins-ci.org/display/JENKINS/Gearman+Plugin

sudo apt-get install php5-dev 
sudo apt-get install libgearman-dev

wget http://pecl.php.net/package/gearman
cd /workspace
tar xzf gearman-1.1.2.tgz
cd gearman-1.1.2
phpize
./configure
sudo make
sudo make install

ll /var/run/gearman/gearmand.pid
ll /var/log/gearman-job-server/gearman.log

#configure
nano /etc/default/gearman-job-server
#PARAMS="--listen=127.0.0.1"
#Put the true IP
PARAMS="--listen=150.151.160.25"

sudo service gearman-job-server status
sudo service gearman-job-server start

#Inside Jenkins plugins
Gearman Server Host
#IP of german host instead of localhost : 150.151.160.25

#http://rripado.info/gearmanui/
cd /workspace/
sudo apt-get install php5-json
curl -sS https://getcomposer.org/installer | sudo php
curl -sS https://getcomposer.org/installer | sudo php -- --install-dir=/bin

##NOK git clone git://github.com/gaspaio/gearmanui.git gearman-ui
#Try instead : https://github.com/yugene/Gearman-Monitor

#cd /workspace/gearman-ui
#sudo /bin/composer.phar install

#cd /workspace/gearman-ui/app
#sudo chmod 777 -R logs

#cd /workspace/gearman-ui/
#sudo chmod 777 -R web

#https://github.com/yugene/Gearman-Monitor
#https://github.com/tripsta/gearman-php-prototype
sudo pear install Net_Gearman-0.2.3

cd /workspace
sudo git clone https://github.com/yugene/Gearman-Monitor.git

cd /var/www
#sudo ln -s /workspace/gearman-ui/web gearman
sudo ln -s /workspace/Gearman-Monitor gearman

sudo nano /etc/hosts
127.0.0.1 gearman-monitor.local

#modify _config.php with the server info $cfgServers[$i]['address'] = '127.0.0.1:4730'; $cfgServers[$i]['name'] = 'Gearman server 1';
cd /workspace/Gearman-Monitor
sudo nano _config.php
#modify _config.php with the server info $cfgServers[$i]['address'] = '127.0.0.1:4730'; $cfgServers[$i]['name'] = 'Gearman server 1';

sudo service apache2 restart

sudo a2enmod rewrite
cd /etc/apache2/sites-available

sudo nano gearman.conf
#<VirtualHost *:80>
<VirtualHost 127.0.0.1:8080>
        # The ServerName directive sets the request scheme, hostname and port that
        # the server uses to identify itself. This is used when creating
        # redirection URLs. In the context of virtual hosts, the ServerName
        # specifies what hostname must appear in the request's Host: header to
        # match this virtual host. For the default virtual host (this file) this
        # value is not decisive as it is used as a last resort host regardless.
        # However, you must set it for any further virtual host explicitly.
        ServerName www.home.nabla.mobi

        ServerAdmin alban.andrieu@nabla.mobi
        DocumentRoot /var/www/gearman

        # Available loglevels: trace8, ..., trace1, debug, info, notice, warn,
        # error, crit, alert, emerg.
        # It is also possible to configure the loglevel for particular
        # modules, e.g.
        #LogLevel info ssl:warn

        ErrorLog ${APACHE_LOG_DIR}/error.log
        CustomLog ${APACHE_LOG_DIR}/access.log combined

        # For most configuration files from conf-available/, which are
        # enabled or disabled at a global level, it is possible to
        # include a line for only one particular virtual host. For example the
        # following line enables the CGI configuration for this host only
        # after it has been globally disabled with "a2disconf".
        #Include conf-available/serve-cgi-bin.conf

        #ProxyPass / http://localhost:8080/
        #ProxyPassReverse / http://localhost:8080/
        #ProxyPreserveHost On
        #ProxyRequests off
</VirtualHost>

sudo a2ensite gearman

cd /var/www/gearman
geany .htaccess
#replace
<IfModule mod_rewrite.c>
    Options -MultiViews

    RewriteEngine On
    RewriteCond %{REQUEST_FILENAME} !-f
    RewriteRule ^ index.php [L]
</IfModule>
#by
<IfModule mod_rewrite.c>
    Options -MultiViews

    RewriteEngine On
    #RewriteBase /path/to/app
    RewriteCond %{REQUEST_FILENAME} !-f
    RewriteRule ^ index.php [QSA,L]
</IfModule>

cd /workspace/gearman-ui/app/config
cp gearmanui.yml.dist gearmanui.yml

sudo service apache2 reload

#See https://localhost/gearman/#/status
#https://home.nabla.mobi/gearman/

less /var/log/apache2/error.log

#or standalone
#cd /workspace/gearman-ui/
#php -S localhost:8580 -t web web/index.php

less /workspace/gearman-ui/app/logs/gearmanui.log

#check gearman behavior
gearadmin --status
gearadmin --status --host 150.151.160.25
#http://stefaanlippens.net/gearman_setting_worker_process_arguments_through_xargs

telnet 150.151.160.25 4730
#then type
workers
status

sudo apt-get install php5-dev
sudo pecl install gearman-beta

sudo nano /etc/php5/apache2/php.ini
date.timezone= "Europe/Paris"

sudo pecl install gearman
#You should add "extension=gearman.so" to php.ini

#http://docs.openstack.org/infra/publications/gearman-plugin/#(20)
#openstack integration
#Remove everything
#sudo apt-get purge apache2*
sudo apt-get remove apache2
sudo apt-get install apache2
sudo apt-get install php5
sudo apt-get install libapache2-mod-php5
sudo /etc/init.d/apache2 restart

#http://doc.ubuntu-fr.org/apache2
ll /etc/apache2/
ll /var/www/

#config
/etc/apache2/apache2.conf
#site available
cat /etc/apache2/sites-available/default

sudo /etc/init.d/apache2 restart

#info localhost
cat /etc/hosts

#liste users
#cat /etc/passwd
root
albandri
crowd
tomcat6
webadmin

#securiser apache
sudo adduser webadmin
sudo addgroup data
sudo adduser webadmin data

#Modification des proprietaires de tous les fichiers et dossiers du repertoire :
sudo chown -Rf webadmin:data /var/www
#RÉPERTOIRES lecture et execution pour le group data et ecriture pour le proprietaire 750 :
sudo find /var/www -type d -exec chmod 750 {} \;
#FICHIERS lecture pour data et creation pour le proprietaire 640 :
sudo find  /var/www -type f -exec chmod 640 {} \;
#alternativement, pour modifier les droits (mais pas les proprietaires), il est possible d'utiliser les deux commandes suivantes:

sudo chmod -R 644 /var/www
#l'interet est de ne pas lancer une multitude de commandes pour changer les droits (find lance la commande a chaque fois qu'il trouve un fichier correspondant) qui a pour effet de mettre le proprietaire comme etant le seul avec droit de lecture et

sudo chmod -R a+X /var/www
#qui ajoute le droit x aux dossiers uniquement (droit de traverser)

#cgi dans /usr/lib/cgi-bin
cd /usr/lib
sudo ln -s /workspace/philesight/philesight.cgi philesight.cgi

tail -f /var/log/apache2/error.log

-----------------------------------------------------------------------

sudo ufw status
sudo iptables -A INPUT -p tcp -m tcp --dport 7070 -j ACCEPT
netstat -an | grep 7070
netstat -tlnp | grep 7070
nmap -v -sV -PN albandri
sudo lsof -i :7070
sudo lsof -i tcp:443

From the machine 192.168.0.29 run the following and post back here.
To list listening devices and ports
sudo netstat -lnp
sudo netstat -an | grep LISTEN

To list firewall settings
sudo iptables -L

List running processes and the ports open for those processes.
sudo rpcinfo -p

To check what outbound connections you have running.
sudo lsof -i -P -n

To check for open ports on the network
sudo nmap -sV 192.168.0.29
sudo nmap -p 80,7070 192.168.0.0-255
sudo nmap -sS -O -p80,8180,7070 192.168.0.0/24
sudo nmap localhost

To check one particular open port on a server
telnet <IP> 3389

--------- change apache to port 7070 -----------
#http://www.cyberciti.biz/faq/linux-apache2-change-default-port-ipbinding/
sudo nano /etc/apache2/ports.conf
#change
#NameVirtualHost *:80
#Listen 80
#Listen 127.0.0.1:7070
Listen 7070
#Gearman
Listen 7071
#Jenkins
Listen 7072
#Nabla
Listen 7073
#Sample
Listen 7074
#Use below to allow everybody to access apache on port 8080
#Listen 8080
#Listen 80

#Use below to allow everybody to access apache on port 7070
#Listen 7070
#Listen *:7070

-----------------------------------------------------------------------

#http://technique.arscenic.org/lamp-linux-apache-mysql-php/apache/modules-complementaires/article/mod_proxy-rediriger-en-tout

/etc/init.d/apache2 reload        

ls -lrta /etc/apache2/conf-enabled

cd /etc/apache2/sites-available
sudo vim 000-default.conf
or
sudo vim /etc/apache2/sites-available/nabla.conf
sudo a2dissite 000-default
sudo a2ensite nabla
sudo a2ensite jenkins
sudo a2ensite gearman
sudo a2ensite sample
sudo a2enmod rewrite
sudo a2enmod proxy
sudo a2enmod ssl
sudo a2enmod proxy_http
 
#check site that are enable at
cd /etc/apache2/sites-enabled

<VirtualHost *:7070>
        # The ServerName directive sets the request scheme, hostname and port that
        # the server uses to identify itself. This is used when creating
        # redirection URLs. In the context of virtual hosts, the ServerName
        # specifies what hostname must appear in the request's Host: header to
        # match this virtual host. For the default virtual host (this file) this
        # value is not decisive as it is used as a last resort host regardless.
        # However, you must set it for any further virtual host explicitly.
        ServerName www.home.nabla.mobi

        ServerAdmin alban.andrieu@nabla.mobi
        DocumentRoot /var/www/nabla

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

        ProxyPass / http://localhost:7070/
        ProxyPassReverse / http://localhost:7070/
        ProxyPreserveHost On
        #ProxyRequests off
</VirtualHost>

#https://confluence.atlassian.com/display/DOC/Using+Apache+with+virtual+hosts+and+mod_proxy

Add the following to your Apache httpd.conf:

# Put this after the other LoadModule directives
LoadModule proxy_module /usr/lib/apache2/modules/mod_proxy.so
LoadModule proxy_http_module /usr/lib/apache2/modules/mod_proxy_http.so
 
# Put this with your other VirtualHosts, or at the bottom of the file
NameVirtualHost *
<VirtualHost *>
    ServerName confluence.example.com
 
    ProxyRequests Off
    <Proxy *>
        Order deny,allow
        Allow from all
    </Proxy>
 
    ProxyPass / http://confluence-app-server.internal.example.com:8090/
    ProxyPassReverse / http://confluence-app-server.internal.example.com:8090/
    <Location />
        Order allow,deny
        Allow from all
    </Location>
</VirtualHost>
<VirtualHost *>
    ServerName jira.example.com
 
    ProxyRequests Off
    <Proxy *>
        Order deny,allow
        Allow from all
    </Proxy>
 
    ProxyPass / http://jira-app-server.internal.example.com:7070/
    ProxyPassReverse / http://jira-app-server.internal.example.com:7070/
    <Location />
        Order allow,deny
        Allow from all
    </Location>
</VirtualHost>

TODO : http://blog.xn--hry-bma.com/article9/configurer-un-reverse-proxy-apache-http-https

http://insecure.org/cgi-bin/

------ NMAP: NEW SERVICE FINGERPRINT ------
Date/Time: 2013-11-15 00:43:49
Contributor: Alban Andrieu <alban.andrieu@free.fr>

Service: http
OS: Ubuntu
Device: 
Application: apache
Version: 1.0

Notes:


Fingerprint:
SF-Port22-TCP:V=6.40%I=7%D=11/15%Time=52856A44%P=i686-pc-linux-gnu%r(NULL,SF:29,"SSH-2\.0-OpenSSH_6\.2p2\x20Ubuntu-6ubuntu0\.1\r\n");

-------------------------------------------

#check error doing
sudo apache2ctl restart

#Fix error : apache2: Could not reliably determine the server's fully qualified domain name, using 127.0.1.1 for ServerName
#http://blog2fouine.free.fr/index.php/42/2008/05/corriger-lerreur-could-not-determine-domain-name-for-servername/
sudo nano /etc/hosts
127.0.0.1	localhost.localdomain localhost ubuntu
#or change /etc/apache2/httpd.conf
#add line ServerName localhost

#remove mpm package
#sudo apt-get purge apache2
sudo apt-get remove apache2-mpm-prefork

sudo service apache2 restart

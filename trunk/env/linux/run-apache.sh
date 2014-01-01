sudo apt-get install apache2
sudo apt-get install php5
sudo apt-get install libapache2-mod-php5
sudo /etc/init.d/apache2 restart

#http://doc.ubuntu-fr.org/apache2
ll /etc/apache2/
ll /var/www/

config
 /etc/apache2/apache2.conf
site available
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
sudo iptables -A INPUT -p tcp -m tcp --dport 8080 -j ACCEPT
netstat -an | grep 8080
nmap -v -sV -PN albandri
sudo lsof -i :8080

From the machine 192.168.0.29 run the following and post back here.
To list listening devices and ports
sudo netstat -lnp

To list firewall settings
sudo iptables -L

List running processes and the ports open for those processes.
sudo rpcinfo -p

To check what outbound connections you have running.
sudo lsof -i -P -n

To check for open ports on the network
sudo nmap -sV 192.168.0.29
sudo nmap -p 80,8080 192.168.0.0-255
sudo nmap -sS -O -p80,8180,8080 192.168.0.0/24
sudo nmap localhost

--------- change apache to port 8080 -----------
sudo nano /etc/apache2/ports.conf
#change
#NameVirtualHost *:80
#Listen 80
#NameVirtualHost *:8080
Listen *:8080

-----------------------------------------------------------------------

#http://technique.arscenic.org/lamp-linux-apache-mysql-php/apache/modules-complementaires/article/mod_proxy-rediriger-en-tout

/etc/init.d/apache2 reload        

cd /etc/apache2/sites-available
sudo vim 000-default.conf
or
sudo vim /etc/apache2/sites-available/nabla.conf
sudo a2ensite nabla
sudo a2ensite jenkins
sudo a2enmod rewrite
sudo a2enmod proxy
sudo a2enmod ssl

<VirtualHost *:8080>
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

        ProxyPass / http://localhost:8080/
        ProxyPassReverse / http://localhost:8080/
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
 
    ProxyPass / http://jira-app-server.internal.example.com:8080/
    ProxyPassReverse / http://jira-app-server.internal.example.com:8080/
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
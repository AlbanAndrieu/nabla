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

sudo iptables -A INPUT -p tcp -m tcp --dport 8080 -j ACCEPT
netstat -an | grep 8080
sudo lsof -i :8080
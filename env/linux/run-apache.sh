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

#Modification des propriétaires de tous les fichiers et dossiers du répertoire :
sudo chown -Rf webadmin:data /var/www
#RÉPERTOIRES lecture et exécution pour le group data et écriture pour le propriétaire 750 :
sudo find /var/www -type d -exec chmod 750 {} \;
#FICHIERS lecture pour data et creation pour le propriétaire 640 :
sudo find  /var/www -type f -exec chmod 640 {} \;
#alternativement, pour modifier les droits (mais pas les propriétaires), il est possible d'utiliser les deux commandes suivantes:

sudo chmod -R 644 /var/www
#l'interet est de ne pas lancer une multitude de commandes pour changer les droits (find lance la commande à chaque fois qu'il trouve un fichier correspondant) qui a pour effet de mettre le propriétaire comme étant le seul avec droit de lecture et

sudo chmod -R a+X /var/www
#qui ajoute le droit x aux dossiers uniquement (droit de traverser)


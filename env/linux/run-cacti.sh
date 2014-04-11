#http://fr.wikipedia.org/wiki/Cacti
#http://doc.ubuntu-fr.org/cacti

sudo apt-get install apache2 mysql-server php5
sudo apt-get install php5-mysql php5-cgi php5-cli php5-snmp php-pear snmp snmpd
sudo apt-get install rrdtool
sudo apt-get install cacti

#https://localhost/cacti/install/
#https://home.nabla.mobi/cacti/index.php
User Name : admin
Password : admin
Password : microsoft

#See
ll /usr/bin/rrdtool
ll /var/log/cacti/cacti.log

#http://doc.ubuntu-fr.org/tutoriel/configurer_snmp_pour_utiliser_cacti_depuis_une_machine_distante
#for cacti
sudo apt-get install snmp snmpd

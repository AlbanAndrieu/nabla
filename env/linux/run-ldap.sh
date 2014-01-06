#http://www.youtube.com/watch?v=DM_UQVVVtoY
#http://www.debuntu.org/ldap-server-and-linux-ldap-clients

#remove if you want
#sudo aptitude purge slapd ldap-utils
#sudo rm /var/lib/ldap/*
#sudo rm  -rf /etc/ldap

sudo apt-get install slapd ldap-utils migrationtools

sudo dpkg-reconfigure slapd
Omit OpenLDAP server configuration? ... No
DNS domain name: ... ldap.nabla.mobi
Name of your organization: ... nabla
Admin Password: microsoft
Confirm Password: microsoft
OK
BDB
Do you want your database to be removed when slapd is purged? ... No
Move old database? ... Yes
Allow LDAPv2 Protocol? ... No 

#test
ldapsearch -x -b dc=ldap,dc=nabla,dc=mobi
ldapsearch -x -h localhost -b "dc=ldap,dc=nabla,dc=mobi" "(objectClass=*)"

#tosee
#http://www.ghacks.net/2010/09/02/adding-ldap-entries-from-the-command-line/

#Install phpLDAPadmin
#http://www.ghacks.net/2010/08/30/manage-your-ldap-data-with-phpldapadmin/
sudo apt-get install php5-ldap 
sudo cp phpldapadmin-1.2.3.tgz  /var/www/
sudo tar xvfz phpldapadmin-1.2.3.tgz
sudo mv phpldapadmin-1.2.3 phpldapadmin
cd /var/www/phpldapadmin/config
sudo mv config.php.example config.php

#restart
sudo /etc/init.d/apache2 restart
#ou
sudo service apache2 restart

#login
cn=admin,dc=ldap,dc=nabla,dc=mobi

add a user albandri with password like the developer workstation

#Connect ldap to google
#http://support.google.com/a/bin/answer.py?hl=fr&answer=106368
cd /opt/GoogleAppsDirSync
sudo ./config-manager
4/hITCFu3OkXtq96da9ysrgsMaFLlx.Eh-a-J3Bu7gXOl05ti8ZT3aRT0JKdgI

sudo dpkg-reconfigure ldap-auth-config

#http://doc.ubuntu-fr.org/ldap_client

sudo service slapd status

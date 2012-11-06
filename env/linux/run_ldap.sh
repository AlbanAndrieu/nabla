#http://www.debuntu.org/ldap-server-and-linux-ldap-clients

#remove if you want
#sudo aptitude purge slapd ldap-utils
#sudo rm /var/lib/ldap/*
#sudo rm  -rf /etc/ldap

sudo apt-get install slapd ldap-utils migrationtools
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

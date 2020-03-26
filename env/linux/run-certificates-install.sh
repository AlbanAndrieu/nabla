#!/bin/bash
set -xv

#https://guide.ubuntu-fr.org/server/certificates-and-security.html

#First try on workstation to create new certificate for this server

#1 - I first prepared my wnvironement
#Doing : https://howto.biapy.com/en/debian-gnu-linux/servers/http/create-a-ssl-tls-certificate-on-debian
sudo apt-get install openssl ssl-cert
sudo apt-get install certbot

mkdir --parent '/etc/ssl/private'
#mkdir --parent '/etc/ssl/requests'
#mkdir --parent '/etc/ssl/roots'
#mkdir --parent '/etc/ssl/chains'
#mkdir --parent '/etc/ssl/certificates'
#mkdir --parent '/etc/ssl/authorities'
#mkdir --parent '/etc/ssl/configs'


sudo addgroup --system 'ssl-cert'
sudo chown -R root:ssl-cert '/etc/ssl/private'
sudo chmod 710 '/etc/ssl/private'
sudo chmod 440 '/etc/ssl/private/'

#SSL_KEY_NAME="$(command hostname --fqdn)"
export SSL_KEY_NAME="albandrieu.com"

#CONF_FILE="$(command mktemp)"
#sed \
#    -e "s/@HostName@/${SSL_KEY_NAME}/" \
#    -e "s|privkey.pem|/etc/ssl/private/${SSL_KEY_NAME}.pem|" \
#    '/usr/share/ssl-cert/ssleay.cnf' > "${CONF_FILE}"
#openssl req -config "${CONF_FILE}" -new -x509 -days 3650 \
#    -nodes -out "/etc/ssl/certificates/${SSL_KEY_NAME}.crt" -keyout "/etc/ssl/private/${SSL_KEY_NAME}.key"
#rm "${CONF_FILE}"
#
#ll /etc/ssl/private/albandri.albandrieu.com.key
#
#chown root:ssl-cert "/etc/ssl/private/${SSL_KEY_NAME}.key"
#chmod 440 "/etc/ssl/private/${SSL_KEY_NAME}.key"

#2 - Creating the private key with a 2048 bits length

if [ -e '/etc/ssl/csr-informations' ]; then
    source '/etc/ssl/csr-informations'
    cat '/etc/ssl/csr-informations'
else
    echo -e "

#####################
Error: No SSL informations available."
fi

SSL_COUNTRY="fr"
SSL_PROVINCE="IleDeFrance"
SSL_CITY="Paris"
SSL_EMAIL="alban.andrieu@free.fr"

echo -e "# SSL CSR informations.
SSL_COUNTRY=\"${SSL_COUNTRY}\"
SSL_PROVINCE=\"${SSL_PROVINCE}\"
SSL_CITY=\"${SSL_CITY}\"
SSL_EMAIL=\"${SSL_EMAIL}\"" \
    > '/etc/ssl/csr-informations'

openssl genrsa -out "/etc/ssl/private/${SSL_KEY_NAME}.key" 2048
#openssl genrsa -out "/etc/pki/tls/private/${SSL_KEY_NAME}.key" 2048
chown root:ssl-cert "/etc/ssl/private/${SSL_KEY_NAME}.key"
chmod 440 "/etc/ssl/private/${SSL_KEY_NAME}.key"

cd /etc/ssl/private/
openssl rsa -in /etc/ssl/private/${SSL_KEY_NAME}.key -text -noout
openssl rsa -in /etc/ssl/private/${SSL_KEY_NAME}.key -pubout -out ${SSL_KEY_NAME}.pem

ls -lrt /etc/ssl/private/

exit 0

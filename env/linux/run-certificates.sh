#https://guide.ubuntu-fr.org/server/certificates-and-security.html

First try on workstation to create new certificate for this server

#1 - I first prepared my wnvironement
#Doing : https://howto.biapy.com/en/debian-gnu-linux/servers/http/create-a-ssl-tls-certificate-on-debian
sudo apt-get install openssl ssl-cert

mkdir --parent '/etc/ssl/private'
mkdir --parent '/etc/ssl/requests'
mkdir --parent '/etc/ssl/roots'
mkdir --parent '/etc/ssl/chains'
mkdir --parent '/etc/ssl/certificates'
mkdir --parent '/etc/ssl/authorities'
mkdir --parent '/etc/ssl/configs'

addgroup --system 'ssl-cert'
chown -R root:ssl-cert '/etc/ssl/private'
chmod 710 '/etc/ssl/private'
chmod 440 '/etc/ssl/private/'

SSL_KEY_NAME="$(command hostname --fqdn)"
SSL_KEY_NAME="nabla.freeboxos.fr"

#CONF_FILE="$(command mktemp)"
#sed \
#    -e "s/@HostName@/${SSL_KEY_NAME}/" \
#    -e "s|privkey.pem|/etc/ssl/private/${SSL_KEY_NAME}.pem|" \
#    '/usr/share/ssl-cert/ssleay.cnf' > "${CONF_FILE}"
#openssl req -config "${CONF_FILE}" -new -x509 -days 3650 \
#    -nodes -out "/etc/ssl/certificates/${SSL_KEY_NAME}.crt" -keyout "/etc/ssl/private/${SSL_KEY_NAME}.key"
#rm "${CONF_FILE}"
#
#ll /etc/ssl/private/albandri.nabla.mobi.key
#
#chown root:ssl-cert "/etc/ssl/private/${SSL_KEY_NAME}.key"
#chmod 440 "/etc/ssl/private/${SSL_KEY_NAME}.key"

#2 - Creating the private key with a 2048 bits length

if [ -e '/etc/ssl/csr-informations' ]; then
    source '/etc/ssl/csr-informations'
    cat '/etc/ssl/csr-informations'
else
    echo "

#####################
Error: No SSL informations available."
fi

SSL_COUNTRY="fr"
SSL_PROVINCE="IleDeFrance"
SSL_CITY="Paris"
SSL_EMAIL="alban.andrieu@free.fr"

echo "# SSL CSR informations.
SSL_COUNTRY=\"${SSL_COUNTRY}\"
SSL_PROVINCE=\"${SSL_PROVINCE}\"
SSL_CITY=\"${SSL_CITY}\"
SSL_EMAIL=\"${SSL_EMAIL}\"" \
    > '/etc/ssl/csr-informations'

openssl genrsa -out "/etc/ssl/private/${SSL_KEY_NAME}.key" 2048
#openssl genrsa -out "/etc/pki/tls/private/${SSL_KEY_NAME}.key" 2048
chown root:ssl-cert "/etc/ssl/private/${SSL_KEY_NAME}.key"
chmod 440 "/etc/ssl/private/${SSL_KEY_NAME}.key"

openssl rsa -in /etc/ssl/private/${SSL_KEY_NAME}.key -text -noout
openssl rsa -in /etc/ssl/private/${SSL_KEY_NAME}.key -pubout -out ${SSL_KEY_NAME}.pem

#CSR
openssl req -new \
    -key "/etc/ssl/private/${SSL_KEY_NAME}.key" \
    -out "/etc/ssl/requests/${SSL_KEY_NAME}.csr" \
    <<< "${SSL_COUNTRY}
${SSL_PROVINCE}
${SSL_CITY}
${SSL_KEY_NAME}

${SSL_KEY_NAME}
${SSL_EMAIL}

"

#CSR with SAN
openssl req -new -sha256 \
    -key "/etc/ssl/private/${SSL_KEY_NAME}.key" \
    -subj "/C=FR/ST=IleDeFrance/O=Misys, Inc./CN=${SSL_KEY_NAME}" \
    -reqexts SAN \
    -config <(cat /etc/ssl/openssl.cnf \
        <(printf "[SAN]\nsubjectAltName=DNS:${SSL_KEY_NAME},DNS:nabla.mobi,DNS:home.nabla.mobi,DNS:alban-andrieu.fr,DNS:alban-andrieu.com,DNS:alban-andrieu.eu,DNS:bababou.fr,DNS:bababou.eu,IP:82.231.208.223,IP:192.168.0.29,IP:127.0.0.1")) \
    -out "/etc/ssl/requests/${SSL_KEY_NAME}.csr"

cat "/etc/ssl/requests/${SSL_KEY_NAME}.csr"
openssl req -in ${SSL_KEY_NAME}.csr -text -noout

#3 - Obtaining the public key from certification authority

cd /etc/ssl/requests/
certnew-der.cer
certnew-der.p7b
certnew-bin.cer
certnew-bin.p7b
#https://www.sslshopper.com/ssl-converter.html
#I would need to Convert certificate from DER to PEM format.
openssl x509 -inform DER -outform PEM -in certnew-der.cer -out albandri.pem
#for sonar

#4 - export certificat to pkcs12
openssl pkcs12 -export -in ${SSL_KEY_NAME}.pem -inkey /etc/ssl/private/${SSL_KEY_NAME}.key -out ${SSL_KEY_NAME}.pkcs12 -name ${SSL_KEY_NAME}
#5 - export certificat to jks
keytool -importkeystore -srckeystore albandri.pkcs12 -srcstoretype pkcs12 -destkeystore albandri.jks -deststoretype JKS

#6 - configure sonar
#http://docs.sonarqube.org/display/SONARQUBE44/Running+SonarQube+Over+HTTPS
sonar.web.https.keyAlias=albandri
sonar.web.https.keyPass=password
#sonar.web.https.keystoreFile=/etc/ssl/requests/albandri.pkcs12
sonar.web.https.keystoreFile=/etc/ssl/requests/albandri.jks
sonar.web.https.keystorePass=
#sonar.web.https.keystoreType=PKCS12
sonar.web.https.keystoreType=JKS

########################################################
#http://superuser.com/questions/104146/add-permanent-ssl-certificate-exception-in-chrome-linux
#http://wiki.cacert.org/FAQ/BrowserClients

stash.nabla.mobi.crt

wget -O cacert-root.crt "http://www.cacert.org/certs/root.crt"
wget -O cacert-class3.crt "http://www.cacert.org/certs/class3.crt"

certutil -d sql:$HOME/.pki/nssdb -A -t TC -n "CAcert.org" -i cacert-root.crt
certutil -d sql:$HOME/.pki/nssdb -A -t TC -n "CAcert.org Class 3" -i cacert-class3.crt

certutil -L -d  sql:$HOME/.pki/nssdb

sudo certutil -d sql:$HOME/.pki/nssdb -A -t P -n "Stash" -i stash.nabla.mobi.crt
sudo certutil -d sql:$HOME/.pki/nssdb -A -t TC -n "Stash" -i stash.nabla.mobi.crt
#http://blog.tkassembled.com/410/adding-a-certificate-authority-to-the-trusted-list-in-ubuntu/
#certutil -d sql:$HOME/.pki/nssdb -A -n "Stash" -i stash.nabla.mobi.crt -t P,P,P
#certutil -d sql:$HOME/.pki/nssdb -A -n 'Stash' -i stash.nabla.mobi.crt -t TCP,TCP,TCP
sudo certutil -D -n Stash -d sql:$HOME/.pki/nssdb

#https://help.ubuntu.com/community/OpenSSL#SSL%20Certificates
sudo apt-cache search libssl | grep SSL
openssl version
openssl -h enc
openssl ciphers -v
openssl speed

sudo keytool -import -alias ca -file ~/Downloads/crowd.crt -keystore cacerts -storepass changeit

#https://confluence.atlassian.com/kb/unable-to-connect-to-ssl-services-due-to-pkix-path-building-failed-779355358.html
TEST :
wget https://confluence.atlassian.com/kb/files/779355358/SSLPoke.class
java -Djavax.net.ssl.trustStore=/etc/ssl/certs/java/cacerts -Djavax.net.debug=true SSLPoke crowd 443

openssl x509 -noout -fingerprint -in ~/Downloads/crowd.crt
#as root
openssl x509 -noout -hash -in /home/albandri/Downloads/crowd.crt
ln -s /home/albandri/Downloads/crowd.crt `openssl x509 -hash -noout -in /home/albandri/Downloads/crowd.crt`.0
#openssl verify -CApath <ssl-base-dir>certs /home/albandri/Downloads/crowd.crt
openssl verify -CAfile /home/albandri/Downloads/crowd.crt /home/albandri/Downloads/crowd.crt
openssl verify -CApath /usr/lib/ssl/certs /home/albandri/Downloads/crowd.crt
openssl verify /home/albandri/Downloads/crowd.crt

openssl s_client -connect crowd:443 -CApath /etc/ssl/certs
openssl s_client -connect crowd:443 -showcerts
openssl s_client -connect google.com:443 -showcerts

#http://blog.donovan-jimenez.com/2011/03/adding-new-trusted-certificate-on.html
/etc/ssl/certs
less /etc/ssl/certs/ca.pem

#dpkg-reconfigure ca-certificates

#http://www.herongyang.com/Cryptography/OpenSSL-Certificate-Path-Validation-Tests.html

This problem is common, you need to ask to your provider for the:

Root CA
Intermediate CA

cd $JAVA_HOME/jre/lib/security/
cacerts -> /etc/ssl/certs/java/cacerts

java -Djavax.net.ssl.trustStore=/etc/ssl/certs/java/cacerts -Djavax.net.debug=true SSLPoke crowd 443

#Add certificates
#http://kb.kerio.com/product/kerio-connect/server-configuration/ssl-certificates/adding-trusted-root-certificates-to-the-server-1605.html

#Ubuntu
#http://superuser.com/questions/437330/how-do-you-add-a-certificate-authority-ca-to-ubuntu
cd /usr/local/share/ca-certificates
sudo cp /etc/ssl/requests/certnew.cer albandri.crt
sudo cp ~/Downloads/UK1VSWCERT01-CA.cer UK1VSWCERT01-CA.crt
#~ #count the number of certificate in a file
cat ~/Downloads/crowd.crt | grep 'BEGIN.* CERTIFICATE' | wc -l
sudo update-ca-certificates
less /etc/ssl/certs/ca-certificates.crt

#RedHat 5
#cat UK1VSWCERT01-CA.crt >> /etc/pki/tls/certs/ca-bundle.crt

#or
cd ~/Downloads
sudo cp *.crt /usr/share/ca-certificates/
sudo dpkg-reconfigure ca-certificates
ask

#RedHat
yum update ca-certificates
#check enable
update-ca-trust check
update-ca-trust enable
update-ca-trust force-enable
cp /files/sonar/sonarqube-4.5.5/*.crt  /etc/pki/ca-trust/source/anchors/
update-ca-trust extract

cd /files/sonar/sonarqube-4.5.5
java -Djavax.net.ssl.trustStore=/files/sonar/sonarqube-4.5.5/bin/linux-x86-64/cacerts -Djavax.net.debug=true SSLPoke crowd 443
java -Djavax.net.ssl.trustStore=/etc/pki/java/cacerts -Djavax.net.debug=true SSLPoke crowd 443

#sudo keytool -import -alias crowd -file /files/sonar/sonarqube-4.5.5/crowd.crt -keystore cacerts -storepass changeit
#sudo keytool -import -alias crowd -file /files/sonar/sonarqube-4.5.5/crowd.crt -keystore /files/sonar/sonarqube-4.5.5/bin/linux-x86-64/cacerts -storepass changeit
sudo keytool -import -alias crowd -file /files/sonar/sonarqube-4.5.5/crowd.crt -keystore /etc/pki/java/cacerts -storepass changeit
sudo keytool -import -alias crowd -file /files/sonar/sonarqube-4.5.5/crowd.crt -keystore /usr/java/jre1.8.0_77/lib/security/cacerts -storepass changeit

#On Ubuntu
#http://blog.chmouel.com/2010/06/03/connecting-to-self-signed-ssl-certificate-from-java-on-debian-ubuntu/
#On ubuntu sudo update-ca-certificates should add your certificate to the java keystore, you can check it with the command (Enter for Password) :
keytool -list -v -keystore /etc/ssl/certs/java/cacerts
ls -lrta $JAVA_HOME/jre/lib/security/

keytool -list -keystore  /etc/ssl/certs/java/cacerts -alias debian:uk1vswcert01-ca.pem
keytool -list -keystore  /etc/ssl/certs/java/cacerts -alias debian:uk1vswcert01-ca-4.pem

#get root CA
openssl s_client -connect google.com:443 < /dev/null | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > ca.crt

#freebox
#http://blogmotion.fr/internet/lets-encrypt-freebox-https-14299

#https://certbot.eff.org/#ubuntutrusty-apache
#sudo apt-get install python-letsencrypt-apache
#sudo apt install letsencrypt
#cd /usr/local/sbin
#sudo wget https://dl.eff.org/certbot-auto
#sudo chmod a+x /usr/local/sbin/certbot-auto
#/usr/local/sbin/certbot-auto certonly --apache -d nabla.freeboxos.fr 
/var/log/letsencrypt/letsencrypt.log

#Saving debug log to /var/log/letsencrypt/letsencrypt.log          
#Starting new HTTPS connection (1): acme-v01.api.letsencrypt.org   
#Obtaining a new certificate                                       
#Performing the following challenges:                              
#tls-sni-01 challenge for nabla.freeboxos.fr                       
#Waiting for verification...                                       
#Cleaning up challenges                                            
#Generating key (2048 bits):                                       
#/etc/letsencrypt/keys/0000_key-certbot.pem                        
#Creating CSR: /etc/letsencrypt/csr/0000_csr-certbot.pem 
#
#- Congratulations! Your certificate and chain have been saved at
#   /etc/letsencrypt/live/nabla.freeboxos.fr-0001/fullchain.pem. Your
#   cert will expire on 2017-04-03. To obtain a new or tweaked version
#   of this certificate in the future, simply run certbot-auto again.
#   To non-interactively renew *all* of your certificates, run
#   "certbot-auto renew"
# - If you like Certbot, please consider supporting our work by:
#
#   Donating to ISRG / Let's Encrypt:   https://letsencrypt.org/donate
#   Donating to EFF:                    https://eff.org/donate-le

/etc/apache2/sites-enabled/default-ssl.conf
#/etc/letsencrypt/live/nabla.freeboxos.fr-0001/cert.pem
#/etc/letsencrypt/live/nabla.freeboxos.fr-0001/privkey.pem
service apache2 restart
tail -f /var/log/apache2/error.log

#letsencrypt \
#    certonly \
#    --config ~/.config/letsencrypt/letsencrypt.conf \
#    --csr /etc/ssl/requests/nabla.freeboxos.fr.csr \
#    --cert-path /etc/ssl/nabla.freeboxos.fr/nabla.freeboxos.fr.pem \
#    --chain-path /etc/ssl/nabla.freeboxos.fr/chain.pem \
#    --fullchain-path /etc/ssl/nabla.freeboxos.fr/cert+chain.pem \
#    --authenticator letsencrypt-ssh:ssh \
#    --letsencrypt-ssh:ssh-server albandri@home.nabla.mobi \
#    --domains nabla.mobi,www.nabla.mobi,home.nabla.mobi,nabla.freeboxos.fr,alban-andrieu.fr,alban-andrieu.com,alban-andrieu.eu,bababou.fr,bababou.eu
#    
#nano ~/.config/letsencrypt/letsencrypt.conf
#config-dir = /home/albandri/.config/letsencrypt
#work-dir = /home/albandri/.local/share/letsencrypt
#logs-dir = /home/albandri/.local/share/letsencrypt
#email = alban.andrieu@free.fr
#non-interactive
#agree-tos
    
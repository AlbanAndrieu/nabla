#!/bin/bash
set -xv

./run-certificates-install.sh


#Permission --w-rwxr-T
#chmod 1274 ${SSL_KEY_NAME}.pem

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
    -subj "/C=FR/ST=IleDeFrance/O=Nabla, Inc./CN=${SSL_KEY_NAME}" \
    -reqexts SAN \
    -config <(cat /etc/ssl/openssl.cnf \
        <(printf "[SAN]\nsubjectAltName=DNS:${SSL_KEY_NAME},DNS:albandrieu.com,DNS:home.albandrieu.com,DNS:freenas.albandrieu.com,DNS:jenkins.albandrieu.com,DNS:sample.albandrieu.com,DNS:alban-andrieu.fr,DNS:alban-andrieu.com,DNS:alban-andrieu.eu,DNS:bababou.fr,DNS:bababou.eu,IP:82.253.244.162.223,IP:192.168.1.42,IP:192.168.0.29,IP:127.0.0.1")) \
    -out "/etc/ssl/requests/${SSL_KEY_NAME}.csr"

cat "/etc/ssl/requests/${SSL_KEY_NAME}.csr"
openssl req -in /etc/ssl/requests/${SSL_KEY_NAME}.csr -text -noout

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

#Install certutil
sudo apt-get install libnss3-tools

##### Chrome
# Find nssdb directory.
find $HOME -name nssdb

# Make a backup.
cp $HOME/.pki/nssdb{,.orig}

certutil -A -i /usr/local/share/ca-certificates/nabla.crt -n nabla -t "C,," -d sql:$HOME/.pki/nssdb/

##### Firefox
# Find cert8.db and key3.db files.
find $HOME -name cert8.db
find $HOME -name key3.db

# Make a backup.
cp $HOME/firefox-profile-directory/cert8.db{,.orig}
cp $HOME/firefox-profile-directory/key3.db{,.orig}

certutil -A -i /usr/local/share/ca-certificates/nabla.crt -n nabla -t "C,," -d $HOME/firefox-profile-directory/

#wget -O cacert-root.crt "http://www.cacert.org/certs/root.crt"
#wget -O cacert-class3.crt "http://www.cacert.org/certs/class3.crt"
#
#certutil -d sql:$HOME/.pki/nssdb -A -t TC -n "CAcert.org" -i cacert-root.crt
#certutil -d sql:$HOME/.pki/nssdb -A -t TC -n "CAcert.org Class 3" -i cacert-class3.crt
#
#certutil -L -d  sql:$HOME/.pki/nssdb
#
#sudo certutil -d sql:$HOME/.pki/nssdb -A -t P -n "Stash" -i stash.albandrieu.com.crt
#sudo certutil -d sql:$HOME/.pki/nssdb -A -t TC -n "Stash" -i stash.albandrieu.com.crt
##http://blog.tkassembled.com/410/adding-a-certificate-authority-to-the-trusted-list-in-ubuntu/
##certutil -d sql:$HOME/.pki/nssdb -A -n "Stash" -i stash.albandrieu.com.crt -t P,P,P
##certutil -d sql:$HOME/.pki/nssdb -A -n 'Stash' -i stash.albandrieu.com.crt -t TCP,TCP,TCP
#sudo certutil -D -n Stash -d sql:$HOME/.pki/nssdb

#https://help.ubuntu.com/community/OpenSSL#SSL%20Certificates
sudo apt-cache search libssl | grep SSL
openssl version
openssl -h enc
openssl ciphers -v
openssl speed

sudo keytool -import -alias ca -file ~/pki/ca.pem -keystore cacerts -storepass changeit

#https://confluence.atlassian.com/kb/unable-to-connect-to-ssl-services-due-to-pkix-path-building-failed-779355358.html
TEST :
wget https://confluence.atlassian.com/kb/files/779355358/SSLPoke.class
java -Djavax.net.ssl.trustStore=/etc/ssl/certs/java/cacerts -Djavax.net.debug=true SSLPoke crowd 443

openssl x509 -noout -fingerprint -in~/pki/ca.pem
#as root
openssl x509 -noout -hash -in ~/pki/ca.pem
ln -s ~/pki/ca.pem `openssl x509 -hash -noout -in /home/albandri/Downloads/crowd.crt`.0
#openssl verify -CApath <ssl-base-dir>certs /home/albandri/Downloads/crowd.crt
openssl verify -CAfile ~/pki/ca.pem /home/albandri/Downloads/crowd.crt
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

#RedHat
ln -s /etc/pki/java/cacerts cacerts

java -Djavax.net.ssl.trustStore=/etc/ssl/certs/java/cacerts -Djavax.net.debug=true SSLPoke crowd 443

#Add certificates
#http://kb.kerio.com/product/kerio-connect/server-configuration/ssl-certificates/adding-trusted-root-certificates-to-the-server-1605.html

#Ubuntu
#http://superuser.com/questions/437330/how-do-you-add-a-certificate-authority-ca-to-ubuntu
cd /usr/local/share/ca-certificates
sudo cp /etc/ssl/requests/certnew.cer albandri.crt
#openssl s_client -showcerts -connect albandrieu.albandrieu.com:443 </dev/null 2>/dev/null |openssl x509 -outform PEM | tee ~/Downloads/docker.pem
#Get your intermediary certificat
sudo wget http://albandrieu.com/download/certs/NABLA-CA-1.crt
sudo cp ~/Downloads/*.crt .
#~ #count the number of certificate in a file
#cat ~/pki/ca.pem | grep 'BEGIN.* CERTIFICATE' | wc -l
sudo update-ca-certificates
#sudo dpkg-reconfigure ca-certificates
less /etc/ssl/certs/ca-certificates.crt

#Test it
curl --cacert /etc/ssl/certs/ https://albandrieu.com:8686/jenkins/
openssl s_client -connect albandrieu.albandrieu.com:443 -CApath /etc/ssl/certs
openssl s_client -showcerts -connect albandrieu.albandrieu.com:443

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

#https://www.ericluwj.com/2017/02/23/install-free-lets-encrypt-ssl-certificate-in-webmin.html

#Apache2

#https://doc.ubuntu-fr.org/ipv6
#https://jochen.kirstaetter.name/configure-ipv6-on-ubuntu/

sudo apt-get install miredo

#sudo ifconfig eth0 inet6 add fe80::226:b9ff:fedd:c008/64
sudo service networking restart

#Test IPv6 enable
test -f /proc/net/if_inet6 && echo "Running kernel is IPv6 ready"
#https://doc.ubuntu-fr.org/optimisation#desactiver_le_support_ipv6
ip link
rfkill list all
#sudo rfkill unblock all
#rfkill list all

ip a | grep inet6

ip -6 addr show
sudo ip -6 address show eth0

sudo netstat -tulpn | grep :80
sudo netstat -lnptu | grep "apache2\W*$"

sudo ifconfig -a
sudo ifconfig eth0

http://test-ipv6.com/

http://www.ipv6-test.com/
http://ipv6-test.com/validate.php
albandrieu.albandrieu.com

#freebox
#http://blogmotion.fr/internet/lets-encrypt-freebox-https-14299

#https://certbot.eff.org/#ubuntutrusty-apache
#sudo apt-get install python-letsencrypt-apache
#sudo apt install letsencrypt
sudo apt-get install certbot
#cd /usr/local/sbin
#sudo wget https://dl.eff.org/certbot-auto
#sudo chmod a+x /usr/local/sbin/certbot-auto
#/usr/local/sbin/certbot-auto certonly --apache -d albandrieu.albandrieu.com,albandrieu.com,home.albandrieu.com,alban-andrieu.fr,alban-andrieu.com,alban-andrieu.eu,bababou.fr,bababou.eu
/usr/local/sbin/certbot-auto certonly --renew-by-default --apache -d albandrieu.albandrieu.com
#/usr/local/sbin/certbot-auto certonly --renew-by-default --apache -d albandrieu.albandrieu.com,albandrieu.com,home.albandrieu.com,alban-andrieu.fr,alban-andrieu.com,alban-andrieu.eu,bababou.fr,bababou.eu

certbot-auto certonly --non-interactive --register-unsafely-without-email --agree-tos --expand --webroot --webroot-path /var/www/html --domain albandrieu.albandrieu.com

certbot certonly -w /var/www/html/ -d albandrieu.albandrieu.com --installer apache --webroot  --test-cert &> certbot.log

tail -f /var/log/letsencrypt/letsencrypt.log

cd /var/www/html/.well-known/acme-challenge
watch -n 0.1 ls -lRa

#Saving debug log to /var/log/letsencrypt/letsencrypt.log
#Starting new HTTPS connection (1): acme-v01.api.letsencrypt.org
#Obtaining a new certificate
#Performing the following challenges:
#tls-sni-01 challenge for albandrieu.albandrieu.com
#Waiting for verification...
#Cleaning up challenges
#Generating key (2048 bits):
#/etc/letsencrypt/keys/0000_key-certbot.pem
#Creating CSR: /etc/letsencrypt/csr/0000_csr-certbot.pem
#
#- Congratulations! Your certificate and chain have been saved at
#   /etc/letsencrypt/live/albandrieu.albandrieu.com-0001/fullchain.pem. Your
#   cert will expire on 2017-04-03. To obtain a new or tweaked version
#   of this certificate in the future, simply run certbot-auto again.
#   To non-interactively renew *all* of your certificates, run
#   "certbot-auto renew"
# - If you like Certbot, please consider supporting our work by:
#
#   Donating to ISRG / Let's Encrypt:   https://letsencrypt.org/donate
#   Donating to EFF:                    https://eff.org/donate-le

/etc/apache2/sites-enabled/default-ssl.conf
#TODO in webmin replace /etc/webmin/miniserv.pem by
#/etc/letsencrypt/live/albandrieu.albandrieu.com-0001/cert.pem
#/etc/letsencrypt/live/albandrieu.albandrieu.com-0001/privkey.pem
service apache2 restart
tail -f /var/log/apache2/error.log

#letsencrypt \
#    certonly \
#    --config ~/.config/letsencrypt/letsencrypt.conf \
#    --csr /etc/ssl/requests/albandrieu.albandrieu.com.csr \
#    --cert-path /etc/ssl/albandrieu.albandrieu.com/albandrieu.albandrieu.com.pem \
#    --chain-path /etc/ssl/albandrieu.albandrieu.com/chain.pem \
#    --fullchain-path /etc/ssl/albandrieu.albandrieu.com/cert+chain.pem \
#    --authenticator letsencrypt-ssh:ssh \
#    --letsencrypt-ssh:ssh-server albandri@home.albandrieu.com \
#    --domains albandrieu.com,www.albandrieu.com,home.albandrieu.com,albandrieu.albandrieu.com,alban-andrieu.fr,alban-andrieu.com,alban-andrieu.eu,bababou.fr,bababou.eu
#
#nano ~/.config/letsencrypt/letsencrypt.conf
#config-dir = /home/albandri/.config/letsencrypt
#work-dir = /home/albandri/.local/share/letsencrypt
#logs-dir = /home/albandri/.local/share/letsencrypt
#email = alban.andrieu@free.fr
#non-interactive
#agree-tos

ln -s /etc/webmin/miniserv.pem /etc/ssl/private/miniserv.pem
#sudo chmod 640 /etc/ssl/private/ssl-cert-snakeoil.key
ll /etc/ssl/private/ssl-cert-snakeoil.key
ln -s /etc/letsencrypt/keys/0001_key-certbot.pem 0001_key-certbot.pem

#Renew certificate
#rm ~/.local/share/letsencrypt -R
#rm -rf /opt/eff.org
sudo certbot-auto renew

#See https://gist.github.com/daronco/45eeb9223c57d240e60d094f8bee457e


A: 82.253.244.162
MX: aspmx2.googlemail.com
MX: alt2.aspmx.l.google.com
MX: alt1.aspmx.l.google.com
MX: aspmx.l.google.com
CNAME: _domainconnect.1and1.com

Domaine: albandrieu.com
Serveur de noms 1: ns1043.ui-dns.com
Serveur de noms 2: ns1043.ui-dns.org
Serveur de noms 3: ns1043.ui-dns.de
Serveur de noms 4: ns1043.ui-dns.biz
Adresse IP (A-record) : 82.253.244.162
Serveur email 1: alt1.aspmx.l.google.com ,5
Serveur email 2: alt2.aspmx.l.google.com ,5
Serveur email 3: aspmx2.googlemail.com ,10
Serveur email 4: aspmx.l.google.com ,1
Adresse IPv6 (AAAA-record) : 2a01:e35:2fdf:4a20:0:0:0:1

IPv4: 82.253.244.162
IPv6: 2a01:0e35:2fdf:4a20:0000:0000:0000:0001

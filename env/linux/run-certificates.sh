#https://guide.ubuntu-fr.org/server/certificates-and-security.html

First try on workstation to create new certificate for this server

#1 - I first prepared my wnvironement
#Doing : https://howto.biapy.com/en/debian-gnu-linux/servers/http/create-a-ssl-tls-certificate-on-debian
apt-get install openssl ssl-cert

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
chmod 440 '/etc/ssl/private/'*

SSL_KEY_NAME="$(command hostname --fqdn)"

#CONF_FILE="$(command mktemp)"
#sed \
#    -e "s/@HostName@/${SSL_KEY_NAME}/" \
#    -e "s|privkey.pem|/etc/ssl/private/${SSL_KEY_NAME}.pem|" \
#    '/usr/share/ssl-cert/ssleay.cnf' > "${CONF_FILE}"
#openssl req -config "${CONF_FILE}" -new -x509 -days 3650 \
#    -nodes -out "/etc/ssl/certificates/${SSL_KEY_NAME}.crt" -keyout "/etc/ssl/private/${SSL_KEY_NAME}.key"
#rm "${CONF_FILE}"
#
#ll /etc/ssl/private/albandri.misys.global.ad.key
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
SSL_EMAIL="FRBM@misys.com"

echo "# SSL CSR informations.
SSL_COUNTRY=\"${SSL_COUNTRY}\"
SSL_PROVINCE=\"${SSL_PROVINCE}\"
SSL_CITY=\"${SSL_CITY}\"
SSL_EMAIL=\"${SSL_EMAIL}\"" \
    > '/etc/ssl/csr-informations'

openssl genrsa -out "/etc/ssl/private/${SSL_KEY_NAME}.key" 2048
chown root:ssl-cert "/etc/ssl/private/${SSL_KEY_NAME}.key"
chmod 440 "/etc/ssl/private/${SSL_KEY_NAME}.key"

openssl rsa -in /etc/ssl/private/albandri.misys.global.ad.key -text -noout
openssl rsa -in /etc/ssl/private/albandri.misys.global.ad.key -pubout -out albandri.misys.global.ad.pem

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

cat "/etc/ssl/requests/${SSL_KEY_NAME}.csr"


#3 - Obtaining the public key from certification authority

cd /etc/ssl/requests/
certnew-der.cer
certnew-der.p7b
certnew-bin.cer
certnew-bin.p7b
#https://www.sslshopper.com/ssl-converter.html
openssl x509 -inform der -in certnew-der.cer -out albandri.pem
#for sonar

#4 - export certificat to pkcs12
openssl pkcs12 -export -in certnew-bin.cer -inkey /etc/ssl/private/albandri.misys.global.ad.key -out albandri.pkcs12 -name albandri
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

scm-git-eur.misys.global.ad.crt

wget -O cacert-root.crt "http://www.cacert.org/certs/root.crt"
wget -O cacert-class3.crt "http://www.cacert.org/certs/class3.crt"

certutil -d sql:$HOME/.pki/nssdb -A -t TC -n "CAcert.org" -i cacert-root.crt
certutil -d sql:$HOME/.pki/nssdb -A -t TC -n "CAcert.org Class 3" -i cacert-class3.crt

certutil -L -d  sql:$HOME/.pki/nssdb

sudo certutil -d sql:$HOME/.pki/nssdb -A -t P -n "Stash" -i scm-git-eur.misys.global.ad.crt
sudo certutil -d sql:$HOME/.pki/nssdb -A -t TC -n "Stash" -i scm-git-eur.misys.global.ad.crt
#http://blog.tkassembled.com/410/adding-a-certificate-authority-to-the-trusted-list-in-ubuntu/
#certutil -d sql:$HOME/.pki/nssdb -A -n "Stash" -i scm-git-eur.misys.global.ad.crt -t P,P,P
#certutil -d sql:$HOME/.pki/nssdb -A -n 'Stash' -i scm-git-eur.misys.global.ad.crt -t TCP,TCP,TCP


#https://help.ubuntu.com/community/OpenSSL#SSL%20Certificates
sudo apt-cache search libssl | grep SSL
openssl version
openssl -h enc
openssl ciphers -v
openssl speed

sudo keytool -import -alias ca -file ~/Downloads/FR1CSLALM0010.crt -keystore cacerts -storepass changeit

#https://confluence.atlassian.com/kb/unable-to-connect-to-ssl-services-due-to-pkix-path-building-failed-779355358.html
TEST :
wget https://confluence.atlassian.com/kb/files/779355358/SSLPoke.class
java -Djavax.net.ssl.trustStore=/etc/ssl/certs/java/cacerts -Djavax.net.debug=true SSLPoke fr1cslalm0010 443

openssl x509 -noout -fingerprint -in ~/Downloads/FR1CSLALM0010.crt
#as root
openssl x509 -noout -hash -in /home/albandri/Downloads/FR1CSLALM0010.crt
ln -s /home/albandri/Downloads/FR1CSLALM0010.crt `openssl x509 -hash -noout -in /home/albandri/Downloads/FR1CSLALM0010.crt`.0
#openssl verify -CApath <ssl-base-dir>certs /home/albandri/Downloads/FR1CSLALM0010.crt
openssl verify -CAfile /home/albandri/Downloads/FR1CSLALM0010.crt /home/albandri/Downloads/FR1CSLALM0010.crt
openssl verify -CApath /usr/lib/ssl/certs /home/albandri/Downloads/FR1CSLALM0010.crt
openssl verify /home/albandri/Downloads/FR1CSLALM0010.crt

openssl s_client -connect fr1cslalm0010:443 -CApath /etc/ssl/certs
openssl s_client -connect fr1cslalm0010:443 -showcerts
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

java -Djavax.net.ssl.trustStore=/etc/ssl/certs/java/cacerts -Djavax.net.debug=true SSLPoke fr1cslalm0010 443

#Add certificates
#http://kb.kerio.com/product/kerio-connect/server-configuration/ssl-certificates/adding-trusted-root-certificates-to-the-server-1605.html

#Ubuntu
#http://superuser.com/questions/437330/how-do-you-add-a-certificate-authority-ca-to-ubuntu
cd /usr/local/share/ca-certificates
sudo cp ~/Downloads/FR1CSLALM0010.crt .
sudo cp /etc/ssl/requests/certnew.cer albandri.crt
sudo cp ~/Downloads/UK1VSWCERT01-CA.cer UK1VSWCERT01-CA.crt
#~ #count the number of certificate in a file
cat ~/Downloads/FR1CSLALM0010.crt | grep 'BEGIN.* CERTIFICATE' | wc -l
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
java -Djavax.net.ssl.trustStore=/files/sonar/sonarqube-4.5.5/bin/linux-x86-64/cacerts -Djavax.net.debug=true SSLPoke fr1cslalm0010 443
java -Djavax.net.ssl.trustStore=/etc/pki/java/cacerts -Djavax.net.debug=true SSLPoke fr1cslalm0010 443

#sudo keytool -import -alias FR1CSLALM0010 -file /files/sonar/sonarqube-4.5.5/FR1CSLALM0010.crt -keystore cacerts -storepass changeit
#sudo keytool -import -alias FR1CSLALM0010 -file /files/sonar/sonarqube-4.5.5/FR1CSLALM0010.crt -keystore /files/sonar/sonarqube-4.5.5/bin/linux-x86-64/cacerts -storepass changeit
sudo keytool -import -alias FR1CSLALM0010 -file /files/sonar/sonarqube-4.5.5/FR1CSLALM0010.crt -keystore /etc/pki/java/cacerts -storepass changeit
sudo keytool -import -alias FR1CSLALM0010 -file /files/sonar/sonarqube-4.5.5/FR1CSLALM0010.crt -keystore /usr/java/jre1.8.0_77/lib/security/cacerts -storepass changeit

#!/bin/bash
set -xv

./run-freenas-letsencrypt.sh

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
/usr/local/sbin/certbot-auto certonly --renew-by-default --apache -d albandrieu.com,albandrieu.albandrieu.com
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

exit 0 

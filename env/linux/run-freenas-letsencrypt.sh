#!/bin/bash
set -xv

#On freenas apache jail

echo "" > /var/www/nabla-site-apache/.well-known/acme-challenge/.htaccess

cd /etc
ln -s /usr/local/etc/letsencrypt letsencrypt

#On freenas webmin

#[root@apache /usr/ports/security/py-certbot]# tail -f /var/log/letsencrypt/letsencrypt.log
#2020-03-29 00:56:22,086:DEBUG:certbot._internal.cli:Var manual_public_ip_logging_ok=True (set by user).
#2020-03-29 00:56:22,086:DEBUG:certbot._internal.cli:Var webroot_path=/usr/local/www/apache24/data/ (set by user).
#2020-03-29 00:56:22,086:DEBUG:certbot._internal.cli:Var webroot_path=/usr/local/www/apache24/data/ (set by user).
#2020-03-29 00:56:22,086:DEBUG:certbot._internal.cli:Var webroot_map={'webroot_path'} (set by user).
#2020-03-29 00:56:22,087:DEBUG:certbot._internal.storage:Writing new config /usr/local/etc/letsencrypt/renewal/albandrieu.com.conf.
#2020-03-29 00:56:22,090:DEBUG:certbot._internal.reporter:Reporting to user: Congratulations! Your certificate and chain have been saved at:
#/usr/local/etc/letsencrypt/live/albandrieu.com/fullchain.pem
#Your key file has been saved at:
#/usr/local/etc/letsencrypt/live/albandrieu.com/privkey.pem
#Your cert will expire on 2020-06-26. To obtain a new or tweaked version of this certificate in the future, simply run certbot again. To non-interactively renew *all* of your certificates, run "certbot renew"

less /usr/local/etc/letsencrypt/renewal/albandrieu.com.conf

cert = /usr/local/etc/letsencrypt/live/albandrieu.com/cert.pem
privkey = /usr/local/etc/letsencrypt/live/albandrieu.com/privkey.pem
chain = /usr/local/etc/letsencrypt/live/albandrieu.com/chain.pem
fullchain = /usr/local/etc/letsencrypt/live/albandrieu.com/fullchain.pem

nano /usr/local/etc/apache24/httpd.conf

SSLEngine On
SSLCertificateFile "/usr/local/etc/letsencrypt/live/albandrieu.com/cert.pem"
SSLCertificateKeyFile "/usr/local/etc/letsencrypt/live/albandrieu.com/privkey.pem"

#certbot certonly --standalone -d albandrieu.com

ServerAlias www.albandrieu.com

nano /usr/local/etc/apache24/extra/httpd-vhosts.conf
nano /usr/local/etc/apache24/extra/httpd-ssl.conf

service apache24 restart

tail -f /var/log/httpd-error.log

http://192.168.1.62/index.pl
http://192.168.1.62/index.cgi

cd /usr/local/www/apache24/data/.well-known/acme-challenge
watch -n 0.1 ls -lRa

# below is working as well

/usr/local/bin/certbot certonly --renew-by-default  -d albandrieu.com,home.albandrieu.com

service apache24 restart

#See https://albandrieu.com/nabla/index/index.html

openssl s_client -connect localhost:443
openssl s_client -connect albandrieu.com:443

exit 0

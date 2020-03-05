#!/bin/bash
set -xv

cd ~
sudo apt-get install perl libnet-ssleay-perl openssl libauthen-pam-perl libpam-runtime libio-pty-perl apt-show-versions python
#wget http://prdownloads.sourceforge.net/webadmin/webmin_1.930_all.deb
#dpkg --install webmin_1.930_all.deb
sudo apt-get install webmin

#check out git code
#see http://www.webmin.com/git.html
#git clone git://github.com/webmin/webmin.git /usr/local/webadmin
#cd /usr/local/webadmin
#sudo ln -s `which perl` /usr/local/bin/perl
#sudo ./local-setup.sh

# Open firewall
sudo ufw allow 10000

#Login name on windows : admin
#Login name on windows : microsoft

# mon
#change /var/www/cgi-bin/mon.cgi by /usr/lib/cgi-bin/mon.cgi

#Install virtualmin
#sudo apt-get remove --purge libapache2-mod-fcgid
#sudo rm -rf /var/lib/apache2/fcgid/
#sudo apt-get install libapache2-mod-fcgid
#ls -lah /var/lib/apache2/fcgid/

#See http://www.webmin.com/vinstall.html
#wget http://software.virtualmin.com/gpl/scripts/install.sh
#chmod +x install.sh
#sudo ./install.sh

#See http://www.webmin.com/cinstall-kvm.html
#wget http://cloudmin.virtualmin.com/gpl/scripts/cloudmin-kvm-debian-install.sh
#chmod +x cloudmin-kvm-debian-install.sh
#sudo ./cloudmin-kvm-debian-install.sh

cd /etc/webmin
cp miniserv.pem miniserv.pem-SAV
ls -lrta /etc/ssl/private/
cat /etc/ssl/private/nabla.freeboxos.fr.key /etc/ssl/private/nabla.freeboxos.fr.pem > new_miniserv.pem

#/usr/share/webmin/changepass.pl /etc/webmin root NEWPASSWORD

service webmin restart

cpan install DBI
cpan install DBD::mysql

#Google Authenticator
cpan install Authen::OATH
#Go into this file /etc/webmin/miniserv.conf, delete this line: twofactor_provider=totp

echo "https://albandrieu.com:10000/"

#See https://www.digitalocean.com/community/tutorials/how-to-install-webmin-on-ubuntu-16-04
#letsencrypt

#Private key /etc/webmin/miniserv.pem
ls -lrta /etc/webmin/miniserv.csr

tail -f /var/webmin/webmin.log
tail -f /var/webmin/miniserv.log
tail -f /var/webmin/miniserv.error

exit 0

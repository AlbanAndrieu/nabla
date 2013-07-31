#http://www.ubuntugeek.com/how-to-install-webmin-on-ubuntu-12-04-precise-server.html

sudo apt-get install perl libnet-ssleay-perl openssl libauthen-pam-perl libpam-runtime libio-pty-perl apt-show-versions python
wget http://prdownloads.sourceforge.net/webadmin/webmin_1.580_all.deb
sudo dpkg -i webmin_1.580_all.deb

#check out git code 
#see http://www.webmin.com/git.html
git clone git://github.com/webmin/webmin.git /usr/local/webadmin
cd /usr/local/webadmin
sudo ln -s `which perl` /usr/local/bin/perl
sudo ./local-setup.sh

#
Login name on windows : admin
Login name on windows : Ba...7
http://PTXMZ0087:10000/

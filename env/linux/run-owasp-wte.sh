#https://github.com/mtesauro/owasp-wte
sudo su - root
sudo echo "deb http://appseclive.org/apt/14.04 trusty main" > /etc/apt/sources.list.d/owasp-wte.list
wget -q -O - http://appseclive.org/apt/owasp-wte.gpg.key | apt-key add -
apt-get update && apt-get -y install owasp-wte-*

#https://www.virtualbox.org/wiki/Linux_Downloads

sudo nano /etc/apt/sources.list
deb http://download.virtualbox.org/virtualbox/debian saucy contrib

wget -q http://download.virtualbox.org/virtualbox/debian/oracle_vbox.asc -O- | sudo apt-key add -

sudo apt-get update
sudo apt-get install virtualbox-4.3
sudo apt-get install dkms

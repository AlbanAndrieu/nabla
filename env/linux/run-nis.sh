#http://doc.ubuntu-fr.org/nis
sudo apt-get install portmap 
sudo apt-get install nis

#put nis server to /etc/hosts

#nis domain nabla
sudo service ypserv start
sudo service nis start

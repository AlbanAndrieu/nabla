#http://doc.ubuntu-fr.org/mysql

#http://doc.ubuntu-fr.org/lamp
#apache on http://127.0.1.1:80
#check php http://localhost/test.php

#http://localhost/phpmyadmin/

sudo service mysql start

sudo service mysql force-reload

#default user : root/admin
#sudo mysqladmin -u root password Nouveau_mot_de_passe -p Ancien_mot_de_passe
sudo mysqladmin -u root password microsoft -p admin

#/etc/mysql/

mysql -u root -p

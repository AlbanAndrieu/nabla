#http://doc.ubuntu-fr.org/mysql

#http://doc.ubuntu-fr.org/lamp
#apache on http://127.0.1.1:80
#check php http://localhost/test.php

#https://home.nabla.mobi/phpmyadmin/

sudo service mysql start

sudo service mysql force-reload

#default user : root/admin
#sudo mysqladmin -u root password Nouveau_mot_de_passe -p Ancien_mot_de_passe
sudo mysqladmin -u user_name -h host_name password "newpwd"
sudo mysqladmin -u nabla -h localhost password "nabla"
sudo mysqladmin -u root -h localhost password "microsoft"

GRANT SUPER ON *.* TO nabla@'localhost' IDENTIFIED BY 'nabla';

#/etc/mysql/
#/var/lib/mysql/

mysql -u root -p

update mysql.user set password=PASSWORD(’jakarta’) where user=’root’;

#mysqld_safe –user=mysql &
#mysqld_safe –skip-grant-tables –user=root &

#/usr/bin/mysqladmin -u root password 'new-password'
#/usr/bin/mysqladmin -u root -h alban password 'new-password'

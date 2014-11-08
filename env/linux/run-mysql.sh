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

#change password
/etc/init.d/mysql stop
#relaunch
mysqld --skip-grant-tables --skip-networking &
#database connection
mysql mysql
UPDATE user SET password=PASSWORD('Motdepasse12') WHERE User="root" AND Host="localhost";

#test connection
mysql -u root -p

#pid bug    
cd /var/run/mysqld/
sudo chmod 664 mysqld.pid
#inside /etc/init.d/mysql
    #pidfile=`mysqld_get_param pid-file`
    pidfile="/var/run/mysqld/mysqld.pid"
    echo "pidfile = $pidfile"

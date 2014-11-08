#http://mmonit.com/monit/
#http://mmonit.com/screenshots/
#http://localhost:3737/

#more configuration at :
#https://www.digitalocean.com/community/tutorials/how-to-install-and-configure-monit

#apache
check process httpd with pidfile /var/run/httpd.pid
group apache
start program = "/etc/init.d/httpd start"
stop program = "/etc/init.d/httpd stop"
if failed host 127.0.0.1 port 80
protocol http then restart
if 5 restarts within 5 cycles then timeout

#apache2
check process apache with pidfile /run/apache2/apache2.pid
start program = "/etc/init.d/apache2 start" with timeout 60 seconds
stop program  = "/etc/init.d/apache2 stop"

#nginx
check process nginx with pidfile /var/run/nginx.pid
start program = "/etc/init.d/nginx start"
stop program = "/etc/init.d/nginx stop"

#mysqld
check process mysqld with pidfile /var/run/mysqld/mysqld.pid
group mysql
start program = "/etc/init.d/mysqld start"
stop program = "/etc/init.d/mysqld stop"
if failed host 127.0.0.1 port 3306 then restart
if 5 restarts within 5 cycles then timeout

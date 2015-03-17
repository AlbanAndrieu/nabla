#http://filsbak.free.fr/index.php?app=tutoriels&ctrl=index&act=view&id=1

sudo service elasticsearch status
sudo service logstash start
sudo service apache2 start

#apache2
sudo a2dissite 000-default
sudo a2dissite kibana3
sudo a2ensite elasticsearch
service apache2 reload

http://localhost:9200/
#and
http://localhost:7070/elasticsearch

#kibana dashboard
#apache
http://localhost:7070/kibana
#nginx
http://localhost/

#logstash
http://localhost:9292/

#TODO log4j
#http://blog.yeradis.com/2013/10/logstash-and-apache-log4j-or-how-to.html

usermod -a -G adm logstash
groups logstash
id logstash
find /var/log -user root -perm 0600

#add --groups adm
#in sudo nano logstash
#nice -n ${LS_NICE} chroot --userspec $LS_USER:$LS_GROUP --groups adm / sh -c "

#dpkg -s logstash
less /etc/init/logstash.conf

sudo -u logstash /opt/logstash/bin/logstash agent -f /etc/logstash/conf.d -l /var/log/logstash/logstash.log

sudo service logstash-web stop

#log
tail -f /var/log/upstart/logstash.log
tail -f /var/log/logstash/logstash.log

#user pass settings
Instaling apache2-utils because htpasswd is so easy to use. This section creates kibana.htpassword for access to Kibana / Elasticsearch

sudo apt-get install apache2-utils
sudo htpasswd -c /etc/nginx/conf.d/kibana.htpasswd albandri
sudo htpasswd /etc/nginx/conf.d/kibana.htpasswd user
This section creates kibana-write.htpassword for the ability to save dashboards

sudo htpasswd -c /etc/nginx/conf.d/kibana-write.htpasswd albandri

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
sudo tail -f /var/log/upstart/logstash.log
sudo tail -f /var/log/logstash/logstash.log
#log file is geting huge
#gksudo geany /etc/init/logstash.conf
#comment LS_OPTS="-vv"
#gksudo geany /opt/logstash/lib/logstash/agent.rb

#user pass settings
Instaling apache2-utils because htpasswd is so easy to use. This section creates kibana.htpassword for access to Kibana / Elasticsearch

sudo apt-get install apache2-utils
sudo htpasswd -c /etc/nginx/conf.d/kibana.htpasswd albandri
sudo htpasswd /etc/nginx/conf.d/kibana.htpasswd user
#This section creates kibana-write.htpassword for the ability to save dashboards

sudo htpasswd -c /etc/nginx/conf.d/kibana-write.htpasswd albandri

#clean up elasticsearch
#install elasticsearch-curator
#sudo apt-get install python-pip
#sudo pip install elasticsearch-curator
#curator --help
#http://www.elastic.co/guide/en/elasticsearch/client/curator/current/examples.html
#curator --host 127.0.0.1 show indices --timestring '%Y.%m.%d'
#curator --host 127.0.0.1 delete indices --older-than 30 --time-unit days --timestring '%Y.%m.%d'
##curator --host 127.0.0.1 close indices --exclude do-not-touch --exclude logstash-2015
#curator --host 127.0.0.1 close indices --exclude do-not-touch --exclude kibana-int
#curator --host 127.0.0.1 delete indices --index logstash-2015.04.29
ll /var/lib/elasticsearch/elasticsearch/nodes/

#test
curl -XGET 'http://localhost:9200/_cluster/health?pretty=true'

The following command remove's ES' built-in replication:

#remove replicatio
curl -XPUT 'localhost:9200/_settings' -d '
{
    "index" : {
        "number_of_replicas" : 0
      }
}
'

#curl -XPOST 'http://localhost:9200/kibana-int/_open'

#install monitoring plugins
#http://www.elastichq.org/support_plugin.html
cd /usr/share/elasticsearch/bin
sudo ./plugin -install royrusso/elasticsearch-HQ
echo http://localhost:9200/_plugin/HQ/

#redis
sudo service redis-server start
tail -f /var/log/redis/redis-server.log

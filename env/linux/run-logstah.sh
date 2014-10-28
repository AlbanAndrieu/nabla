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

#TODO log4j
#http://blog.yeradis.com/2013/10/logstash-and-apache-log4j-or-how-to.html

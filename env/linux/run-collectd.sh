#https://www.elastic.co/blog/logstash-collectd-input-plugin/

#ansible
/opt/collectd/etc/collectd.conf
cd /opt/collectd/var/log

#default
#below is wrong
#gksudo geany /opt/collectd/etc/collectd.conf
gksudo geany /etc/collectd/collectd.conf

#start collectd
sudo /usr/sbin/collectdmon -P /var/run/collectd.pid -- -C /etc/collectd/collectd.conf

#default port is 25826
#http://logstash.net/docs/1.4.2/inputs/collectd

#log
sudo tail -f /var/log/upstart/collectd.log


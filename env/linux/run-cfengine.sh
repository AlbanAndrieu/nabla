#https://cfengine.com/inside/myspace

#http://cfengine.com/cfengine-linux-distros

sudo su - root
wget -qO- http://cfengine.com/pub/gpg.key | apt-key add -
echo "deb http://cfengine.com/pub/apt/packages stable main" >  /etc/apt/sources.list.d/cfengine-community.list
apt-get update
#apt-get install cfengine-community
#apt-get install cfengine3
apt-get install cfengine2

ls /var/lib/cfengine3
ll /usr/share/doc/cfengine3
#inside webmin
#change /usr/bin/cfengine by
/usr/sbin/cfexecd

#webmin does not support cfengine2
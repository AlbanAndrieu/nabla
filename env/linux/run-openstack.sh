#http://doc.ubuntu-fr.org/openstack

sudo apt-get install kvm libvirt-bin virtinst mysql-server python-mysqldb bridge-utils

sudo apt-get install ntp
sudo apt-get install tgt open-iscsi open-iscsi-utils lvm2 
sudo apt-get install rabbitmq-server memcached python-memcache

#TODO
sudo apt-get install keystone python-keystone python-keystoneclient
sudo apt-get install glance glance-api python-glanceclient glance-common glance-registry python-glance
sudo apt-get install nova-api nova-cert nova-common nova-compute nova-compute-kvm nova-doc nova-network nova-objectstore nova-scheduler novnc nova-consoleauth nova-volume python-nova python-novaclient
sudo apt-get install apache2 libapache2-mod-wsgi openstack-dashboard

#look at http://albandri/horizon
#http://doc.ubuntu-fr.org/openstack

sudo apt-get install kvm libvirt-bin virtinst mysql-server python-mysqldb bridge-utils

sudo apt-get install ntp
sudo apt-get install tgt open-iscsi open-iscsi-utils lvm2 
sudo apt-get install rabbitmq-server memcached python-memcache

#TODO
sudo apt-get install keystone python-keystone python-keystoneclient
sudo apt-get install glance glance-api python-glanceclient glance-common glance-registry python-glance
sudo apt-get install nova-conductor
sudo apt-get install nova-api nova-cert nova-common nova-compute nova-compute-kvm nova-doc nova-network nova-objectstore nova-scheduler novnc nova-consoleauth nova-volume python-nova python-novaclient
#sudo apt-get install nova-novncproxy
sudo apt-get install apache2 libapache2-mod-wsgi openstack-dashboard

sudo apt-get install libnss-myhostname

#look at http://albandri/horizon

sudo rm /var/lib/keystone/keystone.db
sudo chown -R keystone:keystone /etc/keystone/

mysql -u root -p <<EOF
CREATE DATABASE keystone;
GRANT ALL ON keystone.* TO 'keystone'@'%' IDENTIFIED BY 'Motdepasse12';
GRANT ALL ON keystone.* TO 'keystone'@'localhost' IDENTIFIED BY 'Motdepasse12';
GRANT ALL ON keystone.* TO 'keystone'@'albandri' IDENTIFIED BY 'Motdepasse12';
FLUSH PRIVILEGES;
EOF


sudo nano  /etc/keystone/keystone.conf
[DEFAULT]
bind_host = 0.0.0.0
public_port = 5000
admin_port = 35357
# Mot de passe d'administration
admin_token = Motdepasse12
compute_port = 8774
verbose = True
debug = True
log_config = /etc/keystone/logging.conf
   
[sql]
connection = mysql://keystone:Motdepasse12@10.25.40.161:3306/keystone
idle_timeout = 200
      
#Création du compte administrateur      
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ user-create --name=admin --pass=Motdepasse12 --email=alban.andrieu@misys.com
+----------+----------------------------------+
| Property |              Value               |
+----------+----------------------------------+
|  email   |     alban.andrieu@misys.com      |
| enabled  |               True               |
|    id    | 68527a3fb83446d3bab47ce30d500dbc |
|   name   |              admin               |
+----------+----------------------------------+
#Création du compte interne du service Glance
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ user-create --name=glance --pass=Motdepasse12 --email=galban.andrieu@misys.com
+----------+----------------------------------+
| Property |              Value               |
+----------+----------------------------------+
|  email   |     galban.andrieu@misys.com     |
| enabled  |               True               |
|    id    | cd93bd532f53495eba123793a0928a00 |
|   name   |              glance              |
+----------+----------------------------------+
#Création du compte interne du service Nova
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ user-create --name=nova --pass=Motdepasse12 --email=nova@example.com   
+----------+----------------------------------+
| Property |              Value               |
+----------+----------------------------------+
|  email   |         nova@example.com         |
| enabled  |               True               |
|    id    | 534c3d8fe3144409bb44b02486a066ee |
|   name   |               nova               |
+----------+----------------------------------+
#Rôle admin   
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ role-create --name=admin
+----------+----------------------------------+
| Property |              Value               |
+----------+----------------------------------+
|    id    | 08c2bc49148747f6bcdc3e23144213cc |
|   name   |              admin               |
+----------+----------------------------------+
#Rôle Membre
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ role-create --name=Member
+----------+----------------------------------+
| Property |              Value               |
+----------+----------------------------------+
|    id    | 5a0c7bfb24414336a041c9f61d12b600 |
|   name   |              Member              |
+----------+----------------------------------+
#Rôle KeystoneAdmin
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ role-create --name=KeystoneAdmin
+----------+----------------------------------+
| Property |              Value               |
+----------+----------------------------------+
|    id    | 87c98eb3b26641a3905ebbdc41dbf745 |
|   name   |          KeystoneAdmin           |
+----------+----------------------------------+
#Rôle KeystoneServiceAdmin
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ role-create --name=KeystoneServiceAdmin
+----------+----------------------------------+
| Property |              Value               |
+----------+----------------------------------+
|    id    | 7755da728fe84ca698007935de38a948 |
|   name   |       KeystoneServiceAdmin       |
+----------+----------------------------------+
#Tenant admin
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ tenant-create --name=admin
+-------------+----------------------------------+
|   Property  |              Value               |
+-------------+----------------------------------+
| description |                                  |
|   enabled   |               True               |
|      id     | 9f9f573069df4318a54d8b406e2611c9 |
|     name    |              admin               |
+-------------+----------------------------------+
#Tenant service
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ tenant-create --name=service
+-------------+----------------------------------+
|   Property  |              Value               |
+-------------+----------------------------------+
| description |                                  |
|   enabled   |               True               |
|      id     | 14fcf7cdf64a4b19bdd46aa98cd1bfc1 |
|     name    |             service              |
+-------------+----------------------------------+
#Définition des rôles
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ user-role-add --user-id 68527a3fb83446d3bab47ce30d500dbc --role-id 08c2bc49148747f6bcdc3e23144213cc --tenant_id 9f9f573069df4318a54d8b406e2611c9   

#TODO
keystone user-role-add --user `keystone user-list | awk '/ admin / { print $2 }'` --role `keystone role-list | awk '/ KeystoneAdmin / { print $2 }'` --tenant_id `keystone tenant-list | awk '/ admin / { print $2 }'`
keystone user-role-add --user `keystone user-list | awk '/ admin / { print $2 }'` --role `keystone role-list | awk '/ KeystoneServiceAdmin / { print $2 }'` --tenant_id `keystone tenant-list | awk '/ admin / { print $2 }'`
keystone user-role-add --user `keystone user-list | awk '/ glance / { print $2 }'` --role `keystone role-list | awk '/ admin / { print $2 }'` --tenant_id `keystone tenant-list | awk '/ service / { print $2 }'`
keystone user-role-add --user `keystone user-list | awk '/ nova / { print $2 }'` --role `keystone role-list | awk '/ admin / { print $2 }'` --tenant_id `keystone tenant-list | awk '/ service / { print $2 }'`

#User
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ user-create --name=$USER --pass=USRPASSWD --email=$USER@misys.com
+----------+----------------------------------+
| Property |              Value               |
+----------+----------------------------------+
|  email   |        albandri@misys.com        |
| enabled  |               True               |
|    id    | f558122ed2ee484e9bab232b1aaa2fca |
|   name   |             albandri             |
+----------+----------------------------------+
#Tenant
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ tenant-create --name=$USER
+-------------+----------------------------------+
|   Property  |              Value               |
+-------------+----------------------------------+
| description |                                  |
|   enabled   |               True               |
|      id     | f9599900c35e4c1d961116576cac72d2 |
|     name    |             albandri             |
+-------------+----------------------------------+
#Rôle
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ user-role-add --user-id f558122ed2ee484e9bab232b1aaa2fca --role-id 5a0c7bfb24414336a041c9f61d12b600 --tenant_id f9599900c35e4c1d961116576cac72d2

#Le service Keystone
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ service-create --name=keystone --type=identity --description='Keystone Identity Service'
+-------------+----------------------------------+
|   Property  |              Value               |
+-------------+----------------------------------+
| description |    Keystone Identity Service     |
|      id     | f5756ddfef0a4e48b58ae23c3da5b4d3 |
|     name    |             keystone             |
|     type    |             identity             |
+-------------+----------------------------------+
keystone --token Motdepasse12 --endpoint http://10.25.40.161:35357/v2.0/ endpoint-create --region RegionOne --service_id=f5756ddfef0a4e48b58ae23c3da5b4d3 --publicurl=http://10.25.40.161:5000/v2.0 --internalurl=http://10.25.40.161:5000/v2.0 --adminurl=http://10.25.40.161:35357/v2.0
+-------------+----------------------------------+
|   Property  |              Value               |
+-------------+----------------------------------+
|   adminurl  |  http://10.25.40.161:35357/v2.0  |
|      id     | dfcac06dfaa645d881482b01b9262cef |
| internalurl |  http://10.25.40.161:5000/v2.0   |
|  publicurl  |  http://10.25.40.161:5000/v2.0   |
|    region   |            RegionOne             |
|  service_id | f5756ddfef0a4e48b58ae23c3da5b4d3 |
+-------------+----------------------------------+

keystone --endpoint http://localhost:35357/v2.0 --token  Motdepasse12 user-list
+----------------------------------+----------+---------+--------------------------+
|                id                |   name   | enabled |          email           |
+----------------------------------+----------+---------+--------------------------+
| 68527a3fb83446d3bab47ce30d500dbc |  admin   |   True  | alban.andrieu@misys.com  |
| f558122ed2ee484e9bab232b1aaa2fca | albandri |   True  |    albandri@misys.com    |
| cd93bd532f53495eba123793a0928a00 |  glance  |   True  | galban.andrieu@misys.com |
| 534c3d8fe3144409bb44b02486a066ee |   nova   |   True  |     nova@example.com     |
+----------------------------------+----------+---------+--------------------------+

#NOK keystone --username admin --password Motdepasse12 --tenant_name admin --auth_url http://localhost:5000/v2.0 user-list

export SERVICE_ENDPOINT=http://localhost:5000/v2.0/
export SERVICE_TOKEN=Motdepasse12
nano .novarc
export OS_TENANT_NAME=admin 
export OS_USERNAME=admin 
export OS_PASSWORD=Motdepasse12 
export OS_AUTH_URL="http://localhost:5000/v2.0/"
keystone user-list

#La prochaine étape est l'installation du service d'images Glance.

mysql -u root -p <<EOF
CREATE DATABASE glance;
GRANT ALL PRIVILEGES ON glance.* TO 'glance'@'%' IDENTIFIED BY 'Motdepasse12';
GRANT ALL ON glance.* TO 'glance'@'localhost' IDENTIFIED BY 'Motdepasse12';
GRANT ALL ON glance.* TO 'glance'@'albandri' IDENTIFIED BY 'Motdepasse12';
FLUSH PRIVILEGES;
EOF


keystone service-create  --name=glance --type=image --description='Glance Image Service'
+-------------+----------------------------------+
|   Property  |              Value               |
+-------------+----------------------------------+
| description |       Glance Image Service       |
|      id     | 843577a0081a4671a6670df6c1d1fa76 |
|     name    |              glance              |
|     type    |              image               |
+-------------+----------------------------------+
keystone endpoint-create --region RegionOne --service_id=843577a0081a4671a6670df6c1d1fa76 --publicurl=http://10.25.40.161:9292/v1 --internalurl=http://10.25.40.161:9292/v1 --adminurl=http://10.25.40.161:9292/v1
+-------------+----------------------------------+
|   Property  |              Value               |
+-------------+----------------------------------+
|   adminurl  |   http://10.25.40.161:9292/v1    |
|      id     | 618d42d69a204b8eb78073c8bb2ca22a |
| internalurl |   http://10.25.40.161:9292/v1    |
|  publicurl  |   http://10.25.40.161:9292/v1    |
|    region   |            RegionOne             |
|  service_id | 843577a0081a4671a6670df6c1d1fa76 |
+-------------+----------------------------------+

sudo nano /etc/glance/glance-api-paste.ini
admin_tenant_name = service
admin_user = glance
admin_password = Motdepasse12
admin_token = Motdepasse12

#change
[pipeline:glance-api]
pipeline = versionnegotiation authtoken auth-context apiv1app

sudo nano /etc/glance/glance-api.conf
admin_tenant_name = service
admin_user = glance
admin_password = Motdepasse12
admin_token = Motdepasse12

[paste_deploy]
flavor = keystone

sudo nano /etc/glance/glance-registry.conf
sql_connection = mysql://glance:Motdepasse12@10.25.40.161:3306/glance

auth_protocol = http
admin_token = Motdepasse12

[paste_deploy]
flavor = keystone

sudo nano /etc/glance/glance-scrubber.conf
sql_connection = mysql://glance:Motdepasse12@10.25.40.161:3306/glance
sql_idle_timeout = 3600

sudo nano /etc/glance/glance-registry-paste.ini 
admin_tenant_name = service
admin_user = glance
admin_password = Motdepasse12
[pipeline:glance-registry]
pipeline = authtoken auth-context context registryapp

#check #admin_user = %SERVICE_USER% is commented
grep SERVICE_USER /etc/glance/*
grep auth_protocol = http /etc/glance/*

sudo glance-manage version_control 0
sudo glance-manage db_sync

sudo service glance-api restart && sudo service glance-registry restart

#Utilisation

wget http://uec-images.ubuntu.com/releases/precise/release/ubuntu-12.04-server-cloudimg-amd64-disk1.img
#glance add name="<Image name>" is_public=true container_format=<container_format> disk_format=<disk_format> < <filename>
glance --debug --os-username admin --os-password Motdepasse12 add name="Ubuntu 12.04 cloudimg amd64" is_public=true container_format=ovf disk_format=qcow2 < /devel/albandri/tmp/ubuntu-12.04-server-cloudimg-amd64-disk1.img
HTTP/1.1 201 Created
content-length: 477
etag: 8eb1e06aca4d7dcd3b945f9f818b2545
location: http://10.25.40.161:9292/v1/images/73be1172-63ea-40a2-abef-59b937fe3d50
date: Thu, 06 Mar 2014 16:37:50 GMT
content-type: application/json
x-openstack-request-id: req-d11c95c3-1e16-4365-9cef-3a05574730d7

{"image": {"status": "active", "deleted": false, "container_format": "ovf", "min_ram": 0, "updated_at": "2014-03-06T16:37:50", "owner": "9f9f573069df4318a54d8b406e2611c9", "min_disk": 0, "is_public": true, "deleted_at": null, "id": "73be1172-63ea-40a2-abef-59b937fe3d50", "size": 255328768, "name": "Ubuntu 12.04 cloudimg amd64", "checksum": "8eb1e06aca4d7dcd3b945f9f818b2545", "created_at": "2014-03-06T16:37:49", "disk_format": "qcow2", "properties": {}, "protected": false}}

Added new image with ID: 73be1172-63ea-40a2-abef-59b937fe3d50

glance index
ID                                   Name                           Disk Format          Container Format     Size          
------------------------------------ ------------------------------ -------------------- -------------------- --------------
73be1172-63ea-40a2-abef-59b937fe3d50 Ubuntu 12.04 cloudimg amd64    qcow2                ovf                       255328768

----------------------------------------------------

glance details
================================================================================
URI: http://10.25.40.161:9292/v1/images/73be1172-63ea-40a2-abef-59b937fe3d50
Id: 73be1172-63ea-40a2-abef-59b937fe3d50
Public: Yes
Protected: No
Name: Ubuntu 12.04 cloudimg amd64
Status: active
Size: 255328768
Disk format: qcow2
Container format: ovf
Minimum Ram Required (MB): 0
Minimum Disk Required (GB): 0
Owner: 9f9f573069df4318a54d8b406e2611c9
Created at: 2014-03-06T16:37:49
Deleted at: None
Updated at: 2014-03-06T16:37:50
================================================================================

#Nova

mysql -u root -p <<EOF
CREATE DATABASE nova;
GRANT ALL PRIVILEGES ON nova.* TO 'nova'@'%' IDENTIFIED BY 'Motdepasse12';
GRANT ALL ON nova.* TO 'nova'@'localhost' IDENTIFIED BY 'Motdepasse12';
GRANT ALL ON nova.* TO 'nova'@'albandri' IDENTIFIED BY 'Motdepasse12';
EOF

#Service compute
keystone service-create --name=nova --type=compute --description='OpenStack Compute Service'
+-------------+----------------------------------+
|   Property  |              Value               |
+-------------+----------------------------------+
| description |    OpenStack Compute Service     |
|      id     | 87c84148575842189ce9ed884aeb5ecd |
|     name    |               nova               |
|     type    |             compute              |
+-------------+----------------------------------+
keystone endpoint-create --region RegionOne --service_id=87c84148575842189ce9ed884aeb5ecd --publicurl='http://10.25.40.161:8774/v2/%(tenant_id)s' --internalurl='http://10.25.40.161:8774/v2/%(tenant_id)s' --adminurl='http://10.25.40.161:8774/v2/%(tenant_id)s'
+-------------+-------------------------------------------+
|   Property  |                   Value                   |
+-------------+-------------------------------------------+
|   adminurl  | http://10.25.40.161:8774/v2/%(tenant_id)s |
|      id     |      991a48ee36fb4eff95204ce435c81c4a     |
| internalurl | http://10.25.40.161:8774/v2/%(tenant_id)s |
|  publicurl  | http://10.25.40.161:8774/v2/%(tenant_id)s |
|    region   |                 RegionOne                 |
|  service_id |      87c84148575842189ce9ed884aeb5ecd     |
+-------------+-------------------------------------------+
keystone service-create --name=volume --type=volume --description='OpenStack Volume Service'
+-------------+----------------------------------+
|   Property  |              Value               |
+-------------+----------------------------------+
| description |     OpenStack Volume Service     |
|      id     | 87f8c368a58544128df648f50592f656 |
|     name    |              volume              |
|     type    |              volume              |
+-------------+----------------------------------+
keystone endpoint-create --region RegionOne --service_id=87f8c368a58544128df648f50592f656 --publicurl='http://10.25.40.161:8776/v1/%(tenant_id)s' --internalurl='http://10.25.40.161:8776/v1/%(tenant_id)s' --adminurl='http://10.25.40.161:8776/v1/%(tenant_id)s'
+-------------+-------------------------------------------+
|   Property  |                   Value                   |
+-------------+-------------------------------------------+
|   adminurl  | http://10.25.40.161:8776/v1/%(tenant_id)s |
|      id     |      f0a65960e77a4fffb1ab1ca6e4d61c6a     |
| internalurl | http://10.25.40.161:8776/v1/%(tenant_id)s |
|  publicurl  | http://10.25.40.161:8776/v1/%(tenant_id)s |
|    region   |                 RegionOne                 |
|  service_id |      87f8c368a58544128df648f50592f656     |
+-------------+-------------------------------------------+

sudo nano /etc/nova/api-paste.ini
admin_tenant_name = service
admin_user = nova
admin_password = Motdepasse12

#cf http://docs.openstack.org/grizzly/openstack-compute/install/apt/content/nova-conf-file.html
sudo nano /etc/nova/nova.conf

[DEFAULT]

# LOGS/STATE
verbose=True
logdir=/var/log/nova
state_path=/var/lib/nova
lock_path=/var/lock/nova
rootwrap_config=/etc/nova/rootwrap.conf

# SCHEDULER
compute_scheduler_driver=nova.scheduler.filter_scheduler.FilterScheduler

# VOLUMES
volume_api_class=nova.volume.cinder.API
volume_driver=nova.volume.driver.ISCSIDriver
volume_group=cinder-volumes
volume_name_template=volume-%s
iscsi_helper=tgtadm

# DATABASE
sql_connection=mysql://nova:Motdepasse12@10.25.40.161/nova

# COMPUTE
libvirt_type=qemu
compute_driver=libvirt.LibvirtDriver
instance_name_template=instance-%08x
api_paste_config=/etc/nova/api-paste.ini

# COMPUTE/APIS: if you have separate configs for separate services
# this flag is required for both nova-api and nova-compute
allow_resize_to_same_host=True

# APIS
osapi_compute_extension=nova.api.openstack.compute.contrib.standard_extensions
ec2_dmz_host=10.25.40.161
s3_host=10.25.40.161
enabled_apis=ec2,osapi_compute,metadata

# RABBITMQ
rabbit_host=10.25.40.161

# GLANCE
image_service=nova.image.glance.GlanceImageService
glance_api_servers=10.25.40.161:9292

# NETWORK
network_manager=nova.network.manager.FlatDHCPManager
force_dhcp_release=True
dhcpbridge_flagfile=/etc/nova/nova.conf
firewall_driver=nova.virt.libvirt.firewall.IptablesFirewallDriver
# Change my_ip to match each host
my_ip=10.25.40.161
public_interface=eth0
vlan_interface=eth0
flat_network_bridge=br100
flat_interface=eth0
fixed_range=''

# NOVNC CONSOLE
novncproxy_base_url=http://10.25.40.161:6080/vnc_auto.html
# Change vncserver_proxyclient_address and vncserver_listen to match each compute host
vncserver_proxyclient_address=10.25.40.161
vncserver_listen=10.25.40.161

# AUTHENTICATION
auth_strategy=keystone
[keystone_authtoken]
#auth_host = 127.0.0.1
auth_host = 10.25.40.161
auth_port = 35357
auth_protocol = http
admin_tenant_name = service
admin_user = nova
admin_password = Motdepasse12
signing_dirname = /tmp/keystone-signing-nova

sudo chown -R nova:nova /etc/nova/

sudo apt-get install nova-novncproxy

for a in libvirt-bin nova-network nova-compute nova-api nova-objectstore nova-scheduler nova-volume nova-cert nova-consoleauth novnc; do sudo service "$a" stop; done
for a in libvirt-bin nova-network nova-compute nova-api nova-objectstore nova-scheduler nova-volume nova-cert nova-consoleauth novnc; do sudo service "$a" start; done
#TODO
nova-volume: unrecognized service
novnc: unrecognized service

#TODO
sudo service novnc status
novnc: unrecognized service

sudo nova-manage db sync

for a in libvirt-bin nova-network nova-compute nova-api nova-objectstore nova-scheduler nova-volume nova-cert nova-consoleauth novnc; do sudo service "$a" stop; done
for a in libvirt-bin nova-network nova-compute nova-api nova-objectstore nova-scheduler nova-volume nova-cert nova-consoleauth novnc; do sudo service "$a" start; done

sudo nova-manage service list

#TODO missing 
nova-volume 

#TODO
#Images disques

nova --os-username admin --os-password Motdepasse12 image-list
less /var/log/nova/nova-api.log

----------------------------------------------------------------------

ls -lrta /var/log/keystone.log
ls -lrta /var/log/keystone/keystone.log

#mkdir -p /var/cache/glance/ap
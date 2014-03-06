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

#TODO
#La prochaine étape est l'installation du service d'images Glance.

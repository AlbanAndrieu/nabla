#http://doc.ubuntu-fr.org/owncloud
#install owncloud inside ubuntu
dans env/script/mountall.sh
sudo mount -t nfs 192.168.0.46:/mnt/dpool/owncloud /owncloud

/usr/share/owncloud/
/etc/owncloud

sudo mv /workspace-tmp/os/freenas/app/* /usr/share/owncloud/apps
https://albandri.local:8280/owncloud

sudo mkdir -p /owncloud/data
#chown -R www-data:www-data data

sudo su - www-data

cd /usr/share/owncloud/
sudo chown -R www-data:www-data /usr/share/owncloud/config
sudo chown -R www-data:www-data /etc/owncloud

sudo chown -R www-data:www-data /var/lib/owncloud/themes
sudo chown -R www-data:www-data /var/lib/owncloud/backup/
sudo chown -R www-data:www-data /var/lib/owncloud/data/

sudo /etc/init.d/apache2 restart

tail -f /var/lib/owncloud/data/owncloud.log

$CONFIG = array (
  'instanceid' => '526bce6aadfee',
  'passwordsalt' => '35ad49800d1b3af7b4bd3e15602a60',
  'datadirectory' => '/owncloud/data',
  'dbtype' => 'mysql',
  'version' => '5.0.12',
  'appstoreenabled' => false,
  'apps_paths' =>
  array (
    0 =>
    array (
      'path' => '/usr/share/owncloud/apps',
      'url' => '/apps',
      'writable' => false,
    ),
  ),
  'dbname' => 'owncloud',
  'dbhost' => 'localhost',
  'dbtableprefix' => 'oc_',
  'dbuser' => 'oc_albandri',
  'dbpassword' => '7ef894a567e41d6478d608f0982b242b',
  'installed' => true,
);


#for google drive 
https://cloud.google.com/console#/project

less /owncloud/data/albandri/mount.json
{"user":{"albandri":{"\/albandri\/files\/FTP":{"class":"\\OC\\Files\\Storage\\FTP","options":{"host":"mafreebox.freebox.fr","user":"freebox","password":"microsoft","root":"","secure":"false"}},"\/albandri\/files\/Dropbox":{"class":"\\OC\\Files\\Storage\\Dropbox","options":{"configured":"true","app_key":"w2cmydmksjbwmzp","app_secret":"76e2eoo2sfc63ez","token":"zwqlybkwxg3abdw7","token_secret":"uayjqdh652rhpyd"}},"\/albandri\/files\/GoogleDrive":{"class":"\\OC\\Files\\Storage\\Google","options":{"configured":"true","client_id":"762972018205.apps.googleusercontent.com","client_secret":"pbOcqdG7LIVVvnClt5R1XWWB","token":"{\"access_token\":\"ya29.1.AADtN_VhCAxDMEhqlwBKji3OOtt2AMLnUO2Sd5a1rjoPMBLCReEzHpVjJtcT4N5rHz4nsw\",\"token_type\":\"Bearer\",\"expires_in\":3600,\"refresh_token\":\"1\\\/iqtNu9Wsdrpo9xLmhw7LeoVDoWNDnIlmEfqw4hBtyBI\",\"created\":1384385302}"}}}}}

/etc/apache2/sites-available/default-ssl

-------------------------------------------------------------------------------------
#on freenas
#TODO Media bug fix
https://github.com/owncloud/apps/commit/64ce426e073fff7118a5b0f5490f6887ef08ef2f
#or install it by hand
#http://imgur.com/a/FgFlc

#echo 'jenkins_enable="YES"' >> /etc/rc.conf
service sshd start
adduser
pw usermod owncloud -G wheel
id owncloud

ssh owncloud@192.168.0.13
#become root
su -

#owncloud change default port
edit /usr/pbi/owncloud-amd64/etc/apache22/httpd.conf 
service apache22 restart

cd /usr/pbi/owncloud-amd64/www/owncloud
edit post-install.sh
------------------------------------
#!/bin/sh
#########################################

owncloud_pbi_path=/usr/pbi/owncloud-$(uname -m)

/bin/cp ${owncloud_pbi_path}/etc/rc.d/apache22 /usr/local/etc/rc.d/

${owncloud_pbi_path}/bin/python2.7 ${owncloud_pbi_path}/owncloudUI/manage.py syncdb --migrate --noinput

if [ ! -f "${owncloud_pbi_path}/www/owncloud/config/config.php" ]; then
	cat << __EOF__ > ${owncloud_pbi_path}/www/owncloud/config/config.php
	<?php
	\$CONFIG = array (
	  'datadirectory' => '/media',
	);
	?>
__EOF__
fi

cat << __EOF__ > ${owncloud_pbi_path}/etc/apache22/Includes/owncloud.conf
AddType application/x-httpd-php .php

Alias / ${owncloud_pbi_path}/www/owncloud/
AcceptPathInfo On
<Directory ${owncloud_pbi_path}/www/owncloud>
    AllowOverride All
    Order Allow,Deny
    Allow from all
</Directory>
__EOF__

chown www:www ${owncloud_pbi_path}/www/owncloud \
	${owncloud_pbi_path}/www/owncloud/apps \
	${owncloud_pbi_path}/www/owncloud/config \
	${owncloud_pbi_path}/www/owncloud/config/config.php \
	/media


# Generate SSL certificate
if [ ! -f "${owncloud_pbi_path}/etc/apache22/server.crt" ]; then

	if ! fgrep "commonName_default" /etc/ssl/openssl.cnf; then
		/usr/bin/sed -i '' -E 's/(^commonName_max.*)/\1\
commonName_default = ownCloud/' /etc/ssl/openssl.cnf
	fi
	tmp=$(mktemp /tmp/tmp.XXXXXX)
	dd if=/dev/urandom count=16 bs=1 2> /dev/null | uuencode -|head -2 |tail -1 > "${tmp}"
	/usr/bin/openssl req -batch -passout file:"${tmp}" -new -x509 -keyout ${owncloud_pbi_path}/etc/apache22/server.key.out -out ${owncloud_pbi_path}/etc/apache22/server.crt
	/usr/bin/openssl rsa -passin file:"${tmp}" -in ${owncloud_pbi_path}/etc/apache22/server.key.out -out ${owncloud_pbi_path}/etc/apache22/server.key

fi

#Enable SSL
/usr/bin/sed -i '' -E -e 's/^#(.*httpd-ssl.conf)/\1/' ${owncloud_pbi_path}/etc/apache22/httpd.conf
---------------------------------

cd /usr/pbi/owncloud-amd64/www/apache22/data

less /usr/pbi/owncloud-amd64/www/apache22/data
less etc/apache22/extra/httpd-ssl.conf  
tail -f /var/log/httpd-error.log 

#fix permisssion bug
cd /usr/pbi/owncloud-amd64/www/owncloud
#chmod -R 755 *
#chown -R wwww:wwww *

#install app
cd /usr/pbi/owncloud-amd64/www/owncloud/apps
wget --no-check-certificate https://freans.de/owncloud/images/ocDashboard/ocDashboard_1.1.zip
chown www:www ocDashboard_1.1.zip
chmod 777 ocDashboard_1.1.zip
#or
#scp ocDashboard owncloud@192.168.0.13:/usr/pbi/owncloud-amd64/www/owncloud/apps
wget --no-check-certificate https://github.com/owncloud/music/releases/download/v0.1.9.1-rc/music.tar.gz
chown www:www
chmod 777
tar -xvf music.tar.gz

scp 157091-fluxx_compensator.zip albandri@home.nabla.mobi:~/Downloads
scp 162915-files_embeddedvideo-0.0.4.tar.gz owncloud@192.168.0.13:/tmp

#in the jail
#install port
portsnap fetch && portsnap extract
cd /usr/ports/net/samba36
make install clean
#Edit /etc/rc.conf
#add this line to the file and save
echo 'samba_enable="YES"' >> /etc/rc.conf

cd /usr/pbi/owncloud-amd64/www/owncloud
#edit /usr/pbi/owncloud-amd64/www/owncloudapps/files_external/lib/config.php
cd /usr/ports/ftp/php55-ftp/
make clean install

#accessing your file via webdav
#http://doc.owncloud.org/server/6.0/user_manual/files/files.html
davs://home.nabla.mobi/owncloud/remote.php/webdav

#ubuntu client
#http://software.opensuse.org/download/package?project=isv:ownCloud:desktop&package=owncloud-client
sudo sh -c "echo 'deb http://download.opensuse.org/repositories/isv:/ownCloud:/desktop/xUbuntu_12.10/ /' >> /etc/apt/sources.list.d/owncloud-client.list"
wget http://download.opensuse.org/repositories/isv:ownCloud:desktop/xUbuntu_13.10/Release.key
sudo apt-key add - < Release.key  
sudo apt-get update
sudo apt-get install owncloud-client


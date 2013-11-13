#http://doc.ubuntu-fr.org/owncloud
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
{"user":{"albandri":{"\/albandri\/files\/FTP":{"class":"\\OC\\Files\\Storage\\FTP","options":{"host":"mafreebox.freebox.fr",
"user":"freebox","password":"microsoft","root":"","secure":"false"}},"\/albandri\/files\/Dropbox":{"class":"\\OC\\Files\\Sto
rage\\Dropbox","options":{"configured":"true","app_key":"w2cmydmksjbwmzp","app_secret":"76e2eoo2sfc63ez","token":"zwqlybkwxg
3abdw7","token_secret":"uayjqdh652rhpyd"}}}}}

{   "class":"\\OC\\Files\\Storage\\Google",
    "options":{
        "configured":"true",
        "client_id":"837653203266-nfdak9kv9j2uvfaoo43cekp8otbok7eu.apps.googleusercontent.com",
        "client_secret":"dQ7r3RI6ujEcc1xHQlDDn195",
        "token":"#token"
    }
}

/etc/apache2/sites-available/default-ssl

#TODO Media bug fix
https://github.com/owncloud/apps/commit/64ce426e073fff7118a5b0f5490f6887ef08ef2f
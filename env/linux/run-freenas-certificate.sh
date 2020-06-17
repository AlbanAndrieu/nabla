#!/bin/bash
set -xv

./run-gcloud.sh

#See https://jorgedelacruz.uk/2019/08/20/freenas-how-to-deploy-a-lets-encrypt-ssl-certificate-in-freenas-11-x-and-https-configuration/

curl https://get.acme.sh | sh

git clone https://github.com/danb35/deploy-freenas
cp /root/deploy-freenas/deploy_config.example /root/deploy-freenas/deploy_config
#in jail
#cp /deploy-freenas/deploy_config.example /deploy-freenas/deploy_config
nano /root/deploy-freenas/deploy_config
#nano /deploy-freenas/deploy_config

source .bashrc
/root/.acme.sh/acme.sh --issue --dns dns_gcloud -d albandrieu.com -d '*.albandrieu.com' --reloadcmd "/root/deploy-freenas/deploy_freenas.py"
# Go to https://console.developers.google.com/project/1054538550931/settings
#/root/.acme.sh/acme.sh --nginx  --issue --dns dns_gcloud -d albandrieu.com -d '*.albandrieu.com' --reloadcmd "/root/deploy-freenas/deploy_freenas.py"
/root/.acme.sh/acme.sh --apache  --issue --dns dns_gcloud -d albandrieu.com -d '*.albandrieu.com' --reloadcmd "/root/deploy-freenas/deploy_freenas.py"
#-w /var/www/html
ls -lrta /usr/local/etc/nginx
ls -lrta /usr/local/www
#ls -lrta /wrkdirs/usr/ports/www/nginx/work

echo "_acme-challenge.albandrieu.com"

exit 0

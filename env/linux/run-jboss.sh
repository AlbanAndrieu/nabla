#https://www.digitalocean.com/community/articles/how-to-install-jboss-on-ubuntu-12-10-64bit

#as jenkins user
/workspace/jboss-as-7.1.1.Final/bin/standalone.sh
#check
echo $JBOSS_HOME

http://localhost:8180
http://localhost:9990/console
#http://127.0.0.1:9990/console/App.html

cd /workspace/jboss/jboss-as-7.1.1.Final/bin
chmod 755 *.sh
add-user.sh
a
Realm (ManagementRealm) : ManagementRealm
Username : nabla
Password : microsoft
Re-enter Password : microsoft

#for cargo
a
Realm (ManagementRealm) : ManagementRealm
Username : admin
Password : microsoft
Re-enter Password : microsoft

cd /etc/init.d
sudo chmod 755 ./jboss
sudo chmod -R 777 /var/log/jboss-as/

cd /etc
sudo mkdir jboss-as
cd jboss-as
sudo ln -s /workspace/jboss-as-7.1.1.Final/bin/init.d/jboss-as.conf jboss-as.conf

cd /usr/share
sudo ln -s /workspace/jboss-as-7.1.1.Final jboss-as

sudo update-rc.d -n jboss start 92 2 3 4 5 . stop 08 0 1 6 .
sudo update-rc.d -n jboss start 92 2 3 4 5 . stop 08 0 1 6 .

tail -f /var/log/jboss-as/console.log

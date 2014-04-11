#http://vpscoupons.co/configuring-ufw-firewall-on-ubuntu-12-04/

sudo ufw enable
sudo ufw default deny incoming
sudo ufw default allow outgoing
sudo ufw allow 5900
sudo ufw allow ssh 

sudo ufw status
sudo ufw app list
cat /etc/services | grep webmin
sudo ufw allow CUPS

sudo ufw allow webmin
#usermin
sudo ufw allow 20000
#sudo ufw allow Samba
sudo ufw allow from 10.0.0.0/8 to 127.0.0.1 app Samba
sudo ufw allow to 10.0.0.0/8 from 127.0.0.1 app Samba
sudo ufw allow from 10.0.0.0/8 to any port 3306/
#sudo ufw allow mysql

#sudo ufw allow ntp

#Allow port 80 (for your webserver to server HTTP).
#sudo ufw allow www
sudo ufw allow 80/tcp
#Allow port 443 (as we have SSL enabled for our clients security).
sudo ufw allow 443/tcp
#Allow port 25 (for your Email SMTP)
sudo ufw allow 25/tcp

#sudo ufw allow from 207.46.232.182

sudo chmod 755 /etc/X11/xinit/xinitrc 

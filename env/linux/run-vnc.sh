#http://doc.ubuntu-fr.org/vnc
#https://www.digitalocean.com/community/articles/how-to-setup-vnc-for-ubuntu-12

#sudo apt-get install ubuntu-desktop tightvncserver xfce4 xfce4-goodies

#see run-ufw.sh to set up firewall

#http://rbgeek.wordpress.com/2012/06/25/how-to-install-vnc-server-on-ubuntu-server-12-04/
sudo apt-get install vnc4server
cd /home/albandri/.vnc
./startScript.sh

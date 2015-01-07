#http://doc.ubuntu-fr.org/trafic

sudo apt-get install wireshark
sudo dpkg-reconfigure wireshark-common 
sudo usermod -a -G wireshark $USER
sudo reboot
#Ubuntu desktop
#gnome-session-quit --logout --no-prompt
#Ubuntu server
#pkill -KILL -u $USER 

#http://www.dickson.me.uk/2012/09/17/installing-wireshark-on-ubuntu-12-04-lts/

#http://troy.jdmz.net/samba/fw/
#Samba
#udp.port == 137
#eth.addr == ff:ff:ff:ff:ff:ff
#http && ip.src==10.25.40.129

#start  firewall
sudo ufw status
sudo ufw app info Samba

#Dropbox broadcast
grep 17500  /etc/services

sudo service iptables restart

#Ports list
#http://fr.wikipedia.org/wiki/Liste_de_ports_logiciels

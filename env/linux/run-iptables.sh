
java -jar /workspace/selenium-server-standalone-2.40.0.jar -port 7777 -role hu
sudo iptables -A INPUT -p tcp -m tcp --dport 4444 -j ACCEPT
sudo iptables -A INPUT -p tcp -i eth0 --dport 7779 -j ACCEPT
sudo iptables -L

#Short answer: you can't. Ports below 1024 can be opened only by root.
http://serverfault.com/questions/112795/how-can-i-run-a-server-on-linux-on-port-80-as-a-normal-user
#selenium
sudo iptables -t nat -A PREROUTING -p tcp --dport 4444 -j REDIRECT --to-port 2222
sudo iptables -t nat -I OUTPUT -p tcp -d 127.0.0.1 --dport 4444 -j REDIRECT
sudo iptables -t nat -I OUTPUT -p tcp -d 0.0.0.0/0 --dport 4444 -j REDIRECT --to-ports 2222

#sudo iptables -t nat --line-numbers -n -L
#delete rule 2
#iptables -t nat -D PREROUTING 2
sudo iptables -t nat -D OUTPUT 2

sudo iptables -t nat -A PREROUTING -p all -d 0.0.0.0/0 -j nova-network-PREROUTING
2    nova-network-PREROUTING  all  --  0.0.0.0/0            0.0.0.0/0

192.168.122.0/24
192.168.0.29

less /etc/network/interfaces

#local forward
ssh -L '*:4444:localhost:4444' mybox 

netstat -an | grep 8080
netstat -tlnp | grep 8080
nmap -v -sV -PN albandri
sudo lsof -i :8080
sudo lsof -i tcp:443

From the machine 192.168.0.29 run the following and post back here.
To list listening devices and ports
sudo netstat -lnp

To list firewall settings
sudo iptables -L

List running processes and the ports open for those processes.
sudo rpcinfo -p

To check what outbound connections you have running.
sudo lsof -i -P -n
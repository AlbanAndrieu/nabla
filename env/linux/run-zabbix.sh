#!/bin/bash
set -xv

#http://www.zabbix.com/download.php
#See video https://www.youtube.com/watch?v=S_9XMcuYk5Q
#Download VMware / VirtualBox (.vmdk)
cd /workspace
mv ~/Downloads/Zabbix_2.2_x86_64.x86_64-2.2.2.vmx.tar.gz .
tar -xvf Zabbix_2.2_x86_64.x86_64-2.2.2.vmx.tar.gz
cd /workspace/Zabbix_2.2_x86_64-2.2.2

#Zabbix Server :
#Username = root
#Password = zabbix

#Zabbix FrontEnd:
#Username = Admin (capital A)
#Password = zabbix

ifconfig
dhcpcd eth1

#check inet addresse
#http://10.0.0.45/zabbix/

#Configuration files are placed in /etc/zabbix
#Zabbix logfiles are placed in /var/log/zabbix
#Zabbix frontend is placed in /usr/share/zabbix
#Home directory for user zabbix is /var/lib/zabbix

#Default install of zabbix with Chocolatey is in C:\Program Files\Zabbix Agent

#In order to install zabbix by hand on windows
#Download zabbix-agent for windows at http://www.zabbix.com/download.php
#Open cmd with run as Administrator
#REM cd C:\Program Files\Zabbix Agent
#REM zabbix_agentd.exe -c zabbix_agentd.conf -i
#REM zabbix_agentd.exe -c zabbix_agentd.conf -s
#REM C:\ProgramData\zabbix\zabbix_agentd.conf

#Disable Windows firewall
#I managed to connect zabbix-agent (VM 1) to zabbix server (VM 2), but I had to disable Windows firewall. Must allow port 10050 Inbound Connection in Firewall

#MacOSX
#See http://blog.oper-init.eu/2016/07/05/install-zabbix-agent-on-mac-osx/

ls -lrta /usr/local/etc/zabbix/zabbix_agentd.conf
#ls -lrta /usr/local/sbin/zabbix_agentd
nano /etc/zabbix/zabbix_agentd.conf
zabbix_agentd

#Test your file
#plutil /Library/LaunchAgents/org.macports.zabbix_agent.plist
sudo launchctl load -w /Library/LaunchAgents/org.macports.zabbix_agent.plist

sudo launchctl list

tail -f /tmp/zabbix_agentd.log

#Solaris
svcs | grep zabbix
svcadm refresh zabbix-agent
svcadm restart zabbix-agent

exit 0

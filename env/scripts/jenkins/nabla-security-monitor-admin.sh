#!/bin/bash
#set -xve

./step-2-0-0-build-env.sh

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} ssl encrypt renewal${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

certbot-auto renew

ls -lrta /var/log/letsencrypt/letsencrypt.log

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} LOG output check${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#sudo head -n 1000 /var/log/tomcat7/catalina.out || exit 1
sudo tail -n 1000 /var/log/tomcat7/catalina.out || exit 1

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} SECURITY/ROOTKIT${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#sudo badblocks -v /dev/sda > bad-blocks

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} LOGWATCH${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

sudo logwatch

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} USERS CONNECT TIMES${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

sudo ac -d -p

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} COMMANDS BY USER${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

users=$(sudo cat /etc/passwd | awk -F ':' '{print $1}' | sort)

for user in $users ; do
  comm=$(sudo lastcomm --user $user | awk '{print $1}' | sort | uniq -c | sort -nr)
  if [ "$comm" ] ; then
    echo -e "$user:"
    echo -e "$comm"
  fi
done

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} COMMANDS BY FREQUENCY OF EXECUTION${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

sudo sa | awk '{print $1, $6}' | sort -n | head -n -1 | sort -nr

sudo logwatch

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} HARDWARE${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

sudo lshw

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} WORKSPACE FILES SIZE${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

sudo du -cks /workspace/* | sort -gr

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} FAIL 2 BAN${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

sudo fail2ban-client status
sudo fail2ban-client status ssh
sudo fail2ban-client status apache
sudo fail2ban-client status apache-modevasive
sudo fail2ban-client status apache-modevasive

exit 0

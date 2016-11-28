#!/bin/bash

if [ -n "${TARGET_SERVER}" ]; then
  echo "TARGET_SERVER is defined"
else
  echo "Undefined build parameter: TARGET_SERVER, use the default one"
  export TARGET_SERVER=nabla.freeboxos.fr
fi

if [ -n "${TARGET_PORT}" ]; then
  echo "TARGET_PORT is defined"
else
  echo "Undefined build parameter: TARGET_PORT, use the default one"
  export TARGET_PORT=8280
fi

if [ -n "${TARGET_URL}" ]; then
  echo "TARGET_URL is defined"
else
  echo "Undefined build parameter: TARGET_URL, use the default one"
  export TARGET_URL="visma/"
fi

echo ""
echo "################### LOG output check ###################"
echo ""

sudo head -n 1000 /var/log/tomcat7/catalina.out || exit 1
#sudo tail -n 1000 /var/log/tomcat7/catalina.out || exit 1

echo ""
echo "################### SECURITY/ROOTKIT ###################"
echo ""

#sudo badblocks -v /dev/sda > bad-blocks

echo ""
echo "################### LOGWATCH ###################"
echo ""

sudo logwatch

echo ""
echo "################### USERS' CONNECT TIMES ###################"
echo ""

sudo ac -d -p

echo ""
echo "################### COMMANDS BY USER ###################"
echo ""

users=$(sudo cat /etc/passwd | awk -F ':' '{print $1}' | sort)

for user in $users ; do
  comm=$(sudo lastcomm --user $user | awk '{print $1}' | sort | uniq -c | sort -nr)
  if [ "$comm" ] ; then
    echo "$user:"
    echo "$comm"
  fi
done

echo ""
echo "################### COMMANDS BY FREQUENCY OF EXECUTION ###################"
echo ""

sudo sa | awk '{print $1, $6}' | sort -n | head -n -1 | sort -nr

sudo logwatch

echo ""
echo "################### HARDWARE ###################"
echo ""

sudo lshw

echo ""
echo "################### WORKSPACE FILES SIZE ###################"
echo ""

sudo du -cks /workspace/* | sort -gr

echo ""
echo "################### FAIL 2 BAN ###################"
echo ""

sudo fail2ban-client status
sudo fail2ban-client status ssh
sudo fail2ban-client status apache
sudo fail2ban-client status apache-modevasive
sudo fail2ban-client status apache-modevasive

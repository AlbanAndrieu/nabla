#!/bin/bash

echo ""
echo "################### APACHE ###################"
echo ""

#for /usr/sbin/apache2 -V
source /etc/apache2/envvars
/usr/sbin/apache2 -V

echo ""
echo "################### BENCKMARK APACHE ###################"
echo ""

ab -n 10 -c 5 http://home.nabla.mobi/

echo ""
echo "################### SECURITY/ROOTKIT ###################"
echo ""

#sudo badblocks -v /dev/sda > bad-blocks

echo ""
echo "################### LYNIS ###################"
echo ""

sudo lynis --check-update
sudo lynis --version

sudo lynis --check-all -Q

echo ""
echo "################### RKHUNTER ###################"
echo ""

sudo rkhunter --update
sudo rkhunter --version

sudo rkhunter --checkall --report-warnings-only

echo ""
echo "################### CHROOTKIT ###################"
echo ""

sudo chkrootkit -V

sudo chkrootkit -q

#sudo tiger --version

#sudo tiger

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
echo "################### FILES SIZE ###################"
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

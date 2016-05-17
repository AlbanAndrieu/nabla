#!/bin/bash

if [ -n "${TARGET_SERVER}" ]; then
  echo "TARGET_SERVER is defined"
else
  echo "Undefined build parameter: TARGET_SERVER, use the default one"
  export TARGET_SERVER=home.nabla.mobi
fi

echo ""
echo "################### APACHE ###################"
echo ""

#for /usr/sbin/apache2 -V
source /etc/apache2/envvars
/usr/sbin/apache2 -V

#Verify if the mod_security module was loaded.
apachectl -M | grep --color security

echo ""
echo "################### BENCKMARK APACHE ###################"
echo ""

ab -n 10 -c 5 http://${TARGET_SERVER}/

echo ""
echo "################### URLS CHECK ###################"
echo ""

openssl version
#Warning openssl must be OpenSSL 1.0.1f 6 Jan 2014 otherwise check for ls1_1 and ls1_2 will not work

OPENSSL_OPTIONS="-quiet"

#apache check
echo "#######################"
echo "Apache check"
echo "---- TLS 1 ----"
openssl s_client -connect ${TARGET_SERVER}:443 -tls1 && echo ERROR
echo "---- TLS 1.1 ----"
openssl s_client -connect ${TARGET_SERVER}:443 -tls1_1 && echo ERROR
echo "---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:443 -tls1_2 && echo OK

#tomcat check
echo "#######################"
echo "Tomcat check"
echo "---- TLS 1 ----"
openssl s_client -connect ${TARGET_SERVER}:8280 -tls1 && echo ERROR
echo "---- TLS 1.1 ----"
openssl s_client -connect ${TARGET_SERVER}:8280 -tls1_1 && echo ERROR
echo "---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:8280 -tls1_2 && echo OK

#jetty check
echo "#######################"
echo "Jetty check"
echo "---- TLS 1 ----"
openssl s_client -connect ${TARGET_SERVER}:9090 -tls1 && echo ERROR
echo "---- TLS 1.1 ----"
openssl s_client -connect ${TARGET_SERVER}:9090 -tls1_1 && echo ERROR
echo "---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:9090 -tls1_2 && echo OK

#TODO sonar jenkins

#quick service check
curl --version

echo "#######################"
echo "Apache check"
curl -k -I --stderr /dev/null https://${TARGET_SERVER}:443 | head -1 | cut -d' ' -f2

echo "#######################"
echo "Tomcat check"
curl -k -I -o /dev/null --silent --head --write-out 'kgr return is : %{http_code}\n' https://${TARGET_SERVER}:8280/visma/

echo ""
echo "################### LOG output check ###################"
echo ""

head -n 1000 /var/log/tomcat7/catalina.out || exit 1
tail -n 1000 /var/log/tomcat7/catalina.out || exit 1

echo ""
echo "################### SECURITY/ROOTKIT ###################"
echo ""

#sudo badblocks -v /dev/sda > bad-blocks

echo ""
echo "################### LYNIS ###################"
echo ""

sudo /usr/local/lynis/2.2.0/lynis --check-update
sudo /usr/local/lynis/2.2.0/lynis --version

sudo /usr/local/lynis/2.2.0/lynis --check-all -Q

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

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
  export TARGET_URL=visma
fi

echo ""
echo "################### APACHE ###################"
echo ""

#for /usr/sbin/apache2 -V
source /etc/apache2/envvars
/usr/sbin/apache2 -V

#Verify if the mod_security module was loaded.
sudo chmod 666 /var/log/apache2/modsec_audit.log
/usr/sbin/apachectl -M | grep --color security

echo ""
echo "################### BENCKMARK APACHE ###################"
echo ""

ab -n 10 -c 5 http://${TARGET_SERVER}/

echo ""
echo "################### OPENSSL VERSION ###################"
echo ""

openssl version
#openssl must be OpenSSL 1.0.1f 6 Jan 2014 otherwise check for ls1_1 and ls1_2 will not work

OPENSSL_OPTIONS="-quiet -ign_eof -CAfile /etc/ssl/certs/ca-certificates.crt"

#TODO :
#https://www.feistyduck.com/library/openssl-cookbook/online/ch-testing-with-openssl.html

echo ""
echo "################### CHECK HTTP TAMPERING ###################"
echo ""

#printf "HEAD /visma HTTP/1.1\nHost: nabla.freeboxos.fr\n\n" | nc -q 1 nabla.freeboxos.fr 8280
#printf "HEAD /visma/rest/ping HTTP/1.1\nHost: nabla.freeboxos.fr\n\n" | nc -q 1 nabla.freeboxos.fr 8280

for method in TEST CONNECT COPY DELETE GET HEAD LOCK MKCOL MOVE OPTIONS POST PROPPATCH PROPFIND PUT TRACE UNLOCK ;
do
  printf "%-10s " $method ;
  printf "$method /${TARGET_URL} HTTP/1.1\nHost: ${TARGET_SERVER}\n\n" | nc -q 1 ${TARGET_SERVER} ${TARGET_PORT} | grep "HTTP/1.1"

done

echo ""
echo "################### CHECK HTTPS TAMPERING ###################"
echo ""

for method in TEST CONNECT COPY DELETE GET HEAD LOCK MKCOL MOVE OPTIONS POST PROPPATCH PROPFIND PUT TRACE UNLOCK ;
do
  printf "%-10s " $method ;
  printf "$method /${TARGET_URL} HTTP/1.1\nHost: ${TARGET_SERVER}\n\n" | openssl s_client -connect ${TARGET_SERVER}:${TARGET_PORT} ${OPENSSL_OPTIONS} 2> /dev/null | grep "HTTP/1.1"
  #&& echo "Port is open on ${TARGET_SERVER}:${TARGET_PORT} for $method" || echo "Port is closed on ${TARGET_SERVER}:${TARGET_PORT} for $method"

done

echo ""
echo "################### CHECK CONNECTION REUSE ###################"
echo ""

echo | openssl s_client -connect ${TARGET_SERVER}:${TARGET_PORT} -reconnect -no_ssl2 2> /dev/null | grep 'New\|Reuse'

echo ""
echo "################### CHECK BEAST VULNERABILITY ###################"
echo ""

echo | openssl s_client -connect ${TARGET_SERVER}:${TARGET_PORT} -cipher 'ALL:!RC4' -no_ssl2 -no_tls1_1 -no_tls1_2 && echo ERROR

echo ""
echo "################### CHECK Diffie-Hellman STRENGTH ###################"
echo ""

#openssl-1.0.2 s_client -connect mgrvkenvi031.misys.global.ad:19084 -cipher kEDH

echo ""
echo "################### URLS CHECK ###################"
echo ""

#TODO
nmap -sV -p80,443,8280,8443,9443 --script http-methods nabla.freeboxos.fr
nmap -sV -p80,443,8280,8443,9443 --script http-methods --script-args http.url-path='/visma/rest/ping' localhost

#apache check
echo "#######################"
echo "Apache check"
echo "---- TLS 1 ----"
openssl s_client -connect ${TARGET_SERVER}:443 -tls1 2> /dev/null && echo ERROR
echo "---- TLS 1.1 ----"
openssl s_client -connect ${TARGET_SERVER}:443 -tls1_1 2> /dev/null && echo ERROR
echo "---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:443 -tls1_2 2> /dev/null && echo OK

#tomcat check
echo "#######################"
echo "Tomcat check"
echo "---- TLS 1 ----"
openssl s_client -connect ${TARGET_SERVER}:8280 -tls1 2> /dev/null && echo ERROR
echo "---- TLS 1.1 ----"
openssl s_client -connect ${TARGET_SERVER}:8280 -tls1_1 2> /dev/null && echo ERROR
echo "---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:8280 -tls1_2 2> /dev/null && echo OK

#jetty check
echo "#######################"
echo "Jetty check"
echo "---- TLS 1 ----"
openssl s_client -connect ${TARGET_SERVER}:9090 -tls1 2> /dev/null && echo ERROR
echo "---- TLS 1.1 ----"
openssl s_client -connect ${TARGET_SERVER}:9090 -tls1_1 2> /dev/null && echo ERROR
echo "---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:9090 -tls1_2 2> /dev/null && echo OK

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
echo "################### CHECK OPEN PORTS ###################"
echo ""

nmap -sV -T4 --version-intensity 1 ${TARGET_SERVER}

echo ""
echo "################### CHECK SSL CIPHERS ###################"
echo ""

nmap -sT -PN -p ${TARGET_PORT} ${TARGET_SERVER} --script ssl-cert,ssl-enum-ciphers

echo ""
echo "################### CHECK POODLE ###################"
echo ""

if [ -f ssl-poodle.nse ]; then
  echo "Poodle file found"
else
  wget http://nmap.org/svn/scripts/ssl-poodle.nse
  wget http://nmap.org/svn/nselib/tls.lua
fi
nmap -sV --version-light --script ssl-poodle -p ${TARGET_PORT} ${TARGET_SERVER}

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
echo "################### LYNIS ###################"
echo ""

#TODO use /usr/local/lynis/2.2.0/lynis
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

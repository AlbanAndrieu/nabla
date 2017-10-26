#!/bin/bash
#set -xve

source ./step-2-0-0-build-env.sh

echo "https://www.ssllabs.com/ssltest/analyze.html?d=nabla.freeboxos.fr&s=82.253.244.162"

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} APACHE${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#for /usr/sbin/apache2 -V
source /etc/apache2/envvars
/usr/sbin/apache2 -V

#Verify if the mod_security module was loaded.
sudo chmod 666 /var/log/apache2/modsec_audit.log
/usr/sbin/apachectl -M | grep --color security

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} BENCKMARK APACHE${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

ab -n 10 -c 5 http://localhost:7070/

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} OPENSSL VERSION${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

openssl version
#openssl must be OpenSSL 1.0.1f 6 Jan 2014 otherwise check for ls1_1 and ls1_2 will not work

OPENSSL_OPTIONS="-quiet -ign_eof -CAfile /etc/ssl/certs/ca-certificates.crt"

#TODO :
#https://www.feistyduck.com/library/openssl-cookbook/online/ch-testing-with-openssl.html

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHECK HTTP TAMPERING${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#printf "HEAD /visma HTTP/1.1\nHost: nabla.freeboxos.fr\n\n" | nc -q 1 nabla.freeboxos.fr 8280
#printf "HEAD /visma/rest/ping HTTP/1.1\nHost: nabla.freeboxos.fr\n\n" | nc -q 1 nabla.freeboxos.fr 8280

for method in TEST CONNECT COPY DELETE GET HEAD LOCK MKCOL MOVE OPTIONS POST PROPPATCH PROPFIND PUT TRACE UNLOCK ;
do
  printf "%-10s " $method ;
  printf "$method /${TARGET_URL} HTTP/1.1\nHost: ${TARGET_SERVER}\n\n" | nc -q 1 ${TARGET_SERVER} ${TARGET_PORT} | grep "HTTP/1.1"

done

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHECK HTTPS TAMPERING${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

for method in TEST CONNECT COPY DELETE GET HEAD LOCK MKCOL MOVE OPTIONS POST PROPPATCH PROPFIND PUT TRACE UNLOCK ;
do
  printf "%-10s " $method ;
  printf "$method /${TARGET_URL} HTTP/1.1\nHost: ${TARGET_SERVER}\n\n" | openssl s_client -connect ${TARGET_SERVER}:8444 ${OPENSSL_OPTIONS} 2> /dev/null | grep "HTTP/1.1"
  #&& echo -e "Port is open on ${TARGET_SERVER}:${TARGET_PORT} for $method" || echo -e "Port is closed on ${TARGET_SERVER}:${TARGET_PORT} for $method"

done

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHECK CONNECTION REUSE${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

echo | openssl s_client -connect ${TARGET_SERVER}:${TARGET_PORT} -reconnect -no_ssl2 2> /dev/null | grep 'New\|Reuse'

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHECK BEAST VULNERABILITY${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

echo | openssl s_client -connect ${TARGET_SERVER}:${TARGET_PORT} -cipher 'ALL:!RC4' -no_ssl2 -no_tls1_1 -no_tls1_2 && echo ERROR

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHECK Diffie-Hellman STRENGTH${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#openssl-1.0.2 s_client -connect ${TARGET_SERVER}:${TARGET_PORT} -cipher kEDH

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHURLS CHECK${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

#TODO
nmap -sV -p80,443,7070,8280,8443,8444,9443 --script http-methods nabla.freeboxos.fr
nmap -sV -p80,443,7070,8280,8443,8444,9443 --script http-methods --script-args http.url-path='/visma/rest/ping' localhost

#apache check
echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} APACHE CHECK${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"
echo -e "${green} ---- TLS 1 ----"
echo -e "${red}"
openssl s_client -connect ${TARGET_SERVER}:443 -tls1 2> /dev/null && echo ERROR
echo -e "${NC}"
echo -e "${green} ---- TLS 1.1 ----"
echo -e "${red}"
openssl s_client -connect ${TARGET_SERVER}:443 -tls1_1 2> /dev/null && echo ERROR
echo -e "${NC}"
echo -e "${green} ---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:443 -tls1_2 2> /dev/null && echo OK
echo -e "${NC}"

#ZaProxy check
echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} ZAPROXY CHECK${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"
echo -e "${green} ---- TLS 1 ----"
echo -e "${red}"
openssl s_client -connect ${TARGET_SERVER}:8443 -tls1 2> /dev/null && echo ERROR
echo -e "${NC}"
echo -e "${green} ---- TLS 1.1 ----"
echo -e "${red}"
openssl s_client -connect ${TARGET_SERVER}:8443 -tls1_1 2> /dev/null && echo ERROR
echo -e "${NC}"
echo -e "${green} ---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:8443 -tls1_2 2> /dev/null && echo OK
echo -e "${NC}"

#tomcat check
echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} TOMCAT CHECK${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"
echo -e "${green} ---- TLS 1 ----"
echo -e "${red}"
openssl s_client -connect ${TARGET_SERVER}:8444 -tls1 2> /dev/null && echo ERROR
echo -e "${NC}"
echo -e "${green} ---- TLS 1.1 ----"
echo -e "${red}"
openssl s_client -connect ${TARGET_SERVER}:8444 -tls1_1 2> /dev/null && echo ERROR
echo -e "${NC}"
echo -e "${green} ---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:8444 -tls1_2 2> /dev/null && echo OK
echo -e "${NC}"

#jetty check
echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} JETTY CHECK${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"
echo -e "${green} ---- TLS 1 ----"
echo -e "${red}"
openssl s_client -connect ${TARGET_SERVER}:9443 -tls1 2> /dev/null && echo ERROR
echo -e "${NC}"
echo -e "${green} ---- TLS 1.1 ----"
echo -e "${red}"
openssl s_client -connect ${TARGET_SERVER}:9443 -tls1_1 2> /dev/null && echo ERROR
echo -e "${NC}"
echo -e "${green} ---- TLS 1.2 ----"
openssl s_client -connect ${TARGET_SERVER}:9443 -tls1_2 2> /dev/null && echo OK
echo -e "${NC}"

#TODO sonar jenkins

#quick service check
curl --version

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} APACHE CHECK${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"
curl -k -I --stderr /dev/null https://${TARGET_SERVER}:7070 | head -1 | cut -d' ' -f2
curl -k -I --stderr /dev/null https://${TARGET_SERVER}:443 | head -1 | cut -d' ' -f2

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} TOMCAT CHECK${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"
curl -k -I -o /dev/null --silent --head --write-out 'visma return is : %{http_code}\n' https://${TARGET_SERVER}:8280/${TARGET_URL}
curl -k -I -o /dev/null --silent --head --write-out 'visma return is : %{http_code}\n' https://${TARGET_SERVER}:8444/${TARGET_URL}

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} NMAP TOP 100${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

awk '$2~/tcp$/' /usr/share/nmap/nmap-services | sort -r -k3 | head -n 100

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHECK OPEN PORTS${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

nmap -sV -T4 --version-intensity 1 ${TARGET_SERVER}

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHECK SSL CIPHERS${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

nmap -sT -PN -p 443 ${TARGET_SERVER} --script ssl-cert,ssl-enum-ciphers
#nmap --script ssl-enum-ciphers -p 443 ${TARGET_SERVER

echo -e "${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${green} CHECK POODLE${NC}"
echo -e "${magenta} ${underline}###################${NC}"
echo -e "${NC}"

if [ -f ssl-poodle.nse ]; then
  echo -e "Poodle file found"
else
  wget http://nmap.org/svn/scripts/ssl-poodle.nse
  wget http://nmap.org/svn/nselib/tls.lua
fi
nmap -sV --version-light --script ssl-poodle -p ${TARGET_PORT} ${TARGET_SERVER}

#echo -e "${NC}"
#echo -e "${magenta} ${underline}###################${NC}"
#echo -e "${green} CHECK AUTO LOGIN${NC}"
#echo -e "${magenta} ${underline}###################${NC}"
#echo -e "${NC}"
#
#curl -i -v -k --data "username=admin&password=microsoft" http://localhost:9090/rest-service-fecru/auth/login

exit 0

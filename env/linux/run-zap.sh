#!/bin/bash
set -xv

#See https://zaproxy.blogspot.fr/

#Add zap proxy configuration with firefox
#https://code.google.com/p/zaproxy/wiki/HelpStartProxies

#Select the	'Tools' menu
#Select the	'Options..' menu item
#Press the	'Advanced' button
#Select the	'Network' tab
#Press the	'Settings...' button
#Select the	'Manual proxy configuration' radio button
#Enter in the	'HTTP Proxy:' field the 'Address' you configured in the Options Local Proxy screen
#Enter in the	'Port' field to the right of the 'HTTP Proxy' field the 'Port' you configured in the Options Local Proxy screen
#8090
#Press the	Connection Setting 'OK' button
#Press the	Options 'OK' button

#In Zap
#Select tools -> Options
#Connection
#Use an outgoing proxy server
#Address localhost
#Port 9090
#Select tools -> Options
#Local proxy
#Address localhost
#Port 8090

#tocheck that zap is linked to firefox
#http://localhost:8090/

#Fix error:
#The Anti-MIME-Sniffing header X-Content-Type-Options was not set to 'nosniff'.
#https://paulbradley.org/apache-http-security-headers/
#In apache
sudo a2enmod headers
sudo nano /etc/apache2/ports.conf
#add
<IfModule mod_headers.c>
    Header unset ETag
    Header set X-Frame-Options: deny
    Header set X-XSS-Protection: "1; mode=block"
    Header set X-Content-Type-Options: nosniff
    Header set X-WebKit-CSP: "default-src 'self'"
    Header set X-Permitted-Cross-Domain-Policies: "master-only"
</IfModule>

#Zap sample : The BodgeIt Store is a vulnerable web application suitable for pen testing
#based on http://code.google.com/p/bodgeit/
#git clone https://code.google.com/p/bodgeit-maven/
#My fork
git clone https://github.com/AlbanAndrieu/bodgeit.git

#Zap
#http://www.dinosec.com/docs/Building_ZAP_with_Eclipse_v3.0.pdf
sudo apt-get install ant-contrib
svn checkout http://zaproxy.googlecode.com/svn/trunk/ zaproxy-read-only
mvn install:install-file -Dfile=./zap/zap-api-v2-4.jar -DgroupId=org.zaproxy -DartifactId=clientapi -Dversion=2.4.0.1 -Dpackaging=jar
cd zaproxy-read-only/build
ant lite-release

#Maven
#git clone https://github.com/ShiNoSenshi/zap-maven-plugin.git
#git clone https://code.google.com/p/zap-maven-plugin/
git clone https://github.com/javabeanz/zap-maven-plugin.git

#TODO no more needed since I switch to ZaProxy Jenkins plugin
#grunt
#npm install async --save-dev
#npm install request --save-dev
#npm install grunt-zaproxy --save-dev

#jenkins
#add PATH
#Inside Jenkins for master
#http://stackoverflow.com/questions/5818403/jenkins-hudson-environment-variables
#sudo nano /etc/profile
#export ZAPROXY_HOME=/zapSource/build/zap
#export PATH=$PATH:$ZAPROXY_HOME
#sudo su - jenkins
#source /etc/profile

#TODO no more needed since I switch to ZaProxy Jenkins plugin
#sudo nano /etc/init/jenkins.conf
#export ZAPROXY_HOME=/zapSource/build/zap
#export PATH=$PATH:$ZAPROXY_HOME

sudo apt-get install phantomjs
#sudo apt-get install adobe-flashplugin
sudo apt-get install chromium-chromedriver
#below needed for protractor tests
#sudo apt-get install google-chrome-stable

#for zap
/usr/bin/firefox --version || true
/usr/bin/phantomjs --version || true
/usr/lib/chromium-browser/chromedriver --version || true

#https://github.com/zaproxy/zap-core-help/wiki/HelpCmdline
-addoninstallall
#-installdir %ZAPROXY_HOME%
-dir ZAP_D-2017-01-16
#https://github.com/zaproxy/zap-core-help/wiki/HelpAddonsSeleniumIntro
-config ajaxSpider.browserId=htmlunit
-config rules.csrf.ignorelist=login-form
#-config rules.csrf.ignorelist="search,login,login-form"

-addonlist
#-addonupdate
-addoninstall soap -addoninstall openapi
#ascanrulesAlpha v18
#pscanrules v18
#directorylistv2_3_lc v3
#ascanrulesBeta v21
#pscanrulesBeta v15
#spiderAjax v17
#selenium v9

#https://gist.github.com/caspyin/2288960
curl -i -v -k ${SERVER_URL}${SERVER_CONTEXT} --data "username=test&password=microsoft"

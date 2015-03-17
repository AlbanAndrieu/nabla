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

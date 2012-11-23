
OpenId
http://www.google.com/a/cpanel/nabla.mobi/SetupIdp
TODO SONAR connect to OpenID

# Generate the RSA keys and certificate
openssl req -x509 -nodes -days 365 -newkey rsa:1024 -sha1 -subj \
  '/C=FR/ST=IDF/L=Paris/CN=www.nabla.mobi' -keyout \
  nablarsakey.pem -out /tmp/nablarsacert.pem
  
#For connecting google to ldap see run-ldap
#http://support.google.com/a/bin/answer.py?hl=fr&answer=106368  

TODO add password syncronisation in Google Apps Directory Sync

#!/bin/bash
set -xv

#OpenId
#http://www.google.com/a/cpanel/nabla.mobi/SetupIdp
#TODO SONAR connect to OpenID

# Generate the RSA keys and certificate
openssl req -x509 -nodes -days 365 -newkey rsa:1024 -sha1 -subj \
  '/C=FR/ST=IDF/L=Paris/CN=www.nabla.mobi' -keyout \
  nablarsakey.pem -out /tmp/nablarsacert.pem

Incoming Mail (IMAP) Server - Requires SSL
imap.gmail.com
Port: 993
Requires SSL:Yes

Outgoing Mail (SMTP) Server - Requires TLS
smtp.gmail.com
Port: 465 or 587
Requires SSL: Yes
Requires authentication: Yes
Use same settings as incoming mail server

#My google analytics account ID
UA-56011797-1

#https://www.thefanclub.co.za/overgrive

#https://console.developers.google.com/apis/dashboard?project=nabla-01

#ID de l organisation gcloud
1069974290280

# Add the Cloud SDK distribution URI as a package source
echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] http://packages.cloud.google.com/apt cloud-sdk main" | sudo tee -a /etc/apt/sources.list.d/google-cloud-sdk.list

# Import the Google Cloud Platform public key
curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key --keyring /usr/share/keyrings/cloud.google.gpg add -

# Update the package list and install the Cloud SDK
sudo apt-get update && sudo apt-get install google-cloud-sdk

exit 0

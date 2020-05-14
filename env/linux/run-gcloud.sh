#!/bin/bash
set -xv

sudo snap install google-cloud-sdk --classic
gcloud init
#less /home/albandrieu/.boto
gcloud auth list

# See https://www.cyberciti.biz/faq/howto-deploying-freebsd11-unix-on-google-cloud/
type -a python
/usr/local/bin/python --version

# See https://cloud.google.com/sdk/docs/downloads-versioned-archives
wget https://dl.google.com/dl/cloudsdk/channels/rapid/downloads/google-cloud-sdk-280.0.0-linux-x86_64.tar.gz
tar zxvf google-cloud-sdk-280.0.0-linux-x86_64.tar.gz
./google-cloud-sdk/install.sh

/root/google-cloud-sdk/bin/gcloud init
/root/google-cloud-sdk/bin/gcloud auth list

# See https://cloud.google.com/sdk/auth_success

# ADD https://cloud.google.com/dns/zones
# https://console.cloud.google.com/net-services/dns/zones/nabla?project=nabla-01&folder&organizationId=1069974290280&dnsResourceRecordSetssize=50

gcloud dns managed-zones list

#alban.andrieu@nabla.mobi

export CLOUDSDK_ACTIVE_CONFIG_NAME=default  # see the note above
acme.sh --issue --dns dns_gcloud -d albandrieu.com -d '*.albandrieu.com'

exit 0

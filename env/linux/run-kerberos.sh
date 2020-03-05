#!/bin/bash
set -xv

#http://guide.ubuntu-fr.org/server/kerberos.html
<<<<<<< HEAD
#sudo apt-get install krb5-kdc krb5-admin-server

#sudo krb5_newrealm
#Enter KDC database master key : microsoft

# See https://help.ubuntu.com/community/NFSv4Howto
sudo apt-get install krb5-user
#ALBANDRIEU.COM
#nabla
sudo apt-get install libpam-krb5 
sudo modprobe rpcsec_gss_krb5 

exit 0
=======
sudo apt-get install krb5-kdc krb5-admin-server

sudo krb5_newrealm
Enter KDC database master key : microsoft
>>>>>>> 9053cf3bd92d78dfb9f33cf5b39354fcbe34c705

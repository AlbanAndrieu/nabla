#!/bin/bash
set -xv

#http://guide.ubuntu-fr.org/server/kerberos.html
sudo apt-get install krb5-kdc krb5-admin-server

sudo krb5_newrealm
Enter KDC database master key : microsoft

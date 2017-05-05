#!/bin/bash
set -xv

#http://jose-manuel.me/2012/02/how-to-compile-apache-2-2-x-for-solaris-64bit/
pkginfo |grep SUNWopensslr
pkginfo -l SUNWopensslr
/usr/sfw/bin/openssl version
pkgchk -l SUNWopenssl-libraries
#pkgadd -d http://get.opencsw.org/now
pkgadd -d

#http://www.par.univie.ac.at/solaris/pca/pca-L.html
#https://getupdates.oracle.com/readme/README.148071-16
patchadd /var/spool/patch/123456-07

148072-19  SunOS 5.10_x86: openssl patch
151913-02  Obsoleted by: 151913-03 SunOS 5.10_x86: OpenSSL 1.0.1 patch

#le  fichier /var/sadm/install/contents
#(gros fichier texte)
#contient la liste de tous les fichiers installes avec les noms des packages, le chemin complet, la taille, une checksum.

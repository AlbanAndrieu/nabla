#!/bin/bash
set -xv

#Solaris 10 download
#http://www.oracle.com/technetwork/server-storage/solaris10/downloads/index.html

#PATH=/usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/ccs/bin:/opt/SUNWspro/bin:/usr/sfw/bin:/opt/csw/bin; export PATH
#echo $SHELL
##PS1='\w $ '
#PS1='${HOST}:${PWD} # ';  export PS1
#Switch to bash
#exec bash --noprofile --rcfile /dev/null

#Sun studio 
#http://www.oracle.com/technetwork/server-storage/developerstudio/overview/developer-studio-beta-program-3654693.html
#Sun studio 12 download
#http://www.oracle.com/technetwork/server-storage/developerstudio/downloads/solaris-studio-12-3-2333052.html
#Get Package Installation
wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-solstudio-cookie" wget http://download.oracle.com/otn/solaris/studio/SolarisStudio12.3-solaris-sparc-bin.tar.bz2 -O SolarisStudio12.3-solaris-sparc-bin.tar.bz2
scp SolarisStudio12.3-solaris-sparc-pkg.tar.bz2  root@nabla:/var/www/html/download/sunstudio/12.3
#bzcat download_directory/SolarisStudio12.3-[OS]-[PLATFORM]-[FORMAT].tar.bz2 | /bin/tar -xf - 
bzcat SolarisStudio12.3-solaris-sparc-pkg.tar.bz2 | /bin/tar -xf - 
cd SolarisStudio12.3-solaris-sparc-pkg
#https://docs.oracle.com/cd/E24457_01/html/E21988/girfs.html
#sudo rm -f /.nbi/.nbilock
sudo su - root
./solarisstudio.sh --help
#./solarisstudio.sh --non-interactive --libraries-only --javahome /usr/jdk/instances/jdk1.8.0_131 --verbose
./solarisstudio.sh --non-interactive --javahome /usr/jdk/instances/jdk1.8.0_131 --verbose
ls -ld /opt/solarisstudio12.3
cd /opt
ln -s /opt/solarisstudio12.3 /opt/SUNWspro

#CC: Sun C++ 5.9 SunOS_sparc Patch 124863-14 2009/06/23
#/opt/solarisstudio12.3/bin/CC -V 
#CC: Sun C++ 5.12 SunOS_sparc 2011/11/16


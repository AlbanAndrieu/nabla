#!/bin/bash
#set -xv

# See http://192.168.1.62/jenkins/

#Fix wrong version of Feenas in jail
freebsd-version
jls
sudo jexec 10 freebsd-version

#See https://www.reddit.com/r/freenas/comments/7s1cgb/pkg_repository_freebsd_contains_packages_for/
#I solved it by editing /usr/local/etc/pkg/repos/FreeBSD.conf Setting the url: to "pkg+https://pkg.freebsd.org/freebsd:11:x86:64/release_1" solved the problem.

pkg update && pkg upgrade
pkg update -f
portsnap fetch extract update
#You must run 'portsnap extract' before running 'portsnap update'.

#Install Jenkins
#https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+inside+a+FreeNAS+jail
#https://wiki.jenkins.io/display/JENKINS/Installing+Jenkins+inside+a+FreeNAS+jail

#http://www.slideshare.net/iXsystems/jenkins-bhyve
pkg install devel/jenkins-lts
#pkg install /devel/jenkins
======================================================================

This OpenJDK implementation requires fdescfs(5) mounted on /dev/fd and
procfs(5) mounted on /proc.

If you have not done it yet, please do the following:

        mount -t fdescfs fdesc /dev/fd
        mount -t procfs proc /proc

To make it permanent, you need the following lines in /etc/fstab:

        fdesc   /dev/fd         fdescfs         rw      0       0
        proc    /proc           procfs          rw      0       0

======================================================================

#pkg_add -r jenkins
http://192.168.1.62/jenkins
http://albandrieu.com:8686/jenkins

edit /usr/local/etc/rc.d/jenkins
#--ajp13ListenAddress=192.168.0.14 --ajp13Port=8009
#REMOVE --prefix=/jenkins for jenkins apps on android
#: ${jenkins_enable:=NO}
#: ${jenkins_home="/usr/local/jenkins"}
#: ${jenkins_args="--webroot=${jenkins_home}/war --httpPort=8180 --prefix=/jenkin
#: ${jenkins_java_home="/usr/local/openjdk8"}
#: ${jenkins_user="jenkins"}
#: ${jenkins_group="jenkins"}
#: ${jenkins_log_file="/var/log/jenkins.log"}

echo 'jenkins_enable="YES"' >> /etc/rc.conf

cd /usr/local/etc/rc.d/
edit jenkins

cd /usr/local/share/jenkins/
ls -lrta jenkins.war
mv jenkins.war jenkins.war-2.277.4
/usr/local/bin/wget http://mirrors.jenkins.io/war-stable/latest/jenkins.war
#--> https://get.jenkins.io/war-stable/2.263.4/jenkins.war

# install by hand
#pkg_info | grep jenkins
##pkg_delete jenkins-1.454
#cd /usr/ports/devel/jenkins/ && make install clean
#ll /usr/ports/distfiles/jenkins/1.525/jenkins.war
#cd /usr/local/share/jenkins/

cd /usr/local/jenkins
mv jenkins jenkins-BACK-SAV
ln -s /media/jenkins jenkins

cd /usr/local/jenkins
nano config.xml
#<!--<useSecurity>true</useSecurity>-->

#/usr/local/etc/rc.d/jenkins onestart
#/usr/local/etc/rc.d/jenkins stop
service jenkins restart

tail -f /var/log/jenkins.log
tail -f /mnt/dpool/jail/software/var/log/httpd-access.log

cd /media/jenkins/scm-sync-configuration/checkoutConfiguration
git config --global user.email "alban.andrieu@free.fr"
git config --global user.name "AlbanAndrieu"

edit /media/workspace/zfs-log_parsing_rules

#./run-freenas-nginx.sh\

# See http://dnaeon.github.io/apache-proxy-freebsd/

#Add mod_proxy xlm2ec inside
nano /usr/local/etc/apache24/httpd.conf

nano /usr/local/etc/apache24/extra/httpd-vhosts.conf

<VirtualHost *:80>
    #<IfModule alias_module>
    #    Redirect permanent / https://albandrieu.com/
    #</IfModule>

    ServerAdmin alban.andrieu@free.fr
    #DocumentRoot "/usr/local/docs/dummy-host.example.com"
    DocumentRoot "/usr/local/www/apache24/data/"
    ServerName albandrieu.com
    ServerAlias www.albandrieu.com
    ErrorLog "/var/log/httpd-albandrieu.com-error.log"
    CustomLog "/var/log/httpd-albandrieu.com-access.log" common

    ProxyPass /jenkins http://192.168.1.62:80/jenkins/ nocanon
    ProxyPassReverse /jenkins http://192.168.1.62:80/jenkins/
    ProxyRequests Off
    AllowEncodedSlashes NoDecode

</VirtualHost>

<VirtualHost *:80>
#<IfModule alias_module>
#    Redirect permanent / https://albandrieu.com/
#</IfModule>

ServerAdmin alban.andrieu@free.fr
#DocumentRoot "/usr/local/docs/dummy-host.example.com"
DocumentRoot "/usr/local/www/apache24/data/"
ServerName jenkins.albandrieu.com
ServerAlias www.jenkins.albandrieu.com
ErrorLog "/var/log/httpd-albandrieu.com-error.log"
CustomLog "/var/log/httpd-albandrieu.com-access.log" common

ProxyPass /jenkins http://192.168.1.62:80/jenkins/ nocanon
ProxyPassReverse /jenkins http://192.168.1.62:80/jenkins/
ProxyRequests Off
AllowEncodedSlashes NoDecode

</VirtualHost>

<VirtualHost *:443>
    SSLEngine On
    SSLCertificateFile "/usr/local/etc/letsencrypt/live/albandrieu.com-0001/cer.pem"/>
    SSLCertificateKeyFile "/usr/local/etc/letsencrypt/live/albandrieu.com-0001/privkey.pem">
.....

# For detailed information about these directives see
# <URL:http://httpd.apache.org/docs/2.4/mod/mod_proxy_html.html>
# and for mod_xml2enc see

BASE=administrativeMonitor/hudson.diagnosis.ReverseProxySetupMonitor
curl -iL -e http://jenkins.albandrieu.com/jenkins/manage \
            http://jenkins.albandrieu.com/jenkins/${BASE}/test

exit 0

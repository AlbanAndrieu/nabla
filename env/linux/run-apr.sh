#!/bin/bash
set -xv

#http://tomcat.apache.org/native-doc/

#On Ubuntu
#http://www.sheroz.com/pages/blog/installing-apache-tomcat-native-linux-ubuntu-1204.html

sudo apt-get install libtcnative-1
sudo apt-get install make
sudo apt-get install gcc

sudo apt-get install openssl
sudo apt-get install libssl-dev

cd /workspace
sudo wget http://apache.mirrors.ovh.net/ftp.apache.org/dist//apr/apr-1.5.2.tar.gz
sudo tar -xzf apr-1.5.2.tar.gz
cd apr-1.5.2
sudo  ./configure
sudo make

ll /usr/local/apr/lib/libapr-1.a

cd /workspace
sudo wget http://wwwftp.ciril.fr/pub/apache/tomcat/tomcat-connectors/native/1.1.34/source/tomcat-native-1.1.34-src.tar.gz
sudo tar -xzf tomcat-native-1.1.34-src.tar.gz
cd tomcat-native-1.1.34-src/jni/native/
echo $JAVA_HOME
sudo ./configure --with-apr=/usr/local/apr --with-java-home=$JAVA_HOME
sudo make
sudo make install

ll /usr/local/apr/lib
ll /usr/local/apr/lib/libtcnative-1.so.0.1.34

sudo nano $CATALINA_HOME/bin/setenv.sh
export LD_LIBRARY_PATH='$LD_LIBRARY_PATH:/usr/local/apr/lib'

sudo nano /etc/tomcat7/server.xml
#uncomment
<Listener className="org.apache.catalina.core.AprLifecycleListener" SSLEngine="on" />

sudo service tomcat7 restart

grep APR /var/log/tomcat7/catalina.out
INFO: Loaded APR based Apache Tomcat Native library 1.1.34 using APR version 1.5.2.
INFO: APR capabilities: IPv6 [true], sendfile [true], accept filters [false], random [true].

--------------- ZONE ----------------

sudo mv /etc/resolv.conf-template /etc/resolv.conf
sudo mv /etc/nsswitch.dns /etc/nsswitch.conf

wget http://wwwftp.ciril.fr/pub/apache/tomcat/tomcat-connectors/native/1.1.34/source/tomcat-native-1.1.34-src.tar.gz

export JAVA_HOME=/thomsonreuters/java/jdk
export CATALINA_HOME=/thomsonreuters/home/kgr/dist/3rdparty/J2EE/tomcat_dist
#export CATALINA_BASE=/thomsonreuters/home/kgr/data/J2EE/TomcatConfigs/

export TAR=/usr/sfw/bin/gtar
${TAR} xzfv
cd /thomsonreuters/home/kgr/tomcat-native-1.1.34-src/native
#/usr/local/apache2/bin/apr-1-config

CFLAGS='-DSSL_ENGINE'

#export PATH=/usr/local/bin:$PATH
export PATH=/thomsonreuters/sybase/kgr/ASE-15_0/jobscheduler/bin:/thomsonreuters/sybase/kgr/ASE-15_0/bin:/thomsonreuters/sybase/kgr/ASE-15_0/install:/thomsonreuters/sybase/kgr/ASEP/bin:/thomsonreuters/sybase/kgr/DBISQL/bin:/thomsonreuters/sybase/kgr/UAF-2_5/bin:/thomsonreuters/sybase/kgr/OCS-15_0/bin:/thomsonreuters/java/jdk/bin:/usr/sbin:/usr/bin:/usr/ccs/bin:/usr/sfw/bin:/usr/ucb:/usr/openwin/bin:/opt/sfw/bin:/thomsonreuters/rvd/tibrv/dist/bin:/thomsonreuters/ems/ems/bin:/thomsonreuters/home/kgr/dist/etc

#./configure --with-apr=/usr/apache2/bin/apr-config \
#            --with-java-home=$JAVA_HOME \
#            --with-ssl=yes \
#            --prefix=$CATALINA_HOME

./configure --with-apr=/usr/local/apache2/bin/apr-1-config \
            --with-java-home=$JAVA_HOME \
            --with-ssl=yes \
            --prefix=$CATALINA_HOME

#./configure --with-apr=/usr/local/apache2/bin/apr-1-config \
#            --with-java-home=/thomsonreuters/java/jdk \
#            --with-ssl=/usr/sfw \
#            --prefix=/thomsonreuters/home/kgr/dist/3rdparty/J2EE/tomcat_dist

cd /thomsonreuters/home/kgr/tomcat-native-1.2.5-src/native
./configure --with-apr=/usr/local/apache2/bin/apr-1-config \
            --with-java-home=$JAVA_HOME \
            --with-ssl=/usr/local/ssl/bin/ \
            --prefix=$CATALINA_HOME

echo "Making using GNU compiler"
gmake

echo "Installing using GNU compiler"
gmake install

#export PATH=$(getconf PATH)
#PATH=/usr/sfw/bin:/opt/SUNWspro/bin:/usr/bin:/usr/ccs/bin:/usr/dt/bin:/usr/openwin/bin:/usr/sbin; export PATH

#http://www.par.univie.ac.at/solaris/pca/installation.html
wget http://www.par.univie.ac.at/solaris/pca/stable/pca
chmod +x pca
./pca --man
pca -l all

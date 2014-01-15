#gearman.org/getting-started/
#NOT up to date sudo apt-get install gearman-job-server

#check ubuntu version
lsb_release -a
sudo apt-get update

#install gearman
sudo apt-get install gearman-job-server gearman-tools

# start gearman
gearmand -d &

# check gearmand running 
ps auxw | grep [g]earmand

# check germand listening for jobs on tcp port 4730
sudo lsof -i tcp:4730

#sudo nmap -p 4730 192.168.0.0-255

#sudo apt-get -f install libboost-all-dev
sudo apt-get install libboost-dev
#sudo apt-get install bjam

sudo apt-get install gperf
sudo apt-get install libevent-dev
sudo apt-get install memcached
sudo apt-get install libmemcached-dev
sudo apt-get install sqlite3
sudo apt-get install mysql-server mysql-client
sudo apt-get install cloog-ppl
sudo apt-get install mpi-default-bin mpi-default-dev 
sudo apt-get install povray
sudo apt-cache search libuuid
#sudo apt-get install libuuid1
sudo apt-get install uuid-dev

cd /workspace
sudo wget https://launchpad.net/gearmand/1.2/1.1.11/+download/gearmand-1.1.11.tar.gz
sudo tar xzf gearmand-1.1.11.tar.gz
sudo ln -s gearmand-1.1.11 gearmand
cd gearmand-1.1.11
sudo ./configure
sudo make
sudo make install

#https://wiki.jenkins-ci.org/display/JENKINS/Gearman+Plugin

sudo apt-get install php5-dev 
sudo apt-get install libgearman-dev

wget http://pecl.php.net/package/gearman
cd /workspace
tar xzf gearman-1.1.2.tgz
cd gearman-1.1.2
phpize
./configure
sudo make
sudo make install

#http://rripado.info/gearmanui/

ll /var/run/gearman/gearmand.pid
ll /var/log/gearman-job-server/gearman.log

#configure
nano /etc/default/gearman-job-server
#PARAMS="--listen=127.0.0.1"
#Put the true IP
PARAMS="--listen=150.151.160.25"

sudo service gearman-job-server status
sudo service gearman-job-server start

#??? /usr/sbin/gearmand -p 4730 -vvvv -u gearman 

#Inside Jenkins plugins
Gearman Server Host
150.151.160.25

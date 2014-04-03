#disable rhnplugin
# grep enable /etc/yum/pluginconf.d/rhnplugin.conf 
enabled = 0
#enabled = 1

#or disable by hand
yum search python26 --disableplugin=rhnplugin
#yum search python27 --disableplugin=rhnplugin
#Not available on RH 5
wget https://www.python.org/ftp/python/2.7.3/Python-2.7.3.tgz --no-check-certificate # Download
tar xvfz Python-2.7.3.tgz # unzip
cd Python-2.7.3 # go into directory
./configure
make # build
su # or 'sudo su' if there is no root user
make altinstall
#make install #do not do it 

ln -s /usr/local/bin/python2.7 /usr/bin/python2.7

ls -lrta /usr/local/bin/python2.7

rm /root/Python-2.7.3

#might need todo yum remove mercurial
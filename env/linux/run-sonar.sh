#http://docs.codehaus.org/display/SONAR/Installing+Sonar

#http://docs.codehaus.org/display/SONAR/Running+Sonar+as+a+Service+on+Linux

sudo ln -s /workspace/sonar-3.3/bin/linux-x86-32/sonar.sh /usr/bin/sonar
cd /etc/init.d
sudo chmod 755 /etc/init.d/sonar
sudo update-rc.d sonar defaults

sudo gedit /workspace/sonar-3.3/conf/sonar.properties

/workspace/sonar-3.3/bin/linux-x86-64/sonar.sh start

#You can now browse to http://localhost:9000.

#http://docs.codehaus.org/display/SONAR/Installing+and+Configuring+Sonar+Runner
#check runner is in the path
sonar-runner -h

user/pass admin/microsoft Alban Andrieu/...

sudo update-rc.d -f sonar remove
sudo update-rc.d sonar defaults 35 65
ls -l /etc/rc?.d/*sonar

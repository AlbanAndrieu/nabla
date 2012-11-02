#http://docs.codehaus.org/display/SONAR/Installing+Sonar

#http://docs.codehaus.org/display/SONAR/Running+Sonar+as+a+Service+on+Linux

sudo ln -s /workspace/sonar-3.3/bin/linux-x86-64/sonar.sh /usr/bin/sonar
sudo chmod 755 /etc/init.d/sonar
sudo update-rc.d sonar defaults

./sonar-3.3/bin/linux-x86-64/sonar.sh start


#You can now browse to http://localhost:9000.

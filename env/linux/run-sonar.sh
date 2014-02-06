#http://docs.codehaus.org/display/SONAR/Installing+Sonar

#http://docs.codehaus.org/display/SONAR/Running+Sonar+as+a+Service+on+Linux

sudo wget http://dist.sonar.codehaus.org/sonarqube-4.0.zip
#unzip sonarqube-4.0.zip -d sonar-4.0
unzip sonarqube-4.0.zip

sudo ln -s /workspace/sonar-3.3/bin/linux-x86-32/sonar.sh /usr/bin/sonar
cd /etc/init.d
sudo chmod 755 /etc/init.d/sonar
sudo update-rc.d sonar defaults

sudo gedit /workspace/sonar/conf/sonar.properties
sonar.jdbc.url=jdbc:mysql://localhost:3306/sonar?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true
sudo gedit /workspace/sonar/conf/wrapper.conf

Copy the OLD_SONARQUBE_HOME/extensions/plugins directory into NEW_SONARQUBE_HOME/extensions/plugins (replace plugins with compatible versions if necessary)
cp sonar-3.7/extensions/plugins/ sonar/extensions/plugins
cp sonar-3.7/extensions/jdbc-driver/ sonar/extensions/jdbc-driver
If a custom JDBC driver is used, copy it into NEW_SONARQUBE_HOME/extensions/jdbc-driver/<dialect>

/workspace/sonar/bin/linux-x86-32/sonar.sh start

#You can now browse to http://localhost:9000 or http://localhost:9000/setup

#http://docs.codehaus.org/display/SONAR/Installing+and+Configuring+Sonar+Runner
#check runner is in the path
sonar-runner -h

user/pass admin/microsoft Alban Andrieu/...

sudo update-rc.d -f sonar remove
sudo update-rc.d sonar defaults 35 65
ls -l /etc/rc?.d/*sonar

#http://docs.codehaus.org/display/SONAR/Pitest
wget http://repository.codehaus.org/org/codehaus/sonar-plugins/sonar-pitest-plugin/0.2/sonar-pitest-plugin-0.2.jar
cd /workspace/sonar/extensions/plugins
sudo mv /workspace/sonar-pitest-plugin-0.2.jar /workspace/sonar/extensions/plugins

#Sonargraph
/jenkins/.hello2morrow/SonargraphArchitect/SonargraphArchitect.license

mvn -Dsonargraph.prepareForSonar=true -Dsonargraph.license=<license-path> (or -Dsonargraph.activationCode=<activation code>) com.hello2morrow.sonargraph:maven-sonargraph-plugin:7.1.10:architect-report
mvn -Dsonargraph.prepareForSonar=true -Dsonargraph.activationCode=2356-F3B2-E2C6-CC70 com.hello2morrow.sonargraph:maven-sonargraph-plugin:7.1.10:architect-report -Psample -Ddatabase=derby
mvn sonar:sonar
For Sonargraph-Quality you would use:
mvn -Dsonargraph.prepareForSonar=true -Dsonargraph.license=<license-path> (or -Dsonargraph.activationCode=<activation code>) com.hello2morrow.sonargraph:maven-sonargraph-plugin:7.1.10:quality-report-direct-parsing-mode
    
#NOK in Jenkins mvn -Dsonarj.prepareForSonar=true -Dsonarj.license=<license-path> (or -Dsonarj.activationCode=<activation code>) com.hello2morrow.sonar:maven-sonarj-plugin:6.0.3:sonarj    
#NOK in Jenkins mvn -Dsonarj.prepareForSonar=true -Dsonarj.activationCode=2356-F3B2-E2C6-CC70 com.hello2morrow.sonar:maven-sonarj-plugin:6.0.3:sonarj    
    
#http://docs.codehaus.org/display/SONAR/Installing
#http://doc.ubuntu-fr.org/sonar

#http://docs.codehaus.org/display/SONAR/Running+SonarQube+as+a+Service+on+Linux

#sudo wget http://dist.sonar.codehaus.org/sonarqube-4.0.zip
sudo wget http://dist.sonar.codehaus.org/sonarqube-4.3.zip
#unzip sonarqube-4.0.zip -d sonar-4.0
unzip sonarqube-4.3.zip

ln -s sonarqube-4.3 sonar
sudo ln -s /workspace/sonar/bin/linux-x86-32/sonar.sh /usr/bin/sonar
cd /etc/init.d
sudo nano  /etc/init.d/sonar
------------------
#!/bin/sh
#
# rc file for SonarQube
#
# chkconfig: 345 96 10
# description: SonarQube system (www.sonarsource.org)
#
### BEGIN INIT INFO
# Provides: sonar
# Required-Start: $network
# Required-Stop: $network
# Default-Start: 3 4 5
# Default-Stop: 0 1 2 6
# Short-Description: SonarQube system (www.sonarsource.org)
# Description: SonarQube system (www.sonarsource.org)
### END INIT INFO
 
/usr/bin/sonar $*
--------------------
sudo chmod 755 /etc/init.d/sonar
sudo update-rc.d sonar defaults

sudo gedit /workspace/sonar/conf/sonar.properties
sonar.jdbc.url=jdbc:mysql://localhost:3306/sonar?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true
sudo gedit /workspace/sonar/conf/wrapper.conf

Copy the OLD_SONARQUBE_HOME/extensions/plugins directory into NEW_SONARQUBE_HOME/extensions/plugins (replace plugins with compatible versions if necessary)
sudo cp sonar/extensions/plugins/* sonar/extensions/plugins/
#sudo cp sonar/extensions/jdbc-driver/ sonar/extensions/jdbc-driver
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
    
#Caused by: java.lang.IllegalArgumentException: Parameter 'directory' is not a directory    
#Please keep in mind that if you are using a NABLA compilation WITHOUT a mutation test 
#and you're using a Sonar WITH mutation test ... job will fail 
#I've switched a NABLA project on Sonar page to another profile 
#without mutation tests
#there is only one difference between this and CommonProfile <http://home.nabla.mobi:9000/rules_configuration/index/9>  
#
#Config rule called: Survived mutant <http://home.nabla.mobi:9000/rules_configuration/index/9?sort_by=SORT_BY_RULE_NAME&searchtext=mutant&rule_activation=ACTIVE&commit=Search#>  
#This rule "is supposing" that in the build process there will be a "special" directory for mutation tests
#this is why build has been failing

#Issue http://sonarqube.15.x6.nabble.com/Cannot-use-PMD-or-Checkstyle-td3214270.html
#Deactivate rules
#PMD 
#XPath rule template

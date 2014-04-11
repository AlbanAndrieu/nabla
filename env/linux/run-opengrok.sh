#https://github.com/OpenGrok/OpenGrok/wiki/How-to-install-OpenGrok

cd /workspace

sudo wget http://java.net/projects/opengrok/downloads/download/opengrok-0.11.1.tar.gz
sudo tar -xvf sudo tar -xvf opengrok-0.11.1.tar.gz
sudo ln -s opengrok-0.11.1 opengrok
cd opengrok
sudo mkdir data src

cd /var/lib/
sudo ln -s /workspace/opengrok opengrok
sudo mkdir /var/log/opengrok

sudo gedit bin/run.sh

sudo mkdir source
cd source
sudo unzip /workspace/opengrok/lib/source.war

sudo gedit WEB-INF/web.xml
change
/var/opengrok/etc/configuration.xml
by
/var/lib/opengrok/configuration.xml

sudo chown -R tomcat7:tomcat7 opengrok-0.11.1

export OPENGROK_TOMCAT_BASE=$TOMCAT_HOME
cd /workspace/opengrok/bin
./OpenGrok deploy
#http://192.168.0.29:8280/
cd /workspace/opengrok/source
sudo zip -r source.war ./
mv source.war /var/lib/tomcat7/webapps
cd /var/lib/tomcat7/webapps
sudo chown tomcat7:tomcat7 source.war
#ll /var/lib/tomcat7
#$TOMCAT_HOME

./OpenGrok index /workspace/users/albandri10
java -Xmx1524m -jar opengrok.jar -W /var/opengrok/etc/configuration.xml -P -S -v -s /workspace/users/albandri10  -d /workspace/opengrok/data

 more /var/opengrok/etc/configuration.xml

grant codeBase "file:${catalina.base}/webapps/source/" {
  permission java.security.AllPermission;
};
grant codeBase "file:${catalina.base}/webapps/source/WEB-INF/lib/" {
  permission java.security.AllPermission;
};

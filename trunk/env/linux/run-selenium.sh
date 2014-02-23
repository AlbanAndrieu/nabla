#http://alex.nederlof.com/blog/2012/11/19/installing-selenium-with-jenkins-on-ubuntu/

sudo apt-get update && sudo apt-get install -y xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic xvfb x11-apps imagemagick firefox

cd /etc/init.d
ln -s /workspace/users/albandri10/env/linux/bin/xvfb.sh xvfb
sudo update-rc.d xvfb defaults

http://home.nabla.mobi:4444/wd/hub
http://home.nabla.mobi:4444/grid/console

#add xvfb in jenkins
#DISPLAY
#:99
#use : 0.0 without xvfb

cd /workspace
/workspace/selenium-server-standalone-2.39.0.jar
#NOK wget http://chromedriver.storage.googleapis.com/2.8/chromedriver_linux64.zip
#NOK unzip chromedriver_linux64.zip -d chrome-driver

wget http://selenium.googlecode.com/files/selenium-server-standalone-2.39.0.jar
#or /var/lib/jenkins/selenium-server-standalone-2.29.0.jar

sudo apt-get install chromium-chromedriver
/var/lib/
ln -s /usr/lib/chromium-browser/chromedriver /var/lib/chromedriver
ls /var/lib/chromedriver
sudo mkdir selenium
cd /var/lib/selenium
ln -s /workspace/selenium-server-standalone-2.39.0.jar selenium.jar
ls /var/lib/selenium/selenium.jar

# Now we have to set the DISPLAY env variable so Firefox and Chrome know where to open the browser.
export DISPLAY=:99

netstat -an | grep 6666
sudo lsof -i :6666
curl http://home.nabla.mobi:6666/selenium-server/driver/?cmd=shutDownSeleniumServer

#Start server 
cd ~/servers/sample/jsf-simple
mvn jetty:run-war -Psample -Dserver=jetty9x -Ddatabase=derby -Djetty.port=9090

# Let's see if Selenium works for firefox:
sudo chown -R jenkins:jenkins /workspace/users/albandri10/.mozilla/firefox/eaadg7zv.Jenkins
java -jar /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *firefox http://localhost:9090/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/firefox-results.html"
#java -jar /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *firefox http://localhost:8280/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/firefox-results.html" -log=/tmp/selenium.log -debug=true -firefoxProfileTemplate /workspace/users/albandri10/.mozilla/firefox/gr8mkk7y.Selenium/ 
java -jar /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *firefox http://localhost:8280/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/firefox-results.html" -log=/tmp/selenium.log -debug=true -firefoxProfileTemplate /workspace/users/albandri10/.mozilla/firefox/eaadg7zv.Jenkins/
java -jar /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *chrome http://localhost:8280/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/chrome-results.html" -log=/tmp/selenium.log -debug=true
  
# For chrome we also need to specify the Chrome driver location.:
java -jar -Dwebdriver.chrome.driver=/var/lib/chromedriver /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *googlechrome http://localhost:9090/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/chrome-results.html"

#add properties in surefire
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-surefire-plugin</artifactId>
	<configuration>
		<systemPropertyVariables>
		        <webdriver.chrome.driver>${webdriver.chrome}</webdriver.chrome.driver>
		        <webdriver.safari.noinstall>true</webdriver.safari.noinstall>
		</systemPropertyVariables>
	</configuration>

-Dwebdriver.safari.noinstall=true -Dwebdriver.chrome.driver=/var/lib/chromedriver
#webdriver.safari.driver

#firefox profile
#http://stackoverflow.com/questions/7106994/jenkins-cant-launch-selenium-tests-timed-out-waiting-for-profile-to-be-created/7154404#7154404
firefox -P
#create profile Selenium

Open up Firefox profile manager : $ firefox -ProfileManager
Create a new profile, called Selenium
Now, when running the selenium command, add "-firefoxProfileTemplate "/home/{username}/.mozilla/firefox/{profile dir}" to the command. (where {username} is your username and {profile dir} is the profile directory, which for me was "6f2um01h.Selenium"


#NOK -Dwebdriver.chrome.driver=/var/lib/chromedriver -port 6666 -log=/tmp/selenium.log -debug=true -firefoxProfileTemplate /workspace/users/albandri10/.mozilla/firefox/gr8mkk7y.Selenium/ 
#-Dwebdriver.chrome.driver=/var/lib/chromedriver -port 6666 -log=/tmp/selenium.log -debug=true -firefoxProfileTemplate /workspace/users/albandri10/.mozilla/firefox/eaadg7zv.Jenkins/
#check following
#http://stackoverflow.com/questions/12588082/webdriver-unable-to-connect-to-host-127-0-0-1-on-port-7055-after-45000-ms

#http://www.mythoughts.co.in/2012/11/orgopenqaseleniumfirefoxnotconnectedexc.html#.Uu-cPz1dX08
#on Windows go to C:\WINDOWS\system32\drivers\etc
#comment the following
#127.0.0.1       localhost

### vi /etc/gdm/custom.conf
##[security]
##AllowRemoteRoot=true
##DisallowTCP=false
##
##[xdmcp]
##Enable=true
  
##xhost +

http://chromedriver.storage.googleapis.com/index.html  
  
selenium available browser  
*firefox
*mock
*firefoxproxy
*pifirefox
*chrome
*iexploreproxy
*iexplore
*firefox3
*safariproxy
*googlechrome
*konqueror
*firefox2
*safari
*piiexplore
*firefoxchrome
*opera
*iehta
*custom  
  
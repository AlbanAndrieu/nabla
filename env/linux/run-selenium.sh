#!/bin/bash
set -xv

#http://alex.nederlof.com/blog/2012/11/19/installing-selenium-with-jenkins-on-ubuntu/

sudo apt-get update && sudo apt-get install -y xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic xvfb x11-apps imagemagick firefox google-chrome-stable
sudo apt-get install x11-apps imagemagick

yum update -y \
&& yum install \
ipa-gothic-fonts xorg-x11-fonts-100dpi xorg-x11-fonts-75dpi xorg-x11-utils xorg-x11-fonts-cyrillicxorg-x11-fonts-Type1 xorg-x11-fonts-misc -y

pacman -S mingw-w64-x86_64-freetype
pacman -S mingw-w64-x86_64-SDL
pacman -S mingw-w64-x86_64-SDL_ttf # for ttf fonts support, optional

cd /etc/init.d
ln -s /workspace/users/albandri10/env/linux/bin/xvfb.sh xvfb
sudo update-rc.d xvfb defaults

http://home.nabla.mobi:4444/wd/hub
http://home.nabla.mobi:4444/grid/console

#add xvfb in jenkins
#DISPLAY
#:99
#use : 0.0 without xvfb

cd /usr/lib/chromium-browser/
#NOK sudo wget http://chromedriver.storage.googleapis.com/2.9/chromedriver_linux64.zip
#NOK sudo unzip chromedriver_linux64.zip
sudo wget http://chromedriver.storage.googleapis.com/2.16/chromedriver_linux32.zip
sudo unzip chromedriver_linux32.zip
sudo chmod 755 chromedriver
#wget http://selenium.googlecode.com/files/selenium-server-standalone-2.39.0.jar
#or /var/lib/jenkins/selenium-server-standalone-2.29.0.jar

#sudo apt-get install chromium-chromedriver
ls /var/lib/chromedriver
sudo mkdir selenium
sudo ln -s /workspace/selenium-server-standalone-3.0.1.jar selenium-server-standalone-3.0.1.jar
ls /var/lib/selenium/selenium.jar

# Now we have to set the DISPLAY env variable so Firefox and Chrome know where to open the browser.
export DISPLAY=:99

netstat -an | grep 6666
sudo lsof -i :6666
curl http://home.nabla.mobi:6666/selenium-server/driver/?cmd=shutDownSeleniumServer

#Start server
cd ~/servers/sample/jsf-simple
mvn jetty:run-war -Psample -Dserver=jetty9x -Ddatabase=derby -Djetty.port=9090

/usr/bin/Xvfb :1 -screen 0 1024x768x24
export DISPLAY=:1

#screenshot
xwd -root -display :99 | convert xwd:- capture.png

#firefox profile
#http://stackoverflow.com/questions/7106994/jenkins-cant-launch-selenium-tests-timed-out-waiting-for-profile-to-be-created/7154404#7154404
firefox -P
#create profile Selenium
sudo chmod -R 777 /workspace/users/albandri10/.mozilla

#Open up Firefox profile manager : $ firefox -ProfileManager
#Create a new profile, called Selenium
#Now, when running the selenium command, add "-firefoxProfileTemplate "/home/{username}/.mozilla/firefox/{profile dir}" to the command. (where {username} is your username and {profile dir} is the profile directory, which for me was "6f2um01h.Selenium"

#NOK -Dwebdriver.chrome.driver=/var/lib/chromedriver -port 6666 -log=/jenkins/selenium.log -debug=true -firefoxProfileTemplate /workspace/users/albandri10/.mozilla/firefox/lwc4dypx.Selenium/

# Let's see if Selenium works for firefox:
sudo chown -R jenkins:jenkins /workspace/users/albandri10/.mozilla/firefox/eaadg7zv.Jenkins



cd /workspace
#/workspace/selenium-server-standalone-2.39.0.jar
wget http://npm.taobao.org/mirrors/selenium/3.13/selenium-html-runner-3.13.0.jar
#See https://seleniumhq.github.io/docs/html-runner.html

wget https://github.com/mozilla/geckodriver/releases/download/v0.21.0/geckodriver-v0.21.0-linux64.tar.gz
tar -xvzf geckodriver-v0.*-linux64.tar.gz
#rm geckodriver-v0.*-linux64.tar.gz
chmod +x geckodriver
sudo cp geckodriver /usr/local/bin/

whereis geckodriver

sudo cp /usr/lib/chromium-browser/chromedriver /usr/local/bin/

whereis chromedriver

#BEFORE with selenium-server-standalone-2.52.0.jar
#
##java -jar /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *firefox http://localhost:9090/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/firefox-results.html"
#java -jar /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *firefox http://localhost:8280/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/firefox-results.html" -log=/jenkins/selenium.log -debug=true -firefoxProfileTemplate /workspace/users/albandri10/.mozilla/firefox/lwc4dypx.Selenium/
#
##java -jar /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *firefox http://localhost:8280/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/firefox-results.html" -log=/jenkins/selenium.log -debug=true -firefoxProfileTemplate /workspace/users/albandri10/.mozilla/firefox/4ppq46yo.Nabla/
##NOK java -jar /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *chrome /opt/google/chrome/chrome http://localhost:8280/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/chrome-results.html" -log=/jenkins/selenium.log -debug=true`
#java -jar /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *chrome http://localhost:8280/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/chrome-results.html" -log=/jenkins/selenium.log -debug=true
#java -jar /var/lib/selenium/selenium.jar -Dwebdriver.chrome.driver=/var/lib/chromedriver -port 6666 -log=/jenkins/selenium.log -debug=true -debug=true -firefoxProfileTemplate /workspace/users/albandri10/.mozilla/firefox/lwc4dypx.Selenium/ -htmlSuite *chrome http://localhost:8280/welcome/ /jenkins/jobs/nabla-servers-jsf-simple-seleniumhq/workspace/src/test/selenium/SimpleSTestSuite.html /jenkins/jobs/nabla-servers-jsf-simple-seleniumhq/workspace/target/test-reports/chrome-results.html
#
## For chrome we also need to specify the Chrome driver location.:
#java -jar -Dwebdriver.chrome.driver=/var/lib/chromedriver /var/lib/selenium/selenium.jar -port 6666 -htmlSuite *googlechrome http://localhost:9090/welcome "/workspace/users/albandri10/servers/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html" "/workspace/users/albandri10/servers/sample/jsf-simple/target/test-reports/chrome-results.html"
#java -jar /var/lib/selenium/selenium.jar -Dwebdriver.chrome.driver=/var/lib/chromedriver -port 6666 -timeout 600 -log=/jenkins/selenium.log -debug=true -htmlSuite *chrome http://home.nabla.mobi:8280/welcome/ /jenkins-slave/workspace/nabla-servers-jsf-simple-seleniumhq-nightly/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html /jenkins-slave/workspace/nabla-servers-jsf-simple-seleniumhq-nightly/sample/jsf-simple/target/test-reports/chrome-results.html

#AFTER with selenium-html-runner-3.13.0.jar
java -jar /workspace/selenium-html-runner-3.13.0.jar -timeout 600  -htmlSuite *firefox http://home.nabla.mobi:8280/welcome/ /jenkins-slave/workspace/nabla-servers-jsf-simple-seleniumhq-nightly/sample/jsf-simple/src/test/selenium/SimpleSTestSuite.html /jenkins-slave/workspace/nabla-servers-jsf-simple-seleniumhq-nightly/sample/jsf-simple/target/test-reports/chrome-results.html

browser
*googlechrome
*firefox

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

#PATH=${PATH}:/usr/lib/chromium-browser/libs

 -Dwebdriver.chrome.driver=/var/lib/chromedriver
 -Dwebdriver.chrome.driver="chromedriver"
 -Dwebdriver.chrome.driver=/opt/google/chrome/chrome

cd /jenkins/plugins/selenium/WEB-INF/lib
sudo ln -s /workspace/selenium-server-standalone-2.40.0.jar selenium-server-standalone-2.29.0.jar
cd /jenkins
sudo ln -s /workspace/selenium-server-standalone-2.40.0.jar selenium-server-standalone-2.29.0.jar

/usr/local/lib/node_modules/protractor/selenium/chromedriver

REM NOK webdriver-manager start

#browser version
/usr/bin/firefox  -V
/usr/lib/firefox/firefox -V
/usr/bin/chromium-browser --version
#chromium-browser might need to be removed
#for chrome
sudo apt-get install google-chrome-stable
/opt/google/chrome/chrome --version

#if issue :
#/opt/google/chrome/chrome: error while loading shared libraries: libudev.so.0: cannot open shared object file: No such file or directory
#sudo apt-get install libudev0:i386
sudo ln -sf /lib/i386-linux-gnu/libudev.so.1 /lib/i386-linux-gnu/libudev.so.0

#https://code.google.com/p/selenium/wiki/Grid2
java -jar /workspace/selenium-server-standalone-2.40.0.jar -role hub
#register node by hand
cd /usr/lib/chromium-browser/
java -jar /workspace/selenium-server-standalone-2.40.0.jar -role node -hub http://127.0.0.1:4444/wd/register -browser seleniumProtocol=WebDriver,browserName=firefox,version=28.0,firefox_binary/usr/bin/firefox,maxInstances=2,platform=LINUX -browser seleniumProtocol=WebDriver,browserName=chrome,version=33,firefox_binary=/usr/bin/chromium-browser,maxInstances=2,platform=LINUX
#result
See : http://home.nabla.mobi:4444/grid/console
See : http://home.nabla.mobi:6666/grid/console

#In order to fic issue:
#error while loading shared libraries: libui_base.so: cannot open shared object file
#http://stackoverflow.com/questions/25695299/chromedriver-on-ubuntu-14-04-error-while-loading-shared-libraries-libui-base
sudo nano /etc/ld.so.conf.d/chrome_lib.conf
/usr/lib/chromium-browser/libs
sudo ldconfig

#In order to fix issue:
#ubuntu firefox is already running error
cd ~/.mozilla
find . -name '.parentlock' -exec rm {} \;

#start by hand
cd /jenkins
sudo ln -s /workspace/selenium-server-standalone-2.46.0.jar selenium-server-standalone-2.41.0.jar
java -jar /jenkins/selenium-server-standalone-2.46.0.jar -role hub -port 4444
export DISPLAY=localhost:99.0 && java -jar /jenkins/selenium-server-standalone-2.46.0.jar -role node -hub http://home.nabla.mobi:4444/wd/register -browser browserName=firefox,version=38.0,firefox_binary=/usr/bin/firefox,maxInstances=1,platform=LINUX -browser browserName=chrome,version=39.0.2171.95,chrome_binary=/opt/google/chrome/chrome,maxInstances=1,platform=LINUX

http://home.nabla.mobi:4444/grid/console
http://home.nabla.mobi:5555/wd/hub/static/resource/hub.html

cd /usr/local/lib
#from http://www.seleniumhq.org/download/
wget https://goo.gl/Br1P0Z selenium-html-runner-3.0.1.jar
sudo ln -s selenium-html-runner-3.0.1.jar selenium-server-standalone.jar

#See docker https://github.com/SeleniumHQ/docker-selenium
sudo docker run -d -p 4444:4444 -e SE_OPTS="-debug true" --name selenium-hub selenium/hub:3.8.1-aluminum
sudo docker run -d --link selenium-hub:hub selenium/node-chrome:3.8.1-aluminum
sudo docker run -d --link selenium-hub:hub selenium/node-firefox:3.8.1-aluminum

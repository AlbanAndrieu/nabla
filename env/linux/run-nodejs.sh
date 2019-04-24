#!/bin/bash
set -xv

sudo apt-get install gcc cpp g++ automake1.9 autoconf libtool flex bison python-software-properties

#On Ubuntu 14 node must be uninstall
sudo apt-get --purge remove node
ll /usr/sbin/node
/bin/ls: cannot access /usr/sbin/node: No such file or directory
sudo apt-get install nodejs
#NOK with ubuntu 13 sudo apt-get install npm
#as root
curl -L https://www.npmjs.com/install.sh | sh
sudo apt-get install karma-tools

#http://ariejan.net/2011/10/24/installing-node-js-and-npm-on-ubuntu-debian/
#http://zagorskis.com/2013/12/install-node-js-karma-grunt-and-bower-on-lubuntu/
#http://stackoverflow.com/questions/13527889/global-installation-of-grunt-js-fails
npm config ls -l | grep config
npm config set prefix /usr/local
npm config get prefix
#npm config set prefix ~/npm
#echo "export NODE_PATH=$NODE_PATH:/home/$USER/npm/lib/node_modules" >> ~/.bashrc && source ~/.bashrc
#export NODE_PATH=/usr/lib/nodejs:/usr/lib/node_modules:/usr/share/javascript:/home/root/npm/lib/node_modules:/root/npm/lib/node_modules:/usr/local/lib/node_modules
export NODE_PATH=/usr/lib/nodejs:/usr/lib/node_modules:/usr/share/javascript:/usr/local/lib/node_modules

sudo add-apt-repository -y ppa:chris-lea/node.js;
sudo apt-get update

#http://www.rosehosting.com/blog/how-to-install-the-latest-versions-of-node-js-and-bower-on-ubuntu-13-10/

#as root
#build it yourself
cd /usr/local/src
wget http://nodejs.org/dist/node-latest.tar.gz
tar zxvf node-latest.tar.gz
cd node-v0.1*
./configure
make
sudo make install

echo $NODE_PATH
/usr/lib/nodejs:/usr/lib/node_modules:/usr/share/javascript

which node
/usr/bin/node
node --version
v0.10.37
which nodejs
/usr/bin/nodejs
nodejs --version
v0.10.37
npm --version
2.13.0

#sudo su - root
#sudo rm /usr/bin/node
#sudo ln -s /usr/bin/nodejs /usr/bin/node
#cd ~
##curl https://npmjs.org/install.sh > install.sh
#curl https://www.npmjs.org/install.sh > install.sh
#chmod 777 ./install.sh

#cd /usr/local/lib
#ln -s /usr/local/bin/node node
#ls -lrta /usr/local/bin/node
#ls -lrta /usr/local/lib/node

#cd ~
#./install.sh

#still as root user
npm install -g grunt
npm install -g grunt-cli
npm install -g bower
npm install -g protractor
npm install -g gulp

#as root user
npm install -g karma
#npm cache clean
npm install -g karma-junit-reporter
npm install -g karma-ng-scenario
npm install -g karma-ng-html2js-preprocessor
npm install -g karma-coverage
npm install -g karma-jasmine
#npm install -g phantomjs@2.1.1
npm install -g phantomjs-prebuilt
npm install -g karma-phantomjs-launcher
npm install -g selenium-webdriver
npm install -g grunt-contrib-compress
npm install -g angular
npm install -g node-gyp
npm install -g grunt-pagespeed-junit@0.3.1
#npm install -g slimerjs@0.9.2
#npm install -g sharp@0.18.4
#stack Error: EACCES: permission denied, mkdir '/usr/local/lib/node_modules/grunt-sitespeedio/node_modules/sleep/build'
#npm install -g grunt-sitespeedio@0.10.5
#npm install -g grunt-sitespeedio@3.1.0
npm install -g grunt-yslow-test@0.1.0
#if it failed try as non root user whitout -g option
npm install nsp --global

npm install -g doctor
npm install -g yo
#npm install selenium-standalone
npm install -g connect-livereload
npm install -g gm

#as local user
npm install grunt
npm install grunt-cli

#/usr/lib/node_modules/karma/bin/karma --version
#export PATH="$PATH:/usr/lib/node_modules/karma/bin"

#or
cd /usr/local/bin/
#Ubuntu 13
ln -s /usr/local/lib/node_modules/karma/bin/karma /usr/local/bin/karma
#ln -s /root/npm/lib/node_modules/karma/bin/karma /usr/local/bin/karma
#Ubuntu 12 ln -s /usr/lib/node_modules/karma/bin/karma /usr/local/bin/karma
sudo chmod -R 777 /usr/local/lib/node_modules/

#check it is working
karma --version
Karma version: 0.10.9

#start karma test by hand
karma start karma-ri-header.conf.js
grunt karma:riHeader​

#Ubuntu 13
#ln -s /usr/local/lib/node_modules/grunt-cli/bin/grunt /usr/local/bin/grunt

#check it is working
grunt --version
grunt-cli v0.1.13

bower --version
1.2.8

#as root
webdriver-manager update

#sudo chown -R yourusername ~/.npm
#check npm repository
npm -g ls

#add nabla repository
#see https://github.com/georgy/nexus-npm-repository-plugin
#inside nexus use http://registry.npmjs.org/ without the s
#as jenkins and albandri user
npm config set registry http://home.nabla.mobi:8081/nexus/content/npm/registry.npmjs.org/
#npm config set registry https://registry.npmjs.org/
npm config ls -l | grep registry

#http://karma-runner.github.io/0.10/index.html
#http://yeoman.io/
npm install -g grunt bower yo generator-karma generator-angular
#launch yo
yo
npm install --save grunt-google-cdn

#fix issue
#axconfig: port 1 not active
sudo apt-get remove node
sudo apt-get remove --purge node
sudo apt-get autoremove

#git clone --depth=14 https://github.com/angular/angular-phonecat.git
npm install
npm start : start a local development web-server
npm test : start the Karma unit test runner
npm run protractor : run the Protractor end 2 end tests
npm run update-webdriver : install the drivers needed by Protractor

#Install private bower
#https://github.com/Hacklone/private-bower/blob/master/README.md
npm install -g private-bower
ll /usr/local/bin/private-bower
ll /usr/local/lib/node_modules/private-bower
#start
sudo private-bower
http://localhost:5678/
http://localhost:5678/packages

#npm adduser --registry http://localhost:5678/
#admin/micro/alban.andrieu@free.f

bower register [packageName] [gitRepo]
bower register sample-component ssh://git@scm-git-eur.misys.global.ad:7999/risk/bower-fr-sample-component.git

#Install bower-registry
#Install redis
#http://redis.io/topics/quickstart
sudo apt-get install redis-server
#check it is working
redis-cli ping
npm install -g bower-registry
#start
bower-registry -d redis
bower-registry -p 8089 -d redis -o '{"port": 6379, "host": "127.0.0.1"}' -P
curl http://localhost:8089/packages
#find package jquery
curl http://localhost:8089/packages/jquery
http://localhost:8089/
#install bower-registry-client
npm install --save bower-registry-client

#bower cache
bower cache list
bower cache clean
bower ls angular

#build a project
npm install
#then
#grunt task
grunt build
grunt karma:unit
grunt documentation
grunt protractor:e2e

#bower register test https://github/scm/risk/ui-components.git
#for bower registry
curl -X DELETE "http://localhost:5678/packages/test?access_token=password"
#for bower private
curl -X POST http://localhost:5678/removePackage -d '{"name":"test"}' -H "Content-Type: application/json" --header "Auth-Key:123456"

ll ~/.m2/bowerRepository.json
ll ~/.m2/bowerRepositoryPublic.json

#Upgrade
#https://github.com/karma-runner/karma-jasmine
npm install karma-jasmine@2_0 --save-dev
npm install jasmine-core --save-dev
#https://github.com/larrymyers/jasmine-reporters
npm install --save-dev jasmine-reporters@^2.0.0
npm install grunt-postcss pixrem autoprefixer-core cssnano --save-dev
#npm install autoprefixer-core --save-dev

#Cache added in http://home.nabla.mobi/html/download/
cd /var/www/html/download
cd nodejs/v0.12.4

#get LTS stable version
npm view npm dist-tags
#npm install -g npm@2.13.0

#Upgrade npm
sudo npm install npm@latest -g
#Upgrade mnodejs
sudo npm cache clean -f
sudo npm install -g n
sudo n stable

#install compass
#sudo apt-get install ruby-full rubygems1.8
sudo apt-get install rubygems
sudo apt install ruby-compass
#sudo gem install sass
#sudo gem install compass

sudo apt-get install coffeescript
coffee --version

sudo apt-get install google-chrome-stable
sudo apt-get install chromium-browser

#upgrade /usr/local/lib/node_modules/protractor/selenium/chromedriver_2.15.zip
sudo webdriver-manager update
sudo /usr/local/lib/node_modules/protractor/selenium/chromedriver --version
ll /usr/local/lib/node_modules/protractor/selenium/selenium-server-standalone-2.45.0.jar

/usr/bin/google-chrome --version
/usr/bin/chromium-browser --version

#For chrome Secure Shell extensionupda
sudo su - root
npm install -g devtools-terminal
devtools-terminal --install --id=leakmhneaibbdapdoienlkifomjceknl

# Upgrade package
npm outdated
npm update

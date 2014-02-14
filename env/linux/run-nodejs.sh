sudo apt-get install gcc cpp g++ automake1.9 autoconf libtool flex bison python-software-properties

#sudo apt-get install node 
sudo apt-get install nodejs
#NOK with ubuntu 13 sudo apt-get install npm
sudo apt-get install karma-tools

#http://ariejan.net/2011/10/24/installing-node-js-and-npm-on-ubuntu-debian/
#http://zagorskis.com/2013/12/install-node-js-karma-grunt-and-bower-on-lubuntu/
#http://stackoverflow.com/questions/13527889/global-installation-of-grunt-js-fails
npm config ls -l | grep config

sudo add-apt-repository -y ppa:chris-lea/node.js;
sudo apt-get update

#http://www.rosehosting.com/blog/how-to-install-the-latest-versions-of-node-js-and-bower-on-ubuntu-13-10/

#as root
cd /usr/local/src
wget http://nodejs.org/dist/node-latest.tar.gz
tar zxvf node-latest.tar.gz
cd node-v0.1*
./configure
make
sudo make install

node --version
v0.10.25
nodejs --version
v0.10.25        
npm --version
1.3.24

#sudo su - root
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

npm config get prefix
#npm config set prefix ~/npm
#echo "export NODE_PATH=$NODE_PATH:/home/$USER/npm/lib/node_modules" >> ~/.bashrc && source ~/.bashrc

#still as root user
#NOK npm install -g doctor
#NOK npm install -g yo
npm install -g grunt
npm install -g grunt-cli
npm install -g bower
npm install -g protractor

#as root user 
npm install -g karma
#npm cache clean
npm install -g karma-junit-reporter
npm install -g karma-ng-scenario
npm install -g karma-ng-html2js-preprocessor
npm install -g karma-coverage
#if it failed try as non root user whitout -g option

#check it is working
karma --version
Karma version: 0.10.9

#sudo chown -R yourusername ~/.npm
#check npm repository
npm -g ls

#http://karma-runner.github.io/0.10/index.html
#http://yeoman.io/

#npm install -g yo karma protractor
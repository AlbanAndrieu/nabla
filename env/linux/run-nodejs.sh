sudo apt-get install node 
sudo apt-get install nodejs
sudo apt-get install npm
sudo apt-get install karma-tools

#http://ariejan.net/2011/10/24/installing-node-js-and-npm-on-ubuntu-debian/
#http://zagorskis.com/2013/12/install-node-js-karma-grunt-and-bower-on-lubuntu/
#http://stackoverflow.com/questions/13527889/global-installation-of-grunt-js-fails
npm config ls -l | grep config

sudo add-apt-repository -y ppa:chris-lea/node.js;
sudo apt-get update

sudo su - root
cd ~
#curl http://npmjs.org/install.sh | sh;
curl https://npmjs.org/install.sh > install.sh
chmod 777 ./install.sh

cd /usr/local/lib
ln -s /usr/local/bin/node node
ls -lrta /usr/local/bin/node
ls -lrta /usr/local/lib/node

cd ~
./install.sh

npm install -g grunt;
npm install -g grunt-cli;
npm install -g bower;

npm install -g karma
npm install -g karma-junit-reporter
npm install -g karma-ng-scenario
npm install -g karma-ng-html2js-preprocessor
npm install -g karma-coverage

sudo chown -R yourusername ~/.npm
npm -g ls

#check it is working
karma --version
#!/bin/bash
set -xv

#On Ubuntu 14.04
sudo apt-get --purge remove node
sudo apt-get --purge remove nodejs

/usr/bin/nodejs --version
/usr/local/bin/node --version

sudo rm -rf /usr/local/{lib/node{,/.npm,_modules},bin,share/man}/{npm*,node*,man1/node*}

#On Ubuntu 16.04 (you can reinstall it (but I would use Upgrade node in run-nodejs.sh instead)
sudo apt-get install nodejs

/usr/bin/nodejs --version

echo $NODE_PATH

ll /usr/bin/node
sudo rm /usr/bin/node
sudo ln -s /usr/local/n/versions/node/7.8.0/bin/node /usr/bin/node

sudo npm remove  -g node-gyp
sudo npm install -g node-gyp@2.0.2
node-gyp --version
#v2.0.2
#sudo npm install -g gyp

node_modules/node-gyp/bin/node-gyp.js --version
./node/npm/bin/node-gyp-bin/node-gyp --version
#v2.0.1
node-gyp rebuild

--------------------------------------------------------------------

#sudo apt-get install nodejs npm
#Node updater
#sudo npm cache clean -f
#sudo npm install -g n
#sudo n stable
#/usr/local/n/versions/node/6.4.0
#/usr/bin/node --version
#Switch to new version
#sudo ln -sf /usr/local/n/versions/node/6.4.0/ /usr/bin/node
#

#Upgrade node
#http://stackoverflow.com/questions/8191459/how-to-update-node-js
#as root
npm cache clean -f
npm install -g n
#n stable
n 8.9.4
node -v
/usr/local/bin/node -v

#update clean up npm repo
#sudo chown -R albandri:albandri  ~/.npm
npm cache clear
#update npm
npm update

#show which dependencies is using connect
npm ls connect
#Upgrade npm
#npm install -g npm
npm install -g npm@5.5.1

#publish to https://www.npmjs.com/
npm whoami
#npm adduser --registry=https://www.npmjs.com/
npm adduser
#albanandrieu
npm login

npm config ls

#API : http://npm.nabla.mobi:8080/
#GUI : https://www.npmjs.com/~albanandrieu

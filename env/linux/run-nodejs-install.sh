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

git clone https://github.com/bsuh/node_xslt.git
cd node_xslt

grep parallel /usr/lib/node_modules/npm/node_modules/node-gyp/lib/configure.js
grep parallel /usr/lib/node_modules/node-gyp/lib/configure.js
#in workspace
find . -name 'configure.js' | xargs grep parallel
#comment parallel

#export NODE_PATH=$NODE_PATH:${WORKSPACE}/lib/node_modules
export NODE_PATH=$NODE_PATH:./lib/node_modules
#export PATH=./:./node/:/workspace/users/albandri10/.linuxbrew/bin:/workspace/users/albandri10/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games
export PATH=./:./node:$PATH
#./ is needed for grunt yslow_test that require phantomjs

node_modules/node-gyp/bin/node-gyp.js --version
./node/npm/bin/node-gyp-bin/node-gyp --version
#v2.0.1
node-gyp rebuild

--------------------------------------------------------------------

# Note the new setup script name for Node.js v0.12
#curl -sL https://deb.nodesource.com/setup_0.12 | sudo bash -
curl -sL https://deb.nodesource.com/setup_4.x | sudo -E bash -

# Then install with:
sudo apt-get install -y nodejs

#if you have such issue after npm -version
#bash: /usr/local/bin/npm: No such file or directory
hash -r
npm -version
2.11.3
/usr/bin/node  --version

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

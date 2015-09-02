/usr/bin/nodejs --version

sudo apt-get --purge remove node
sudo apt-get --purge remove nodejs

/usr/bin/nodejs --version

/usr/local/bin/node --version

sudo rm -rf /usr/local/{lib/node{,/.npm,_modules},bin,share/man}/{npm*,node*,man1/node*}

sudo apt-get install nodejs

/usr/bin/nodejs --version

sudo npm remove  -g node-gyp
sudo npm install -g node-gyp@2.0.2
node-gyp --version
#v1.0.2
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
curl -sL https://deb.nodesource.com/setup_0.12 | sudo bash -

# Then install with:
sudo apt-get install -y nodejs

npm -version
2.11.3
/usr/bin/node  --version


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

#bower register test https://scm-git-eur.misys.global.ad/scm/risk/ui-components.git
#for bower registry
curl -X DELETE "http://localhost:5678/packages/test?access_token=password"
#for bower private
curl -X POST http://localhost:5678/removePackage -d '{"name":"test"}' -H "Content-Type: application/json" --header "Auth-Key:123456"

ll ~/.m2/bowerRepository.json
ll ~/.m2/bowerRepositoryPublic.json

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

#log
less /service/private-bower/log/private-bower/current

#TODO start private-bower as daemontools
#http://cr.yp.to/daemontools.html
sudo apt-get install daemontools
cd /service/private-bower/
sudo /command/svstat .
.: up (pid 32259) 54601 seconds
#http://www.wolframalpha.com/input/?i=54601%20seconds%20ago

To read status:

cd /service

sudo /command/svstat *
$ sudo /command/svstat /service/private-bower/
/service/private-bower/: up (pid 21632) 1358 seconds

To stop:
sudo /command/svc –d /service/private-bower/

To start:
sudo /command/svc –u /service/private-bower/

To restart:
sudo /command/svc –t /service/private-bower/

#issue while refresh
#try workaround
cd /files/bower/private-bower/gitRepoCache/nabla-auth
git fetch --prune --tags

#for each repo
git config --local --list
git config http.sslVerify false

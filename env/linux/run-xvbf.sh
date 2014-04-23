#http://www.labelmedia.co.uk/blog/posts/setting-up-selenium-server-on-a-headless-jenkins-ci-build-machine.html
sudo apt-get install xvfb

sudo update-rc.d xvfb defaults 10

to start : /etc/init.d/xvfb start
#ssh -fX albandri@home.nabla.mobi xclock
#export DISPLAY=:10.0

#http://alex.nederlof.com/blog/2012/11/19/installing-selenium-with-jenkins-on-ubuntu/

sudo apt-get update && sudo apt-get install -y xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic xvfb x11-apps imagemagick firefox

cd /etc/init.d
ln -s /workspace/users/albandri10/env/linux/bin/xvfb.sh xvfb
sudo update-rc.d xvfb defaults

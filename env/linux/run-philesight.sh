#http://zevv.nl/play/code/philesight/
#http://searchingtechdata.net/page/3/
sudo apt-get install libdb4.2-ruby1.8 libcairo-ruby1.8 
sudo apt-get install rubygems
#sudo gem install tumblr-rb

#downgrade ruby 
sudo aptitude remove ruby
sudo aptitude remove ruby 1.9.2p0
sudo aptitude purge ruby
sudo aptitude purge ruby 1.9.2p0

#see /workspace/users/albandri10/env/linux/diskusage.refresh.sh
#see /usr/lib/cgi-bin/philesight.cgi

sudo gedit /usr/lib/cgi-bin/philesight.cgi
#change
$path_db = "/usr/lib/philesight.db"

cd /workspace/users/
sudo chmod 750 images
sudo chmod 750 albandri33

#http://zevv.nl/play/code/philesight/
#http://searchingtechdata.net/page/3/
#for ubuntu 12
sudo apt-get install libdb4.2-ruby1.8 libcairo-ruby1.8 
#install gems by hand
#sudo apt-get install rubygems
#sudo gem install tumblr-rb
sudo wget http://production.cf.rubygems.org/rubygems/rubygems-1.4.2.tgz
sudo tar -xvf rubygems-1.4.2.tgz
cd rubygems-1.4.2 
sudo ruby setup.rb install
cd .. 
sudo rm -rf rubygems-1.4.2
sudo ln -s /usr/bin/gem1.8 /usr/local/bin/gem
gem sources -a http://gems.github.com # add Github as a gem source, you won't regret it

#ubuntu 14
sudo apt-get install python-software-properties
sudo apt-add-repository ppa:brightbox/ruby-ng
sudo apt-get update

ruby -v
#ruby-switch --list
#sudo ruby-switch --set ruby1.8
sudo apt-get install ruby1.8 ruby-switch
sudo gem1.8 install cairo

#downgrade ruby 
#http://stackoverflow.com/questions/4601003/how-to-downgrade-from-ruby-1-9-2-to-ruby-1-8-7-to-run-rails-2-0-2
sudo dpkg -l | grep ruby
sudo aptitude remove ruby1.9.1
#sudo aptitude purge ruby
#sudo aptitude purge ruby 1.9.2p0

#see /workspace/users/albandri10/env/linux/diskusage.refresh.sh
#see /usr/lib/cgi-bin/philesight.cgi

#ruby 1.9
sudo apt-get install ruby ruby-cairo

sudo gedit /usr/lib/cgi-bin/philesight.cgi
#change
$path_db = "/usr/lib/philesight.db"

cd /workspace/users/
sudo chmod 750 images
sudo chmod 750 albandri33

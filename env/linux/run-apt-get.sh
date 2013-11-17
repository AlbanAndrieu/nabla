#webmin
sudo apt-get autoremove
sudo apt-get install nis ntp autofs

wget http://prdownloads.sourceforge.net/webadmin/webmin_1.630_all.deb
dpkg --install webmin_1.630_all.deb

#other package
sudo apt-get install perl libnet-ssleay-perl openssl libauthen-pam-perl libpam-runtime libio-pty-perl apt-show-versions python
sudo apt-get -f install

sudo apt-get install subversion cvs tomcat7 git maven
#sudo apt-get install xxdiff
sudo apt-get install wget curl
sudo apt-get install smartmontools mon 
sudo apt-get install cmake scons

sudo apt-get install maven
sudo dpkg -i --force-all /var/cache/apt/archives/libwagon2-java_2.2-3+nmu1_all.deb
sudo apt-get -f install

sudo apt-cache search 5
sudo apt-get install libdb5.1-dev 

sudo apt-get install ssmtp mailutils
sudo apt-get install geany gedit

sudo apt-get install openjdk-6-jdk openjdk-7-jdk

#cpan
sudo cpan install CPAN
#Install following perl package
sudo cpan install BDB
sudo cpan install XML::DOM
sudo cpan install XML::Handler::YAWriter
sudo cpan install XML::Simple
sudo cpan install Test::Harness
sudo cpan install Test::Pod::Coverage
sudo cpan install Test::Pod
sudo cpan install JSON
sudo cpan install IO::Prompt
sudo cpan install Text::SimpleTable
sudo cpan install HTTP::Date
sudo cpan install Date::Calc
sudo cpan install Date::Format
sudo cpan install Date::Manip
sudo cpan install LWP::Protocol::https
sudo cpan install Crypt::SSLeay
sudo cpan install File::Copy::Recursive
sudo cpan install File::Find::Rule
sudo cpan install Tree::Simple
sudo cpan install Tree::Simple::View::ASCII
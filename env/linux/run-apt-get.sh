#webmin
sudo apt-get autoremove
sudo apt-get install nis ntp autofs

wget http://prdownloads.sourceforge.net/webadmin/webmin_1.630_all.deb

dpkg --install webmin_1.630_all.deb

#cpan
sudo cpan install CPAN

#other package
sudo apt-get install perl libnet-ssleay-perl openssl libauthen-pam-perl libpam-runtime libio-pty-perl apt-show-versions python
sudo apt-get -f install

sudo apt-get install xxdiff cvs tomcat7 git maven
sudo apt-get install wget curl
sudo apt-get install smartmontools mon 

sudo apt-get install maven
sudo dpkg -i --force-all /var/cache/apt/archives/libwagon2-java_2.2-3+nmu1_all.deb
sudo apt-get -f install

sudo apt-cache search 5
sudo apt-get install libdb5.1-dev 
 
#Install following perl package
sudo cpan install BDB
XML::DOM
XML::Handler::YAWriter
XML::Simple
Test::Harness
Test::Pod::Coverag
Test::Pod
JSON
IO::Prompt
Text::SimpleTable
HTTP::Date
Date::Calc
Date::Format
Date::Manip
LWP::Protocol::https
Crypt::SSLeay
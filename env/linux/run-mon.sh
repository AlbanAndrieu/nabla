#http://www.debianhelp.co.uk/mon.htm
sudo apt-get install mon 

sudo nano /etc/mon/auth.cf
#allow user
* mon microsoft
sudo nano /etc/mon/mon.cf
ls /usr/lib/mon/mon.d

#Use webmin to configure mon

#mail -s test alban.andrieu@nabla.mobi <<< test
#mail -s test root@localhost <<< test

#TODO use freespace-snmp.monitor

#sudo cpan install DBD::mSQL 
sudo cpan install DBD::mysql 

cd /usr/lib/mon/mon.d
sudo ln msql-mysql.monitor mysql.monitor
./mysql.monitor albandri
./msql-mysql.monitor --mode mysql localhost
./msql-mysql.monitor --mode mysql --username=root --password=microsoft --database=mysql --port=3306 albandri

sudo cpan install Net::LDAPapi
sudo cpan install Convert::BER
sudo cpan install SNMP::Session
#Fix dns bug
#http://bugs.debian.org/cgi-bin/bugreport.cgi?bug=731328

Enter LDAP Server: albandri
Enter port: 389
Enter Search Filter (ex. uid=abc123): 
Enter LDAP Search Base (ex. o=Org, c=US):

#TODO -basedn='dc=ldap,dc=nabla,dc=mobi'
#TODO -basedn='cn=Manager,o=VAJ' --filter='cn=Manager'
#TODO -base="dc=xpedite, dc=com" -filter="uid=mjcunnin" -attribute=uid -value=mjcunnin 
 
#Sample at https://wb.is.depaul.edu/is/_downloads/SampleMONConfigFile.txt 
 
sudo service mon restart
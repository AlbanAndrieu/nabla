#http://doc.ubuntu-fr.org/rootkit

#https://cisofy.com/documentation/lynis/#installation

sudo apt-get install lynis
sudo lynis --check-update
sudo lynis --version

sudo lynis --check-all -Q

sudo apt-get install rkhunter 
sudo rkhunter --update
sudo rkhunter --version

sudo rkhunter --checkall --report-warnings-only

sudo apt-get install chkrootkit
sudo chkrootkit --version

sudo chkrootkit -q

sudo apt-get install tiger
sudo tiger --version

sudo tiger 

#check for bad block
sudo apt-get install e2fsprogs
sudo badblocks -v /dev/sda > bad-blocks
#sudo fsck -t ext3 -l bad-blocks /dev/sda

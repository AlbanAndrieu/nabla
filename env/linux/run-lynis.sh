
#https://cisofy.com/documentation/lynis/#installation

sudo apt-get install lynis
sudo lynis --check-update
sudo lynis --version

sudo lynis --check-all -Q

#Issue
#http://askubuntu.com/questions/420320/what-permissions-would-change-if-i-change-umask-to-027-from-022
#05:57:20   - Default umask in /etc/login.defs could be more strict like 027 [test:AUTH-9328]
#05:57:20   - Default umask in /etc/init.d/rc could be more strict like 027 [test:AUTH-9328]
grep -RIi umask /etc/login.defs
sudo chmod 750 /etc/login.defs
sudo chmod 750 /etc/init.d/rc
#sudo chmod o-rwx /etc/init.d/rc

#Disable drivers like USB storage when not used
#http://askubuntu.com/questions/254113/how-do-i-disable-usb-storage
echo "blacklist usb-storage" | sudo tee -a /etc/modprobe.d/blacklist.conf
sudo update-initramfs -u

#Issue
#http://www.leonardoborda.com/blog/how-to-configure-sysstatsar-on-ubuntudebian/
#Enable sysstat to collect accounting [test:ACCT-9626]
sudo apt-get install sysstat
sudo nano /etc/default/sysstat
sudo service sysstat restart

#Issue
#Enable auditd to collect audit information [test:ACCT-9628]
#http://linux-audit.com/configuring-and-auditing-linux-systems-with-audit-daemon/
sduo apt-get install auditd audispd-plugins
sudo auditctl -lauditctl -l
sudo auditctl -a exit,always -F path=/etc/passwd -F perm=wa

#Split resolving between localhost and the hostname of the system [test:NAME-4406]
#https://cisofy.com/controls/NAME-4406/
#http://superuser.com/questions/671614/localhost-as-hostname-confusion
sudo nano /etc/hosts
#There should only be one line in there that reads:
127.0.0.1       localhost
127.0.1.1       albandri

hostname
hostname -f

sudo dhclient
sudo restart network-manager

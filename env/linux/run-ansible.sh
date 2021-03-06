#!/bin/bash
set -xv

#http://blog.trifork.com/2013/03/26/ansible-next-generation-configuration-management/

#install ansible using apt (BUT instead use pip in order to have a more recent version of ansible)
sudo add-apt-repository ppa:rquillo/ansible
#For the older version 1.9 we use this
sudo apt-add-repository --remove ppa:ansible/ansible -y
sudo add-apt-repository ppa:ansible/ansible-1.9
#sudo apt-get install ansible
#sudo apt-get --reinstall install ansible
#sudo apt-cache showpkg ansible
#sudo dpkg -l ansible
#sudo aptitude show ansible

#install python
sudo apt-get install python-pip python-dev build-essential
sudo pip install --upgrade pip

#Red hat installation
#https://www.digitalocean.com/community/tutorials/how-to-set-up-python-2-7-6-and-3-3-3-on-centos-6-4
subscription-manager list --available --all
yum update -y --skip-broken
sudo sh -c 'wget -qO- http://people.redhat.com/bkabrda/scl_python27.repo >> /etc/yum.repos.d/scl.repo'
yum search python27
yum install python27
scl enable python27 bash
#yum install python-pip python-devel
#pip install pycrypto
#sudo pip install pycrypto --upgrade
#sudo pip uninstall pycrypto
# yum erase python-crypto
# yum install python-crypto python-paramiko
#sudo pip install paramiko
#sudo pip install PyYAML jinja2 httplib2 --upgrade
pip2.7 install ansible

#Red hat usage in bash script
#scl enable python27 bash
export PATH="/opt/rh/python27/root/usr/bin:/usr/lib64/qt-3.3/bin:/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/root/bin"
export LD_LIBRARY_PATH="/opt/rh/python27/root/usr/lib64"

#alias python='/opt/rh/python27/root/usr/bin/python2.7'
#alias pip='/opt/rh/python27/root/usr/bin/pip2.7'
#alias ansible='/opt/rh/python27/root/usr/bin/ansible'

python -V
python2.7 -V

pip -V

ansible --version

#source /workspace/users/albandri10/ansible/hacking/env-setup

#PATH=/workspace/users/albandri10/ansible/bin:/usr/lib/lightdm/lightdm:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games
#PYTHONPATH=/workspace/users/albandri10/ansible/lib:
#ANSIBLE_LIBRARY=/workspace/users/albandri10/ansible/library
#MANPATH=/workspace/users/albandri10/ansible/docs/man:

#install python version of ansible
#it go inside /usr/local/bin
sudo pip2 uninstall ansible
sudo pip2 install ansible==2.3.0.0
sudo pip2 install docker-compose==1.12.0
sudo pip2 install docker==2.2.1
#install ansible devel version
#sudo pip install https://github.com/ansible/ansible/archive/devel.zip

which ansible
ansible --version

git clone https://github.com/ansible/ansible-examples.git

sudo gedit /etc/ansible/hosts
sudo gedit /etc/ansible/ansible.cfg
#change hostfile = /etc/ansible/hosts
hostfile       = /workspace/users/albandri10/env/ansible/hosts
#to override default config
export ANSIBLE_HOSTS=/workspace/users/albandri10/env/ansible/hosts

cd /workspace/users/albandri10/env/ansible
chmod -x hosts
chmod 755 -R *

#http://www.ansibleworks.com/docs/intro_getting_started.html

#echo "127.0.0.1" > ~/ansible_hosts
#export ANSIBLE_HOSTS=~/ansible_hosts

ssh-agent bash
#ssh-add ~/.ssh/id_rsa
ssh-add ~/.ssh/OpenSSH_RSA_4096

ansible all -m ping --ask-pass
#ansible albandri -m setup -u tomcat -k

#as root
ansible-playbook site.yml --list-hosts
ansible-playbook -i hosts site.yml -vvvv

ansible-playbook -i hosts jenkins.yml -vvvv
#ansible-playbook jenkins.yml --extra-vars "host=albandri user=albandri" --ask-sudo-pass

#tutorial
#https://github.com/leucos/ansible-tuto

git clone https://github.com/leucos/ansible-tuto.git
cd ansible-tuto
ansible-playbook -c paramiko -i step-00/hosts step-00/setup.yml --ask-pass --sudo
#use pass vagrant

#see params
ansible -m setup albandri | grep eth0
ansible -m setup localhost
ansible -m setup dantooine -i hosts-dantooine -vvvv -u root
ansible -m setup zone -i hosts -vvvv -u root --ask-pass -e 'ansible_python_interpreter=/usr/local/bin/python2.7'

#jenkins
#https://blog.trifork.com/2013/04/02/ansible-example-playbook-to-setup-jenkins-slave/

#ansible tower
cd /workspace
wget http://www.ansible.com/e1t/c/*VkSrPh92y0-nW70nTNx3_SP3N0/*W6JHrjk4pCNdtW8RHZ5g8tnbQL0/5/f18dQhb0S2C573Gt_KTvKVG5sWNx8W2KvcF-2R7TH1W73PLLz2qz4c-W2RFhpP4SKM2KMZ7V_XVw5mwW5n1Q2z9bpRqQVmJDJh4Zl5cjW87fsdg8Yq0CdW25qxfM8kBvC5W6r988r1dYhMRW2t-Gqq91grlcW6xGH6w32Rm-BW4pjnYz3YZbt_W5mwcDs26CLL7W7T3QgS2jDTlTW2nRT0y3RnyQcVtQ2KJ2pf3H_W13-30g605zhXW2ByPLM8hKlgTV-BpM74HpQnVW6xW3PZ66vZCvW7DtGtb6Sr_wgW14PfTv99xY2MW19s5QX2735_tW5DPhlq6YwBVVN94JvbhHrkb9W6Bb1vL1_KTbrW62HJRp3C4RDjW1z45hv7M6SDsW1R7kcR51h8SwW5BmkM93RwR30N3h3CqkLHJZCW52ZXL33yvCt2W7htYQv2h3c-6W7HTjcT8gSgMRW6xpnJm32BT1bW1BZkr01566FcW48TLNJ8Q-TM6N7q3QQl8rWWfW8VRPtJ3wG67JW6h0NJj2fc18rVjbfj67DQR-cW83W6mz2Qt40zW1TPwxB3Cq7vMVy9G654VnNMkW4dPNws4GsPQYW6_RgTy7D_dDcW8hFsGL2sV-3SVgh2Hv5jl9wxW3hf9Gr4HlBxvN4dChbZwndLZW6_Y25X616SB2103
sudo tar -xvf ansible-tower-setup-latest.tar.gz
https://localhost/
#admin Microsoft
#admin Microsoft

#see example
#https://github.com/ansible/ansible-examples/tree/master/language_features

#windows how to
#http://docs.ansible.com/intro_windows.html#installing-on-the-control-machine
#http://damonoverboe.org/post/ansible-and-windows-basic-set-up
#http://docs.ansible.com/list_of_windows_modules.html

#see run-xrdp.sh
#in order to fix error:
#IndexError: tuple index out of range
sudo pip install https://github.com/diyan/pywinrm/archive/df049454a9309280866e0156805ccda12d71c93a.zip --upgrade
#NOK sudo pip install https://github.com/diyan/pywinrm/tree/7ab74a4b8fbeb2af707c5628703c485f8d14238d --upgrade
#NOK sudo pip install -U http://github.com/diyan/pywinrm/archive/master.zip#egg=pywinrm
sudo pip install pywinrm --upgrade

ansible windows -i hosts -m win_ping --ask-vault-pass
#list info
ansible -i hosts GDNCSWMGRQA0015.misys.global.ad -m setup

#On windows enable ping
#cmd
netsh advfirewall firewall add rule name="All ICMP V4" protocol=icmpv4:any,any dir=in action=allow
netsh advfirewall firewall add rule Profile=public name="Allow WinRM HTTPS" dir=in localport=5986 protocol=TCP action=allow
NetSH ADVFirewall Set AllProfiles Settings remotemanagement Enable

#see https://github.com/diyan/pywinrm
winrm set winrm/config/client/auth @{Basic="true"}
winrm set winrm/config/service/auth @{Basic="true"}
winrm set winrm/config/service @{AllowUnencrypted="true"}
#powershell
Get-ExecutionPolicy -Scope CurrentUser
Set-ExecutionPolicy -Scope CurrentUser RemoteSigned

sudo pip install ansigenome
easy_install ansigenome
git clone https://github.com/nickjj/ansigenome

#sudo ansigenome config
cd ~/env/ansible/roles
ansigenome scan
less ~/.ansigenome.conf
ansigenome gendoc -f md

#https://docs.ansible.com/ansible-container/
sudo pip install ansible-container

sudo pip3.5 install --upgrade ansible-cmdb

# Install ARA
#See https://github.com/openstack/ara
# Install ARA
pip install ara
# Load environment variables that inform Ansible to use ARA regardless
# of its location or python version
source <(python -m ara.setup.env)
# Run your Ansible playbook or commands
# ansible-playbook myplaybook.yml
# Start the ARA standalone webserver
ara-manage runserver
# Browse http://127.0.0.1:9191

# in order to fix issue :
# Could not import python modules: apt, apt_pkg. Please install python3-apt package
# remove  -e ansible_python_interpreter="/opt/ansible/env37/bin/python3.7" from Jenkinsfile and add it on inventory/production

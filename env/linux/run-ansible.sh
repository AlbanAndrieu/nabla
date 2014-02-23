#http://blog.trifork.com/2013/03/26/ansible-next-generation-configuration-management/

#install ansible
sudo add-apt-repository ppa:rquillo/ansible
sudo apt-get install ansible

#install python
sudo apt-get install python-pip python-dev build-essential
sudo pip install --upgrade pip

sudo pip install paramiko PyYAML jinja2 httplib2

#build yourself
#git clone git://github.com/ansible/ansible.git
#cd ansible
#make debian

#source /workspace/users/albandri10/ansible/hacking/env-setup

#PATH=/workspace/users/albandri10/ansible/bin:/usr/lib/lightdm/lightdm:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games
#PYTHONPATH=/workspace/users/albandri10/ansible/lib:
#ANSIBLE_LIBRARY=/workspace/users/albandri10/ansible/library
#MANPATH=/workspace/users/albandri10/ansible/docs/man:

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
https://github.com/leucos/ansible-tuto

sudo apt-get purge openssh-server openssh-client
sudo apt-get install openssh-server openssh-client

#First, check that your SSH daemon is running:
ps -A | grep sshd

sudo ss -lnp | grep sshd

sudo lsof -i | grep ssh
netstat -l --numeric-ports | grep 22

ssh localhost

#ssh tunelling example
ssh -D 9696 albandri@albandri.misys.global.ad

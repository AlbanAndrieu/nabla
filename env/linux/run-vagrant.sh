#http://docs.vagrantup.com/v2/why-vagrant/index.html
#http://www.synbioz.com/blog/vagrant_et_la_virtualisation_pour_faciliter_le_developpement

cd /workspace
#sudo apt-get remove vagrant:i386
#sudo wget https://dl.bintray.com/mitchellh/vagrant/vagrant_1.4.3_x86_64.deb
#sudo dpkg --install vagrant_1.4.3_x86_64.deb
sudo wget https://dl.bintray.com/mitchellh/vagrant/vagrant_1.4.3_i686.deb
sudo dpkg --install vagrant_1.4.3_i686.deb

#tutorial
#https://github.com/leucos/ansible-tuto
#see run-ansible.sh
git clone https://github.com/leucos/ansible-tuto.git
cd ansible-tuto

vagrant up
#or get yours at http://www.vagrantbox.es/
#wget http://brennovich.s3.amazonaws.com/saucy64_vmware_fusion.box
#wget http://files.vagrantup.com/precise64.box
#vagrant box add base /devel/albandri/tmp/ansible-tuto/precise64.box
#vagrant box add precise32 http://files.vagrantup.com/precise32.box
#vagrant box add precise32 /devel/albandri/tmp/ansible-tuto/precise32.box
vagrant init base
#vagrant up --provider=libvirt
vagrant up
vagrant ssh
vagrant provision
vagrant halt
vagrant destroy
#vagrant box update

vagrant package --base 'vagrant-windows-2012' --output 'vagrant-windows-2012.box'

#vagrant package
#tar xf package.box
#ovftool box.ovf box.ova

#you might need to change 
#export VAGRANT_HOME=/devel/albandri/home/.vagrant.d
#create symbolic link
#ln -s /devel/albandri/home/VirtualBox\ VMs/ 'VirtualBox VMs'

#https://wiki.jenkins-ci.org/display/JENKINS/Vagrant+Plugin

#add vagrant plugin
sudo apt-get install libxslt-dev libxml2-dev libvirt-dev
sudo vagrant plugin install vagrant-libvirt

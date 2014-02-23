#http://docs.vagrantup.com/v2/why-vagrant/index.html
#http://www.synbioz.com/blog/vagrant_et_la_virtualisation_pour_faciliter_le_developpement

cd /worspace
#sudo wget https://dl.bintray.com/mitchellh/vagrant/vagrant_1.4.3_x86_64.deb
#sudo dpkg --install vagrant_1.4.3_x86_64.deb
sudo wget https://dl.bintray.com/mitchellh/vagrant/vagrant_1.4.3_i686.deb
sudo dpkg --install vagrant_1.4.3_i686.deb

git clone https://github.com/leucos/ansible-tuto.git
cd ansible-tuto

vagrant up
#or get yours at http://www.vagrantbox.es/
#wget http://brennovich.s3.amazonaws.com/saucy64_vmware_fusion.box
#wget http://files.vagrantup.com/precise64.box
#vagrant box add base /devel/albandri/tmp/ansible-tuto/precise64.box

TODO
[host2] Waiting for machine to boot. This may take a few minutes...
Timed out while waiting for the machine to boot. This means that
Vagrant was unable to communicate with the guest machine within
the configured ("config.vm.boot_timeout" value) time period. This can
mean a number of things.

If you're using a custom box, make sure that networking is properly
working and you're able to connect to the machine. It is a common
problem that networking isn't setup properly in these boxes.
Verify that authentication configurations are also setup properly,
as well.

If the box appears to be booting properly, you may want to increase
the timeout ("config.vm.boot_timeout") value.

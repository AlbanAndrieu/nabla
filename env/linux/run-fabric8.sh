#See https://github.com/minishift/minishift/blob/master/docs/source/getting-started/setting-up-driver-plugin.adoc#kvm-driver-install

sudo apt install libvirt-bin qemu-kvm
sudo usermod -a -G libvirtd albandri
newgrp libvirtd

#See https://github.com/fabric8io/fabric8-platform/blob/master/INSTALL.md

curl -sS https://get.fabric8.io/download.txt | bash
echo 'export PATH=$PATH:~/.fabric8/bin' >> ~/.bashrc
source ~/.bashrc

gofabric8 start

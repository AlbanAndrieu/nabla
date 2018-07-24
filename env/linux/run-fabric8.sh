#See https://github.com/minishift/minishift/blob/master/docs/source/getting-started/setting-up-driver-plugin.adoc#kvm-driver-install

sudo apt install libvirt-bin qemu-kvm
sudo usermod -a -G libvirtd albandri
newgrp libvirtd

#See https://github.com/fabric8io/fabric8-platform/blob/master/INSTALL.md

curl -sS https://get.fabric8.io/download.txt | bash
echo 'export PATH=$PATH:~/.fabric8/bin' >> ~/.bashrc
source ~/.bashrc

gofabric8 start --package=system  --namespace fabric8
#gofabric8 start --minishift --package=system  --namespace fabric8

#See https://github.com/fabric8io/fabric8/blob/master/docs/getStarted/gofabric8.md

#See https://github.com/settings/applications/818104
export GITHUB_OAUTH_CLIENT_ID=c52c293400ba80af105a
export GITHUB_OAUTH_CLIENT_SECRET=microsoft

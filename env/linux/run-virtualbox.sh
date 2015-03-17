#https://www.virtualbox.org/wiki/Linux_Downloads

sudo nano /etc/apt/sources.list
#deb http://download.virtualbox.org/virtualbox/debian saucy contrib
deb http://download.virtualbox.org/virtualbox/debian precise contrib

wget -q http://download.virtualbox.org/virtualbox/debian/oracle_vbox.asc -O- | sudo apt-key add -

sudo apt-get update
sudo apt-get install virtualbox-4.3
sudo apt-get install dkms

sudo mkdir -p /workspace/virtualbox/$USER/.VirtualBox
sudo chown -R albandri:albandri /workspace/virtualbox/$USER
cp -R ~/.VirtualBox /workspace/virtualbox/$USER
rm -rf ~/.VirtualBox
ln -s /workspace/virtualbox/$USER/.VirtualBox ~/.VirtualBox

cp -r ~/VirtualBox\ VMs /workspace/virtualbox/$USER
mkdir -p /workspace/virtualbox/$USER/VirtualBox\ VMs
#rm -rf ~/VirtualBox \ VMs
ln -s /workspace/virtualbox/$USER/VirtualBox\ VMs ~/VirtualBox\ VMs

#install oracle vm virtualbox extension pack
wget http://download.virtualbox.org/virtualbox/4.3.10/Oracle_VM_VirtualBox_Extension_Pack-4.3.10-93012.vbox-extpack
sudo mkdir -p /local/virtualbox/Windows7/Shared
#Log in with user: User/Kondor_123

#convert vdi to vmdk
vboxmanage internalcommands converttoraw OpenSolaris.vdi OpenSolaris.raw
sudo apt-get install qemu-kvm libvirt-bin bridge-utils virt-manager
sudo adduser albandri libvirtd
sudo virsh -c qemu:///system list
qemu-img convert -O vmdk OpenSolaris.raw OpenSolaris.vmdk

#access global zone from windows host
#http://10.0.2.4
#http://10.0.2.2:9000/
#sudo ifconfig -a

#Sample of command
VBoxManage list vms
VBoxManage controlvm vagrant-windows-2012 poweroff
VBoxManage modifyvm "vagrant-windows-2012" --natpf1 delete "winrm"
VBoxManage modifyvm "vagrant-windows-2012" --memory 4096
# MySQL 3306
VBoxManage modifyvm "vagrant-windows-2012" --natpf1 "tcp-port3306,tcp,,3306,,3306"
VBoxManage modifyvm "vagrant-windows-2012" --natpf1 "udp-port3306,udp,,3306,,3306"

VBoxManage metrics list "vagrant-windows-2012"
VBoxManage debugvm "vagrant-windows-2012" osinfo
VBoxManage startvm "vagrant-windows-2012" --type headless



#VBoxManage unregistervm vagrant-windows-2012 --delete

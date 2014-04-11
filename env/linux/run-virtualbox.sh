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

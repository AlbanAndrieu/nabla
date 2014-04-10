#https://www.virtualbox.org/wiki/Linux_Downloads

sudo nano /etc/apt/sources.list
deb http://download.virtualbox.org/virtualbox/debian saucy contrib

wget -q http://download.virtualbox.org/virtualbox/debian/oracle_vbox.asc -O- | sudo apt-key add -

sudo apt-get update
sudo apt-get install virtualbox-4.3
sudo apt-get install dkms

sudo mkdir -p /workspace/virtualbox/$USER/.VirtualBox
sudo chown -R albandri:albandri albandri/
cp ~/.VirtualBox /workspace/virtualbox/$USER
rm -rf ~/.VirtualBox
ln -s /workspace/virtualbox/$USER/.VirtualBox ~/.VirtualBox

#cp -r ~/VirtualBox\ VMs /workspace/virtualbox/$USER 
#rm -rf ~/VirtualBox 
#ln -s /workspace/virtualbox/$USER\VirtualBox\ VMs ~/VirtualBox\ VMs

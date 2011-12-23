
'g++-3.4' is available from "hardy-updates"
http://packages.ubuntu.com/hardy-updates/g++-3.4

sudo dpkg -i \
cpp-3.4_3.4.6-6ubuntu5_i386.deb g++-3.4_3.4.6-6ubuntu5_i386.deb \ 
gcc-3.4_3.4.6-6ubuntu5_i386.deb gcc-3.4-base_3.4.6-6ubuntu5_i386.deb \ 
libstdc++6-dev_3.4.6-6ubuntu5_i386.deb 

wget http://fr.archive.ubuntu.com/ubuntu/pool/main/g/gcc-4.4/libstdc++6_4.4.1-4ubuntu8_i386.deb
sudo dpkg -i libstdc*.deb
sudo apt-get install -f

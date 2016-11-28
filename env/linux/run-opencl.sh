
#opencl
#https://software.intel.com/en-us/articles/opencl-drivers#philinux
#http://develnoter.blogspot.co.uk/2012/05/installing-opencl-in-ubuntu-1204.html
#NOK below
#wget http://registrationcenter.intel.com/irc_nas/4181/intel_sdk_for_ocl_applications_2014_ubuntu_4.4.0.117_x64.tgz
#tar zxvf intel_sdk_for_ocl_applications_2014_ubuntu_4.4.0.117_x64.tgz
#./install-cpu.sh
#ll /usr/lib/x86_64-linux-gnu/libOpenCL.so

cd ~/Downloads/
wget http://registrationcenter-download.intel.com/akdlm/irc_nas/9019/opencl_runtime_16.1_x64_ubuntu_5.2.0.10002.tgz
cd opencl_runtime_16.1_x64_ubuntu_5.2.0.10002
sudo sh install.sh

sudo mkdir /opt/intel
sudo tar -xzf opencl-1.2.0.9756.tgz -C /opt/intel
sudo mkdir -p /etc/OpenCL/vendors
sudo ln -s /opt/intel/opencl-1.2.0.9756/etc/intel64.icd /etc/OpenCL/vendors/intel64.icd
sudo apt-get install ocl-icd-libopencl1 ocl-icd-opencl-dev libnuma-dev

ll /etc/X11/xorg.conf
Section "Device"
    Identifier     "Device0"
    Driver         "nvidia"
    VendorName     "NVIDIA Corporation"
    Option         "Interactive" "off"
EndSection

cat /proc/cpuinfo
lspci |grep NVIDIA

#You can check OpenCL devices on Ubuntu systems with utility "clinfo" (get it from apt):
#sudo apt-get install nvidia-cg-toolkit
sudo apt-get install clinfo
clinfo

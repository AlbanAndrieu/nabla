#!/bin/bash
set -xv

#disable rhnplugin
# grep enable /etc/yum/pluginconf.d/rhnplugin.conf
#enabled = 0
##enabled = 1

#or disable by hand
yum search python26 --disableplugin=rhnplugin
#yum search python27 --disableplugin=rhnplugin
#Not available on RH 5
wget https://www.python.org/ftp/python/2.7.3/Python-2.7.3.tgz --no-check-certificate # Download
tar xvfz Python-2.7.3.tgz # unzip
cd Python-2.7.3 # go into directory
./configure
make # build
#su # or 'sudo su' if there is no root user
make altinstall
#make install #do not do it

ln -s /usr/local/bin/python2.7 /usr/bin/python2.7

ls -lrta /usr/local/bin/python2.7

rm /root/Python-2.7.3

#might need todo yum remove mercurial

#TODO RedHat https://www.tecmint.com/install-python-in-linux/ install python 3.6 for ansible
#yum -y groupinstall development
#yum -y install zlib-devel

# wget https://www.python.org/ftp/python/3.6.3/Python-3.6.3.tar.xz
# tar xJf Python-3.6.3.tar.xz
# cd Python-3.6.3
# ./configure
# make
# make install

# which python3
# python3 -V

#virtualenv py3-ansible -p /usr/local/bin/python3.6
sudo virtualenv /opt/ansible/env36 -p /usr/bin/python3.6
source /opt/ansible/env36/bin/activate

#RedHat
#alternatives --install /usr/bin/python python /usr/local/bin/python3.6 2
#alternatives --install /usr/bin/python python /usr/bin/python2.7 1
#alternatives --list | grep -i python

#Ubuntu
#ls -la /etc/alternatives/python*
#sudo update-alternatives --install /usr/bin/python python /usr/bin/python3.6 30
#sudo update-alternatives --install /usr/bin/python python /usr/bin/python3.5 20
#sudo update-alternatives --install /usr/bin/python python /usr/bin/python2.7 100
#sudo update-alternatives --install /usr/bin/python python /usr/bin/python2.6  5
#sudo update-alternatives --config python

#pip3 install docker-py
#pip3 install -U docker-compose
#pip3 install ansible

#python3 /usr/bin/ansible localhost -m ping

#update-alternatives --config python

#Issue AttributeError: 'module' object has no attribute 'PROTOCOL_SSLv3
sudo easy_install --upgrade pip

#Show outdated pip package
pip2 list --outdated --format=freeze
pip3 list --outdated --format=freeze
#Upgrade all
export PYTHONPATH=/usr/local/lib/python2.7/dist-packages
pip2 freeze --local | grep -v '^\-e' | cut -d = -f 1  | xargs -n1 sudo pip2 install -U
export PYTHONPATH=/usr/local/lib/python3.6/dist-packages/
pip3 freeze --local | grep -v '^\-e' | cut -d = -f 1  | xargs -n1 sudo pip3 install -U

sudo apt-get install python3.6-dev
#Issue pycurl: libcurl link-time ssl backend (nss) is different from compile-time ssl backend (none/other)
sudo pip uninstall pycurl
sudo pip install --no-cache-dir --compile --ignore-installed --install-option="--with-nss" pycurl
#RedHat
pip install pycurl==7.43.0.1 --global-option="--with-nss" --upgrade

#virtualenv
mkvirtualenv py27 -p /usr/bin/python2.7
mkvirtualenv py36 -p /usr/bin/python3.6
workon py36

lsvirtualenv

#color
sudo pip2.7 install ansicolors termcolor colorama
sudo pip2.7 freeze > requirements-current-2.7.txt
sudo pip2.7 install -r requirements.txt

sudo pip3.6 install ansicolors termcolor colorama
sudo pip3.6 freeze > requirements-current-3.6.txt
sudo pip3.6 install -r requirements-current-3.6.txt

#Upgrade requirements.txt
#pip install pip-tools pip-review
#pip-review --auto
pip install pip-upgrader

pip-upgrade requirements-current-3.6.txt

#pip uninstall docker docker-py docker-compose

#Ubuntu 16 is missing pip3.6
curl https://bootstrap.pypa.io/get-pip.py | sudo python3.6
(pip -V && pip3 -V && pip3.6 -V) | uniq

#Install docker-compose

sudo pip2.7 uninstall docker
sudo pip2.7 uninstall docker-py
sudo pip2.7 uninstall docker-compose
sudo pip2.7 install docker-compose==1.9.0

docker-compose --version

sudo pip3.6 uninstall docker
sudo pip3.6 uninstall docker-py
sudo pip3.6 uninstall docker-compose
sudo pip3.6 install docker-compose==1.9.0

docker-compose --version

#Error below https://github.com/Kozea/CairoSVG/issues/141
#sudo pip2.7 install cairosvg
brew install cairo libxml2 libffi
pip3 install cairosvg
apt-get install libffi-dev
yum install libffi-devel
pip install cairocffi==0.8.0
pip2 install CairoSVG==2.0.3

dpkg -l | grep 'urllib3'
sudo apt-get install python-urllib3 python3-urllib3

# Documentation
sudo apt install python-markdown
markdown_py README.md > README.html
pip install -U mkdocs

#Ubuntu 18.04 LTS
#version `CURL_OPENSSL_3' not found (required by /usr/local/lib/python2.7/dist-packages/pycurl.so
sudo apt-get install libcurl3 python-pip
#recreate virtualenv
sudo rm -Rf /opt/ansible/env36
virtualenv --no-site-packages /opt/ansible/env36 -p python3.6

#Run setuptools to create python package
#See https://packaging.python.org/tutorials/packaging-projects/#setup-py

python3 -m pip install --user --upgrade setuptools wheel
python3 setup.py sdist bdist_wheel

# Could not import python modules: apt, apt_pkg. Please install python3-apt package.
sudo apt-get remove --purge python-apt
#sudo apt-get install python-apt -y -q
sudo apt-get install python3-apt --reinstall
sudo apt install python3.7
cd /usr/lib/python3/dist-packages
sudo ln -s apt_pkg.cpython-{35m,34m}-x86_64-linux-gnu.so
sudo ln -s apt_pkg.cpython-{36m,35m}-x86_64-linux-gnu.so
sudo ln -s apt_pkg.cpython-{36m,37m}-x86_64-linux-gnu.so
#sudo ln -s apt_pkg.cpython-{35m,34m}-x86_64-linux-gnu.so apt_pkg.so
#sudo ln -s apt_pkg.cpython-{35m,34m}-x86_64-linux-gnu.so apt.so
sudo cp apt_pkg.cpython-36m-x86_64-linux-gnu.so apt_pkg.so
sudo ln -s apt_inst.cpython-36m-x86_64-linux-gnu.so apt_inst.so

#Python profiling
#See https://github.com/jrfonseca/gprof2dot
sudo apt-get install python3 graphviz
pip install gprof2dot

# Use normal command to run script, proceeded by module call to cProfile (-o is output file)
python -m  cProfile -o cprofile  setup.py
# Use gprof2dot to generate .png image of calls
gprof2dot -f pstats cprofile | dot -Tpng -o output.png

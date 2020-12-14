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

./run-update-alternatives.sh

#pip3 install docker-py
#pip3 install -U docker-compose
#pip3 install ansible

#python3 /usr/bin/ansible localhost -m ping

#update-alternatives --config python

#Upgrade pip
#Issue AttributeError: 'module' object has no attribute 'PROTOCOL_SSLv3
#sudo easy_install --upgrade pip
pip2 install --upgrade pip
pip3 install --upgrade pip

#Run setuptools to create python package
#See https://packaging.python.org/tutorials/packaging-projects/#setup-py

python2 -m pip install --user --upgrade setuptools wheel
python3 -m pip install --user --upgrade setuptools wheel
python3 setup.py sdist bdist_wheel

#Show outdated pip package
pip2 list --outdated --format=freeze
pip3 list --outdated --format=freeze
#Upgrade all
export PYTHONPATH=/usr/local/lib/python2.7/dist-packages
pip2 freeze --local | grep -v '^\-e' | cut -d = -f 1  | xargs -n1 sudo pip2 install -U
#export PYTHONPATH=/usr/local/lib/python3.6/dist-packages/
export PYTHONPATH=/opt/ansible/env37/lib/python3.7/site-packages/
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

sudo pip3.8 install ansicolors termcolor colorama
sudo pip3.8 freeze > requirements-current-3.8.txt
sudo pip3.8 install -r requirements-current-3.8.txt

#Upgrade requirements.txt
#pip install pip-tools pip-review
#pip-review --auto
pip install pip-upgrader

pip-upgrade requirements-current-3.8.txt

#pip uninstall docker docker-py docker-compose

#Ubuntu 16 is missing pip3.6
curl https://bootstrap.pypa.io/get-pip.py | sudo python3.6
(pip -V && pip3 -V && pip3.6 -V) | uniq

#Install docker-compose

sudo pip2.7 uninstall docker
sudo pip2.7 uninstall docker-py
sudo pip2.7 uninstall docker-compose
sudo pip2.7 install docker-compose==1.25.5

#sudo pip3.6 uninstall docker
#sudo pip3.6 uninstall docker-py
#sudo pip3.6 uninstall docker-compose
#sudo pip3.6 install docker-compose==1.9.0

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
#Ubuntu 19.04 LTS
sudo apt-get install libcurl4 python-pip

#recreate virtualenv
sudo rm -Rf /opt/ansible/env38
virtualenv --no-site-packages /opt/ansible/env38 -p python3.8

# Could not import python modules: apt, apt_pkg. Please install python3-apt package.
sudo apt-get remove --purge python-apt
#sudo apt-get remove --purge python3.7*
#sudo apt-get install python-apt -y -q
sudo apt-get install python3-apt --reinstall
sudo apt install python3.7 python3.7-dev
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

#Python 2.7 dropped
#See https://setuptools.readthedocs.io/en/latest/python%202%20sunset.html
sudo pip uninstall -y setuptools

# See https://virtualenvwrapper.readthedocs.io/en/latest/install.html

sudo chown -R jenkins:docker /opt/ansible/

#sudo /usr/local/bin/pip2.7 install virtualenv==20.0.24
pip2.7 uninstall virtualenv virtualenvwrapper
pip2.7 list

source /opt/ansible/env38/bin/activate
export SETUPTOOLS_USE_DISTUTILS=stdlib
virtualenv --version
#15.2.0
#sudo pip3.8 install setuptools virtualenvwrapper
#sudo apt-get install python3-virtualenv
#sudo mv /usr/local/bin/virtualenv /usr/local/bin/virtualenv-SAV
mkvirtualenv --python=/usr/bin/python
#brew info python
#brew uninstall --ignore-dependencies python

mkvirtualenv --version

source /opt/ansible/env/bin/activate
pip uninstall virtualenv #15.2.0
sudo pip2 install virtualenv==20.0.23
sudo pip2 install virtualenvwrapper

/opt/ansible/env/bin/pip2 list
/usr/local/bin/pip3 list
pip3 list
/opt/ansible/env38/bin/pip3.8 list
#sudo /opt/ansible/env38/bin/pip3.8 install virtualenv==20.0.24

export WORKON_HOME=/opt/ansible/env/
source /usr/local/bin/virtualenvwrapper.sh
#VIRTUALENVWRAPPER_PYTHON=/opt/ansible/env38/bin/python
export VIRTUALENVWRAPPER_PYTHON=/opt/ansible/env/bin/python
export VIRTUALENVWRAPPER_VIRTUALENV=/opt/ansible/env/bin/virtualenv

lssitepackages

ls -l $VIRTUALENVWRAPPER_PYTHON
ls -lrta $HOME/.virtualenvs/
ls -lrta $PROJECT_HOME

#Test creation
mkvirtualenv test

#pip3 install --upgrade pip==20.2.2 wheel==0.34.2 setuptools==46.1.3

# Issue on jenkins user
# ModuleNotFoundError: No module named 'setuptools._distutils'
rm -Rf /jenkins/.local/lib/python3.8/site-packages/

# Issue ModuleNotFoundError: No module named 'virtualenv.seed.via_app_data'
# https://news.julien-anne.fr/ubuntu-20-04-python3-et-virtualenv-installation-et-erreurs-potentielles/
sudo apt remove python3-virtualenv
pip3 install virtualenv==20.0.23
/usr/bin/python3.8 -m pip install --upgrade pip
#Successfully installed pip-20.2.3

#Add in ~/.bashrc
if [ -d "/home/${USER}/.local/bin" ] ; then
    export PATH=/home/${USER}/.local/bin:${PATH}
fi

pip2 install --user "setuptools<45"

# See https://stackoverflow.com/questions/25981703/pip-install-fails-with-connection-error-ssl-certificate-verify-failed-certi

# /c/Python27/Scripts/pip2.7.exe --trusted-host pypi.org --trusted-host files.pythonhosted.org install pywin32==228 distro==1.5.0
# /c/Python27/python.exe -m pip --trusted-host pypi.org --trusted-host files.pythonhosted.org install --upgrade pip

#mkdir ~/.config/pip
#geany ~/.config/pip/pip.conf
#[global]
#trusted-host = pypi.python.org
#               pypi.org
#               files.pythonhosted.org

# BUG infinit loop pip 20.3 : See https://github.com/pypa/pip/issues/9011
# Downgrade to
/opt/ansible/env37/bin/pip3.7 install --upgrade pip==20.2.4

exit 0

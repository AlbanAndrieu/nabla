#!/bin/bash
#set -xv

red='\e[0;31m'
green='\e[0;32m'
NC='\e[0m' # No Color

if [ -n "${TARGET_SLAVE}" ]; then
  echo -e "TARGET_SLAVE is defined \u061F"
else
  echo -e "${red} \u00BB Undefined build parameter: TARGET_SLAVE, use the default one ${NC}"
  export TARGET_SLAVE=albandri.misys.global.ad
fi

lsb_release -a

echo "USER : $USER"
echo "HOME : $HOME"
echo "WORKSPACE : $WORKSPACE"

echo -e "${red} Configure workstation ${NC}"

#sudo apt-get update -qq
#sudo apt-get purge -y ansible
#/usr/bin/yes | sudo pip uninstall ansible
#sudo apt-get install -qq python-apt python-pycurl
#sudo apt-get install chkrootkit
#sudo pip install 'ansible<1.8' 
#sudo pip install ansible-lint

#todo use virtualenv

echo "Switch to python 2.7 and ansible 2.1.1"
#scl enable python27 bash
#Enable python 2.7 and switch to ansible 2.1.1
#source /opt/rh/python27/enable

type -p ansible-playbook > /dev/null
if [ $? -ne 0 ]; then
    echo -e "Oops! I cannot find ansible.  Please be sure to install ansible before proceeding."
    echo -e "For guidance on installing ansible, consult http://docs.ansible.com/intro_installation.html."
    exit 1
fi

# Allow exit codes to trickle through a pipe
set -o pipefail

#TIMESTAMP=$(date --utc +"%F-%T")

# When using an interactive shell, force colorized ansible output
if [ -t "0" ]; then
    ANSIBLE_FORCE_COLOR=True
fi

python --version
pip --version
ansible --version
ansible-galaxy --version

#vagrant --version
#docker --version

cd ${WORKSPACE}/Scripts/ansible

# install roles
ansible-galaxy install -r requirements.yml -p ./roles/ --ignore-errors

ansible -m setup ${TARGET_SLAVE} -i staging -vvvv

# check quality
#ansible-lint workstation.yml

# check syntax 
ansible-playbook -i staging -c local -v workstation.yml --limit ${TARGET_SLAVE} -vvvv --syntax-check
RC=$?
if [ ${RC} -ne 0 ]; then
  echo ""
  echo -e "${red} Sorry, syntax-check failed ${NC}"
  exit 1
else
  echo -e "${green} The syntax-check completed successfully. ${NC}"
fi

# test ansible
ansible-playbook -i staging workstation.yml -vvvv --limit ${TARGET_SLAVE}
RC=$?
if [ ${RC} -ne 0 ]; then
  echo -e "${red} Sorry, playboook failed ${NC}"
  #exit 1
else
  echo -e "${green} playboook first try succeed. ${NC}"
  ansible-playbook -i staging workstation.yml -vvvv --limit ${TARGET_SLAVE} | grep -q 'unreachable=0.*failed=0' && (echo 'Main test: pass' && exit 0) || (echo 'Main test: fail' && exit 1)
  #./setup.sh
  #--extra-vars "jenkins_username=${JENKINS_USERNAME} jenkins_password=${JENKINS_PASSWORD}"
  #./setup.sh | grep -q 'changed=0.*failed=0' && (echo 'Idempotence test: pass' && exit 0) || (echo 'Idempotence test: fail' && exit 1)

  echo -e "${green} Ansible done. $? ${NC}"  
fi

cd ${WORKSPACE}/Scripts/shell

shellcheck *.sh -f checkstyle > checkstyle-result.xml || true
echo -e "${green} shell check done. $? ${NC}"

exit 0

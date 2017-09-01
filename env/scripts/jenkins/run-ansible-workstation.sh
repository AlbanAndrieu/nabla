#!/bin/bash
#set -xv

red='\e[0;31m'
green='\e[0;32m'
NC='\e[0m' # No Color

if [ -n "${TARGET_SLAVE}" ]; then
  echo -e "TARGET_SLAVE is defined \u1F44D"
else
  echo -e "${red} \u00BB Undefined build parameter: TARGET_SLAVE, use the default one ${NC}"
  export TARGET_SLAVE=albandri.misys.global.ad
fi

if [ -n "${DRY_RUN}" ]; then
  echo -e "DRY_RUN is defined \u1F44D"
else
  echo -e "${red} \u00BB Undefined build parameter: DRY_RUN, use the default one ${NC}"
  export DRY_RUN="--check"
fi

if [ -n "${TARGET_USER}" ]; then
  echo -e "TARGET_USER is defined \u1F44D"
else
  echo -e "${red} \u00BB Undefined build parameter: TARGET_USER, use the default one ${NC}"
  export TARGET_USER="jenkins"
fi

lsb_release -a

echo -e " ======= Running on ${TARGET_SLAVE} \u00A1 ${NC}"
echo "USER : $USER"
echo "HOME : $HOME"
echo "WORKSPACE : $WORKSPACE"

echo -e "${red} Find stale processes ${NC}"

find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps -edf
echo -e "${red} Killing stale grunt processes ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep grunt | awk '{ print $1 }' | sudo xargs kill
echo -e "${red} Killing stale google/chrome processes ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep google/chrome | awk '{ print $1 }' | sudo xargs kill
echo -e "${red} Killing stale chromedriver processes ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep chromedriver | awk '{ print $1 }' | sudo xargs kill
echo -e "${red} Killing stale selenium processes ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep selenium | awk '{ print $1 }' | sudo xargs kill
echo -e "${red} Killing stale zaproxy processes ${NC}"
find /proc -maxdepth 1 -user ${TARGET_USER} -type d -mmin +200 -exec basename {} \; | xargs ps | grep ZAPROXY | awk '{ print $1 }' | sudo xargs kill

echo -e "${red} Configure workstation ${NC}"

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

echo -e "${green} Checking version ${NC}"

python --version
pip --version
ansible --version
ansible-galaxy --version

#vagrant --version
#docker --version

cd ${WORKSPACE}/Scripts/ansible

echo -e "${green} Insalling roles version ${NC}"
ansible-galaxy install -r requirements.yml -p ./roles/ --ignore-errors

echo -e "${green} Display setup ${NC}"
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
ansible-playbook -i staging workstation.yml -vvvv --limit ${TARGET_SLAVE} ${DRY_RUN}
RC=$?
if [ ${RC} -ne 0 ]; then
  echo -e "${red} Sorry, playboook failed ${NC}"
  #exit 1
else
  echo -e "${green} playboook first try succeed. ${NC}"
  ansible-playbook -i staging workstation.yml -vvvv --limit ${TARGET_SLAVE} ${DRY_RUN} | grep -q 'unreachable=0.*failed=0' && (echo 'Main test: pass' && exit 0) || (echo 'Main test: fail' && exit 1)
  #./setup.sh
  #--extra-vars "jenkins_username=${JENKINS_USERNAME} jenkins_password=${JENKINS_PASSWORD}"
  #./setup.sh | grep -q 'changed=0.*failed=0' && (echo 'Idempotence test: pass' && exit 0) || (echo 'Idempotence test: fail' && exit 1)

  echo -e "${green} Ansible done. $? ${NC}"
fi

echo -e "${green} Ansible server summary ${NC}"
mkdir out
#ansible -i staging -m setup --user=root --tree out/ all
ansible -i production -m setup --user=root --tree out/ all
ansible-cmdb -i ./production out/ > overview.html
sudo cp overview.html /var/www/html/
#scp overview.html root@kgrdb01:/var/www/html
echo -e "${green} Ansible server summary done. $? ${NC}"

cd ${WORKSPACE}/Scripts/shell

shellcheck *.sh -f checkstyle > checkstyle-result.xml || true
echo -e "${green} shell check for shell done. $? ${NC}"

cd ${WORKSPACE}/Scripts/release
shellcheck *.sh -f checkstyle > checkstyle-result.xml || true
echo -e "${green} shell check for release done. $? ${NC}"

cd ${WORKSPACE}/Scripts/Python

pylint **/*.py
echo -e "${green} pyhton check for shell done. $? ${NC}"

#pyreverse -o png -p Pyreverse pylint/pyreverse/

exit 0

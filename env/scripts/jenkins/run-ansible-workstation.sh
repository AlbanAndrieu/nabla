#!/bin/bash
#set -xv

bold="\033[01m"
underline="\033[04m"
blink="\033[05m"

black="\033[30m"
red="\033[31m"
green="\033[32m"
yellow="\033[33m"
blue="\033[34m"
magenta="\033[35m"
cyan="\033[36m"
ltgray="\033[37m"

NC="\033[0m"

#double_arrow='\u00BB'
double_arrow='\xC2\xBB'
#head_skull='\u2620'
head_skull='\xE2\x98\xA0'
#happy_smiley='\u263A'
happy_smiley='\xE2\x98\xBA'
reverse_exclamation='\u00A1'

if [ -n "${TARGET_SLAVE}" ]; then
  echo -e "${green} TARGET_SLAVE is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : TARGET_SLAVE, use the default one ${NC}"
  export TARGET_SLAVE=albandri.misys.global.ad
fi

if [ -n "${TARGET_PLAYBOOK}" ]; then
  echo -e "${green} TARGET_PLAYBOOK is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : TARGET_PLAYBOOK, use the default one ${NC}"
  export TARGET_PLAYBOOK=workstation.yml
fi

if [ -n "${DRY_RUN}" ]; then
  echo -e "${green} DRY_RUN is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : DRY_RUN, use the default one ${NC}"
  export DRY_RUN="--check"
fi

if [ -n "${DOCKER_RUN}" ]; then
  echo -e "${green} DOCKER_RUN is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : DOCKER_RUN, use the default one ${NC}"
  export DOCKER_RUN=""
fi

lsb_release -a

echo -e " ======= Running on ${TARGET_SLAVE} ${reverse_exclamation} ${NC}"
echo "USER : $USER"
echo "HOME : $HOME"
echo "WORKSPACE : $WORKSPACE"

#export ANSIBLE_DEBUG=1

echo -e "${red} Configure workstation ${NC}"

#todo use virtualenv

echo "Switch to python 2.7 and ansible 2.1.1"
#scl enable python27 bash
#Enable python 2.7 and switch to ansible 2.1.1
#source /opt/rh/python27/enable

type -p ansible-playbook > /dev/null
if [ $? -ne 0 ]; then
    echo -e "Oops! ${head_skull} I cannot find ansible. Please be sure to install ansible before proceeding."
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

ansible --version|grep python

#Check winrm in target host
#winrm id
#winrm get winrm/config
#For oler version od Windows, please do
#Set-Item WSMan:\localhost\Shell\MaxMemoryPerShellMB 5000
#Set-Item WSMan:\localhost\Plugin\Microsoft.PowerShell\Quotas\MaxMemoryPerShellMB 5000
#Restart-Service winrm
#winrm set winrm/config/winrs '@{MaxMemoryPerShellMB="0"}'

#vagrant --version
#docker --version

cd ${WORKSPACE}/Scripts/ansible

echo -e "${green} Insalling roles version ${NC}"
ansible-galaxy install -r requirements.yml -p ./roles/ --ignore-errors

echo -e "${green} Display setup ${NC}"
ansible -m setup ${TARGET_SLAVE} -i staging -vvvv

# check quality
#ansible-lint ${TARGET_PLAYBOOK}

# check syntax
ansible-playbook -i staging -c local -v ${TARGET_PLAYBOOK} --limit ${TARGET_SLAVE} ${DRY_RUN} -vvvv --syntax-check --become-method=sudo
RC=$?
if [ ${RC} -ne 0 ]; then
  echo ""
  echo -e "${red} ${head_skull} Sorry, syntax-check failed ${NC}"
  exit 1
else
  echo -e "${green} The syntax-check completed successfully. ${NC}"
fi


# test ansible
if [ "${DOCKER_RUN}" == "" ]; then
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : DOCKER_RUN${NC}"
  #./setup.sh

  # test ansible
  ansible-playbook -i staging ${TARGET_PLAYBOOK} -vvvv --limit ${TARGET_SLAVE} ${DRY_RUN} --become-method=sudo
  RC=$?
  if [ ${RC} -ne 0 ]; then
    echo -e "${red} ${head_skull} Sorry, playboook failed ${NC}"
    #exit 1
  else
    echo -e "${green} playboook first try succeed. ${NC}"
    ansible-playbook -i staging ${TARGET_PLAYBOOK} -vvvv --limit ${TARGET_SLAVE} ${DRY_RUN} --become-method=sudo | grep -q 'unreachable=0.*failed=0' && (echo 'Main test: pass' && exit 0) || (echo 'Main test: fail' && exit 1)
    #./setup.sh
    #--extra-vars "jenkins_username=${JENKINS_USERNAME} jenkins_password=${JENKINS_PASSWORD}"
    #./setup.sh | grep -q 'changed=0.*failed=0' && (echo 'Idempotence test: pass' && exit 0) || (echo 'Idempotence test: fail' && exit 1)

    echo -e "${green} Ansible done. $? ${NC}"
  fi

else
  ./build.sh
fi

echo -e "${green} Ansible server summary ${NC}"
rm -Rf out || true
mkdir out
#ansible -i staging -m setup --user=root --tree out/ all
ansible -i production -m setup --user=root --tree out/ all
ansible-cmdb -i ./production out/ > overview.html
#sudo cp overview.html /var/www/html/
echo -e "${green} Ansible server summary done. $? ${NC}"

echo -e "${green} See http://${TARGET_SLAVE}/overview.html ${NC}"

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

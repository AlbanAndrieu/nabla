#!/bin/bash
#set -xve

source ./step-0-color.sh

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

if [ -n "${ANSIBLE_CMD}" ]; then
  echo -e "${green} ANSIBLE_CMD is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_CMD, use the default one ${NC}"
  export ANSIBLE_CMD="/usr/local/bin/ansible"
fi

if [ -n "${ANSIBLE_CMBD_CMD}" ]; then
  echo -e "${green} ANSIBLE_CMBD_CMD is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_CMBD_CMD, use the default one ${NC}"
  export ANSIBLE_CMBD_CMD="/usr/local/bin/ansible-cmdb"
fi

if [ -n "${ANSIBLE_GALAXY_CMD}" ]; then
  echo -e "${green} ANSIBLE_GALAXY_CMD is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_GALAXY_CMD, use the default one ${NC}"
  export ANSIBLE_GALAXY_CMD="/usr/local/bin/ansible-galaxy"
fi

if [ -n "${ANSIBLE_PLAYBOOK_CMD}" ]; then
  echo -e "${green} ANSIBLE_PLAYBOOK_CMD is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_PLAYBOOK_CMD, use the default one ${NC}"
  export ANSIBLE_PLAYBOOK_CMD="/usr/local/bin/ansible-playbook"
fi

lsb_release -a

echo -e " ======= Running on ${TARGET_SLAVE} ${reverse_exclamation} ${NC}"
echo "USER : $USER"
echo "HOME : $HOME"
echo "WORKSPACE : $WORKSPACE"

sudo service tomcat8 stop || true

#export ANSIBLE_DEBUG=1

echo -e "${red} Configure workstation ${NC}"

#todo use virtualenv

#echo "Switch to python 2.7 and ansible 2.1.1"
#scl enable python27 bash
#Enable python 2.7 and switch to ansible 2.1.1
#source /opt/rh/python27/enable

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Checking version ${NC}"

python --version
python2.7 --version
pip --version
pip2.7 --version
${ANSIBLE_CMD} --version
${ANSIBLE_CMD} --version | grep python
${ANSIBLE_GALAXY_CMD} --version
virtualenv --version

pip2.7 show docker-py
pip2.7 list --format=legacy | grep docker

#vagrant --version
docker version

#sudo pip2.7 install -r requirements.txt
#pip2.7 freeze > requirements.txt

#Check winrm in target host
#winrm id
#winrm get winrm/config
#For oler version od Windows, please do
#Set-Item WSMan:\localhost\Shell\MaxMemoryPerShellMB 5000
#Set-Item WSMan:\localhost\Plugin\Microsoft.PowerShell\Quotas\MaxMemoryPerShellMB 5000
#Restart-Service winrm
#winrm set winrm/config/winrs '@{MaxMemoryPerShellMB="0"}'

if [ -d "${WORKSPACE}/env/scripts/jenkins" ]; then
  cd "${WORKSPACE}/env/scripts/jenkins"
fi

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Insalling roles version ${NC}"
${ANSIBLE_GALAXY_CMD} install -r requirements.yml -p ./roles/ --ignore-errors --force

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Display setup ${NC}"
${ANSIBLE_CMD} -m setup ${TARGET_SLAVE} -i staging -vvvv

exit 0

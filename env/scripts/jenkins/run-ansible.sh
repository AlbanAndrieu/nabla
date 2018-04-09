#!/bin/bash
#set -xve

#export bold="\033[01m"
#export underline="\033[04m"
#export blink="\033[05m"

#export black="\033[30m"
export red="\033[31m"
export green="\033[32m"
#export yellow="\033[33m"
#export blue="\033[34m"
export magenta="\033[35m"
export cyan="\033[36m"
#export ltgray="\033[37m"

export NC="\033[0m"

#double_arrow='\xC2\xBB'
export head_skull='\xE2\x98\xA0'
export happy_smiley='\xE2\x98\xBA'
export reverse_exclamation='\u00A1'

case "$OSTYPE" in
  linux*)   SYSTEM=LINUX;;
  darwin*)  SYSTEM=OSX;;
  win*)     SYSTEM=Windows;;
  cygwin*)  SYSTEM=Cygwin;;
  msys*)    SYSTEM=MSYS;;
  bsd*)     SYSTEM=BSD;;
  solaris*) SYSTEM=SOLARIS;;
  *)        SYSTEM=UNKNOWN;;
esac
echo "SYSTEM : ${SYSTEM}"

if [ -f /etc/os-release ]; then
    # freedesktop.org and systemd
    . /etc/os-release
    OS=$NAME
    VER=$VERSION_ID
elif type lsb_release >/dev/null 2>&1; then
    # linuxbase.org
    OS=$(lsb_release -si)
    VER=$(lsb_release -sr)
elif [ -f /etc/lsb-release ]; then
    # For some versions of Debian/Ubuntu without lsb_release command
    . /etc/lsb-release
    OS=$DISTRIB_ID
    VER=$DISTRIB_RELEASE
elif [ -f /etc/debian_version ]; then
    # Older Debian/Ubuntu/etc.
    OS=Debian
    VER=$(cat /etc/debian_version)
elif [ -f /etc/SuSe-release ]; then
    # Older SuSE/etc.
    ...
elif [ -f /etc/redhat-release ]; then
    # Older Red Hat, CentOS, etc.
    ...
else
    # Fall back to uname, e.g. "Linux <version>", also works for BSD, etc.
    OS=$(uname -s)
    VER=$(uname -r)
fi
echo "OS : ${OS}"
echo "VER : ${VER}"

if [ -n "${TARGET_SLAVE}" ]; then
  echo -e "${green} TARGET_SLAVE is defined ${happy_smiley} : ${TARGET_SLAVE} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : TARGET_SLAVE, use the default one ${NC}"
  export TARGET_SLAVE=albandri.misys.global.ad
  echo -e "${magenta} TARGET_SLAVE : ${TARGET_SLAVE} ${NC}"
fi

if [ -n "${TARGET_PLAYBOOK}" ]; then
  echo -e "${green} TARGET_PLAYBOOK is defined ${happy_smiley} : ${TARGET_PLAYBOOK} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : TARGET_PLAYBOOK, use the default one ${NC}"
  export TARGET_PLAYBOOK=workstation.yml
  echo -e "${magenta} TARGET_PLAYBOOK : ${TARGET_PLAYBOOK} ${NC}"
fi

if [ -n "${DRY_RUN}" ]; then
  echo -e "${green} DRY_RUN is defined ${happy_smiley} : ${DRY_RUN} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : DRY_RUN, use the default one ${NC}"
  export DRY_RUN="--check"
  echo -e "${magenta} DRY_RUN : ${DRY_RUN} ${NC}"
fi

if [ -n "${DOCKER_RUN}" ]; then
  echo -e "${green} DOCKER_RUN is defined ${happy_smiley} : ${DOCKER_RUN} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : DOCKER_RUN, use the default one ${NC}"
  export DOCKER_RUN=""
  echo -e "${magenta} DOCKER_RUN : ${DOCKER_RUN} ${NC}"
fi

if [ -n "${PYTHON_CMD}" ]; then
  echo -e "${green} PYTHON_CMD is defined ${happy_smiley} : ${PYTHON_CMD} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : PYTHON_CMD, use the default one ${NC}"
  #/usr/local/bin/python3.5 for RedHat
  #/usr/bin/python3.5 for Ubuntu
  if [ "${OS}" == "Red Hat Enterprise Linux Server" ]; then
    PYTHON_CMD="/usr/local/bin/python3.5"
  else
    PYTHON_CMD="/usr/bin/python3.5"
  fi
  export PYTHON_CMD
  echo -e "${magenta} PYTHON_CMD : ${PYTHON_CMD} ${NC}"
fi

if [ -n "${ANSIBLE_INVENTORY}" ]; then
  echo -e "${green} ANSIBLE_INVENTORY is defined ${happy_smiley} : ${ANSIBLE_INVENTORY} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_INVENTORY, use the default one ${NC}"
  export ANSIBLE_INVENTORY="staging"
  echo -e "${magenta} ANSIBLE_INVENTORY : ${ANSIBLE_INVENTORY} ${NC}"
fi

if [ -n "${ANSIBLE_CMD}" ]; then
  echo -e "${green} ANSIBLE_CMD is defined ${happy_smiley} : ${ANSIBLE_CMD} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_CMD, use the default one ${NC}"
  #/usr/bin/ansible for RedHat
  #/usr/local/bin/ansible for Ubuntu
  if [ "${OS}" == "Ubuntu" ]; then
    ANSIBLE_CMD="${PYTHON_CMD} /usr/local/bin/ansible"
  else
    ANSIBLE_CMD="${PYTHON_CMD} /usr/bin/ansible"
  fi
  export ANSIBLE_CMD
  echo -e "${magenta} ANSIBLE_CMD : ${ANSIBLE_CMD} ${NC}"
fi

if [ -n "${ANSIBLE_CMBD_CMD}" ]; then
  echo -e "${green} ANSIBLE_CMBD_CMD is defined ${happy_smiley} : ${ANSIBLE_CMBD_CMD} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_CMBD_CMD, use the default one ${NC}"
  #/usr/bin/ansible-cmdb for RedHat
  #/usr/local/bin/ansible-cmdb for Ubuntu
  if [ "${OS}" == "Ubuntu" ]; then
    ANSIBLE_CMBD_CMD="/usr/local/bin/ansible-cmdb"
  else
    ANSIBLE_CMBD_CMD="/usr/bin/ansible-cmdb"
  fi
  export ANSIBLE_CMBD_CMD
  echo -e "${magenta} ANSIBLE_CMBD_CMD : ${ANSIBLE_CMBD_CMD} ${NC}"
fi

if [ -n "${ANSIBLE_GALAXY_CMD}" ]; then
  echo -e "${green} ANSIBLE_GALAXY_CMD is defined ${happy_smiley} : ${ANSIBLE_GALAXY_CMD} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_GALAXY_CMD, use the default one ${NC}"
  #/usr/bin/ansible-galaxy for RedHat
  #/usr/local/bin/ansible-galaxy for Ubuntu
  if [ "${OS}" == "Ubuntu" ]; then
    ANSIBLE_GALAXY_CMD="${PYTHON_CMD} /usr/local/bin/ansible-galaxy"
  else
    ANSIBLE_GALAXY_CMD="${PYTHON_CMD} /usr/bin/ansible-galaxy"
  fi
  export ANSIBLE_GALAXY_CMD
  echo -e "${magenta} ANSIBLE_GALAXY_CMD : ${ANSIBLE_GALAXY_CMD} ${NC}"
fi

if [ -n "${ANSIBLE_PLAYBOOK_CMD}" ]; then
  echo -e "${green} ANSIBLE_PLAYBOOK_CMD is defined ${happy_smiley} : ${ANSIBLE_PLAYBOOK_CMD} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_PLAYBOOK_CMD, use the default one ${NC}"
  #/usr/bin/ansible-playbook for RedHat
  #/usr/local/bin/ansible-playbook for Ubuntu
  if [ "${OS}" == "Ubuntu" ]; then
    ANSIBLE_PLAYBOOK_CMD="${PYTHON_CMD} /usr/local/bin/ansible-playbook"
  else
    ANSIBLE_PLAYBOOK_CMD="${PYTHON_CMD} /usr/bin/ansible-playbook"
  fi
  export ANSIBLE_PLAYBOOK_CMD
  echo -e "${magenta} ANSIBLE_PLAYBOOK_CMD : ${ANSIBLE_PLAYBOOK_CMD} ${NC}"
fi

if [ -n "${ANSIBLE_LINT_CMD}" ]; then
  echo -e "${green} ANSIBLE_LINT_CMD is defined ${happy_smiley} : ${ANSIBLE_LINT_CMD} ${NC}"
else
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : ANSIBLE_LINT_CMD, use the default one ${NC}"
  #/usr/bin/ansible-lint for RedHat
  #/usr/local/bin/ansible-lint for Ubuntu
  if [ "${OS}" == "Ubuntu" ]; then
    ANSIBLE_LINT_CMD="${PYTHON_CMD} /usr/local/bin/ansible-lint"
  else
    ANSIBLE_LINT_CMD="${PYTHON_CMD} /usr/bin/ansible-lint"
  fi
  export ANSIBLE_LINT_CMD
  echo -e "${magenta} ANSIBLE_LINT_CMD : ${ANSIBLE_LINT_CMD} ${NC}"
fi

lsb_release -a

# DOCKER
export DOCKER_CLIENT_TIMEOUT=240
export COMPOSE_HTTP_TIMEOUT=2000

echo -e " ======= Running on ${TARGET_SLAVE} ${reverse_exclamation} ${NC}"
echo "USER : $USER"
echo "HOME : $HOME"
echo "WORKSPACE : $WORKSPACE"

echo "DOCKER_CLIENT_TIMEOUT : $DOCKER_CLIENT_TIMEOUT"
echo "COMPOSE_HTTP_TIMEOUT : $COMPOSE_HTTP_TIMEOUT"

#tomcat8 must be stop to no use same port
sudo service tomcat8 stop || true

echo -e "${red} Configure workstation ${NC}"

echo -e "${cyan} Use virtual env /opt/ansible/env35/bin/activate ${NC}"
#echo "Switch to python 2.7 and ansible 2.1.1"
#scl enable python27 bash
#Enable python 2.7 and switch to ansible 2.1.1
#source /opt/rh/python27/enable

#sudo virtualenv -p /usr/bin/python3.5 /opt/ansible/env35

source /opt/ansible/env35/bin/activate || exit 2

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Install virtual env requiremnts ${NC}"
sudo -H pip3.5 install -r roles/jenkins-slave/files/requirements-minimal-current-3.5.txt || exit 2

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Checking docker-compose version ${NC}"

docker-compose --version
RC=$?
if [ ${RC} -ne 0 ]; then
  echo ""
  echo -e "${red} ${head_skull} Sorry, docker-compose failed ${NC}"
  exit 1
else
  echo -e "${green} The docker-compose check completed successfully. ${NC}"
fi

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Checking python version ${NC}"

ansible --version | grep python || true

python --version || true
pip --version || true
${ANSIBLE_CMD} --version || true
${ANSIBLE_GALAXY_CMD} --version || true
virtualenv --version || true

#vagrant --version
docker version || true

echo -e "${green} Checking python 2.7 version ${NC}"

python2.7 --version || true
pip2.7 --version || true

#pip2.7 show docker-py || true
sudo -H pip2.7 list --format=legacy | grep docker || true

#sudo pip2.7 -H install -r requirements-current-2.7.txt
sudo -H pip2.7 freeze > requirements-2.7.txt

echo -e "${green} Checking python 3.5 version ${NC}"

python3 --version || true
pip3 --version || true
python3.5 --version || true
pip3.5 --version || true

#pip3.5 show docker-py || true
sudo -H pip3.5 list --format=legacy | grep docker || true

#sudo pip3.5 -H install -r requirements-current-3.5.txt
sudo -H pip3.5 freeze > requirements-3.5.txt

if [ -d "${WORKSPACE}/ansible" ]; then
  cd "${WORKSPACE}/ansible"
fi

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Insalling roles version ${NC}"
echo -e "${magenta} ${ANSIBLE_GALAXY_CMD} install -r requirements.yml -p ./roles/ --ignore-errors --force ${NC}"
${ANSIBLE_GALAXY_CMD} install -r requirements.yml -p ./roles/ --ignore-errors --force

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Display setup ${NC}"
echo -e "${magenta} ${ANSIBLE_CMD} -m setup ${TARGET_SLAVE} -i ${ANSIBLE_INVENTORY} -vvvv ${NC}"
${ANSIBLE_CMD} -m setup ${TARGET_SLAVE} -i ${ANSIBLE_INVENTORY} -vvvv

#exit 0

#!/bin/bash
#set -xve

export TARGET_PLAYBOOK=docker-container.yml
#export TARGET_SLAVE=albandri.misys.global.ad
export TARGET_SLAVE=FR1CSLFRBM0019.misys.global.ad

source ./run-ansible.sh

# check quality
#ansible-lint ${TARGET_PLAYBOOK}

# check syntax
echo -e "${cyan} =========== ${NC}"
echo -e "${green} Starting the syntax-check. ${NC}"
${ANSIBLE_PLAYBOOK_CMD} -i ${ANSIBLE_INVENTORY} -c local -v ${TARGET_PLAYBOOK} --limit ${TARGET_SLAVE} ${DRY_RUN} -vvvv --syntax-check --become-method=sudo
RC=$?
if [ ${RC} -ne 0 ]; then
  echo ""
  echo -e "${red} ${head_skull} Sorry, syntax-check failed ${NC}"
  exit 1
else
  echo -e "${green} The syntax-check completed successfully. ${NC}"
fi

if [ -d "${WORKSPACE}/ansible" ]; then
  cd "${WORKSPACE}/ansible"
fi

# check quality
#${ANSIBLE_LINT_CMD} ${TARGET_PLAYBOOK}

# check syntax
#${ANSIBLE_PLAYBOOK_CMD} -i ${ANSIBLE_INVENTORY} -c local -v ${TARGET_PLAYBOOK} --limit ${TARGET_SLAVE} -vvvv --syntax-check

# test ansible
# --ask-sudo-pass
${ANSIBLE_PLAYBOOK_CMD} -i ${ANSIBLE_INVENTORY} -c local -v ${TARGET_PLAYBOOK} --limit ${TARGET_SLAVE} --become-method=sudo -vvvv -e 'ansible_python_interpreter=/usr/bin/python3'

#deactivate

#sleep 20m

docker ps


exit 0

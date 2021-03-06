#!/bin/bash
#set -xve

if [ -d "${WORKSPACE}/ansible" ]; then
  cd "${WORKSPACE}/ansible"
fi

source ./run-ansible.sh

# check quality
#ansible-lint ${TARGET_PLAYBOOK}

# check syntax
echo -e "${cyan} =========== ${NC}"
echo -e "${green} Starting the syntax-check. ${NC}"
echo -e "${magenta} ${ANSIBLE_PLAYBOOK_CMD} -i ${ANSIBLE_INVENTORY} -v ${TARGET_PLAYBOOK} --limit ${TARGET_SLAVE} ${DRY_RUN} -vvvv --syntax-check --become-method=sudo ${NC}"
${ANSIBLE_PLAYBOOK_CMD} -i ${ANSIBLE_INVENTORY} -v ${TARGET_PLAYBOOK} --limit ${TARGET_SLAVE} ${DRY_RUN} -vvvv --syntax-check --become-method=sudo
RC=$?
if [ ${RC} -ne 0 ]; then
  echo ""
  echo -e "${red} ${head_skull} Sorry, syntax-check failed ${NC}"
  exit 1
else
  echo -e "${green} The syntax-check completed successfully. ${NC}"
fi

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Starting the playbook. ${NC}"
if [ "${DOCKER_RUN}" == "" ]; then
  echo -e "${red} \u00BB Undefined build parameter ${head_skull} : DOCKER_RUN${NC}"
  ./setup.sh
else
  ./build.sh
fi

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Ansible server inventory ${NC}"
rm -Rf out || true
mkdir out
echo -e "${magenta} ${ANSIBLE_CMD} -i ${ANSIBLE_INVENTORY} -m setup --user=root -vvv --tree out/ all ${NC}"
${ANSIBLE_CMD} -i ${ANSIBLE_INVENTORY} -m setup --user=root -vvv --tree out/ all
RC=$?
if [ ${RC} -ne 0 ]; then
  echo ""
  echo -e "${red} ${head_skull} Sorry, inventory failed ${NC}"
  #exit 1
else
  echo -e "${green} The inventory completed successfully. ${NC}"
fi

echo -e "${cyan} =========== ${NC}"
echo -e "${green} Ansible server inventory HTML generation ${NC}"
echo -e "${magenta} ${ANSIBLE_CMBD_CMD} -i ./${ANSIBLE_INVENTORY} out/ > overview.html ${NC}"
${ANSIBLE_CMBD_CMD} -i ./${ANSIBLE_INVENTORY} out/ > overview.html
#sudo cp overview.html /var/www/html/
echo -e "${green} Ansible server summary done. $? ${NC}"

echo -e "${green} See http://${TARGET_SLAVE}/overview.html ${NC}"

cd "${WORKSPACE}/bm/Scripts/shell"

echo -e "${cyan} =========== ${NC}"
shellcheck ./*.sh -f checkstyle > checkstyle-result.xml || true
echo -e "${green} shell check for shell done. $? ${NC}"

echo -e "${cyan} =========== ${NC}"
cd "${WORKSPACE}/bm/Scripts/release"
shellcheck ./*.sh -f checkstyle > checkstyle-result.xml || true
echo -e "${green} shell check for release done. $? ${NC}"

echo -e "${cyan} =========== ${NC}"
cd "${WORKSPACE}/bm/Scripts/Python"
pylint ./**/*.py
echo -e "${green} pyhton check for shell done. $? ${NC}"

#pyreverse -o png -p Pyreverse pylint/pyreverse/

exit 0

#!/bin/bash
set -xv
echo "USER : $USER"
echo "HOME : $HOME"
echo "WORKSPACE : $WORKSPACE"

echo "Configure Jenkins slaves"

ansible --version
python --version

cd ./Scripts/ansible

vagrant box list

# shutdown vms
VBoxManage controlvm hosttest0 poweroff
VBoxManage controlvm hosttest1 poweroff
VBoxManage controlvm hosttest2 poweroff

# delete vms
VBoxManage unregistervm hosttest0 -delete
VBoxManage unregistervm hosttest1 -delete
VBoxManage unregistervm hosttest2 -delete

# clean vagrant
vagrant destroy --force

# rebuild vagrant
vagrant up
vagrant status

sshpass -f /jenkins/pass.txt ssh-copy-id vagrant@192.168.33.10
sshpass -f /jenkins/pass.txt ssh-copy-id vagrant@192.168.33.11
sshpass -f /jenkins/pass.txt ssh-copy-id vagrant@192.168.33.12

# test ansible
ansible-playbook -i hosts jenkins-slave.yml -vvvv
#--extra-vars "jenkins_username=${JENKINS_USERNAME} jenkins_password=${JENKINS_PASSWORD}"
#ansible-playbook -i hosts jenkins-slave.yml -vvvv | grep -q 'changed=0.*failed=0' && (echo 'Idempotence test: pass' && exit 0) || (echo 'Idempotence test: fail' && exit 1)

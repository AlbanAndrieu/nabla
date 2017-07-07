#!/bin/bash
set -xv

#See https://nickcharlton.net/posts/automating-macos-using-ansible.html
#See https://blog.vandenbrand.org/2016/01/04/how-to-automate-your-mac-os-x-setup-with-ansible/

#Download xcode from https://developer.apple.com/download/

sudo xcodebuild -license
sudo xcode-select --install
sudo xcode-select -p
sudo CFLAGS=-Qunused-arguments CPPFLAGS=-Qunused-arguments pip install ansible

launchctl limit maxfiles
sudo launchctl limit maxfiles 1024 unlimited

launchctl limit maxfiles
ulimit -n

git clone https://github.com/geerlingguy/mac-dev-playbook
cd mac-dev-playbook

ansible-galaxy install -r requirements.yml
ansible-playbook main.yml -i inventory -K

#Download Mac port from https://www.macports.org/install.php
sudo port -v selfupdate

port list | grep wget
sudo port -t install wget

#See https://github.com/geerlingguy/mac-dev-playbook
git clone https://github.com/geerlingguy/mac-dev-playbook
cd mac-dev-playbook
ansible-galaxy install -r requirements.yml
ansible-playbook main.yml -i inventory -K

#Jenkins
#See https://wiki.jenkins.io/display/JENKINS/Thanks+for+using+OSX+Installer

sudo defaults read /Library/LaunchDaemons/org.jenkins-ci
sudo defaults write /Library/LaunchDaemons/org.jenkins-ci httpPort 8380
sudo defaults write /Library/LaunchDaemons/org.jenkins-ci prefix /jenkins

#sudo chmod u+x /Library/LaunchDaemons/org.jenkins-ci.plist
sudo chown jenkins /var/log/jenkins
#sudo chmod 755 /var/log/jenkins
#sudo chown root /var/log/jenkins
sudo chown jenkins:jenkins /Users/Shared/Jenkins
#sudo chmod +wr /Users/Shared/Jenkins
sudo launchctl unload /Library/LaunchDaemons/org.jenkins-ci.plist
sudo launchctl load /Library/LaunchDaemons/org.jenkins-ci.plist
#launchctl start /Library/LaunchDaemons/org.jenkins-ci.plist

/Library/Application Support/Jenkins/jenkins-runner.sh

#See http://www.cimgf.com/2015/05/26/setting-up-jenkins-ci-on-a-mac-2/
#See https://blog.samsao.co/how-to-setup-a-jenkins-slave-running-mac-os-x-for-ios-projects-part-1-2937502ce90b

exit 0

#!/bin/bash
set -xv

#See https://nickcharlton.net/posts/automating-macos-using-ansible.html
#See https://blog.vandenbrand.org/2016/01/04/how-to-automate-your-mac-os-x-setup-with-ansible/

#Download xcode from https://developer.apple.com/download/

pkgutil --pkg-info=com.apple.pkg.CLTools_Executables

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
sw_vers -productVersion
#wget https://github.com/macports/macports-base/releases/download/v2.4.2/MacPorts-2.4.2-10.12-Sierra.pkg
wget https://distfiles.macports.org/MacPorts/MacPorts-2.4.3-10.13-HighSierra.pkg
#sudo installer -pkg MacPorts-2.4.2-10.12-Sierra.pkg -target /
sudo installer -pkg MacPorts-2.4.3-10.13-HighSierra.pkg -target /
sudo /opt/local/bin/port version

#less /opt/local/etc/macports/macports.conf
sudo nano /opt/local/etc/macports/sources.conf
#switch to
#file:///Users/admin/Downloads/ports.tar [default]
#then
#file:////opt/local/var/macports/portdirs/ports/ [default]

sudo /opt/local/bin/port -v selfupdate

sudo /opt/local/bin/port list | grep wget
sudo /opt/local/bin/port -t install wget
sudo /opt/local/bin/port install openssl
#sudo port install xorg-server
sudo /opt/local/bin/port install py-ansible

#Upgrade macport
/opt/local/bin/port -qv installed > myports.txt
/opt/local/bin/port echo requested | cut -d ' ' -f 1 > requested.txt

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

#Import certificates
/usr/libexec/java_home
/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home
sudo keytool -importcert -alias dev -file UK1VSWCERT01-CA-5.crt -keystore /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/security/cacerts

#Sleep
#http://osxdaily.com/2015/02/03/set-or-disable-sleep-due-to-mac-system-inactivity-from-the-command-line-in-os-x/
sudo systemsetup -getcomputersleep
sudo systemsetup -setcomputersleep Never

#On Issue : xcrun: error: unable to exec Xcode native xcrun (Permission denied)
#xcrun --show-sdk-path
#xcode-select --reset

#See https://embeddedartistry.com/blog/2017/2/20/installing-clangllvm-on-osx
#brew info llvm
#brew doctor
#brew install llvm
#brew install --with-toolchain llvm
#which scan-build
#echo 'export PATH="/usr/local/opt/llvm/bin:$PATH"' >> ~/.bash_profile

#sudo mv /opt/local ~/macports

exit 0

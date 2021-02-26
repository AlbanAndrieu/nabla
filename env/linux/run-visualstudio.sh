#!/bin/bash
set -xv

./run-database.sh

sudo snap install code --classic

#wget -qO - https://gitlab.com/paulcarroty/vscodium-deb-rpm-repo/raw/master/pub.gpg | sudo apt-key add -
#echo 'deb https://paulcarroty.gitlab.io/vscodium-deb-rpm-repo/debs/ vscodium main' | sudo tee --append /etc/apt/sources.list.d/vscodium.list
#sudo apt update && sudo apt install vscodium

sudo nano /etc/sysctl.conf
fs.inotify.max_user_watches=524288

code --install-extension ms-vscode.cpptools austin.code-gnu-global twxs.cmake ms-vscode.cmake-tools fireblackhat.conan-tools ms-azuretools.vscode-docker ms-python.python
code --install-extension james-yu.latex-workshop tecosaur.latex-u tilities
code --install-extension vscjava.vscode-java-pack redhat.vscode-xml
code --install-extension sonarsource.sonarlint-vscode
code --install-extension msjsdiag.debugger-for-chrome
code --install-extension ms-python.python
code --install-extension ansenhuang.vscode-view-readme
code --install-extension janjoerke.jenkins-pipeline-linter-connector
#ext install janjoerke.jenkins-pipeline-linter-connector
code --install-extension madhavd1.javadoc-tools
code --install-extension joaompinto.vscode-graphviz

# See ~/.config/Code/User/settings.json
#    "java.home": "/usr/lib/jvm/java-14-oracle/"

#Needed for pytest when using (visual studio) code
export PYTHONPATH=hooks:$PYTHONPATH
code .

exit 0

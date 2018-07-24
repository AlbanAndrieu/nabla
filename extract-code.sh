#!/bin/bash
set -xv

#git clone https://github.com/AlbanAndrieu/nabla.git nabla

git pull && git submodule init && git submodule update && git submodule status
#git fetch --recurse-submodules
#git submodule foreach git fetch
git submodule foreach git pull origin master
git submodule foreach git checkout master

#git submodule add https://github.com/AlbanAndrieu/nabla-build-tools.git build-tools
#git submodule add https://github.com/AlbanAndrieu/nabla-maven.git maven
#git submodule add https://github.com/AlbanAndrieu/nabla-uml.git uml
#git submodule add https://github.com/AlbanAndrieu/nabla-servers.git servers
#git submodule add https://github.com/AlbanAndrieu/nabla-databases.git databases
#git submodule add https://github.com/AlbanAndrieu/nabla-projects.git projects
#git submodule add https://github.com/AlbanAndrieu/nabla-andromda.git andromda
##git submodule add https://github.com/AlbanAndrieu/nabla-servers-bower.git bower
##git submodule add https://github.com/AlbanAndrieu/nabla-servers-bower-sample.git bower-sample
##git submodule add https://github.com/AlbanAndrieu/nabla-cpp.git cpp

exit 0

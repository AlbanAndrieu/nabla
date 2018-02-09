#!/bin/bash
#set -xv

#See https://docs.travis-ci.com/user/environment-variables/

sudo gem install travis
/usr/local/bin/travis encrypt SOMEVAR="secretvalue" --add

travis pubkey

echo "https://api.travis-ci.org/repos/AlbanAndrieu/nabla-cpp/key"

exit 0

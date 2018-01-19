#!/bin/bash
#set -xv

#https://github.com/icebreaker/scolorizer

#See https://bitbucket.org/scons/scons/wiki/SconsToolbox
#See https://bitbucket.org/scons/scons/wiki/SconsRecipes

#Add https://bitbucket.org/scons/scons/wiki/BashCompletion

#See https://github.com/ja11sop/cuppa

sudo apt install ubuntu-dev-tools
reverse-depends -b scons

#See http://www.cs.virginia.edu/~dww4s/tools/scons2dot/

#Debug
/sbin/ldconfig -p | grep stdc++ || true
#file /lib/x86_64-linux-gnu/libcrypto.so.1.0.0
#readelf -Ws /usr/lib/x86_64-linux-gnu/libstdc++.so.5.0.7 | grep '^\([[:space:]]\+[^[:space:]]\+\)\{6\}[[:space:]]\+[[:digit:]]\+'
readelf -Ws /lib/x86_64-linux-gnu/libcrypto.so.1.0.0 | grep '^\([[:space:]]\+[^[:space:]]\+\)\{6\}[[:space:]]\+[[:digit:]]\+' | grep EVP_cast5_cbc
nm -C -D /lib/x86_64-linux-gnu/libcrypto.so.1.0.0 | grep EVP_cast5_cbc
nm -C -D ./x86Linux/misc-OLD/lib/libcrypto.so.6 | grep EVP_cast5_cbc
nm -C -D ./x86Linux/openssl-0.9.8-OLD/lib/libcrypto.so.0.9.8 | grep EVP_cast5_cbc
nm --demangle --dynamic --defined-only --extern-only /lib/x86_64-linux-gnu/libcrypto.so.1.0.0 | grep EVP_cast5_cbc

apt-cache policy libcppunit-dev

ecit 0

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

#RPATH
objdump -x /lib/x86_64-linux-gnu/libcrypto.so.1.0.0 |grep RPATH
readelf -d /lib/x86_64-linux-gnu/libcrypto.so.1.0.0 |head -20

export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:3rdparties/x86Linux/misc-OLD/lib
ld -L3rdparties/x86Linux/misc-OLD/lib -lssl --verbose
#ld -Bstatic -L3rdparties/x86Linux/misc-OLD/lib -lssl --verbose

#Check flag LINKFLAGS
#'-Wl,--as-needed'
ldd -u -r target/lib/x86Linux/debug64/shared/libmain_library.so
#
#'-Wl,--no-as-needed'
#Unused direct dependencies:
#	/usr/lib/x86_64-linux-gnu/libboost_thread.so.1.58.0
#	/usr/lib/x86_64-linux-gnu/libboost_date_time.so.1.58.0
#	/lib/x86_64-linux-gnu/libm.so.6

ldd -u -r target/bin/x86Linux/run_app
#nused direct dependencies:
#	/usr/lib/x86_64-linux-gnu/libboost_thread.so.1.58.0
#	/usr/lib/x86_64-linux-gnu/libboost_date_time.so.1.58.0
#	/usr/lib/x86_64-linux-gnu/libboost_system.so.1.58.0
#	/workspace/users/albandri30/nabla-cpp/target/lib/x86Linux/debug64/shared/libmain_library.so
#	/lib/x86_64-linux-gnu/libm.so.6

#nm --demangle --dynamic --defined-only --extern-only target/lib/x86Linux/debug64/shared/libmain_library.so
readelf -d target/bin/x86Linux/run_app |head -20
# See tuto https://undo.io/resources/gdb-watchpoint/build-for-debug-in-gdb/
readelf --debug-dump target/bin/x86Linux/run_app | less
readelf --debug-dump=loc target/bin/x86Linux/run_app | less

#sudo yum update glibc
ldd --version

openssl version -a

yum whatprovides */libcrypto.so.10

ldconfig -p | grep libssl

#gcc/g++ linking is sensitive to order and that your linked libraries must follow the things that depend upon them.
#For instance -lssh2 -lssl -lcrypto -llber -lldap -lz -ldl

apt-cache policy libcppunit-dev

ecit 0

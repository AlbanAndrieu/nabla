#!/bin/bash
set -xv

pkg install python27
pkg install py27-pip
pkg install python

pkg install scons
pkg install cmake
cd /usr/ports/devel/doxygen/ && make install clean
pkg install doxygen

cd /usr/ports && make search name=clang
#Port:	lang/clang38
#Moved:	devel/llvm90
# TODO llvm80-8.0.1_3.txz
cd /usr/ports/devel/llvm90 && make install clean
pkg install llvm90
pkg install gcc
#-Wl,-rpath=/usr/local/lib/gcc9

pkg install git

pkg install cppcheck rats java-findbugs flawfinder gperf
pkg install hs-ShellCheck

pkg install gnuplot

pkg install p5-LaTeXML
pkg install lzlib libxml2
pkg install boost-all boost-libs

exit 0

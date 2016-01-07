#sudo apt-get install ocaml ocaml-native-compilers camlp4-extra opam

#http://clang-analyzer.llvm.org/installation.html
cd /workspace
sudo svn co http://llvm.org/svn/llvm-project/llvm/trunk llvm
cd llvm/tools
sudo svn co http://llvm.org/svn/llvm-project/cfe/trunk clang
cd ../..
cd llvm/tools/clang/tools
sudo svn co http://llvm.org/svn/llvm-project/clang-tools-extra/trunk extra
cd ../../../..
cd llvm/projects
sudo svn co http://llvm.org/svn/llvm-project/compiler-rt/trunk compiler-rt
cd ../..
cd llvm/projects
sudo svn co http://llvm.org/svn/llvm-project/libcxx/trunk libcxx
cd ../..
sudo mkdir build
cd build
sudo cmake -G "Unix Makefiles" ../llvm
sudo nohup make
#clang --help

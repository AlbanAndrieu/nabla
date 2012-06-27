@echo off
@echo file: cmake.bat
C:
chdir C:\cygwin\bin

@echo WORKSPACE %WORKSPACE%
@echo /cygdrive/c/hudson/jobs/Nabla-CMake-Bat/workspace/ktpplus/build-cygwin/infra/build.sh

bash --login -i /cygdrive/c/hudson/jobs/Nabla-CMake-Bat/workspace/cpp/sample/build-cygwin/build.sh

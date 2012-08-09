@echo off
@echo file: cmake.bat
C:
chdir C:\cygwin\bin

@echo WORKSPACE %WORKSPACE%
@echo %WORKSPACE%/cpp/sample/build-cygwin/build.sh

bash --login -i %WORKSPACE%/cpp/sample/build-cygwin/build.sh

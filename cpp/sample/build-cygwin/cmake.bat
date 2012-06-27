@echo off
@echo file: cmake.bat
C:
chdir C:\cygwin\bin

@echo WORKSPACE %WORKSPACE%
@echo %WORKSPACE%/sample/build-cygwin/build.sh

bash --login -i %WORKSPACE%/sample/build-cygwin/build.sh

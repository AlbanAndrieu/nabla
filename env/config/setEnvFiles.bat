@echo off
@echo file: setEnvFiles.bat
C:
chdir C:\cygwin\bin

@echo ./setEnvFiles.allUserDev.sh ./profiles/albandri.dev.properties

bash --login -i ./setEnvFiles.allUserDev.sh ./profiles/albandri.dev.properties

@echo off
@echo file: setEnvFiles.bat
C:
chdir C:\cygwin\bin

@echo ./env/config/setEnvFiles.allUserDev.sh ./env/config/profiles/albandri10.cygwin.properties

bash --login -i ./env/config/setEnvFiles.allUserDev.sh ./env/config/profiles/albandri10.cygwin.properties

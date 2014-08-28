
#reinstall wine
sudo add-apt-repository ppa:ubuntu-wine/ppa
sudo apt-get update
sudo apt-get upgrade # got me wine 1.3.32, but not working
rm -rf ~/.wine # wipe out entire wine directory before downgrading
sudo apt-get install wine1.2 # done :)
sudo apt-get build-dep wine

#install Bridgit client
wine BridgitLoader.exe

#Then access inside
wine /workspace/users/albandri10/.wine/drive_c/users/albandri/Application\ Data/SMART\ Technologies/Bridgit/4.6.206.0/Bridgit.exe
wineconsole /workspace/users/albandri10/.wine/drive_c/users/albandri/Application\ Data/SMART\ Technologies/Bridgit/4.6.206.0/Bridgit.exe


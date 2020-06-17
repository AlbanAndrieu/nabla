#!/bin/bash
set -xv

echo "Symantec Endpoint Protection : SAVFL"

chmod +x ./install.sh
sudo ./install.sh

cd /opt/Symantec/symantec_antivirus/
/opt/Symantec/symantec_antivirus/sav info -d
sudo /opt/Symantec/symantec_antivirus/sav info -s
/opt/Symantec/symantec_antivirus/sav info -p 
/opt/Symantec/symantec_antivirus/sav info -e
/opt/Symantec/symantec_antivirus/sav manage -p
/opt/Symantec/symantec_antivirus/sav manage -s
# sepm.finastra.global

/opt/Symantec/symantec_antivirus/sav info -a
#Malfunctioning

#connected to LiveUpdate and downloaded updates with
sudo /opt/Symantec/symantec_antivirus/sav liveupdate -u
sudo /etc/init.d/rtvscand restart

sudo bash ./sadiag.sh

#"C:\Program Files (x86)\Symantec\Symantec Endpoint Protection\DoScan" /ScanName "Weekly Scheduled Scan"
#"C:\Program Files (x86)\Symantec\Symantec Endpoint Protection\DoScan" /ScanName "Monday Night Scan"

#HKEY_LOCAL_MACHINE\SOFTWARE\WOW6432Node\Symantec\Symantec Endpoint Protection\AV\LocalScans\934f8e88-0ac7-0545-1f4a-7b6c06834e71\Schedule
#Name

# Check availability to virus definition portal https://sepm.finastra.global/secars/secars.dll?hello,secars

#sudo ./symcfg add -k '\Symantec Endpoint Protection\AV' -v NoFileMod -d 1 -t REG_DWORD

#See https://knowledge.broadcom.com/external/article?legacyId=TECH231013

# Stop 
# /etc/init.d/symcfgd stop
# /etc/init.d/smcd stop

#https://www.broadcom.com/support/security-center/definitions/download/detail?gid=sep#secTab3

#sudo apt-get install sharutils ncompress

#wget https://definitions.symantec.com/defs/20200405-002-core15unix.sh
#wget http://definitions.symantec.com/defs/static/symcdefs-unix64.sh

sudo /opt/Symantec/symantec_antivirus/sav scheduledscan -c albandri -f weekly -i Sat -t 23:00 -m 1 /
sudo /opt/Symantec/symantec_antivirus/sav scheduledscan --list

#sudo /opt/Symantec/symantec_antivirus/sav manualscan --scan /
sudo /opt/Symantec/symantec_antivirus/sav manualscan --clscan / &

#See https://knowledge.broadcom.com/external/article?legacyId=TECH132773

#For headless Ubuntu
#sudo dpkg --add-architecture i386 && sudo apt-get update

#Rebuild SEP kernel
#See for full info https://knowledge.broadcom.com/external/article?legacyId=TECH132773

sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-7 70 
sudo update-alternatives --install /usr/bin/g++ g++ /usr/bin/g++-7 70 
sudo update-alternatives --config gcc
sudo update-alternatives --config g++

#sudo apt-get install linux-headers-$(uname -r) build-essential
find . -name 'ap-kernelmodule*'

./build.sh --kernel-dir /lib/modules/$(uname -r)/build
cp ./bin.ira/* /opt/Symantec/autoprotect
sudo /etc/init.d/autoprotect restart
sudo /etc/init.d/rtvscand restart

dmesg | tail -n 2
#symev: can't get the address of filename_lookup function.

/opt/Symantec/symantec_antivirus/sav info -a

#sudo apt remove linux-image-unsigned-5.0.0-050000-generic linux-headers-5.0.0-050000-generic
sudo apt-get purge $(dpkg -l | awk '{print $2}' | grep -E "linux-(image|headers)-$(uname -r | cut -d- -f1).*" )
apt --fix-broken install

#/opt/Symantec/symantec_antivirus/savtray
#killall savtray
pkill savtray

sudo /etc/init.d/rtvscand stop
sudo /etc/init.d/symcfgd stop
sudo /etc/init.d/smcd stop

# https://community.broadcom.com/symantecenterprise/communities/community-home/librarydocuments/viewdocument?DocumentKey=277577ca-a0b1-4ae8-8002-36048d86d833&CommunityKey=1ecf5f55-9545-44d6-b0f4-4e4a7f5f5e68&tab=librarydocuments
/opt/Symantec/symantec_antivirus/unsupported/xsymcfg --help

ls -lrta /etc/symantec/sep

export PATH=$PATH:/opt/Symantec/symantec_antivirus/

/opt/Symantec/symantec_antivirus/symcfg -r list
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Storages\FileSystem\RealTimeScan' -v HaveExceptionDirs -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\LocalScans\ManualScan' -v HaveExceptionDirs -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Custom Tasks\albandri' -v HaveExceptionDirs -d 1 -t REG_DWORD

/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Storages\FileSystem\RealTimeScan\NoScanDir' -v /proc -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Storages\FileSystem\RealTimeScan\NoScanDir' -v /sys -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\LocalScans\ManualScan\NoScanDir' -v /proc -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\LocalScans\ManualScan\NoScanDir' -v /sys -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Custom Tasks\albandri\NoScanDir' -v /proc -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Custom Tasks\albandri\NoScanDir' -v /sys -d 1 -t REG_DWORD

/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Storages\FileSystem\RealTimeScan\NoScanDir' -v /kgr -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Storages\FileSystem\RealTimeScan\NoScanDir' -v /home -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\LocalScans\ManualScan\NoScanDir' -v /kgr -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\LocalScans\ManualScan\NoScanDir' -v /home -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Custom Tasks\albandri\NoScanDir' -v /kgr -d 1 -t REG_DWORD
/opt/Symantec/symantec_antivirus/symcfg add -k '\Symantec Endpoint Protection\AV\Custom Tasks\albandri\NoScanDir' -v /home -d 1 -t REG_DWORD

/opt/Symantec/symantec_antivirus/symcfg -r list | grep 'proc\|sys\|kgr\|home'

tail -f /var/symantec/sep/Logs/syslog.log
/opt/Symantec/symantec_antivirus/sav log -e
 
exit 0

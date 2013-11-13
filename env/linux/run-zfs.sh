#http://www.h-online.com/open/news/item/ZFS-on-Linux-is-ready-for-wide-scale-deployment-1832848.html

sudo add-apt-repository  http://ppa.launchpad.net/zfs-native/stable/ubuntu
sudo apt-get update
sudo apt-get install ubuntu-zfs
sudo apt-get install zfs-fuse

zpool upgrade -v

#https://github.com/zfsonlinux/pkg-zfs/wiki/HOWTO-install-Ubuntu-to-a-Native-ZFS-Root-Filesystem
sudo apt-add-repository --yes ppa:zfs-native/stable
sudo apt-get update
sudo apt-get install debootstrap ubuntu-zfs

dmesg | grep ZFS

ls -l /dev/disk/by-id/
#zpool create -f datastore raidz /dev/vdb /dev/vdc /dev/vdd
sudo zpool create -o ashift=9 rpool /dev/disk/by-id/ata-WDC_WD10EALX-759BA1_WD-WCATR7615786 -f
sudo zpool status rpool
sudo zpool create -o ashift=9 dpool /dev/disk/by-id/ata-WDC_WD10EALX-759BA1_WD-WCATR7624246 -f
sudo zpool status dpool

sudo zfs create -o mountpoint=/mnt/backup dpool/backup
sudo zfs create -o mountpoint=/mnt/jenkins dpool/jenkins

sudo zfs list

cd /
sudo ln -s /mnt/jenkins jenkins

export JENKINS_HOME=/jenkins
sudo apt-get install jenkins

#swap
swap -d /dev/zvol/dsk/rpool/swap
zfs destroy rpool/swap
zfs create -V300G -b4k rpool/swap
swap -a /dev/zvol/dsk/rpool/swap

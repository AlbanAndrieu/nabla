#!/bin/bash
set -xv

#http://synergy-foss.org/

apt-get remove synergy
apt-get --fix-broken install

sudo apt-get install qml-module-qtquick-controls qml-module-qtquick-layouts qml-module-qtquick-dialogs qml-module-qtquick2

wget http://archive.ubuntu.com/ubuntu/pool/main/o/openssl1.0/libssl1.0.0_1.0.2n-1ubuntu6_amd64.deb
sudo dpkg -i libssl1.0.0_1.0.2n-1ubuntu6_amd64.deb

wget http://fossfiles.com/synergy/synergy_2.0.12.beta_b1705+e5daaeda_amd64.deb
#See https://members.symless.com/forums/topic/5941-cant-install-synergy-2012/
dpkg-deb -R synergy_2.0.12.beta_b1705+e5daaeda_amd64.deb nameOfFolder
cd nameOfFolder
mv usr/lib/systemd/system/synergy.service usr/lib/systemd/system/synergy.service.dpkg-new
nano DEBIAN/control
#Remove libssl and qt stuff
dpkg-deb -b . synergy2.deb
sudo mkdir /var/www/html/synergy
sudo mv synergy2.deb /var/www/html/synergy
wget http://albandri/synergy/synergy2.deb
sudo dpkg --install synergy2.deb

#http://codedragon.tistory.com/attachment/cfile4.uf@276F684758A7D5DF2ACF9F.deb ???

ps -edf | grep synergy
killall synergy-service
killall synergy-coresynergy-service
killall synergy-config

tail -f /var/log/synergy/synergy-core.log

locate synergy.conf
nano /var/lib/synergy/synergy.conf
synergy-core --config /var/lib/synergy/synergy.conf
synergys --config /var/lib/synergy/synergy.conf

#nano /var/lib/synergy/synergy-user.cfg

sudo systemctl restart synergy

exit 0

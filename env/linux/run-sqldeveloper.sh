#http://askubuntu.com/questions/458554/how-to-install-sql-developer-on-ubuntu-14-04

sudo unzip sqldeveloper-*-no-jre.zip -d /opt/
sudo chmod +x /opt/sqldeveloper/sqldeveloper.sh

sudo ln -s /opt/sqldeveloper/sqldeveloper.sh /usr/local/bin/sqldeveloper

sudo nano /opt/sqldeveloper/sqldeveloper.sh

#!/bin/bash
unset -v GNOME_DESKTOP_SESSION_ID
cd /opt/sqldeveloper/sqldeveloper/bin
./sqldeveloper "$@"

sqldeveloper

cd /usr/share/applications/
sudo nano sqldeveloper.desktop

[Desktop Entry]
Exec=sqldeveloper
Terminal=false
StartupNotify=true
Categories=GNOME;Oracle;
Type=Application
Icon=/opt/sqldeveloper/icon.png
Name=Oracle SQL Developer

sudo update-desktop-database

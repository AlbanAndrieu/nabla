#!/bin/bash
set -xv

# See https://doc.ubuntu-fr.org/minidlna

sudo apt-get install minidlna

sudo nano /etc/minidlna.conf
media_dir=A,/media/music
media_dir=P,/media/photo
media_dir=V,/media/video

sudo ufw allow from 192.168.1.0/24 to any port 8200

sudo systemctl restart minidlna

exit 0

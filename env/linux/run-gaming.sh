#!/bin/bash
#set -xv

# See https://lutris.net/

# See https://github.com/lutris/docs/blob/master/HowToEsync.md
sudo nano /etc/systemd/system.conf
DefaultLimitNOFILE=1024:524288
sudo nano /etc/systemd/user.conf
DefaultLimitNOFILE=524288

ulimit -Hn

# See https://store.steampowered.com/

exit 0

#!/bin/bash
set -xv

sudo apt-get install nautilus-scripts-manager

cd ~/.local/share/nautilus/scripts/

wget https://www.linux-apps.com/p/1007563/startdownload?file_id=1460750169&file_name=105395-dot-tree.pl&file_type=text/x-perl&file_size=2362

#ls -lrta ~/.config/caja/scripts/ # Caja (Mate)
ls -lrta ~/.local/share/nautilus/scripts/ # Nautilus (Gnome/Unity)
#ls -lrta ~/.local/share/nemo/scripts/ # Némo (Cinnamon)

exit 0

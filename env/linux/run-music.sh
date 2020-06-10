#!/bin/bash
set -xv

sudo apt-get install rhythmbox-plugin-alternative-toolbar
sudo add-apt-repository ppa:fossfreedom/rhythmbox-plugins

# See https://wiki.gnome.org/Apps/Rhythmbox/Plugins/ThirdParty
sudo apt search rhythmbox

#sudo apt-get install rhythmbox-plugin-complete
sudo apt-get install rhythmbox-plugin-playlist-import-export
sudo apt-get install rhythmbox-plugin-llyrics rhythmbox-plugin-android-remote
sudo apt-get install rhythmbox-plugin-rating-filters rhythmbox-plugin-tray-icon

#sudo add-apt-repository ppa:musicbrainz-developers/daily
#sudo apt-get update
#sudo apt-get install rhythmbox-plugin-listenbrainz


exit 0

#!/bin/bash
set -xv

#http://doc.ubuntu-fr.org/rhythmbox
#edit and add radio
#~/.local/share/rhythmbox/rhythmdb.xml
#add new DAAP share
#home.nabla.mobi:3689

#NOK sudo apt-get install rhythmbox-radio-browser unity-lens-radios

#See https://doc.ubuntu-fr.org/liste_radio_france

#Rire et chansons
https://scdn.nrjaudio.fm/audio1/fr/30401/mp3_128.mp3?origine=ubuntu_website
https://scdn.nrjaudio.fm/adwz1/fr/30407/aac_64.mp3

less ./.local/share/rhythmbox/rhythmdb.xml

exit 0

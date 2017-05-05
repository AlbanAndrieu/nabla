#!/bin/bash
set -xv

#http://www.videolan.org/doc/vlc-user-guide/fr/ch07.html

#sudo apt-get install mozilla-plugin-vlc
#sudo apt-get install vlc browser-plugin-vlc

#https://www.mozilla.org/en-US/plugincheck/

vlc --open http://mafreebox.freebox.fr/freeboxtv/playlist.m3u

pip install -U yturl

#import
vlc "$(yturl 'https://www.youtube.com/watch?v=aKflhTrRh2k')"

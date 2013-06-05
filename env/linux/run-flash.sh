
-DflashPlayer.command=${flashplayer executable}
whereis flash
http://doc.ubuntu-fr.org/flashplayer#flashplayer_standalone
sudo apt-get install adobe-flashplugin

/usr/lib/adobe-flashplugin/libflashplayer.so to provide /usr/lib/mozilla/plugins/flashplugin-alternative.so (mozilla-flashplugin) in auto mode

apt-get autoremove -y --purge flashplugin-nonfree gnash gnash-common mozilla-plugin-gnash swfdec-mozilla libflashsupport
sudo rm -f /usr/lib/mozilla/plugins/*flash* ~/.mozilla/plugins/*flash* /usr/lib/firefox/plugins/*flash* /usr/lib/firefox-addons/plugins/*flash*
sudo rm -f  ~/.config/chromium/plugins/*flash* /usr/lib/chromium-browser/plugins/*flash* /usr/lib/opera/plugins
sudo apt-get install flashplugin-installer

https://docs.sonatype.org/display/FLEXMOJOS/Running+unit+tests
http://www.adobe.com/support/flashplayer/downloads.html#fp11
cd /dir-you-have-pmd
mvn clean install -DflashPlayer.command=/workspace/users/albandri10/env/linux/bin/flashplayer

#sudo apt-get install xvfb

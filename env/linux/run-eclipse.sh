
sudo chown -R albandri:albandri /eclipse-j2ee/

##http://www.comoke.com/index.php/2012/06/install-eclipse-in-launcher-ubuntu-12-04-unity/
gedit ~/.local/share/applications/opt_eclipse.desktop
#Add
[Desktop Entry]
Version=3.7
Name=Eclipse
GenericName=Text Editor

Exec=eclipse
Terminal=false
#Icon=/usr/lib/eclipse/icon.xpm
#** something like /opt/eclipse/icon.xpm **
Icon=/eclipse-j2ee/icon.xpm
Type=Application
Categories=IDE;Development
X-Ayatana-Desktop-Shortcuts=NewWindow

[NewWindow Shortcut Group]
Name=New Window
#Exec=eclipse -n
# ** something like /opt/eclipse/eclipse **
Exec=/eclipse-j2ee/eclipse
TargetEnvironment=Unity

#Or
gnome-desktop-item-edit --create-new ~/Desktop

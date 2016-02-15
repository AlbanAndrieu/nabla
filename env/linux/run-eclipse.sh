
#deprecated
#mvn eclipse:eclipse -DdownloadSources=true -DdowlonloadJavadocs=true -Dmaven.test.skip=true

sudo chown -R albandri:albandri /eclipse-j2ee/

##http://www.comoke.com/index.php/2012/06/install-eclipse-in-launcher-ubuntu-12-04-unity/
gedit ~/.local/share/applications/eclipse.desktop
#Add
[Desktop Entry]
Encoding=UTF-8
Version=4
Name=Eclipse 4
GenericName=Text Editor

Exec=/usr/local/eclipse/eclipse-4/eclipse
Terminal=false
#Icon=/usr/lib/eclipse/icon.xpm
#** something like /opt/eclipse/icon.xpm **
Icon=/usr/local/eclipse/eclipse-4/icon.xpm
Type=Application
Categories=IDE;Development
Comment=Integrated Development Environment
NoDisplay=false
StartupNotify=false
StartupWMClass=Eclipse
OnlyShowIn=Unity;
X-UnityGenerated=true

X-Ayatana-Desktop-Shortcuts=NewWindow

[NewWindow Shortcut Group]
Name=New Window
#Exec=eclipse -n
# ** something like /opt/eclipse/eclipse **
Exec=/usr/local/eclipse/eclipse-4/eclipse
TargetEnvironment=Unity

#Update dash configuration
sudo update-desktop-database

#Or
gnome-desktop-item-edit --create-new ~/Desktop

#BUG for eclipse bundled with ubuntu
#http://stackoverflow.com/questions/10165693/eclipse-cannot-load-swt-libraries
#sudo apt-get install libswt-gtk-3-jni libswt-gtk-3-java
#ln -s /usr/lib/jni/libswt-* ~/.swt/lib/linux/x86/
sudo ln -s /usr/lib/jni/libswt-* ~/.swt/lib/linux/x86_64/

#Groovy plugin
#http://dist.springsource.org/release/GRECLIPSE/e4.3/

#Java 8 patches
#Install new software
2. Java8 Support: http://download.eclipse.org/eclipse/updates/4.3-P-builds/
3. Java 8 Facets: http://download.eclipse.org/webtools/patches/drops/R3.5.2/P-3.5.2-20140329045715/repository
4. New m2e milestone: http://download.eclipse.org/technology/m2e/milestones/1.5  (https://bugs.eclipse.org/bugs/show_bug.cgi?id=420848)

#http://stackoverflow.com/questions/14791843/eclipse-add-tomcat-7-blank-server-name
cd /usr/local/eclipse/eclipse-luna-workspace-visma/.metadata/.plugins/org.eclipse.core.runtime/.settings
rm -Rf org.eclipse.wst.server.core.prefs org.eclipse.jst.server.tomcat.core.prefs

cd /usr/share/tomcat7
sudo service tomcat7 stop
sudo update-rc.d tomcat7 disable
sudo ln -s /var/lib/tomcat7/conf conf
sudo ln -s /etc/tomcat7/policy.d/03catalina.policy conf/catalina.policy
sudo ln -s /var/log/tomcat7 log
sudo chmod -R 777 /usr/share/tomcat7/conf
sudo ln -s /var/lib/tomcat7/common common
sudo ln -s /var/lib/tomcat7/server server
sudo ln -s /var/lib/tomcat7/shared shared

#http://gridlab.dimes.unical.it/lackovic/eclipse-tomcat-ubuntu-jersey/

#Add maven overlay connector
#http://stackoverflow.com/questions/8491308/how-to-handle-maven-war-overlays-in-eclipse
#https://dzone.com/articles/mavens-war-overlay-what-are

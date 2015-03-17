#http://doc.ubuntu-fr.org/gedit

#Block commenting in Gedit
#http://stackoverflow.com/questions/7649626/block-commenting-in-gedit\
#1.Install gedit plugins
#2.Go to Edit->Preference->Plugins-> and enable Code Comment
#3.Ctl+m to comment block of codes
#4.Ctl+Shift+m to uncomment block of codes2.Go to Edit->Preference->Plugins-> and enable Code Comment
#3.Ctl+m to comment block of codes
#4.Ctl+Shift+m to uncomment block of codes


#https://codetree.com.au/projects/imitation/
cd /workspace
mkdir imitation-1.3
cd imitation-1.3
wget https://codetree.com.au/static/content/imitation/releases/imitation-1.3.tar.gz
tar -xvf imitation-1.3.tar.gz
cd imitation
sudo cp ../org.gnome.gedit.plugins.imitation.gschema.xml /usr/share/glib-2.0/schemas/
sudo glib-compile-schemas /usr/share/glib-2.0/schemas
cd ..
sudo cp -r imitation/ /usr/lib/gedit/plugins/
sudo cp imitation.plugin /usr/lib/gedit/plugins/
#Once installed, you need to activate imitation plug-in. For this, open gedit window, go to edit->preferences->plugins and activate it from there.

#Usage sample Ctrl+PageDn
#http://mylinuxbook.com/imitation-a-gedit-plugin-to-edit-a-document-at-multiple-places/http://mylinuxbook.com/imitation-a-gedit-plugin-to-edit-a-document-at-multiple-places/

#https://github.com/jessevdk/gedit-multi-edit

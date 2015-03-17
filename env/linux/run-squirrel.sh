#http://www.squirrelsql.org/#installation
cd ~/Downloads/
wget --output-document squirrel-sql-3.6-standard.jar http://downloads.sourceforge.net/project/squirrel-sql/1-stable/3.6.0/squirrel-sql-3.6-standard.jar?r=http%3A%2F%2Fwww.squirrelsql.org%2F&ts=1424876345&use_mirror=heanet
sudo chmod 755 squirrel-sql-3.6-standard.jar
java -jar ~/Downloads​/squirrel-sql-3.6-standard.jar -f ~/env/ansible-nabla/roles/alban.andrieu.squirrel/templates​/install.xml.j2

#!/bin/bash

#http://www.howtoforge.com/how-to-monitor-hard-drive-usage-in-ubuntu-server-using-the-visual-philesight-cgi-script
#grant db sudo chmod 777 /usr/lib/philesightdb
#edit /usr/lib/cgi-bin/philesight.cgi
#check result in : http://your_server_name/cgi-bin/philesight.cgi

#see /var/www /usr/bin/philesightdb /usr/lib/philesightdb
echo "Starting scan at" `date`;
#su -m tomcat6 -c rm /usr/lib/philesightdb
rm /usr/lib/philesightdb
/usr/bin/philesight  --db /usr/lib/philesightdb --index /
#/usr/bin/philesight  --db /usr/lib/nabla-workspace --index /workspace --draw workspace.png
#/usr/bin/philesight  --db /usr/lib/nabla-jenkins-repo --index /usr/share/tomcat6/.m2/repository --draw jenkins-repo.png
#for p in "workspace" "target" "jenkins" "log"; do
#	echo "== $p starting" `date`
#	/usr/bin/philesight  --db nabla.$p --index /$p/
#done
echo "Scan finished at " `date`;


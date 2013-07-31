#!/bin/bash

#http://www.howtoforge.com/how-to-monitor-hard-drive-usage-in-ubuntu-server-using-the-visual-philesight-cgi-script
#grant db sudo chmod 777 /usr/lib/philesightdb
#edit /usr/lib/cgi-bin/philesight.cgi
#check result in : http://your_server_name/cgi-bin/philesight.cgi

cd /workspace/philesight

#see /var/www /usr/bin/philesightdb /usr/lib/philesightdb
echo "Starting scan at" `date`;
#su -m tomcat6 -c rm /usr/lib/philesightdb
#rm /usr/lib/philesight.db
rm /workspace/philesight/philesight.db
#/usr/bin/ruby1.8 /usr/bin/philesight  --db /usr/lib/philesight.db --index / || exit 1
/usr/bin/ruby1.8 /usr/bin/philesight  --db /workspace/philesight/philesight.db --index / || exit 1
#/usr/bin/philesight  --db /usr/lib/nabla-workspace --index /workspace --draw workspace.png
#/usr/bin/philesight  --db /usr/lib/nabla-jenkins-repo --index /usr/share/tomcat6/.m2/repository --draw jenkins-repo.png
#for p in "workspace" "target" "jenkins" "log"; do
#	echo "== $p starting" `date`
#	/usr/bin/philesight  --db nabla.$p --index /$p/
#done
echo "Scan finished at " `date`;

echo "Check server output with : tail -f /var/log/apache2/error.log"
echo "Check result in : http://home.nabla.mobi/cgi-bin/philesight.cgi"

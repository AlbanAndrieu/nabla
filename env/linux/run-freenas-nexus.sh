
#nexus
http://home.nabla.mobi:8085/nexus/
http://192.168.0.24:8081/nexus

pkg install nexus2-oss
======================================================================
Message from nexus2-oss-2.14.0:
========================================================================
Nexus Repository Manager OSS 2.14.0 has been successfully installed!

To enable Nexus, add the following line to /etc/rc.conf[.local]:

  nexus2_enable="YES"

IMPORTANT: Nexus runs by default as user nexus!

Configuration
=============
* Start Nexus 'service nexus2 start'
* Open the following URL in your browser: http://localhost:8081/nexus
* Log in with the admin account 'admin/admin123', configure Nexus and
  change this password immediately!

Common Locations
================
The configuration files can be found at:
  /usr/local/etc/nexus2

The work, log, and run directories are located at:
* /var/nexus2
* /var/log/nexus2
* /var/run/nexus2

Documentation
=============
Further documentation can be found in the official Nexus Book at:
  http://books.sonatype.com/nexus-book/2.14/reference/index.html

echo 'nexus2_enable="YES"' >> /etc/rc.conf
service nexus2 start
http://192.168.0.24:8081/nexus
http://home.nabla.mobi:8085/nexus/
OLD NEXUS is http://home.nabla.mobi:8084/nexus

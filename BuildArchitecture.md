#Build architecture.

# Introduction #

Architecture overview.
![http://home.nabla.mobi/nabla/nabla-build-architecture.jpg](http://home.nabla.mobi/nabla/nabla-build-architecture.jpg)

# Build #

Continuous integration:
  * High availibility [Jenkins](https://home.nabla.mobi/jenkins/) with a load balancer and a ssh tunneling (apache), a reverse proxy and a fail over (varnish) to another Jenkins backup server. Data are replicated using rsync or using zfs send/receive.
  * Sonatype [Nexus](http://home.nabla.mobi:8081/nexus/index.html#welcome) as a central artifacts cache and repo with TCM (not free) as artifacts and security monitoring.  Data are replicated using rsync or using zfs send/receive
  * Build farm on AWS with EC2 (not free for normal usage and security) for scalability
  * [Sonar](http://home.nabla.mobi:9000/) as code analyses tool. Data on a clustered and replicated mySQL [HA mySQL](http://dev.mysql.com/doc/refman/5.0/en/ha-overview.html)
  * ALM Atlassian tools JIRA / Conluence / Crucible / FishEye. Data on a clustered and replicated mySQL [HA JIRA](https://confluence.atlassian.com/display/ATLAS/Failover+for+JIRA).
  * All Authentifaction (Jenkins, Sonar, Nexus, ALM) with atlassian Crowd connected to LDAP
  * Infrastructure monitoring through Xabbix or Nagios or Ncinga, Webmin, [MON](https://home.nabla.mobi/cgi-bin/mon.cgi), [AWStats](https://www.home.nabla.mobi/cgi-bin/awstats.pl?config=home.nabla.mobi), [Philesight](https://home.nabla.mobi/cgi-bin/philesight.cgi), [Usermin](https://home.nabla.mobi:20000/), [Webmin](https://home.nabla.mobi:10000/), [PhpMyAdmin](https://home.nabla.mobi/phpmyadmin/), [PhpLdapAdmin](https://home.nabla.mobi/phpldapadmin/), [Ftp](ftp://home.nabla.mobi:8021/)
  * Document sharing using [Owncloud](https://home.nabla.mobi/owncloud) connected to GoogleDrive and DropBox and NAS ZFS catalog

TODO test : Nginx instead apache, [HAProxy](http://haproxy.1wt.eu/) instead [Varnish](https://www.varnish-cache.org/docs/3.0/tutorial/advanced_backend_servers.html#health-checks), add [Sonargraph](http://docs.codehaus.org/display/SONAR/Sonargraph+Plugin) to Sonar
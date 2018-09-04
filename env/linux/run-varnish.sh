#!/bin/bash
set -xv

#https://www.varnish-cache.org/docs/3.0/tutorial/advanced_backend_servers.html#health-checks
sudo apt-get install varnish

sudo service varnish status

#https://www.digitalocean.com/community/articles/how-to-install-and-configure-varnish-with-apache-on-ubuntu-12-04--3
#sudo nano /etc/default/varnish
#sudo nano /etc/varnish/varnish.params
nano /lib/systemd/system/varnish.service

#DAEMON_OPTS="-a :80
#-a :80 -a :6081,PROXY
DAEMON_OPTS="-a :80 \
             -T :6082 \
             -f /etc/varnish/default.vcl \
             -S /etc/varnish/secret \
             -s malloc,256m"

#               -T localhost:6082 \
#               -f /etc/varnish/default.vcl \
#               -p thread_pools=4 \
#               -p thread_pool_max=1500 \
#               -p listen_depth=2048 \
#               -p lru_interval=1800 \
#               -h classic,169313 \
#               -p connect_timeout=600 \
#               -s malloc,2G"

#/usr/sbin/varnishd -a :80 -T localhost:6082 -f /etc/varnish/default.vcl -S /etc/varnish/secret -s malloc,256m

sudo nano /etc/varnish/default.vcl

vcl 4.0;

import directors;    # load the directors

# This is a basic VCL configuration file for varnish.  See the vcl(7)
# man page for details on VCL syntax and semantics.
#
# Default backend definition.  Set this to point to your content
# server.
#
backend default {
    .host = "127.0.0.1";
    .port = "8080";
}

backend apache1 {
    .host = "10.21.188.115";
#    .port = "80";
    .probe = {
         .url = "/";
         .timeout = 1s;
         .interval = 5s;
         .window = 5;
         .threshold = 3;
    }
}

backend apache2 {
    .host = "10.21.188.114";
#    .port = "80";
    .probe = {
         .url = "/";
         .timeout = 1s;
         .interval = 5s;
         .window = 5;
         .threshold = 3;
    }
}

backend jboss {
    .host = "127.0.0.1";
    .port = "8180";
    .probe = {
         .url = "/";
         .interval = 5s;
         .timeout = 1s;
#         .connect_timeout = 600s;
#         .first_byte_timeout = 600s;
#         .between_bytes_timeout = 600s;
#         .window = 5;
         .threshold = 3;
    }
}

backend jboss_console {
    .host = "127.0.0.1";
    .port = "9990";
    .probe = {
         .url = "/console";
         .interval = 5s;
         .timeout = 1s;
#         .connect_timeout = 600s;
#         .first_byte_timeout = 600s;
#         .between_bytes_timeout = 600s;
#         .window = 5;
         .threshold = 3;
    }
}

# Define the list of backends (web servers).
# Port 80 Backend Servers
##backend web1 { .host = "127.0.0.1"; .port = "8380"; .probe = { .url = "/jenkins/?"; .interval = 5s; .timeout = 1s; .window = 5;.threshold = 3; }}
#backend web1 { .host = "127.0.0.1"; .port = "7070"; .probe = { .url = "/"; .interval = 5s; .timeout = 1s; .window = 5;.threshold = 3; }}
#backend web2 { .host = "192.168.0.8"; .port = "8080"; .probe = { .url = "/"; .interval = 5s; .timeout = 1s; .window = 5;.threshold = 3; }}
##sick backend web2 { .host = "192.168.0.46"; .port = "80"; .probe = { .url = "/"; .interval = 5s; .timeout = 1s; .window = 5;.threshold = 3; }}

# Port 443 Backend Servers for SSL
#backend web1_ssl { .host = "82.231.208.223"; .port = "443"; .probe = { .url = "/jenkins/?"; .interval = 5s; .timeout = 1 s; .window = 5;.threshold = 3; }}
#backend web2_ssl { .host = "127.0.0.1"; .port = "443"; .probe = { .url = "/jenkins/?"; .interval = 5s; .timeout = 1 s; .window = 5;.threshold = 3; }}

# Define the director that determines how to distribute incoming requests.
#director default_director round-robin {
#  { .backend = web1; }
#  { .backend = web2; }
#}
#director ssl_director round-robin {
#  { .backend = web1_ssl; }
#  { .backend = web2_ssl; }
#}

#See https://varnish-cache.org/docs/4.1/users-guide/vcl-backends.html
sub vcl_init {
    new apache = directors.round_robin();
    apache.add_backend(apache1);
    apache.add_backend(apache2);
}

sub vcl_recv {
  if (req.http.host == "fr1cslfrbm0059.misys.global.ad" || req.http.host == "www.fr1cslfrbm0059.misys.global.ad") {
      set req.backend_hint = apache1;
  }
  elseif (req.http.host == "fr1cslfrbm0060.misys.global.ad" || req.http.host == "www.fr1cslfrbm0060.misys.global.ad") {
      set req.backend_hint = apache2;
  }

  if (req.url ~ "^/jenkins/") {
    set req.backend = default_director;
  }

  if (req.url ~ "^/console/") {
    set req.backend = jboss_console;
  }

  if (req.url ~ "^/jboss/") {
    set req.backend = jboss;
  }
  # Set the director to cycle between web servers.
  #if (server.port == 443) {
  #  set req.backend = default_director;
  #}
  #else {
  #   set req.backend = default;
  #}
# send all traffic to the apache director:
  set req.backend_hint = apache.backend();
}

#sub vcl_fetch {
#  if (req.url ~ "^/jenkins/") {
#    set beresp.ttl = 5d;
#  }
#}

#now varnish will forward to apache on port 8080

sudo nano /etc/apache2/ports.conf
# If you just change the port or add more ports here, you will likely also
# have to change the VirtualHost statement in
# /etc/apache2/sites-enabled/000-default

Listen 127.0.0.1:8080
#NameVirtualHost 127.0.0.1:8080
#Listen 80

<IfModule ssl_module>
        Listen 443
</IfModule>

<IfModule mod_gnutls.c>
        Listen 443
</IfModule>

# vim: syntax=apache ts=4 sw=4 sts=4 sr noet


#vanish at http://albandri.local:80
#apache is at http://albandri.local:8080
#jenkins is at http://localhost:8380/jenkins
#http://82.231.208.223:8080/
192.168.0.29
https://albandri.local/jenkins

cat /etc/init.d/varnish
cat /etc/default/varnish

#log
varnishlog
varnishstat
varnishtop

lsof -i :80

sudo service varnish stop
sudo service apache2 start
#sudo service varnish start
sudo service varnish restart

#https://www.varnish-cache.org/docs/3.0/tutorial/advanced_backend_servers.html#health-checks
sudo apt-get install varnish

sudo service varnish status
 
#log
varnishlog 

#https://www.digitalocean.com/community/articles/how-to-install-and-configure-varnish-with-apache-on-ubuntu-12-04--3
sudo nano /etc/default/varnish

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
# Define the list of backends (web servers).
# Port 80 Backend Servers
backend web1 { .host = "127.0.0.1"; .port = "8080"; .probe = { .url = "/"; .interval = 5s; .timeout = 1s; .window = 5;.threshold = 3; }}
#backend web2 { .host = "127.0.0.1"; .probe = { .url = "/status.php"; .interval = 5s; .timeout = 1s; .window = 5;.threshold = 3; }}

# Port 443 Backend Servers for SSL
backend web1_ssl { .host = "127.0.0.1"; .port = "443"; .probe = { .url = "/"; .interval = 5s; .timeout = 1 s; .window = 5;.threshold = 3; }}
#backend web2_ssl { .host = "127.0.0.1"; .port = "443"; .probe = { .url = "/status.php"; .interval = 5s; .timeout = 1 s; .window = 5;.threshold = 3; }}

# Define the director that determines how to distribute incoming requests.
director default_director round-robin {
  { .backend = web1; }
#  { .backend = web2; }
}

director ssl_director round-robin {
  { .backend = web1_ssl; }
#  { .backend = web2_ssl; }
}
sub vcl_recv {
  #if (req.url ~ "^/jenkins/") {
  #  set req.backend = jenkins_backup;
  #} else {
  #  set req.backend = default;
  #}
  # Set the director to cycle between web servers.
  if (server.port == 443) {
    set req.backend = ssl_director;
  }
  else {
   set req.backend = default_director;
  }
}

#now varnish will forward to apache on port 8080

DAEMON_OPTS="-a :80,:443 \
             -T localhost:6082 \
             -f /etc/varnish/default.vcl \
             -S /etc/varnish/secret \
             -s malloc,256m"

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
https://albandri.local/jenkins

cat /etc/init.d/varnish
cat /etc/default/varnish

varnishstat

sudo service varnish stop
sudo service apache2 start
sudo service varnish start

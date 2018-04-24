#!/bin/bash
set -xv

sudo apt-get install php7.0 php7.0-mysql php7.0-cgi php7.0-cli

#Reset the default PHP back to PHP5 (optional)
#update-alternatives --set php /usr/bin/php5

exit 0

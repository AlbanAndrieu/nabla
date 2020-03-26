#!/bin/bash
set -xv

php -v

sudo apt-get install php7.3 php7.3-mysql php7.3-cgi php7.3-cli

#Reset the default PHP back to PHP5 (optional)
#update-alternatives --set php /usr/bin/php5

exit 0

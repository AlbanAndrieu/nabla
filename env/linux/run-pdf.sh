#!/bin/bash
set -xv

# See https://doc.ubuntu-fr.org/imagemagick
#sudo sed -i 's/rights="none" pattern="PDF"/rights="read | write" pattern="PDF"/' /etc/ImageMagick-6/policy.xml
#sudo sed -i 's/rights="none" pattern="EPS"/rights="read | write" pattern="EPS"/' /etc/ImageMagick-6/policy.xml
#sudo sed -i 's/rights="none" pattern="XPS"/rights="read | write" pattern="XPS"/' /etc/ImageMagick-6/policy.xml
#sudo sed -i 's/rights="none" pattern="PS"/rights="read | write" pattern="PS"/' /etc/ImageMagick-6/policy.xml
#Change memory to 2 Gb
#  <!--<policy domain="resource" name="memory" value="256MiB"/>-->
#  <policy domain="resource" name="memory" value="2GiB"/>

#convert *.jpg document.pdf
convert -compress jpeg images_*.png document.pdf

# See https://doc.ubuntu-fr.org/pdftk
#sudo apt-get install pdftk
#pdftk 1.pdf 2.pdf 3.pdf cat output 123.pdf

exit 0

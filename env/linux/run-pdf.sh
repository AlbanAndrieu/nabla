#!/bin/bash
set -xv

# See https://doc.ubuntu-fr.org/imagemagick

# Fix bug https://github.com/ImageMagick/ImageMagick/issues/396
#sudo sed -i 's/rights="none" pattern="PDF"/rights="read | write" pattern="PDF"/' /etc/ImageMagick-6/policy.xml
#sudo sed -i 's/rights="none" pattern="EPS"/rights="read | write" pattern="EPS"/' /etc/ImageMagick-6/policy.xml
#sudo sed -i 's/rights="none" pattern="XPS"/rights="read | write" pattern="XPS"/' /etc/ImageMagick-6/policy.xml
#sudo sed -i 's/rights="none" pattern="PS"/rights="read | write" pattern="PS"/' /etc/ImageMagick-6/policy.xml
# Fix memory bug to 2 Gb
# https://doc.ubuntu-fr.org/imagemagick#j_obtiens_une_erreur_de_cache
#sudo sed -i 's/name="memory" value="256MiB"/name="memory" value="3GiB"/' /etc/ImageMagick-6/policy.xml
#sudo sed -i 's/name="disk" value="1GiB"/name="disk" value="2GiB"/' /etc/ImageMagick-6/policy.xml

#convert *.jpg document.pdf
convert -compress jpeg images_*.png document.pdf

# See https://doc.ubuntu-fr.org/pdftk
#sudo apt-get install pdftk
#pdftk 1.pdf 2.pdf 3.pdf cat output 123.pdf

# Compress pdf
convert -density 200x200 -quality 60 -compress jpeg input.pdf output.pdf

# Sign document
# See https://www.howtogeek.com/164668/how-to-electronically-sign-documents-without-printing-and-scanning-them/

sudo apt install xournal

# See https://www.hellosign.com/ to sign using internet

# Merge pdf
sudo snap install pdftk
pdftk file1.pdf file2.pdf cat output mergedfile.pdf

#sudo apt-get install pdfshuffler
sudo apt-get install pdfarranger

exit 0

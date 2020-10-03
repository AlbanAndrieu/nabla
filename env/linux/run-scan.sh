#!/bin/bash
set -xv

#./run-printer-epson.sh

sudo apt-get install simple-scan

simple-scan
# works with Epson NX100

sudo apt-get install xsane

xsane

#less /etc/sane.d/epkowa.conf
#sudo /etc/init.d/saned restart

# Best result with tesseract

wget https://doc.ubuntu-fr.org/_export/code/xsane2tess?codeblock=0
sudo cp ~/Downloads/xsane2tess /usr/bin/
# See https://doc.ubuntu-fr.org/xsane2tess
sudo chmod +x /usr/bin/xsane2tess

# See printing.yml

# OCR command
# xsane2tess -l nor

ll ~/.sane/xsane/Epson:NX100-OCR-TESSERACT.drc

exit 0

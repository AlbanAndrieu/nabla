#!/bin/bash
displayNum=$1
if [ "$displayNum" = "" ]; then
  displayNum="2"
fi
vncserver :$displayNum -geometry 1920x1200 -depth 24

echo "`hostname`:$displayNum" > currentDisplay.txt

echo "For copy/paste launch"
echo "/usr/bin/vncconfig"

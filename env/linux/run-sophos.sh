#!/bin/bash
set -xv

#http://www.bleepingcomputer.com/forums/t/578679/sophos-antivirus-for-linux/
savscan -h
sudo /opt/sophos-av/bin/savlog --today

sudo /opt/sophos-av/bin/savdstatus

sudo /opt/sophos-av/bin/savdctl enable
sudo /opt/sophos-av/bin/savdctl disable

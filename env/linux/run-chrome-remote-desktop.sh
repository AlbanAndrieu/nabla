#!/bin/bash
set -xv

#See https://medium.com/@vsimon/how-to-install-chrome-remote-desktop-on-ubuntu-18-04-52d99980d83e
sudo usermod -a -G chrome-remote-desktop $USER
/opt/google/chrome-remote-desktop/chrome-remote-desktop --stop
/opt/google/chrome-remote-desktop/chrome-remote-desktop --start

less  ~/.chrome-remote-desktop-session

exit 0

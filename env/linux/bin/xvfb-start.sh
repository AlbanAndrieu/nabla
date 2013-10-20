#!/bin/bash
echo "Starting Xvfb on the port :99"

/usr/bin/Xvfb :99 -ac -screen 0 1024x768x8 &


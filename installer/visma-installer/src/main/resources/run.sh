#!/bin/bash

if [ -z "$1" ]; then
  echo "`basename $0` {start|stop}"
  exit
fi

case "$1" in
start)
  echo "Go to http://localhost:9090/"
  java -jar bin/jetty-runner.jar --port 9090 bin/*.war &> output.log
;;
#stop)
#  killall jetty-runner
#;;
esac



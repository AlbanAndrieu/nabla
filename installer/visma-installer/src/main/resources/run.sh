#!/bin/bash

if [ -z "$1" ]; then
  echo "`basename $0` {start|stop}"
  exit
fi

case "$1" in
start)
  java -jar bin/jetty-runner.jar --port 9090 bin/*.war &> output.log
  echo "Go to http://localhost:9090/"
;;
#stop)
#  killall jetty-runner
#;;
esac


